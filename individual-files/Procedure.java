/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
    doGet() accepts an HTTP request and response

How is it processed? 
    ...

What are the outputs?
    The output appears to be HTML code

Who / What initializes the code?
    This file does not have a main function and therefore is not
    executed directly; an outside source must reference and execute
    the code in this file

What are the major functions?
    doGet()

What objects are created / used?
    No objects are created; this is a class

--------------------------------------------------------

Defects / issues found (relevance of each defect)
    No defects found

Types / categories of defects
    Standards: no comments or descriptors

Overall quality assessment
    Closed

Provide a quality grade / score (that can be compared to other fragments)
    A
*/

import java.lang.Runtime;
import java.io.*;

public class Procedure extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        res.setContentType("text/html");
        ServletOutputStream out = res.getOutputStream();
        out.println("<HTML><HEAD><TITLE>Test</TITLE></HEAD><BODY><blockquote><pre>");
        
        String user = req.getParameter("user");
        if(user != null) 
        {
            try 
            {
                 String[] args = { "/bin/sh", "-c", "finger " + user };
                Process p = Runtime.getRuntime().exec(args);
                BufferedReader fingdata = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while((line = fingdata.readLine()) != null)
                    out.println(line);
                p.waitFor();
                catch(Exception e) 
                {
                    throw new ServletException(e);
                
                    else 
                    {
                        out.println("specify a user");
            
        
                        out.println("</pre></blockquote></BODY></HTML>");
                        out.close();
        
                    }
                }
            }
        }
    }
}
