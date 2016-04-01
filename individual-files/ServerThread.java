/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
  No user inputs are necessary; the only real input is for
  threaded processing

How is it processed? 
  A socket is passed to a thread for multiple processing

What are the outputs?
  The only outputs are messages for socket success and the

Who / What initializes the code?
  The ServerThread class contains the main() function which
  begins execution

What are the major functions?
  main(), sthread(), and run()

What objects are created / used?
  An SThread class, a socket

--------------------------------------------------------

Defects / issues found (relevance of each defect)
  No exit case for infinite while loop to close
  socket connections

Types / categories of defects  
  Standards: few comments, no exit case for while loop

Overall quality assessment
  Open

Provide a quality grade / score (that can be compared to other fragments)
  A
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread //DEFECT SEVERITY 2: no exit case
{
  public static void main(String args[]) throws Exception 
  {
    int PORT = 5555;      // Open port 5555

    //open socket to listen
    ServerSocket server = new ServerSocket(PORT);
    Socket client = null;

    while (true) 
    {
      System.out.println("Waiting for client...");

      // open client socket to accept connection
      client = server.accept();

      System.out.println(client.getInetAddress()+" contacted ");
      System.out.println("Creating thread to serve request");

      SThread student = new SThread(client);
      student.start();
    }
  }
}


public class SThread extends Thread 
{
    Socket client; 

    public SThread(Socket x) 
    {  
        client = x;  
    }

    public void run() 
    {
        // create object to send information to client
        PrintWriter out = new  PrintWriter(client.getOutputStream(),true);

        out.println("Student name: ");//send text to client;
    }
}

