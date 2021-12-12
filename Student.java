import java.util.ArrayList;

public class Student {
	String name;
	int age;
	ArrayList<Integer> grades;
	public Student(String name, int age, ArrayList<Integer> grades) {
		super();
		this.name = name;
		this.age = age;
		this.grades = new ArrayList<Integer>();
		for(Integer n : grades)
		{
			this.grades.add(n);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if(age < 0) {
			throw new InvalidAge();
		}
		this.age = age;
	}
	public ArrayList<Integer> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<Integer> grades) {
		if(grades == null) {
			throw new UnsupportedOperationException();
		}
		
		this.grades = new ArrayList<Integer>();
		for (Integer n : grades) {
			this.grades.add(n);	
		}
	}
	
	public float getAverage() {
		if(this.grades.size() > 0) {
			float suma = 0;
			for(int nota : this.grades) {
				suma += nota;
			}
			return suma/this.grades.size();
		}
		else {
			return 0;
		}
		
	}
	
}
