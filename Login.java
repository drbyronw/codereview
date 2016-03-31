/*
Login.java: 
Discuss each code fragment (primary function(s) provided):

What are the inputs:
The only input is the username.

How is it processed:
The username is used to create a ChatClient with it’s loginName being the username.

What are the outputs:
There is no output for any of the functions or for the whole file.

Who / What initializes the code:
A user running chatt-app will initialize this file first after the server has been set up because it is the GUI.

What are the major functions:
enter.addActionListener
If the login button is pressed, a new ChatClient is created and the login button is removed.
loginName.addKeyListener

If the enter button is pressed on the keyboard when in the text field, a new ChatClient is created and the login button is removed.

What objects are created / used:
The only object used is the ChatClient object.

What is the main purpose/job of the file:
The file is a GUI for Ghatt-app



Overall quality assessment
everything works but the majority of the running code is in the constructor in ChatClient.java.
There are several issues with style. There needs to be better error checking. There needs to be more comments.

Provide a quality grade / score (that can be compared to other fragments)
B-
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;


public class Login {
        //tabbed over too much severity: 2
	public static void main(String[] args){
                //tabbed over too much
		final JFrame login = new JFrame("Login");
		JPanel panel = new JPanel();
		final JTextField loginName = new JTextField(20);
		JButton enter = new JButton("Login");
		
		panel.add(loginName);
		panel.add(enter);
		login.setSize(300, 100);
		login.add(panel);
		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                //lambda expression could be used severity: 2
		enter.addActionListener(new ActionListener(){
                        //tabbed over too much 
			@Override
			public void actionPerformed(ActionEvent e) {
                                //tabbed over too much
                                //Remove all TODO comments severity: 2
				// TODO Auto-generated method stub
				try {
                                        //tabbed over too much
					ChatClient client = new ChatClient(loginName.getText());
					login.setVisible(true);
					login.dispose();
				} catch (UnknownHostException e1) {
                                        //tabbed over too much
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace() severity: 2
					e1.printStackTrace();
				} catch (IOException e1) {
                                        //tabbed over too much
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace()
					e1.printStackTrace();
				}
			}
		//don't need the extra line of whitespace severity: 2
                        
		});
		
		loginName.addKeyListener(new KeyListener(){
                        //tabbed over too much
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			//don't need the extra line of whitespace
                            
			}

			@Override
			public void keyPressed(KeyEvent e) {
                                //tabbed over too much
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                //no tab over
				try {
                                        //tabbed over too much
                                        //client is created and then never used 
                                        //the constructer is running all the code
                                        //bad practice severity: 2
					ChatClient client = new ChatClient(loginName.getText());
					login.setVisible(false);
					login.dispose();
				} catch (UnknownHostException e1) {
                                        //tabbed over too much
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace()
					e1.printStackTrace();
				} catch (IOException e1) {
                                        //tabbed over too much
					// TODO Auto-generated catch block
                                        //it's bad practice to call printStackTrace()
					e1.printStackTrace();
				}
                                //don't need the extra line of whitespace
				
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
                                //tabbed over too much
				// TODO Auto-generated method stub
			//don't need the extra line of whitespace
                            
			}
                //don't need the extra line of whitespace
			
		});
	//don't need the extra line of whitespace
                
	}
}
