package Design_Patterns.Factory_Method;

interface Transport {
    void deliver();
}

class Truck implements Transport {
    public void deliver() {
        System.out.println("Delivering by truck.");
    }
}

class Ship implements Transport {
    public void deliver() {
        System.out.println("Delivering by ship.");
    }
}

class Airplane implements Transport {
    public void deliver() {
        System.out.println("Delivering by plane.");
    }
}

abstract class Logistics {
    abstract Transport createTransport();

    void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

class RoadLogistics extends Logistics {
    Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    Transport createTransport() {
        return new Ship();
    }
}

class AirLogistics extends Logistics {
    Transport createTransport() {
        return new Airplane();
    }
}

class Mainest {
    public static void main(String[] args) {
        Logistics logistics;
        logistics = new RoadLogistics();
        logistics.planDelivery();

        logistics = new AirLogistics();
        logistics.planDelivery();
    }
}