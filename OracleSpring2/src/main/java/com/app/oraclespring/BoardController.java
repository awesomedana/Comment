package com.app.oraclespring;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.oraclespring.DAO.BoardDAO;
import com.app.oraclespring.VO.Board;
import com.app.oraclespring.VO.Comment;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {

		return "redirect:/boardList";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite(HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "login";
		}
		return "boardWrite";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(Board board, HttpSession session) {
		if (session.getAttribute("loginId") == null) {// 로그인을 안했거나, 세션이 끊겼을때
			return "login";
		}
		board.setId((String) session.getAttribute("loginId"));

		int result = dao.insertBoard(board);
		if (result == 0) {// 등록실패시
			return "boardWrite";
		}

		return "redirect:/boardList";
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(Model model) {

		// 게시물을 가져온다
		ArrayList<Board> bList = dao.boardList();

		model.addAttribute("bList", bList);

		return "board";
	}

	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, String boardSeq) {

		try {
			Integer.parseInt(boardSeq);
		} catch (Exception e) {
			return "redirect:/boardList";
		}
		
		dao.increaseHit(boardSeq);
		
		Board result = dao.boardDetail(boardSeq);
		if (result == null) {
			return "redirect:/boardList";
		}
		model.addAttribute("board", result);
		selectComment(model,result.getBoardSeq()+"");
		return "boardDetail";
	}

	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(String boardSeq,HttpSession session) {
		if (session.getAttribute("loginId") == null) {// 로그인을 안했거나, 세션이 끊겼을때
			return "login";
		}
		Board board=dao.boardDetail(boardSeq);
		
		if(board.getId().equals((String)session.getAttribute("loginId"))) {
			dao.deleteBoard(boardSeq);
		}	
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(String boardSeq,Model model,HttpSession session) {
		if (session.getAttribute("loginId") == null) {// 로그인을 안했거나, 세션이 끊겼을때
			return "login";
		}
		
		Board board=dao.boardDetail(boardSeq);
		
		if(!board.getId().equals((String)session.getAttribute("loginId"))) {
			return "redirect:/boardList";
		}	
		
		model.addAttribute("board",board);
		
		return "boardWrite";
	}
	
	
	@RequestMapping(value = "/updateContent", method = RequestMethod.POST)
	public String updateContent(Board board,HttpSession session) {
		if (session.getAttribute("loginId") == null) {// 로그인을 안했거나, 세션이 끊겼을때
			return "login";
		}
		
		dao.updateContent(board);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	public String insertComment(Comment comment,HttpSession session,Model model) {
		if(session.getAttribute("loginId")==null) {
			return "login";
		}
		String loginId=(String)session.getAttribute("loginId");
		comment.setId(loginId);
		dao.insertComment(comment);
		
		
		Board result = dao.boardDetail(comment.getBoardSeq()+"");
		model.addAttribute("board", result);
		selectComment(model,result.getBoardSeq()+"");
		
		return "boardDetail";
	}
	
	public void selectComment(Model model, String boardSeq) {
		ArrayList<Comment> result;
		result=dao.selectComment(boardSeq);
		model.addAttribute("commentList",result);
	}
	
	
}







