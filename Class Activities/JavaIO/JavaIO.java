import java.util.*;
import java.io.*;

public class JavaIO implements Serializable {

   public void writeDataToFile() throws FileNotFoundException{
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(new File("dataFile"));
    int number;
    while(sc.hasNextInt()) {
      number = sc.nextInt();
      pw.println(number);
    }
    sc.close();
    pw.close();
  }
   
  public void readDataFromFile() throws FileNotFoundException{
    Scanner sc = new Scanner(new File("dataFile"));
    int number;
    while(sc.hasNextInt()) {
      number = sc.nextInt();
      System.out.println(number);
    }
    sc.close();
  }
  
  //COMPLETE ME: Change method to add Computer objects to an ArrayList<Computer> of computers and then 
  //write ArrayList (as a single object) to an object file
  public void writeObjectsToFile () throws IOException{
    ArrayList<Computer> computers = new ArrayList<Computer>();        
    Computer c1, c2, c3;
    c1 = new Computer("DELL","I5",16);
    c2 = new Computer("HP","I7",8);
    c3 = new Computer("ASUS","I9",32);
    computers.add(c1);
    computers.add(c2);
    computers.add(c3);
    ObjectOutputStream ow = new  ObjectOutputStream(new FileOutputStream("objectFile"));
    ow.writeObject(computers);
    ow.close();
    
  }
  //COMPLETE ME: Change method to read ArrayList<Computer> object from object file and then 
  //loop over ArrayList to display objects on screen
  public void readObjectsFromFile () throws IOException, ClassNotFoundException{
    ObjectInputStream or = new  ObjectInputStream(new FileInputStream("objectFile"));
    ArrayList<Computer> inputComp = (ArrayList<Computer>) or.readObject();
    inputComp.forEach(computer -> System.out.println(computer));
//    Computer c = (Computer) or.readObject();
//    System.out.println("***"+c);
//    c =  (Computer) or.readObject();
//    System.out.println("***"+c);
//    c = (Computer) or.readObject();
//    System.out.println("***"+c);
 or.close();
  }
  
  public static void main(String [] args){
    JavaIO jio = new JavaIO();
    try{  
      jio.writeDataToFile();
      jio.readDataFromFile();
      jio.writeObjectsToFile();
      jio.readObjectsFromFile();
    }
    catch(IOException ioe){
      System.out.println("Can't IO:" + ioe);
    }
    catch(ClassNotFoundException cnfe){
      System.out.println(cnfe);
    }
    
  }
}
