/*
ChatServer.java: 
Discuss each code fragment (primary function(s) provided):

What are the inputs:
The input is each new client starting a chat. incoming connections and 
messages after they have connected.

How is it processed:
The file creates a socket for each incoming person and 
listens for messages from clients and sends them out to all the other users.

What are the outputs:
The outputs for the file are the messages that each client sends and the file distributes the messages to each client.

Who / What initializes the code:
this is a server file. The person hosting the server initializes the code.

What are the major functions:
threads, listening for new messages sent by the different clients.

What objects are created / used:
The only objects used are the ChatServer object and the AcceptClient object.

What is the main purpose/job of the file:
The file is a server for Chatt-app.



Overall quality assessment
everything works but the majority of the running code is in the constructors in AcceptClient and ChatServer.
The code never leaves the ChatServer constructor. There needs to be better error checking. There needs to be more comments.
There are several issues with style.

Provide a quality grade / score (that can be compared to other fragments)
C-
*/
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
//Vector is obsolete
//bad practice
import java.util.Vector;


public class ChatServer {
        //Vector is obsolete severity:1
	static Vector ClientSockets;
	static Vector LoginNames;
	
	ChatServer() throws IOException{
		ServerSocket server = new ServerSocket(5217);
                //Vector is obsolete
		ClientSockets = new Vector();
		LoginNames = new Vector();
		
                //infinite loop in constructor 
                //bad practice severity: 1
		while(true){
			Socket client = server.accept();
                        //acceptClient is never used
                        //bad practice
			AcceptClient acceptClient = new AcceptClient(client);
		}
	}
	
	public static void main(String[] args) throws IOException{
                //server is never used
                //bad practice severity: 2
		ChatServer server = new ChatServer();
	}
	
	class AcceptClient extends Thread{
		Socket ClientSocket;
		DataInputStream din;
		DataOutputStream dout;
		AcceptClient(Socket client) throws IOException{
			ClientSocket = client;
			din = new DataInputStream(ClientSocket.getInputStream());
			dout = new DataOutputStream(ClientSocket.getOutputStream());
			
			String LoginName = din.readUTF();
			
			LoginNames.add(LoginName);
			ClientSockets.add(ClientSocket);
			
                        //starting thread in constructor
                        //bad practice severity: 2
			start();
		}
		
		public void run(){
                        //inconsistant tabbing
			while(true){
				try {
					String msg = "";
					String msgFromClient = din.readUTF();
					StringTokenizer st = new StringTokenizer(msgFromClient);
					String LoginName = st.nextToken();
					String MsgType = st.nextToken();
					int lo = -1;
					
					while(st.hasMoreTokens()){
						msg=msg+ " " + st.nextToken();
					}
                                        //would work better as a switch statement severity: 2
					if(MsgType.equals("LOGIN")){
						for(int i = 0; i<LoginNames.size(); i++){
							Socket pSocket = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(LoginName + " has logged in.");
						}
					}
					else if(MsgType.equals("LOGOUT")){
						for(int i = 0; i<LoginNames.size(); i++){
							if(LoginName.equals(LoginNames.elementAt(i)))
								lo = i;
							Socket pSocket = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(LoginName + " has logged out.");
						}
						if(lo >= 0){
							LoginNames.removeElementAt(lo);
							ClientSockets.removeElementAt(lo);
						}
					}
					else {
						for(int i = 0; i<LoginNames.size(); i++){
							Socket pSocket = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(LoginName + ": " + msg);
						}
					}
                                        
                                        //should be stuck with the else if(MsgType.equals("LOGOUT"))
                                        //bad practice severity: 2
					if(MsgType.equals("LOGOUT"))
						break;
					
				} catch (IOException e) {
                                        //remove TODO comment severity: 2
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace() severity: 2
					e.printStackTrace();
				}
			}
		}
	}
}
