
import java.awt.Graphics;
import java.awt.*;
import java.util.ArrayList;

public class Cell {

    private int positionX;
    private int positionY;
    private ArrayList<Cell> cells;
    private boolean isAlive;
    private boolean survived;

    public Cell(int positionX, int positionY, ArrayList<Cell> cells) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.cells = cells;
        this.isAlive = false;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setIsAlive(boolean status) {
        this.isAlive = status;
    }

    public boolean getSurvived() {
        return this.survived;
    }

    public void setSurvived(boolean status) {
        this.survived = status;
    }

    public void checkNeighbors() {
        //North  South    East   West      NE      NW      SE         SW
        int[][] directions = {{0, -10}, {0, 10}, {10, 0}, {-10, 0}, {10, -10}, {-10, -10}, {10, 10}, {-10, 10}};
        int neighborAliveCount = 0;
        for (int i = 0; i < 8; i++) {
            for (Cell cell : this.cells) {
                int xSum = 0;
                int ySum = 0;
                int x = this.positionX;
                int y = this.positionY;

                if (x + directions[i][0] < 20) {
                    xSum = 510;
                } else if (x + directions[i][0] > 510) {
                    xSum = 20;
                } else {
                    xSum = x + directions[i][0];
                }

                if (y + directions[i][1] < 20) {
                    ySum = 210;
                } else if (y + directions[i][1] > 210) {
                    ySum = 20;
                } else {
                    ySum = y + directions[i][1];
                }
                if ((xSum == cell.getPositionX()) && (ySum == cell.getPositionY()) && cell.getIsAlive() == true) {
                    neighborAliveCount++;
                    break;
                }
            }
        }

        //        for (int i = 0; i < 8; i++) {
        //            for (Cell cell : cells) {
        //                if ((this.positionX + directions[i][0]) == cell.getPositionX()
        //                        && ((this.positionY + directions[i][1]) == cell.getPositionY())
        //                        && cell.getIsAlive() == true) {
        //
        //                    neighborAliveCount++;
        //                }
        //            }
        //        } 
        //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
        //Any live cell with more than three live neighbours dies, as if by overpopulation.
        if ((neighborAliveCount < 2 || neighborAliveCount > 3) && this.isAlive == true) {
            this.survived = false;
        } //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        else if (this.isAlive == false && neighborAliveCount == 3) {
            this.survived = true;
        }//Any live cell with more than three live neighbours dies, as if by overpopulation.
        else if (this.isAlive == true && (neighborAliveCount == 2 || neighborAliveCount == 3)) {
            this.survived = true;
        }
    }

    @Override
    public String toString() {
        return "Cell at " + this.positionX + (", ") + this.positionY + ". Alive = " + this.isAlive + ". Survived: " + this.survived;
    }

    public void update() {
        checkNeighbors();
    }

    public void updateLife() {
        this.isAlive = this.survived;
    }

    public void draw(Graphics graphics) {
        if (this.isAlive == true) {
            graphics.setColor(Color.black);
            graphics.fillRect(this.positionX, this.positionY, 10, 10);
        } else {
            graphics.setColor(Color.gray);
            graphics.drawRect(this.positionX, this.positionY, 10, 10);
        }
    }
}
