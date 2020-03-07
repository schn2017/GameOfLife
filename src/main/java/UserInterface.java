
import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Conway's Game of Life");
        frame.setPreferredSize(new Dimension(540, 300));
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        CellBoard cellBoard = new CellBoard();
        BorderLayout layout = new BorderLayout();
        DrawingBoard drawingBoard = new DrawingBoard(cellBoard);
        
        ClickListener clickListener = new ClickListener(cellBoard,drawingBoard);
        drawingBoard.addMouseListener(clickListener);
        drawingBoard.setClickListener(clickListener);
        container.setLayout(layout);
        container.add(drawingBoard, BorderLayout.CENTER);
        container.add(buttonPanel(cellBoard, drawingBoard), BorderLayout.PAGE_END);
    }

    private JPanel buttonPanel(CellBoard cellBoard, DrawingBoard drawingBoard) {
        JPanel panel = new JPanel();
        
        // Setup buttons
        JButton startButton = new JButton();
        startButton.setText("Start");
        JButton pauseButton = new JButton();
        pauseButton.setText("Pause");
        JButton singleButton = new JButton();
        singleButton.setText("Single Step");
        JButton clearButton = new JButton();
        clearButton.setText("Clear");

        // Create action listeners
        StartButtonListener startButtonListener = new StartButtonListener(cellBoard, drawingBoard);
        ButtonListener pauseButtonListener = new ButtonListener(cellBoard, drawingBoard, pauseButton, startButtonListener, drawingBoard.getClickListener());
        ButtonListener clearButtonListener = new ButtonListener(cellBoard, drawingBoard, clearButton, startButtonListener, drawingBoard.getClickListener());
        ButtonListener singleButtonListener = new ButtonListener(cellBoard, drawingBoard, singleButton, startButtonListener, drawingBoard.getClickListener());
        
        // Link action listeners
        startButtonListener.setPauseButton(pauseButton);
        startButtonListener.setClearButton(clearButton);
        startButtonListener.setSingleButton(singleButton);
        startButtonListener.setClickListener(drawingBoard.getClickListener());
        pauseButtonListener.setSingleClearButtons(singleButton, clearButton);
        
        // Add action listeners to buttons
        startButton.addActionListener(startButtonListener);
        pauseButton.addActionListener(pauseButtonListener);
        singleButton.addActionListener(singleButtonListener);
        clearButton.addActionListener(clearButtonListener);
        
        //Disable buttons
        pauseButton.setEnabled(false);
        
        // Add buttons to panel
        panel.add(startButton);
        panel.add(pauseButton);
        panel.add(singleButton);
        panel.add(clearButton);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
