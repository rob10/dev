import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeZones implements Runnable{
	
	//initialize variables and jframe components
	private String timezone;
	JFrame frame;
	Color green;
	Color red;
	JLabel time;
	JButton resume;
	JButton suspend;
	int horizontal;
	
	
	TimeZones(String timezone){
		//set the timezone, used to decide what differences to make between timezones
		this.timezone = timezone;
		//create jframe and set boundaries
		frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,400);
		//create the label to display the current timezone
		JLabel label = new JLabel();
		//calls method that gets the full timezone name
		label.setText(setLabelText());
		label.setLocation(275, 0);
		label.setSize(200,30);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		label.setForeground(Color.white);
		//sets the location of the window, uses the variable horizontal to
		//know where to place the window horizontally. horizontally is 
		//initialized where the label text is initialized to get different location
		//per timezone
		frame.setLocation(horizontal, 400);
		
		//create resume and suspended buttons and set boundaries
		resume = new JButton();
		suspend = new JButton();
		
		resume.setSize(100, 50);
	    resume.setLocation(150, 250);
	    resume.setText("Resume");
	    suspend.setSize(100, 50);
	    suspend.setLocation(430, 250);
	    suspend.setText("Suspend");
		
		frame.add(label);
		frame.add(resume);
		frame.add(suspend);
		
		//create colors to use for background
		green = new Color(22, 160, 133);
		red = new Color(192, 57, 43);
		
		//initially set as green
		frame.getContentPane().setBackground(green);
		
		//create label that will display the current time for the timezone
		time = new JLabel();
		time.setLocation(180, 100);
		time.setSize(450,30);
		time.setFont(new Font("Serif", Font.PLAIN, 22));
		time.setForeground(Color.white);
		frame.add(time);
		
		
		//frame.setVisible(true);
	}

	@Override
	public void run() {
		
		//get current time
		Calendar cal = new GregorianCalendar();
		DateFormat fmt = DateFormat.getDateTimeInstance
			(DateFormat.FULL, DateFormat.FULL, Locale.US);
		TimeZone tze = TimeZone.getTimeZone(timezone);
		fmt.setTimeZone(tze);
		
		
		//set the text of the label to the current time
		time.setText(fmt.format(cal.getTime()));
		
		
		ActionListener actionListener;
		
		//action listener for resume button, set background to green and label to current time 
		resume.addActionListener(actionListener = new ActionListener() {
	    	
		      public void actionPerformed(ActionEvent actionEvent) {
		          frame.getContentPane().setBackground(green);
		          TimeZone tze = TimeZone.getTimeZone(timezone);
		  		  fmt.setTimeZone(tze);
		          time.setText(fmt.format(cal.getTime()));
		        }
		      });
		
		//action listener for suspend button, sets background to red and text to suspend
		suspend.addActionListener(actionListener = new ActionListener() {
	    	
		      public void actionPerformed(ActionEvent actionEvent) {
		          frame.getContentPane().setBackground(red);
		          time.setText("suspended");
		        }
		      });
		

		
		
		frame.setVisible(true);
	}
	
	
	/**
	 * this is used to determine the information thats special per timezone
	 * it changes the title label and the horizontal location where the window
	 * will appear
	 * @return
	 */
	private String setLabelText()
	{
		switch(timezone)
		{
		case "EST": 
			horizontal=0;
			return "Eastern Standard Time";
		case "CST":
			horizontal=700;
			return "Central Standard Time";
		case "PST":
			horizontal=1400;
			return "Pacific Standard Time";
			default:
				return "";
		}
		
	}
	
	

}
