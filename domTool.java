import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


class domTool {
    private Document dbDom;
    private final String domRoot = "TestBank";
    private NodeList questionNodes;
    File dbFileObj;
    private LinkedList<scRecord> records;

    domTool(File dbFile){
        this.dbFileObj = dbFile;
        this.records = new LinkedList<scRecord>();

    }

    private void createDom() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        try {
            //Using factory get an instance of document builder
            db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dbDom = db.parse(dbFileObj);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    LinkedList<scRecord> parse(){
        createDom();

        //Root Document element which is always TestBank
        Element documentElement = dbDom.getDocumentElement();
        //Get the nodelist of questions.
        NodeList questionList = documentElement.getElementsByTagName("question");
        if(questionList != null && questionList.getLength() > 0) {
            for(int i = 0 ; i < questionList.getLength(); i++) {

                //get a question element from the nodelist.
                Element questionElement = (Element) questionList.item(i);

                //populate a new scRecord
                scRecord record = getScRecord(questionElement);

                //add it to list
                this.records.add(record);
            }
        }
        return records;
    }

    private String getTextValue(Element question, String tagName) {
        String textVal = null;
        NodeList nl = question.getElementsByTagName(tagName);
        if(nl != null && nl.getLength() > 0) {
            textVal = nl.item(0).getFirstChild().getNodeValue();
            //textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }

    private scRecord getScRecord(Element questionEl) {

        //for each question element get text/Integer value of child
        scRecord rec = new scRecord();
        rec.setSubject(getTextValue(questionEl,"subject"));
        rec.setSection(Integer.valueOf(getTextValue(questionEl,"section")));
        rec.setSubsection(Integer.valueOf(getTextValue(questionEl,"subsection")));
        rec.setDifficulty(Integer.valueOf(getTextValue(questionEl,"difficulty")));
        rec.setTopic(getTextValue(questionEl,"topic"));
        rec.setInstructions(getTextValue(questionEl,"instructions"));
        rec.setQuestionHtml(getTextValue(questionEl,"questionHtml"));
        rec.setAnswerHtml(getTextValue(questionEl,"answerHtml"));
        rec.setQuestionLatex(getTextValue(questionEl,"questionLatex"));
        rec.setChoicesHtml(getTextValue(questionEl, "choicesHtml"));
        return rec;
    }

    public String[] getSubjects(){
        createDom();
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

    public String[] getSections(String subject){
        String expression = "/" + domRoot + "/question[subject='" + subject + "']/section";
        Set<String> sections = new HashSet<String>();

        XPath xp = XPathFactory.newInstance().newXPath();
        try {
            XPathExpression xpExp = xp.compile(expression);
            NodeList nl = (NodeList) xpExp.evaluate(dbDom, XPathConstants.NODESET);
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
}
