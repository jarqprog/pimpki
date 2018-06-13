package model;

import java.io.File;

public enum CellPaths {
    GRASS("src/main/resources/img/grass.png"),
    EMPTY("src/main/resources/img/empty.png"),
    WALL("src/main/resources/img/wall.png"),
    PIMPEK("src/main/resources/img/pimpek.png"),
    PREDATOR("src/main/resources/img/predator.png"),
    APPLE("src/main/resources/img/apple.png"),
    STRAWBERRY("src/main/resources/img/strawberry.png"),
    SAUSAGE("src/main/resources/img/sausage.png");

    private String path;

    CellPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path.replaceAll("/", File.separator);
    }
}
