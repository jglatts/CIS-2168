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
    String lines = getPageLines(br);
    System.out.println(getFiveLines(lines));
  }
  
  /**
   * Read all the lines from the web-page. Can prolly change it to read 5
   * 
   * @param br, the BufferedReader object containing the InputStreamReader
   * @return a String containing all the lines from web-page. 
   * @throws IOException 
   */
  public static String getPageLines(BufferedReader br) throws IOException { 
      String allLines = "";
      boolean check = false;
      
      do {
        String line = br.readLine();
        if (line != null) 
            allLines += line + "\n";
        else 
            check = true;
      } while (!check);    
      
      return allLines;
  }
  
  /**
   * Return the first 5 lines from the web-page
   * 
   * @param s, all the lines from the web-page
   * @return a string containing the first 5 lines of web-page
   */
  public static String getFiveLines(String s) {
    String outPut = "";  
    String[] strArr = s.split("\n");
    
    // change this to get 5 lines, won't be a for-each loop
    for (String i : strArr) {
        if (i.contains("</p>") || i.contains("</li>"))
            outPut += i + "\n";
    }
    
    return outPut;
  }
}
