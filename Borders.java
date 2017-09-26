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
public class Borders extends HW2 {
    
    public static boolean doesBorder(String Germany){
        
        boolean tf = false;
        
            switch(Germany)
                {
                case "France":
                    tf = true;
                    break;
                case "Poland":
                    tf = true;
                    break;
                case "Netherlands":
                    tf = true;
                    break;
                case "Belgium":
                    tf = true;
                    break;
                case "Luxembourg":
                    tf = true;
                    break;
                case "Czechia":
                    tf = true;
                    break;
                case "Austria":
                    tf = true;
                    break;
                case "Switzerland":
                    tf = true;
                    break;      
                } 
            return tf;
        }
        
    }
    

