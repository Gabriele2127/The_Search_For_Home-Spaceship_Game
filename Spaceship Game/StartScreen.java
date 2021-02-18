import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import java.io.*;
import java.awt.*;
/**
 * Start Screen of game.
 */
public class StartScreen extends World
{
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(600, 600, 1);
        GreenfootImage background = new GreenfootImage("start1.png");
        background.setColor(Color.BLACK);
        background.fill();
        
        
        createStars(706);
        
        
    }
    
    /**
     * Calling the method checkKey. 
     */
    public void act()
    {
        checkKey();
    }
   
    /**
     * Creating the space background by adding stars. 
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
     * Method which takes user to level 1. 
     */
    private void checkKey()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.delay(25);
            
            Greenfoot.setWorld(new Level1());
        }
        
        if (Greenfoot.isKeyDown("F1"))
        {
            try {Desktop.getDesktop().open(new File("UserGuide.pdf"));}
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
