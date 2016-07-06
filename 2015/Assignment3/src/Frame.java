import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame implements ActionListener{
	//declare all components
	JTextArea textarea;
	JButton btn;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JScrollPane pane;
	JRadioButton radiobtn;
	JRadioButton radiobtn2;
	JColorChooser color;
	ActionListener actionListener;
	String text = null;
	
	/** 
	 * Constructor. Sets the size of the JFrame and exit action. 
	 * calls method to initialize and add all the components. Sets
	 * the location of the window and sets is to visible.
	 * 
	 */
	public Frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		init();
		//if you pass it null it puts the window in the middle of the screen
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	/**
	 * This method initializes all the buttons, textarea, jpanel. It then adds it to
	 * the window. It also sets all the actions for the buttons and finally it adds 
	 * it to the JFrame
	 * 
	 */
	public void init()
	{
		//this is used to I can position the components wherever I want
		setLayout(null);
		
		//initialize textarea and scroll pane. Set the size and location of the pane and add it
		textarea = new JTextArea(100,100);
		pane = new JScrollPane(textarea);
		pane.setBounds(0, 0, 770, 300);
		add(pane);
		
	    //initialize all the buttons
	    btn = new JButton();
	    btn2 = new JButton();
	    btn3 = new JButton();
	    btn4 = new JButton();
	    radiobtn = new JRadioButton();
	    radiobtn2 = new JRadioButton();

	    btn.setSize(100, 50);
	    btn.setLocation(10, 350);
	    btn.setText("Save");

	    btn.addActionListener(actionListener = new ActionListener() {
	    	/**
	    	 * Add the action listener method for this button in there, it gets 
	    	 * the text that is in the textarea and adds it to a local String variable
	    	 * 
	    	 */
		      public void actionPerformed(ActionEvent actionEvent) {
		          text = textarea.getText();
		        }
		      });
	    
	  	    
	    btn2.setSize(100, 50);
	    btn2.setLocation(110, 350);
	    btn2.setText("Clear");
	   
	    btn2.addActionListener(actionListener = new ActionListener() {
	    	/**
	    	 * Action method for this button is also in here, it sets the text
	    	 * of the textarea to null when clicked
	    	 * 
	    	 */
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  textarea.setText("");		    	  
		    	  
		        }
		      });
	    
	    btn3.setSize(100, 50);
	    btn3.setLocation(210, 350);
	    btn3.setText("Load");
	
	    btn3.addActionListener(actionListener = new ActionListener() {
	    	/** 
	    	 * This action method sets the textarea to the saved text from earlier
	    	 * 
	    	 */
		      public void actionPerformed(ActionEvent actionEvent) {
		          textarea.setText(text);
		        }
		      });
	    
	    btn4.setSize(100, 50);
	    btn4.setLocation(550, 350);
	    btn4.setText("Color");
	    
	    btn4.addActionListener(actionListener = new ActionListener() {
	    	/** 
	    	 * this action method enables the radiobuttons so you then can click
	    	 * on them and choose a color
	    	 * 
	    	 */
		      public void actionPerformed(ActionEvent actionEvent) {
		          radiobtn.setEnabled(true);
		          radiobtn2.setEnabled(true);
		        }
		      });
	    
	    
	    
	    
	    radiobtn.setSize(100, 50);
	    radiobtn.setLocation(510, 400);
	    radiobtn.setText("Frame");
	    radiobtn.setEnabled(false);
	    //This uses the action method in the class since it needs to reference "this"
	    //to be able to set the color of the JFrame
	    radiobtn.addActionListener(this);
        
	    
	    
	    
	    radiobtn2.setSize(100, 50);
	    radiobtn2.setLocation(650, 400);
	    radiobtn2.setText("Text Area");
	    radiobtn2.setEnabled(false);
	    
	    radiobtn2.addActionListener(actionListener = new ActionListener() {
	    	  /**
	    	   * this sets the color of the text area background. It makes sure to
	    	   * unselect the other radio button, then gets the current color and 
	    	   * then brings up thje jcolor chooser. at the end it disables the radio
	    	    *buttons so you need to click on the button to be able to set the color again.
	    	   * 
	    	   */
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  radiobtn.setSelected(false);
		    	  radiobtn2.setSelected(true);
		          Color initialBackground = textarea.getBackground();
		          Color background = JColorChooser.showDialog(null, "Change Text Area Background",
		              initialBackground);
		          if (background != null) {
		            textarea.setBackground(background);
		          }
		          radiobtn.setEnabled(false);
		          radiobtn2.setEnabled(false);
		        }
		      });
	    
	    //add all the buttons
		add(btn);
		add(btn2);
		add(btn3);
		add(btn4);		
		add(radiobtn);		
		add(radiobtn2);
	    
		   
		
	}
	
	/**
	 * This action method sets the color of the JFrame background.
	 * It makes sure it unselects the other radio button. Then gets the current
	 * color of the background and then brings up the jcolorchooser.
	 * it also sets the background color of the radiobuttons so it matches the
	 * background of the jframe. disables radio buttons 
	 * 
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		radiobtn2.setSelected(false);
  	    radiobtn.setSelected(true);
		 Color initialBackground = this.getContentPane().getBackground();
	     Color background = JColorChooser.showDialog(null, "Change Background Color", initialBackground);
	        if (background != null) {
	          this.getContentPane().setBackground(background);
	        }
	        radiobtn.setBackground(background);
	        radiobtn2.setBackground(background);
	        radiobtn.setEnabled(false);
	        radiobtn2.setEnabled(false);
	}
		
		
	

}
