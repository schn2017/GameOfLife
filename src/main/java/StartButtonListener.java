
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartButtonListener implements ActionListener {

    private CellBoard cellBoards;
    private Component component;
    private JButton pauseButton;
    private JButton clearButton;
    private JButton singleButton;
    private Timer time;
    private ClickListener clickListener;

    public StartButtonListener(CellBoard cellBoard, Component component) {
        this.cellBoards = cellBoard;
        this.component = component;
        this.time = new Timer(500, this);
    }

    public void stopTime() {
        this.time.stop();
    }

    void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    void setPauseButton(JButton pauseButton) {
        this.pauseButton = pauseButton;
    }

    void setClearButton(JButton clearButton){
        this.clearButton = clearButton;
    }
    
    void setSingleButton(JButton singleButton){
        this.singleButton = singleButton;
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            this.clickListener.setCanDraw(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        this.time.start();
        this.pauseButton.setEnabled(true);
        this.clearButton.setEnabled(false);
        this.singleButton.setEnabled(false);
        this.cellBoards.update();
        this.component.repaint();
    }
}
