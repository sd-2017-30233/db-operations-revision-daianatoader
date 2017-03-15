import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnrollment {

	@Test
	public void testAdd() {
		Enrollment e = new Enrollment(4,4);
		EnrollmentDAO ed = new EnrollmentDAO();
		CourseDAO cd = new CourseDAO();
		int size = ed.findAll(cd.getById(4).getName()).size();
		ed.add(e.getStudentId(),e.getCourseId());
		int size2 = ed.findAll(cd.getById(4).getName()).size();
		assertEquals(size2,size+1);
	}

	@Test
	public void testFindAll() {
		EnrollmentDAO ed = new EnrollmentDAO();
		CourseDAO cd = new CourseDAO();
		int size = ed.findAll(cd.getById(1).getName()).size();
		assertEquals(size,4);
	}

}
