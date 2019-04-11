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

/**
 *
 * @author Frankie
 */
public class VehicleList extends ArrayList<Vehicle> {

    private File file;
    private Scanner input;
    private Vehicle vehicle;
    private RandomAccessFile random;
    
    Make maker;
    BodyCondition body;
    BodyType bodtype;
    Transmission trans;
    
    public VehicleList() throws FileNotFoundException, IOException{
        file = new File("vehicle.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        input = new Scanner(file);
        vehicle = new Vehicle();
    }
    
    public String readFile() throws FileNotFoundException{
     
        return "";
    }
    
    public void writeRecord(Vehicle newItem) throws FileNotFoundException, IOException{
    
         random = new RandomAccessFile(file,"rw");
         int field_size = 50;
        
        random = new RandomAccessFile(file,"rw");
        random.seek(random.length());
        
        int year=0;
        random.writeInt(year);
        
        String make = "";
        make = prepStringField(make,field_size);
        random.writeChars(make);
        maker.setName(make);
        
        
        String model ="";
        model = prepStringField(model, field_size);
        random.writeChars(model);
        
        String vin = "";
        vin = prepStringField(vin,field_size);
        random.writeChars(vin);
        
        double price =0.0;
        random.writeDouble(price);
        
        String condition ="";
        condition = prepStringField(condition, field_size);
        random.writeChars(condition);
        body.setCondition(condition);
        
        String type ="";
        type = prepStringField(type, field_size);
        random.writeChars(type);
        bodtype.setBodyType(type);
        
        int miles = 0;
        random.writeInt(miles);
        
        String fuel ="";
        fuel = prepStringField(fuel, field_size);
        random.writeChars(fuel);
        trans.setTransmission(fuel);
        
        int seat =0;
        random.writeInt(seat);
        
        String colour = "";
        colour = prepStringField(colour,field_size);
        random.writeChars(colour);
        
        
        newItem = new Vehicle(year, maker, model, vin, price, body, bodtype, miles, trans, seat, colour);

    }
        
    public boolean checkRecord(int record){
        return true;
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
}
