import java.util.Arrays;

/*
 * This is a template class
 * 
 * Author - Darren Sin
 */

public class User {
	
	//Fields - Instance variables
	private String name;
	private int[] weighting = new int[8];
	
	//Setter and getter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getWeighting() {
		return weighting;
	}
	public void setWeighting(int[] weighting) {
		this.weighting = weighting;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", weighting=" + Arrays.toString(weighting) + "]";
	}
	
	

}
