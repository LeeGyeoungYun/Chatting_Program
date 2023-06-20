package com.exam.chatting.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;

//해당 레파지토리 인터페이스는 MyBatis의 SQL Mapper와 유사한 퍼시스턴스 영역에 사용되는 인터페이스로 MyBatis의 Mapper를 JPA에서는 Repository라고 부릅니다.
//주의사항은 엔티티(Entity) 클래스와 레파지토리(Repository) 인터페이스는 같은 패키지에 위치해 있어야만 합니다.
public interface BoardRepository extends JpaRepository<Board, Long> {

	//extends JpaRepository<Board,Long> 은 레파지토리 인터페이스에서 JpaRepository 인터페이스를 상속받을 때
	//엔티티 클래스의 타입(Board)와 PK에 해당하는 데이터 타입(Long)을 선언하면 해당 엔티티 클래스와 매핑되는 테이블인 board 테이블의 CRUD기능을 사용할 수 있습니다.


}
