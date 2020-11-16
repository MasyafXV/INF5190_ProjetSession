package com.pronatation.Child;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.pronatation.users.UserDTO;

import service.UserService;

public class ListChildsAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860040487301150565L;
	private ArrayList<ChildBean> childsList;
	private String userName="";

	
	public String execute() {
        
		System.out.println("Listing the childs of "+userName);
		
		UserService uservice = new UserService(userName);
		uservice.getAllChilds();

		
//		ArrayList<ChildDto> listChildsDTO = new ArrayList<ChildDto> ();
//		listChildsDTO = getAllChilds();
//		
//		childsList = new ArrayList<>();
//		
//		for(int i = 1; i < listChildsDTO.size(); i++) {
//			childsList.add(new ChildBean(listChildsDTO.get(i).getChild_firstname()));
//		}
    	
        return SUCCESS;
    }
	
    
    private ArrayList<ChildDto> getAllChilds(){
    	
    	UserDTO userDTO=new UserDTO(userName, "");
    	
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
