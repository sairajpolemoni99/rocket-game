import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroids extends Actor
{
    private int giveWidth;
    private int giveHeight;
    public Asteroids()
    {
    }
    
    public Asteroids(int giveWidth,int giveHeight,int choice)
    {
        this.giveWidth = giveWidth;
        this.giveHeight = giveHeight;
        if(choice == 1)
        {
            changeIncSize();
        }
        if(choice == 0)
        {
            changeDecSize();
        }
    }

    public void hitByMissile()
    {
     if(isTouching(Missile1.class))
     {
        removeTouching(Missile1.class);
        Space.rocket.score++;
        getWorld().addObject(new SmallExplosion(), getX(), getY());
        if(getImage().getWidth()<=58)
        {
            getWorld().removeObject(this);
        }
        else 
        {
            divideAsteriods(new Asteroids());
            divideAsteriods(new Asteroids());
            getWorld().removeObject(this);
        }
    }
}

    public void divideAsteriods(Asteroids a)
    {
        getWorld().addObject(a,getX(),getY());
        int rn = Greenfoot.getRandomNumber(360);
        a.setRotation(rn);
    }
    public void changeIncSize()
    {
        getImage().scale(getImage().getWidth()*this.giveWidth,getImage().getHeight()*this.giveHeight);
    }
    
    public void changeDecSize()
    {
        getImage().scale(getImage().getWidth()/this.giveWidth,getImage().getHeight()/this.giveHeight);
    }
    public void bounceBack()
    {
        if(isAtEdge())
        {
            int randomDegree = Greenfoot.getRandomNumber(10);
            turn(randomDegree);
        }
    }
    
    public void act() 
    {
        move(1);
        bounceBack();
        hitByMissile();
    }    
}
