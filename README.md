# JavaSnakeGame


![Java Snake Game](https://github.com/yourusername/JavaSnakeGame/raw/main/screenshot.png)

A classic Snake game implemented in Java. This project serves as a fun and educational example of using Java for simple game development.

## Description

The Java Snake Game is a recreation of the classic Snake game that many of us enjoyed in our childhood. The player controls a snake that moves around the screen, eating food to grow longer while avoiding running into walls or itself. This project is designed to demonstrate fundamental game development concepts such as game loops, collision detection, and event handling in Java.

The game features a simple and clean user interface, making it easy to understand and play. It also includes score tracking and game over detection. The codebase is structured in a way that allows easy extension and modification, making it an excellent starting point for those interested in game development.

## How It Works

### Game Loop

The game utilizes a game loop that continuously updates the game state and renders the game on the screen. The loop consists of the following steps:
1. **Process Input**: Captures user input (arrow keys) to change the snake's direction.
2. **Update Game State**: Moves the snake, checks for collisions, and updates the score.
3. **Render**: Draws the snake, food, and score on the screen.

### Snake Movement

- The snake is represented as a list of segments, where each segment is a coordinate (x, y) on the grid.
- The snake moves by adding a new segment in the direction of movement and removing the last segment.
- The direction of the snake can be controlled using the arrow keys.

### Food Generation

- Food is randomly placed on the grid.
- When the snake eats the food (i.e., the snake's head position matches the food's position), the food is relocated to a new random position, and the snake grows longer.

### Collision Detection

- **Self-Collision**: The game checks if the snake's head collides with any of its body segments. If it does, the game is over.
- **Wall-Collision**: The game checks if the snake's head goes out of bounds. If it does, the game is over.

### Score Tracking

- The score is tracked by counting the number of food items eaten by the snake.
- The score is displayed on the screen.

### Game Over

- When a collision is detected, the game stops, and a game over message is displayed.

## Features

- Classic Snake game mechanics
- Simple and clean UI
- Score tracking
- Game over detection
- Easy to extend and modify

## Installation

### Prerequisites

- Java Development Kit (JDK) installed
- Git installed

