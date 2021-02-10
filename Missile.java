import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Missile extends Actor
{
    protected int gravity; 
    public void act() 
    {
        // Add your action code here.
    }
    
    public Missile(int imageSize)
    {
        getImage().scale(getImage().getWidth()/imageSize, getImage().getHeight()/imageSize);
    }
    
    abstract public void drop();
    
    protected void defineGravity()
    {
        gravity++;
        setLocation(getX(), getY()+gravity);
    }
    
}
