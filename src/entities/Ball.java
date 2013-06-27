package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private Ellipse2D.Double _circle;
	private int _angle;
	private int _speed;
	private double _gravity;
	private boolean _intersects;

	public Ball(double x, double y) {
		_circle = new Ellipse2D.Double(x, y, 10, 10);
		_angle = 270;
		_speed = 400;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fill(_circle);

	}

	public boolean bounce(Rectangle2D.Double rect, boolean isPaddle) {
		int _oldAngle = _angle;
		double x = _circle.getCenterX();
		double y = _circle.getCenterY();
		if (isPaddle) {
			if (_circle.intersects(rect)) {
				_gravity = -4;
				if ((_circle.getY() + 10) >= rect.getY()
						&& _circle.getX() + 5 >= rect.getX()
						&& _circle.getX() + 5 <= rect.getX() + rect.getWidth()
						&& _circle.intersects(rect)) {
					_angle = 135 - (int) (90.0 * ((x - rect.getX()) / rect
							.getWidth()));
				} else if (rect.getX() - x <= 5) {
					_angle = 150;
				}

				else if (rect.getX() + rect.getWidth() - _circle.getX() <= 5) {
					_angle = 30;
				}
			}

		} else {
			if (_circle.intersects(rect)) {
				if (x >= rect.getX() + .1
						&& x <= rect.getX() + rect.getWidth() + .1)
					_angle = 0 - _angle;
				else if (y >= rect.getY() + .1
						&& y <= rect.getY() + rect.getWidth() + .1)
					if (_angle > 180)
						_angle = 540 - _angle;
					else
						_angle = 180 - _angle;
			}
		}

		if (_circle.getX()
				+ (_speed * (Math.cos(Math.toRadians(_angle))) / 100) < 0
				&& !_intersects) {
			if (_angle > 180)
				_angle = 540 - _angle;
			else
				_angle = 180 - _angle;
			return false;
		}
		if (_circle.getY()
				- (_speed * (Math.sin(Math.toRadians(_angle))) / 100) < 0
				&& !_intersects) {
			_angle = 0 - _angle;
			_gravity = 0;
			return false;
		}
		if (_circle.getX() + _circle.getWidth()
				+ (_speed * (Math.cos(Math.toRadians(_angle))) / 100) > 800
				&& !_intersects) {
			if (_angle > 180)
				_angle = 180 + 180 - (_angle - 180);
			else
				_angle = 180 - _angle;
			return false;
		}
		if (_circle.getX() + _circle.getWidth()
				+ (_speed * (Math.cos(Math.toRadians(_angle))) / 100) > 800
				|| _circle.getY() < 0 || _circle.getX() < 0)
			_intersects = true;
		else
			_intersects = false;

		return _angle != _oldAngle;
	}

	public void update() {

		_circle.setFrame(
				_circle.getX()
						+ (_speed * (Math.cos(Math.toRadians(_angle))) / 100),
				_circle.getY()
						- (_speed * (Math.sin(Math.toRadians(_angle))) / 100)
						+ _gravity, 10, 10);
		_gravity += 0.06;

	}
}
