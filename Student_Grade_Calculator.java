import java.util.Scanner;

public class Student_Grade_Calculator {

    public static void calculateStudentGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects:");
        int num = sc.nextInt();
        int totalmark = 0;
        for (int i = 1; i <= num; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                i--;
                continue;
            }
            totalmark += marks;
        }
        double avgpc = (double) totalmark / num;
        char grade;
        if (avgpc >= 90) {
            grade = 'A';
        } else if (avgpc >= 80) {
            grade = 'B';
        } else if (avgpc >= 70) {
            grade = 'C';
        } else if (avgpc >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Results:");
        System.out.println("Total Marks: " + totalmark);
        System.out.println("Average Percentage: " + avgpc + "%");
        System.out.println("Grade: " + grade);
    }
    public static void main(String[] args) {
        calculateStudentGrade();
    }
}

