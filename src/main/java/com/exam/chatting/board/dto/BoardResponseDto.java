package com.exam.chatting.board.dto;

import java.time.LocalDateTime;

import com.exam.chatting.board.entity.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto { //게시판 응답(Response) DTO 클래스

    private Long id; // PK
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private int hits; // 조회 수
    private char deleteYn; // 삭제 여부
    private LocalDateTime createdDate; // 생성일
    private LocalDateTime modifiedDate; // 수정일

    
    //응답(Response)도 Entity클래스가 사용되어서는 안되기 때문에 클래스를 분리해야만 합니다.
    //응답 객체 생성은 필수적으로 Entity클래스를 필요로합니다.
    
    
    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.hits = entity.getHits();
        this.deleteYn = entity.getDeleteYn();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }

}
