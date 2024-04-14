package com.pss.exercise.Controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pss.exercise.model.vo.ExerciseInfo;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.exercise.model.vo.WorkoutRecord;
import com.pss.exercise.service.ExerciseServiceImpl;

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
		
//		int loginUserNo = ((Member)request.getAttribute("loginUser")).getUserNo();
		String exName = "";
		String bodyPart = "";
		int exSet = 0;
		int exWeight = 0;
		int exCount = 0;
		int result = 0;
		
		
		Gson gson = new Gson();
		WorkoutRecord[] workoutRecords = gson.fromJson(jsonData, WorkoutRecord[].class);
		
		for(WorkoutRecord record : workoutRecords) {
			System.out.println("Exercise: " + record.getExercise());
			exName = record.getExercise();
            System.out.println("BodyPart: " + record.getBodyPart());
            bodyPart = record.getBodyPart();
            for (ExerciseInfo info : record.getExInfos()) {
                System.out.println("Set: " + info.getExSet());
                exSet = Integer.parseInt(info.getExSet());
                System.out.println("Weight: " + info.getExWeight());
                exWeight = Integer.parseInt(info.getExWeight());
                System.out.println("Count: " + info.getExCount());
                exCount = Integer.parseInt(info.getExCount());
                ExerciseRecord exRecord = new ExerciseRecord(exName, exSet,exWeight, exCount);
                result = new ExerciseServiceImpl().insertWorkoutRecord(exName, exRecord);
            }
		}
		
//		System.out.println(jsonData);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
