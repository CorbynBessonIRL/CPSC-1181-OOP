
public class Student {

	private String name;
	private int studentId;
	private double gpa;

	// default constructor (no-arg constructor)
	public Student() {
		// provide default values for data members
		name = "unknown";
		studentId = 0;
		gpa = 0.0;
	}

	// defined constructor
	public Student(String n, int id, double _gpa) {
		name = n;
		studentId = id;
		gpa = _gpa;
	}

	// getters (accessors) / setters (mutators)
	public String GetName() {
		return name;
	}

	public void SetName(String s) {
		name = s;
	}

	public int GetStudentID() {
		return studentId;
	}

	public void SetStudentID(int id) {
		if (id < 1) {
			System.out.println("ID cannot be less than 1");
			return;
		}

		studentId = id;
	}

	public double GetGPA() {
		return gpa;
	}

	public void SetGPA(double g) {
		if (g >= 0.0) {
			gpa = g;
		} else {
			System.out.println("negative gpa not allowed");
		}

	}

	// test objects
	public void Print() {
		System.out.println("Name: " + name + ", ID: " + studentId + ", GPA: " + gpa);
	}

}
