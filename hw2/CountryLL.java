package hw2;

public class CountryLL {
    
    
    public CountryLL next;
    public Countries country;

    public CountryLL(Countries _country){
        this.country = _country;
        this.next = null;
    }

    public CountryLL add(Countries _country){
        
        CountryLL item = new CountryLL(_country);
        item.next = this;
        return item;
    }
    
    public int countItems(){
        
        return count(this, 0);
    }

     private int count(CountryLL item, int _count){
         
         _count++; 
         if(item.next == null){
             return _count;
         }
         else{
             return count(item.next, _count);
         }
         
     }  
}