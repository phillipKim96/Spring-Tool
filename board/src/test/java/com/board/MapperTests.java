package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class MapperTests {

	@Autowired 
	private BoardMapper boardMapper; // @Autowired를 통해 BoardMapper 인터페이스에 Bean주입
	
	@Test
	public void testOfInsert() {  // 게시글 작성 메서드 (넣어줄땐 set) 
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");
		
		int result = boardMapper.insertBoard(params); //insertBoard메서드가 새로운 게시물을 데이터베이스에 삽입하는 역할
		System.out.println("결과는" + result +"입니다.");
		
	}
	@Test
	public void testOfSelectDetail() { //게시글 조회기능 테스트 결과
		BoardDTO board = boardMapper.selectBoardDetail((long)1); //long 1은 데이터베이스 1번 게시글을 조회하기 위한 pk값
		try {
			String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
			System.out.println("======================");
			System.out.println(boardJson);
			System.out.println("======================");
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void restOfUpdate() { //수정할 땐 업데이트 
		BoardDTO params=new BoardDTO();
		params.setTitle("1번 게시글 제목을 수정합니다.");
		params.setContent("1번 게시글 내용을 수정합니다.");
		params.setWriter("홍길동");
		params.setIdx((long)1);
		
		int result = boardMapper.updateBoard(params);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long)1);
			try {
				String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				
				System.out.println("======================");
				System.out.println(boardJson);
				System.out.println("======================");
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void restOfDelete() { // 게시글 삭제 메서드
		int result = boardMapper.deleteBoard((long)1);
		if (result==1) {
			BoardDTO board = boardMapper.selectBoardDetail((long)1);
			try {
				String BoardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				System.out.println("======================");
				System.out.println(BoardJson);
				System.out.println("======================");
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void testSelectList() { //게시글 목록 조회 메서드
		int boardTotalCount = boardMapper.selectBoardTotalCount(null);
		if (boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.selectBoardList(null);
			if(CollectionUtils.isEmpty(boardList) == false) {
				for(BoardDTO board : boardList) {
				System.out.println("======================");
				System.out.println(board.getTitle()); //받아올땐 겟
				System.out.println(board.getContent());
				System.out.println(board.getWriter());
				System.out.println("======================");
				}
			}
		}
		
	}
}
;