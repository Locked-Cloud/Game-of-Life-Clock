// The GameOfLife class
import java.util.Arrays;

public class GameOfLife {
    private int width;
    private int height;
    private boolean[][] grid;

    private static final int DIGIT_WIDTH = 6;
    private static final int DIGIT_HEIGHT = 7;
    private static final int DIGIT_SPACING = 2;
    
    private static final boolean[][][] DIGITS = {
        // 0
        {{false, true, true, true, true, false}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // 1
        {{false, false, true, true, false, false}, {false, true, false, true, false, false}, {false, false, false, true, false, false}, {false, false, false, true, false, false}, {false, false, false, true, false, false}, {false, false, false, true, false, false}, {false, false, true, true, true, false}},
        // 2
        {{false, true, true, true, true, false}, {true, false, false, false, false, true}, {false, false, false, false, false, true}, {false, true, true, true, true, false}, {true, false, false, false, false, false}, {true, false, false, false, false, false}, {false, true, true, true, true, true}},
        // 3
        {{false, true, true, true, true, false}, {true, false, false, false, false, true}, {false, false, false, false, false, true}, {false, false, true, true, true, false}, {false, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // 4
        {{false, false, false, true, true, false}, {false, false, true, false, true, false}, {false, true, false, false, true, false}, {true, false, false, false, true, false}, {true, true, true, true, true, true}, {false, false, false, false, true, false}, {false, false, false, false, true, false}},
        // 5
        {{true, true, true, true, true, true}, {true, false, false, false, false, false}, {true, true, true, true, true, false}, {false, false, false, false, false, true}, {false, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // 6
        {{false, true, true, true, true, false}, {true, false, false, false, false, false}, {true, true, true, true, true, false}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // 7
        {{true, true, true, true, true, true}, {false, false, false, false, false, true}, {false, false, false, false, false, true}, {false, false, false, false, false, true}, {false, false, false, false, false, true}, {false, false, false, false, false, true}, {false, false, false, false, false, true}},
        // 8
        {{false, true, true, true, true, false}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // 9
        {{false, true, true, true, true, false}, {true, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}, {false, false, false, false, false, true}, {true, false, false, false, false, true}, {false, true, true, true, true, false}},
        // Colon (:)
        {{false, false, false, false, false, false}, {false, false, false, false, false, false}, {false, true, true, false, false, false}, {false, false, false, false, false, false}, {false, true, true, false, false, false}, {false, false, false, false, false, false}, {false, false, false, false, false, false}}
    };

    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
    }

    public void setTime(String timeString) {
        clearGrid();
        int xOffset = 0;
        for (char ch : timeString.toCharArray()) {
            if (Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);
                placeDigit(digit, xOffset);
                xOffset += DIGIT_WIDTH + DIGIT_SPACING;
            } else if (ch == ':') {
                placeColon(xOffset);
                xOffset += DIGIT_WIDTH; // Colon is narrower
            }
        }
    }

    private void placeDigit(int digit, int xOffset) {
        for (int y = 0; y < DIGIT_HEIGHT; y++) {
            for (int x = 0; x < DIGIT_WIDTH; x++) {
                grid[y][x + xOffset] = DIGITS[digit][y][x];
            }
        }
    }

    private void placeColon(int xOffset) {
        for (int y = 0; y < DIGIT_HEIGHT; y++) {
            for (int x = 0; x < DIGIT_WIDTH; x++) {
                grid[y][x + xOffset] = DIGITS[10][y][x]; // Use the full width of the colon
            }
        }
    }

    private void clearGrid() {
        for (int y = 0; y < height; y++) {
            Arrays.fill(grid[y], false);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean getCell(int x, int y) {
        return grid[y][x];
    }
}
