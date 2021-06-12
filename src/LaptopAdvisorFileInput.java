import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This class reads a spreadsheet file (csv format) which contains information regarding laptops (Brand, Memory, Storage, CPU, Ratings).
 * It then updates the information in a laptop array (belongs to the LaptopAdvisorAppplication class).
 * Author: Shreyas Peddi
 */
public class LaptopAdvisorFileInput {

	// This method (constructor) reads information from csv file and updates it in the laptop
	// array of the application class
	public LaptopAdvisorFileInput() {

		try {

			// Read the csv(comma seperated values) file
			Scanner input = new Scanner(new File("laptop.csv"));
			
			//Set up a delimeter which seperates each word by ',' or a new line character(\n)
			input.useDelimiter(",|\\r\\n");

			// Ignore the first line which contains column headings
			input.nextLine();

			// Start with index=0 to update the laptopArray
			int index = 0;

			// As long as there is another line of information, keep doing the following
			while (input.hasNextLine()) {

				// Create a new laptop object by taking an instance of the Laptop class
				LaptopAdvisorApplication.laptopArray[index] = new Laptop();

				// Keep storing the next values and set it to the corresponding fields of the
				// Laptop object
				LaptopAdvisorApplication.laptopArray[index].setBrand(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[0] = input.nextInt(); // Brand Rating

				LaptopAdvisorApplication.laptopArray[index].setModel(input.next());
				LaptopAdvisorApplication.laptopArray[index].setType(input.next());
				LaptopAdvisorApplication.laptopArray[index].setPrice(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setCpuBrand(input.next());
				LaptopAdvisorApplication.laptopArray[index].setCpuModel(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[1] = input.nextInt(); // CPU Rating

				LaptopAdvisorApplication.laptopArray[index].setRamSizeGB(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setRamType(input.next());
				LaptopAdvisorApplication.laptopArray[index].setHardDriveGB(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setSsdGB(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setGpuBrand(input.next());
				LaptopAdvisorApplication.laptopArray[index].setGpuModel(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[2] = input.nextInt(); // GPU rating

				LaptopAdvisorApplication.laptopArray[index].setPortsDescription(input.next());
				LaptopAdvisorApplication.laptopArray[index].setNumOfPorts(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[3] = input.nextInt(); // Connectivity Rating

				LaptopAdvisorApplication.laptopArray[index].setHours(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setSoftware(input.next());
				LaptopAdvisorApplication.laptopArray[index].setDisplaySize(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setResWidth(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setResHeight(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setTouchScreen(input.nextBoolean());
				LaptopAdvisorApplication.laptopArray[index].setDepth(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setWidth(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setHeight(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setWeight(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setWarrantyYears(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setHyperLink(input.next());
				LaptopAdvisorApplication.laptopArray[index].setImageFile("laptop" + index + ".jpg");	//Set the image file by accessing index(counter)

				// Display object(laptop) information
				System.out.println(LaptopAdvisorApplication.laptopArray[index]);

				// Increment the index to access next laptop object
				index++;

			} // End of loop

			input.close();

		} catch (FileNotFoundException error) {

			// Display the error to the console
			System.out.println("Sorry file not loading - please check the name/location");
		}

	}	//End of method
	
}	//End of class
