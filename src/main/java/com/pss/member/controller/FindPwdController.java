package com.pss.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pss.member.model.vo.Member;
import com.pss.member.service.MemberServiceImpl;

/**
 * Servlet implementation class FindPwdController
 */
@WebServlet("/findPwd.me")
public class FindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userEmail = request.getParameter("userEmail");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		
		Member m = new Member();
		
		m.setUserEmail(userEmail);
		m.setUserName(userName);
		m.setUserNickname(userNickname);
		
		Member findPwd = new MemberServiceImpl().findPwd(m);
		
		if(findPwd == null) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "입력하신 정보에 해당하는 계정이 없습니다.");
			response.sendRedirect(request.getContextPath() + "/findForm.me");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "해당 계정의 비밀번호는 " + findPwd.getUserPwd() + "입니다.");
			response.sendRedirect(request.getContextPath() + "/loginForm.me");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
