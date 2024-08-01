import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGameDSA extends JPanel implements ActionListener {
    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 400;
    private final int UNIT_SIZE = 20;
    private final int DELAY = 75;

    private LinkedList<Point> snake;
    private Point apple;
    private char direction = 'R';
    private boolean running = false;
    private Timer timer;
    private Random random;

    public SnakeGameDSA() {
        random = new Random();
        snake = new LinkedList<>();
        snake.add(new Point(UNIT_SIZE, UNIT_SIZE)); // Initial position of the snake
        newApple();
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Draw apple
            g.setColor(Color.red);
            g.fillOval(apple.x, apple.y, UNIT_SIZE, UNIT_SIZE);

            // Draw snake
            for (Point p : snake) {
                g.setColor(Color.green);
                g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
            }
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        int randomX = random.nextInt((int) (BOARD_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        int randomY = random.nextInt((int) (BOARD_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        apple = new Point(randomX, randomY);
    }

    public void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head.x, head.y);

        switch (direction) {
            case 'U':
                newHead.y -= UNIT_SIZE;
                break;
            case 'D':
                newHead.y += UNIT_SIZE;
                break;
            case 'L':
                newHead.x -= UNIT_SIZE;
                break;
            case 'R':
                newHead.x += UNIT_SIZE;
                break;
        }

        snake.addFirst(newHead);

        if (newHead.equals(apple)) {
            newApple();
        } else {
            snake.removeLast();
        }

        checkCollisions();
    }

    public void checkCollisions() {
        // Check if head collides with itself or borders
        Point head = snake.getFirst();
        if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT
                || snake.contains(head) && snake.indexOf(head) != 0) {
            running = false;
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (BOARD_WIDTH - metrics.stringWidth("Game Over")) / 2, BOARD_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game with DSA");
        var game = new SnakeGameDSA();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}




