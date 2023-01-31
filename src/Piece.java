
import java.awt.*;

public interface Piece {

    // all the methods from LShape

    void move(Direction direction);

    Point[] getLocations();

    Color getColor();

    boolean canMove(Direction direction);

    void draw(Graphics g);

    void rotate(Direction direction);

	boolean canRotate();
}
