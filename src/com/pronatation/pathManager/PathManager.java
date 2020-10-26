package com.pronatation.pathManager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class PathManager {
	
	private String ProjectPath;
	
	public PathManager() {
		
	}
	


	   public String getProjectPath() {
		    String myPorjectpath = this.getClass().getClassLoader().getResource("").getPath();
		    String fullPath = null;
		    
			try {
				fullPath = URLDecoder.decode(myPorjectpath, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String pathArr[] = fullPath.split(".metadata");
		    ProjectPath=pathArr[0] + "INF5190_ProjetSession/WebContent/Data/";

		    System.out.println(" fullPath: " + ProjectPath);
		    return ProjectPath;
	   }

}
