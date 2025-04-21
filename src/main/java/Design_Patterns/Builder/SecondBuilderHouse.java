package Design_Patterns.Builder;

class SecondHouse {
private String walls;
private String doors;
private String windows;
private String pool;

public void setWalls(String walls) {
    this.walls = walls;
}
public void setDoors(String doors) {
    this.doors = doors;
}
public void setWindows(String windows) {
    this.windows = windows;
}

public void setPool(String pool) {
    this.pool = pool;
}

@Override
public String toString() {
    return "House with " + this.walls + " , " + this.doors + " , " + this.windows + " , " + this.pool;
}
}

interface BobTheBuilder {
    void buildWalls();
    void buildDoors();
    void buildWindows();
    void buildPool();
    SecondHouse getResult();
}

// This house doesn't want pool
class DrvenaKuca implements BobTheBuilder {
    private SecondHouse house;

    public DrvenaKuca() {
        this.house = new SecondHouse();
    }

    public void buildWalls() {
        house.setWalls("Wooden walls!");
    }
    public void buildDoors() {
        house.setDoors("Wooden doors!");
    }
    public void buildWindows() {
        house.setWindows("Wooden windows!");
    }
    public void buildPool() {
    }
    public SecondHouse getResult() {
        return house;
    }
}

class ModernaKuca implements BobTheBuilder {
    private SecondHouse house;

    public ModernaKuca() {
        this.house = new SecondHouse();
    }

    public void buildWalls() {
        house.setWalls("Modern walls!");
    }
    public void buildDoors() {
        house.setDoors("Elevator doors!");
    }
    public void buildWindows() {
        house.setWindows("Modern Windows!");
    }
    public void buildPool() {
        house.setPool("Modern Big Pool!");
    }
    public SecondHouse getResult() {
        return house;
    }
}

class Main03 {
    public static void main(String[] args) {
        BobTheBuilder builderInterface = new DrvenaKuca();
        builderInterface.buildWalls();
        builderInterface.buildDoors();
        builderInterface.buildWindows();
        builderInterface.buildPool();

        SecondHouse finishedWoodenHouse = builderInterface.getResult();
        System.out.println(finishedWoodenHouse);

        builderInterface = new ModernaKuca();
        builderInterface.buildWalls();
        builderInterface.buildDoors();
        builderInterface.buildWindows();
        builderInterface.buildPool();

        SecondHouse finishedModernHouse = builderInterface.getResult();
        System.out.println(finishedModernHouse);
    }
}