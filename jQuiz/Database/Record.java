import java.util.Vector;

/**
 * @author  C1740129
 * @author  Kyle Morris
 * @version 1.0
 * @since   2018-04-04
 */
public class Record {
    
    Vector<Cell> cell = new Vector<Cell>();

    public Record() {
        //Default Constructor
    }

    public Record(Cell...cell) {
        for(Cell c: cell){
            this.cell.add(c);
        }
    }

    /**
     * getCell()
     * @param id
     */
    public String getCell(int id) {
        this.cell.get(id);
    }

    /**
     * setCell()
     * @param id
     */
    public void setCell(int id) {
        this.cell.del(id);
    }

    public static void main(String[] args) {
        
        Cell c1 = new Cell("Kyle");
        Cell c2 = new Cell('d');
        Cell c3 = new Cell(17);
        
        Record r = new Record(c1, c2, c3);

    
    


    }


}