import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public StudentDAO() {
	}

	private Connection getConnection() throws SQLException {
		Connection connection;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	public void add(Student s) {
		try {
			String query = "INSERT INTO student(name, birthdate, address) VALUES(?,?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getBirthdate());
			ps.setString(3, s.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, Student s) {
		try {
			String query = "UPDATE student SET name=?,birthdate=?,address=? WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getBirthdate());
			ps.setString(3, s.getAddress());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			String query = "DELETE FROM student WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student getById(int id) {
		Student s = null;
		try {
			String query = "SELECT * FROM student WHERE id=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			String name = null, birthdate = null, address = null;
			while (rs.next()) {
				System.out.println("Name: " + rs.getString("name") + ", Birthdate: "
						+ rs.getString("birthdate") + ", Address: "
						+ rs.getString("address"));
				name = rs.getString("name");
				birthdate = rs.getString("birthdate");
				address = rs.getString("address");
				s = new Student(name,birthdate,address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public Student getByName(String studentName) {
		Student s = null;
		try {
			String query = "SELECT * FROM student WHERE name=?";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, studentName);
			rs = ps.executeQuery();
			String name = null, birthdate = null, address = null;
			while (rs.next()) {
				System.out.println("Name: " + rs.getString("name") + ", Birthdate: "
						+ rs.getString("birthdate") + ", Address: "
						+ rs.getString("address"));
				name = rs.getString("name");
				birthdate = rs.getString("birthdate");
				address = rs.getString("address");
				s = new Student(name,birthdate,address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
