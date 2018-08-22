import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame implements ActionListener {

       private JLabel picture1;
       private JLabel picture2;
       private JComboBox colourComboBox;
       private JComboBox pictureComboBox;
       private JPanel leftPanel;
       private JPanel rightPanel;
       private JTextField guessTextField;
       
       private JLabel guess11;
       private JLabel guess12;
       private JLabel guess13;
       
       private JLabel guess21;
       private JLabel guess22;
       private JLabel guess23;
       
       private JLabel guess31;
       private JLabel guess32;
       private JLabel guess33;
       private int randomNumber;
        
       public GuessingGame(){
              
              setSize(600, 400);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setTitle("Guessing Game");
              
              leftPanel = new JPanel();
              rightPanel = new JPanel();
              
              randomNumber = (int)(Math.random()*10);
              rightPanel.setLayout(new GridLayout(9, 3));
              setLayout(new FlowLayout());
              // First row 
              JLabel guessLabel = new JLabel("Guesses:");
              rightPanel.add(guessLabel);
              
              JLabel guessLabel1 = new JLabel(" ");
              rightPanel.add(guessLabel1);
              
              JLabel guessLabel2 = new JLabel(" ");
              rightPanel.add(guessLabel2);
              
              // 2 row
              guess11 = new JLabel(" ");
              rightPanel.add(guess11);
              
              guess12 = new JLabel(" ");
              rightPanel.add(guess12);
              
              guess13 = new JLabel(" ");
              rightPanel.add(guess13);
              
              // 3 row 
              guess21 = new JLabel(" ");
              rightPanel.add(guess21);
              
              guess22 = new JLabel(" ");
              rightPanel.add(guess22);
              
              guess23 = new JLabel(" ");
              rightPanel.add(guess23);
              
              // 4 row
              guess31 = new JLabel(" ");
              rightPanel.add(guess31);
              
              guess32 = new JLabel(" ");
              rightPanel.add(guess32);
              
              guess33 = new JLabel(" ");
              rightPanel.add(guess33);
              
              // 5 row 
              JLabel empty = new JLabel(" ");
              rightPanel.add(empty); 
              
              guessTextField = new JTextField(10);
              rightPanel.add(guessTextField);
              
              JButton guessButton = new JButton("Guess");
              guessButton.addActionListener(this);
              rightPanel.add(guessButton);
              
              
              // 6 row 
              JLabel interfaceLabel = new JLabel("Interface:");
              rightPanel.add(interfaceLabel);
              
              JLabel emptyLabel1 = new JLabel(" ");
              rightPanel.add(emptyLabel1);
              
              JLabel emptyLabel2 = new JLabel(" ");
              rightPanel.add(emptyLabel2);
              
              // 7 row
              JLabel pictureLabel = new JLabel("Picture:");
              rightPanel.add(pictureLabel);
              
              pictureComboBox = new JComboBox();
              pictureComboBox.addItem("mickey");
              pictureComboBox.addItem("pluto");
              pictureComboBox.addActionListener(this);
              rightPanel.add(pictureComboBox);
              
              JLabel emptyLabel4 = new JLabel(" ");
              rightPanel.add(emptyLabel4);
              
              // 8 row 
              JLabel colourLabel = new JLabel("Colour:");
              rightPanel.add(colourLabel);
              
              colourComboBox  = new JComboBox();
              colourComboBox.addItem("red");
              colourComboBox.addItem("blue");
              colourComboBox.addActionListener(this);
              rightPanel.add(colourComboBox);
              
              JButton changeButton = new JButton("Change");
              changeButton.addActionListener(this);
              rightPanel.add(changeButton);
              
              // 9 row 
              JButton closeButton = new JButton("Close");
              closeButton.addActionListener(this);
              rightPanel.add(closeButton);
              
              JButton newgameButton = new JButton("New Game");
              newgameButton.addActionListener(this);
              rightPanel.add(newgameButton);
              
              JLabel emptyLabel3 = new JLabel(" ");
              rightPanel.add(emptyLabel3);
              
              // Image
              ImageIcon image1 = new ImageIcon("mickey.gif");
              picture1 = new JLabel(image1);
              picture1.setVisible(true);
              leftPanel.add(picture1);
              
              ImageIcon image2 = new ImageIcon("pluto.gif");
              picture2 = new JLabel(image2);
              picture2.setVisible(false);
              leftPanel.add(picture2);
              
              add(leftPanel);
              add(rightPanel);
               
       }
       int counter = 1;
       public void actionPerformed(ActionEvent e){
              String event = e.getActionCommand();
              
              
              
              if (event.equals("Change")){
              
                 String colourCombo = colourComboBox.getSelectedItem().toString();
                 String pictureCombo = pictureComboBox.getSelectedItem().toString(); 
                 
                 if (colourCombo.equals("red") && pictureCombo.equals("mickey")){
                    getContentPane().setBackground(Color.RED);
                    leftPanel.setBackground(Color.RED);
                    rightPanel.setBackground(Color.RED);
                    picture2.setVisible(false);
                    picture1.setVisible(true);
                 }
              
                 else if (colourCombo.equals("blue") && pictureCombo.equals("mickey")){
                    getContentPane().setBackground(Color.BLUE);
                    leftPanel.setBackground(Color.BLUE);
                    rightPanel.setBackground(Color.BLUE);
                    picture2.setVisible(false);
                    picture1.setVisible(true);
                 }
              
                 else if (colourCombo.equals("red") && pictureCombo.equals("pluto")){
                    getContentPane().setBackground(Color.RED);
                    leftPanel.setBackground(Color.RED);
                    rightPanel.setBackground(Color.RED);
                    picture2.setVisible(true);
                    picture1.setVisible(false);
                 }
              
                 else if (colourCombo.equals("blue") && pictureCombo.equals("pluto")){
                    getContentPane().setBackground(Color.BLUE);
                    leftPanel.setBackground(Color.BLUE);
                    rightPanel.setBackground(Color.BLUE);
                    picture2.setVisible(true);
                    picture1.setVisible(false);          
                 }
                 
              }
              else if (event.equals("Close")){
                    System.exit(0);
              }
              
              else if (event.equals("Guess")){
                   String input = guessTextField.getText();
                   guessTextField.setText("");
                   int guessNum = Integer.parseInt(input); 
                   
                   if (counter == 1){
           
                      guess11.setText("Guess 1:");
                      guess12.setText(input);
                      counter++;
                      if ( guessNum == randomNumber ){
                         guess13.setText("Correct !");
                         
                      }
                   
                      else if (guessNum < randomNumber){
                         guess13.setText("Too small !");
                      }
                   
                      else if (guessNum > randomNumber){
                         guess13.setText("Too big !");
                      }
                   }
                   
                   else if (counter == 2){
                   
                      guess21.setText("Guess 2:");
                      guess22.setText(input);
                      counter++;
                      if ( guessNum == randomNumber ){
                         guess23.setText("Correct !");
                         
                      }
                   
                      else if (guessNum < randomNumber){
                         guess23.setText("Too small !");
                      }
                   
                      else if (guessNum > randomNumber){
                         guess23.setText("Too big !");
                      }
                   }
                   
                   else if (counter == 3){
                   
                      guess31.setText("Guess 3:");
                      guess32.setText(input);
                      if ( guessNum == randomNumber ){
                         guess33.setText("Correct !");
                         
                      }
                   
                      else if (guessNum < randomNumber){
                         guess33.setText("Too small !");
                      }
                   
                      else if (guessNum > randomNumber){
                         guess33.setText("Too big !");
                      }
                   }
              }
              
              else if (event.equals("New Game")){
                    counter = 1;
                    randomNumber = (int)(Math.random()*10);
                    guess11.setText(" ");
                    guess12.setText(" ");
                    guess13.setText(" ");
                    
                    guess21.setText(" ");
                    guess22.setText(" ");
                    guess23.setText(" ");
              
                    guess31.setText(" ");
                    guess32.setText(" ");
                    guess33.setText(" ");
                    
              }
              

        
       
       }
       
       
       
       public static void main(String [] args){
              GuessingGame gui = new GuessingGame();
              gui.setVisible(true);
       }
 }