package BudgetBuddy;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // important classes
        SignUp[] SU = new SignUp[100];
        Scanner sc = new Scanner(System.in);

        // variables
        int userchoice;
        int passiveUsers = 0;

        do {

            System.out.println("Enter 1 for Login");
            System.out.println("Enter 2 for SignUp");
            System.out.println("Enter 3 To Exit");
            System.out.print("Enter Number :");
            userchoice = sc.nextInt();

            // switch case
            switch (userchoice) {
                case 1:
                    // login
                    break;
                case 2:
                    for (int i = passiveUsers; i <= passiveUsers && i < SU.length; i++) {
                        SU[passiveUsers] = new SignUp();
                        SU[passiveUsers].getDetails();
                    }
                    passiveUsers++;
                    break;
                case 3:
                    // exit
                    break;

                default:
                    System.out.println("\nERROR Press from 1 to 3");
                    sc.nextLine();
                    System.out.print("\nPress Enter To Continue...");
                    sc.nextLine();
                    break;
            }

        } while (userchoice != 3);
    }

}

class SignUp {

    // variables
    String firstName;
    String lastName;
    String mobileNumber;
    String PassKey;
    String SecurityQuestionDisplay;
    String SecurityAnswer;

    // classes
    Scanner sc = new Scanner(System.in);

    void getDetails() {
        boolean flag; // to validate Mobile Number...

        System.out.print("Enter First Name: ");
        firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();

        // loop for mobile number...
        do {
            flag = true;
            System.out.print("Enter Mobile Number: ");
            mobileNumber = sc.nextLine();

            if (mobileNumber.length() != 10) { // to validate length
                flag = false;
                System.out.println("Number should be of 10 digit!!!\n");
            }
            for (int i = 0; i < mobileNumber.length(); i++) { // to validate number is an integers
                if (mobileNumber.charAt(i) < '0' || mobileNumber.charAt(i) > '9') {
                    flag = false;
                    System.out.println("Number Should Not contain Alpabetical Characters!!!\n");
                    break;
                }
            }
        } while (!flag);

        // loop for Pin...
        do {
            flag = true;
            System.out.print("Enter 4 Digit Security Pin: ");
            PassKey = sc.nextLine();

            if (PassKey.length() != 4) {
                flag = false;
                System.out.println("Pin should be of 4 digit!!!\n");
            }

            for (int i = 0; i < PassKey.length(); i++) { // to validate Pin is an integer
                if (PassKey.charAt(i) < '0' || PassKey.charAt(i) > '9') {
                    flag = false;
                    System.out.println("Pin Should Not contain Alpabetical Characters!!!\n");
                    break;
                }
            }
        } while (!flag);

        //securtity question
        System.out.println("Worried! Of Forgetting Pin");
        System.out.println("Just SetUp a Security Question And Enjoy\n");
        System.out.println("Press 1 for ---> Who is Your Favourite Teacher?");
        System.out.println("Press 2 for ---> What is Your Favourite Food?");
        System.out.println("Press 3 for ---> Which is Your Favourite Pet?");

        int QuestionNumber = sc.nextInt();
        sc.nextLine();

        switch (QuestionNumber) {
            case 1:
                SecurityQuestionDisplay = "Who is Your Favourite Teacher?";
                System.out.print("Enter His Name: ");
                SecurityAnswer = sc.nextLine();
                break;
            case 2:
                SecurityQuestionDisplay = "What is Your Favourite Food?";
                System.out.print("Enter Name Of Fruit : ");
                SecurityAnswer = sc.nextLine();
                System.out.println("\nSound's Delicious!\n");
                break;
            case 3:
                SecurityQuestionDisplay = "Which is Your Favourite Pet?";
                System.out.print("Enter Name Of Animal : ");
                SecurityAnswer = sc.nextLine();
                System.out.println("\nAwesome! You've chosen the best animal on the planet!\n");
                break;
            default:
                System.out.println("\nERROR Press from 1 to 3");
                sc.nextLine();
                System.out.print("\nPress Enter To Continue...");
                sc.nextLine();
                break;
        }

    }

}
