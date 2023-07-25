package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;
import com.board.paging.Criteria;

@Mapper //SQL문을 찾아 실행 
public interface BoardMapper {
//boardDTO클래스 만들어 놓은 것들만 사용할 예정
	public int insertBoard(BoardDTO params); // 게시글 생성 
	public BoardDTO selectBoardDetail(Long idx); // 하나의 게시글 조회
	public int updateBoard(BoardDTO params); //게시글 수정
	public int deleteBoard(Long idx); //게시글 삭제
	public List<BoardDTO> selectBoardList(Criteria criteria); //게시글 목록 조회 > list로 뿌릴 예정인데 BoardDTO에서 뿌릴꺼
	public int selectBoardTotalCount(Criteria criteria);

}
