package Design_Patterns.Builder;

class HouseA {
    private String walls;
    private String doors;
    private String roof;
    private String pool;

    public void setWalls(String walls) {
        this.walls = walls;
    }
    public void setDoors(String doors) {
        this.doors = doors;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }
    public void setPool(String pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "House with " + walls + " , " + doors + " , " + roof  + (pool != null ? " and a " + pool : ".");
    }
}

class FluentBuilder {
    private HouseA house;

    public FluentBuilder() {
        this.house = new HouseA();
    }

    public FluentBuilder buildWalls(String walls) {
        house.setWalls(walls);
        return this;
    }

    public FluentBuilder buildDoors(String doors) {
        house.setDoors(doors);
        return this;
    }

    public FluentBuilder buildRoof(String roof) {
        house.setRoof(roof);
        return this;
    }

    public FluentBuilder buildPool(boolean pool) {
        if (pool) {
            house.setPool("swimming pool");
        }

        return this;
    }

    public HouseA getResult() {
        return house;
    }
}

class Main04 {
    public static void main(String[] args) {
        HouseA woodenHouse = new FluentBuilder()
                .buildWalls("Wooden walls")
                .buildDoors("Wooden doors")
                .buildRoof("Wooden roof")
                .buildPool(false)
                .getResult();


        HouseA modernHouse = new FluentBuilder()
                .buildWalls("Glass and concrete walls")
                .buildDoors("Sliding glass doors")
                .buildRoof("Flat concrete roof")
                .buildPool(true)
                .getResult();


        System.out.println(woodenHouse);
        System.out.println(modernHouse);

    }
}