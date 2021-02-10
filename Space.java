import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    public static Rocket rocket;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        rocket = new Rocket(2);
        addObject(rocket, getWidth()/2, getHeight()/2);
        addObject(new Asteroids(),203,127);
        addObject(new Asteroids(3,3,1),510,88);
        addObject(new Asteroids(2,2,0), 556, 482);
    }
    
    public void act()
    {
        showText("Score :"+Space.rocket.score,100,75);
        youWin();
        showText("Lives :"+Space.rocket.lives,200,75);
        gameOver();
    }
    
    public void youWin()
    {
        if(Space.rocket.score == 5)
        {
            addObject(new YouWin(),getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    public void gameOver()
    {
        if(Space.rocket.lives == 0)
        {
            addObject(new GameOver(), getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }
}
