/*
Matt Coover
CS2050
HW2 version 2
 */

package hw2;

import java.io.FileNotFoundException;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class HW2 {

    private static final int POPULATION_LIMIT = 35000000;

    Countries[] countryArray;
    CountryLL countryLL;

    public static void main(String[] args) {
        
        HW2 hw = new HW2();
        
        System.out.println("This program will read data about European"
                + "countries, and return select data for \n"
                + "your viewing pleasure. Please select one of the following, \n"
                + "and REMEMBER to import the data first!");
        
        int chosenNum = hw.inputFromUser();
        while (chosenNum != 5) {
            
            switch (chosenNum) {
                case 1:
                    hw.readCountries();
                    break;
                case 2:
                    hw.outputBorderingCountries();
                    break;
                case 3:
                    hw.outputExceedsPopulation(POPULATION_LIMIT);
                    break;
                case 4:
                    hw.outputBorderingExceedsPopulation(POPULATION_LIMIT);
                    break;
                default:
                    break;
            }
           
            chosenNum = hw.inputFromUser();

        } // while
    } // main
 
    int inputFromUser() {
        
        int choice = 0;
        Scanner kb = new Scanner(System.in);
        while (choice < 1 || choice > 5) {

            System.out.println("Please select one of the following options.");
            System.out.println("1. Import the data");
            System.out.println("2. Display list of all countries that border "
                    + "Germany");
            System.out.println("3. Display list of all countries that have a "
                    + "population greater than 35 million");
            System.out.println("4. Display list of all countries that border "
                    + "Germany AND"
                    + "have a population greater than 35 million");
            System.out.println("5. Quit the program");

            choice = kb.nextInt();
            if (choice > 5 || choice < 1) {
                System.out.println("Please enter a valid number. 1 - 5");
            }
        }
        return choice;
    }
    
    private void readCountries() {
        try {
            
            URL url = getClass().getResource("countries_data.txt");
            File file = new File(url.getPath());
          
            Scanner f = new Scanner(file);
          
            while (f.hasNextLine()) {

                String line = f.nextLine();
                String[] items = line.split(", ");
                Countries country = new Countries();
                country.countryName = items[0];
                country.latitude = items[1];
                country.longitude = items[2];
                country.countryArea = Integer.parseInt(items[3]);
                country.countryPopulation = Integer.parseInt(items[4]);
                country.countryGDP = Double.parseDouble(items[5]);
                country.countryYear = Integer.parseInt(items[6]);
                

                if (countryLL == null) {
                    countryLL = new CountryLL(country);
                } else {
                    countryLL = countryLL.add(country);
                }
            }

            int num = countryLL.countItems();
            this.countryArray = new Countries[num];
            CountryLL ll = countryLL;
            for (int i = 0; i < num; i++) {
                countryArray[i] = ll.country;
                ll = ll.next;
            }
        } 
        catch (FileNotFoundException e) {
        }
        
        System.out.println("\n Data successfully input" + "\n");
        
    } // method

    void outputBorderingExceedsPopulation(int population) {
        boolean doesBorder;
        Borders b = new Borders();
        for (Countries cntry : countryArray) {
            doesBorder = b.isBordering("Germany", cntry.countryName);
            if (doesBorder && cntry.countryPopulation > population) {
                System.out.println(cntry.countryName + "  " 
                    + cntry.countryPopulation + "\n");
            } // if
        } // for

    } // method


    void outputExceedsPopulation(int population) {
        for (Countries cntry : countryArray) {
            if (cntry.countryPopulation > population) {
                System.out.println(cntry.countryName + ", Population: " 
                        + cntry.countryPopulation + "\n");
            }
        } // for
    } // method

    
    void outputBorderingCountries() {
        boolean doesBorder;
        Borders b = new Borders();

        for (Countries cntry : countryArray) {
            doesBorder = b.isBordering("Germany", cntry.countryName);
            if (doesBorder) {
                System.out.println(cntry.countryName + "\n");
            } // if
        } // for
    } // method

} // class