
/*
 * This class contains a frame that allows the user to enter their weightings
 * (how much they care about each of the ratings).
 * 
 * author: Regina Liang
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LaptopAdvisorGUIUserWeightings extends JFrame implements ActionListener {

	// Fields or Instance Variable
	// Main Panel and Label
	private JPanel userWeightingsPanel = new JPanel();
	private JLabel userWeightingsLabel = new JLabel(" USER WEIGHTINGS ");
	private JLabel[] weightingLabelArray = new JLabel[8];
	private JComboBox[] weightingComboBoxArray = new JComboBox[8];
	private JButton reportButton = new JButton("Create Report");
	private LaptopAdvisorGUIMenuBar menubar = new LaptopAdvisorGUIMenuBar();

	//GUI element - outline
	private JPanel panelOutline = new JPanel();

	//Image label
	private ImageIcon laptopImage = new ImageIcon("./Images/laptopImage.png");
	private JLabel laptopImageLabel = new JLabel(laptopImage);
	
	// Create custom colors based on RGB code
	// https://www.java-examples.com/create-custom-color-using-rgb-example
	Color backgroundColor = new Color(214, 211, 240);
	Color borderColor = new Color(174, 167, 180);

	// This method set up the panel and frame
	public LaptopAdvisorGUIUserWeightings() {

		userWeightingsPanelSetup();
		frameSetup();
	}

	// this method sets the size, layout, and location of the panel
	private void userWeightingsPanelSetup() {
		
		// Set the bounds for  Image
		laptopImageLabel.setBounds(170,70,235,155);
		laptopImageLabel.setOpaque(false);
		
		// Set bounds and layouts for userWeightingsPanel
		userWeightingsPanel.setBounds(50, 50, 1250, 500);
		userWeightingsPanel.setLayout(null);
		userWeightingsPanel.setBackground(backgroundColor);
		
		//Set a thick line border
		//https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		Border mainBorder = BorderFactory.createLineBorder(borderColor, 20);	//use borderColor (custom defined color)
		userWeightingsPanel.setBorder(mainBorder);
		
		// Set bounds and layouts for userWeightingLabel
		userWeightingsLabel.setBounds(425, 58, 420, 50);
		userWeightingsLabel.setFont(new Font("Optima", Font.BOLD, 40));
		userWeightingsLabel.setBackground(Color.DARK_GRAY);
		userWeightingsLabel.setForeground(Color.WHITE);
		userWeightingsLabel.setOpaque(true);
		userWeightingsPanel.add(userWeightingsLabel);
		
		// Set up the Combo Boxes
		setupComboBoxes();

		// Set bounds for reportButton
		reportButton.setBounds(575, 575, 200, 50);
		reportButton.setFont(new Font("Franklin", Font.TYPE1_FONT, 14));
		reportButton.setBackground(Color.DARK_GRAY);
		reportButton.setForeground(Color.WHITE);
		add(reportButton);
		reportButton.addActionListener(this);

	}

	//This method sets up the size of the frame and display
	private void frameSetup() {

		// Sets the size
		setSize(1366, 725);
		setLayout(null);

		
		// This sets the background colour of the frame
		// https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
		getContentPane().setBackground(backgroundColor);
		
		// Sets up MenuBar
		setJMenuBar(menubar);

		// Add the main panel and image to the frame
		add(laptopImageLabel);
	    add(userWeightingsPanel);
	    
	    // Sets the panel outline
		add(panelOutline); 

		// Set the frame visibility to true
		setVisible(true);

	}

	// This method set up the Questions and ComboBoxes
	private void setupComboBoxes() {

		// Store the weightings for each question
		weightingLabelArray[0] = new JLabel("1. How important is the Brand?");
		weightingLabelArray[1] = new JLabel("2. How important is the CPU?");
		weightingLabelArray[2] = new JLabel("3. How important is the GPU?");
		weightingLabelArray[3] = new JLabel("4. How important is the Conectivity?");
		weightingLabelArray[4] = new JLabel("5. How important is the budget?");
		weightingLabelArray[5] = new JLabel("6. How important is the touch screen feature?\t");
		weightingLabelArray[6] = new JLabel("7. How important is the display size?");
		weightingLabelArray[7] = new JLabel("8. How important is the OS?");

		// Half of the array length
		int half = weightingLabelArray.length / 2;

		// Set the bounds for positioning
		for (int index = 0; index < weightingLabelArray.length; index++) {

			// Set Bounds positioning Labels
			if (index < half)
				weightingLabelArray[index].setBounds(50 + index * 300, 175, 250, 25);
			else
				weightingLabelArray[index].setBounds(50 + (index - half) * 300, 330, 300, 25);

			userWeightingsPanel.add(weightingLabelArray[index]); // add weightingLabel to the panel

			// Set the weightingComboBoxArray
			weightingComboBoxArray[index] = new JComboBox<Integer>();
			weightingComboBoxArray[index].addActionListener(this);

			// Set the values in Combo Boxes
			for (int value = 0; value <= 10; value++)
				weightingComboBoxArray[index].addItem(value);

			// Set Bounds for positioning combo boxes
			if (index < half)
				weightingComboBoxArray[index].setBounds(50 + index * 300, 200, 220, 25);
			else
				weightingComboBoxArray[index].setBounds(50 + (index - half) * 300, 360, 220, 25);

			userWeightingsPanel.add(weightingComboBoxArray[index]); // add combo box to the panel
		}

	}

	// This method uses action event to allow user to click
	public void actionPerformed(ActionEvent event) {

		// Values for weightings
		for (int index = 0; index < weightingComboBoxArray.length; index++) {

			if (event.getSource() == weightingComboBoxArray[index]) {
				LaptopAdvisorApplication.user.getWeighting()[index] = weightingComboBoxArray[index].getSelectedIndex();
				break;
			}
		}

		// Get Report Button clicked
		if (event.getSource() == reportButton) {
			setVisible(false);
			new LaptopAdvisorGUIReport();

		}
	}

}
