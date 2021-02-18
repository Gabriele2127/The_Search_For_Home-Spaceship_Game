import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


/**
 * The Search for Home
 */
public class Level1 extends World
{
   public Counter scoreCounter;
   private int startAsteroids = 6;
   public int numberOfObjects;
    
   /**
   * Constructor
   */
   public Level1() 
    {
        super(600, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars(706);

        StarFighter1 rocket = new StarFighter1();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);

        addAsteroids(startAsteroids);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 580);

        Explosion.initializeImages();
        ProtonWave.initializeImages();

        prepare();
    }
    /**
    * background stars
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
     * This method gets called in the constructor to spawn asteroids.
     */
   private void addAsteroids(int count) 
   {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
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
        addObject(new ScoreBoard("You Win!",scoreCounter.getValue()), 300, 300);
    }
   /**
     * Prepares all obstacles.
     * This method gets called in order to prepare all obstacles.
     */
   private void prepare()
   {
        Asteroid asteroid = new Asteroid();
        addObject(asteroid, 417, 242);
        Asteroid asteroid2 = new Asteroid();
        addObject(asteroid2, 368, 283);
        Asteroid asteroid3 = new Asteroid();
        addObject(asteroid3, 341, 383);
        Asteroid asteroid4 = new Asteroid();
        addObject(asteroid4, 120, 317);
        Asteroid asteroid5 = new Asteroid();
        addObject(asteroid5, 458, 134);
        Asteroid asteroid6 = new Asteroid();
        addObject(asteroid6, 481, 332);
        Asteroid asteroid7 = new Asteroid();
        addObject(asteroid7, 57, 185);
        asteroid.setLocation(413, 342);
        removeObject(asteroid6);
        removeObject(asteroid);
        removeObject(asteroid3);
        removeObject(asteroid2);
        removeObject(asteroid5);
        removeObject(asteroid4);
        removeObject(asteroid7);      
   }
   
   /**
     * Score counter method used to keep score and add +1 for every enemy
     * destroyed.
     */
    public void countScore()
   {
        scoreCounter.add(1);
   }
}