package com.board.service;
import java.util.List;
import com.board.domain.BoardDTO;
import com.board.paging.Criteria;

public interface BoardService {
	public boolean registerBoard(BoardDTO parmas);
	public BoardDTO getBoardDetail(Long idx);
	public boolean deleteBoard(Long idx);
	public List<BoardDTO> getBoardList(Criteria criteria);
	

}
