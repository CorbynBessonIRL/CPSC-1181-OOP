
import java.util.Scanner;

public class StudentTest {

	public static Student[] GenerateStudentArray(int numStudents) {
		// stub method
		Student[] s = new Student[numStudents];
		for (int i = 0; i < numStudents; i++) {
			s[i] = new Student();
		}

		return s;
	}

	public static void InputInfo(Student[] students) {
		Scanner s = new Scanner(System.in);

		String name;
		int id;
		double gpa;

		for (int i = 0; i < students.length; i++) {
			System.out.println("name:");
			name = s.nextLine();

			System.out.println("ID:");
			id = s.nextInt();

			System.out.println("GPA:");
			gpa = s.nextDouble();

			s.nextLine();

			students[i].SetName(name);
			students[i].SetStudentID(id);
			students[i].SetGPA(gpa);

		}
		s.close();
		return;
	}

	public static void OutputInfo(Student[] students) {

		double maxGpa = students[0].GetGPA();
		int maxStd = 0;
		double sumGpa = students[0].GetGPA();

		for (int i = 1; i < students.length; i++) {
			double tmpGpa = students[i].GetGPA();

			// sumGpa +=

			if (tmpGpa > maxGpa) {
				maxGpa = tmpGpa;
				maxStd = i;
			}
		}

		System.out.println(students[maxStd].GetName());
		System.out.println(students[maxStd].GetStudentID());
		System.out.println(students[maxStd].GetGPA());

	}

	public static void Display(Student[] students) {
		System.out.println("Student Info:");
		for (int i = 0; i < students.length; i++) {
			// System.out.println((i+1) + "Name: "+ students[i].GetName() +", ID:" +
			// students[i].GetStudentID()+",GPA: " + student[i].GetGPA());
			students[i].Print();
		}
	}

	public static void main(String[] args) {

		int n = 3; // number of students

		Student[] students = GenerateStudentArray(n);

		InputInfo(students);

		Display(students);

		// TODO Auto-generated method stub
		Student s = new Student();

		s.Print();

		Student s2 = new Student("Bob", 1234, 4.0);
		s2.Print();

		s2.SetGPA(3.8);

		s2.Print();

		System.out.println(s.GetName());

	}

}
