package File_Manipulation;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

class Events {

    public void generateEventsFile(String filename, int numberOfRecords) {
        Random random = new Random();
        String[] eventTypes = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberOfRecords; i++) {


                Date currentDate = new Date();


                int randomDays = random.nextInt(30);  // Nasumičan broj dana (0-30)
                int randomHours = random.nextInt(24); // Nasumičan broj sati (0-23)
                int randomMinutes = random.nextInt(60); // Nasumičan broj minuta (0-59)


                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.DAY_OF_YEAR, -randomDays); // Oduzimanje nasumičnih dana
                calendar.add(Calendar.HOUR_OF_DAY, -randomHours); // Oduzimanje nasumičnih sati
                calendar.add(Calendar.MINUTE, -randomMinutes); // Oduzimanje nasumičnih minuta


                Date randomDate = calendar.getTime();
                String timestamp = dateFormat.format(randomDate); // Formatiranje datuma u željeni oblik


                String eventType = eventTypes[random.nextInt(eventTypes.length)];
                int userId = random.nextInt(1000);


                String event = "Timestamp: " + timestamp + " | Event Type: " + eventType + " | User ID: " + userId;
                writer.write(event);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readEventsFromFile(String filename) {
        ArrayList<String> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static void main(String[] args) {

        Events events = new Events();

        String filename = "events.txt";
        events.generateEventsFile(filename, 10);

        System.out.println("Printing events from the file:");
        events.printEventsFromFile(filename);

        ArrayList<String> eventRecords = events.readEventsFromFile(filename);
        System.out.println("\nReading events into an ArrayList:");
        for (String event : eventRecords) {
            System.out.println(event);
        }
    }
}

