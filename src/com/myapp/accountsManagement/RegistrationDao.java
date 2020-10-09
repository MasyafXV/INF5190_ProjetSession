package com.myapp.accountsManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegistrationDao {
	
	
	public static boolean RegisterUser(
			String userName,
			String password,
			String firstname,
			String lastname,
			String email,
			String adress,
			String bdate) throws IOException {
		
		System.out.println("User Registration ");
		
		File fout = new File("/Users/vorolf/Documents/Course/SessionLive/Web app/INF5190_ProjetSession/WebContent/Data/UserAccounts.txt");
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
	
	public static boolean addUserToDatabase(
			String userName,
			String password) throws IOException {
				
		File fout = new File("/Users/vorolf/Documents/Course/SessionLive/Web app/INF5190_ProjetSession/WebContent/Data/Users.txt");
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
