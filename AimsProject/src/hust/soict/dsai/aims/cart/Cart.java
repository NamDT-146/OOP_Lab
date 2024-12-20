package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    private ObservableList<Media> itemsOrdered;

    public Cart() {
        itemsOrdered = FXCollections.observableArrayList();
    }

    public void addMedia(Media md){
        if (itemsOrdered.size() + 1 > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        else if (!itemsOrdered.contains(md)){
            this.itemsOrdered.add(md);
            System.out.println("Media Added");
        }
        else System.out.println("Media included");
        
    }

    public void addMedia(Media [] mdList){
        if (itemsOrdered.size() + mdList.length > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        for (int i = 0; i < mdList.length; i++)
        {
            if (!itemsOrdered.contains(mdList[i])){
                this.itemsOrdered.add(mdList[i]);
                System.out.println("Media Added");
            }
            else System.out.println("Media included");
        }
    }

    public void addMedia(Media md1, Media md2){
        if (itemsOrdered.size() + 2 > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        if (!itemsOrdered.contains(md1)){
            this.itemsOrdered.add(md1);
            System.out.println("Media Added");
        }
        else System.out.println("Media included");
        if (!itemsOrdered.contains(md2)){
            this.itemsOrdered.add(md2);
            System.out.println("Media Added");
        }
    }

    public ObservableList<Media> getItemsOrdered(){
        return this.itemsOrdered;
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

    public void displayItems(){
        System.out.println("***************************CART***************************\nOrdered Items:\n");
        for (int i = 0; i < itemsOrdered.size(); i++){  
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**********************************************************");
    }

    public boolean checkID(int id){
        for (Media media: itemsOrdered){{
            if (media.isMatchID(id)){
                return true;
                }
            }    
        }

        return false;
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

    public void SortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    public void SortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int getNumMedia(){
        return itemsOrdered.size();
    }

    public void displayByID(int ID){
        int idx = -1;
        int i = 0;
        for (Media media: itemsOrdered){
            if (media.isMatchID(ID)) idx = i;             
            i++;
        }    
        if (idx == -1){
            System.out.println("Not Found");
            return ;
        }
        else System.out.println( itemsOrdered.get(idx).toString() );
    }

    public boolean checkTitle(String title){
        int idx = -1;
        int i = 0;
        for (Media media: itemsOrdered){
            if (media.getTitle() == title) idx = i;             
            i++;
        }    
        if (idx == -1){
            return false;
        }
        else return true;
    }

    public void displayByTitle(String title){
        int idx = -1;
        int i = 0;
        for (Media media: itemsOrdered){
            if (media.getTitle() == title) idx = i;             
            i++;
        }    
        if (idx == -1){
            System.out.println("Not Found");
            return ;
        }
        else System.out.println( itemsOrdered.get(idx).toString() );
    }

    public boolean removeMedia(String title){
        int idx = -1;
        int i = 0;
        for (Media media: itemsOrdered){
            if (media.getTitle() == title) idx = i;             
            i++;
        }    
        if (idx == -1){
            // System.out.println("Not Found");
            return false;
        }
        else itemsOrdered.remove(idx);
        return true;
    }

    public void clearCart(){
        itemsOrdered.clear();
    }
}