package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    private ArrayList<Media> itemsOrdered;

    public void addMedia(Media dics){
        if (itemsOrdered.size() + 1 > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        this.itemsOrdered.add(dics);
        System.out.println("DVD Added");
    }

    public void addMedia(Media [] dvdList){
        if (itemsOrdered.size() + dvdList.length > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        for (int i = 0; i < dvdList.length; i++)
        {
            itemsOrdered.add(dvdList[i]);
        }
        
        System.out.println(dvdList.length + " DVD Added");
    }

    public void addMedia(Media md1, Media md2){
        if (itemsOrdered.size() + 2 > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        this.itemsOrdered.add(md1);
        this.itemsOrdered.add(md2);
        System.out.println("2 DVD Added");
    }

    public void removeMedia(Media md){
        int idx = itemsOrdered.indexOf(md);

        if (idx == -1){
            System.out.println("Deleting-DVD not found");
        }
        else{
            itemsOrdered.remove(idx);
            System.out.println("DVD Deleted");

        }

    }

    public float totalCost(){
        float Sum = 0.0f;
        for (Media media: itemsOrdered){
            Sum += media.getCost();
        }
        
        return Sum;
    }

    public void print(){
        System.out.println("***************************CART***************************\nOrdered Items:\n");
        for (int i = 0; i < itemsOrdered.size(); i++){  
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**********************************************************");
    }

    public void searchByID(int id){
        for (Media media: itemsOrdered){{
            if (media.isMatchID(id)){
                System.out.println("ID " + id + ": " + media.toString());
                return;
                }
            }    
        }

        System.out.println("There is no Media match the ID " + id);

        return;
    }
}