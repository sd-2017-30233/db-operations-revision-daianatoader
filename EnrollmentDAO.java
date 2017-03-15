import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public EnrollmentDAO() {
	}

	private Connection getConnection() throws SQLException {
		Connection connection;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	public void add(int idStudent, int idCourse) {
		try {
			String query = "INSERT INTO enrollment(student_id, course_id) VALUES(?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, idStudent);
			ps.setInt(2, idCourse);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> findAll(String course) {
		List<String> studentName = new ArrayList<String>();
		try {
			String query = "SELECT student.name FROM student, course, enrollment WHERE course.name = ? AND enrollment.student_id = student.id AND enrollment.course_id = course.id;";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, course);
			rs = ps.executeQuery();
			while (rs.next()) {
				studentName.add(rs.getString("student.name"));
				//System.out.println("Name: " + rs.getString("student.name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentName;

	}
}