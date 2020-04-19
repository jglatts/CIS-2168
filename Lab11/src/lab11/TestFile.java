/**
 * Generates a test file with random values
 */
package lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class TestFile {
    
    private static File f;
    private static PrintStream p;
    private static Random rand;
    private static int n;
    
    public static String makeTestFile(String s, int size) throws FileNotFoundException {
        f = new File(s + ".txt");
        n = size;
        writeToFile(f);
        return s + ".txt";
    }
    
    private static  void writeToFile(File f) throws FileNotFoundException{
        p = new PrintStream(f);
        rand = new Random();
        p.println(n);
        for (int i = 0; i < n; ++i) {
            p.print((rand.nextInt(300)+1) + " ");
        }
        p.close();
    }
    
}
