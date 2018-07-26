package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape implements GraphicalObject{
	public Oval()
	{
		this.left = 0;
		this.top = 0;
		this.width = 20;
		this.height = 20;
		this.color = "black";
	}
	public Oval(int left, int top, int width, int height, String color)
	{
		this.left = left; 
		this.top = top;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	public void draw(Graphics g)
	{
		if(this.color.equals("red"))
			g.setColor(Color.red);
		else if(this.color.equals("green"))
			g.setColor(Color.green);
		else if(this.color.equals("blue"))
			g.setColor(Color.blue);
		else if(this.color.equals("orange"))
			g.setColor(Color.orange);
		else if(this.color.equals("yellow"))
			g.setColor(Color.yellow);
		else if(this.color.equals("violet"))
			g.setColor(Color.magenta);
		else if(this.color.equals("black"))
			g.setColor(Color.black);
		else if(this.color.equals("gray")) 
			g.setColor(Color.gray);
		g.fillOval(left, top, width, height);
		
	}
	public boolean containsPt(int x, int y)
	{
		int xFlag = 0;
		int yFlag = 0;
		int leftbound,rightbound,upbound,botbound;
		leftbound = left;
		rightbound = left + width;
		upbound = top;
		botbound = top - height;
		if(x >= leftbound && x <= rightbound)
			xFlag = 1;
		if(y >= botbound && y <= upbound)
			yFlag = 1;
		if(xFlag == 1 && yFlag == 1)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return String.format("Oval(%d, %d, %d, %d)", left, top, width, height);
	}

}
