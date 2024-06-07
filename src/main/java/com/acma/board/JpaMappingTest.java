package com.acma.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.acma.board.domain.Board;
import com.acma.board.repository.BoardRepository;

@DataJpaTest
public class JpaMappingTest {
    
    private final String title = "테스트";
    private final String content = "내용";
    
    @Autowired
    private BoardRepository boardRepository;
    
    @BeforeEach
    public void init() {
        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now()).build());
    }
    
    @Test
    public void test() {
        Board board = boardRepository.getOne((long) 1);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }
}