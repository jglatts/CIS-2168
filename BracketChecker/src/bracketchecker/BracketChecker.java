package bracketchecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    char type;
    int position;
    
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

}

class BracketChecker {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        Bracket opening_bracket = null;
        Boolean check = true;
        String message = "";
        System.out.print("Input: " );
        String text = reader.readLine();
        
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(new Bracket(next, position));
            }
            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (!opening_brackets_stack.isEmpty()) 
                    opening_bracket = opening_brackets_stack.pop();
                else {
                    // Etack is empty, so no closing bracket
                    // Exit loop and display position
                    message = "" + (position+1);
                    break;                
                }
                if (!opening_bracket.Match(next)) {
                    // Opening bracket doesn't equal closing bracket
                    // Exit loop and display position
                    message = "" + (position+1);
                    check = false;
                    break;
                } 
                // If we made it here,
                // both opening bracket and closing bracket match 
                else message = "Success";  
            }
        }
        // Check if there are any elements left in stack 
        // If check == true, the opening bracket has no closing bracket
        // Else , the opening bracket has a closing bracket, so don't display the message 
        if (!opening_brackets_stack.isEmpty() && check) 
            message = "" + (opening_brackets_stack.pop().position+1);
        
        // Printing answer, write your code here
        System.out.println("\n" + message);
    }
    
}
    
