/**
 * The type TestDB.
 */
public class TestDB {


    /**
     * Print dbnames.
     */
    public static void printDBnames(){
        System.out.println("Database Names on Disk: ");
        for (String filename : scDataBase.getFileNameList()){
            System.out.println(filename);
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        printDBnames();


    }
}
