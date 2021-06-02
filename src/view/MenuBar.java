/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The menu bar that is used with the Trivial Maze GameFrame.
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 */
public class MenuBar extends JMenuBar {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -111659266189879540L;
    
    /**
     * Constructor that sets up a new menu bar.
     */
    public MenuBar() {
        super();
        setupFileMenu();
        setupHelpMenu();
    }
    
    /**
     * Sets up and adds the "File" menu to this menu bar. 
     */
    private void setupFileMenu() {
        // initialize components
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem saveItem = new JMenuItem("Save");
        final JMenuItem loadItem = new JMenuItem("Load");
        final JMenuItem exitItem = new JMenuItem("Exit to Start");
        
        // add action listeners
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("Save menu clicked");
            } 
        });
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("Load menu clicked");
            } 
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("Exit menu clicked");
            } 
        });
        
        // add the components to the menu bar
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);
      
        this.add(fileMenu);
    }
    
    /**
     * Sets up and adds the "Help" menu to this menu bar. 
     */
    private void setupHelpMenu() {
        // initialize components
        final JMenu helpMenu = new JMenu("Help");
        final JMenuItem aboutItem = new JMenuItem("About");
        final JMenuItem howToPlayItem = new JMenuItem("How To Play");
        
        // add action listeners
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("About menu clicked");         
                final AboutFrame frame = new AboutFrame();
            }    
        });
        howToPlayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("How to Play menu clicked");                
                final HowToFrame frame = new HowToFrame();
            }
        });
        
        // add components to menu bar
        helpMenu.add(aboutItem);
        helpMenu.add(howToPlayItem);
        
        this.add(helpMenu);
    }
}