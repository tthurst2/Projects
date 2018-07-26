package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Line extends Shape implements GraphicalObject{
	int x1, x2, y1, y2;
	public Line()
	{
		this.x1 = 0;
		this.y1 = 0;
		this.x2 = 20;
		this.y2 = 20;
		this.color = "black";
	}
	public Line(int x1, int y1, int x2, int y2, String color)
	{
		this.x1 = x1; 
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
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
		g.drawLine(x1, y1, x2, y2);
	}
	public boolean containsPt(int x, int y)
	{
		Line2D Dline =  new Line2D.Double((double)x1, (double)y1, (double)x2, (double)y2);
		if(Dline.ptSegDistSq((double) x, (double) y) <= 5)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return String.format("Line(%d, %d, %d, %d)", x1, y1, x2, y2);
	}

}
