package Design_Patterns.Builder;

class House {
    private String walls;
    private String doors;
    private String roof;

    public void setWalls(String walls) {
        this.walls = walls;
    }
    public void setDoors(String doors) {
        this.doors = doors;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House with " + this.walls + " , " + this.doors + " , " + this.roof;
    }

}

interface HouseBuilder {
    void buildWalls();
    void buildDoors();
    void buildRoof();
    House getResult();
}

class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    public void buildWalls() {
        house.setWalls("Wooden walls!");
    }
    public void buildDoors() {
        house.setDoors("Wooden doors!");
    }
    public void buildRoof() {
        house.setRoof("Wooden roof!");
    }
    public House getResult() {
        return house;
    }
}

class StoneHouseBuilder implements HouseBuilder {
    private House house;

    public StoneHouseBuilder() {
        this.house = new House();
    }

    public void buildWalls() {
        house.setWalls("Stone walls!");
    }
    public void buildDoors() {
        house.setDoors("Stone doors!");
    }
    public void buildRoof() {
        house.setRoof("Stone roof!");
    }
    public House getResult() {
        return house;
    }
}

class Main01 {
    public static void main(String[] args) {
        HouseBuilder builder = new WoodenHouseBuilder();
        builder.buildWalls();
        builder.buildDoors();
        builder.buildRoof();

        House finishedProduct = builder.getResult();
        System.out.println(finishedProduct);

        builder = new StoneHouseBuilder();
        builder.buildWalls();
        builder.buildDoors();
        builder.buildRoof();

        House secondFinishedProduct = builder.getResult();
        System.out.println(secondFinishedProduct);
    }
}