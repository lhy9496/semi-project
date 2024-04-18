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
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userEmail = request.getParameter("userEmail");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		
		Member m = new Member(userName, userNickname, userEmail, userPwd, gender, 0);
		
		System.out.println(m);
		
		int result = new MemberServiceImpl().insertMember(m);
		
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			
			String redirectUrl = (String)session.getAttribute("redirectUrl");
			if (redirectUrl == null) {
			response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect(redirectUrl);
			}
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/enrollForm.me");
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
