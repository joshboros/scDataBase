import java.io.File;
import java.io.FilenameFilter;

/**
 * The type scDataBase
 */
public class scDataBase{
    private static final String dbDirPath = "./";   /** The path where the databases are located */
    private static final String dbFileExt = ".xml"; /** The database file extension */
    private String dbFileName;

    /**
     * Opens the default database.
     * This is default.xml
     */
    public scDataBase(){
        getFileNameList();
    }

    /**
     * Opens existing database or creates a new database.
     * The database is stored as filename.xml
     *
     * @param filename  The name of the Database.
     */
    public scDataBase(String filename){

    }

    /**
     * Provides user with all database names currently on disk.
     * @return array of Databases
     */
    public static String[] getFileNameList(){
        File dir = new File(dbDirPath);
        File[] files = dir.listFiles((dirs, name) -> name.endsWith(".xml"));

        String[] outlist = new String[files.length];
        int i = 0;
        for (File file : files) {
            outlist[i++] = file.getName().substring(0, file.getName().length() - dbFileExt.length());;
        }
        return outlist;
    }


}
