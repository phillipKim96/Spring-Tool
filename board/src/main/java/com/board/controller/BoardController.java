package com.board.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;
import com.board.domain.BoardDTO;
import com.board.paging.Criteria;
import com.board.service.BoardService;
import com.board.util.UiUtils;

// @Controller 어노테이션을 사용하여 BoardController 클래스를 컨트롤러로 등록합니다.
@Controller
public class BoardController extends UiUtils {
	
	
	// BoardService 인터페이스를 주입받기 위해 @Autowired 어노테이션을 사용합니다.
	@Autowired
	private BoardService boardService;
	
	// "/board/write.do" 요청에 대한 처리를 위한 메서드입니다. HTTP GET 요청에 대응합니다.
	@GetMapping(value = "/board/write.do")
	public String openBoardWrite(@RequestParam(value="idx",required = false)Long idx, Model model) {
		if(idx == null ) {
			model.addAttribute("board", new BoardDTO());
		}else {
			BoardDTO board = boardService.getBoardDetail(idx);
			if (board == null) {
				return "redirect:/board/list.do";
			}
			model.addAttribute("board",board);
		}
		return "board/write";
		/*
		 * // "board/write" 뷰를 반환합니다. // 이 뷰는 게시글 작성 페이지를 나타내는 템플릿 파일을 가리킵니다. String
		 * title = "제목"; String content = "내용"; String writer = "홍길동";
		 * 
		 * model.addAttribute("t",title); model.addAttribute("c",content);
		 * model.addAttribute("w",writer); return "board/write";
		 */
	}
	@PostMapping(value = "/board/register.do")
	public String registerBoard(final BoardDTO params, Model model) {
	try{
		boolean isRegistered = boardService.registerBoard(params);
		if (isRegistered ==false) {
			return showMessageWithRedirect("게시글 등록에 실패하였습니다.","/board/list.do", Method.GET, null, model);
			
		}		
	}	catch(DataAccessException e) {
			return showMessageWithRedirect("데이터 베이스 처리 과정에 문제가 발생했습니다.","/board/list.do", Method.GET, null, model);
	} 	catch(Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
	}
		return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	}
	@GetMapping(value ="/board/list.do")
	public String openBoardList(@ModelAttribute("criteria") Criteria criteria, Model model) {
		List<BoardDTO> boardList= boardService.getBoardList(criteria);
		model.addAttribute("boardList",boardList);
		return "board/list";
	}
	@GetMapping(value = "/board/view.do")
	public String openBoardDetail(@RequestParam(value = "idx", required =false)Long idx, Model model) {
		if(idx == null) {
			return "redirect:/board/list.do";
		}
		BoardDTO board = boardService.getBoardDetail(idx);
		if(board == null || "Y".equals(board.getDeleteYn())) {
			return "redirect:/board/list.do";
		}
		model.addAttribute("board", board);
		
		return "board/view";
	}
	@PostMapping(value="/board/delete.do")
	public String deleteBoard(@RequestParam(value = "idx", required = false)Long idx, Model model){
	  if(idx == null){
	    return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list.do", Method.GET, null, model);
	  }
	  try{
	    boolean isDeleted = boardService.deleteBoard(idx);
	    if(isDeleted == false){
	    	return showMessageWithRedirect("게시글 삭제에 실패하였습니다.","/board/list.do", Method.GET, null, model);
	    	}
	    }catch (DataAccessException e){
	    	return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.","/board/list.do", Method.GET, null, model);

	    }catch(Exception e){
	    	return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
	    }
	  	return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	  	} 
	}

