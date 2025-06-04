import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Grant Peroutka and Andrew Nerud
 * Date: 12/10/2022
 */

/**
 * Class that sets the game window
 */
public class GameWindow extends JFrame {
  //The non-changing file name to save to
  public static final String SAVE_FILE = "SavedGame.txt";
  //Field that allows access for controlling buttons
  private final Map<String, JButton> buttonMap;
  //Local instance of Game Layout
  private final GameLayout gameLayout;
  //Set of the connections
  private final Set<String> previousConnections;
  //Lable of the position of the cop
  private JLabel positionLabel;
  //Lable of the clue
  private JLabel clueLabel;
  //Lable of the turn
  private JLabel turnLabel;


  /**
   * Constructor that creates a GameWindow
   * 
   * @param gameLayout is an instance of a GameLayout
   * @param screen int 1 -> 3 of a screen to go to
   */
  public GameWindow(GameLayout gameLayout, int screen) {
    super("Cops N' Robbers");
    this.buttonMap = new HashMap<>();
    this.gameLayout = gameLayout;
    this.previousConnections = new HashSet<>();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900,1000);
    setResizable(false);
    this.getContentPane().setLayout(null);
    this.setLayout(null);
    setVisible(true);
    if (screen == 1) startupMenu();
    else if (screen == 2) gameScreen();
    else if (screen == 3) winScreen();
  }

  /**
   * Set up GUI for the Start up menu
   */
  public void startupMenu() {
    //Have a title with a few buttons -> maybe start new game & load from last saved game
    //Button clicks will have a property to call gameScreen method
    JLabel title = new JLabel("Cops N' Robbers");
    title.setBounds(60, 70, 870, 300);
    title.setFont(new Font("Comic Sans", Font.BOLD, 80));

    JButton startButton = new JButton("Start");
    startButton.setBounds(350, 500, 200, 100);
    startButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

    JButton fromSaved = new JButton("Resume");
    fromSaved.setBounds(350, 650, 200, 100);
    fromSaved.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

    this.getContentPane().add(title);
    this.getContentPane().add(startButton);
    startButton.addActionListener(event -> {
      this.dispose();
      new GameWindow(this.gameLayout, 2);
    });
    this.getContentPane().add(fromSaved);
    fromSaved.addActionListener(event -> {
      this.dispose();
      if (gameLayout.getSaved(SAVE_FILE)) {
        this.gameLayout.setFromSave(true);
        this.gameLayout.nullify(SAVE_FILE);
      }
      new GameWindow(this.gameLayout, 2);
    });

  }

  /**
   * Set up GUI for the main game screen
   */
  public void gameScreen(){

    try {
      JButton jb = new JButton();
      jb.setText("Save and Exit");
      jb.setBounds(720, 0, 168, 40);
      this.add(jb);
      jb.addActionListener(event -> {
        gameLayout.write(SAVE_FILE);
        this.dispose();
      });
      
      JLabel l1 = new JLabel();
      l1.setBounds(680, 450, 200, 50);
      l1.setText("Current Position:");
      this.add(l1);
      
      positionLabel = new JLabel();
      positionLabel.setBounds(700, 475, 200, 50);
      positionLabel.setText("");
      this.add(positionLabel);
      
      JLabel l2 = new JLabel();
      l2.setBounds(680, 550, 200, 50);
      l2.setText("Clue:");
      this.add(l2);
      
      clueLabel = new JLabel();
      clueLabel.setBounds(700, 575, 200, 50);
      clueLabel.setText("");
      this.add(clueLabel);
      
      JLabel l3 = new JLabel();
      l3.setBounds(680, 650, 200, 50);
      l3.setText("Turn:");
      this.add(l3);
      
      turnLabel = new JLabel();
      turnLabel.setBounds(700, 675, 200, 50);
      turnLabel.setText("");
      this.add(turnLabel);
      
      addLocationButtons();

      JLabel jl = new JLabel(new ImageIcon("MN_Map_mini.png"));
      jl.setBounds(0, 0, 900, 1000);
      this.add(jl);

    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    if (!gameLayout.isFromSave()) gameSetup();
    else setupSaved();
  }
  
  /**
   * Set up GUI for the Win Screen
   */
  public void winScreen() {
    JLabel win = new JLabel();
    win.setBounds(100, 50, 800, 200);
    win.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 55));
    win.setText("You Caught the Robber!");
    this.add(win);
    
    JLabel turnsTaken = new JLabel();
    turnsTaken.setBounds(100, 250, 800, 200);
    turnsTaken.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));
    turnsTaken.setText("Number of Turns Taken: " + gameLayout.getTurn());
    this.add(turnsTaken);
    
    JLabel moneyStolen = new JLabel();
    moneyStolen.setBounds(100, 450, 800, 200);
    moneyStolen.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));
    moneyStolen.setText("The Robber Stole a Total of : $" + gameLayout.getRobber().getMoneyStolen());
    this.add(moneyStolen);
    
    
    this.getGraphics().drawImage((new ImageIcon("MN_Map.png")).getImage(), 360, 750, 180, 200, null);
    
    JButton restartButton = new JButton("Restart");
    restartButton.setBounds(350, 700, 200, 100);
    restartButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    
    this.getContentPane().add(restartButton);
    restartButton.addActionListener(event -> {
      this.dispose();
      new GameWindow(new GameLayout("LocationsList.txt", "ConnectionsList.txt"), 2);
    });
  }

  /**
   * adds all the buttons for the locatins from a static file
   * @throws FileNotFoundException
   */
  public void addLocationButtons() throws FileNotFoundException {
    Scanner sc = new Scanner(new File("ButtonLocations.txt"));
    while (sc.hasNextLine()) {
      String[] next = sc.nextLine().split(",");
      if (next[0].equals("end")) break;
      LocationButton lb = new LocationButton(next[0], Integer.parseInt(next[1]), Integer.parseInt(next[2]), this);
      buttonMap.put(next[0], lb);
    }
  }

  /**
   * Moved the cop to a new location
   * 
   * @param location the String location to move to
   */
  public void moveToAction(String location) {
    gameLayout.moveCop(location);
    //disables previous connections
    for (String previous : previousConnections) {
      buttonMap.get(previous).setEnabled(false);
    }
    previousConnections.clear();

    //Sets all connecting locations to enabled and adds each to the set (including current pos)
    buttonMap.get(location).setEnabled(true);
    previousConnections.add(location);
    Iterator<String> currentConnections = gameLayout.allLocationConnections(location);
    while (currentConnections.hasNext()) {
      String next = currentConnections.next();
      if(!next.equals("Start") && !next.equals("Jail")) {
        buttonMap.get(next).setEnabled(true);
        previousConnections.add(next);
      }
    }
    
    positionLabel.setText(location);
    clueLabel.setText(gameLayout.get(location).getClue());
    turnLabel.setText(""+(gameLayout.getTurn() == 0 ? "Start" : gameLayout.getTurn()));
    
    if (gameLayout.isRobberFound()) {
      System.out.print("Robber Found");
      gameLayout.robberToJail();
      this.dispose();
      new GameWindow(this.gameLayout, 3);
    } else {
      if (!gameLayout.isFromSave()) gameLayout.moveRobber(true);
      System.out.println(gameLayout.getRobber().getCurrentLocation());
    }
  }

  /**
   * Method to set up the Cop and robber before the game starts
   */
  public void gameSetup() {
    gameLayout.getRobber().setCurrentLocation("Minneapolis");
    gameLayout.get("Start").setHasRobber(true);
    gameLayout.moveRobber(false);
    gameLayout.moveRobber(false);
    gameLayout.moveRobber(false);
    gameLayout.moveRobber(false);
    moveToAction("Minneapolis");
  }

  /**
   * Method to set up the Cop and robber before the game starts from a previous save
   */
  public void setupSaved() {
    System.out.println(gameLayout.getCopCurrentLocation());
    moveToAction(gameLayout.getCopCurrentLocation());
    gameLayout.setFromSave(false);
  }
}