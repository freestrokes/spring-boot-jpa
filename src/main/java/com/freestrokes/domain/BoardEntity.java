package com.freestrokes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "board")
@Entity
public class BoardEntity {

    // TODO: id 필드에 sequence 적용하려는 경우엔 아래와 같이 사용.
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "board_id", unique = true, nullable = false)
//    private Long boardId;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "board_id", length = 100, unique = true, nullable = false)
    private String boardId;

    // TODO: 양방향 연관관계에서 발생하는 Infinite Recursion
    // 컨트롤러에서 JSON으로 값을 출력하는 경우 타입을 변환해야 하는데
    // 변환되는 엔티티의 필드가 다른 엔티티를 참조하고 또 그 엔티티의 필드가 또 다른 엔티티를 참조하는 동작이 반복하여 Infinite Recursion 발생

    // @JsonIgnore 사용하기
    // 해결하는 여러가지 방법이 있는데 간단하게 상위(parent) 엔티티에서 하위(child) @OneToMany 필드에 @JsonIgnore를 추가하여 해결 가능.
    // @JsonIgnore는 json으로 변환되는 대상 객체에 사용해야 함. -> return 객체가 domain 인지 dto 인지 확인하고 사용.
    // 사전에 이러한 문제를 방지하고자 양방향 연관 관계를 지양하고 단방향 연관 관계를 사용.
    // 단방향 매핑만으로 테이블과 연관 관계 매핑 설정이 가능.

    // @JsonManagedReference, @JsonBackReference 사용하기
    // 필드에 대해 직렬화/비직렬화 여부를 설정해주는 것.
    // @OneToMany 필드에 JsonManagedReference, @ManyToOne 필드에 JsonBackReference 설정.

    // TODO: 연관관계의 주인
    // 1:N 관계에서 외래키는 항상 N 쪽에 있음.
    // 연관관계의 주인은 N 쪽의 테이블.
    // 즉, 연관관계의 주인은 외래키가 있는 곳.
    // 키의 주인이 아닌 관계의 주인인 것에 유의.

    // TODO: 일대다 단방향 연관관계의 단점
    // 일대다에서 '다'쪽에 있는 테이블의 외래키를 관리해줘야 함.
    // 일대다 단방향 연관관계에서는 '다'쪽 테이블 필드에 @JoinColumn을 사용해서 연관관계의 주인을 명시해줘야 함.
    // 그렇게 하지 않은 경우엔 JPA에서 조인 테이블을 생성하게 됨.
    // 일대다 연관관계는 JPA 표준 스펙에서 지원하지만 실무에서는 권장되지 않음.

    // 또한 이러한 경우엔 연관관계 처리를 위해 update sql을 추가로 실행해야 함.
    // 이런 문제를 해결하기 위해 외래키가 본인 테이블에 있도록 다대일(N:1) 양방향 매핑을 사용하는 것을 권장.
    // 또한 양방향 매핑에서 @OneToMany는 연관관계의 주인이 될 수 없으므로 일대다 단방향 매핑은 권장되지 않음.
    // 연관관계의 주인은 외래키가 있는 곳이기 때문.
    // 따라서 항상 '다'쪽이 외래키를 가지기 때문에 @ManyToOne이 항상 연관관계의 주인이 됨.

    // 일대다 단방향 매핑보다는 다대일 단방향 관계로 매핑하고 필요한 경우 양방향 매핑을 사용하는 것이 권장 됨.
    // 권장되는 연관관계 매핑
    // 1) 다대일(N:1) 단방향 연관관계
    // 2) 다대일(N:1) 양방향 연관관계
    // 3) 일대다(1:N) 단방향 연관관계
    // 공식적으로 일대다(1:N) 양방향 매핑은 없음. 굳이 사용한다면 아래와 같은 형태로 사용.
    // ex) @JoinColumn(name = "team_id", insertable = false, updatable = false)

    // TODO: N+1 문제
    // 연관관계가 설정된 엔티티를 조회했을 때 한 번에 조회하지 않고
    // 조회된 데이터의 개수(N) 만큼 연관관계의 엔티티에 대해 조회 쿼리가 추가로 발생하는 문제.
    // N+1 문제는 많은 양의 쿼리가 발생했을 때 성능 저하의 원인이 됨.
    // FetchType.EAGER, FetchType.LAZY 즉시로딩과 지연로딩 모두 N+1 문제가 발생할 수 있음.
    // fetch join, 하이버네이트 @BatchSize, FetchModel.SUBSELECT, EntityGraph 등으로 해결 가능.

    // N+1 문제 확인을 위한 설정
    // 즉시 로딩의 경우
    // 상위 엔티티에서 연관관계가 설정된 필드에 @OneToMany(fetch = FetchType.EAGER) 설정
    // 하위 엔티티에서 연관관계가 설정된 필드에 @ManyToOne 설정
    // 지연 로딩의 경우
    // 상위 엔티티에서 연관관계가 설정된 필드에 @OneToMany 설정
    // 하위 엔티티에서 연관관계가 설정된 필드에 @ManyToOne(fetch = FetchType.LAZY) 설정
    // spring.jpa.properties.hibernate.default_batch_fetch_size 주석 처리
    // spring.jpa.properties.hibernate.format_sql 주석 처리
    // spring.jpa.properties.hibernate.use_sql_comments 주석 처리

    // TODO: cascadeType을 이용한 영속성 전이
    // 부모 엔티티 삭제시 연관관계가 매핑된 자식 엔티티가 고아 객체가 되지 않도록 하기 위해 사용.
    // cascade = CascadeType.REMOVE 또는 cascade = {CascadeType.ALL}, orphanRemoval = true 옵션을 적용.
    // 이와 같이 영속성 전이를 통해 생명주기를 관리할 수 있음.
//    @JsonManagedReference
    @JsonIgnore
    @OneToMany(
        mappedBy = "board"
//        cascade = {CascadeType.ALL},
//        orphanRemoval = true,
//        fetch = FetchType.EAGER
//        cascade = CascadeType.REMOVE
    )
    private List<BoardCommentEntity> boardComments;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "author", length = 100)
    private String author;

    public void updateBoard(
        String title,
        String content,
        String author
    ) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Builder(toBuilder = true)
    public BoardEntity(
        String boardId,
        String title,
        String content,
        String author,
        List<BoardCommentEntity> boardComments
    ) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.boardComments = boardComments;
    }

}
