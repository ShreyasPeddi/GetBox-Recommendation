import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * This class creates a GUI help screen which consists of useful information to navigate each screen of this 
 * application
 * 
 * Author - Tony Yu
 */
public class LaptopAdvisorGUIHelp extends JFrame implements ActionListener {

	// Fields or instance Variables
	private JPanel helpPanel = new JPanel();
	private JLabel helpPanelLabel = new JLabel();
	private JLabel titleLabel = new JLabel();
	private JTextArea helpTextArea = new JTextArea();
	private JButton[] helpImageButtonArray = new JButton[3];
	private LaptopAdvisorGUIMenuBar menubar = new LaptopAdvisorGUIMenuBar();
	Color backgroundColor = new Color(214, 211, 240);

	// Constructor method: Calls other helper methods to setup the help screen
	public LaptopAdvisorGUIHelp() {

		// Setup the panel
		helpPanelSetup();

		// Set the frame and add the panel
		frameSetup();
	}

	// This method creates a panel and adds GUI elements like Textareas to display
	// information regarding each screen on the application
	private void helpPanelSetup() {

		//Set the location and dimensions of the Panel
		helpPanel.setBounds(50, 50, 1250, 500);
		helpPanel.setLayout(null);

		helpPanel.setBackground(backgroundColor);
		//Set the location and dimensions of the help label
		helpPanelLabel.setBounds(575, 25, 200, 25);
		helpPanel.add(helpPanelLabel);

		//Set the dimensions and location of the title label
		titleLabel.setBounds(530,10,177,40);
		
		//Set the font and Text of the title label
		titleLabel.setFont(new Font("Franklin", Font.BOLD, 26));
		titleLabel.setText("   Help Panel");
		
		//Set the background and foreground colors
		titleLabel.setBackground(Color.DARK_GRAY);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setOpaque(true);
		
		//Add the label to the panel
		helpPanel.add(titleLabel);
		
		//Do the following for each button
		for (int index = 0; index < helpImageButtonArray.length; index++) {
			
			//Add each button to the panel
			helpImageButtonArray[index] = new JButton();
			helpImageButtonArray[index].setBounds(100 + 400 * index, 75, 250, 200);
			helpImageButtonArray[index].addActionListener(this);
			
			//Add the button to the panel
			helpPanel.add(helpImageButtonArray[index]);
			
		}
		
		//Add each text area to the panel
		helpTextArea.setBounds(300, 350, 650, 200);
		helpTextArea.setFont(new Font("Franklin", Font.BOLD, 16));
		
		//Set line wrap to make the text go to the next line
		//https://www.codota.com/code/java/methods/javax.swing.JTextArea/setLineWrap
		helpTextArea.setEditable(false);
		helpTextArea.setLineWrap(true);
		helpTextArea.setWrapStyleWord(true);
		helpTextArea.setBackground(backgroundColor);
		
		//Add the text area to the panel
		helpPanel.add(helpTextArea);
		
		//Set the icons of the buttons (screenshots)
		helpImageButtonArray[0].setIcon(new ImageIcon(
				new ImageIcon("./images/User Ratings Panel.jpg").getImage().getScaledInstance(250, 200, 0)));
		
		helpImageButtonArray[1].setIcon(new ImageIcon(
				new ImageIcon("./images/User Weightings Panel.jpg").getImage().getScaledInstance(250, 200, 0)));

		helpImageButtonArray[2].setIcon(new ImageIcon(
				new ImageIcon("./images/Report Panel.jpg").getImage().getScaledInstance(250, 200, 0)));

	}	//End of method

	//This method sets up the frame (size, add the panel and menubar)
	private void frameSetup() {
		
		//Set the size of the frame
		setSize(1366, 725);
		setLayout(null);

		//Add the menubar to the screen
		setJMenuBar(menubar);

		//Add the panel with GUI elements
		add(helpPanel);

		//Set the visibility to true
		setVisible(true);
	}

	// This method determines events and adds functionality to each event
	@Override
	public void actionPerformed(ActionEvent event) {
	
		// check if user clicks on the help images to provide a message (RATINGS SCREEN)
		if (event.getSource() == helpImageButtonArray[0])
			helpTextArea.setText("Ratings screen allows you to rate your own personal levels of preferences "
					+ "with respect to your budget, a touch screen feature, display size, and operating system."
					+ "These ratings and preferences will be taken into account when determining the best laptops. "
					+ "Once you’ve selected your preferences for each category, it will then move you over to the "
					+ "weightings screen.");
		
		// check if user clicks on the help images to provide a message (WEIGHTINGS SCREEN)
		if (event.getSource() == helpImageButtonArray[1])
			helpTextArea.setText("Weighing screen will allow you to select how much you care about each of the "
					+ "laptop features within  a scale of 1-10. Your weightings result will also be taken to help "
					+ "determine the best laptops for you. Once you’ve selected the weightings, it will create a "
					+ "report with information of 3 laptops based on your preferences.");
		
		// check if user clicks on the help images to provide a message (REPORT SCREEN)
		if (event.getSource() == helpImageButtonArray[2]) 
			helpTextArea.setText("Report screen provides you with a curated report on the best laptops available "
					+ "in the market. It will give you the top 3 laptops based on your"
					+ "ratings and our team's extensive research on key features.It "
					+ "would give detailed information"
					+ " about the laptop and also has a hyperlink to take you to the website to purchase the laptop");
		
	}	//End of main
	
}	//End of class
