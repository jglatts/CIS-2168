package lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class MakeTestGraph {
    
    // generate a test file containing graph with n nodes and e edges
    public static String generate(String s, int n, int e) {
        try {
            printToFile(new PrintStream(new File(s)), n, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MakeTestGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "\nGenerated Test Graph @" + s;
    }
    
    private static void printToFile(PrintStream p, int n, int e)  {
        Random rand = new Random();
        // print number of nodes and edges assoc. with this graph
        p.println(n);
        p.println(e);
        // generate edges
        for (int i = 0; i < e; ++i) {
            int r = rand.nextInt(e) + 1;
            int x = rand.nextInt(e) + 1;
            p.println(r + " " + x);
        }
        // generate source and terminal node
        int r = rand.nextInt(e) + 1;
        int x = rand.nextInt(e) + 1;
        p.println(r + " " + x);       
        p.close();
    }    
    
    // generate a test file containing graph with n nodes and e edges
    // includes w weights
    public static String generate(String s, int n, int e, int w) {
        try {
            printToFile(new PrintStream(new File(s)), n, e, w);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MakeTestGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "\nGenerated Test Graph @" + s;
    }    
    
    private static void printToFile(PrintStream p, int n, int e, int w)  {
        Random rand = new Random();
        p.println(n);
        p.println(e);
        for (int i = 0; i < e; ++i) {
            int r = rand.nextInt(e) + 1;
            int x = rand.nextInt(e) + 1;
            int k = rand.nextInt(w) + 1;
            p.println(r + " " + x + " " + k);
        }
        int r = rand.nextInt(e) + 1;
        int x = rand.nextInt(e) + 1;
        p.println(r + " " + x);       
        p.close();
    }
    
}
