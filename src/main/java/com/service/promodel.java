package com.service;



import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Register;
import com.mysql.jdbc.Connection;


public class promodel {
	Connection con;
	public promodel(Connection con) {
		super();
		this.con=con;
		
	}
	public boolean insertRegister(Register r) throws SQLException {
		boolean f=false;
		String sql="insert into register1(uname,PhNo,email,password) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, r.getUname());
		ps.setString(2, r.getPhNo());
		ps.setString(3, r.getEmail());
		ps.setString(4, r.getPassword());
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println(" login Successful");
			f=true;
		
			
		}
		
		
		return f;
	}
	public String logincheck(String email, String password)throws SQLException {
	    Register s=null;
	    String st=null;
     
        String sql="select * from register where email= ? and password = ?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs=(ResultSet) ps.executeQuery();
		while(rs.next())
		{
			s=new Register();
			s.setId(rs.getInt("id"));
			s.setUname(rs.getString("uname"));
			s.setEmail(rs.getString("email"));
			s.setPassword(rs.getString("password"));
			
			if(email.equals(s.getEmail()) && password.equals(s.getPassword()))
			{
				st=s.getUname();
				
				break;
			}
		}
		
		return st;
	}
	public List<Register> prostock3() throws SQLException
	{  
		List<Register> ll=new ArrayList<Register>();
		Register p=null;
		try {
		String sql="select * from register";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=(ResultSet) ps.executeQuery();
		while (rs.next())
		{
		   p=new Register();
		   p.setId(rs.getInt("id"));
		   p.setUname(rs.getString("Uname"));
		   p.setPhoneno(rs.getString("Phoneno"));
		   p.setEmail(rs.getString("Email"));
		   
		   ll.add(p);
			
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return ll;
		}
	public List<Register> prostock4() throws SQLException
	{  
		List<Register> ll=new ArrayList<Register>();
		Register p=null;
		try {
		String sql="select id from register WHERE id=(SELECT MAX(id) FROM register)";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=(ResultSet) ps.executeQuery();
		while (rs.next())
		{
		   p=new Register();
		   p.setId(rs.getInt("id"));
		   
		   ll.add(p);
			
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return ll;
		}
		/*
		 * public static int uploadFile(String name, String price, String qun, String
		 * cat, InputStream file)throws SQLException { String
		 * sql="insert into product(pname,p_price,p_qun,p_cat,p_img) values(?,?,?,?,?)";
		 * int row=0; PreparedStatement ps=con.prepareStatement(sql); ps.setString(1,
		 * name); ps.setString(2, price); ps.setString(3, qun); ps.setString(4,cat);
		 * ps.setBlob(5,file); row=ps.executeUpdate(); return row;
		 * 
		 * 
		 * 
		 * }
		 */
    }
