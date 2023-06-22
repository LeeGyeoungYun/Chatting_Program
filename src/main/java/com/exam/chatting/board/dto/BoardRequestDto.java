package com.exam.chatting.board.dto;

import com.exam.chatting.board.entity.Board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto { // 게시판 요청(Request) DTO 클래스

	private String title; //제목
	private String content; //내용
	private String writer; //작성자
	private char deleteYn; //삭제여부
	
	
	//Board 클래스에 정의한 Entity는  테이블(Table) 또는 레코드 (Record) 역할을 하는 데이터베이스 그자체로 생각할 수 있고
	//절대로 요청(Request)나 응답(Response)에 사용되어서는 안되기 때문에 반드시 Request,Response 클래스를 따로 생성(구분)해 주어야 합니다.
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.writer(writer)
				.hits(0)
				.deleteYn(deleteYn)
				.build();
	}
}
