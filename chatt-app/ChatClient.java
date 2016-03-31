/*
ChatClient.java: 
Discuss each code fragment (primary function(s) provided):

What are the inputs:
The input is the username of each client.

How is it processed:
The file creates a socket for each incoming client and listens for messages from other clients.

What are the outputs:
The outputs for the file are the messages that the client sends.

Who / What initializes the code:
Code is initialized by Login.java.

What are the major functions:
Creating a thread to listening for new messages sent by different clients.
Listeners to accept user input and send messages to the server.

What objects are created / used:
File is an object that is used by Login.java.

What is the main purpose/job of the file:
the file creates a thread to listen for new messages sent by different clients.
the file also listens to accept user input and send messages to the server.


Overall quality assessment
everything works but the majority of the running code is in the constructor.
There needs to be better error checking.
There needs to be more comments. There are several issues with style.

Provide a quality grade / score (that can be compared to other fragments)
C-
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;

import javax.swing.*;


public class ChatClient extends JFrame implements Runnable {
	
	Socket socket;
	JTextArea ta;
	JButton send, logout;
	JTextField tf;
	
	Thread thread;
	
	DataInputStream din;
	DataOutputStream dout;
	
	String LoginName;
	
	ChatClient(String login) throws UnknownHostException, IOException{
		super(login);
		LoginName = login;
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					dout.writeUTF(LoginName + " " + "LOGOUT");
					System.exit(1);
				} catch (IOException e1) {
                                        //remove all TODO comments severity: 2
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace() severity: 2
					e1.printStackTrace();
				}
			}
		});
		
		ta = new JTextArea(18, 50);
		tf = new JTextField(50);
		
		tf.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						if(tf.getText().length()>0)
                                                        //remove toString() already a string 
                                                        //Correctness severity: 2
							dout.writeUTF(LoginName + " " + "DATA " + tf.getText().toString());
						tf.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
                                                //it's bad practice to call printStackTrace()
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
                //all GUI parts need to be together 
                //bad practice severity: 2
		send = new JButton("Send");
		logout = new JButton("Logout");
		
                //lambda expression could be used severity: 2
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(tf.getText().length()>0)
						dout.writeUTF(LoginName + " " + "DATA " + tf.getText().toString());
					tf.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace()
					e1.printStackTrace();
				}
			}
			
		});
		
                //lambda expression could be used severity: 2
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dout.writeUTF(LoginName + " " + "LOGOUT");
					System.exit(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace()
					e1.printStackTrace();
				}
			}
			
		});
		
		socket = new Socket("localhost", 5217);
		
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(LoginName);
		dout.writeUTF(LoginName + " " + "LOGIN");
		
		thread = new Thread(this);
                //starting thread in constructor
                //bad practice severity: 2
		thread.start();
		setup();
	}
        
	//The setup function should just be in the constructor because 
        //it is only run once and is part of setup. Put with the other GUI creation parts. 
        //bad practice severity: 2
	private void setup() {
		// TODO Auto-generated method stub
		setSize(600, 400);
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(ta));
		panel.add(tf);
		panel.add(send);
		panel.add(logout);
		add(panel);
		
		setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				ta.append("\n" + din.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
                                //it's bad practice to call printStackTrace()
				e.printStackTrace();
			}
		}
	}
//remove whitespace at end severity: 3	
        

}
