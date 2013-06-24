package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Brick {
	private Rectangle2D.Double _rect;
	private boolean _isOn;

	public Brick(double x, double y, double w, double h) {
		_rect = new Rectangle2D.Double(x, y, w, h);
		_isOn = false;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		if (_isOn){
			g.fill(_rect);
		}
	}

	public void setOn(boolean b) {
		_isOn = b;
	}
	
	public boolean getOn(){
		return _isOn;
	}
	
	public Rectangle2D.Double getRect(){
		return _rect;
	}
	
	public void update(){
		
	}

}
