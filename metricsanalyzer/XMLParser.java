/*
 * XMLParser.java
 *
 */

package metricsanalyzer;

import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
//Vector is obsolete
//bad practice severity: 1
import java.util.Vector;
/**
 *
 * @author Byron
 */
public class XMLParser {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser parser = null;
    
    /** Creates a new instance of XMLParser */
    public XMLParser() {
        
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        
        System.out.println("Parser will "+(spf.isNamespaceAware()?"":"not ") +"be namespace aware");
        System.out.println("Parser will "+(spf.isValidating()?"":"not ") + "validate XML");
        
        try {
            parser = spf.newSAXParser();
            System.out.println("Parser object is: "+ parser);
        //could be replaced with a multicatch severity: 2
        //style problem
        }catch(SAXException e){
            e.printStackTrace(System.err);
            System.exit(1);
        } catch(ParserConfigurationException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
    
    public void parseFile(File file, String revisionNum) {
        System.out.println("\nStarting parsing of "+file+"\n");
        SAXHandler handler = new SAXHandler(revisionNum);
        try {
            parser.parse(file, handler);
        //could be replaced with a multicatch severity: 2
        //style problem
        }  catch(IOException e) {
            e.printStackTrace(System.err);
            
        } catch(SAXException e) {
            e.printStackTrace(System.err);
        }
        
        DBUpdate update = new DBUpdate();
        update.addRevision(revisionNum);
        //need to remove comments severity: 2
        //bad practice
       // update.setMetrics(handler.geMetricsList());
        //update.setSystemMetrics(handler.getSysMetrics());
        //update.setClassMetrics(handler.getClassMetrics());
        //update.setPackageMetrics(handler.getPackageMetrics());
        update.setMethodMetrics(handler.getMethodMetrics());
    }
    
}
