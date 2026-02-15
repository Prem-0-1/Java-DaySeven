import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
        System.out.println("------------------------");
    }
}

class GradeManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                student.displayStudentDetails();
            }
        }
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {

        GradeManager manager = new GradeManager();

        Student s1 = new Student("Rahul");
        Student s2 = new Student("Sneha");

        manager.addStudent(s1);
        manager.addStudent(s2);

        s1.addGrade(85);
        s1.addGrade(90);
        s1.addGrade(88);

        s2.addGrade(75);
        s2.addGrade(80);
        s2.addGrade(70);

        System.out.println("\nAll Students:");
        manager.displayAllStudents();

        System.out.println("\nSearching for Rahul:");
        Student found = manager.findStudentByName("Rahul");
        if (found != null) {
            found.displayStudentDetails();
        } else {
            System.out.println("Student not found.");
        }
    }
}
