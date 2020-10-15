package com.myapp.accountsManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.pronatation.pathManager.PathManager;

public class RegistrationDao {
	
	private String ProjectPath;

	
	public  boolean RegisterUser(
			String userName,
			String password,
			String firstname,
			String lastname,
			String email,
			String adress,
			String bdate) throws IOException {
		
		System.out.println("User Registration ");
		
		
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String userAccountsPath = ProjectPath+"UserAccounts.txt";
		   
		File fout = new File(userAccountsPath);
		
		FileOutputStream fos = new FileOutputStream(fout,true);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	
			bw.write(userName);
			bw.newLine();
			bw.write(password);
			bw.newLine();
			bw.write(firstname);
			bw.newLine();
			bw.write(lastname);
			bw.newLine();
			bw.write(email);
			bw.newLine();
			bw.write(adress);
			bw.newLine();
			bw.write(bdate);
			bw.newLine();
			bw.close();
			
			return true;
			
	}
	
	public  boolean addUserToDatabase(
			String userName,
			String password) throws IOException {
		
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String usersPath = ProjectPath+"Users.txt";
		   
		File fout = new File(usersPath);
		
		FileOutputStream fos = new FileOutputStream(fout,true);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	
			bw.write(userName);
			bw.newLine();
			bw.write(password);
			bw.newLine();
			bw.flush();
			bw.close();
			
			return true;
			
	}
	

}
