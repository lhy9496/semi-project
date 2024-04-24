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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Member update = new Member();
		
		update.setUserEmail(request.getParameter("userEmail"));
		update.setUserPwd(request.getParameter("userPwd"));
		update.setUserName(request.getParameter("userName"));
		update.setGender(request.getParameter("gender"));
		update.setAge(Integer.parseInt(request.getParameter("age")));
		
		int result = new MemberServiceImpl().updateMember(update);
		
		if (result > 0) {
			session.setAttribute("alertMsg", "회원정보가 수정되었습니다.");
			
			String redirectUrl = (String)session.getAttribute("redirectUrl");
			if (redirectUrl == null) {
			response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect(redirectUrl);
			}
			
		} else {
			session.setAttribute("alertMsg", "회원정보 수정에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/updateForm.me");
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
