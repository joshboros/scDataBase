
import java.io.*;
import java.util.Formatter;
import java.awt.List;
public class htmlFile {
        private int qcount;
        private RetrieveXML XMLretriever;
        private LatexFile tex_file;
        private List html_questions;
        private String test_name;
/**
         * constructor
         * @throws IOException 
         */
    public htmlFile(String dpath) throws IOException{
            XMLretriever = new RetrieveXML(dpath);
            html_questions = new List();
            tex_file = new LatexFile("temp.tex",dpath);
            tex_file.WriteLatexHead("temp");       
    }
    
/**
     * creates list of questions to add
     * adds problems to temp.tex
     * @param subject course subject title
     * @param section lesson section
     * @param difficulty difficulty of problems
     * @param questionQuantity number of problems to add
     */    
    public void WritehtmlQuestions(String sectionTopic, int section, int difficulty, int questionQuantity){
        List questionsbysubject = XMLretriever.returnByTopic(sectionTopic);
        List questionsbysection = XMLretriever.returnBySection(section);
        List questionsbydifficulty = XMLretriever.returnByDifficulty(difficulty);
        List temp_list = new List();
        List LatexQuestions = new List();

        for(int c=0;c<questionsbysubject.getItemCount();c++){
            for(int d=0;d<questionsbysection.getItemCount();d++){
                if(questionsbysubject.getItem(c).compareTo(questionsbysection.getItem(d))==0)
                    temp_list.add(questionsbysection.getItem(d));
            }
        }
        
        for(int c=0;c<temp_list.getItemCount();c++){
            for(int d=0;d<questionsbydifficulty.getItemCount();d++){
               if(temp_list.getItem(c).compareTo(questionsbydifficulty.getItem(d))==0)
                  LatexQuestions.add(questionsbydifficulty.getItem(c));
            }
        }
        tex_file.WriteLatexQuestions(sectionTopic, section, difficulty, questionQuantity);
        if(questionQuantity<=LatexQuestions.getItemCount()){
            for(int c=0;c<questionQuantity;c++){
                html_questions.add(LatexQuestions.getItem(c));
            }
        }
        else{
                System.out.println("Not enough questions in database. Adding " + LatexQuestions.getItemCount() + ".");
            for(int c=0;c<LatexQuestions.getItemCount();c++)
                html_questions.add(LatexQuestions.getItem(c));
        }
    }
    
/**
     * depends on latex2html. latex2html generates png files from math mode 
     * sections in the temp.tex file. the directory created by latex2html
     * is moved to a directory named after String testname. generates index.html
     * and moves it to test directory
     * @param testname name of html test to be generated
     */
    public void GeneratehtmlTest(String testname){
        String test_dir = testname;
        test_dir = test_dir.replaceAll(" ", "_");
        try{
            tex_file.WriteLatexFoot();
            Process p;
            p = Runtime.getRuntime().exec("mkdir " + test_dir);
            p.waitFor();
            p=Runtime.getRuntime().exec("latex2html temp.tex");  
            p.waitFor();
            p=Runtime.getRuntime().exec("mv temp " + test_dir);
            p.waitFor();
            p=Runtime.getRuntime().exec("rm temp.tex");
            p.waitFor();
            File html_test = new File("index.html");
            if(!html_test.exists())
                html_test.createNewFile();
            Formatter html_test_io = new Formatter(html_test.getAbsolutePath());
            html_test_io.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n");
            html_test_io.format("<HTML>\n<HEAD>\n<TITLE>" + testname + "</TITLE>\n</HEAD>\n<BODY>\n\n");
            html_test_io.format("<center><b>" + testname + "</b></center><br><br>");
            for(int c=0;c<html_questions.getItemCount();c++){
                html_test_io.format((c+1) + ") " + XMLretriever.returnTestData(html_questions.getItem(c), "latex_instructions") + "\n<br>\n");
                html_test_io.format("<IMG SRC=\"temp/img" + (c+1) + ".png\">\n<br><br><br>\n");
            }
            html_test_io.format("\n\n</BODY>\n\n</HTML>");
            html_test_io.close();
            p=Runtime.getRuntime().exec("mv index.html " + test_dir);        
            p.waitFor();
        }
        catch(IOException e){
            System.out.println("IOexception");
            e.printStackTrace();
        }
        
        catch(InterruptedException d){
            System.out.println("InterruptedException");
        }
    }
}
