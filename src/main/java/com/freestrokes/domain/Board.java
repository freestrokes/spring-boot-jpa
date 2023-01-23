package com.freestrokes.domain;

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
