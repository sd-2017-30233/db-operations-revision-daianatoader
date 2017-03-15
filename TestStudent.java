import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {

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
		Student s = new Student("Pop Maria","11.02.1994","Sibiu");
		StudentDAO sd = new StudentDAO();
		sd.add(s);
		assertEquals("Pop Maria",sd.getByName("Pop Maria").getName());
	}

	@Test
	public void testUpdate() {
		Student c = new Student("Pop Maria","11.02.1994","Sibiu");
		StudentDAO sd = new StudentDAO();
		sd.update(1,c);
		assertEquals("Pop Maria",sd.getById(1).getName());
	}

	@Test
	public void testDelete() {
		StudentDAO sd = new StudentDAO();
		sd.delete(10);
		assertNull(sd.getById(10));
	}

	@Test
	public void testGetById() {
		StudentDAO sd = new StudentDAO();
		assertEquals("Pop Maria",sd.getById(1).getName());
	}

}
