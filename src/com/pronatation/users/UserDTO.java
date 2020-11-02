package com.pronatation.users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.pronatation.Child.ChildDto;
import com.pronatation.pathManager.PathManager;

public class UserDTO {
	private String ProjectPath;


	private String username="";
    private String password="";
    
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
     }
    
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<ChildDto> getAllChilds(){
    	
	    System.out.println("Fetching " + username+ " childs...");

    	
    	   ArrayList<ChildDto> childsDtoArray= new ArrayList<ChildDto>();
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String userChildsPath = ProjectPath+"UserChilds.txt";

		   
		    String line = "";
		    
		    int lineNumber;
		    String childs=""; 
		    try {
		      FileReader readfile = new FileReader(userChildsPath);
		      BufferedReader readbuffer = new BufferedReader(readfile);
		      for (lineNumber = 1; lineNumber < 10; lineNumber++) {
		    	  
		    	  line=readbuffer.readLine();
		    	  
		    	  if(readFirstWord(line).equals(username)) {
		    		  childs=line;
		    		  
		    	  }
		    	   
		    	 
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    if(!childs.equals("")) { //if the user has childs
		    	
		    	String[] splitChilds = childs.split("\\s+");
		    	
		    	for (int i = 0; i<splitChilds.length; i++) {
		    		System.out.println(splitChilds[i]);
		    		ChildDto childDto= new ChildDto(splitChilds[i],"" ,"" );
		    		childsDtoArray.add(childDto);
		    	}
		    	
		    }else if (childs.equals("")) { //if the user has no childs
		    	
		    
			    System.out.println( username+ " Has no childs");

		    	
		    }
    	
		return childsDtoArray;
    	
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

