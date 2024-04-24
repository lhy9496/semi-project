package com.pss.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;
import com.pss.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberBodyUpdateController
 */
@WebServlet("/pupdate.me")
public class MemberPhysicalUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPhysicalUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		UserPhysicalInfo userPInfo = new UserPhysicalInfo();
		
		userPInfo.setUserNo(loginUser.getUserNo());
		userPInfo.setMemHeight(Double.parseDouble(request.getParameter("memHeight")));
		userPInfo.setMemWeight(Double.parseDouble(request.getParameter("memWeight")));
		userPInfo.setMemSmm(Double.parseDouble(request.getParameter("memSmm")));
		userPInfo.setMemBep(Double.parseDouble(request.getParameter("memBep")));
		
		int result = new MemberServiceImpl().updatePhysicalInfo(userPInfo);
		
		if (result > 0) {
			session.setAttribute("alertMsg", "정보가 수정되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/menuToUserPage.me");
		} else {
			session.setAttribute("alertMsg", "정보 수정에 실패했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/pupdateform.me");
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
