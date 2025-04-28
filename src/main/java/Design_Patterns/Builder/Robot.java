package Design_Patterns.Builder;

class Robot implements Cloneable {
    private String head;
    private String body;
    private String arms;
    private String legs;

    public void setHead(String head) { this.head = head; }
    public void setBody(String body) { this.body = body; }
    public void setArms(String arms) { this.arms = arms; }
    public void setLegs(String legs) { this.legs = legs; }

    public Robot clone() {
        try {
            return (Robot) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed!");
        }
    }

    @Override
    public String toString() {
        return "Robot with:\n" +
                "- Head: " + head + "\n" +
                "- Body: " + body + "\n" +
                "- Arms: " + arms + "\n" +
                "- Legs: " + legs;
    }
}

interface RobotBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    Robot getResult();
}

class MilitaryRobotBuilder implements RobotBuilder {
    private Robot robot = new Robot();

    public void buildHead() { robot.setHead("Helmet with sensors"); }
    public void buildBody() { robot.setBody("Armored body"); }
    public void buildArms() { robot.setArms("Rocket launchers"); }
    public void buildLegs() { robot.setLegs("Tank tracks"); }

    public Robot getResult() { return robot; }
}

class MedicalRobotBuilder implements RobotBuilder {
    private Robot robot = new Robot();

    public void buildHead() { robot.setHead("Medical scanner"); }
    public void buildBody() { robot.setBody("Sterile body"); }
    public void buildArms() { robot.setArms("Surgical tools"); }
    public void buildLegs() { robot.setLegs("Flexible wheels"); }

    public Robot getResult() { return robot; }
}

class DirectorSecond {
    public void constructBasicRobot(RobotBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
    }
}

class RobotMain {
    public static void main(String[] args) {
        DirectorSecond director = new DirectorSecond();

        // Build military robot
        RobotBuilder militaryBuilder = new MilitaryRobotBuilder();
        director.constructBasicRobot(militaryBuilder);
        Robot militaryRobot = militaryBuilder.getResult();

        System.out.println("Military Robot:");
        System.out.println(militaryRobot);

        // Clone it
        Robot clonedMilitary = militaryRobot.clone();
        System.out.println("\nCloned Military Robot:");
        System.out.println(clonedMilitary);

        // Build medical robot
        RobotBuilder medicalBuilder = new MedicalRobotBuilder();
        director.constructBasicRobot(medicalBuilder);
        Robot medicalRobot = medicalBuilder.getResult();

        System.out.println("\nMedical Robot:");
        System.out.println(medicalRobot);
    }
}



