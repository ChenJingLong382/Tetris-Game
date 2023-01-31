import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class TetrisTest {

	@Test
	public void testCheckedRows() {
		// create a grid 
		// fill all the squares except all rows except for rows = 5 and 15
		Grid g = new Grid();
		for (int row = 0; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				if(row != 5 && row != 15 || col == 4 || col ==5) {
				g.set(row, col, Color.BLUE);
				}
			}
		}
		g.checkRows();
		
		// check if we have 4 squares at the bottom of the grid
		for (int row = 0; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				if((row == Grid.HEIGHT - 1 || row == Grid.HEIGHT - 2) && 
					(col == 4 || col == 5)) {
					assertTrue(g.isSet(row, col));
				}
			}
		}
	}
	@Test
	public void testMoveSquare() {
		// create a grid to make squares at row 16 to 20
		// from col 0 to 4
		Grid h = new Grid();
		for (int row = 15; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < 5; col++) {
				h.set(row, col, Color.RED);
			}
		}
		// create a square to test that it can move properly
		Square s = new Square(h, 15, 5, Color.RED, true);
		assertTrue(s.canMove(Direction.RIGHT));
		assertFalse(s.canMove(Direction.LEFT));
		s.move(Direction.RIGHT);
		assertTrue(s.getCol() == 6);
		assertTrue(s.getRow() == 15);

	}
	
	@Test
	public void testRotate() {
		Grid g = new Grid();

		int row = 5, col = 5;
		Piece[] pieces = { new BarShape(row, col, g), new LShape(row, col, g), new ZShape(row, col, g),
				new TShape(row, col, g), new JShape(row, col, g), new SShape(row, col, g) };

		for (Piece p : pieces) {
			System.out.println(p.getClass());
			// The piece should be able to rotate
			assertTrue(p.canRotate());

			// Place a square next to the piece to prevent it from rotating
			int setRow, setCol;
			if (p.getClass() == BarShape.class) {
				setRow = row + 1;
				setCol = col;
			} else if (p.getClass() == LShape.class) {
				setRow = row;
				setCol = col - 1;
			} else if (p.getClass() == ZShape.class) {
				setRow = row + 1;
				setCol = col - 1;
			} else if (p.getClass() == TShape.class) {
				setRow = row + 1;
				setCol = col - 1;
			} else if (p.getClass() == JShape.class) {
				setRow = row;
				setCol = col - 1;
			} else { // SShape
				setRow = row;
				setCol = col - 1;
			}
			g.set(setRow, setCol, Color.GREEN);
			assertFalse(p.canRotate());

			// clear the square for the next piece
			g.set(setRow, setCol, Grid.EMPTY);
		}
	}
	

}
