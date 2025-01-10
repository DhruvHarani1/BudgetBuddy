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

    // classes
    Scanner sc = new Scanner(System.in);

    void getDetails() {
        boolean mobileNum; // to validate Mobile Number...

        System.out.print("Enter First Name: ");
        firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();

        do {

            mobileNum = true;

            System.out.print("Enter Mobile Number: ");
            mobileNumber = sc.nextLine();

            if (mobileNumber.length() != 10) { // to validate length
                mobileNum = false;
                System.out.println("Number should be of 10 digit!!!\n");
            }
            for (int i = 0; i < mobileNumber.length(); i++) { // to validate integers
                if (mobileNumber.charAt(i) < '0' || mobileNumber.charAt(i) > '9') {
                    mobileNum = false;
                    System.out.println("Number Should Not contain Alpabetical Characters!!!\n");
                    break;
                }
            }
        } while (!mobileNum);

    }

}
