import java.io.IOException;
import java.lang.String;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

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
    private Document dbDom;
    private final String domRoot = "TestBank";

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
            } else {
                parseXml();
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
                parseXml();
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
    public int addQuestion(scRecord newQuestion) {
        return 0;

    }


    /**
     * Get list of all subjects in Database.
     *
     * @return the string [ ]
     */
    public String[] getSubjects(){
        NodeList nl = dbDom.getElementsByTagName("subject");
        // Get unique occurrences of the subject.
        Set<String> subjects = new HashSet<String>( );
        for(int i = 0 ; i < nl.getLength(); i++) {
           subjects.add(nl.item(i).getTextContent());
        }
        String subj[] = new String[subjects.size()];
        subj = subjects.toArray(subj);
        return subj;
    }

    /**
     * Get a list of section numbers for a subject.
     *
     * @param subject the subject name.
     * @return the String [ ]
     */
    public String[] getSections(String subject){
        String expression = "/" + domRoot + "/question[subject='" + subject + "']/section";
        Set<String> sections = new HashSet<String>();

        XPath xp = XPathFactory.newInstance().newXPath();
        try {
            XPathExpression xpExp = xp.compile(expression);
            NodeList nl = (NodeList) xpExp.evaluate(dbDom,XPathConstants.NODESET);
            for (int i = 0; i < nl.getLength(); i++){
                sections.add(nl.item(i).getTextContent());
            }
        } catch (XPathExpressionException xpee){
            xpee.printStackTrace();
        }

        String sect[] = new String[sections.size()];
        sect = sections.toArray(sect);
        return sect;
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

    /**
     * Get multiple records from this database and add them to another.
     *
     * @param toThisDb   The database to add the records to. The databases must have different names. If the names are the same, the return value is false.
     * @param subject    A list of subjects to get.
     * @param section   A list of Sections to get. If multiple subjects are specified in subject, then get each section as it exists under subject.
     * @param subsection A list subsection to get. If multiple subjects and/or sections are specified then get each subsection under each of the subject's sections.
     * @param difficulty Only add records of the specified difficulty levels.
     * @return True if records were added successfully. False if a problem occurred.
     */
    public boolean multiGet(scDataBase toThisDb, String[] subject, int[] section, int[] subsection, scRecord.DifficultyLevel[] difficulty){
        return false;


    }
/*
    public int[] getIDs(String [] subject, int[] section, int[] subsection, scRecord.DifficultyLevel difficulty){

        return();

    }
    */


    /**
     * Get multiple records by Question ID and add them to another database.
     *
     * @param toThisDb   The database to add the records to. The databases must have different names. If the names are the same, the return value is false.
     * @param questionID the id's of the records to add.
     * @return True if records were added successfully. False if a problem occurred.
     */
    public boolean multiGet(scDataBase toThisDb, int ...questionID){
        return false;

    }

    private void parseXml(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dbDom = db.parse(dbFileObj);


        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch(SAXException se) {
            se.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }



}
