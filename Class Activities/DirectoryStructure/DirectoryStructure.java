import java.io.*;
import javax.swing.*;
import java.util.regex.*;


public class DirectoryStructure{
  
  //Exercise 1: READ AND UNDERSTAND public version should call private version starting at 0 depth
  public void getDirectoryContents(String filePath) {
    getDirectoryContents(filePath,0);
  }
  
  //Exercise 2: COMPLETE private recursive version to produce an output similar to the following
  /* 
   * 
   Calling getDirectoryContent("/home/irahal/git/CSCI200") : 
   
   Recursion&Backtracking/ 
   > BinaryToDecimal/ 
   > > BinaryToDecimal.java 
   > > BinaryToDecimal.zip 
   > > BinaryToDecimal_SOLUTION.zip 
   > > SOLUTION/ 
   > > > BinaryToDecimal.class 
   > > > BinaryToDecimal.java 
   > > > BinaryToDecimalTest.class 
   > > > BinaryToDecimalTest.java 
   > DirectoryStructure/ 
   > > DirectoryStructure.java 
   > > DirectoryStructure.zip 
   > > DirectoryStructure_SOLUTION/ 
   > > > DirectoryStructure.class 
   > > > DirectoryStructure.java 
   > > > DirectoryStructure.java~ 
   > > DirectoryStructure_SOLUTION.zip 
   
   * you'll need to use the following methods in class File
   * 
   *     Note that File objects are created like the following example: File currentDirOrFile = new File(filePath);
   *     exists() --- Tests whether the file or directory denoted by filePath exists.
   *     isFile() --- Tests whether the file denoted by filePath is a normal file
   *     isDirectory() --- Tests whether the file denoted by filePath is a directory.
   *     list() --- Returns an array of strings naming the files and directories in the directory denoted by filePath
   *     getName() --- Returns the name of the file or directory denoted by filePath
   */  
  private void getDirectoryContents(String filePath, int currentDepth) {
    //1- create a File object for filePath
    //2- create the appropriate indentation string to display before file/directory names by appending "> " based on the value of currentDepth
    //3- what is/are the base case(s) for recursion?
    //4- what is/are the general case(s)?
    File file = new File(filePath);
    if (!file.exists()) {
      System.out.println("File/Directory doesn't exist");
      return;
    }
    for (int i = 0; i <= currentDepth; i++) {
        System.out.print("> ");
    }
    if (file.isFile()) {
      System.out.println(file.getName());
    } else {
      System.out.println(file.getName() + "/");
      for (String s : file.list()) {
        getDirectoryContents(filePath+"/"+s, currentDepth +1);
      }
    }
  }
  
  public static void main (String args [] ){
    String startPath = JOptionPane.showInputDialog("Please enter the full path to your JavaPackages folder:");
    System.out.println("Calling getDirectoryContent(\"" + startPath + "\") : \n");
    (new DirectoryStructure()).getDirectoryContents(startPath);
  }
}
