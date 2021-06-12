/*
 * This class creates and displays a panel in which the user can select their ratings and preferences
 * for each subjective rating (budget, touchscreen, display size, and OS) by the use of radio buttons.
 * The class then takes the preferences and determines a score for each rating.
 * 
 * Author - Darren Sin
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;

public class LaptopAdvisorGUIUserRatings extends JFrame implements ActionListener {
	
	//Fields - Instance variables for all GUI elements
	//Main panel and label
	private JPanel userRatingsPanel = new JPanel();
	private JLabel userLabel = new JLabel("  USER");
	private JLabel ratingsLabel = new JLabel ("  RATINGS");
	private JLabel aboutLabel = new JLabel ("  Hello! This is the Laptop Advisor Application that "
										+ "	asks you about your preferences for a laptop.");
	private JLabel instructionLabel = new JLabel ("Choose your preferences!");
	
	//Colours
	//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
	private static final Color LIGHT_BLUE = new Color(16,189,224);
	
	//Images
	private ImageIcon preferenceImage = new ImageIcon("./Images/preference.png");
	private ImageIcon starImage = new ImageIcon("./Images/star.png");
	private ImageIcon bgImage = new ImageIcon("./Images/carbon.png");
	private JLabel preferenceImageLabel = new JLabel(preferenceImage);
	private JLabel starImageLabel = new JLabel(starImage);
	
	//GUI elements for budget
	private JLabel budgetLabel = new JLabel("1. What is your optimal budget?");
	private JRadioButton[] budgetRadioButtonArray = new JRadioButton[4];
	private ButtonGroup budgetButtonGroup = new ButtonGroup();
	
	//GUI elements for touch screen
	private JLabel touchScreenLabel = new JLabel("2. Do you prefer touch-screen?");
	private JRadioButton[] touchScreenRadioButtonArray = new JRadioButton[2];
	private ButtonGroup touchScreenButtonGroup = new ButtonGroup();
	
	//GUI elements for display size
	private JLabel sizeLabel = new JLabel("3. What type of display size do you prefer?");
	private JRadioButton[] sizeRadioButtonArray = new JRadioButton[3];
	private ButtonGroup sizeButtonGroup = new ButtonGroup();
	
	//GUI elements for OS
	private JLabel operateSystemLabel = new JLabel("4. Which OS do you prefer?");
	private JRadioButton[] operateSystemRadioButtonArray = new JRadioButton[3];
	private ButtonGroup operateSystemButtonGroup = new ButtonGroup();
	
	//Button for weightings panel
	private JButton weightingsButton = new JButton("Enter your weightings");
	
	//Menu for menu class
	private LaptopAdvisorGUIMenuBar menuBar = new LaptopAdvisorGUIMenuBar();
	
	//This method sets up the panel and frame/window and displays it
	public LaptopAdvisorGUIUserRatings() {
		
		userRatingsPanelSetup(); //This sets the dimensions, layout, and location of the panel
		frameSetup(); //This sets the size of the frame/window
		
	}

	//This method sets the size, layout, and location of the panel and labels
	private void userRatingsPanelSetup() {
		
		//Sets up the main panel
		//https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		userRatingsPanel.setBounds(50,50,1260,600);
		Border mainBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 20);
		userRatingsPanel.setBorder(mainBorder);
		userRatingsPanel.setLayout(null);
		
		//Sets up the title
		userLabel.setBounds(30,120,400,120);
		userLabel.setFont(new Font("Franklin", Font.BOLD + Font.ITALIC, 100));
		userLabel.setBackground(LIGHT_BLUE);
		userLabel.setForeground(Color.WHITE);
		
		//Sets up the title
		ratingsLabel.setBounds(120,230,440,100);
		ratingsLabel.setFont(new Font("Franklin", Font.BOLD + Font.ITALIC, 80));
		ratingsLabel.setBackground(Color.RED);
		ratingsLabel.setForeground(Color.WHITE);
		
		//Sets up the description label
		//https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		aboutLabel.setBounds(50,350,550,40);
		Border labelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		aboutLabel.setBorder(labelBorder);
		
		//Sets up the images
		preferenceImageLabel.setBounds(470,120,200,200);
		starImageLabel.setBounds(0,80,200,200);
		
		//Sets up the instructions label
		instructionLabel.setBounds(725,130,400,25);
		instructionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		
		//https://stackoverflow.com/questions/15892844/underlined-jlabel/15892859#15892859
		Font instruction = instructionLabel.getFont(); //Gets the font of the label
		Map attributes = instruction.getAttributes(); //Returns the attributes map of this font
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); //Adds an underline to the attributes
		instructionLabel.setFont(instruction.deriveFont(attributes)); //Sets the underlined font text to the instruction label
		
		//Sets the opaque to true for background colour
		userLabel.setOpaque(true);
		ratingsLabel.setOpaque(true);
		
		//Adds each of the labels to the main panel
		userRatingsPanel.add(userLabel);
		userRatingsPanel.add(ratingsLabel);
		userRatingsPanel.add(aboutLabel);
		userRatingsPanel.add(instructionLabel);
		
		//Calls the setup radio buttons method
		setupRadioButtons();
		
		//Setups the weightings button
		weightingsButton.setBounds(575,550,200,50);
		weightingsButton.setBackground(Color.white);
		weightingsButton.setForeground(Color.RED);
		weightingsButton.setFont(new Font("Franklin", Font.BOLD, 13));
		
		//Adds the weightings button
		add(weightingsButton);
		weightingsButton.addActionListener(this); //Adds an action listener
		
	}
	
	//This method sets the size of the frame/window and displays it
	private void frameSetup() {
		
		//Window size is 1366 x 725
		setSize(1366,725);
		setLayout(null);
		setTitle("Laptop Advisor User Ratings Panel");
		
		//This sets the background colour of the frame to gray
		//https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
		getContentPane().setBackground(Color.GRAY.darker());
		
		setJMenuBar(menuBar); //Sets up the menu bar
		
		//Adds the images and main panel to the frame
		add(preferenceImageLabel);
		add(starImageLabel);
		add(userRatingsPanel);
		
		//Sets the frame to visible
		setVisible(true);
		
	}
	
	//This method sets up the radio buttons for all of the subjective ratings
	private void setupRadioButtons() {
		
		//Sets the dimensions and location of the budget label
		budgetLabel.setBounds(725,160,300,25);
		userRatingsPanel.add(budgetLabel); //Adds the label to the panel
		
		//Creates radio buttons for each rating
		budgetRadioButtonArray[0] = new JRadioButton("Less than $500"); 
		budgetRadioButtonArray[1] = new JRadioButton("$500 to less than $1000");
		budgetRadioButtonArray[2] = new JRadioButton("$1000 to less than $2000");
		budgetRadioButtonArray[3] = new JRadioButton("$2000 or more");
		
		//Repeats for the amount of ratings and adds each button onto the panel
		for (int index = 0; index < budgetRadioButtonArray.length; index++) {
			
			budgetButtonGroup.add(budgetRadioButtonArray[index]); //Adds each button in the array to the button group
			budgetRadioButtonArray[index].setBounds(725,185 + index * 25, 300, 25); //Sets the location and size of each button
			userRatingsPanel.add(budgetRadioButtonArray[index]); //Adds each button to the panel
			budgetRadioButtonArray[index].addActionListener(this); //Adds an action listener to each button
			
		}
		
		//Sets the dimensions and location of the touchScreen label
		touchScreenLabel.setBounds(1050,160,300,25);
		userRatingsPanel.add(touchScreenLabel);
		
		//Creates radio buttons for each rating
		touchScreenRadioButtonArray[0] = new JRadioButton("Yes");
		touchScreenRadioButtonArray[1] = new JRadioButton("No");
		
		//Repeats for the amount of ratings and adds each button onto the panel
		for (int index = 0; index < touchScreenRadioButtonArray.length; index++) {
			
			touchScreenButtonGroup.add(touchScreenRadioButtonArray[index]); //Adds each button in the array to the button group
			touchScreenRadioButtonArray[index].setBounds(1050,185 + index * 25, 100, 25); //Sets the location and size of each button
			userRatingsPanel.add(touchScreenRadioButtonArray[index]); //Adds each button to the panel
			touchScreenRadioButtonArray[index].addActionListener(this); //Adds an action listener to each button
		
		}
		
		//Sets the dimensions and location of the size label
		sizeLabel.setBounds(725,325,300,25);
		userRatingsPanel.add(sizeLabel);
		
		//Creates radio buttons for each rating
		sizeRadioButtonArray[0] = new JRadioButton("Small");
		sizeRadioButtonArray[1] = new JRadioButton("Medium");
		sizeRadioButtonArray[2] = new JRadioButton("Large");
		
		//Repeats for the amount of ratings and adds each button onto the panel
		for (int index = 0; index < sizeRadioButtonArray.length; index++) {
			
			sizeButtonGroup.add(sizeRadioButtonArray[index]); //Adds each button in the array to the button group
			sizeRadioButtonArray[index].setBounds(725,350 + index * 25, 300, 25); //Sets the location and size of each button
			userRatingsPanel.add(sizeRadioButtonArray[index]); //Adds each button to the panel
			sizeRadioButtonArray[index].addActionListener(this); //Adds an action listener to each button
		
		}
		
		//Sets the dimensions and location of the OS label
		operateSystemLabel.setBounds(1050,325,300,25);
		userRatingsPanel.add(operateSystemLabel);
		
		//Creates radio buttons for each rating
		operateSystemRadioButtonArray[0] = new JRadioButton("Windows OS");
		operateSystemRadioButtonArray[1] = new JRadioButton("Chrome OS");
		operateSystemRadioButtonArray[2] = new JRadioButton("macOS");
		
		//Repeats for the amount of ratings and adds each button onto the panel
		for (int index = 0; index < operateSystemRadioButtonArray.length; index++) {
			
			operateSystemButtonGroup.add(operateSystemRadioButtonArray[index]); //Adds each button in the array to the button group
			operateSystemRadioButtonArray[index].setBounds(1050,350 + index * 25, 100, 25); //Sets the location and size of each button
			userRatingsPanel.add(operateSystemRadioButtonArray[index]); //Adds each button to the panel
			operateSystemRadioButtonArray[index].addActionListener(this); //Adds an action listener to each button
		
		}
		
	}
	
	//This method determines the preference that the user selected and passes the value to
	//the appropriate rating method
	public void actionPerformed(ActionEvent event) {
		
		for (int index = 0; index < budgetRadioButtonArray.length; index++)
			if (event.getSource() == budgetRadioButtonArray[index])
				setBudgetRating(index);
		
		for (int index = 0; index < touchScreenRadioButtonArray.length; index++)
			if (event.getSource() == touchScreenRadioButtonArray[index])
				setTouchScreenRating(index);
		
		for (int index = 0; index < operateSystemRadioButtonArray.length; index++)
			if (event.getSource() == operateSystemRadioButtonArray[index])
				setOSRating(index);
		
		for (int index = 0; index < sizeRadioButtonArray.length; index++)
			if (event.getSource() == sizeRadioButtonArray[index])
				setSizeRating(index);
		
		//If the weightings button is selected, it moves over to the user weightings class
		if (event.getSource() == weightingsButton) {
			setVisible(false);
			new LaptopAdvisorGUIUserWeightings();
			
		}
		
	}
	
	//This method sets the score based on the user's choice of budget
	private void setBudgetRating(int choice) {
		
		//Repeats for each laptop
		for (int index = 0; index < LaptopAdvisorApplication.laptopArray.length; index++) {
			
			//1) What is your optimal budget ? (Less than $500, between $500-$999, between $1000-$2000, more than $2000)
			//Top Choice =100p, range +- 1= 25p, range+-2=0p

			//If the user's budget is less than $500
			if (choice == 0) {
				if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 500)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 100;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 1000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 2000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
					
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
				
			}
			
			//If the user's budget is between $500-$999
			if (choice == 1) {
				if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 500)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 1000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 100;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 2000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
				
			}
			
			//If the user's budget is between $1000-$2000
			if (choice == 2) {
				if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 500)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 1000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 2000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 100;
				
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
			}
			
			//If the user's budget is more than $2000
			if (choice == 3) {
				if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 500)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 1000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 0;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getPrice() < 2000)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 25;
				
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[4] = 100;
				
			}
			
		}
		
	}

	//This method sets the score based on the user's preference of having a touch screen
	private void setTouchScreenRating(int choice) {
		
		//Repeats for each laptop
		for (int index = 0; index < LaptopAdvisorApplication.laptopArray.length; index++) {
			
			//2) Do you prefer touch-screen?
			//Yes= 25p, No=0p
			
			//If the user prefers a touch screen
			if (choice == 0) {
				if (LaptopAdvisorApplication.laptopArray[index].isTouchScreen() == true)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[5] = 25;
					
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[5] = 0;
				
			}
			
			//If the user does not prefer a touch screen
			if (choice == 1) {
				if (LaptopAdvisorApplication.laptopArray[index].isTouchScreen() == false)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[5] = 25;
					
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[5] = 0;
				
			}
			
		}
		
	}
	
	//This method sets the score based on the user's preference of size
	private void setSizeRating(int choice) {
		
		//Repeats for each laptop
		for (int index = 0; index < LaptopAdvisorApplication.laptopArray.length; index++) {
			
			//3) What type of laptop size do you prefer? (Small, Medium, Large)
			//Top choice=20p, range+-1=10p, range+-2=3p
			
			//If user prefers a small screen size
			if (choice == 0) {
				if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 14)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 20;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 16)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 10;
					
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 3;
				
			}
			
			//If user prefers a medium screen size
			if (choice == 1) {
				if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 14)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 10;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 16)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 20;
				
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 10;
				
			}
			
			//If user prefers a large screen size
			if (choice == 2) {
				if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 14)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 3;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getDisplaySize() <= 16)
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 10;
				
				else
					LaptopAdvisorApplication.laptopArray[index].getRatings()[6] = 20;
				
			}
			
		}
	
	}
	
	//This method sets the score based on the user's preference of OS
	private void setOSRating(int choice) {
		
		//Repeats for each laptop
		for (int index = 0; index < LaptopAdvisorApplication.laptopArray.length; index++) {
			
			//4) Which OS do you prefer? (Mac OS, Chrome OS, Windows OS)
			//Top choice = 30p, range+-1=10p, range+-2=10p

			
			//If the user prefers Windows OS
			if (choice == 0) {
				if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Home" || LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Pro")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 30;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Chrome OS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
					
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "MacOS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
				
			}
			
			//If the user prefers Chrome OS
			if (choice == 1) {
				if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Home" || LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Pro")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Chrome OS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 30;
					
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "MacOS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
				
			}
			
			//If the user prefers macOS
			if (choice == 2) {
				if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Home" || LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Windows 10 Pro")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
				
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "Chrome OS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 10;
					
				else if (LaptopAdvisorApplication.laptopArray[index].getSoftware() == "MacOS")
					LaptopAdvisorApplication.laptopArray[index].getRatings()[7] = 30;
				
			}
			
		}
	
	}
	
}