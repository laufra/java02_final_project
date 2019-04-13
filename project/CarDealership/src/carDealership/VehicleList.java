/*
        [Class name]
        Author: Frankie
        Date: [date]

        Description
        [Description about the class]
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;

/**
 *
 * @author Frankie
 */
public class VehicleList extends ArrayList<Vehicle> {

    private Scanner input;
    private Vehicle vehicle;
    File file;
    public static final int field_size = 20;
    //int String string double string
    public static final int RECORD_SIZE = 132;
    private String filePath = "";
    private String copyPath = "";
    public static String year;
    public static String make;
    public static String model;
    public static String price;
    public static String color;

    public VehicleList() throws FileNotFoundException, IOException {
        file = new File("vehicle.txt");
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        if (!file.exists()) {
            file.createNewFile();
        }
        input = new Scanner(file);
        vehicle = new Vehicle();

    }

    public void deleteRecord() throws FileNotFoundException, IOException {
        filePath = "vehicle.txt";
        file = new File(filePath);
        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            random.seek(random.length() - 132);
            random.setLength(random.getFilePointer());

        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    public String readString(RandomAccessFile random, int size) throws java.io.IOException {
        String n = "";
        for (int i = 0; i < size; i++) {
            n += random.readChar();
        }
        return n;
    }

    public String prepStringField(String value, int size) {
        if (value.length() < size) {
            int numSpaces = size - value.length();
            for (int i = 1; i <= numSpaces; i++) {
                value += " ";
            }
        } else {
            value = value.substring(0, size);
        }
        return value;
    }

    public String readFile() throws FileNotFoundException, IOException {
        String rs = "";
        filePath = "vehicle.txt";
        file = new File(filePath);
            try {
                RandomAccessFile random = new RandomAccessFile(file, "rw");
                random.seek(0);
                while (random.getFilePointer() < random.length()) {

                    rs += String.format("%n%4d%28s%15s%3.2f%30s%n", random.readInt(),
                            readString(random, field_size),
                            readString(random, field_size), random.readDouble(),
                            readString(random, field_size));
                }

            } catch (IOException ex) {
                ex.getMessage();
            }
        return rs;
    }

    public void writeRecord(Vehicle newItem) throws FileNotFoundException, IOException {
        try {
            filePath = "vehicle.txt";
            file = new File(filePath);
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            long fileSize = random.length();
            random.seek(fileSize);
            random.writeInt(newItem.getYear());
            random.writeChars(prepStringField(newItem.getMake().getName(), field_size));
            random.writeChars(prepStringField(newItem.getModel(), field_size));
            random.writeDouble(newItem.getPrice());
            random.writeChars(prepStringField(newItem.getColor(), field_size));

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public boolean checkRecord(int num) throws FileNotFoundException, IOException {
        filePath = "vehicle.txt";
        file = new File(filePath);
        long fileSize = RECORD_SIZE * (num);
        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            random.seek(fileSize);
            if (fileSize + 1 < random.length()) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public void editRecord(Vehicle newItem , int num) throws FileNotFoundException, IOException {
        filePath = "vehicle.txt";
        file = new File(filePath);
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        long fileSize = RECORD_SIZE * num;
        random.seek(fileSize);
        random.writeInt(newItem.getYear());
            random.writeChars(prepStringField(newItem.getMake().getName(), field_size));
            random.writeChars(prepStringField(newItem.getModel(), field_size));
            random.writeDouble(newItem.getPrice());
            random.writeChars(prepStringField(newItem.getColor(), field_size));
        
    }
    
    public String readFileIndex(int num) throws FileNotFoundException, IOException {
        String rs = "";
        filePath = "vehicle.txt";
        file = new File(filePath);
        long fileSize = RECORD_SIZE*num;
            try {
                RandomAccessFile random = new RandomAccessFile(file, "rw");
                random.seek(fileSize);
                while (random.getFilePointer() < random.length()) {

                    rs += String.format("%n%4d%28s%15s%3.2f%30s%n", random.readInt(),
                            readString(random, field_size),
                            readString(random, field_size), random.readDouble(),
                            readString(random, field_size));
                }

            } catch (IOException ex) {
                ex.getMessage();
            }
        return rs;
    }
}
