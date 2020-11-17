package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.pronatation.Courses.CourseDTO;

import mangodb.DatabaseManager;

public class CourseService {
	
	public CourseService() {
		
	}
	
	public ArrayList<CourseDTO> getAllCourses() {
		
		
		DatabaseManager dbManager = new DatabaseManager();

		
		MongoClient client = dbManager.connect();
		
		MongoDatabase mydatabase = dbManager.getDatabase(client);
		
	    MongoCollection<Document> courseCollection = mydatabase.getCollection("Courses");
	    
    	
    	FindIterable<Document> iterable = courseCollection.find(); // (1)

    	MongoCursor<Document> cursor = iterable.iterator(); // (2)
    	
    	ArrayList<CourseDTO> coursesList=new ArrayList<CourseDTO>();

    	try {
    		
    	while(cursor.hasNext()) {
    		
    		Document course = cursor.next();
    		
    		
    		@SuppressWarnings("unchecked")
			Object[] prerequisites = ((ArrayList<String>) course.get("prerequisite")).toArray();
    		
    		CourseDTO courseDTO = new CourseDTO(course.getString("courseLevel"), prerequisites);
    		coursesList.add(courseDTO);
    	}
    	
    	} finally {
    		
    	cursor.close();
    	
    	}
    	
    	return coursesList;

	     
	}

}