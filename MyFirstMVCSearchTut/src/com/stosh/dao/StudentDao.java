package com.stosh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import org.apache.catalina.ssi.SSIServletRequestUtil;

import com.stosh.model.Student;
import com.stosh.utils.DBConnection;

public class StudentDao {

	public int add(int i, int j) {
		return i+j;
	}
	
	public int sub(int i , int j) {
		return i-j;
	}
	
	public void insertStudent(Student st) {
		
		try {
			
			String i = "Name : Ram, Age :6";
				
			Connection con = DBConnection.getConnection();
			String qry = "insert into Student (studentName,studentAddress) values(?,?)";
			
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, st.getStudentName());
			pst.setString(2, st.getStudentAddress());
			//pst.setInt(3, get);
			pst.execute();
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Student> getStudentList(){
		try {
			
			Connection con = DBConnection.getConnection();
			String qry =  "select * from student";
			PreparedStatement pst = con.prepareStatement(qry);
			
			ResultSet rs = pst.executeQuery();
			
			List<Student> li = new ArrayList<>();
			
			while(rs.next()) {
				Student s1 = new Student();
				s1.setStudentId(rs.getInt("studentId"));
				s1.setStudentName(rs.getString("studentName"));
				s1.setStudentAddress(rs.getString("studentAddress"));
				li.add(s1);
			}
			return li;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Student> getStudentList(String searchStudent, String studentAddress){
		try {
			//String s =  "'Ram"+"Hati'";
			Connection con = DBConnection.getConnection();
			String qry =  "select * from student where studentName like '%"+searchStudent+"%' and studentAddress like '%"+studentAddress+"%'" ;
			PreparedStatement pst = con.prepareStatement(qry); 
			
			ResultSet rs = pst.executeQuery();
			
			List<Student> li = new ArrayList<>();
			
			while(rs.next()) {
				Student s1 = new Student();
				s1.setStudentId(rs.getInt("studentId"));
				s1.setStudentName(rs.getString("studentName"));
				s1.setStudentAddress(rs.getString("studentAddress"));
				li.add(s1);
			}
			return li;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Student getStudent(int studentId){
		try {
			
			Connection con = DBConnection.getConnection();
			String qry =  "select * from student where studentId=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, studentId);
			ResultSet rs = pst.executeQuery();
								
			while(rs.next()) {
				Student s1 = new Student();
				s1.setStudentId(rs.getInt("studentId"));
				s1.setStudentName(rs.getString("studentName"));
				s1.setStudentAddress(rs.getString("studentAddress"));
				return s1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void deleteStudent(int studentId) {
		try {
			
			Connection con = DBConnection.getConnection();
			String qry = "delete from student where studentId = ?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, studentId);
			pst.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateStudent(Student student) {
		try {
			
			Connection con = DBConnection.getConnection();
			String qry = "update student set studentName = ? , studentAddress= ? where studentId =?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, student.getStudentName());
			pst.setString(2, student.getStudentAddress());
			pst.setInt(3 , student.getStudentId());
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
