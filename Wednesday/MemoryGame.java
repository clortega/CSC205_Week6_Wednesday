import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
//NOTE: THIS CODE DOES NOT WORK ON A MAC
import java.util.Collections;

public class MemoryGame extends JFrame{
    final int COLUMNS = 4;
    final int ROWS = 3;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> colorsList = new ArrayList<Color>();

    int match = 0;
    int score = 0;
    JMenu menu;
    JButton initialSelection;

    // JMenuBar menuBar; //GREENED OUT MY WORK..
    // JMenu menu;
    // JMenuItem menuItemResetGame;



    public MemoryGame() { //Ctor
        super("Memory Game");
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Score: " + score);
        JMenuItem jMenuItem = new JMenuItem("Restart Game");
        menu.add(jMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // menuBar = new JMenuBar(); ///GREENED OUT MY WORK---IT MOSTLY WORKS
        // menu = new JMenu("Score: " + score);

        // menuItemResetGame = new JMenuItem("Reset Game");
        // menuItemResetGame.addActionListener(e -> ResetGame());
        // // menu.add(menuItemResetGame);
        // menuBar.add(menu);
        // setJMenuBar(menuBar);
        

        for(int i = 0; i < ROWS * COLUMNS; i++) 
        {
            JButton button = new JButton();
            button.addActionListener(this::ButtonClicked);
            //the following is another notation:
            // button.addActionListener(e -> ButtonClicked(e));
            buttonList.add(button);
            add(button);
        }
        InitColorsList();
        setLayout(gridLayout);
        setSize(900, 900);
        setLocation(1200, 0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    private void ButtonClicked(ActionEvent actionEvent) {
        JButton button = (JButton)actionEvent.getSource(); 
        int index = buttonList.indexOf(button);
        Color color = colorsList.get(index);
        // button.setText("" + index);
        button.setBackground(color);

        if(initialSelection == null) {
            //then we know this is the first button clicked
            initialSelection = button;
            button.setEnabled(false);
        } else {
        if(initialSelection.getBackground().equals(button.getBackground())) {
            //let user know of match
            button.setEnabled(false);
            match++;
            score += 10;
            JOptionPane.showMessageDialog(this, "The Score is: " + score);
        } else {
            //let user know there wasn't a match
            JOptionPane.showMessageDialog(this, "The colors don't match" + "\nThe Score is: " + score);
            //reset the buttons
            button.setEnabled(true);
            button.setBackground(null);
            initialSelection.setEnabled(true);
            initialSelection.setBackground(null);
            // score -= 1;
            int newScore = score -1;
            score = newScore < 0 ? 0: newScore; //The ? is a ... its a condensed form of ifs(see below)
            // if(newScore < 0) {
            //     score = 0;
            // } else {
            //     score = score;
            // }

            }
            // reset the first selection to null
            initialSelection = null;
            menu.setText("Score: " + score);


        }
        // while(buttonList.button.setEnabled != false) {

        // }

    }
    private void RestartGame() {

        for(int i = 0; i < buttonList.size(); i++) {
            JButton button = buttonList.get(i);
            button.setBackground(.....);
        }
    }
    // private void ResetGame() {
    //     System.exit(0);
    // }

    private void InitColorsList() {
        colorsList.add(Color.CYAN);
        colorsList.add(Color.CYAN);
        colorsList.add(Color.GREEN);
        colorsList.add(Color.GREEN);
        colorsList.add(Color.YELLOW);
        colorsList.add(Color.YELLOW);
        colorsList.add(Color.BLUE);
        colorsList.add(Color.BLUE);
        colorsList.add(Color.RED);
        colorsList.add(Color.RED);
        colorsList.add(Color.MAGENTA);
        colorsList.add(Color.MAGENTA);
        //Below is another means of adding our colors to the boxes

        // Collections.addAll(colorsList, Color.CYAN, Color.CYAN, Color.MAGENTA, Color.MAGENTA, Color.PINK, Color.PINK, Color.BLACK, Color.BLACK,Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW );

        // Collections.shuffle(colorsList);//this shuffles the list. Import Collections needed.
        Collections.shuffle(buttonList);//Another way to shuffle the List



    }
}
