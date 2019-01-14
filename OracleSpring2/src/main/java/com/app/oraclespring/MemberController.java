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

	// ȸ�������� �̵�
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "signup";
	}

	// ȸ������ �׼�
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(Member member, Model model) {

		int result = dao.insertMember(member);

		if (result == 0) {// ���� ���н�
			model.addAttribute("warning", "�ߺ��� ID�� �ֽ��ϴ�.");
			model.addAttribute("member", member);

			return "signup";
		}

		return "home";
	}

	// �α����� �̵�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// �α����� �׼�
	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginMember(Member member, Model model, HttpSession session) {

		Member result = null;

		result = dao.loginMember(member);

		if (result == null) {// �α��� ����
			model.addAttribute("warning", "ID�� ��й�ȣ�� Ȯ�����ּ���.");
			model.addAttribute("member", member);
			return "login";
		}

		session.setAttribute("loginId", member.getId());

		return "home";
	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		// session.invalidate();
		session.setAttribute("loginId", null);

		return "home";
	}

}
