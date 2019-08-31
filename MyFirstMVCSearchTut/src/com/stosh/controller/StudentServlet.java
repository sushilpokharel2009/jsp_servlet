package com.stosh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stosh.dao.StudentDao;
import com.stosh.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			StudentDao sd = new StudentDao();
			
			if(request.getParameter("add")!=null) {
			Student st1 = new Student();
			st1.setStudentName(request.getParameter("studentName"));
			st1.setStudentAddress(request.getParameter("studentAddress"));			
			sd.insertStudent(st1);	
			response.sendRedirect("home.jsp");
			return;
			
			}else if(request.getParameter("studentIdForDelete")!=null) {
				
				int studentId = Integer.parseInt(request.getParameter("studentIdForDelete"));
				
				sd.deleteStudent(studentId);
			}else if(request.getParameter("studentIdForEdit")!=null) {
				
				int studentId = Integer.parseInt(request.getParameter("studentIdForEdit"));
				
				Student student = sd.getStudent(studentId);
				request.setAttribute("s", student);
				RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
				rd.forward(request, response);
				return;
				
			}else if(request.getParameter("update")!=null) {
				int studentId = Integer.parseInt(request.getParameter("studentId"));
				Student st1 = new Student();
				st1.setStudentId(studentId);
				st1.setStudentName(request.getParameter("studentName"));
				st1.setStudentAddress(request.getParameter("studentAddress"));
				
				sd.updateStudent(st1);
			}else if(request.getParameter("search")!=null) {
				
				String studentName = request.getParameter("studentName");
				String studentAddress = request.getParameter("studentAddress");
				
				
				
				
				
				
				
				
				
				List<Student> studentList = sd.getStudentList(studentName, studentAddress);
				request.setAttribute("sList", studentList);
				RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
				rd.forward(request, response);
				return;
			}
			
		
			
			List<Student> studentList = sd.getStudentList();
			
			
//***********pagination making but we must do this from javascript and jquery not from java.*************			
			int p = 1;
			int j = 1;
			if(request.getParameter("p")!=null) {
			 p = Integer.parseInt(request.getParameter("p"));
			 

			}
			
			switch(p) {
			case 1:
				j=0;
				break;
				default :
					j = (10*(p-1))-1;
					
			}
			//int  i = 0;
			//List<Student> studentList1 = studentList.subList(i, ((i+10)-1)*p);
			List<Student> studentList1 = new ArrayList<>();
			for( int i=j; i<studentList.size(); i++) {
				
				studentList1.add(studentList.get(i));
				if(j+10==i)break;
			}
			System.out.println("-------"+studentList1.size());
//			int a = sd.add(5, 7);
			
			
//		***********************************	
			
			
			
			
//			
			request.setAttribute("sList", studentList1);
			RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
			rd.forward(request, response);
			
			
			
			
		//	response.sendRedirect("student-list.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
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
