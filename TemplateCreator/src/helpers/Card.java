package helpers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Card {
    private StringProperty name;
    private StringProperty rarity;
    private int numOfCopys;
    
    public Card(String name, String rarity, int numOfCopys) {
        this.name = new SimpleStringProperty(name);
        this.rarity = new SimpleStringProperty(rarity);
        this.numOfCopys = numOfCopys;
    }
    
    public int getNumOfCopys() {
    	return numOfCopys;
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public String getRarity() {
        return rarity.get();
    }
    
    public void setRarity(String rarity) {
        this.rarity.set(rarity);
    }
    
    public String toString() {
    	return "[ " + numOfCopys + ", " + name + ", " + rarity + "]";
    }
}