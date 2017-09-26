package hw2;

/**
 *
 * @author mattc
 */
public class CountryList extends HW2 {
    
     public CountryList next;
    public Countries country;
    
    public CountryList(Countries country){
        this.country = country;
        this.next = null;
    }
    
    public CountryList add(Countries country){
        
        CountryList now = new CountryList(country);
        now.next = this;
        return now;
    }
    
    public int countItems(){
        
        return count(this, 0);
    }
  
     private int count(CountryList a, int count){
         
         count++; 
         if(a.next != null){
             return count(a.next, count);
         }
         else{
             return count;
         } 
     }  
}
