import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestStudent {

	//text fixture
	Student student;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		grades.add(9);
		grades.add(10);
		grades.add(9);
		
		student = new Student("Gigel", 20, grades);
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGetgrades() {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		grades.add(10);
		grades.add(8);
		grades.add(5);
		
		student.setGrades(grades);
		ArrayList<Integer> actual = student.getGrades();
		
		assertEquals(grades, actual);
	}
	
	@Test(expected = InvalidAge.class)
	public void testSetInvalidAge() throws Exception
	{
		student.setAge(-1);
	}
	
	@Test
	public void testSetGetage()
	{
		int expectedAge = 35;
		try {
			student.setAge(35);
		} catch (Exception e) {
			fail("Setter exception");
		}
		int age = student.getAge();
		
	}
	
	@Test
	public void testSetGetname() {
		String expectedName = "testName";
		student.setName(expectedName);
		String name = student.getName();
		
		assertEquals(expectedName, name);
	}
	
	@Test
	public void testGetAverageCorrectValues() {
		
		float expectedValue = 9.33f;
		float actualValue = student.getAverage();
		
		assertEquals("Incorrect average for correct values",
				expectedValue, actualValue, 0.005);
	}
	
	@Test
	public void testGetAverageListWithoutGrades() {
		
		ArrayList<Integer> grades = new ArrayList<Integer>();
		student.setGrades(grades);
		
		float expectedValue = 0;
		
		float average= student.getAverage();
		assertEquals("Student has no grades", expectedValue , average, 0);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testGetAverageNullList() {
		ArrayList<Integer> grades = null;
		student.setGrades(grades);
		float average = student.getAverage();
	}
	
}
