import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

   public static void main(String argv[]) {

    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bSubject = false;
	boolean bSection = false;
	boolean bDifficulty = false;
    boolean bQuestion = false;
    boolean bAnswer = false;

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		//System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("SUBJECT")) 
        {
			bSubject = true;
		}

        if (qName.equalsIgnoreCase("SECTION")) 
        {
			bSection = true;
		}

        if (qName.equalsIgnoreCase("DIFFICULTY")) 
        {
			bDifficulty = true;
		}

        if (qName.equalsIgnoreCase("QUESTIONHTML")) 
        {
			bQuestion = true;
		}
        if (qName.equalsIgnoreCase("ANSWERHTML")) 
        {
			bAnswer = true;
		}
	}

	//public void endElement(String uri, String localName,
	//	String qName) throws SAXException {

	//	System.out.println("End Element :" + qName);

	//}

	public void characters(char ch[], int start, int length) throws SAXException {

        if (bSubject) 
        {
			System.out.println("Subject : " + new String(ch, start, length));
			bSubject = false;
		}

        if (bSection) 
        {
			System.out.println("Section : " + new String(ch, start, length));
			bSection = false;
		}

        if (bDifficulty) 
        {
			System.out.println("Difficulty : " + new String(ch, start, length));
			bDifficulty = false;
		}

        if (bQuestion) 
        {
			System.out.println("Question : " + new String(ch, start, length));
            bQuestion = false;
        }

        if (bAnswer) 
        {
			System.out.println("Answer : " + new String(ch, start, length));
            bAnswer = false;
            System.out.println("**********************************************************************");
		}

	}

     };

       saxParser.parse("/home/surya/Desktop/data.xml", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}