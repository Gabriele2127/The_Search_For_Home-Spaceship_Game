import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private Counter scoreCounter;
    private int startAsteroids2 = 3;
    private int startAlien = 5;
    public int numberOfObjects;
    
    /**
     * Constructor for level.
     */
    public Level2() 
    {
        super(600, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars(706);

        StarFighter2 starfighter2 = new StarFighter2();
        addObject(starfighter2, getWidth()/2 + 100, getHeight()/2);

        addAsteroids2(startAsteroids2);
        addAliens(startAlien);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 580);

        Explosion.initializeImages();
        ProtonWave.initializeImages();

        prepare();
    }
     /**
     * background stars.
     */
    private void createStars(int number)
    {
        GreenfootImage background = getBackground();
        for(int i=0;i<number;i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int color = 120 - Greenfoot.getRandomNumber(100);
            background.setColor(new Color(color, color, color));
            background.fillOval(x,y,2,2);
        }
    }
    /**
     * This method is called in the constructor to spawn asteroids.
     */
    private void addAsteroids2(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid2(), x, y);
        }
    }
    private void addAliens(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Alien(), x, y);
        }
    }
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        addObject(new ScoreBoard(scoreCounter.getValue()), 300, 300);
    }
    public void gameOverWithMessage() 
    {
        addObject(new ScoreBoard("You Win!",scoreCounter.getValue()+42), 300, 300);
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Asteroid2 asteroid = new Asteroid2();
        addObject(asteroid, 417, 242);
        Asteroid2 asteroid2 = new Asteroid2();
        addObject(asteroid2, 368, 283);
        Asteroid2 asteroid3 = new Asteroid2();
        addObject(asteroid3, 341, 383);
        Asteroid2 asteroid4 = new Asteroid2();
        addObject(asteroid4, 120, 317);
        Asteroid2 asteroid5 = new Asteroid2();
        addObject(asteroid5, 458, 134);
        Asteroid2 asteroid6 = new Asteroid2();
        addObject(asteroid6, 481, 332);
        Asteroid2 asteroid7 = new Asteroid2();
        addObject(asteroid7, 57, 185);
        asteroid.setLocation(413, 342);
        removeObject(asteroid6);
        removeObject(asteroid);
        removeObject(asteroid3);
        removeObject(asteroid2);
        removeObject(asteroid5);
        removeObject(asteroid4);
        removeObject(asteroid7);
        
        Alien alien = new Alien();
        addObject(alien, 200, 200);
        Alien alien1 = new Alien();
        addObject(alien, 220, 220);
        Alien alien2 = new Alien();
        addObject(alien, 250, 245);
        Alien alien3 = new Alien();
        addObject(alien, 300, 290);
        Alien alien4 = new Alien();
        addObject(alien, 100, 400);
        
        
    }
    public void countScore()
    {
         
        scoreCounter.add(1);
    }
}
