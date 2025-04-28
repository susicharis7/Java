package Design_Patterns.Builder;

class Computer {

    private String CPU;
    private String RAM;

    private String GPU;
    private String storage;
    private String powerSupply;
    private boolean waterCooling;


    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.GPU = builder.GPU;
        this.storage = builder.storage;
        this.powerSupply = builder.powerSupply;
        this.waterCooling = builder.waterCooling;
    }

    @Override
    public String toString() {
        return "Computer:\n" +
                "- CPU: " + CPU + "\n" +
                "- RAM: " + RAM + "\n" +
                "- GPU: " + (GPU != null ? GPU : "N/A") + "\n" +
                "- Storage: " + (storage != null ? storage : "N/A") + "\n" +
                "- Power Supply: " + (powerSupply != null ? powerSupply : "N/A") + "\n" +
                "- Water Cooling: " + (waterCooling ? "Yes" : "No");
    }


    public static class ComputerBuilder {
        private String CPU;
        private String RAM;

        private String GPU;
        private String storage;
        private String powerSupply;
        private boolean waterCooling;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public ComputerBuilder enableWaterCooling() {
            this.waterCooling = true;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

class PCMain {
    public static void main(String[] args) {
        // High-end gaming PC
        Computer gamingPC = new Computer.ComputerBuilder("Intel i9", "32GB")
                .setGPU("NVIDIA RTX 4090")
                .setStorage("2TB SSD")
                .setPowerSupply("850W")
                .enableWaterCooling()
                .build();

        System.out.println(gamingPC);
        System.out.println();

        // Budget office PC
        Computer officePC = new Computer.ComputerBuilder("Intel i3", "8GB")
                .setStorage("512GB SSD")
                .setPowerSupply("400W")
                .build();

        System.out.println(officePC);
    }
}

