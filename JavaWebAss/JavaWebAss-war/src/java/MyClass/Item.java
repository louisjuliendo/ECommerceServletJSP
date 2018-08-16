/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;
/**
 *
 * @author cwtan
 */
public class Item {
    private String id, name;    
    private double unitPrice;
    private int quantity;
    private String img_name;
    
    public Item() { id = name = img_name = ""; unitPrice = 0.0; quantity = 0; }
    public Item(String id, String name, double price, int quantity) {
        this.id = id; this.name = name; this.unitPrice = price;
        this.quantity = quantity;
        
    }
    public void setID(String id)            { this.id = id; }
    public void setName(String name)        { this.name = name;}
    public void setUnitPrice(double price)  { this.unitPrice = price; }
    public void setQuantity(int quantity)   { this.quantity = quantity; }
    public String getID()       { return this.id;        }
    public String getName()     { return this.name;      }
    public double getUnitPrice(){ return this.unitPrice; }
    public int getQuantity()    { return this.quantity;  }
    public void setImageName(String img_name) { this.img_name = img_name;}
    public String getImageName() { return this.img_name; }
    
}
