package com.stosh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.stosh.model.User;
import com.stosh.utils.DBConnection;

public class UserDao {

	public User verifyUser(User u2) {
		try {
			
			Connection con = DBConnection.getConnection();
			String qry = "select * from user where userName=? and userPassword =?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, u2.getUserName());
			pst.setString(2, u2.getUserPassword());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				User verifiedUse = new User();
				verifiedUse.setUserId(rs.getInt("userId"));
				verifiedUse.setUserName(rs.getString("userName"));
				verifiedUse.setUserPassword(rs.getString("userPassword"));
				return verifiedUse;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
