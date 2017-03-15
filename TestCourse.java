import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCourse {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Course c = new Course("ASDN","Lucia Vacariu",1);
		CourseDAO cd = new CourseDAO();
		cd.add(c);
		assertEquals("ASDN",cd.getByName("ASDN").getName());
	}

	@Test
	public void testUpdate() {
		Course c = new Course("ASDN","Lucia Vacariu",1);
		CourseDAO cd = new CourseDAO();
		cd.update(1,c);
		assertEquals("ASDN",cd.getById(1).getName());
	}

	@Test
	public void testDelete() {
		CourseDAO cd = new CourseDAO();
		cd.delete(10);
		assertNull(cd.getById(10).getName());
	}

	@Test
	public void testGetById() {
		CourseDAO cd = new CourseDAO();
		assertEquals("ASDN",cd.getById(1).getName());
	}

}
