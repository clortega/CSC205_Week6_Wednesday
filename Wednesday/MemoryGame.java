import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    JButton initialSelection;


    public MemoryGame() { //Ctor
        super("Memory Game");
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
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
        } else {
            //let user know there wasn't a match
            JOptionPane.showMessageDialog(this, "the colors don't match");
            //reset the buttons
            button.setEnabled(true);
            button.setBackground(null);
            initialSelection.setEnabled(true);
            initialSelection.setBackground(null);

            }
            // reset the first selection to null
            initialSelection = null;
        }

    }

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
