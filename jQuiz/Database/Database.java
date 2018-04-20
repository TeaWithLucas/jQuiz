public class Database {

    Vector<Field> records = new Vector<Field>();

    /**
     * Default Constructor, add records into the database.
     * @param Record
     */
    public Database(Record...record) {
        for(Record r: record) {
            this.records.add(r);
        }
    }

    public void addRecord(Record r) {
        this.records.add(r);
    }

    public void delRecord(int id)   {
        this.records.del(id);
    }

}