import java.io.IOException;
import java.lang.String;
import java.io.File;
import java.util.*;

//Reading and writing DOM
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * The type scDataBase
 */
public class scDataBase{

    /**
     * The path where the databases are located
     */
    public static final String dbDefaultDirPath = "./";

    /**
     * The database file extension
     */
    public static final String dbFileExt = ".xml";

    /**
     * The Default database Name
     */
    public static final String dbDefaultName = "default";

    private String dbName;      /** The name of the instance's database. */
    private File dbFileObj;     /** The path/file of the instance's database. */
    private final String domRoot = "TestBank";
    private domTool dtool;

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
     *
     * @return File file
     */
    public File getPDF(){
        return dbFileObj;

    }

    /**
     * Generate a .html of the current Database.
     *
     * @return File file
     */
    public File getHtml(){
        return dbFileObj;

    }

    /**
     * Generate a .tex of the current Database.
     *
     * @return File file
     */
    public File getLatex(){
        return dbFileObj;

    }

    /**
     * Get current DataBase file object.
     *
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
        //TODO This opens the default database in the directory that the program was executed. The main repo is going to import our repo a directory below. We need to make sure that the existing database file(s) still open correctly.
        dbName = dbDefaultName;
        dbFileObj = new File(dbDefaultDirPath.concat(dbDefaultName.concat(dbFileExt)));
        try {
            if (dbFileObj.createNewFile()) {
                //create new xml file.
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        dtool = new domTool(dbFileObj);
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
                //parseXml();
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

    /**
     * Add question to Database.
     *
     * @return The added Question's ID value.
     */
    public void addRecord(scRecord newQuestion) {


    }


    /**
     * Get list of all subjects in Database.
     *
     * @return the string [ ]
     */
    public String[] getSubjects(){
        return dtool.getSubjects();

    }

    /**
     * Get a list of section numbers for a subject.
     *
     * @param subject the subject name.
     * @return the String [ ]
     */
    public String[] getSections(String subject){
        return dtool.getSections(subject);
    }

    /**
     * Get a list of subsections for a Subject's Section number.
     *
     * @param subject The subject name
     * @param section The subject's section
     * @return the int [ ]
     */
    public int[] getSubSection(String subject, int section){
        int[] subSections = {};

        return subSections;
    }

    public LinkedList<scRecord> getRecords() {
        return dtool.parse();
    }

    public void replaceRecords(){


    }




}
