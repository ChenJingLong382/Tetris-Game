
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An L-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration:
 *
 * Sq <br>
 * Sq <br>
 * Sq Sq <br>
 *
 * The game piece "floats above" the Grid. The (row, col) coordinates are the
 * location of the middle Square on the side within the Grid
 *
 * @author CSC 143
 */
public class BarShape extends AbstractPiece {

    public BarShape(int r, int c, Grid g) {
        super(g);
        // Create the squares // BarShape
        squares[0] = new Square(g, r, c, Color.magenta, true);
        squares[1] = new Square(g, r, c+1, Color.magenta, true);
        squares[2] = new Square(g, r, c+2, Color.magenta, true);
        squares[3] = new Square(g, r, c+3, Color.magenta, true);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void rotate(Direction direction) {

        int centralRow = squares[1].getRow();
        int centralColumn = squares[1].getCol();


        if (canRotate(centralRow, centralColumn)) {
            for (Square square: squares) {
                square.rotate(centralRow, centralColumn);
            }
        }
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
