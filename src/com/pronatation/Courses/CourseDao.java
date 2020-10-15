package com.pronatation.Courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CourseDao {
	
	private String ProjectPath;
	   public CourseDao() {
		   
	   }
	   
	   public boolean UserInscription(String Username, String CourseLevel) {
		   
		   ProjectPath= getProjectPath();

		
		    String line = "";
		    String newline = "";
		    
		    int lineNumber;
		    int targetLine=-1; 
		    try {
		      FileReader readfile = new FileReader(ProjectPath);
		      BufferedReader readbuffer = new BufferedReader(readfile);
		      for (lineNumber = 1; lineNumber < 10; lineNumber++) {
		    	  
		    	  line=readbuffer.readLine();
		    	  
		    	  if(readFirstWord(line).equals(Username)) {
		    		  targetLine=lineNumber;
		    		  newline=line;
		    		  
		    	  }
		    	   
		    	 
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    System.out.println(" The specific Line to add the course is: " + targetLine);
		    
		    if(targetLine!=-1) { //if the user has a course
		    	
		    	Path path = Paths.get(ProjectPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = targetLine -1;
		    	String extraLine = newline + " " + CourseLevel;  
		    	
		    	lines.add(position, extraLine);
		    	lines.remove(targetLine);

		    	try {
					Files.write(path, lines, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }else if (targetLine==-1) { //if the user has no courses
		    	
		    	Path path = Paths.get(ProjectPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = 0;
		    	String extraLine = Username + " " + CourseLevel;  
		    	
		    	lines.add(position, extraLine);

		    	try {
					Files.write(path, lines, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    
		   
		   return true;
		   
	   }
	  
	   
	   private static String readFirstWord(String line) {
		   String firstWord="";
		   
		   if(line !=null) {
			   
			   String arr[] = line.split(" ", 2);

			    firstWord = arr[0];   
			   
		   }
		   

		   
		return firstWord;
	   }
	
	   
	   public boolean ChildInscription(String ChildName, String CourseID) {
		   
		   
		   
		   
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
		    ProjectPath=pathArr[0] + "INF5190_ProjetSession/WebContent/Data/UsersCourses.txt";

		    System.out.println(" fullPath: " + ProjectPath);
		    return ProjectPath;
	   }
	   
	   
	  

}
