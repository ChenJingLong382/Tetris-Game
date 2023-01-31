
import java.awt.*;

public class ZShape extends AbstractPiece {

    public ZShape(int r, int c, Grid g) {
        super(g);
        // Create the squares // ZShape
        squares[0] = new Square(g, r, c, Color.magenta, true);
        squares[1] = new Square(g, r, c+1, Color.magenta, true);
        squares[2] = new Square(g, r+1, c+1, Color.magenta, true);
        squares[3] = new Square(g, r+1, c+2, Color.magenta, true);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
    }

    @Override
    public Point[] getLocations() {
        return super.getLocations();
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMove(Direction direction) {
        return super.canMove(direction);
    }

    /**
     * Draws the piece on the given Graphics context
     */


    /**
     * Moves the piece if possible Freeze the piece if it cannot move down
     * anymore
     *
     * @param direction
     *            the direction to move
     */


    /**
     * Returns the (row,col) grid coordinates occupied by this Piece
     *
     * @return an Array of (row,col) Points
     */


    /**
     * Return the color of this piece
     */


    /**
     * Returns if this piece can move in the given direction
     *
     */

}

