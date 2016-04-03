/*
 * DBUpdate.java
 *
 */

package metricsanalyzer;
//Vector is obsolete
//bad practice severity: 1
import java.util.Vector;
import java.sql.*;
import java.util.StringTokenizer;
/**
 *
 * @author Byron
 */
public class DBUpdate {
    
    private Connection con;
    private String add;
    private StringTokenizer stz;
    private String[] columns;
    /** Creates a new instance of DBUpdate */
    public DBUpdate() {
    }
    
    public void addRevision(String revisionNum) {
        MetricsDB db = new MetricsDB(); 
        //no need to make a variable for the number 0 severity: 3
        //bad practice
        int zero = 0;
         add = "INSERT INTO revisiondata VALUES('"+revisionNum+"','"+zero+"','"+zero+"','"+zero+"','"+zero +
                    "','"+zero+"','Revision: "+revisionNum+"','1')";
         con = db.getConnection(); 
         try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding revisiondata values:  "+ sqe);
            }
         db.closeConnection(); 
    }
    
    //the rest of the functions can be reduced down to just one function with the addition of one variable
    //only one line changes in all the functions severity: 1
    //style issue/bad practice
    public void setMethodMetrics(Vector metrics) {
        MetricsDB db = new MetricsDB();
        int tokens = 0, counter;
        
        con = db.getConnection();
        
        for (int i=0; i<metrics.size(); i++) {
            stz = new StringTokenizer(metrics.elementAt(i).toString(), ",", false);
            
            tokens = stz.countTokens();
            columns = new String[tokens];
            counter = 0;
            
            while (stz.hasMoreTokens()) {
                columns[counter] = stz.nextToken();
                
                if (columns[counter].equals("null")) {
                    columns[counter] = "0";
                }
                //remove comment severity: 2
                //System.out.println(columns[counter]);
                counter++;
                
            }
            add = "INSERT INTO methodmetrics VALUES('"+columns[0]+"','"+columns[1]+"','"+columns[2]+"','"+columns[3]+"','"+columns[4]+
                    "','"+columns[5]+"')";
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding methodmetric values:  "+ sqe);
            }
        }
         
        
        db.closeConnection();
    }
    
    public void setPackageMetrics(Vector metrics) {
        MetricsDB db = new MetricsDB();
        int tokens = 0, counter;
        
        con = db.getConnection();
        
        for (int i=0; i<metrics.size(); i++) {
            stz = new StringTokenizer(metrics.elementAt(i).toString(), ",", false);
            
            tokens = stz.countTokens();
            columns = new String[tokens];
            counter = 0;
            
            while (stz.hasMoreTokens()) {
                columns[counter] = stz.nextToken();
                
                if (columns[counter].equals("null")) {
                    columns[counter] = "0";
                }
                //System.out.println(columns[counter]);
                counter++;
                
            }
            add = "INSERT INTO packagemetrics VALUES('"+columns[0]+"','"+columns[1]+"','"+columns[2]+"','"+columns[3]+"','"+columns[4]+"')";
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding packagemetric values:  "+ sqe);
            }
        }
         
        
        db.closeConnection();
    }
    
    public void setClassMetrics(Vector metrics) {
        MetricsDB db = new MetricsDB();
        int tokens = 0, counter;
        
        con = db.getConnection();
        
        for (int i=0; i<metrics.size(); i++) {
            stz = new StringTokenizer(metrics.elementAt(i).toString(), ",", false);
            
            tokens = stz.countTokens();
            columns = new String[tokens];
            counter = 0;
            
            while (stz.hasMoreTokens()) {
                columns[counter] = stz.nextToken();
                
                if (columns[counter].equals("null")) {
                    columns[counter] = "0";
                }
                //System.out.println(columns[counter]);
                counter++;
                
            }
            add = "INSERT INTO classmetrics VALUES('"+columns[0]+"','"+columns[1]+"','"+columns[2]+"','"+columns[3]+"','"+columns[4]+"','"+
                    columns[5]+"')";
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding classmetric values:  "+ sqe);
            }
        }
         
        
        db.closeConnection();
    }
        
    public void setMetrics(Vector metrics) {
        MetricsDB db = new MetricsDB();
        int tokens = 0, counter;
        
        con = db.getConnection();
        
        for (int i=0; i<metrics.size(); i++) {
            stz = new StringTokenizer(metrics.elementAt(i).toString(), ",", false);
            
            tokens = stz.countTokens();
            columns = new String[tokens];
            counter = 0;
            
            while (stz.hasMoreTokens()) {
                columns[counter] = stz.nextToken();
                
                if (columns[counter].equals("null")) {
                    columns[counter] = "0";
                }
                //System.out.println(columns[counter]);
                counter++;
                
            }
            add = "INSERT INTO metrics VALUES('"+columns[0]+"','"+columns[1]+"')";
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding metrics values:  "+ sqe);
            }
        }
         
        
        db.closeConnection();
    }
    
    public void setSystemMetrics(Vector metrics) {
        MetricsDB db = new MetricsDB();
        int tokens = 0, counter;
        
        con = db.getConnection();
        
        for (int i=0; i<metrics.size(); i++) {
            stz = new StringTokenizer(metrics.elementAt(i).toString(), ",", false);
            
            tokens = stz.countTokens();
            columns = new String[tokens];
            counter = 0;
            
            while (stz.hasMoreTokens()) {
                columns[counter] = stz.nextToken();
                
                if (columns[counter].equals("null")) {
                    columns[counter] = "0";
                }
               // System.out.println(columns[counter]);
                counter++;
                
            }
            add = "INSERT INTO systemmetrics VALUES('"+columns[0]+"','"+columns[1]+"','"+columns[2]+"','"+columns[3]+"','"+columns[4]+"','"+
                    columns[5]+"','"+columns[6]+"')";
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(add);
                stmt.close();
            } catch (java.sql.SQLException sqe) {
                System.out.println("error adding systemmetric values:  "+ sqe);
            }
        }
         
        
        db.closeConnection();
    }
    
}
