/* File: CityNamesStream.java */

import java.util.*;
import java.io.*;

/**
 * This class contains three  methods: input2TextFile,
 * textFile2ObjectFile, and objectFile2output that move 
 * text from one source or file to another. They function 
 * sequentially, like a pipeline in which each method 
 * accomplishes a specific chunch of the functionality.
 * 
 * @author  I. Rahal and Andrew Nerud and Grant Peroutka
 * @version September 01, 2022
 */

public class CityNamesStream {
  
  /**
   * Reads city names, one per line, from standard input and 
   * writes them to the text file specified as parameter.
   * 
   * Stops on a line consisting of the period character, "."
   * without copying the period.
   *  
   * @param textFileName the name of the file to write to
   */
  public void input2TextFile(String textFileName) {
    Scanner scanner = new Scanner(System.in);
    
    try{
      //**** Fill in code according to lab instructions ************************
      PrintWriter pw = new PrintWriter(new File(textFileName));
      while (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        if (input.equals(".")) break;
        pw.println(input);
      }
      pw.close();
      scanner.close();
    } catch(IOException ioe){
      return;
    }
  }
  
//**** Fill in code and Javadoc for textFile2ObjectFile here according to lab instruction *****************
  public void textFile2ObjectFile(String textFileName, String objectFileName) {
    List<String> list = new ArrayList<>();
    try {
      Scanner scan = new Scanner(new File(textFileName));
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFileName));
      while(scan.hasNextLine()) {
        list.add(scan.nextLine());
      }
      oos.writeObject(list);
      oos.close();
      scan.close();
    } catch(IOException ioe){
      return;
    }
  }
//**** Fill in code and Javadoc for objectFile2Output here according to lab instruction *******************
  public void objectFile2Output(String objectFileName) {
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFileName));
      List<String> inputList = (List<String>)ois.readObject();
     
      System.out.println("List Contents: ");
      inputList.forEach(string -> System.out.println(string));
      ois.close();
    } catch(IOException | ClassNotFoundException e){
      return;
    }
  }
}  

