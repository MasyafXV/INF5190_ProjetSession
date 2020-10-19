package com.pronatation.Child;

import java.util.ArrayList;

import com.myapp.login.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListChildsAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860040487301150565L;
	private ArrayList<ChildBean> childsList;
	private String userName="";

	
	public String execute() {
        
		System.out.println("execution..");
		
		ArrayList<ChildDto> listChildsDTO = new ArrayList<ChildDto> ();
		listChildsDTO = getAllChilds();
		
//		childsList = new ArrayList<>();
//		
//		for(int i = 0; i < listChildsDTO.size(); i++) {
//			childsList.add(new ChildBean(listChildsDTO.get(i).getChild_firstname()));
//		}
    	
        return SUCCESS;
    }
    
    private ArrayList<ChildDto> getAllChilds(){
    	
    	UserDTO userDTO=new UserDTO("User2", "");
    	
		return userDTO.getAllChilds();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<ChildBean> getChildsList() {
		return childsList;
	}

	public void setChildsList(ArrayList<ChildBean> childsList) {
		this.childsList = childsList;
	}

}
