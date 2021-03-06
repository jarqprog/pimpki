package world;

import worldManager.WorldManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import cell.CellPaths;
import cell.BasicCell;
import cell.Cell;
import cell.CellView;
import cell.cellcontent.Content;
import cell.cellcontent.Empty;
import configuration.Configuration;
import food.foodModel.Food;
import food.foodSpawner.FoodSpawner;
import obstacle.obstacleSpawner.ObstacleSpawner;
import pimpek.pimpekModel.Pimpek;
import pimpek.pimpekSpawner.PimpekSpawner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class WorldCreator implements BoardCreator {

    private final WorldManager explorer;
    private final Configuration configuration;
    private final FoodSpawner foodSpawner;
    private final PimpekSpawner pimpekSpawner;
    private final ObstacleSpawner obstacleSpawner;
    private Set<Pimpek> beings;
    private Set<Food> supplies;
    private int height;
    private int width;
    private int obstaclesQuantity;


    public WorldCreator(WorldManager explorer, Configuration configuration,
                        FoodSpawner foodSpawner, PimpekSpawner pimpekSpawner,
                        ObstacleSpawner obstacleSpawner, Set<Pimpek> beings, Set<Food> supplies) {
        this.explorer = explorer;
        this.configuration = configuration;
        this.foodSpawner = foodSpawner;
        this.pimpekSpawner = pimpekSpawner;
        this.obstacleSpawner = obstacleSpawner;
        this.beings = beings;
        this.supplies = supplies;
        this.height = configuration.getMapHeight();
        this.width = configuration.getMapWidth();
        this.obstaclesQuantity = configuration.getObstaclesQuantity();
    }

    @Override
    public Board create() throws FileNotFoundException{
        Board board = createEmptyBoard();
        explorer.setBoard(board);
        populate();
        return board;
    }

    public Board createEmptyBoard() throws FileNotFoundException {
        Cell[][] cells = createEmptyCells();
        int counter = 0;
        for (Cell[] row: cells) {
            for (int i=0; i<row.length; i++) {
                row[i].getContent();
            }

        }
        return new World(width, height, cells);
    }

    public void populate() throws FileNotFoundException {
        pimpekSpawner.spawn(beings);
        foodSpawner.spawn(supplies);
        obstacleSpawner.spawn(obstaclesQuantity);
    }

    private Cell[][] createEmptyCells() throws FileNotFoundException {
        Cell[][] cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Content content = new Empty();
                cells[i][j] = new BasicCell(createCellView(content), content);
            }
        }
        return cells;
    }

    private CellView createCellView(Content content) throws FileNotFoundException {
        return new CellView(
                new StackPane(),
                new ImageView(new Image(new FileInputStream(CellPaths.GRASS.getPath()))),
                new ImageView(ImageParser.getImage(content.getImagePath()))
        );
    }
}
