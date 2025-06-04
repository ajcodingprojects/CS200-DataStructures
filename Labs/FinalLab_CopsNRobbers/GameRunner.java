/**
 * Game runner class that creates a new game window
 */
/**
 * Grant Peroutka and Andrew Nerud
 * Date: 12/9/2022
 */
public class GameRunner {
  private static GameWindow gw;
  
  /**
   * Main method that creates a new game window and allows user to play the game
   */
  public static void main (String args[]) {
    GameLayout gl = new GameLayout("LocationsList.txt", "ConnectionsList.txt");
    new GameWindow(gl, 1);
    
  }
}