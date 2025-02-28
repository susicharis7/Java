package Encapsulation_And_Inheritance;

class Component {
    private String id;
    private String producer;
    private String description;

    public Component(String id, String producer, String description) {
        this.id = id;
        this.producer = producer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public String getDescription() {
        return description;
    }

    class Motor extends Component{
        private String motorType;

        public Motor(String id, String producer, String description, String motorType) {
            super(id,producer,description);
            this.motorType = motorType;
        }

        public String getMotorType() {
            return motorType;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public static void main(String[] args) {
        Component component = new Component("414", "BMW", "Best Car Ever");
        Motor motor = component.new Motor("414", "BMW", "Best Ever", "Benzinac");
        System.out.println(motor.getMotorType());
    }
}
