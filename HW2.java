/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/**
 *
 * @author mattc
 */

import java.util.Scanner;

public class HW2 {

    private static Countries country;
    final static String INPUT_FILE  = "countries.txt";
    static Countries[] countryArray = null;
    static CountryList countryList;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scnr = new Scanner (System.in);
        String userAction = "";
        HW2 hw2 = new HW2();
        
        int maxPop = 35000000;
       
        greetReadUser (userAction);
        
        switch (userAction) {
            case "1":
                HW2.importData();
                break;
            case "2": 
                hw2.borders();
                break;
            case "3":
                hw2.population(maxPop);
                break;
            case "4":
                hw2.comboPopBorder(maxPop);
                break;
            default:
                break;
        }
        System.exit(0);
    }
    
    public static String greetReadUser(String newAction){
        
        Scanner scnr = new Scanner(System.in);
        
        String userAction;
    
        System.out.println("This program will read data about European"
                + "countries, and return select data for \n"
                + "your viewing pleasure. Please select one of the following, \n"
                + "and REMEMBER to import the data first!");
        System.out.println("Select one of the following actions: \n"
                + "1. Import the data \n"
                + "2. Display a list of countries that border Germany \n"
                + "3. Display a list of all countries that have a population"
                +    "of greater than 35 million \n"
                + "4. Display list of all countries that border Germany AND"
                +    "have a population greater than 35 million\n"
                + "5. Quit the program");
        
        return userAction = scnr.next();
}
    
    public static void importData () { //this will try to obtain file through a search, and with file name.
        //Make file the input scanner
        Scanner scnr = new Scanner(INPUT_FILE);
        //Loop through file using a seperater and will assign values from file to array.
        while (scnr.hasNextLine()) {
            
            String line = scnr.nextLine();
            String[] items = line.split(", ");
            Countries z;
            z = new Countries();
            z.countryName = items[0];
            z.latitude = items[1];
            z.longitude = items[2];
            z.countryArea = Integer.parseInt(items[3]);
            z.countryPopulation = Integer.parseInt(items[4]);
            z.countryGDP = Double.parseDouble(items[5]);
            z.countryYear = Integer.parseInt(items[6]);
            
            //Sets the null linkedlist to new data incoming
            //After it's no longer null, the next time around it will add
            //new data to the next linkedlist.
            if (countryList == null) {
                countryList = new CountryList(z);
            } else {
                countryList = countryList.add(z);
            }
        }
        //Count the linkedlist, create new array with length of linked list
        //then populate new array with data from linkedlist
        int num = countryList.countItems();
        HW2.countryArray = new Countries[num];
        CountryList ll = countryList;
        for (int i = 0; i < num; i++) {
            countryArray[i] = ll.country;
            ll = ll.next;
        }
    }
        
    
    
    public void borders(){ // input 2
        
        boolean doesBorder;
        Borders now = new Borders();

        for (Countries cntry : countryArray) {
            doesBorder = Borders.doesBorder(cntry.countryName);
            if (doesBorder) {
                System.out.println(cntry.countryName);
            }
        }
    }
    
    public void population(int pop){ // inut 3
        
        for (Countries cntry : countryArray) {
            if (cntry.countryPopulation > pop) {
                System.out.println (cntry.countryName + cntry.countryPopulation);
            }
        } 
    } // end population
    
    public void comboPopBorder(int pop){ //input 4
        
        boolean doesBorder;
        Borders b = new Borders();
        for (Countries cntry : countryArray) {
            doesBorder = Borders.doesBorder(cntry.countryName);
            if (doesBorder && cntry.countryPopulation > pop) {
                System.out.println(cntry.countryName + "  " + cntry.countryPopulation);
            }
        }
        //Clean output
        System.out.print("\n");
    } // end comboPopBorder
    
    }// end class