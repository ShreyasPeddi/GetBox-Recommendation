/* Project header
 * 
 * Name(s): Shreyas Peddi, Darren Sin, Regina Liang, Tony Yu
 * Date: June 4, 2021
 * Course code: ICS3U1-09
 * Purpose: To create an application that produces a report for user by displaying
 * the top three laptops that best match their needs. 
 * 
 * Major skills: File Input, GUI (Panel, Labels, Text areas, Buttons), Arrays, Weighted Decision Matrix, Combo Boxes, Static variables, Files, Delimiters, Handling Expectations Control Structures,
 * Sorting Array Objects, Conditional loops, Nested loops
 * 
 * Classes within the program:
 * Application: This class takes laptop information from the Csv file (specific information of laptops), creates multiple GUI screens which represent the Laptop advisor application
 * User: This is a template class that gets the users weighting input
 * Laptop: This is a template class contains informations of laptops
 * LaptopAdvisorFileInput: Reads the spreadsheet file where contain informations of all the laptops, and updates the laptop array in the application class
 * LaptopGUIHelp: Allow the user to see if they need further informations within the application 
 * LaptopGUIMenuBar: A menu bar in the report screen which allow the user to click "Help", "Exit" or "Restart"
 * 
 * LaptopAdvisorGUIUserRatings: This class will create and display a frame that allows the user to select their ratings and preferences
 * LaptopAdvisorGUIUserWeightings: This class will create a display a frame that allows the user to select their weightings (how much they care about each of the ratings)
 * LaptopAdvisorGUIReport: This class will produce a report for user and display a frame with the final result of the top 3 laptops that match their needs
 * 
 * Extra features:
 * LaptopAdvisorGUIUserRatings: Implemented custom colors, added borders around the panels, underlined text, added bordered description, added images
 * changed the frame color, button color
 * 
 * LaptopAdvisorGUIUserWeightings: Added outline around the panel, added image, changed the title color, button color.
 * 
 * LaptopAdvisorGUIReport: Added mouse listener so that a border gets displayed around buttons when mouse is hovered over. Added scroller to text areas.
 * Improvised text areas by setting line wrap and word wrap and also spacing out laptop information.  Added extra text to help 
 * the user to navigate through. Added border around the panel. Created custom colors using online color pallette generator and 
 * incorporated RGB into code. Changed color and font for labels. Added an image for visual appeal.
 * 		
 * LaptopAdvisorGUIHelp: Background color
 * Areas of concern: None
 */

/*
 * This class takes laptop information from the Csv file, and creates multiple GUI screens which represent the Laptop advisor application
 * 
 * author - Regina Liang
 */
public class LaptopAdvisorApplication {

	// Store the list of laptops
	public static Laptop[] laptopArray = new Laptop[40];

	// Create User object which represents the user of this application
	public static User user = new User();

	// This method runs the application
	public static void main(String[] args) {

		new LaptopAdvisorFileInput(); // FileInput class

		new LaptopAdvisorGUIUserRatings(); // UserRatings class

	} // End of main

} // End of class