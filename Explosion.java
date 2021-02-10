import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int delayTime;
    public void act() 
    {
        
    }
    public void delay()
    {
        delayTime++;
        if(delayTime>12)
        {
            getWorld().removeObject(this);
        }
    }
}
