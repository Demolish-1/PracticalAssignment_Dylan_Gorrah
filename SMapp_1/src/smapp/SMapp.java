// Dylan Gorrah ST10398445
package smapp;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SMapp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDatabase database = new StudentDatabase();
// runs first
    public static void main(String[] args) {
        welcomeMessage();
        LaunchWith1();
    }
// prints welcome
    public static void welcomeMessage() {
    System.out.println("----------------------------------------------");
    System.out.println("STUDENT MANAGEMENT APPLICATION");
    System.out.println("----------------------------------------------");
    System.out.println("Enter (1) to launch menu or press any button to exit.");
}
public static void LaunchWith1() {
    try {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (choice == 1) {
            menu();
        } else {
            System.out.println("Goodbye!");
            scanner.close();
            System.exit(0);
        }
    } catch (InputMismatchException e) {
        System.out.println("Goodbye!");
        scanner.close();
        System.exit(0);
    }

} // prints menu
public static void menu() {
    System.out.println();
    System.out.println("Please select one of the following menu items:");
    System.out.println("----------------------------------------------");
    System.out.println("(1)  Capture new Student.");
    System.out.println("(2)  Search for a student.  ");
    System.out.println("(3)  Delete a student. ");
    System.out.println("(4)  Print student Report. ");
    System.out.println("(5)  Exit Application. ");
    System.out.println("----------------------------------------------");

    int selection;
    while (true) {
        try {
            selection = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (selection < 1 || selection > 5) {
                System.out.println("Invalid selection. Please try again.");
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
    }

    switch (selection) {
        case 1:
            CaptureStudent(); //saves user input of student details
            break;
        case 2:
            searchStudent(); // serches student by student number
            break;
        case 3: 
               deleteStudent(); // delete student
                
            break;
        case 4:
            Report(); // Print student Report
            
            break;
        case 5:
            Timer timer = new Timer();
            System.out.println("Exiting application in 4 seconds. Goodbye!");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    scanner.close();
                    System.exit(0); // when ever you pres [ 5 ] the program will always close.
                }
            }, 4000); // 4000 milliseconds = 4 seconds
            break;
    }

    }

   public static void CaptureStudent() {
    System.out.println("----------------------------------------------");
    System.out.println("Student Registration");
    System.out.println("----------------------------------------------");

    try {// enter name with format checking
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim(); // trim spaces
        while (name.isEmpty() || name.matches(".*\\s+.*")) {
            System.out.println("Invalid input. Please enter a name without extra spaces.");
            System.out.print("Enter name: ");
            name = scanner.nextLine().trim();
        }
        name = capitalize(name); // auto capitalize

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine().trim(); // trim spaces
        while (surname.isEmpty() || surname.matches(".*\\s+.*")) {
            System.out.println("Invalid input. Please enter a surname without extra spaces.");
            System.out.print("Enter surname: ");
            surname = scanner.nextLine().trim();
        }
        surname = capitalize(surname); // auto capitalize



        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim(); // trim spaces
        while (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter a valid email address.");
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();
        }
        
        email = email.substring(0, 1).toLowerCase() + email.substring(1); // auto small letter the first letter

        System.out.print("Enter student course: ");
        String course = scanner.nextLine().trim(); // trim spaces
        while (course.isEmpty() || course.matches(".*\\s+.*")) {
            System.out.println("Invalid input. Please enter a course without extra spaces.");
            System.out.print("Enter student course: ");
            course = scanner.nextLine().trim();
        }

int age;// ensure numerical variable is inputted
    while (true) {
        System.out.println("Enter student's age:");
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            if (age >= 17) {// ages must be equal or above age limit
                break;
            } else {
                System.out.println("You have entered an incorrect student age!!! Please re-enter age:");// ensures users corrects their input variables
            }
        } else {
            System.out.println("Invalid input. Please enter a valid age.");
            scanner.next(); // Clear invalid input
        }
    }
        int studentNumber = (int) (Math.random() * 90000) + 10000; // generate a random 5-digit number

        Student student = new Student(name, surname, age, email, course, studentNumber);
        database.addStudent(student);
System.out.println("Welcome " + name + " " + surname + studentNumber);
System.out.println("Please remember to write down or remember your student number (" + studentNumber + ")");
System.out.println("press (1) to continue");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid choice.");
            scanner.next(); // clear invalid input
            System.out.println("press (1) to continue");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        while (true) {
            if (choice == 1) {
                menu();
            } else {
                System.out.println("Exiting application. Goodbye!");
                scanner.close();
                break;
            }
        }
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        scanner.close();
        System.exit(1); // exit the application
    }
}

// Method to validate email format
private static boolean isValidEmail(String email) {
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPattern.matcher(email);
    return matcher.find();
}


// Method to capitalize the first letter of a string
private static String capitalize(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
}

 public static void searchStudent() {
    try {
        System.out.print("Enter student number: ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Student student = database.searchStudent(studentNumber);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + student.getName());
            System.out.println("Surname: " + student.getSurname());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
        } else {
            System.out.println("Student not found.");
        }

        while (true) {
            System.out.println("Press (1) to continue or any other key to exit.");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 1) {
                menu();
                break;
            } else {
                System.out.println("Invalid input. Please enter 1 to continue.");
            }
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.next(); // Consume invalid input
        searchStudent(); // Call the method again
    }

}


public static void Report() {
    database.printReport();
    System.out.println("press (1) to continue, anything els to return to menu");

    try {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        while (true) {
            if (choice == 1) {
                menu();
            } else {
                System.out.println("Invalid selection. Please try again.");
                Report(); // launch menu
                break;
            }
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.next(); // Consume invalid input
        menu(); // Call the method again
    }
}


public static void deleteStudent() {
    System.out.print("Enter student number: ");
    int studentNumber = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    if (database.getStudents().containsKey(studentNumber)) {
        database.removeStudent(studentNumber);
        System.out.println("Student deleted successfully.");
    } else {
        System.out.println("Student not found.");
    }

    System.out.println("press (1) to continue");

    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    while (true) {
        if (choice == 1) {
            menu();
        } else {
            System.out.println("Exiting application. Goodbye!");
            scanner.close();
            break;
        }
    }
    }
}











