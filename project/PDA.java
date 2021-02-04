/**PDAs contain three attributes:
 * states : which is the grammar that is considered while writing this project
 * input string: which is provided im Main Class and will be given to PAD's methods
 * Stack: which the Class is implemented and the object is constructed here*/
public class PDA {

    private MyStack stack;

    PDA(){
        stack = new MyStack();
    }

    /**just 0 and 1 is allowed is stack. we consider a as 0 and b as 1*/
    public boolean textMatchGrammar(String text){ //text includes a and b

        char[] ab = text.toCharArray();
        boolean isMatch = true;

        for (int i = 0; i<ab.length; ++i) {

            if (stack.isEmpty() && i == ab.length-1) { //if there is any extra closed parentheses
                isMatch = false;
                System.out.println(i);
                break;
            }

            if (ab[i] == 'a')
                stack.push(0);
            else stack.pop();
        }

        if (!stack.isEmpty()) //if there any extra opened parentheses
            isMatch = false;

        return isMatch;
    }

    /**this method find the equivalent text with the special format which is possible to check it with the grammar of PDA
     * therefore this method put letter a for each "(" and letter b for each ")"*/
    public StringBuilder arithmeticToText(String arithmetic){
        StringBuilder text = new StringBuilder();

        for (char ch:arithmetic.toCharArray()) {
            if (ch == '(')
                text.append("a");
            else if (ch == ')')
                text.append("b");
        }
        return text;
    }

    /**this method will be called when the textMatchGrammar method returns false in the Main Class
     * therefore we are sure that the text does Not match the grammar of the PDA so we dont check it again
     * and we just review the stack to see in what state it is*/
    public String notMatchReason(String text){
        if (stack.isEmpty())
            return "there is extra unopened closed parentheses [)] in the string";
        else
            return "there is extra opened unclosed parentheses [(] in the string";
    }

}
