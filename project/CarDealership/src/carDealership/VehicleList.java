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
    public String year;
    public String make;
    public String model;
    public String price;
    public String color;

    public VehicleList() throws FileNotFoundException, IOException {
        file = new File("vehicle.txt");
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        if (!file.exists()) {
            file.createNewFile();
        }
        input = new Scanner(file);
        vehicle = new Vehicle();

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
        copyPath = "copy.txt";
        File copy = new File(copyPath, "rw");
        if (copy.exists()) {
            try {
                RandomAccessFile random = new RandomAccessFile(copy, "rw");
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

        }
        else{
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

    public void deleteRecord(int num) throws FileNotFoundException, IOException {
        filePath = "vehicle.txt";
        file = new File(filePath);
        long fileSize = RECORD_SIZE * (num - 1);
        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            File copy = new File("copy.txt");
            RandomAccessFile copyFile = new RandomAccessFile(copy, "rw");
            if (num == 0) {
                random.seek(132);
                for (int i = 132; i < random.length(); i++) {
                    copyFile.write(random.read());
                }
                filePath = "copy.txt";

            } else {
                random.seek(fileSize);
                for (int i = (int) fileSize; i < random.length(); i++) {
                    copyFile.write(random.read());
                }
                filePath = "copy.txt";
            }

        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    public void getEditRecord(int num) {
        filePath = "vehicle.txt";
        file = new File(filePath);
        long fileSize = RECORD_SIZE * (num - 1);
        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            random.seek(fileSize);
            random.setLength(fileSize + 132);
            year = "" + random.readInt();
            make = this.readString(random, field_size);
            model = this.readString(random, field_size);
            price = "" + random.readDouble();
            color = this.readString(random, field_size);

        } catch (Exception e) {
        }
    }

    public void editRecord(int num, Vehicle vehicle) {
        filePath = "vehicle.txt";
        file = new File(filePath);
        long fileSize = RECORD_SIZE * (num - 1);
        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");
            if (num == 0) {
                random.seek(132);
                this.writeRecord(vehicle);
            } else {

            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
