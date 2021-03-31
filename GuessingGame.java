import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

//declare guessing game
public class GuessingGame

//implement action listener
implements ActionListener {
  JTextField guessField;
  JButton guessButton, 
  playAgainButton;
  JLabel jlabUserGuess, 
  jlabHighLow, 
  jlabPreviousGuess;

  Random r = new Random();
  int randomNum;

//Guessing game constructor
  GuessingGame() {

    randomNum = r.nextInt(101);

    //Making the frame
    JFrame frame = new JFrame("Guessing Game"); 
    frame.setLayout(new FlowLayout()); 
    frame.setSize(240, 120); 
    guessField = new JTextField(10); 
    guessField.setActionCommand("myTF");
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    guessField.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    jlabUserGuess = new JLabel("Enter your guess: ");
    jlabHighLow = new JLabel("");
    jlabPreviousGuess = new JLabel("");

    frame.add(jlabUserGuess);
    frame.add(guessField);
    frame.add(guessButton);
    frame.add(jlabHighLow);
    frame.add(jlabPreviousGuess);
    frame.add(playAgainButton);
  // set the frame to visible 
    frame.setVisible(true);
  }
  

  //if statement for true and false
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(guessField.getText());

      //if random number is high or low, set text properly
      //else "You got it!"
      if (guess < randomNum) {
        jlabHighLow.setText("Too low!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else if (guess > randomNum) {
        jlabHighLow.setText("Too high!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else {
        jlabHighLow.setText("You got it!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
    }

    else if(ae.getActionCommand().equals("Play Again")) {
      //Reset everything 
      jlabPreviousGuess.setText("");
      guessField.setText("");
      jlabHighLow.setText("");
      randomNum = r.nextInt(101);
    }
    else {
      jlabHighLow.setText("You can Enter. Please press the Guess Button.");
    }
  }
}
4