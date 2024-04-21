package com.pss.diet.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pss.diet.model.vo.MealRecord;
import com.pss.diet.service.FoodServiceImpl;
import com.pss.exercise.model.vo.ExerciseInfo;
import com.pss.exercise.model.vo.WorkoutRecord;
import com.pss.exercise.service.ExerciseServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class MealInsertController
 */
@WebServlet("/insert.mr")
public class MealInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		String jsonData = sb.toString();
		
//		int loginUserNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();

//		System.out.println(loginUserNo);
		
		
		Gson gson = new Gson();
		MealRecord[] mealRecords = gson.fromJson(jsonData, MealRecord[].class);

		for(MealRecord meal : mealRecords) {

			int foodNo = meal.getFoodNo();
			int foodAmount = meal.getAmount();
			int mealTimingNo = meal.getMealTimingNo();
                
            HashMap<String, Integer> map = new HashMap<>();
            System.out.println(foodNo);
            System.out.println(foodAmount);
            System.out.println(mealTimingNo);
            
            map.put("foodNo", foodNo);
            map.put("foodAmount", foodAmount);
            map.put("mealTimingNo", mealTimingNo);
            
            int result = new FoodServiceImpl().insertMealRecord(map);
                       
		}
		
		new Gson().toJson("",response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
