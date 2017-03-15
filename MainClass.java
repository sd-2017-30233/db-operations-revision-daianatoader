
public class MainClass {
	
	public static void main(String[] args){
		Student s1 = new Student("Popa Emiliana","23.01.1995","Turda");
		Student s2 = new Student("Pop Laura","11.07.1995","Cluj-Napoca");
		
		Course c1 = new Course("Matematica","Ioan Gavrea",1);
		Course c2 = new Course("Programare","Iosif Ignat",1);
		
		Enrollment e1 = new Enrollment(4,2);
		Enrollment e2 = new Enrollment(4,1);
		Enrollment e3 = new Enrollment(2,2);
		
		StudentDAO s = new StudentDAO();
		CourseDAO c = new CourseDAO();
		EnrollmentDAO e = new EnrollmentDAO();
		
		//ADD - Student and Course
		/*
		s.add(s1);
		s.add(s2);
		
		c.add(c1);
		c.add(c2);
		*/
		
		//UPDATE - Student and Course
		
		/*
		s.update(4, s2);
		c.update(3, c2);
		*/
		
		//DELETE - Student and Course
		
		/*
		s.delete(3);
		c.delete(3);
		*/
		
		//getByID - Student and Course
		
		/*
		s.getById(1);
		c.getById(1);
		*/
		
		//ADD Students to courses
		
		/*
		e.add(e1.getStudentId(), e1.getCourseId());
		e.add(e2.getStudentId(), e2.getCourseId());
		e.add(e3.getStudentId(), e3.getCourseId());
		*/
		
		//LIST ALL STUDENTS FROM A SPECIFIC COURSE
		
		/*
		for(int i = 0; i<e.findAll(c1.getName()).size();i++)
			System.out.println(e.findAll(c1.getName()).get(i));
		*/
	}

}
