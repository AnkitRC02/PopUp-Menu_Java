import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopupMenuExampleexp13 extends JFrame {

    public PopupMenuExampleexp13() {
        setTitle("Popup Menu Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a label to trigger the popup menu
        JLabel label = new JLabel("Right-click to open popup menu");

        // Create a popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("CUT");
        JMenuItem menuItem2 = new JMenuItem("COPY");
        JMenuItem menuItem3 = new JMenuItem("PASTE");
        JMenuItem menuItem4 = new JMenuItem("DELETE");
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);

        // Add a mouse listener to the label to show the popup menu
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Add an action listener to the menu items
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                System.out.println("Selected: " + source.getText());
            }
        };
        menuItem1.addActionListener(actionListener);
        menuItem2.addActionListener(actionListener);
        menuItem3.addActionListener(actionListener);

        // Add the label to the frame
        add(label);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PopupMenuExampleexp13::new);
    }
}
