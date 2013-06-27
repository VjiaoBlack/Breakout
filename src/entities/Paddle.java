package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Paddle {
	private Rectangle2D.Double _rect;
	private boolean _left, _right;
	private double _xvel;

	public Paddle(double x, double y, double w, double h) {
		_rect = new Rectangle2D.Double(x, y, w, h);
		_left = _right = false;
	}

	public void update(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (_left)
				_left = false;
			else
				_left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (_right)
				_right = false;
			else
				_right = true;
		}

	}

	public void update() {
		double xcor = _rect.getX();
		double ycor = _rect.getY();
		if (_xvel > -5) {
			if (_left) {
				_xvel -= 0.5;
			}
		}
	    if (_xvel < 5) {
			if (_right) {
				_xvel += 0.5;
			}
		}
	    if (!_left && !_right){
	    	_xvel *= .9;
	    }
	    xcor += _xvel;
	    		
	    if (xcor < 0){
			xcor = 0;
			_xvel = 0;
	    }
	    if (xcor + _rect.getWidth() > 800){
	    	xcor = 800 - _rect.getWidth();
	    	_xvel = 0;
	    }
		_rect.setFrame(xcor, _rect.getY(), _rect.getWidth(),
				_rect.getHeight());
	}

	public void draw(Graphics2D g) {
		g.fill(_rect);
	}

	public Rectangle2D.Double getRect() {
		return _rect;
	}
}
