package java2.lesson3;

/*
 * 
 * Как я понял телефоны имеют уникальный номер, а фамилии могут быть и разные и совпадающие
 * Тогда можно использовать любой Map
 */

/**
 *
 * @author info
 */
import java.util.*;

public class PhoneBook {
    
    private Map<String, String> hashMap;//телефонная книга

    public PhoneBook() {
        this.hashMap = new HashMap<String, String>();
    }
    
    public void add(String number, String name){
        this.hashMap.put(number, name);
    }
    
    public String get(String name){
        String res = name;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue().equals(name))
            res +="\n| Number: " + entry.getKey();
        }
        return res;
    }
    
    @Override
    public String toString() {
        String res = "Phone Book:";
        for (Map.Entry entry : hashMap.entrySet()) {
            res +="\n| Key: " + entry.getKey() +
                    " Value: "+ entry.getValue();
        }
        return res;
    }
}
