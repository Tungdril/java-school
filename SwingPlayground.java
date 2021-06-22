import javax.swing.*;

public class SwingPlayground extends JFrame {
   
    public static void main(String[] args) {
    JFrame myApp = new SwingPlayground();
    } 

    public SwingPlayground(){ 
    this.setTitle("Playground");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel label = new JLabel(" Hello World," + " this is a small Swing Demo ");

    this.add(label);
    this.pack();
    this.setVisible(true);
    }

}
