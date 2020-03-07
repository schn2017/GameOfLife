
import java.awt.Component;
import java.awt.event.*;

public class ClickListener implements MouseListener {

    private CellBoard cellBoard;
    private Component component;
    private boolean canDraw;

    public ClickListener(CellBoard cellBoard, Component component) {
        this.cellBoard = cellBoard;
        this.component = component;
        this.canDraw = true;
    }
    
    public void setCanDraw(boolean status){
        this.canDraw = status;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.canDraw == true) {
            cellBoard.updateClicked(e.getX(), e.getY());
            component.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
