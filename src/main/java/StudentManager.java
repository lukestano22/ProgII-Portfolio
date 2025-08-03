import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Student> students = new LinkedList<>();

        System.out.println("Enter student data. Type 'done' when finished.");

        while (true) {
            System.out.print("Enter name (or 'done'): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            double gpa = -1;
            while (true) {
                System.out.print("Enter GPA (0.0 - 4.0): ");
                try {
                    gpa = Double.parseDouble(scanner.nextLine());
                    if (gpa < 0.0 || gpa > 4.0) {
                        System.out.println("GPA must be between 0.0 and 4.0.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            Student student = new Student(name, address, gpa);
            students.add(student);
            System.out.println("Student added.\n");
        }

        // Sort students by name
        Collections.sort(students);

        // Output to text file
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            System.out.println("\nStudent data saved to students.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}
