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
    
    public void writeRecord(Vehicle newItem) throws FileNotFoundException{
    
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
    }
        
    public boolean checkRecord(int record){
        return true;
    }
    

}
