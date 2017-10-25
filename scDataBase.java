import java.io.IOException;
import java.lang.String;
import java.io.File;
import java.io.FilenameFilter;

/**
 * The type scDataBase
 */
public class scDataBase{
    private static final String dbDirPath = "./";   /** The path where the databases are located */
    private static final String dbFileExt = ".xml"; /** The database file extension */
    private static final String dbDefaultFileName = "default";
    File dbFile;
    private String dbFileName;
    private File dbFileObj;

    /**
     * Opens the default database.
     * This is default.xml
     */
    public scDataBase(){
        dbFileName = dbDefaultFileName;
        dbFileObj = new File(dbDirPath.concat(dbDefaultFileName.concat(dbFileExt)));
        try {
            if (dbFileObj.createNewFile()) {
                //create new xml file.
            } else {
                //file exists.
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * Opens existing database or creates a new database.
     * The database is stored as filename.xml
     *
     * @param filename  The name of the Database.
     */
    public scDataBase(String filename){
        if (filename.endsWith(dbFileExt)){
            filename = filename.substring(0, filename.length() - dbFileExt.length());
        }
        dbFileObj = new File(dbDirPath.concat(dbDefaultFileName.concat(dbFileExt)));
        try {
            if (dbFileObj.createNewFile()) {
                //create new xml file
            } else {
                //file exists.
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
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
