package school.termProject.database;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


class domTool {
    private Document dbDom;
    private final String domRoot = "TestBank";

    private void createDom(File dbFileObj) {
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



    private void getNodeList(){
        NodeList questionNodes = dbDom.getChildNodes();
    }




}
