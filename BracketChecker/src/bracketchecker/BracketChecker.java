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

// working, but need to cut the time in HALF

class BracketChecker {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        Bracket openingBracket = null, b = null;
        int open_bracket_count = 0, closed_bracket_count = 0; 
        String message = "";
        System.out.print("Input: ");
        String text = reader.readLine();
        
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                openingBracket = processOpeningBracket(opening_brackets_stack, next, position);
                open_bracket_count++;
            }
            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                closed_bracket_count++;
                if (opening_brackets_stack.size() > 0) b = opening_brackets_stack.pop();
                if (openingBracket == null) {
                    message = "" + 1;
                    break;
                }
                else 
                    if (processClosingBracket(b, next, position, message)) break;
                    else message = "Success";
            }
            if (open_bracket_count != closed_bracket_count) message = "" + (position+1);
        }
        // Printing answer, write your code here
        System.out.println("\n" + message);
    }
    
    public static Bracket processOpeningBracket(Stack<Bracket> stack, char next, int position) {
        Bracket openingBracket = new Bracket(next, position);
        stack.push(openingBracket);
        return openingBracket;
    }
    
    public static boolean processClosingBracket(Bracket b, char next, int position, String message) {
        if (!b.Match(next)) {
            message = "" + (position+1); // fix this off-by-one error
            return true;        
        }
        return false;
    }
    
}
    