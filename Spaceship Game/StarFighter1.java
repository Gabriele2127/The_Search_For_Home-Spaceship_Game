import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * Player's character. Cna move and shoot bullets.
 */
public class StarFighter1 extends SmoothMover
{
    private static final int gunReloadTime = 7;//minimum delay between firing bullets.
    
    private int reloadDelayCount;   //How long ago we fired the gun the last time.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initilise this rocket.
     */
    public StarFighter1()
    {
        reloadDelayCount = 40;
        
    }

    /**
     * Calls all the methods for rocket.
     */
    public void act()
    {
        checkKeys();
        move();
        checkForAsteroids();
        checkCollision();
        reloadDelayCount++;
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
    * Method checks if rocket hits anything and explodes if it does.
    */
    private void checkCollision()
    {
         Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (asteroid != null){
            World world = getWorld();
            world.addObject(new Explosion(), getX(), getY());
            Level1 space = (Level1) getWorld();
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
            Bullet bullet = new Bullet (getMovement().copy(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
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
    private void checkForAsteroids()
    {
       Level1 space = (Level1) getWorld();
       if(space.numberOfObjects() < 3)
       {
           Greenfoot.playSound("fanfare.wav");
           space.gameOverWithMessage();
       }
    }
}
