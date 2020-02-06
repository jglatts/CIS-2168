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
        String message = "";
        System.out.print("Input: ");
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
                Bracket opening_bracket = opening_brackets_stack.pop();
                if (!opening_bracket.Match(next)) {
                    message = "" + (position+1);
                    break;
                } 
                else message = "Success";  
            }
        }
        if (!opening_brackets_stack.isEmpty()) message = "" + text.length();
        // Printing answer, write your code here
        System.out.println("\n" + message);
    }
    

    
}
    
