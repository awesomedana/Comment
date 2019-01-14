package com.app.oraclespring;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.oraclespring.DAO.MemberDAO;
import com.app.oraclespring.VO.Member;

@Controller
public class MemberController {

	@Autowired
	MemberDAO dao;

	// 회원가입폼 이동
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "signup";
	}

	// 회원가입 액션
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(Member member, Model model) {

		int result = dao.insertMember(member);

		if (result == 0) {// 가입 실패시
			model.addAttribute("warning", "중복된 ID가 있습니다.");
			model.addAttribute("member", member);

			return "signup";
		}

		return "home";
	}

	// 로그인폼 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 로그인폼 액션
	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginMember(Member member, Model model, HttpSession session) {

		Member result = null;

		result = dao.loginMember(member);

		if (result == null) {// 로그인 실패
			model.addAttribute("warning", "ID와 비밀번호를 확인해주세요.");
			model.addAttribute("member", member);
			return "login";
		}

		session.setAttribute("loginId", member.getId());

		return "home";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		// session.invalidate();
		session.setAttribute("loginId", null);

		return "home";
	}

}
