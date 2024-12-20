package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore;

    public Store(){
        itemsInStore = new ArrayList<Media>();
    }

    public void addMedia(Media md){
        if (itemsInStore.contains(md)){
            this.itemsInStore.add(md);
            System.out.println("Media Added");
        }
        else System.out.println("Media included");
    }

    public void removeMedia(Media md){
        int rmv_idx = itemsInStore.indexOf(md);

        if (rmv_idx == -1){
            System.out.println("DVD not found in Store!");
        }
        else{
            itemsInStore.remove(rmv_idx);
            System.out.println("DVD removed");
        }
    }

    public ArrayList<Media> getItemsInStore(){
        return this.itemsInStore;
    }

    public void displayStore(){
        System.out.println("***************************STORE**************************\nItems:\n");
        if (itemsInStore.size() == 0){
            System.out.println("There is nothing!");
        }
        else{
            for (int i = 0; i < this.itemsInStore.size(); i++){
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("**********************************************************");
    }

    public int SearchByTitle( String title ){
        int idx = -1;
        int i = 0;
        for (Media md: itemsInStore){
            if (md.getTitle() == title){
                idx = i;
            }
            i += 1;
        }

        return idx;
    }
    
    public void displayMediaDetails( String title ){
        int idx = SearchByTitle(title);

        if (idx == -1){
            System.out.println("Not Found!");
        }
        else{
            System.out.println(itemsInStore.get(idx).toString());
        }
    }

    public boolean inStore(String title){
        return SearchByTitle(title) != -1;
    }

    public Media getByTitle(String title){
        int idx = SearchByTitle(title);
        return itemsInStore.get(idx);
    }

    public boolean removeMedia(String title){
        if (!inStore(title)) return false;
        Media rm_md = getByTitle(title);

        removeMedia(rm_md);
        return true;
    }

}
