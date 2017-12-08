package workers;

public class Worker extends AbstractWorker {
    static private db database = new db();
    @Override
    double getNetto() {
        return getWynagrodzniaBrutto() * (0.79);
    }

    Worker(String pesel, double brutto) {
        super(pesel, brutto);
    }

    public Worker getWorker(String pesel){
        Worker worker = new Worker(pesel, 0.0);
        database.findWorker(worker);
        return worker;
    }

    public void addWorker(String pesel, double brutto){
        database.insertWorker(pesel, brutto);
    }

    public void deleteWorker(String pesel) {
        database.deleteWorker(pesel);
    }

    public void createTable() {
        database.createWorkersTable();
    }

    public void dropTable() {
        database.dropWorkersTable();
    }

    public static void main(String[] args) {
        Worker test = new Worker("123", 0.1);
        test.createTable();
        test.addWorker("123", 0.1);
        test.getWorker("123");
        test.deleteWorker("123");
        test.dropTable();

    }
}
