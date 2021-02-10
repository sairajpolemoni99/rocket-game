import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (Sairaj) 
 * @version (rocket v1.0 or 24th 12 2020)
 */
public class Rocket extends Actor
{
    /*NSV which controls speed of my rocket*/
    private int speed;
    private int reloadTime;
    public int score;
    public int lives = 5;
    public Rocket(int speed)
    {
        this.speed = speed;
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(this.speed);
        moveAround();
        wrapAround();
        rotate();
        reloadTime++;
        if(reloadTime>=20)
        {
            fire();
        }
        hitByAsteroid();
    }
    
    public void moveAround()
    {
        setImage("rocketWithoutBooster.png");
        this.speed = 2;
        if(Greenfoot.isKeyDown("right"))
        {
            setImage("rocketWithBooster.png");
            this.speed = 4;
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setImage("rocketWithBooster.png");
            this.speed = 4;
            setRotation(90);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setImage("rocketWithBooster.png");
            this.speed = 4;
            setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setImage("rocketWithBooster.png");
            this.speed = 4;
            setRotation(270);
        }
    }
    
    public void wrapAround()
    {
        int rx = getX();
        int ry = getY();
        World w = getWorld();
        int worldWidth = w.getWidth()-1;
        int worldHeight = w.getHeight()-1;
        
        if(rx == 0)
        {
            setLocation(worldWidth, ry);
        }
        if(rx == worldWidth)
        {
            setLocation(0, ry);
        }
        if(ry == 0)
        {
            setLocation(rx,worldHeight);
        }
        if(ry == worldHeight)
        {
            setLocation(rx,0);
        }
    }
    
    public void rotate()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            turn(-5);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            turn(5);
        }
    }
    public void fire()
    {
        if(Greenfoot.isKeyDown("f"))
        {
            addMissile(new Missile1());
        }
        if(Greenfoot.isKeyDown("d"))
        {
            addMissile(new Missile2());
        }
    }
    public void addMissile(Missile m)
    {
        getWorld().addObject(m,getX(),getY());
        reloadTime = 0;
        if(m instanceof Missile1)
        {
            m.setRotation(getRotation());
        }
    }
    public void hitByAsteroid()
    {
        if(isTouching(Asteroids.class))
        {
            lives--;
            getWorld().addObject(new BigExplosion(), getX(), getY());
            setLocation(60, 653);
            
        }
    }
}
     