import java.util.Scanner;       //allows the scanner utility class to run and the compiler understands it is the one defined in java.util

    public class Driver{        /*Jaim Zacharia (s3855148). class driver - this class contains the main methods 
                                and is only responsible for initiating the program*/
        public static void main (String[]args){     /*this main methods runs the program and directs the program to the corresponding 
                                                    method depending on the user's input as either calculator or lotto checker. 
                                                    It uses if statements to decide whether the user requires the 
                                                    calucaltor or lotto checker.*/

            Scanner selection = new Scanner(System.in);     //new scanner is created to intake user input
            String program_choice;
            A1 myA1 = new A1();

            System.out.println("If you wish to use the Basic Calculator, type '1'. If you wish to use the Lotto Checker, type '2'.");
                program_choice = selection.nextLine();
                    if (program_choice.equals("1")){        /*if statement that determines whether user requires calulator or lotto checker. these statements were learnt using the following text
                                                            A. Downey and C. Mayfield, "Conditionals and logic|Think Java|Trinket", Books.trinket.io, 2020. [Online]. Available: https://books.trinket.io/thinkjava2/chapter5.html. [Accessed: 26- Mar- 2020].*/
                        System.out.println("");
                        myA1.calculator_inputs();       //directs to method for calculator in A1 class
                    } else if (program_choice.equals("2")) {
                        System.out.println("");
                        myA1.lotto_inputs();        //directs to method for lotto checker in A1 class
                    } else {
                        System.out.println("The input was not correct!");
                    }
            selection.close();      //close the scanner to prevent any more inputs
        }   
    }