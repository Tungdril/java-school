package Ballgame;


public class BallMain {

 public static void main(String[] args) {
    Ball defaultBall = new Ball();
    defaultBall.output();

    Ball customBall = new Ball(2, 4, "blue", 's');
    customBall.output();
    
    System.out.println(customBall.speedUp(5));

    System.out.println(customBall.slowDown(2));

    System.out.println(customBall.direction('s'));
 }
 
}
