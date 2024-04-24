package com.pss.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pss.member.model.vo.Member;
import com.pss.member.service.MemberServiceImpl;

/**
 * Servlet implementation class AjaxPwdCheckController
 */
@WebServlet("/pwdCheck.me")
public class AjaxPwdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxPwdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		
		String checkPwd = request.getParameter("checkPwd");
		String userEmail = loginUser.getUserEmail();
		
		Member former = new Member();
		former.setUserEmail(userEmail);
		former.setUserPwd(checkPwd);
		
		System.out.println(former);
		
		int count = new MemberServiceImpl().pwdCheck(former);
		
		if (count > 0) {
			response.getWriter().print("NNNNN");
		} else {
			response.getWriter().print("NNNNY");
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
