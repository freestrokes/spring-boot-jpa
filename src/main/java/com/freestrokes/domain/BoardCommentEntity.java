package com.freestrokes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "board_comment")
@Entity
public class BoardCommentEntity {

    // NOTE: id 필드에 sequence 적용하려는 경우엔 아래와 같이 사용.
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "board_comment_id", unique = true, nullable = false)
//    private Long boardCommentId;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "board_comment_id", length = 100, unique = true, nullable = false)
    private String boardCommentId;

    // NOTE: FetchType
    // 즉시 로딩(EAGER)과 지연 로딩(LAZY)가 있음.
    // @OneToMany, @ManyToMany -> 디폴트 패치 전략 LAZY
    // @ManyToOne, @OneToOne -> 디폴트 패치 전략 EAGER

    // NOTE: @JoinColumn 어노테이션
    // 외래키 매핑을 위해서 사용.
    // 사용하지 않으면 JPA 내부적으로 조인 테이블을 생성해서 매핑하게 됨.
//    @JsonBackReference
//    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "author", length = 100)
    private String author;

    public void updateBoardComment(
        String content,
        String author
    ) {
        this.content = content;
        this.author = author;
    }

    @Builder(toBuilder = true)
    public BoardCommentEntity(
        String boardCommentId,
        BoardEntity board,
        String content,
        String author
    ) {
        this.boardCommentId = boardCommentId;
        this.board = board;
        this.content = content;
        this.author = author;
    }

}
