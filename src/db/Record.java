package db;

import java.util.Vector;

/**
 * @author 	Kyle Davies
 * @version 1.0
 * @param <T>
 * @since 	2018-04-04
 */
public class Record<T> {
	
	
	private Vector<Cell<?>> record = new Vector<Cell<?>>();
	
	/**
	 * Default Constructor 
	 */
	public Record() {
		//Default Constructor
	}
	
	/**
	 * Constructor that allows for infinite cells to be added.
	 * @param cells
	 */
	public Record(Cell<?>...cells) {
		for(Cell<?> c: cells) {
			this.record.add(c);
		}
	}
	
	/**
	 * delCell() deletes a cell at a certain index
	 * @param index
	 */
	public void delCell(int index) {
		this.record.remove(index);
	}
	
	/**
	 * addCell() adds a cell to the record.
	 * @param cell
	 */
	public void addCell(Cell<?> cell) {
		this.record.addElement(cell);
	}
	
	/***
	 * getCell() retruns a cell.
	 * @param index
	 * @return 
	 */
	public Cell<?> getCell(int index) {
		return this.record.elementAt(index);
	}
	
	/**
	 * getCells() returns an array of cells.
	 * @param to
	 * @param from
	 * @return
	 */
	public Cell<?>[] getCells(int to, int from) {
		
		// Create a array of Cells of any type of the correct size.
		Cell<?>[] arr = new Cell[from - to];
		
		// Loop through the record and add the correct cells on.
		for(int i = from; i <= to; i++) {
			arr[i] = this.record.get(i);
		}
		
		return arr;
	}
	
	public void displayRecord() {
		for(Cell<?> c: record) {
			System.out.print(c + "\t");
		}
	}
	
	
	
	
	/**
	 * Main(), a runner method to test.
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
}
