package com.board.util;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;
import com.board.domain.BoardDTO;
import com.board.paging.Criteria;

public class UiUtils {
	public String showMessageWithRedirect(@RequestParam(value="message", required = false)String message,
										  @RequestParam(value="redirectUri", required = false)String redirectUri,
										  @RequestParam(value="method", required = false)Method method,
										  @RequestParam(value="params", required = false)Map<String, Object> params, Model model) {
	
		
		model.addAttribute("message", message);
		model.addAttribute("redirectUri", redirectUri);
		model.addAttribute("method", method);
		model.addAttribute("params", params);
		
		return "utils/message-redirect";
	}

	public List<BoardDTO> getBoardList(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
}
