package world;

import javafx.scene.layout.GridPane;
import cell.Cell;

public interface Board {

    int getWidth();

    int getHeight();

    Cell getCellAt(int x, int y);

    Cell[][] getCells();

    void setCells(Cell[][] cells);

    GridPane getGridPane();

}
