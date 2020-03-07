
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Component;

public class CellBoard {

    private ArrayList<Cell> cells;
    private boolean keepUpdating;

    public CellBoard() {
        this.cells = new ArrayList<>();
        populateBoard();
        this.keepUpdating = false;
    }

    public void setKeepUpdating(boolean status) {
        this.keepUpdating = status;
    }

    public void populateBoard() {
        int cellCount = 0;
        int rowPixelSpacing = 20;
        int columnPixelSpacing = 20;

        int totalCellsAllowed = 1000;
        int cellsPerRow = 50;
        int resetRow = (cellsPerRow * 10) + 20;
        int column = 0;
        while (cellCount < totalCellsAllowed) {
            for (int row = 0; row < cellsPerRow; row++) {
                this.cells.add(new Cell(rowPixelSpacing, columnPixelSpacing, this.cells));
                cellCount++;
                if (rowPixelSpacing + 10 >= resetRow) {
                    rowPixelSpacing = 20;
                    columnPixelSpacing = columnPixelSpacing + 10;
                    column++;
                } else {
                    rowPixelSpacing = rowPixelSpacing + 10;
                }
            }
        }
    }

    public void clearBoard() {
        cells.clear();
        populateBoard();
    }

    public void updateClicked(int x, int y) {
        for (Cell cell : this.cells) {
            if ((x >= cell.getPositionX() && x <= cell.getPositionX() + 10)
                    && ((y >= cell.getPositionY() && y <= cell.getPositionY() + 10))) {
                if (cell.getIsAlive() == true) {
                    cell.setIsAlive(false);
                } else {
                    cell.setIsAlive(true);
                }
                if (cell.getSurvived() == true) {
                    cell.setSurvived(false);
                }
                break;
            }
        }
    }

    public void update() {
        if (this.keepUpdating == false) {

            for (Cell cell : this.cells) {
                cell.update();
            }
            for (Cell cell : this.cells) {
                cell.updateLife();
            }
        } else {
            while (this.keepUpdating == true) {
                for (Cell cell : this.cells) {
                    cell.update();
                }
                for (Cell cell : this.cells) {
                    cell.updateLife();
                }
            }
        }
    }

    public void draw(Graphics graphics) {
        for (Cell cell : this.cells) {
            cell.draw(graphics);
        }
    }
}
