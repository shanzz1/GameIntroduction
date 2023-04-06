import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameIntroduction extends JFrame {
    private JButton playButton, instructionsButton, quitButton;
    private JPanel homePanel, instructionsPanel, gamePanel;
    private JLabel gameLabel;
    private JButton backButton;
    private JTextField guessTextField;
    private JButton guessButton;
    private int randomNumber;

    public GameIntroduction() {
        // Set up the main window (home panel)
        homePanel = new JPanel(new GridLayout(3, 1));
        playButton = new JButton("Play");
        instructionsButton = new JButton("Instructions");
        quitButton = new JButton("Quit");
        homePanel.add(playButton);
        homePanel.add(instructionsButton);
        homePanel.add(quitButton);
        add(homePanel);

        // Set up the instructions panel
        instructionsPanel = new JPanel(new BorderLayout());
        JTextArea instructionsText = new JTextArea("Welcome to the game!\n\n"
            + "In this game, you will be guessing a number between 1 and 100. "
            + "You can enter your guess in the text box and click the 'Guess' button. "
            + "The game will tell you whether your guess is too high, too low, or correct. "
            + "You can play as many times as you like by clicking the 'Play' button on the home screen.\n\n"
            + "Good luck!");
        instructionsText.setEditable(false);
        instructionsPanel.add(instructionsText, BorderLayout.CENTER);
        JButton backButton2 = new JButton("Back");
        instructionsPanel.add(backButton2, BorderLayout.SOUTH);
        backButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the home panel
                getContentPane().removeAll();
                getContentPane().add(homePanel);
                revalidate();
                repaint();
            }
        });
    

        // Set up the game panel
        gamePanel = new JPanel(new BorderLayout());
        JPanel gameTopPanel = new JPanel(new FlowLayout());
        gameLabel = new JLabel("Guess a number between 1 and 100.");
        gameTopPanel.add(gameLabel);
        gamePanel.add(gameTopPanel, BorderLayout.NORTH);
        JPanel gameCenterPanel = new JPanel(new FlowLayout());
        guessTextField = new JTextField(10);
        guessButton = new JButton("Guess");
        gameCenterPanel.add(guessTextField);
        gameCenterPanel.add(guessButton);
        gamePanel.add(gameCenterPanel, BorderLayout.CENTER);
        backButton = new JButton("Back");
        gamePanel.add(backButton, BorderLayout.SOUTH);

        // Add listeners to the buttons
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set up the game
                gameLabel.setText("Guess a number between 1 and 100.");
                randomNumber = (int)(Math.random() * 100) + 1;
                // Show the game panel
                getContentPane().removeAll();
                getContentPane().add(gamePanel);
                revalidate();
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the instructions panel
                getContentPane().removeAll();
                getContentPane().add(instructionsPanel);
                revalidate();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quit the application
                System.exit(0);
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the home panel
                getContentPane().removeAll();
                getContentPane().add(homePanel);
                revalidate();
                repaint();;

            }
        });
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessTextField.getText());
                    if (guess < randomNumber) {
                        gameLabel.setText("Too low! Guess again.");
                    } else if (guess > randomNumber) {
                        gameLabel.setText("Too high! Guess again.");
                    } else {
                        gameLabel.setText("You got it!");
                    }
                    guessTextField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(gamePanel, "Please enter a valid number.");
                }
            }
        });

        // Set up the main window
        setTitle("Game Introduction");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameIntroduction();
    }
}
