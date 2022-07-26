package com.suapapa.springbootweb.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA 에선 Repository라고 부르며 인터페이스로 생성. 인터페이스 생성후 JpaRepository<Entity 클래스,PK 타입>를 상속하면
// 기본적인 CRUD 메소드가 자동으로 생성 된다.
public interface PostRepository extends JpaRepository<Posts,Long> {
}
