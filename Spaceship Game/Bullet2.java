import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A bullet that can hit asteroids.
 */
public class Bullet2 extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 16;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 40;
    
    public Bullet2()
    {
    }
    
    public Bullet2(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            
            checkAsteroidHit2();
        }
    }
    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkAsteroidHit2()
    {
        Asteroid2 asteroid2 = (Asteroid2) getOneIntersectingObject(Asteroid2.class);
        if (asteroid2 != null){
            getWorld().removeObject(this);
            asteroid2.hit2(damage);
        }
        
        if (getWorld() == null) return;
        
        Alien alien = (Alien) getOneIntersectingObject(Alien.class);
        if (alien !=null)
        {
            getWorld().removeObject(this);
            alien.hit3(damage);
        }
    }
    
    
}
