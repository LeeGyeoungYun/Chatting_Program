package com.exam.chatting.board.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.chatting.board.dto.BoardRequestDto;
import com.exam.chatting.board.dto.BoardResponseDto;
import com.exam.chatting.board.entity.Board;
import com.exam.chatting.board.entity.BoardRepository;
import com.exam.chatting.exception.CustomException;
import com.exam.chatting.exception.ErrorCode;
import com.exam.chatting.paging.CommonParams;
import com.exam.chatting.paging.Pagination;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //@RequiredArgsConstructor은 롬복에서 제공하는 어노테이션으로, 클래스내의 final로 선언된 모든 멤버에 대한 생성자를 만들어줍니다.
public class BoardService {
	
	//보통 @Autowired로 빈(Bean)을 주입받는 방식을 사용했는데 스프링은 생성자로 빈을 주입하는 방식을 권장한다고 함.
    private final BoardRepository boardRepository; //JPA Repository 인터페이스
    private final BoardMapper boardMapper;
   
    // 게시글 생성  
    @Transactional
    public Long save(final BoardRequestDto params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    // 게시글 리스트 조회   
    public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn)  {
    	
    	//sort 객체는 ORDER BY id DESC, created_date DESC를 의미합니다.
        Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAllByDeleteYn(deleteYn, sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    
    // 게시글 수정 
    @Transactional
    public Long update(final Long id, final BoardRequestDto params) { //트랜잭션(Transaction)이 종료(commit)되는 시점에 update 쿼리를 실행
    	
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
    }
    
    // 게시글 삭제
    @Transactional
    public Long delete(final Long id) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }
    
    // 게시글 상세조회 기능
    @Transactional
    public BoardResponseDto findById(final Long id) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.increaseHits();
        return new BoardResponseDto(entity);
    }
    
    
    // 게시글 리스트 조회 - (With. pagination information)    
    public Map<String, Object> findAll(CommonParams params) {

        // 게시글 수 조회
        int count = boardMapper.count(params);

        // 등록된 게시글이 없는 경우, 로직 종료
        if (count < 1) {
            return Collections.emptyMap();
        }

        // 페이지네이션 정보 계산
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 게시글 리스트 조회
        List<BoardResponseDto> list = boardMapper.findAll(params);

        // 데이터 반환
        Map<String, Object> response = new HashMap<>();
        response.put("params", params);
        response.put("list", list);
        return response;
    }

}
