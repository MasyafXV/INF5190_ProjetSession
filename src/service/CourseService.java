package service;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.pronatation.Courses.CourseDTO;

import mangodb.DatabaseManager;

public class CourseService {
	
	DatabaseManager dbManager;
	MongoClient client;
	MongoDatabase mydatabase;
	
	public CourseService() {
		
		dbManager = new DatabaseManager();
		client = dbManager.connect();
		mydatabase = dbManager.getDatabase(client);

	}

	public ArrayList<CourseDTO> getAllCourses() {


		MongoCollection<Document> courseCollection = mydatabase.getCollection("Courses");

		FindIterable<Document> iterable = courseCollection.find(); // (1)

		MongoCursor<Document> cursor = iterable.iterator(); // (2)

		ArrayList<CourseDTO> coursesList = new ArrayList<CourseDTO>();

		try {

			while (cursor.hasNext()) {

				Document course = cursor.next();

				@SuppressWarnings("unchecked")
				Object[] prerequisites = ((ArrayList<String>) course.get("prerequisite")).toArray();

				CourseDTO courseDTO = new CourseDTO(course.getString("sessionCode"), course.getString("courseLevel"),
						course.getString("description"), course.getString("NbPlace"), course.getString("price"),
						prerequisites);
				coursesList.add(courseDTO);
			}

		} finally {

			cursor.close();

		}

		return coursesList;

	}

}
