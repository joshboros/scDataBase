import java.io.File;
/**
 * The type TestDB.
 */
public class TestDB {

    /**
     * Print dbnames.
     */
    public static void printDBnames(){
        System.out.println("Database Names on Disk: ");
        for (String filename : scDataBase.getDBnameArray()){
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
        scDataBase[] dba =  scDataBase.getDBnameArray();
        scDataBase dbArray[] = new scDataBase[scDataBase.getDBnameArray().length];
        for (String dbname : scDataBase.getDBnameArray()){

        }

        scDataBase testdefdb = new scDataBase();
        System.out.println("Opened " + testdefdb.getDBname());











    }
}
