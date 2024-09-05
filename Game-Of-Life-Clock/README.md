# Digital Clock Project

## Overview

The Digital Clock project is a graphical Java application that displays the current time in a digital clock format using the Game of Life algorithm. The clock updates every second and visualizes the time using a grid-based representation.

## Features

- **Real-Time Clock**: Displays the current time in `HH:mm:ss` format.
- **Graphical Display**: Utilizes a grid to render digits and colons in a digital clock style.
- **Live Updates**: Updates the display every second to reflect the current time.

## Project Structure

- **`DigitalClock.java`**: The main class for the digital clock application. It sets up the graphical user interface, manages the timer, and updates the display every second.
- **`GameOfLife.java`**: Contains the logic for rendering digits and colons on a grid. It updates the grid based on the current time.

## How It Works

1. **Initialization**: 
   - The `DigitalClock` class initializes a `GameOfLife` instance with a grid size sufficient to display the time.
   - A `Timer` is set to trigger every second, fetching the current time and updating the grid.

2. **Rendering**: 
   - The `GameOfLife` class converts the current time into a grid representation, placing digits and colons accordingly.
   - The `DigitalClock` class paints the grid onto the screen, with each cell representing a part of the digit or colon.

## Usage

1. **Build and Run**: Compile and run the `DigitalClock` class to start the application. Ensure that both `DigitalClock.java` and `GameOfLife.java` are in the same directory or properly configured in your IDE.

2. **Adjustments**:
   - Modify the grid size and cell size in `DigitalClock.java` if needed to fit different screen resolutions.
   - Adjust the `cellSize` in the `drawGrid` method to change the display size of each digit.

## Example

Upon running the application, you should see a window displaying the current time in a digital format, updating every second.

## Dependencies

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or higher installed to compile and run the application.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For any questions or issues, please contact:

- **Name**: Your Name
- **Email**: your.email@example.com
