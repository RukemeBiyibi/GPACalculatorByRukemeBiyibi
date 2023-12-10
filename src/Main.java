import java.util.Scanner;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input;
        int index = 0;
        int unit = 0;
        double score = 0;
        int noOfCourses;
        System.out.print("How many courses did you take this semester?\n");
        input = new Scanner(System.in);

            while (true) {
                try {
                    noOfCourses = input.nextInt();
                    if (noOfCourses < 0) {
                        System.out.print("Input a value greater than 0: ");
                    } else if (noOfCourses == 0) {
                        System.out.println("Thank you for using this app!");
                        System.exit(0);
                    } else {
                        break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid input. Input an integer: ");
                    input.next();
                }
            }

            CourseInputs[] data = new CourseInputs[noOfCourses];

            try {
                while (index < noOfCourses) {
                    CourseInputs course = new CourseInputs();
                    input = new Scanner(System.in);
                    System.out.printf("Course: %d\nInput the course %d code: ", index + 1, index + 1);
                    course.setCourseCode(input.nextLine());
                    System.out.print("Input the course unit: ");

                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            unit = input.nextInt();
                            if (unit < 0) {
                                System.out.print("Input a value greater than 0: ");
                            } else {
                                course.setCourseUnit(unit);
                                break;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.print("Invalid input. Input a valid integer for course unit: ");
                            input.next();
                        }
                    }

                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            System.out.print("Input your score(/100): ");
                            score = input.nextInt();
                            if (score < 0 || score > 100) {
                                System.out.print("Input a value greater than or equal to 0 and less than 100: ");
                            } else {
                                course.setScore(score);
                                break;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input. Input a valid input for score.");
                            input.next();
                        }
                    }
                    data[index] = course;
                    index++;
                }
            } catch (InputMismatchException ex) {
                System.out.println("You have inputted an invalid value. Re-input details for the course.");
            }
            Print print = new Print();
            print.printTable(data);
    }

    public static class Print {
        public void printTable(CourseInputs [] data) {
            System.out.println("\nRukeme's GPA Calculator\n");
            System.out.println("|---------------|-------------|-------|------------|");
            System.out.printf("| %13s | %11s | %5s | %10s |\n", "COURSE CODE", "COURSE UNIT", "GRADE", "GRADE-UNIT");
            System.out.println("|---------------|-------------|-------|------------|");
            for (CourseInputs course: data) {
                System.out.printf("| %-13s | %-11d | %-5s | %-10d |\n", course.getCourseCode(), course.getCourseUnit(), course.getGrade(), course.getGradeUnit());
            }
            System.out.println("|--------------------------------------------------|\n");
            AverageFunction calculator = new AverageFunction();
            System.out.printf("Your GPA = %.2f to two decimal places", calculator.Average(data));
        }
    }
}