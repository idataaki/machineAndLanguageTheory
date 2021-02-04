/**TITLE: project one
 * SUBJECT: Theory of Languages and Machines
 * PROVIDER: Zahra Taki
 * provided in 21st of June*/
import java.util.Scanner;

public class Main {
//////////////////////////////////////fix strings///////////////////////////////////////////////////////////////////////
    private static final String MENU = "options:\n1.input a string including a and b.\n2.input an arithmetic expression.\n3.Exit!";
    private static final String EQUIVALENT = "the equivalent string is:\n";
    private static final String MATCH = "[this grammar produces this string]";
    private static final String NOT_MATCH = "[this grammar does't produce this string]";
    /////////////////////////////////Class Attribute////////////////////////////////////////////////////////////////////
    private static Scanner input = new Scanner(System.in);
    private static PDA pda;

    public static void main(String[] args) {

        boolean exit = false;        //a flag for exiting the program

        String ABexpression;         //string including a and b
        String ArithmeticExpression; //string including operation and operand
        String output = "nothing yet!";               //output of the whole program
        String extraOutput = "nothing yet!";     //output for special cases

        while (!exit){
            pda = new PDA();
            System.out.println(MENU); //show the options for the costumer

            switch (input.nextInt()) {
                case 1: //the case we want to test a string including a and b
                    ABexpression = input.next();
                    output = pda.textMatchGrammar(ABexpression) ? MATCH : NOT_MATCH; //does text matches grammar or no?

                    ////////////////OUTPUT/////////////////////////////////////////////////////
                    System.out.println(output);
                    break;
                case 2: //the case we want to test a arithmetic string
                    ArithmeticExpression = input.next();
                    String text = String.valueOf(pda.arithmeticToText(ArithmeticExpression));
                    output = EQUIVALENT + text;
                    extraOutput = pda.textMatchGrammar(text) ? MATCH : pda.notMatchReason(text);

                    //////////////OUTPUT//////////////////////////////////////////////////////
                    System.out.println(output);
                    System.out.println(extraOutput);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }

    }

}
