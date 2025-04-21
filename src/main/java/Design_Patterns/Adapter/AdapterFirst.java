package Design_Patterns.Adapter;

interface Socket {
    String getPower();
}

class EuropeanSocket {
    public String get220V() {
        return "Coming 220V From Europe";
    }
}

class AmericanSocket {
    public String get180V() {
        return "Coming 180V From America";
    }
}

class SocketAdapter implements Socket {
    private EuropeanSocket europeanSocket;
    private AmericanSocket americanSocket;

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    public String getPower() {
        if (europeanSocket != null) {
            return europeanSocket.get220V();
        } else if (americanSocket != null) {
            return americanSocket.get180V();
        } else {
            return "No socket connected!";
        }
    }
}

class Device {
    Socket socket;

    public Device(Socket socket) {

        this.socket = socket;
    }

    public void charge() {
        System.out.println(socket.getPower());
    }
}

class Main{
    public static void main(String[] args) {
        EuropeanSocket socket = new EuropeanSocket();
        Socket adapter = new SocketAdapter(socket);
        Device device = new Device(adapter);
        device.charge();

        AmericanSocket socket2 = new AmericanSocket();
        Socket adapter2 = new SocketAdapter(socket2);
        Device device2 = new Device(adapter2);
        device2.charge();
    }
}

