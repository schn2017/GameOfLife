import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {
    
    private CellBoard cellBoard;
    private ClickListener clickListener;

    public DrawingBoard(CellBoard cellBoard) {
        this.cellBoard = cellBoard;
        super.setBackground(Color.WHITE);
    }
    
    public ClickListener getClickListener(){
        return this.clickListener;
    }
    
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        cellBoard.draw(graphics);
    }
}
