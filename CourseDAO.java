import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public CourseDAO() {
	}

	private Connection getConnection() throws SQLException {
		Connection connection;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	public void add(Course c) {
		try {
			String query = "INSERT INTO course(name, teacher, studyYear) VALUES(?,?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setString(2, c.getTeacher());
			ps.setInt(3, c.getStudyYear());
			ps.executeUpdate();
			//return "Succes";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}

	public void update(int id, Course c) {
		try {
			String query = "UPDATE course SET name=?,teacher=?,studyYear=? WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setString(2, c.getTeacher());
			ps.setInt(3, c.getStudyYear());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			String query = "DELETE FROM course WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Course getById(int id) {
		Course c=null;
		try {
			String query = "SELECT * FROM course WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			String name = null, teacher = null;
			int studyYear = 0;
			while (rs.next()) {
				System.out.println("Name: " + rs.getString("name") + ", Teacher: "
						+ rs.getString("teacher") + ", StudyYear: "
						+ rs.getString("studyYear"));
				name = rs.getString("name");
				teacher = rs.getString("teacher");
				studyYear = Integer.parseInt(rs.getString("studyYear"));
			}
			c =  new Course(name,teacher,studyYear);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public Course getByName(String courseName) {
		Course c = null;
		try {
			String query = "SELECT * FROM course WHERE name=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, courseName);
			rs = ps.executeQuery();
			String name = null, teacher = null;
			int studyYear = 0;
			while (rs.next()) {
				System.out.println("Name: " + rs.getString("name") + ", Teacher: "
						+ rs.getString("teacher") + ", StudyYear: "
						+ rs.getString("studyYear"));
				name = rs.getString("name");
				teacher = rs.getString("teacher");
				studyYear = Integer.parseInt(rs.getString("studyYear"));
			}
			c =  new Course(name,teacher,studyYear);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
