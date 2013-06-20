import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {

    private final int SPEED = 5;
    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;

    private Image image;
    private final Random rng = new Random();
    private int x = rng.nextInt(800);
    private int y = 600;

    public Game() {
        super("Slick 2D reference");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        loadSpider();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            resetSpider();
        }
        y -= SPEED;
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setBackground(Color.white);
        image.draw(x, y);
        g.setColor(Color.black);
        g.drawString("Press SPACE to reset the spider!", 10, 10);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setVSync(true);
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setShowFPS(false);
        app.start();
    }

    private void resetSpider() {
        y = WIDTH;
        x = rng.nextInt(HEIGHT - 150);
    }

    private void loadSpider() throws SlickException {
        image = new Image("/resources/spider.png");
    }

}
