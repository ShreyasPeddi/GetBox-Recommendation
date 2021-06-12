import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * This class creates a menubar object which can navigate to help screen, restart the application or close it
 * 
 * Author - Tony Yu
 */
public class LaptopAdvisorGUIMenuBar extends JMenuBar implements ActionListener {

	// Create a menu(s)
	JMenu fileMenu = new JMenu("File");

	// Create menu item(s)
	JMenuItem helpMenuItem = new JMenuItem("Help");
	JMenuItem exitMenuItem = new JMenuItem("Exit");
	JMenuItem restartMenuItem = new JMenuItem("Restart");

	// This method 
	public LaptopAdvisorGUIMenuBar() {
		
		// Add action listeners to the menu items
		helpMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		restartMenuItem.addActionListener(this);

		// Add menu items to their respective menus
		fileMenu.add(helpMenuItem);
		fileMenu.add(exitMenuItem);
		fileMenu.add(restartMenuItem);
		
		// Add the menus to the menu bar
		add(fileMenu);

	}

	// This method performs an action based on chosen menu item
	@Override
	public void actionPerformed(ActionEvent event) {

		// Perform desired actions when menu items are selected by the user
		
		//Take to new screen
		if (event.getSource() == helpMenuItem)
			new LaptopAdvisorGUIHelp();

		//Exit the application
		if (event.getSource() == exitMenuItem)
			System.exit(0);
		
		//Restart the application
		if (event.getSource() == restartMenuItem) {
			new LaptopAdvisorGUIUserRatings();
		}
	}


}	
