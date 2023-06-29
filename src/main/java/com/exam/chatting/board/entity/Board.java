package com.exam.chatting.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * @Getter 은 해당 클래스에 포함된 멤버변수의 모든 getter 메서드를 생성해주는 lombok의 강력한 기능입니다.
 * 
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)은 해당 클래스의 기본 생성자를 생성해주는 어노테이션입니다.
 * 	access속성을 이용해서 동일한 패키지내의 클래스에서만 객체를 생성할 수 있도록 제어합니다.
 * 	
 *	@Entity는 해당 클래스가 테이블과 매핑되는 JPA의 엔티티(Entity) 클래스임을 의미합니다.
 *   기본적으로 클래스명을 테이블명으로 매핑합니다. 예를들어 user_role이라는 테이블은 UserRole이라는 이름의 클래스로 네이밍 하면되고, 
 *   혹시라도 클래스명과 테이블명이 다를 수 밖에 없는 상황에서는 클래스 레벨에 @Table을 선언하고, @Table(name ="user_role") 과 같이 
 *   name 속성을 이용해서 처리해 주면 됩니다.
 *   
 * */

@Getter   
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    @Builder
    public Board(String title, String content, String writer, int hits, char deleteYn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }
    
    //Entity 클래스에 게시물 수정 기능 -> update()메소드 생성
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }
    
    //게시물 조회수 증가 기능
    public void increaseHits() {
        this.hits++;
    }

    //게시물 삭제 기능
    public void delete() {
        this.deleteYn = 'Y';
    }

}