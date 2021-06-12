import java.util.Arrays;

/*
 * This is a template class that contains the information and specifications of the laptop.
 * 
 * Author - Darren Sin
 */

public class Laptop {
	
	//Fields - Instance variables
	//Specs of the laptop
	private String brand;
	private String model;
	private String type;
	private double price;
	private String cpuBrand;
	private String cpuModel;
	private int ramSizeGB;
	private String ramType;
	private int hardDriveGB;
	private int ssdGB;
	private String gpuBrand;
	private String gpuModel;
	private String portsDescription;
	private int numOfPorts;
	private int hours;
	private String software;
	private double displaySize;
	private int resWidth;
	private int resHeight;
	private boolean touchScreen;
	private double depth;
	private double width;
	private double height;
	private double weight;
	private int warrantyYears;
	
	private String hyperLink; //Link to the laptop listing webpage
	private String imageFile; //The image of the laptop
	private int[] ratings = new int[8];
	private int pos;
	private int overallScore; //Overall score of the laptop
	private String ifTouchScreen;
	
	//Setter and Getter methods
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCpuBrand() {
		return cpuBrand;
	}
	public void setCpuBrand(String cpuBrand) {
		this.cpuBrand = cpuBrand;
	}
	public String getCpuModel() {
		return cpuModel;
	}
	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}
	public int getRamSizeGB() {
		return ramSizeGB;
	}
	public void setRamSizeGB(int ramSizeGB) {
		this.ramSizeGB = ramSizeGB;
	}
	public String getRamType() {
		return ramType;
	}
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	public int getHardDriveGB() {
		return hardDriveGB;
	}
	public void setHardDriveGB(int hardDriveGB) {
		this.hardDriveGB = hardDriveGB;
	}
	public int getSsdGB() {
		return ssdGB;
	}
	public void setSsdGB(int ssdGB) {
		this.ssdGB = ssdGB;
	}
	public String getGpuBrand() {
		return gpuBrand;
	}
	public void setGpuBrand(String gpuBrand) {
		this.gpuBrand = gpuBrand;
	}
	public String getGpuModel() {
		return gpuModel;
	}
	public void setGpuModel(String gpuModel) {
		this.gpuModel = gpuModel;
	}
	public String getPortsDescription() {
		return portsDescription;
	}
	public void setPortsDescription(String portsDescription) {
		this.portsDescription = portsDescription;
	}
	public int getNumOfPorts() {
		return numOfPorts;
	}
	public void setNumOfPorts(int numOfPorts) {
		this.numOfPorts = numOfPorts;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public double getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}
	public int getResWidth() {
		return resWidth;
	}
	public void setResWidth(int resWidth) {
		this.resWidth = resWidth;
	}
	public int getResHeight() {
		return resHeight;
	}
	public void setResHeight(int resHeight) {
		this.resHeight = resHeight;
	}
	public boolean isTouchScreen() {
		return touchScreen;
	}
	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
		
		//Set touch screen field to yes if is true and no otherwise
		if(touchScreen)
			this.ifTouchScreen="yes";
		else
			this.ifTouchScreen="no";
		
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getWarrantyYears() {
		return warrantyYears;
	}
	public void setWarrantyYears(int warrantyYears) {
		this.warrantyYears = warrantyYears;
	}
	public String getHyperLink() {
		return hyperLink;
	}
	public void setHyperLink(String hyperLink) {
		this.hyperLink = hyperLink;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public int[] getRatings() {
		return ratings;
	}
	public void setRatings(int num) {
		this.ratings[pos++] = num;
	}
	public int getOverallScore() {
		return overallScore;
	}
	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price + ", cpuBrand="
				+ cpuBrand + ", cpuModel=" + cpuModel + ", ramSizeGB=" + ramSizeGB + ", ramType=" + ramType
				+ ", hardDriveGB=" + hardDriveGB + ", ssdGB=" + ssdGB + ", gpuBrand=" + gpuBrand + ", gpuModel="
				+ gpuModel + ", portsDescription=" + portsDescription + ", numOfPorts=" + numOfPorts + ", hours="
				+ hours + ", software=" + software + ", displaySize=" + displaySize + ", resWidth=" + resWidth
				+ ", resHeight=" + resHeight + ", touchScreen=" + touchScreen + ", depth=" + depth + ", width=" + width
				+ ", height=" + height + ", weight=" + weight + ", warrantyYears=" + warrantyYears + ", hyperLink="
				+ hyperLink + ", imageFile=" + imageFile + ", ratings=" + Arrays.toString(ratings) + ", overallScore="
				+ overallScore + "]";
	}
	
	//Display Laptop information formatted specifically for text area
	public String displayContent() {
		
		return "Laptop brand: " + brand + "\nModel: " + model + "\nType: " + type + "\n\nPrice: $" + price + "\n\nCPU Brand: "
				+ cpuBrand + "\nCPU Model:" + cpuModel + "\n\nRAM Size: " + ramSizeGB + " GB"+"\nRAM Type: " + ramType
				+ "\nStorage (hardrive): " + hardDriveGB + ", Storage(SSD): " + ssdGB + "\n\nGPU Brand: " + gpuBrand + "\nGPU Model:"
				+ gpuModel + "\n\nPorts: " + portsDescription + "\nNumber of Ports: " + numOfPorts + "\n\nBattery Life: "
				+ hours +"hrs"+ "\n\nSoftware: " + software + "\n\nDisplay Size: " + displaySize + " inch"+"\n" + "Resoltion: "+resWidth
				+ "x" + resHeight + "\n\nTouch Screen: " + ifTouchScreen + "\n\nDepth: " + depth + "(in)"+", Width: " + width
				+ "(in)"+", Height: " + height + "(in)"+", Weight: " + weight + "lbs"+"\n\nWarranty: " + warrantyYears+ " year(s)";
	}
	
}
