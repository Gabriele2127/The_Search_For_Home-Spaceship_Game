
import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * Player's character. Cna move and shoot bullets.
 */
public class StarFighter2 extends SmoothMover
{
    private static final int gunReloadTime = 7;         // The minimum delay between firing the gun.
    private static final int protonReloadTime = 450;
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private int protonReloadDelay;
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initilise this rocket.
     */
    public StarFighter2()
    {
        reloadDelayCount = 40;
        protonReloadDelay = 1000;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        move();
        checkForAsteroids2();
        checkCollision();
        reloadDelayCount++;
        protonReloadDelay++;
        
        
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-7);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            turn(7);
        }
        ignite(Greenfoot.isKeyDown("up"));
        if (Greenfoot.isKeyDown("up"))
        {
            addForce(new Vector(getRotation(), .2));
        }
        if (Greenfoot.isKeyDown ("Shift"))
        {
            startProtonWave();
        }
        if (Greenfoot.isKeyDown("A"))
        {
            turn(-7);
        }
        if (Greenfoot.isKeyDown("D"))
        {
            turn(7);
        }
        ignite(Greenfoot.isKeyDown("W"));
        if (Greenfoot.isKeyDown("W"))
        {
            addForce(new Vector(getRotation(), .2));
        }
    }
   
    
    /**
    * Method taht stars up the ProtonWave.
    */
    private void startProtonWave()
    {
        if(protonReloadDelay >= protonReloadTime)
        {   
            World world = getWorld();
            world.addObject(new ProtonWave(), getX(), getY());
            protonReloadDelay = 0;
        }
    }
    
    
    /**
    * Method checks if rocket hits anything and explodes if it does.
    */
    public void checkCollision()
    {
        Asteroid2 asteroid2 = (Asteroid2) getOneIntersectingObject(Asteroid2.class);
        Alien alien = (Alien) getOneIntersectingObject(Alien.class);
        if (asteroid2 != null){
            World world = getWorld();
            world.addObject(new Explosion(), getX(), getY());
            Level2 space = (Level2) getWorld();
            space.gameOver();
            getWorld().removeObject(this);
        }
        else if (alien !=null) {
            World world = getWorld();
            world.addObject(new Explosion(), getX(), getY());
            Level2 space = (Level2) getWorld();
            space.gameOver();
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet2 bullet2 = new Bullet2 (getMovement().copy(), getRotation());
            getWorld().addObject (bullet2, getX(), getY());
            bullet2.move ();
            reloadDelayCount = 0;
        }
    }
    
    /**
    * Makes rocket thrust turn on.
    */
    private void ignite(boolean boosterOn)
    {
       if(boosterOn)
       {
           setImage(rocketWithThrust);
       }
       else
       {
           setImage(rocket);
       }
    }
    /**
     * Brings up game over message if rocket hits asteroid.
    */
    private void checkForAsteroids2()
    {
       Level2 space = (Level2) getWorld();
       if(space.numberOfObjects() < 3)
       {
           Greenfoot.playSound("fanfare.wav");
           space.gameOverWithMessage();
       }
    }
}