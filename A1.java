import java.util.Scanner;       //allows the scanner utility class to run and the compiler understands it is the one defined in java.util
import java.util.Random;        //allows random number generator class to run and the compiler knows it is the one defined in java.util
    
    public class A1{                                    /*Jaim Zacharia (s3855148). class A1 - this class contains all the program logic 
                                                        and calculations required for the program. It does not contain a main method
                                                        but various different methods that are called upon for either the calucalator
                                                        or the lotto checker*/

        public double calculator_inputs() {             /*this method acquires the inputs for the calculations by using the scanner class
                                                        and asking the user what the two numbers are and what calculation is required.
                                                        With these values stored, it calls another class which performs the calculations
                                                        depending on what operation the user has chosen. if the inputs are not positive,
                                                        the program prints an error message and terminates*/
        
            Scanner values = new Scanner(System.in);        //a new scanner is created to intake the numerical values and the operation
            double number1;
            double number2;
            int operation;

            System.out.println("What is the first number? (It must be positive)");
                number1 = values.nextDouble();
            System.out.println("What is the second number? (It must be positive)");
                number2 = values.nextDouble();
            System.out.println("To choose select an operation, type the corresponding number:");
            System.out.println("For Addition, type '0'");
            System.out.println("For Subtraction, type '1'");
            System.out.println("For Multiplication, type '2'");
            System.out.println("For Division, type '3'");
                operation = values.nextInt();

            if (number1<0 || number2<0){        //an if statement is used to conclude wheter the numbers are positive or not as asked
                System.out.println("ERROR: The numbers entered were not positive as required");
                System.exit(0);     //the program is terminated due to the numbers not being positive
            } else 
                calculate(number1, number2, operation);     //another method is called with the received inputs to process the calculations

            values.close();     //close the scanner to prevent any more inputs
            return operation;       //this method then returns the operation
        }         
    
        private double calculate(double number1, double number2, int operation) {   /*this method uses the inputs received and decides
                                                                                    on what operation the user wants to do by using if
                                                                                    statements. Once concluded, it calls upon another 
                                                                                    method which performs the specific calculation and 
                                                                                    then this method returns the answer of that calculation
                                                                                    and prints it out in the terminal*/

            if (operation == 0){        //these if statements determine which operation the user wishes to use
                A1 myA1 = new A1();
                double answer = myA1.Addition(number1, number2);        //call's to method Addition to do the calculation
                    System.out.print("The answer is ");    
                    System.out.printf("%.2f", answer);     //prints answer of the method called to 2 decimal places
            } else if (operation == 1){
                A1 myA1 = new A1();
                double answer = myA1.Subtraction(number1, number2);     //call's to method Subtraction to do the calculation
                    System.out.print("The answer is ");
                    System.out.printf("%.2f", answer);     //prints answer of the method called to 2 decimal places
            } else if (operation == 2){
                A1 myA1 = new A1();
                double answer = myA1.Multiplication(number1, number2);      //call's to method Multiplication to do the calculation
                    System.out.print("The answer is ");
                    System.out.printf("%.2f", answer);     //prints answer of the method called to 2 decimal places
            } else if (operation == 3){
                A1 myA1 = new A1();
                double answer = myA1.Division(number1, number2);        //call's to method Division to do the calculation
                    System.out.print("The answer is ");
                    System.out.printf("%.2f", answer);     //prints answer of the method called to 2 decimal places
            } else
                System.out.println("-1.0"); //Since the operation supplied is invalid, -1.0 is returned
            return operation;
        }

            public double Addition(double number1, double number2){     /*this method is used to add the two numbers the user inputted to
                                                                        calculate. it takes in the two numbers and returns the answer to
                                                                        the calculation*/
                
                double answer = number1 + number2;
                return answer;
            }
            
            public double Subtraction(double number1, double number2){      /*this method is used to subtract the two numbers the user 
                                                                            inputted to calculate. it takes in the two numbers and returns 
                                                                            the answer to the calculation*/
                
                double answer = number1 - number2;
                return answer;
            }
        
            public double Multiplication(double number1, double number2){   /*this method is used to multiply the two numbers the user 
                                                                            inputted to calculate. it takes in the two numbers and returns 
                                                                            the answer to the calculation*/
                
                double answer = number1 * number2;
                return answer;
            }
    
            public double Division(double number1, double number2){     /*this method is used to divide the two numbers the user inputted 
                                                                        to calculate. it takes in the two numbers and returns the answer
                                                                        to the calculation*/
                
                if (number2 == 0){  //if number2 was 0, the solution would be undefined so -2.0 is returned
                    return(-2.0);
                }
                double answer = number1 / number2;
                return answer;
            }   
    
    
        public void lotto_inputs() {        /*this method uses a scanner to take in three integers. these integers are then called
                                            to another method which compares it to 8 randomly generated numbers. if the 3 numbers fall
                                            outside the provided range, an error message is shown and the program is terminated. otherwise
                                            the method returns the result of the checkLotto method*/

            int chosen1;
            int chosen2;
            int chosen3;

            Scanner lotto_guess = new Scanner(System.in);      //a new scanner is created to intake the user's guessed lotto numbers
            System.out.println("This is a Lotto Checker. All your inputed lotto numbers must be within 1 to 24");
            System.out.println("What is your first guess?");
                chosen1 = lotto_guess.nextInt();
            System.out.println("What is your second guess?");
                chosen2 = lotto_guess.nextInt();
            System.out.println("What is your third guess?");
                chosen3 = lotto_guess.nextInt();
            
            lotto_guess.close();    //close the scanner to prevent any more inputs  

            if (chosen1>=24 || chosen1<=0 || chosen2>=24 || chosen2<=0 || chosen3>=24 || chosen3<=0){       /*if statement used to determine whether 
                                                                                                            the inputs fall within the required range*/
                System.out.println("ERROR: One of your input numbers fall outside the required range. Try again");
                System.exit(0);     //terminates the program since the numbers lie outside the specified range
            } else {
                checkLotto(chosen1, chosen2, chosen3);      //another method is called to compare the inputs with the random numbers
            }
        }

        private String checkLotto(int chosen1, int chosen2, int chosen3){       /*this method uses the three user inputs and compares them
                                                                                to 8 randomly generated numbers that fall between the range
                                                                                of 1 and 24. it returns the random numbers and also the user's
                                                                                guesses. it also compares the two and determines whether any
                                                                                have matches and returns a statement saying which numbers
                                                                                match and how many correct guesses were achieved by the user*/
        
        Random lotto = new Random();        //a random generator is created to create random numbers
        int lotto_1 = 1+lotto.nextInt(24);      //these next 8 lines create 8 random numbers within the range of 1-24
        int lotto_2 = 1+lotto.nextInt(24);
        int lotto_3 = 1+lotto.nextInt(24);
        int lotto_4 = 1+lotto.nextInt(24);
        int lotto_5 = 1+lotto.nextInt(24);
        int lotto_6 = 1+lotto.nextInt(24);
        int lotto_7 = 1+lotto.nextInt(24);
        int lotto_8 = 1+lotto.nextInt(24);

        System.out.println("The random lotto numbers are: " + lotto_1 + " " + lotto_2 + " " +  lotto_3 + " " +  lotto_4 + " " +  lotto_5 + " " +  lotto_6 + " " +  lotto_7 + " " +  lotto_8);
                //the above line prints out these 8 random numbers for the user to see

        int counter = 0;        //a counter is created to count how many correct guesses are achieved by the user
        String chosen1_result;
        String chosen2_result;
        String chosen3_result;
            
                //below, if statemetns are used to determine whether the guessed lotto numbers match the random numbers generated
        if (chosen1 == lotto_1 || chosen1 == lotto_2 || chosen1 == lotto_3 || chosen1 == lotto_4 || chosen1 == lotto_5 || chosen1 == lotto_6 || chosen1 == lotto_7 || chosen1 == lotto_8) {
            chosen1_result = (chosen1 + " does match");
                counter = counter + 1;      //every time there is a match, the counter increases by 1
        } else {
            chosen1_result = (chosen1 + " does not match");}
            
        if (chosen2 == lotto_1 || chosen2 == lotto_2 || chosen2 == lotto_3 || chosen2 == lotto_4 || chosen2 == lotto_5 || chosen2 == lotto_6 || chosen2 == lotto_7 || chosen2 == lotto_8) {
            chosen2_result = (chosen2 + " does match");
                counter = counter + 1;
        } else {
            chosen2_result = (chosen2 + " does not match");}
    
        if (chosen3 == lotto_1 || chosen3 == lotto_2 || chosen3 == lotto_3 || chosen3 == lotto_4 || chosen3 == lotto_5 || chosen3 == lotto_6 || chosen3 == lotto_7 || chosen3 == lotto_8) {
            chosen3_result = (chosen3 + " does match");
                counter = counter + 1;
        } else {
            chosen3_result = (chosen3 + " does not match");}
        
        String final_result = (chosen1_result + ", " + chosen2_result + ", " + chosen3_result + ". You have " + counter + " matches");
        System.out.println(final_result);    
        return final_result;        //this returns a string with the final result of the lotto guesses and the number of mathces achieved
        }
    }