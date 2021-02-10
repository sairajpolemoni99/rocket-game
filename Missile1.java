import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile1 extends Missile
{
    public Missile1()
    {
        super(2);
    }
    
    public void act() 
    {
        move(4);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        if(gravity<=8)
        {
            drop();
        }
    }
    
    public void drop()
    {
        defineGravity();
    }
}
