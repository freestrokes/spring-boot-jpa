package com.freestrokes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "board_comment")
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_id", unique = true, nullable = false)
    private Long board_comment_id;

    // TODO: FetchType 확인 필요
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "author", length = 100)
    private String author;

    public void update(BoardComment boardComment) {
        this.content = boardComment.getContent();
        this.author = boardComment.getAuthor();
    }

    @Builder(toBuilder = true)
    public BoardComment(
        String content,
        String author
    ) {
        this.content = content;
        this.author = author;
    }

}
