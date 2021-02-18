import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * A proton wave that expands and destroys things in its path.
 */
public class ProtonWave extends Actor
{
    /** The damage this wave will deal */
    private static final int DAMAGE = 30;
    
    /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 30;
    
    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    int imageCount = 0;
    /**
     * Create a new proton wave.
     */
    public ProtonWave() 
    {
        initializeImages();
        Greenfoot.playSound("proton.wav");
    }
    
    /** 
     * Create the images for expanding the wave.
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            int i = 0;
            while (i < NUMBER_IMAGES) 
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
                i++;
            }
        }
    }
    
    /**
     * Act for the proton wave is: grow and check whether we hit anything.
     */
    public void act()
    { 
       checkCollision();
        grow();
    } 
    private void grow()
    {
      
       if (imageCount < NUMBER_IMAGES)
        {
            setImage (images [imageCount]);
            imageCount++;
        }
        else
        {
           imageCount = 0;
           getWorld().removeObject(this);
        }
    }
    /**
     * Method to detect anything that touches ProtonWave and destroy it.
     */
    private void checkCollision()
    {    
        int range = getImage().getWidth()/2;
        List<Asteroid2> asteroids2 = getObjectsInRange(range, Asteroid2.class);
        for(Asteroid2 asteroid2 : asteroids2)
        {
            asteroid2.hit2(DAMAGE);
        }
        
        List<Alien> aliens = getObjectsInRange(range, Alien.class);
        for(Alien alien : aliens)
        {
            alien.hit3(DAMAGE);
        }
    }
}

