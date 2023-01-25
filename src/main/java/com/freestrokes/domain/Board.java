package com.freestrokes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", unique = true, nullable = false)
    private Long boardId;

    // TODO: 양방향 연관 관계를 설정한 경우
    // 컨트롤러에서 JSON으로 값을 출력하는 경우 타입을 변환해야 하는데
    // 변환되는 엔티티의 필드가 다른 엔티티를 참조하고 또 그 엔티티의 필드가 또 다른 엔티티를 참조하는 동작이 반복
    // Infinite Recursion 발생
    // 해결하는 여러가지 방법이 있는데 간단하게 parent 엔티티에서 child @OneToMany 필드에 @JsonIgnore를 추가하여 해결 가능.
    // @JsonIgnore는 json으로 변환되는 대상 객체에 사용해야 함. -> return 객체가 domain 인지 dto 인지 확인하고 사용.
    // 사전에 이러한 문제를 방지하고자 양방향 연관 관계를 지양하고 단방향 연관 관계를 사용.
    // 단방향 매핑만으로 테이블과 연관 관계 매핑 설정이 가능.

    // TODO: 연관관계의 주인
    // 1:N 관계에서 외래키는 항상 N 쪽에 있음.
    // 연관관계의 주인은 N 쪽의 테이블.
    // 키의 주인이 아닌 관계의 주인인 것에 유의.

    // TODO: 일대다 단방향 매핑의 단점
    // 다른 테이블에 있는 외래키를 관리해줘야 함.
    // 이러한 경우 연관관계 처리를 위한 update sql을 추가로 실행해야 함.
    // 이런 문제를 해겷하기 위해 외래키가 본인 테이블에 있도록 다대일 양방향 매핑을 사용하는 것을 권장.
    // 또한 양방향 매핑에서 @OneToMany는 연관관계의 주인이 될 수 없으므로 일대다 단방향 매핑은 권장되지 않음.
    @JsonIgnore
    @OneToMany(mappedBy = "board")
    private List<BoardComment> boardComments;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "author", length = 100)
    private String author;

    public void update(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }

    @Builder(toBuilder = true)
    public Board(
        String title,
        String content,
        String author,
        List<BoardComment> boardComments
    ) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.boardComments = boardComments;
    }

}
