package graphics;

import java.awt.Graphics;

interface GraphicalObject
{
	public void draw(Graphics g);
	public boolean containsPt(int x, int y);
	public String toString();
}
