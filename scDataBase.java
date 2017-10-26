import java.io.IOException;
import java.lang.String;
import java.io.File;

/**
 * The type scDataBase
 */
public class scDataBase{
    public static final String dbDefaultDirPath = "./";   /** The path where the databases are located */
    public static final String dbFileExt = ".xml";        /** The database file extension */
    public static final String dbDefaultName = "default"; /** The Default database Name */
    private String dbName;      /** The name of an instance's database. */
    private File dbFileObj;     /** The path/file of an instance's database. */

    @Override
    public String toString() {
        return dbName;
    }

    /**
     * Get the name of the current DataBase.
     *
     * @return the string
     */
    public String getDBname(){
        return dbName;
    }

    /**
     * Generate a .pdf of the current Database.
     * @return File
     */
    public File getPDF(){

    }

    /**
     * Generate a .html of the current Database.
     * @return
     */
    public File getHtml(){

    }

    /**
     * Generate a .tex of the current Database.
     * @return File
     */
    public File getLatex(){

    }

    /**
     * Get current DataBase file object.
     * @return the file
     */
    public File getDBfileObj(){
        return dbFileObj;
    }

    /**
     * Opens the default database.
     * This is default.xml
     */
    public scDataBase(){
        dbName = dbDefaultName;
        dbFileObj = new File(dbDefaultDirPath.concat(dbDefaultName.concat(dbFileExt)));
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
     * @param filename The name of the Database.
     */
    public scDataBase(String filename){
        if (filename.endsWith(dbFileExt)){
            filename = filename.substring(0, filename.length() - dbFileExt.length());
        }
        dbFileObj = new File(dbDefaultDirPath.concat(dbDefaultName.concat(dbFileExt)));
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
     *
     * @return array of Database names.
     */
    public static String[] getDBnameArray(){

        File dir = new File(dbDefaultDirPath);
        File[] files = dir.listFiles((dirs, name) -> name.endsWith(dbFileExt));

        String[] outlist = new String[files.length];
        int i = 0;
        for (File file : files) {
            outlist[i++] = file.getName().substring(0, file.getName().length() - dbFileExt.length());;
        }
        return outlist;
    }
}
