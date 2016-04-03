/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
    The class has various setter functions to access
    private variables

How is it processed? 
    Data is processed based on the set functions

What are the outputs?
    Output is provided through the get function

Who / What initializes the code?
    This file does not have a main function and therefore is not
    executed directly; an outside source must reference and execute
    the code in this file

What are the major functions?
    all Item functions
    all set functions
    processRequest
    reset

What objects are created / used?
    No objects are created or instantiatedl this is a class

--------------------------------------------------------

Defects / issues found (relevance of each defect)
    Functions accessing private member variables have no
    error checking; can cause issues if handed unexpected input

Types / categories of defects
    Inadequate design: does not prevent malicious or unintentional errors

Overall quality assessment
    Open

Provide a quality grade / score (that can be compared to other fragments)
    B
*/

package sessions;

import javax.servlet.http.*;
import java.util.Vector;
import java.util.Enumeration;

public class Cart 
{
    Vector v = new Vector();
    String submit = null;
    String item = null;
   
    private void addItem(String name)
    {
        v.addElement(name); //DEFECT SEVERITY 2: no error checking
    }

    private void removeItem(String name) 
    {
        v.removeElement(name); //DEFECT SEVERITY 2: no error checking
    }

    public void setItem(String name) 
    {
        item = name; //DEFECT SEVERITY 2: no error checking
    }
   
    public void setSubmit(String s) 
    {
        submit = s; //DEFECT SEVERITY 2: no error checking
    }

    public String[] getItems() 
    {
        String[] s = new String[ v.size()];
        v.copyInto(s);
        return s;
    }
   
    public void processRequest(HttpServletRequest request) 
    {
        if (submit == null)
            addItem(item);

        if (submit.equals("add"))
            addItem(item);
        else if (submit.equals("remove"))
            removeItem(item);
   
        // reset at the end of the request
        reset();
    }

    // reset
    private void reset() 
    {
        submit = null;
        item = null;
    }
}
