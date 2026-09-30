package week_4_lab;
import java.util.ArrayList;

public class StudentRecord {
    private String studentName;
    private ArrayList<Integer> grades;

    public StudentRecord(String name) {
        studentName = name;
        grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        }
    }

    public double getAverage() {
        if (grades.size() == 0) {
            return 0;
        }

        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public int getHighestGrade() {
        if (grades.size() == 0) {
            return -1;
        }

        int highest = grades.get(0);

        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    public void removeFailingGrades() {
        grades.removeIf(grade -> grade < 50);
    }

    public void printReport() {
        System.out.println("Student: " + studentName);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f%n", getAverage());
        System.out.println("Highest: " + getHighestGrade());
        System.out.println();
    }
}
