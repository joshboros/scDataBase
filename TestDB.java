import java.io.File;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
        scDataBase mydb = new scDataBase();
        System.out.println("Subjects: ");
        for (String subject : mydb.getSubjects()) {
            System.out.println(subject);
            for (String section : mydb.getSections(subject)) {
                System.out.println(section);
            }
        }

        LinkedList<scRecord> records = mydb.getRecords();

        for(scRecord a : records){
            if (a.getDifficulty() == 3)
                System.out.println(a);
        }
    }


        /*
        String[] dba =  scDataBase.getDBnameArray();
        scDataBase dbArray[] = new scDataBase[scDataBase.getDBnameArray().length];
        for (String dbname : scDataBase.getDBnameArray()){

        }

        scDataBase testdefdb = new scDataBase();
        System.out.println("Opened " + testdefdb.getDBname());
        */











    }
