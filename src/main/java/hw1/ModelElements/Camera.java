package hw1.ModelElements;


import hw1.Stuff.Angle3D;
import hw1.Stuff.Point3D;

public class Camera {
    public Point3D location;
    public Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    // TODO: реализовать метод rotate
    public void rotate(Angle3D angle) {
    }

    // TODO: реализовать метод move
    public void move(Point3D location) {
    }
}
