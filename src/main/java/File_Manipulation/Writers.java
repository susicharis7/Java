package File_Manipulation;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

class Writers {

    // File Writing
    public static void simpleWrite(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\java\\File_Manipulation\\output.txt"));
        writer.write("Haris Susic");
        writer.close();
    }
    // Array File Writing
    public static void arrayFileWrite(String[] data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\java\\File_Manipulation\\output.txt"));
        for(String row : data) {
            writer.write(row);
        }

        writer.close();
    }

    // Reading from File
    public static void simpleRead() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\java\\File_Manipulation\\output.txt"));
        System.out.println(reader.readLine()); // only reads one line
        reader.close();
    }

    // Reading all values from file
    public static void readWholeFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\java\\File_Manipulation\\output.txt"));
        String tempLine;

        while((tempLine = reader.readLine()) != null) {
            System.out.println(tempLine);
        }
        reader.close();
    }

    // Utilize Streams
    public static void readWholeFileList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\java\\File_Manipulation\\output.txt"));

        List<String> lines = reader.lines().collect(Collectors.toList());
        for(String line : lines) {
            System.out.println(line);
        }

        reader.close();
    }

    public static void main(String[] args) throws IOException{
        String text = "Haris should start thinking one step ahead sometimes...";
        String[] data = {"Not","Okay","But","We","Gucci"};
        simpleWrite(text);
        simpleRead();
        arrayFileWrite(data);
        readWholeFile();
        readWholeFileList();
    }

}
