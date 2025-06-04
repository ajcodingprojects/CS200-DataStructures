import javax.swing.*;
import java.awt.*;
/**
 * Grant Peroutka and Andrew Nerud
 * Date: 12/10/2022
 */

/**
 * Class that enables the use of buttons
 */
public class LocationButton extends JButton {

    /**
     * Constructor that creates a button
     * @param name
     * @param xPos
     * @param yPos
     * @param gw
     */
    public LocationButton(String name, int xPos, int yPos, GameWindow gw) {
        super(name);
        setBounds(xPos, yPos, 87, 40);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 8));
        gw.add(this);
        doClick();
        addActionListener(event -> gw.moveToAction(name));
        setEnabled(false);
    }

}
