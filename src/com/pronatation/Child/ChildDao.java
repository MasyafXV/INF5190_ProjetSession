package com.pronatation.Child;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.pronatation.pathManager.PathManager;
import com.sun.tools.javac.util.List;

public class ChildDao {
	

	private String ProjectPath;

	   public ChildDao() {
		   
	   }
	   
	   public boolean registerChild(String childFname, String childLname, String childAge) throws IOException {
		   
		   System.out.println("writing in child.txt for " + childFname);
		   
			
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String userAccountsPath = ProjectPath+"Childs.txt";
		   
				File fout = new File(userAccountsPath);
				
				FileOutputStream fos = new FileOutputStream(fout,true);
			 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
					bw.write(childFname);
					bw.newLine();
					bw.write(childLname);
					bw.newLine();
					bw.write(childAge);
					bw.newLine();
					bw.close();
			
			return true;

	   }
	   
	   
	   public boolean addChild(String Parent_username,String childName) {
		   
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String userChildsPath = ProjectPath+"UserChilds.txt";

		   
		    String line = "";
		    String newline = "";
		    
		    int lineNumber;
		    int targetLine=-1; 
		    try {
		      FileReader readfile = new FileReader(userChildsPath);
		      BufferedReader readbuffer = new BufferedReader(readfile);
		      for (lineNumber = 1; lineNumber < 10; lineNumber++) {
		    	  
		    	  line=readbuffer.readLine();
		    	  
		    	  if(readFirstWord(line).equals(Parent_username)) {
		    		  targetLine=lineNumber;
		    		  newline=line;
		    		  
		    	  }
		    	   
		    	 
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
//		    System.out.println(" The specific Line to add the child is: " + targetLine);
		    
		    if(targetLine!=-1) { //if the user has a child
		    	
		    	Path path = Paths.get(userChildsPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = targetLine -1;
		    	String extraLine = newline + " " + childName;  
		    	
		    	lines.add(position, extraLine);
		    	lines.remove(targetLine);

		    	try {
					Files.write(path, lines, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }else if (targetLine==-1) { //if the user has no childs
		    	
		    	Path path = Paths.get(userChildsPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = 0;
		    	String extraLine = Parent_username + " " + childName;  
		    	
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
	  
	   
	   private  String readFirstWord(String line) {
		   String firstWord="";
		   
		   if(line !=null) {
			   
			   String arr[] = line.split(" ", 2);

			    firstWord = arr[0];   
			   
		   }
		   

		   
		return firstWord;
	   }

	
	   
}
