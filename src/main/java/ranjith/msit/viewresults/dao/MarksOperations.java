package ranjith.msit.viewresults.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ranjith.msit.viewresults.dbproperties.DatabaseProperties;
import ranjith.msit.viewresults.model.Marks;
import ranjith.msit.viewresults.model.MarksTable;

public class MarksOperations {
	
	public List<MarksTable> getAllMarks() throws SQLException, ClassNotFoundException{
		System.out.println("Test here");
		Connection connection = null;
		PreparedStatement pStatement =null;
		ResultSet rs = null;
		List<MarksTable> marks= new ArrayList<MarksTable>();
		DatabaseProperties property = new DatabaseProperties();
		try {
			
			System.out.println("Test in query");
			connection = property.openConnectionToDB();
			System.out.println("Connected");
			pStatement = (PreparedStatement) connection.prepareStatement("SELECT * from marks");
			rs = pStatement.executeQuery();
			while(rs.next()) {
				MarksTable mt = new MarksTable();
				System.out.println(rs.getString("rno"));
				mt.setRno(rs.getString("rno"));
				mt.setStudent_name(rs.getString("student_name"));
				mt.setCourse_id(rs.getString("course_id"));
				mt.setCourse_name(rs.getString("course_name"));
				mt.setMarks(rs.getFloat("marks"));
				mt.setGrade(rs.getString("grade"));
				mt.setRemarks(rs.getString("remarks"));
				marks.add(mt); 
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			property.closeConnection(connection);
		}
		return marks;
	}
}
