/**
 * Grant Peroutka and Andrew Nerud
 * Date: 12/1/2022
 */

import java.io.*;

/**
 * Class that creates the location description
 */
public class LocationDescription implements Serializable  {
  
  /*
   * the name of the location
   */
  private String name;
  
  /*
   * the value of money at each location 
   */
  private int money;
 
  /*
   * the clue left behind the robber
   */
  private String clue;
  
  /*
   * if the robber left a clue
   */
  private boolean hasClue;
  
  /*
   * number of $ stolen since the cop arrived last 
   */
  private int amtStolen;
  
  /*
   * if the robber is at the location
   */
  private boolean hasRobber;
  
  
  /**
   * Creates a new location Description with the specified name and money.
   */
  public LocationDescription(){
    this.name = null;
    this.money = -1;
    this.clue = "None";
    this.hasClue = false;
    this.amtStolen = -1;
    this.hasRobber = false;
  }
  
   /**
   * Creates a new location Description with the specified name and money.
   * 
   * @param name the name of the location
   * @param money the money at the location
   */
  public LocationDescription(String name, int money) {
    this.name = name;
    this.money = money;
    this.clue = "None";
    this.hasClue = false;
    this.amtStolen = -1;
    this.hasRobber = false;
  }
     
  /**
   * Creates a new location Description with the specified name and money.
   * 
   * @param name the name of the location
   * @param money the money at the location
   * @param clue is the clue left behind from the robber
   * @param hasClue is if the robber left behind a clue
   * @param robbedOnTurn is the robbers last turn they robbed the location on
   * @param amtStolen is the amount the robber has stolen since visiting the location
   * @param hasRobber is if the robber is at the location currently
   */
  public LocationDescription(String name, int money, String clue, boolean hasClue, int amtStolen, boolean hasRobber) {
    this.name = name;
    this.money = money;
    this.clue = "None";
    this.hasClue = hasClue;
    this.amtStolen = amtStolen;
    this.hasRobber = hasRobber;
  }
  
  /*
   * method to return the instance fields
   */
  public String toString(){
    return "Name: " + name + "\n" 
      + "Money: " + money + "\n"
      + "Clue: " + clue + "\n"
      + "Has Clue: " + hasClue + "\n"
      + "Total Amount Stolen: " + amtStolen + "\n"
      + "Has Robber Currently: " + hasRobber;
  }
  
  /*
   * sets the name
   */
  public void setName(String name){
    this.name = name;
  }
  
  /*
   * gets the name
   */
  public String getName(){
    return this.name;
  }
  
  /*
   * sets the money
   */
  public void setMoney(int money){
    this.money = money;
  }
  
  /*
   * gets the money
   */
  public int getMoney(){
    return this.money;
  }
  
  /*
   * sets the clue
   */
  public void setClue(String clue){
    this.clue = clue;
  }
  
  /*
   * gets the clue
   */
  public String getClue(){
    return this.clue;
  }
  
  /*
   * sets the hasClue
   */
  public void setHasClue(boolean hasClue){
    this.hasClue = hasClue;
  }
  
  /*
   * gets the hasClue
   */
  public boolean hasClue(){
    return this.hasClue;
  }
  
  /*
   * sets the amtStolen
   */
  public void setAmtStolen(int amtStolen){
    this.amtStolen = amtStolen;
  }
  
  /*
   * gets the amtStolen
   */
  public int getAmtStolen(){
    return this.amtStolen;
  }
  
  /*
   * sets the hasRobber
   */
  public void setHasRobber(boolean hasRobber){
    this.hasRobber = hasRobber;
  }
  
  /*
   * gets the hasRobber
   */
  public boolean hasRobber(){
    return this.hasRobber;
  }
  
  
}
