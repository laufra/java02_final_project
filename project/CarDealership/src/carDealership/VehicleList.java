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
    private RandomAccessFile random;
    File file;
    public static final int field_size = 30;
    public static final int RECORD_SIZE = 128;

    public VehicleList() throws FileNotFoundException, IOException {
        file = new File("vehicle.dat");
        random = new RandomAccessFile(file, "rw");
        if (!file.exists()) {
            file.createNewFile();
        }
        input = new Scanner(file);
        vehicle = new Vehicle();

    }

    public String readString(RandomAccessFile random, int size) throws java.io.IOException {
        String n = "";
        for (int i = 0; i < size; i++) {
            n += String.valueOf(random.readChar());
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

        try {
            long recNum = random.length() / RECORD_SIZE;
            random.seek(0);
            for (int i = 0; i < recNum; i++) {
                rs += String.format("\n%8d%7s%7s%12f%8s", random.readInt(),
                        readString(random, field_size),
                        readString(random, field_size), random.readDouble(),
                        readString(random, field_size));

            }
            System.out.println(rs);

        } catch (IOException ex) {
            ex.getMessage();
        }
        return rs;
    }

    public void writeRecord(Vehicle newItem) throws FileNotFoundException, IOException {
        try {
            long fileSize = random.length();
            random.seek(fileSize);
            random.writeInt(newItem.getYear());
            random.writeChars(newItem.getMake().getName());
            random.writeChars(newItem.getModel());
            random.writeDouble(newItem.getPrice());
            random.writeChars(newItem.getColor());
            random.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public boolean checkRecord(int num) {
        if (num == this.indexOf(vehicle)) {
            return true;
        } else {
            return false;
        }
    }
}
