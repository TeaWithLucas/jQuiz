package db;

import java.util.Vector;
import java.util.Arrays;

/**
 * @author 	Kyle Davies
 * @version 1.0
 * @since 	2018-04-04
 */
public class Database {

	// Database Name
	private String name;
	
	// Database Fields
	private Vector<Record<String>> fields;
	
	// Database Records
	private Vector<Record<?>> database;
	
	/**
	 * Default Constructor
	 */
	public Database(String name) {
		this.name = name;
		this.database = new Vector<Record<?>>();
	}
	
	public Database(String name, int size) {
		this.name = name;
		this.database = new Vector<Record<?>>(size);
	}
	
	/**
	 * Constructor that allows infinite records to be added.
	 * @param record
	 * @param fields 
	 */
	public Database(String name, String[] fields, Record<?>...record) {
		
		this.database = new Vector<Record<?>>();
		
		for(Record<?>  r: record) {
			this.database.add(r);
		}
		this.name = name;
	}
	
	// Get Records
	
	/**
	 * getRecord()
	 * @param id
	 * @return
	 */
	public Record<?> getRecord(int id) {
		return this.database.elementAt(id);
	}
	
	/**
	 * getRecords() returns an array of records.
	 * @param to
	 * @param from
	 * @return
	 */
	public Record<?>[] getRecords(int from, int to) {
		
		// Create a array of Records of any type of the correct size.
		Record<?>[] arr = new Record[from - to];
		
		// Loop through the Database and add the correct cells on.
		for(int i = from; i <= to; i++) {
			arr[i] = this.database.get(i);
		}
		
		return arr;
	}
	
	// Get Fields
	
	/**
	 * getField() with index
	 * @param id
	 * @return
	 */
	public Cell<?> getCell(int index) {
		return this.database.elementAt(1).getCell(index);
	}
	
	/**
	 * getFeilds() from an index to another index.
	 * @param from
	 * @param to
	 * @return
	 */
	public Cell<?>[] getFields(int from, int to) {
		
		// Create a array of Cells of any type of the correct size.
		Cell<?>[] arr = new Cell[from - to];
			
		// Loop through the record and add the correct cells on.
		for(int i = from; i <= to; i++) {
			arr[i] = this.database.elementAt(i).getCell(i);
		}
			
		return arr;
	}
	
	public Cell<?> getField(String fieldname, int index) {
		
		int index = getColumnNumber(fieldname);
		
		return this.database.elementAt(index).getCell(index);
		
		
	}
	
	public Cell<?>[] getFeilds(String fieldname) {
		
		int index = getColumnNumber(fieldname);
		
		for(Cell<?>[] c: this.database.elementAt(index))
		
		
		
	}

	public Cell<?>[] getFields(String fieldname, int from, int to) {
		
	}
	
	// Get Cells 
	
	
	// DONE
	
	/**
	 * getColumnNumber() 
	 * @param fieldname
	 * @return
	 */
	private int getColumnNumber(String fieldname) {
		
		int flag = -1;
		
		for(int i = 0; i < fields.size(); i++) {
			if( this.database.elementAt(i).equals(fieldname) ) {
				return flag;
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
	
		Cell<String> c1 = new Cell<>("Kyle");
		Cell<Character> c2 = new Cell<>('D');
		Cell<Double> c3 = new Cell<Double>(6.1);
		
		Cell<String> c4 = new Cell<>("Kay");
		Cell<Character> c5 = new Cell<>('J');
		Cell<Double> c6 = new Cell<Double>(5.5);
		
		Cell<String> c7 = new Cell<>("Flynn");
		Cell<Character> c8 = new Cell<>('E');
		Cell<Double> c9 = new Cell<Double>(6.1);
		
		Record<Cell<?>> r1 = new Record<Cell<?>>(c1, c2, c3);
		Record<Cell<?>> r2 = new Record<Cell<?>>(c4, c5, c6);
		Record<Cell<?>> r3 = new Record<Cell<?>>(c7, c8, c9);
		
		r1.displayRecord();
		r2.displayRecord();
		r3.displayRecord();
		
		String[] fields = {"Forename", "Surname", "Height"};
		
		Database d = new Database("People", fields, r1, r2, r3);
		
		
	}
	
}
/*
 * 
 * 			FORENAME	SURNAME		HEIGHT
 * 			========	=======		======	
 * 	 ID1	"KYLE"		'D'			5.12
 * 	 ID2	"KAY"		'J'			5.5
 *	 ID3	"FLYNN"		'E' 		6.1
 * 
 * 	
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
