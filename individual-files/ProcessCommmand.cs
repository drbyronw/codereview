/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
	User input from the command line

How is it processed? 
	A command is retrieved from the command line and is
	either executed or an exception is thrown

What are the outputs?
	The command given by the user is executed or,
	on failure, an exception is thrown

Who / What initializes the code?
	The ProcessCommand class contains a Main function which
	instantiates an object of the class

What are the major functions?
	The major functions are Main and ProcessCommand

What objects are created / used?
	ProcessCommand

--------------------------------------------------------

Defects / issues found (relevance of each defect)
	No defects found

Types / categories of defects
	None

Overall quality assessment
	Closed

Provide a quality grade / score (that can be compared to other fragments)
	A
*/

using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
  
class ProcessCommand 
{
    public ProcessCommand()
	{
        Console.WriteLine("Enter OS command: ");
        string userCommand = Console.ReadLine();
        Console.WriteLine(userCommand);
        if (userCommand.Length != 0)
            try
            {
                Process.Start(userCommand);
            }
            catch (System.ComponentModel.Win32Exception)
            {
                Console.WriteLine("Error opening file");
            }
    }
    static void Main(string[] args)
	{
        ProcessCommand PC = new ProcessCommand();
    }
}
