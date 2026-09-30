package week_4_lab;


public class StudentDriver {
    public static void main(String[] args) {
        StudentRecord student1 = new StudentRecord("Alice");
        StudentRecord student2 = new StudentRecord("Bob");

        student1.addGrade(80);
        student1.addGrade(90);
        student1.addGrade(75);
        student1.addGrade(45);

        student2.addGrade(100);
        student2.addGrade(60);
        student2.addGrade(30);

        student1.printReport();
        student2.printReport();

        student1.removeFailingGrades();
        student2.removeFailingGrades();

        System.out.println("After removing failing grades:");
        student1.printReport();
        student2.printReport();
    }
}