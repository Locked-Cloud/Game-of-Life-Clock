import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JPanel {
    private GameOfLife gol;
    private DateTimeFormatter formatter;
    private Timer timer;

    public DigitalClock() {
        // Increase the width to fit all digits and colons
        int width = 76; // Adjust width to fit "HH:mm:ss" with spacing
        int height = 7;  // Digit height remains 7
        gol = new GameOfLife(width, height);
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime time = LocalTime.now();
                String timeString = time.format(formatter);
                gol.setTime(timeString); // This will update the grid to display the current time
                revalidate();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK); // Set the background color to black
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        int cellSize = 20; // Adjust cell size as needed
        g.setColor(Color.WHITE); // Set the cell color to white
        for (int y = 0; y < gol.getHeight(); y++) {
            for (int x = 0; x < gol.getWidth(); x++) {
                if (gol.getCell(x, y)) {
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        DigitalClock clock = new DigitalClock();
        frame.add(clock);
        frame.setSize(1600, 200); // Adjust the frame size to fit the clock display
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// GameOfLife class remains the same, no changes needed there.
