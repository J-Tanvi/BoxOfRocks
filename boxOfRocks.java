//Name: Tanvi Jain
//Date: June 16th, 2023
//Purpose: to help a teacher engage his class

//libaries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.io.*;

public class boxOfRocks extends Applet implements ActionListener
{
    //global variables
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5, card6;
    CardLayout cdLayout = new CardLayout ();

    JLabel picture, picture2, count, points;
    JLabel result;
    //the picture of the rocks
    JLabel rock1, rock2;
    int guess;
    int sum;
    //tracks whose winning
    JLabel star, star2, star3, star4, star5, star6;
    int rockPts, userPts;
    //the card stack
    CardStack box = new CardStack ();
    Card d;
    int num = 0;
    //helps keep the cards shuffled
    int numberStack = (int) (Math.random () * 39) + 1; //eg. 11
    public char difficulty = 'A';
    int choice = 0;


    //prints the date
    public void date ()
    {
	Date now = new Date ();
	DateFormat df = DateFormat.getDateInstance ();
	df.setTimeZone (TimeZone.getTimeZone ("Canada/Toronto"));
	String s = df.format (now);
	JOptionPane.showMessageDialog (null, "Today is " + s,
		"Date", JOptionPane.INFORMATION_MESSAGE);
    }


    //main method
    public void init ()
    {
	date ();
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//all the screens
	screen1 ();
	screen2 ();
	screen6 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (350, 620);
	setLayout (new BorderLayout ());
	menu ();
	add ("Center", p_card);
    }


    //adds a menu for users
    public void menu ()
    {
	Color brown = new Color (148, 120, 111);
	Color darkBrown = new Color (56, 46, 19);
	JMenuBar menuBar = new JMenuBar ();
	menuBar.setBackground (brown);
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menu.setBackground (brown);
	menu.setForeground (darkBrown);
	menuBar.add (menu);
	menuItem = new JMenuItem ("Date");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("date");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Exit");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("exit");
	menu.add (menuItem);

	menu = new JMenu ("Game Settings");
	menu.setBackground (brown);
	menu.setForeground (darkBrown);
	menuBar.add (menu);
	menuItem = new JMenuItem ("Reset Game");
	menuItem.setActionCommand ("reset");
	menuItem.addActionListener (this);
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menu.setBackground (brown);
	menu.setForeground (darkBrown);
	menuBar.add (menu);
	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s1");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Intructions");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s2");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Controls");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s6");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Play");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s3");
	menu.add (menuItem);

	add ("North", menuBar);
    }


    public void screen1 ()
    { //title screen
	card1 = new Panel ();
	JButton next = new JButton (createImageIcon ("title.png"));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //instructions
	card2 = new Panel ();
	JButton next = new JButton (createImageIcon ("instruc.png"));
	next.setActionCommand ("s6");
	next.addActionListener (this);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void screen6 ()
    { //controles
	card6 = new Panel ();
	JButton next = new JButton (createImageIcon ("controls.png"));
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card6.add (next);
	p_card.add ("6", card6);
    }


    public void screen3 ()
    { //the actual game
	card3 = new Panel ();
	card3.setBackground (new Color (148, 120, 111));

	JLabel title = new JLabel ("Box of Rocks!");
	title.setFont (new Font ("Unispace", Font.BOLD, 30));
	title.setForeground (new Color (56, 46, 19));
	rock1 = new JLabel (createImageIcon ("rock0.png"));
	rock2 = new JLabel (createImageIcon ("rock0.png"));
	picture = new JLabel (createImageIcon ("1.png"));
	picture2 = new JLabel (createImageIcon ("41.png"));
	picture2.setVisible (false);
	//score tracker
	JLabel human = new JLabel (createImageIcon ("hooman.png"));
	star = new JLabel (createImageIcon ("star.png"));
	star2 = new JLabel (createImageIcon ("star.png"));
	star3 = new JLabel (createImageIcon ("star.png"));
	JLabel rocko = new JLabel (createImageIcon ("rocko.png"));
	star4 = new JLabel (createImageIcon ("star.png"));
	star5 = new JLabel (createImageIcon ("star.png"));
	star6 = new JLabel (createImageIcon ("star.png"));
	star.setVisible (false);
	star2.setVisible (false);
	star3.setVisible (false);
	star4.setVisible (false);
	star5.setVisible (false);
	star6.setVisible (false);

	count = new JLabel ("Your deck of cards currently has: 0 Cards.");
	points = new JLabel ("<waiting for questions to be answered>");
	result = new JLabel ("<waiting for questions to be answered>");
	Panel p = new Panel (new GridLayout (4, 1));
	p.add (count);
	p.add (points);
	p.add (result);

	Panel p2 = new Panel (new GridLayout (1, 1));
	p2.add (rock1);
	p2.add (rock2);

	Panel p3 = new Panel (new GridLayout (1, 1));
	p3.add (picture);
	p3.add (picture2);


	Panel starH = new Panel (new GridLayout (3, 1));
	starH.add (star);
	starH.add (star2);
	starH.add (star3);

	Panel starR = new Panel (new GridLayout (3, 1));
	starR.add (star4);
	starR.add (star5);
	starR.add (star6);

	Panel p4 = new Panel (new GridLayout (1, 1));
	p4.add (human);
	p4.add (rocko);

	//adds all the panels to the screen
	card3.add (title);
	card3.add (p);
	card3.add (p2);
	card3.add (p3);
	card3.add (starH);
	card3.add (p4);
	card3.add (starR);

	p_card.add ("3", card3);
    }


    public void screen4 ()
    { //win screen
	card4 = new Panel ();
	JButton next = new JButton (createImageIcon ("win.png"));
	next.setActionCommand ("s5");
	next.addActionListener (this);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //lose screen
	card5 = new Panel ();
	JButton next = new JButton (createImageIcon ("lose.png"));
	next.setActionCommand ("s1");
	next.addActionListener (this);
	card5.add (next);
	p_card.add ("5", card5);
    }


    //arrow key notifiers
    public void addNotify ()
    {
	super.addNotify ();
	setFocusable (true);
	requestFocusInWindow ();
	addKeyListener (new ArrowKeyListener ());
    }


    //arrow key listener
    private class ArrowKeyListener extends KeyAdapter
    {
	public void keyReleased (KeyEvent e)
	{
	    if (e.getKeyCode () == KeyEvent.VK_UP)
	    { //shakes the rocks
		turnRock ();
	    }
	    else if (e.getKeyCode () == KeyEvent.VK_DOWN)
	    { //enters the turn
		picture2.setVisible (true);
		turnYou ();
	    }
	    else if (e.getKeyCode () == KeyEvent.VK_LEFT)
	    { //pops card off stack
		pop ();

	    }
	    else if (e.getKeyCode () == KeyEvent.VK_RIGHT)
	    { //pushes a card onto the stack
		push ();
	    }
	    else if (e.getKeyCode () == 48)
	    { //enters players guess as 0
		guess = 0;
		JOptionPane.showMessageDialog (null, "Your guess is '0'.",
			"Guess '0'", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else if (e.getKeyCode () == 49)
	    { //enters players guess as 1
		guess = 1;
		JOptionPane.showMessageDialog (null, "Your guess is '1'.",
			"Guess '1'", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else if (e.getKeyCode () == 50)
	    { //enters players guess as 2
		guess = 2;
		JOptionPane.showMessageDialog (null, "Your guess is '2'.",
			"Guess '2'", JOptionPane.INFORMATION_MESSAGE);
	    }
	    //picks difficulty
	    else if (e.getKeyCode () == 65)
	    { //chooses question set a
		difficulty = 'A';
		choice = 0;
		JOptionPane.showMessageDialog (null, "You have selected question A. This selection will remain until changed.",
			"Question A", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else if (e.getKeyCode () == 66)
	    { //chooses question set b
		difficulty = 'B';
		choice = 1;
		JOptionPane.showMessageDialog (null, "You have selected question B. This selection will remain until changed.",
			"Question B", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else if (e.getKeyCode () == 67)
	    { //chooses question set c
		difficulty = 'C';
		choice = 2;
		JOptionPane.showMessageDialog (null, "You have selected question C. This selection will remain until changed.",
			"Question C", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }


    public void push ()
    { //pushes a new card onto the stack
	picture2.setVisible (false);
	points.setText ("<waiting for questions to be answered>");
	result.setText ("<waiting for questions to be answered>");
	//make a new random card
	numberStack = (int) (Math.random () * 39) + 1;
	d = new Card (numberStack);
	//if the box isn't full
	if (!box.isFull ())
	{
	    //Push d onto the box
	    box.push (d);
	    //add one to num
	    num++;
	    //Call showCard, pass in d
	    showCard (d);
	}
    }


    public void pop ()
    { //pops a card off the stack
	picture2.setVisible (false);
	points.setText ("<waiting for questions to be answered>");
	result.setText ("<waiting for questions to be answered>");
	if (!box.isEmpty ())
	{ //pop a donut from the box, save it
	    Card d = box.pop ();
	    //subtract one from num
	    num--;
	    //call showCard, pass in d
	    showCard (d);
	}
	else
	{
	    //set num to 0
	    num = 0;
	    //at the bottom, call drawblank
	    drawblank ();
	}
    }


    public void turnRock ()
    { //picks a random number for the rocks and displays it on screen
	int num = (int) (Math.random () * 2);
	int num2 = (int) (Math.random () * 2);
	if (num == 1)
	{
	    rock1.setIcon (createImageIcon ("rock1.png"));
	}
	else // if (num == 1)
	{
	    rock1.setIcon (createImageIcon ("rock0.png"));
	}
	if (num2 == 1)
	{
	    rock2.setIcon (createImageIcon ("rock1.png"));
	}
	else // if (num2 == 1)
	{
	    rock2.setIcon (createImageIcon ("rock0.png"));
	}
	sum = num + num2;
    }


    public void turnYou ()
    { //submits all the given information and gives points to whoever won
	int ans = d.getCardPts () [choice];
	points.setText ("The correct answer to question " + difficulty + " is " + ans + ".");
	if (guess == ans && sum == ans)
	{ //tie or no points
	    result.setText ("You have tied. No points awarded.");
	}
	else if (guess == ans)
	{ //user gets a point
	    result.setText ("You outsmarted the rocks. +1 star for you.");
	    userPts++;
	    //updates stars
	    if (userPts == 1)
		star.setVisible (true);
	    else if (userPts == 2)
		star2.setVisible (true);
	    else if (userPts == 3)
	    {
		star3.setVisible (true);
		win ();
	    }
	}
	else if (sum == ans)
	{ //rocks get a point
	    result.setText ("You lost to rocks. +1 star for rocks.");
	    rockPts++;
	    //updates stars
	    if (rockPts == 1)
		star4.setVisible (true);
	    else if (rockPts == 2)
		star5.setVisible (true);
	    else if (rockPts == 3)
	    {
		star6.setVisible (true);
		lose ();
	    }
	}
	Card d = new Card (numberStack);
	showAnswer (d);

    }


    public void drawblank ()
    { //resets the stack
	picture.setIcon (createImageIcon ("1.png"));
	points.setText ("<waiting for questions to be answered>");
	result.setText ("<waiting for questions to be answered>");
	count.setText ("Your deck of cards currently has: 0 Cards.");
    }


    public void showCard (Card d)
    { //displays a card
	picture.setIcon (createImageIcon (d.getPicName () + ".png"));
	count.setText ("Your deck of cards currently has: " + num + " Cards.");
    }


    public void showAnswer (Card d)
    { //shows the answer card
	picture2.setIcon (createImageIcon (d.getPicAnswer () + ".png"));
    }


    public void win ()
    { // goes to the win screen
	cdLayout.show (p_card, "4");
    }


    public void lose ()
    { //goes to the lose screen
	cdLayout.show (p_card, "5");
    }


    public void reset ()
    { //resets the game
	//set num to 0
	num = 0;
	//clear box
	box.clear ();
	//call drawblank
	drawblank ();
	rockPts = 0;
	userPts = 0;
	//reset scores
	userPts = 0;
	rockPts = 0;
	star.setVisible (false);
	star2.setVisible (false);
	star3.setVisible (false);
	star4.setVisible (false);
	star5.setVisible (false);
	star6.setVisible (false);
	cdLayout.show (p_card, "1");
    }


    public void actionPerformed (ActionEvent e)
    { //actioned performed
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("s6"))
	    cdLayout.show (p_card, "6");
	else if (e.getActionCommand ().equals ("date"))
	    date ();
	else if (e.getActionCommand ().equals ("exit"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
    }


    protected static ImageIcon createImageIcon (String path)
    { //actual code that is displaying the images
	java.net.URL imgURL = boxOfRocks.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}




