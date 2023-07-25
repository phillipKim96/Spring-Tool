package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.paging.Criteria;

// BoardServicelmpl 클래스를 서비스 빈으로 등록하기 위해 @Service 어노테이션을 사용합니다.
@Service
public class BoardServicelmpl implements BoardService {

	// BoardMapper 인터페이스를 주입받기 위해 @Autowired 어노테이션을 사용합니다.
	@Autowired
	private BoardMapper boardMapper;

	// 게시글을 등록하는 메서드입니다.
	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;
		
		// 만약 params의 idx 값이 null이라면, 새로운 게시글을 등록하는 쿼리를 실행합니다.
		// 그렇지 않으면 기존 게시글을 수정하는 쿼리를 실행합니다.
		if(params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}
		
		// 쿼리 실행 결과가 1이면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
		return (queryResult == 1) ? true : false;
	}

	// 특정 게시글의 상세 정보를 조회하는 메서드입니다.
	@Override
	public BoardDTO getBoardDetail(Long idx) {
		// boardMapper를 사용하여 특정 게시글의 상세 정보를 조회하여 반환합니다.
		return boardMapper.selectBoardDetail(idx);
	}

	// 특정 게시글을 삭제하는 메서드입니다.
	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;

		// boardMapper를 사용하여 특정 게시글의 정보를 조회합니다.
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		
		// 게시글이 존재하고, 삭제 여부가 "N"인 경우에만 삭제 쿼리를 실행합니다.
		if(board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);
		}
		
		// 쿼리 실행 결과가 1이면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
		return (queryResult == 1) ? true : false;
	}

	// 모든 게시글 목록을 조회하는 메서드입니다.
	@Override
	public List<BoardDTO> getBoardList(Criteria criteria){
		List<BoardDTO> boardList = Collections.emptyList();
		
		int boardTotalCount = boardMapper.selectBoardTotalCount(criteria);
		
		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList(criteria);
		}
		 
		return boardList;
	}
}
