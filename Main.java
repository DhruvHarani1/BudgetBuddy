package BudgetBuddy;

import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // important classes
        SignUp[] SU = new SignUp[100];
        Scanner sc = new Scanner(System.in);
        Login L = new Login();
        MainPage MP = new MainPage();

        // variables
        int userchoice;
        int passiveUsers = 0;

        do {

            System.out.println("Enter 1 for SignUp");
            System.out.println("Enter 2 for Login");
            System.out.println("Enter 3 To Exit");
            System.out.print("Enter Number :");
            userchoice = sc.nextInt();

            // switch case
            switch (userchoice) {
                case 1:
                    for (int i = passiveUsers; i <= passiveUsers && i < SU.length; i++) {
                        SU[passiveUsers] = new SignUp();
                        SU[passiveUsers].getDetails(SU, passiveUsers);
                    }
                    passiveUsers++;
                    break;
                case 2:
                    int logedUser = L.getLoginDetails(SU, passiveUsers);
                    MP.mainpage(SU[logedUser]);
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
    long Balance = 0;
    int expenseCount = 0;
    int incomeCount = 0;
    Expense[] EP = new Expense[1000];
    Income[] IC = new Income[1000];

    // classes
    Scanner sc = new Scanner(System.in);

    // method for getting user details
    void getDetails(SignUp[] SU, int passiveUsers) {

        // variables
        boolean flag; // to validate if user already exist or not

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

            for (int i = 0; i < passiveUsers; i++) { // to validate if user already login
                if (mobileNumber.equals(SU[i].mobileNumber)) {
                    flag = false;
                    System.out.println("User already exists! Please go to login.");
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

        // securtity question
        System.out.println("Worried! Of Forgetting Pin");
        System.out.println("Just SetUp a Security Question And Enjoy\n");

        do {

            flag = true;
            System.out.println("Press 1 for ---> Who is Your Favourite Teacher?");
            System.out.println("Press 2 for ---> What is Your Favourite Fruit?");
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
                    SecurityQuestionDisplay = "What is Your Favourite Fruit?";
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
                    flag = false;
                    System.out.print("\nPress Enter To Continue...");
                    sc.nextLine();
                    break;
            }
        } while (!flag);
    }
}

class Login {

    // classes
    Scanner sc = new Scanner(System.in);

    // variables
    String loginMobileNumber;
    String loginPassKey;

    int getLoginDetails(SignUp[] SU, int passiveUsers) {

        // variables
        boolean flag = false;
        int i;

        do {
            System.out.print("Enter Mobile Number: ");
            loginMobileNumber = sc.nextLine();

            for (i = 0; i <= passiveUsers; i++) {

                if (loginMobileNumber.equals(SU[i].mobileNumber)) {
                    System.out.print("Enter Pin: ");
                    loginPassKey = sc.nextLine();
                    for (int j = 0; j <= passiveUsers; j++) {
                        if (loginPassKey.equals(SU[i].PassKey)) {
                            flag = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if (!flag) {
                System.out.println("\nInvalid Mobile number or PIN Retry!!!");
            }
        } while (!flag);
        return i;
    }
}

class MainPage {

    // classes
    Scanner sc = new Scanner(System.in);

    void mainpage(SignUp SU) {

        // variables
        int userinput;

        do {
            System.out.println("Enter 1) for Expense");
            System.out.println("Enter 2) for Income");
            System.out.println("Enter 3) for Exit");
            System.out.print("Enter Number: ");
            userinput = sc.nextInt();

            switch (userinput) {
                case 1:
                    for (int i = SU.expenseCount; i <= SU.expenseCount; i++) {
                        SU.EP[i] = new Expense();
                        SU.EP[i].expenseCalculator(SU);
                    }
                    SU.expenseCount++;
                    break;
                case 2:
                    for (int i = SU.incomeCount; i <= SU.incomeCount; i++) {
                        SU.IC[i] = new Income();
                        SU.IC[i].incomeCalculator(SU);
                    }
                    SU.incomeCount++;
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
        } while (userinput != 3);
    }
}

class Expense {

    // attributes
    long expense;
    String discription;
    LocalDate date;
    String category = "";

    // classes
    Scanner sc = new Scanner(System.in);
    Category CG = new Category();

    // method to calc expense
    void expenseCalculator(SignUp SU) {

        System.out.print("ENTER Expense: ");
        expense = sc.nextLong();
        System.out.print("Enter Discription: ");
        discription = sc.next();

        // select category
        do {
            category = CG.expenseCategory();

            if (category.equals("")) {
                System.out.println("Enter A Valid number From 1 to 10.");
            }
        } while (category.equals(""));

        date = LocalDate.now();
        SU.Balance -= expense;
    }
}

class Income {

    // attributes
    long income;
    String discription;
    LocalDate date;
    String category = "";

    // classes
    Scanner sc = new Scanner(System.in);
    Category CG = new Category();

    // method to calc expense
    void incomeCalculator(SignUp SU) {

        System.out.print("ENTER Income: ");
        income = sc.nextLong();
        System.out.print("Enter Discription: ");
        discription = sc.next();

        // select category
        do {
            category = CG.incomeCategory();

            if (category.equals("")) {
                System.out.println("Enter A Valid number From 1 to 10.");
            }
        } while (category.equals(""));

        date = LocalDate.now();

        SU.Balance += income;
    }
}

class Category {

    // classes
    Scanner sc = new Scanner(System.in);

    // method for expense category
    String expenseCategory() {

        // variables
        String category;

        System.out.println("\t\t\t\tSelect Category from Below\n\n");

        System.out.println("1) Transport \t\t\t\t 2) Food");
        System.out.println("3) Medical \t\t\t\t 4) Housing");
        System.out.println("5) Shopping \t\t\t\t 6) Education");
        System.out.println("7) Personal Care\t\t8) Savings");
        System.out.println("9) Debt Payment\t\t10) Others");

        int selectedcategory = sc.nextInt();

        return switch (selectedcategory) {
            case 1 -> category = "Transort";
            case 2 -> category = "Food";
            case 3 -> category = "Medical";
            case 4 -> category = "Housing";
            case 5 -> category = "Shopping";
            case 6 -> category = "Education";
            case 7 -> category = "Personal Care";
            case 8 -> category = "Savings";
            case 9 -> category = " Debt Payment";
            case 10 -> category = "Others";
            default -> "";
        };
    }

    // method for income category
    String incomeCategory() {

        // variables
        String category;

        System.out.println("\t\t\t\tSelect Category from Below\n\n");

        System.out.println("1) Salary \t\t\t\t 2) Investment Return");
        System.out.println("3) Savings \t\t\t\t 4) Cash in Hand");
        System.out.println("5) Bank Balance \t\t\t6) UPI Wallet");
        System.out.println("7) Loans \t\t\t\t 8) Scholarships");
        System.out.println("9) FreeLancing \t\t\t\t 10) Others");

        int selectedcategory = sc.nextInt();

        return switch (selectedcategory) {
            case 1 -> category = "Salary";
            case 2 -> category = "Investment Return";
            case 3 -> category = "Savings";
            case 4 -> category = "Cash in Hand";
            case 5 -> category = "Bank Balance";
            case 6 -> category = "UPI Wallet";
            case 7 -> category = "Loans";
            case 8 -> category = "Scholarships";
            case 9 -> category = "FreeLancing";
            case 10 -> category = "Others";
            default -> "";
        };
    }
}