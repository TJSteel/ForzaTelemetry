package car;

/**
 *
 * @author Jay
 */
public class CarType {
	// {{ variables
	private int carOrdinal; 
	private String manufacturer;
	private int yearOfManufacture;
	private String description;
    // }} variables

	// {{ Constructor
	public CarType(int carOrdinal, int yearOfManufacture, String manufacturer, String description) {
    	this.setCarOrdinal(carOrdinal);
    	this.setYearOfManufacture(yearOfManufacture);
    	this.setManufacturer(manufacturer);
    	this.setDescription(description);
    }
	// }} Constructor
    
    // {{ Getters and Setters
	/**
	 * @return the carOrdinal
	 */
	public int getCarOrdinal() {
		return carOrdinal;
	}
	/**
	 * @param carOrdinal the carOrdinal to set
	 */
	public void setCarOrdinal(int carOrdinal) {
		this.carOrdinal = carOrdinal;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the yearOfManufacture
	 */
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	/**
	 * @param yearOfManufacture the yearOfManufacture to set
	 */
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	// }} Getters and Setters
}
