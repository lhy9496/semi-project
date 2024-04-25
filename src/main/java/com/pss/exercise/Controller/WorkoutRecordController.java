package com.pss.exercise.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pss.exercise.model.vo.ExerciseInfo;
import com.pss.exercise.model.vo.WorkoutRecord;
import com.pss.exercise.service.ExerciseServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class WorkoutRecordController
 */
@WebServlet("/insert.wo")
public class WorkoutRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkoutRecordController() {
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
		
		int loginUserNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Gson gson = new Gson();
		WorkoutRecord[] workoutRecords = gson.fromJson(jsonData, WorkoutRecord[].class);
		
		int result = 0;
		
		for(WorkoutRecord record : workoutRecords) {

			int exerciseNo = Integer.parseInt(record.getExerciseNo());
            for (ExerciseInfo info : record.getExInfos()) {
               
            	int exSet = Integer.parseInt(info.getExSet());
                
                int exWeight = Integer.parseInt(info.getExWeight());
               
                int exCount = Integer.parseInt(info.getExCount());
                
                HashMap<String, Integer> map = new HashMap<>();
                map.put("exerciseNo", exerciseNo);
                map.put("exSet", exSet);
                map.put("exWeight", exWeight);
                map.put("exCount", exCount);
                map.put("userNo",loginUserNo);
                
                result = new ExerciseServiceImpl().insertExerciseRecord(map);
                       
            }
		}
		
		gson.toJson(result);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
