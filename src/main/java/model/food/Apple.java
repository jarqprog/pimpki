package model.food;

import model.CellPaths;

public class Apple implements Food {


    private static final String IMAGE_PATH = CellPaths.APPLE.getPath();

    @Override
    public int getEnergy() {
        return 35;
    }

    @Override
    public String getImagePath() {
        return IMAGE_PATH;
    }
}