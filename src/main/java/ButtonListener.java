
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ButtonListener implements ActionListener {

    private CellBoard cellBoards;
    private Component component;
    private JButton button;
    private JButton singleButton;
    private JButton clearButton;
    private StartButtonListener startButton;
    private ClickListener clickListener;

    public ButtonListener(CellBoard cellBoard, Component component, JButton button, StartButtonListener start, ClickListener clickListener) {
        this.cellBoards = cellBoard;
        this.component = component;
        this.button = button;
        this.startButton = start;
        this.clickListener = clickListener;
    }

    void setSingleClearButtons(JButton singleButton, JButton clearButton) {
        this.singleButton = singleButton;
        this.clearButton = clearButton;
    }

    public void actionPerformed(ActionEvent ae) {
        String buttonText = this.button.getText();
        this.startButton.stopTime();
        this.clickListener.setCanDraw(true);
        try {
            this.singleButton.setEnabled(true);
            this.clearButton.setEnabled(true);
        } catch (Exception e) {

        }

        switch (buttonText) {
            case "Clear":
                this.cellBoards.clearBoard();
                this.component.repaint();
                break;
            case "Single Step":
                this.cellBoards.update();
                this.component.repaint();
                break;
            case "Pause":
                this.button.setEnabled(false);
                break;
        }
    }
}
