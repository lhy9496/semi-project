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
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Member m = new Member();
		
		m.setUserEmail(request.getParameter("userEmail"));
		m.setUserPwd(request.getParameter("userPwd"));
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		if (loginUser == null) {
			session.setAttribute("alertMsg", "이메일이나 비밀번호가 올바르지 않습니다.");
			response.sendRedirect(request.getContextPath() + "/loginForm.me");
		} else {
			session.setAttribute("alertMsg", loginUser.getUserNickname() + "님 환영합니다.");
			request.getSession().setAttribute("loginUser", loginUser);
			
			String redirectUrl = (String)session.getAttribute("redirectUrl");
			
			if (redirectUrl == null) {
			response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect(redirectUrl);
			}
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
