package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Paddle {
	private Rectangle2D.Double _rect;
	private boolean _left, _right;
	
	public Paddle(double x, double y, double w, double h){
		_rect = new Rectangle2D.Double(x,y,w,h);
		_left = _right = false;
	}
	
	public void update(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_A){
			if (_left)
				_left = false;
			else _left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D){
			if (_right)
				_right = false;
			else _right = true;
		}
	}
	
	public void update(){
		if (_left){
			_rect.setFrame(_rect.getX() - 4, _rect.getY(), _rect.getWidth(), _rect.getHeight());
		}
		if (_right){
			_rect.setFrame(_rect.getX() + 4, _rect.getY(), _rect.getWidth(), _rect.getHeight());
		}
	}
	
	public void draw(Graphics2D g){
		g.fill(_rect);
	}
	
	public Rectangle2D.Double getRect(){
		return _rect;
	}
}
