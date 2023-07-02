package com.exam.chatting.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.chatting.board.dto.BoardResponseDto;
import com.exam.chatting.paging.CommonParams;

@Mapper //MyBatis는 @Mapper가 선언된 인터페이스와 연결된 XML Mapper에서 메서드명과 동일한 SQL을 찾아 쿼리를 실행합니다.
public interface BoardMapper {

    //게시글 조회
    int count(final CommonParams params);

    //게시글 리스트 조회
    List<BoardResponseDto> findAll(final CommonParams params);

}
 
