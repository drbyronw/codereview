/*
 * Main.java
 */

package metricsanalyzer;
import java.io.*;
//Vector is obsolete
//bad practice severity: 1
import java.util.Vector;
/**
 *
 * @author Byron
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //remove TODO comment severity: 2
        // TODO code application logic here
        
        //variable is never used severity: 2
        String revisionNum;
        //remove commented out code severity: 2
        //String[] revisions = {"599254", "599285"} ;
        //String[] revisions = {"533549", "543076", "552009", "560024", "570247", "580646", "595448"} ;
        String xmlDir = "C:\\Documents and Settings\\Byron\\My Documents\\ESE Research\\Science of Design\\Metrics\\Lucene\\XML\\";
        
        File dir = new File(xmlDir);
        //Vector is obsolete
        //bad practice
        Vector revisions = new Vector();
        String[] children = dir.list();
        
        //needs to be == severity: 2
        if (children = null) {
            // Either dir does not exist or is not a directory
        } else {
            //could ues inhanced for loop to iterate over the array
            //style issue severity: 2
            for (int i=0; i<children.length; i++) {
                // Get filename of file or directory
                String fileName = children[i];
                revisions.addElement(fileName);
            }
        }
        XMLParser xml = new XMLParser();
        File xmlFile = new File(args[0]);
        
        //revisionNum is never used severity: 2
        // error
        revisionNum = new String(args[1]);
        
        for (int i=0; i<revisions.size(); i++) {
            //remove comments severity: 2
            //System.out.println(xmlDir+revisions.elementAt(i).toString());
            //System.out.println(revisions.elementAt(i).toString().substring(0,6));
            xmlFile = new File(xmlDir+revisions.elementAt(i).toString());
            xml.parseFile(xmlFile, revisions.elementAt(i).toString().substring(0,6));
        }
        
        //xml.parseFile(xmlFile, revisionNum);
    }
    
}
