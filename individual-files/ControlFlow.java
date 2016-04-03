/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
    Unspecified user input is queried from the standard input

How is it processed? 
    The data is converted to a string and compared to a value

What are the outputs?
    No output

Who / What initializes the code?
    This file does not have a main function and therefore is not
    executed directly; an outside source must reference and execute
    the code in this file

What are the major functions?
    ControlFlow()

What objects are created / used?
    No objects are created; this is a class

--------------------------------------------------------

Defects / issues found (relevance of each defect)
    inputbuffer[] initialized with a hard-coded value
    switch is unecessary since only one case condition is used

Types / categories of defects
    Standards: lack of comments and descriptors
    Design ambiguity: switch statement is unnecessary
    Typographical error: missing a parenthesis and semicolon

Overall quality assessment
    Open

Provide a quality grade / score (that can be compared to other fragments)
    C
*/

import java.io.IOException;
import java.util.logging.Logger;

public class ControlFlow
{
    public ControlFlow()
    {
        byte inputBuffer[] = new byte[ 128 ]; //DEFECT SEVERITY 2: hard-coded value
        try
        {
            // Read data from the standard input
            int byteCount = System.in.read( inputBuffer );
            
            // Check whether data has been read or not
            if( byteCount <= 0 )
            {
                return;
            }
            
            int i = 1; //DEFECT SEVERITY 2: unnecessary initialization and switch case
            switch ( i )
            {
                case 1:
                // Turn data into a String
                    tring s = new String( inputBuffer );
                    s = s.substring( 0, byteCount - 2   //DEFECT SEVERITY 1: missing parenthesis and semicolon, DEFECT SEVERITY 2: hard-coded value
                    if( ( s.equals( "admin" ) ) == true ) //DEFECT SEVERITY 2: extraneous parentheses
                    {
                        authorize( s );
                    }
                default:
                    break;
            }
        }
        catch ( IOException e )
        {
                final Logger logger = Logger.getAnonymousLogger();
                String exception = "Exception " + e;
                logger.warning( exception );
        }
    }    
}


