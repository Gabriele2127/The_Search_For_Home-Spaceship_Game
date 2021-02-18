import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Graphics;

/**
 * Counter that displays a text and number.
 */
public class Counter extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    public Counter()
    {
        this("");
    }

    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
        
        /**
         * If statement that decides when score = 42 it will take player from
         * Level1 to Level2
         */   
        World myLevel1 = getWorld();
        if (value == 42)
        { 
           Greenfoot.delay(100);
            
           Greenfoot.setWorld(new Level2());
        }
    }
  
    public void add(int score)
    {
        target += score;
    }

    public int getValue()
    {
        return value;
    }

    /**
     * Make the image of counter
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}
