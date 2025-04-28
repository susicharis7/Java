package Design_Patterns.Adapter;

interface TemperatureSensorCelsius {
    double getTemperatureCelsius();
}

interface TemperatureSensorFahrenheit {
    double getTemperatureFahrenheit();
}

class CelsiusSensor implements TemperatureSensorCelsius {
    public double getTemperatureCelsius() {
        return 25.0;
    }
}

class SensorAdapter implements TemperatureSensorFahrenheit {
    private TemperatureSensorCelsius celsiusSensor;

    public SensorAdapter(TemperatureSensorCelsius celsiusSensor) {
        this.celsiusSensor = celsiusSensor;
    }

    public double getTemperatureFahrenheit() {
        return (celsiusSensor.getTemperatureCelsius() * 9/5) + 32;
    }
}
