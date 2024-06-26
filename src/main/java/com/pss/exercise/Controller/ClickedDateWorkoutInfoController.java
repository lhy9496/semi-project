package com.pss.exercise.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson; 
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.exercise.service.ExerciseServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class ClickedDateWorkoutInfoController
 */
@WebServlet("/cinfo.wo")
public class ClickedDateWorkoutInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClickedDateWorkoutInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String clickedDate = request.getParameter("clickedDate");
		String userNo = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).getUserNo());
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("clickedDate", clickedDate);
		map.put("userNo", userNo);
		// 이 날짜로 해당 날짜의 운동기록 불러오기
		ArrayList<ExerciseRecord> list = new ExerciseServiceImpl().selectClickedDateWorkoutList(map);

		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
