package com.freestrokes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

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
        String author
    ) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
