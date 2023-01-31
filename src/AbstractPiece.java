

import java.awt.*;

public abstract class AbstractPiece implements Piece {



    // all instance variables from LShape class

    protected boolean ableToMove; // can this piece move

    protected Square[] squares; // the squares that make up this piece

    // Made up of PIECE_COUNT squares
    protected Grid grid; // the board this piece is on

    // number of squares in one Tetris game piece
    protected static final int PIECE_COUNT = 4;

    public AbstractPiece(Grid grid) {
        this.ableToMove = true;
        this.squares = new Square[PIECE_COUNT];
        this.grid = grid;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < PIECE_COUNT; i++) {
            squares[i].draw(g);
        }
    }

    @Override
    public void move(Direction direction) {
        // It makes L-Shape figure to drop all the way down
        if (direction == Direction.DROP) {
            while (canMove(Direction.DOWN)){
                for (int i=0; i<PIECE_COUNT; i++){
                    squares[i].move(Direction.DOWN);
                }
            }
        }

        else if (canMove(direction)) {
            for (int i = 0; i < PIECE_COUNT; i++)
                squares[i].move(direction);
        }
        // if we couldn't move, see if because we're at the bottom
        else if (direction == Direction.DOWN) {
            ableToMove = false;
        }
    }

    @Override
    public Point[] getLocations() {
        Point[] points = new Point[PIECE_COUNT];
        for (int i = 0; i < PIECE_COUNT; i++) {
            points[i] = new Point(squares[i].getRow(), squares[i].getCol());
        }
        return points;
    }

    @Override
    public Color getColor() {
        // all squares of this piece have the same color
        return squares[0].getColor();
    }

    @Override
    public boolean canMove(Direction direction) {
        if (!ableToMove)
            return false;

        // Each square must be able to move in that direction
        boolean answer = true;
        for (int i = 0; i < PIECE_COUNT; i++) {
            answer = answer && squares[i].canMove(direction);
        }

        return answer;
    }
    @Override
    public void rotate(Direction direction) {
        int centralRow = squares[1].getRow();
        int centralCol = squares[1].getCol();
        if (canRotate(centralRow, centralCol)) {
            for (Square square: squares) {
                square.rotate(centralRow, centralCol);
            }
        }

    }

    @Override
    public boolean canRotate() {
        for (int i = 0; i < PIECE_COUNT; i++) {
            if (!this.square[i].canRotate(square[1])) return false;
        }
        return true;
    }


}
