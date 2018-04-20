package jQuiz.database;

import java.util.Vector;

/**
 * @author  C1740129
 * @author  Kyle Morris
 * @version 1.0
 * @since   2018-04-04
 */
public class Database {

    Vector<Record> records = new Vector<Record>();

    /**
     * Default Constructor, add records into the database.
     * @param Record
     */
    public Database(Record...record) {
        for(Record r: record) {
            this.records.add(r);
        }
    }

    /**
     * addRecord() add record to the database.
     */
    public void addRecord(Record r) {
        this.records.add(r);
    }

    /**
     * delRecord() del record from the database.
     */
    public void delRecord(int id)   {
        this.records.del(id);
    }

}