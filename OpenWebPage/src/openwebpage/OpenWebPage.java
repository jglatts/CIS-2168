package openwebpage;

import java.net.*;
import java.io.*;

/**  This class provides a main function to read five lines of a company
 *   Web page and prints them in reverse order, given the name of a company.
 */
class OpenWebPage {

//   Prompts the user for the name X of a company (a single string), opens
//   the Web site corresponding to www.X.com, and prints the first five lines
//   of the Web page in reverse order.
  public static void main(String[] arg) throws Exception {

    BufferedReader keyoabrd;
    String inputLine;

    keyoabrd = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        // Make sure the line is printed immediately. 
    inputLine = keyoabrd.readLine();

    // YOUR CODE HERE
    URL url = new URL("https://www." + inputLine + ".com");
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    printLines(getPageLines(br));
  }
  
  /**
   * Read all the lines from the web-page. Can prolly change it to read 5
   * 
   * @param br, the BufferedReader object containing the InputStreamReader
   * @return a String containing all the lines from web-page. 
   * @throws IOException 
   */
  public static String[] getPageLines(BufferedReader br) throws IOException { 
      String[] allLines = new String[5];
      
      for (int i = 0; i < 5; ++i) {
        String line = br.readLine();
        if (line != null) allLines[i] = line + "\n";          
      }
      
      return allLines;
  }
    
  /**
   * Print the first five lines of web-page in reverse order
   * 
   * @param strArr, the String array containing the five lines
   */
  public static void printLines(String[] strArr) {
      for (int i = 4; i >= 0; --i) {
        System.out.println(strArr[i]);
    }
  }
  
}
