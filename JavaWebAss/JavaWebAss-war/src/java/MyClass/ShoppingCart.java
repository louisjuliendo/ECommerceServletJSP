package MyClass;

import java.util.ArrayList;


public class ShoppingCart {
    private ArrayList<Item> items;
    
    public ShoppingCart() { items = new ArrayList(); }
    
    public void addItem(String id, String name, double price, int qty, String img_name) {
        Item item = getItem(id);        
        if (item != null) {
                int newQty = item.getQuantity() + qty;
                item.setQuantity(newQty);
        }
        else {
            item = new Item(id, name, price, qty);
            item.setImageName(img_name);
            items.add(item);
        }
    }
    
    public Item getItem(String id) {
        Item searchedItem = null;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getID().equals(id)) {
                searchedItem = item;
                break;
            }   // end if
        }   // end for
        return searchedItem;
    }
    
    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) 
            return items.get(index);
        return null;
    }
    
    public void removeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getID().equals(id)) {
                removeItem(i);
                break;
            }   // end if
        }   // end for    
    }
    
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) 
            items.remove(index);
    }    
    
    public int size() { return items.size(); }
    
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            totalPrice += (item.getUnitPrice() * item.getQuantity());
        }
        return totalPrice;
    }
}
