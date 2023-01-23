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
    // 변환되는 엔티티의 필드가 다른 엔티티를 참조하고 또 그 엔티티 클래스의 필드가 또 다른 엔티티를 참조하는 동작이 반복
    // Infinite Recursion 발생
    // 이러한 경우 여러가지 방법이 있는데 parent 엔티티의 child @OneToMany 필드에 @JsonIgnore를 추가.
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
