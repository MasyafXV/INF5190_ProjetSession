package com.myapp.accountsManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
		
		ProjectPath= getProjectPath();
		File fout = new File(ProjectPath+"Data/UserAccounts.txt");
		
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
		
		ProjectPath= getProjectPath();				
		File fout = new File(ProjectPath+"Data/Users.txt");
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
	
	   private String getProjectPath() {
		    String myPorjectpath = this.getClass().getClassLoader().getResource("").getPath();
		    String fullPath = null;
		    
			try {
				fullPath = URLDecoder.decode(myPorjectpath, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String pathArr[] = fullPath.split("ProjectWorkplace");
		    System.out.println(fullPath);
		    System.out.println(pathArr[0]);
		    ProjectPath=pathArr[0] + "INF5190_ProjetSession/WebContent/";

		    System.out.println(" fullPath: " + ProjectPath);
		    return ProjectPath;
	   }
}
