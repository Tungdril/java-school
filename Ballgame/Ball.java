package Ballgame;
public class Ball {

    //attributes
    private int weight = 1, width = 5, speed = 0;
    private int posX, posY;
    private String color = "Red";
    private char direction = 'n';

    //standard constructor
    Ball(){
        this.posX = (int) (Math.random()*100);
        this.posY = (int) (Math.random()*100);

        System.out.println("\nBall has been created with default values.");
    }

    //individual constructor
    Ball(int weight, int width, String color, char direction){
        this.weight = weight;
        this.width = width;
        this.color = color;
        this.direction = direction;   

        this.posX = (int) (Math.random()*100);
        this.posY = (int) (Math.random()*100);

        System.out.println("\nBall has been created with custom values.");
    }

    //methods
    public void output(){
        System.out.println("\nBall position: X: " + this.posX +" | Y: " + this.posY);
        System.out.println("Weight:" + this.weight);
        System.out.println("Width:" + this.width);
        System.out.println("Color:" + this.color);
        System.out.println("Direction:" + this.direction);
        System.out.println("Speed:" + this.speed);
    }

    public int speedUp(int velocity){
        this.speed = this.speed + velocity;

        if(this.speed > 100){
            this.speed = 100;
        }

        return this.speed;
    }

    public int slowDown(int slowness){
        this.speed = this.speed - slowness;

        if(this.speed <= 0){
            this.speed = 0;
        }

        return this.speed;
    }

    public char direction (char setDirection){
    
        if(setDirection != 's' && setDirection != 'e' && setDirection != 'w'){
            this.direction = 'n';
        } else {
            this.direction = setDirection;
        }

        return this.direction;
    }

}
