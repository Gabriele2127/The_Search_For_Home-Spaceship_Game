import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alien enemy ship that only appears in Level2.
 */
public class Alien extends SmoothMover
{
     private int size;
     

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;

    
    public Alien()
    {
        stability = 100;
        GreenfootImage image = getImage();
        image.scale(70,45);
    }
    
    public Alien(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(500), 2));
        setSize(size);
    }
    
    public Alien(int size, Vector speed)
    {
        super(speed);
        setSize(size);
    }
    
    /**
    * Alien ship will come toward the player's character.
    */
    public void act()
    {         
        move(1);
        if (getWorld().getObjects(StarFighter2.class).isEmpty()) return; // skips following if the tank is not in world
        Actor StarFighter2 = (Actor)getWorld().getObjects(StarFighter2.class).get(0); // gets reference to tank
        turnTowards(StarFighter2.getX(), StarFighter2.getY()); // turn toward tank
    }

    /**
     * Set the size of this Alien ship. 
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * Return the current stability of alien ship. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Hit this ship dealing the given amount of damage.
     */
    public void hit3(int damage) {
        stability = stability - damage;
        if(stability <= 0) 
            breakUp3 ();         
    }
    /**
    * Method that destroyes alien ship when player destroys it.
     */
     private void breakUp3() 
    {
        Greenfoot.playSound("Explosion.wav");
        Level2 space = (Level2) getWorld();
        
        space.countScore();
        if(size <= 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
