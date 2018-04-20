
/**
 * @author  C1740129
 * @author  Kyle Morris
 * @version 1.0
 * @since   2018-04-04
 */
public class Cell<T> {  

    private T cellValue;

    /**
     * Constructor creates a cell with a value.
     * @param value
     */
    public Cell(T value){
        this.cellValue = value;
    }

    /*
     * getCell() gets the value of a cell.
     */
    public T getCell() {
        return this.cellValue;
    }

    /**
     * setCell() sets the value of a cell.
     * @param value
     */
    public void setCell(T value){
        this.cellValue = value;
    }

    /**
     * main() runner method
     * @param args
     */
    public static void main(String[] args) {
        
        Cell c1 = new Cell("Hello World");
        Cell c2 = new Cell(7);
        Cell c3 = new Cell('a');
        Cell c4 = new Cell(1.4);

        System.out.println(c1.getValue());
        System.out.println(c2.getValue());
        System.out.println(c3.getValue());
        System.out.println(c4.getValue());

    }

}