package graphics;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

class GraphicsDriver extends JPanel {

    JFrame window = new JFrame();
    LinkedList<GraphicalObject> components = new LinkedList<GraphicalObject>();
    
    public Dimension getPreferredSize() {
	return new Dimension(800, 800);
    }
   
    public GraphicsDriver () {

	// PUT YOUR CODE FOR CREATING OBJECTS AND CHECKING WHETHER OBJECTS
	// CONTAIN MOUSE POINTS HERE
    	/************************************MYCODE*************************************/
    	Scanner stdin = new Scanner(System.in);
    	/*Reads in file*/
    	while(stdin.hasNext() == true)
    	{
    		String lineFirst = stdin.next();
    		if(lineFirst.equals("rectangle"))
    		{
    			/*Setter takes the next 4 integers from the line and then the next anything */
    			GraphicalObject r = new Rectangle(stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.next());
    			components.add(r); //add to the linkedlist
    		}
    		else if(lineFirst.equals("oval"))
    		{
    			GraphicalObject r = new Oval(stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.next());
    			components.add(r); //add to the linkedlist
    		}
    		else if(lineFirst.equals("roundtangle"))
    		{   //adds arcsize
    			int left = stdin.nextInt(); int top = stdin.nextInt();int width = stdin.nextInt();int height = stdin.nextInt();
    			int arcsize = 0;
    			String color = stdin.next();
    			if(stdin.hasNextInt())
    				arcsize = stdin.nextInt();
    			else 
    			{
    				String s = stdin.next();
    				if(s.equals("SMALL"))
    					arcsize = 10;
    				if(s.equals("MEDIUM"))
    					arcsize = 20;
    				if(s.equals("LARGE"))
    					arcsize = 30;
    			}
    			/*else if(stdin.hasNext() == "SMALL")
    				arcsize = 10;
    			else if(stdin.next() == "MEDIUM")
    				arcsize = 20;
    			else if(stdin.next() == "LARGE")
    				arcsize = 30;*/
       			GraphicalObject r = new Roundtangle(left, top, width, height, color, arcsize);
    			components.add(r); //add to the linkedlist
    		}
    		else if(lineFirst.equals("text"))
    		{
    			GraphicalObject r = new Text(stdin.nextInt(), stdin.nextInt() , stdin.next(), stdin.nextLine());
    			components.add(r); //add to the linkedlist
    		}
    		else if(lineFirst.equals("line"))
    		{
    			GraphicalObject r = new Line(stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.next());
    			components.add(r); //add to the linkedlist
    		}
    		else if(lineFirst.equals("end"))
    			break;  //done with taking in shapes and ready to read in points    		
    		else
    		{
    			System.out.println("The first line isn't an allowed shape!"); //error checking
    			return;
    		}
    	}
    		/*Reads in Points */
    		while(stdin.hasNext()==true)
    		{
    			int x = stdin.nextInt();  //first integer
    			int y = stdin.nextInt();  //second integer
    			int i;
    			for(i = components.size()-1; i >= 0; i--) //reverse traversal
    			{
    				if(components.get(i).containsPt(x, y) == true) //traverses list backwards and runs containsPt
    				{
    					System.out.printf("%s\n",components.get(i).toString()); //call to string on the last shape with the points contained
    					break; //make sure only to do the last one
    				}
    			}
    			if(i == -1)  //if the list ran through and didn't break, ie, no points fit
    			{
    				System.out.printf("No shapes containes the point(%d, %d)!\n", x, y); //printing
    		
    			}
    			
    		}
    	
    	/************************************MYCODE*************************************/
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.getContentPane().add(this, BorderLayout.CENTER);
	
	window.pack();
	window.setVisible(true);
    }

    static public void main(String args[]) {
	GraphicsDriver testDriver = new GraphicsDriver();
    }

    public void paintComponent(Graphics g) {
	for (GraphicalObject obj : components) {
	    obj.draw(g);
	}
    }

}