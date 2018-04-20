package db;

/**
 * @author 	Kyle Davies
 * @version 1.0
 * @since 	2018-04-04
 */
public class Cell<T> {
	
	private T cell;
	
	/**
	 * Default Constructor
	 */
	public Cell() {
		//Default Constructor
	}
	
	/**
	 * Constructor
	 * @param value
	 */
	public Cell(T value) {
		this.cell = value;
	}
	
	/**
	 * getCell()
	 * @return
	 */
	public T getCell() {
		return this.cell;
	}
	
	/**
	 * setCell()
	 * @param value
	 */
	public void setCell(T value) {
		this.cell = value;
	}
	
	/**
	 * toString()
	 * @return a String reprenstation of Cell<?>
	 */
	public String toString() {
		return String.valueOf(this.cell);
	}
	
	/**
	 * Main(), a runner method to test.
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
}
