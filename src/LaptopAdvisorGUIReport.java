import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.border.Border;

/*
 * This class creates a curated report based on user ratings (subjective) and weightings. 
 * It has GUI elements such as buttons, textareas, scroll pane and labels to easily navigate and
 * display the report information. The report information is extracted from the static array field 
 * and by accessing each laptop object through getters and setters. Also, display content method in laptop template
 * class is specifically made to display report information in the text areas
 * Author - Shreyas Peddi
 */
public class LaptopAdvisorGUIReport extends JFrame implements ActionListener {

	// Fields - Instance Variables
	// GUI Elements on the Report Screen
	private LaptopAdvisorGUIMenuBar menubar = new LaptopAdvisorGUIMenuBar();
	private JPanel reportPanel = new JPanel(); // Panel
	private ImageIcon reportImage = new ImageIcon("./Images/reportImage.png"); // Save the image into the object
	private JLabel reportImageLabel = new JLabel(reportImage); // Create a label to display the image
	private JLabel titleLabel = new JLabel(); // Screen Title label
																							// to website
	private JButton[] laptopImageButton = new JButton[3]; // laptop image array to display laptop images
	private JLabel[] btnOutlineLabelArray = new JLabel[3]; // for each button, an outline label
	
	private JLabel[] laptopTitleArray = new JLabel[3]; // Laptop Title label
	private JLabel[] laptopPointsLabel = new JLabel[3]; // Label to display overall score
	private JTextArea[] laptopTextAreaArray = new JTextArea[3]; // Textarea
	private JScrollPane[] scrollArray = new JScrollPane[3]; // Scroller to scroll through textarea
	
	private JLabel helpText = new JLabel("** Click on the laptop to visit the website"); // Help text to navigate user
	
	// Create custom colors based on RGB code. This colors will be used for labels,
	// buttons, textareas
	// https://www.java-examples.com/create-custom-color-using-rgb-example
	Color backgroundColor = new Color(214, 211, 240);
	Color borderColor = new Color(174, 167, 180);

	
	// This method(constructor) sets up the Panel, frame and creates a report by
	// calling other methods
	public LaptopAdvisorGUIReport() {

		// Setup GUI elements like panel, text area, buttons
		reportPanelSetup();

		// Setup frame size, add the panel and make the frame visible
		frameSetup();

		// Create a report using wdm algorithm
		createReport();

	}

	// This method sets up the panel, adds labels to display titles, text areas to
	// display report information, scrollers to scroll through content
	private void reportPanelSetup() {

		// Set the location for the image
		reportImageLabel.setBounds(840, 10, 235, 155);

		// REPORT PANEL: Set the dimensions and coordinates of the panel
		reportPanel.setBounds(30, 30, 1300, 630);
		reportPanel.setLayout(null);

		// Set a thick line border
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		Border mainBorder = BorderFactory.createLineBorder(borderColor, 20); // use borderColor (custom defined color)
		reportPanel.setBorder(mainBorder);

		// Set the custom created backgroun color
		reportPanel.setBackground(backgroundColor);

		// TITLE LABEL: Set the dimensions and location of the title label
		titleLabel.setBounds(460, 25, 380, 60);

		// Set the font and Text of the title label
		titleLabel.setFont(new Font("Optima", Font.BOLD, 40));
		titleLabel.setText("    FINAL REPORT");

		// Set the background and foreground colors
		titleLabel.setBackground(borderColor);
		titleLabel.setForeground(Color.black);

		// Set opaque true to make the colors visible
		titleLabel.setOpaque(true);

		// Add the label to the panel
		reportPanel.add(titleLabel);

		// Repeat the following for three times
		for (int index = 0; index < laptopTextAreaArray.length; index++) {

			// LAPTOP BUTTON: Create a button to link the web page
			laptopImageButton[index] = new JButton();

			// Add action listener to make the button clickable
			laptopImageButton[index].addActionListener(this);

			// Set the dimensions and coordinates of the button
			laptopImageButton[index].setBounds(120 + 400 * index, 125, 223, 180);

			// Add a mouse listener. When you hover over, a label in the background would be
			// displayed
			// Thereby, it creates a border effect.
			// https://stackoverflow.com/questions/33178060/java-button-hovering
			laptopImageButton[index].addMouseListener(new MouseAdapter() {

				// When mouse is hovered over, a label would be displayed (like a border)
				@Override
				public void mouseEntered(MouseEvent event) {

					// For each laptop image button
					for (int index = 0; index < laptopImageButton.length; index++) {

						// In case mouse is hovered over, do the following
						if (event.getSource() == laptopImageButton[index]) {

							// Set visibility of a new label to true
							btnOutlineLabelArray[index].setVisible(true);

							// Refresh
							repaint();
						}
					}

				} // End of method

				// When mouse is not hovered over, label should be removed (no border)
				@Override
				public void mouseExited(MouseEvent event) {

					// For each laptop image button
					for (int index = 0; index < laptopImageButton.length; index++) {

						// In case mouse is not hovered over, do the following
						if (event.getSource() == laptopImageButton[index]) {

							// Set visibility of the label to false
							btnOutlineLabelArray[index].setVisible(false);

							// Refresh
							repaint();
						}
					}

				} // End of method
			});

			// Add the button to the panel
			reportPanel.add(laptopImageButton[index]);

			// BUTTON OUTLINE LABEL: Create a button outline which gets highligted when
			// mouse is hovered over
			btnOutlineLabelArray[index] = new JLabel();

			// Set the dimensions and coordinates of the labels
			btnOutlineLabelArray[index].setBounds(112 + (index * 400), 115, 240, 200);

			// Set the background color
			btnOutlineLabelArray[index].setBackground(borderColor);

			// Set Opaque to true to make the colors visible
			btnOutlineLabelArray[index].setOpaque(true);

			// Set the default visibility as false since it should be acitivated only when
			// the mouse is hovered over
			btnOutlineLabelArray[index].setVisible(false);

			// Add the button outline label
			reportPanel.add(btnOutlineLabelArray[index]);

			// LAPTOP TITLE LABEL: Displays laptop title
			laptopTitleArray[index] = new JLabel();

			// Set the dimensions and coordinates of the labels
			laptopTitleArray[index].setBounds(90 + 400 * index, 320, 300, 30);

			// Set Font, background and foreground colors
			laptopTitleArray[index].setFont(new Font("Franklin", Font.BOLD, 18));
			laptopTitleArray[index].setBackground(borderColor); // Set color to custom created color
			laptopTitleArray[index].setForeground(Color.black);

			// Set Opaque to true to make the colors visible
			laptopTitleArray[index].setOpaque(true);

			// Add the laptop title label to the panel
			reportPanel.add(laptopTitleArray[index]);

			// LAPTOP POINTS LABEL: Displays overall score of the laptop on a label
			laptopPointsLabel[index] = new JLabel();

			// Set the dimensions and coordinates of the labels
			laptopPointsLabel[index].setBounds(305 + 400 * index, 340, 300, 30);

			// Set font, size and foreground color
			laptopPointsLabel[index].setFont(new Font("Franklin", Font.BOLD, 12));
			laptopPointsLabel[index].setForeground(Color.black);

			// Add the label to the panel
			reportPanel.add(laptopPointsLabel[index]);

			// TEXT AREA: Create a text areas to display report information
			laptopTextAreaArray[index] = new JTextArea();

			// Set the font of the text area
			laptopTextAreaArray[index].setFont(new Font("Franklin", Font.BOLD, 13));
			laptopTextAreaArray[index].setBackground(backgroundColor);
			laptopTextAreaArray[index].setForeground(Color.black);

			// Set the text area to be non editable
			laptopTextAreaArray[index].setEditable(false);

			// Set line wrap to make the text go to the next line
			// https://www.codota.com/code/java/methods/javax.swing.JTextArea/setLineWrap
			laptopTextAreaArray[index].setLineWrap(true);
			laptopTextAreaArray[index].setWrapStyleWord(true);

			// Attach the scroller to the textarea
			scrollArray[index] = new JScrollPane(laptopTextAreaArray[index], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

			// Set the coordinates and size for the scroller. This will automatically set
			// the coordinates for the textarea as it is attached to it
			scrollArray[index].setBounds(90 + 400 * index, 365, 300, 220);

			// Add the scroller object only (which is already attached to textarea)
			reportPanel.add(scrollArray[index]);

		} // End of loop

		// Set the coordinates of the help text label which lets the user know to click
		// the image
		helpText.setBounds(1000, 633, 300, 30);

	}

	// This method sets up the frame of the application. The frame of the
	// application holds the panel and the menu bar
	private void frameSetup() {

		// Set the size of the frame
		setSize(1368, 750);
		setLayout(null);

		// Add the menubar object to the frame
		setJMenuBar(menubar);

		// Add the custom image to the frame
		add(reportImageLabel);

		// This sets the background colour of the frame
		// https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
		getContentPane().setBackground(backgroundColor);

		// This adds the text label onto the frame (outside the panel)
		// http://www.mathcs.emory.edu/~cheung/Courses/377/Syllabus/8-JDBC/GUI/containers
		getContentPane().add(helpText);

		// Set the title of the screen
		setTitle("Laptops Report Screen");

		// Add the report panel (consisting of GUI elements) to the frame
		add(reportPanel);

		// Set the visibility to true, so that the frame is visible
		setVisible(true);

	} 

	// This method creates a curated report by ranking the best possible laptop for
	// the user
	private void createReport() {

		// Ranks the laptops based on the weightings and ratings available
		rankLaptops();

		// The report panel is added to the frame to update
		add(reportPanel);

		// Allows the screen to be refreshed
		repaint();

	}

	// This method runs the logic behind determining the best match laptop for the
	// user. A score is calculated for every laptop and the highest score laptops
	// are displayed
	private void rankLaptops() {

		// Local variable to display a specific message for each standing
		String laptopChoiceMessage;

		// Iterate over the list of laptops and determine a score for each laptop
		for (Laptop currentLaptop : LaptopAdvisorApplication.laptopArray)

			// Determine the score and store the overall score of the laptop
			currentLaptop.setOverallScore((wdm(currentLaptop)));

		// Sort laptopArray in descending order based on overall score - .reversed()
		// method ensures that laptops are sorted from highest score to lowest score
		Arrays.sort(LaptopAdvisorApplication.laptopArray, Comparator.comparing(Laptop::getOverallScore).reversed());

		// For number of text areas, iterate over and update the report
		for (int index = 0; index < laptopTextAreaArray.length; index++) {

			// Display laptop information by setting the appropriate text to the text area
			laptopTextAreaArray[index].setText(LaptopAdvisorApplication.laptopArray[index].displayContent());

			// Display the laptop icon by setting appropriate icon onto the button
			laptopImageButton[index].setIcon(new ImageIcon(
					new ImageIcon("./images/" + LaptopAdvisorApplication.laptopArray[index].getImageFile()).getImage()
							.getScaledInstance(220, 180, 0)));

			// Display a message for each position of the top 3 laptops
			if (index == 0)
				laptopChoiceMessage = " (Best)"; // 1st place

			else if (index == 1)
				laptopChoiceMessage = " (2nd Best)"; // 2nd place

			else
				laptopChoiceMessage = " (3rd Best)"; // 3rd place

			// Set the laptop title text
			laptopTitleArray[index].setText(" " + LaptopAdvisorApplication.laptopArray[index].getBrand() + " "
					+ LaptopAdvisorApplication.laptopArray[index].getModel() + laptopChoiceMessage);

			// Set the total overall points
			laptopPointsLabel[index]
					.setText("Overall Score: " + LaptopAdvisorApplication.laptopArray[index].getOverallScore());

		} // End of loop

	} // End of method

	/*
	 * Weighted Decision Matrix is quantitative technique which uses multiple
	 * criteria to compare different things. This method uses the wdm approach to
	 * calculate an objective score for the laptop.
	 */
	private int wdm(Laptop currentLaptop) {

		// Keeps track of the total score
		int totalScore = 0;

		// Calculate the total score
		for (int index = 0; index < currentLaptop.getRatings().length; index++)

			// Multiply the weightings by the ratings to determine a final score
			totalScore += LaptopAdvisorApplication.user.getWeighting()[index] * currentLaptop.getRatings()[index];

		// Return the total score
		return totalScore;
	}

	// Action Listener which performs appropriate action(navigating to website)
	// based on event source
	@Override
	public void actionPerformed(ActionEvent event) {

		// For every button clicked, perform an appropriate action
		for (int index = 0; index < laptopImageButton.length; index++) {

			// In case one of the buttons is clicked, do the following
			if (event.getSource() == laptopImageButton[index])

				// Open laptop website by accessing the hyperlink
				openWebBrowser(index);
		}

	} // End of method

	// This method opens the website link of a laptop given the index of the laptop
	private void openWebBrowser(int index) {

		// Check if browser is supported
		if (Desktop.isDesktopSupported()) {

			try {
				// Navigate to the laptop website by accessing the Laptop's field
				Desktop.getDesktop().browse(new URI(LaptopAdvisorApplication.laptopArray[index].getHyperLink()));

				// Catch an exception if there are any
			} catch (IOException e1) {

				// Display the exception to the console
				e1.printStackTrace();
			} catch (URISyntaxException e1) {

				// Display the exception to the console
				e1.printStackTrace();
			}
		}

	} // End of method

} // End of class
