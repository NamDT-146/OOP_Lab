package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore;

    public Store(){
        
    }

    public void addDVD(Media md){
        itemsInStore.add(md);
    }

    public void removeDVD(Media md){
        int rmv_idx = itemsInStore.indexOf(md);

        if (rmv_idx == -1){
            System.out.println("DVD not found in Store!");
        }
        else{
            itemsInStore.remove(rmv_idx);
            System.out.println("DVD removed");
        }
    }

    public void print(){
        System.out.println("***************************STORE**************************\nItems:\n");
        for (int i = 0; i < this.itemsInStore.size(); i++){
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("**********************************************************");
    }
}
