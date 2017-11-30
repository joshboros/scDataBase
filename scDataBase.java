import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.Writer;
import java.lang.String;
import java.io.File;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;

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
        LinkedList<scRecord> records = getRecords();
        BufferedWriter bufwriter = null;
        try {
            File htmlFile = new File("htmlout.html");
            Writer writer = new FileWriter(htmlFile);
            bufwriter = new BufferedWriter(writer);

            bufwriter.write("<!DOCTYPE html>\n" + "<html>\n" + "<head>");
            bufwriter.write("\t<title> " + getDBname() +  "</title>\n"
                    +"\t<meta charset=\"UTF-8\">\n" + "</head>\n" );
            bufwriter.write("<body>");

            //Begin At the top

            //for (scRecord record : records){
                //Sort by Subject
                for (String subject : getSubjects()){
                    bufwriter.write("<h1>"+subject+"</h1>\n");
                    List<scRecord> subjList = records.stream()
                            .filter(rec -> rec.getSubject() == subject)
                            .collect(Collectors.toList());
                    //Then the Section of the subject.
                    for(String section : getSections(subject)){
                        bufwriter.write("\t<h2>"+section);
                        List<scRecord> sectionList = subjList.stream()
                                .filter(rec -> rec.getSection() == Integer.valueOf(section))
                                .collect(Collectors.toList());
                        for(String subsec : getSubSections(subject, Integer.valueOf(section))){
                            bufwriter.write("." + subsec + "</h2>\n");
                            List<scRecord> subsecList = sectionList;

                        }
                    }

                }
                //bufwriter.write("<h1>"+records.getSubject()+"</h1>");
                //bufwriter.write("<h2>"+records.getTopic()+"</h21>");
            //}
            bufwriter.write("</body>\n" + "</html>\n");
            bufwriter.flush();
            bufwriter.close();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try {
                if (bufwriter != null) bufwriter.close();
            } catch (Exception ex) {

            }
        }
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
    public String[] getSubSections(String subject, int section) {
        String[] subSections;
        List<scRecord> records = getRecords();
        Set<scRecord> subsecRecords = records.stream()
                .filter(record -> record.getSubject() == subject)
                .filter(record -> record.getSection() == section)
                //.sorted(Comparator.comparing(scRecord::getSubsection)
                .collect(Collectors.toSet());
        subSections = new String[subsecRecords.size()];
        int i = 0;
        for (scRecord rec : subsecRecords) {
            subSections[i++] = Integer.toString(rec.getSubsection());
        }
        return subSections;
    }

    public LinkedList<scRecord> getRecords() {
        return dtool.parse();
    }

    public void replaceRecords(List<scRecord> records){
        return;



    }




}
