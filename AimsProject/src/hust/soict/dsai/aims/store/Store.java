package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {

    private final int MAX_NUM = 10000;
    private DigitalVideoDisc itemsInStore [] = new DigitalVideoDisc[MAX_NUM];
    private int NumDVD;

    public Store(){
        NumDVD = 0;
    }

    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore[NumDVD] = dvd;
        NumDVD += 1;
    }

    public void removeDVD(DigitalVideoDisc dvd){
        int rmv_idx = -1;

        for (int i = 0; i < NumDVD; i++){
            if ( dvd.isMatchID( itemsInStore[i].getID() ) ){
                rmv_idx = i;
                break;
            }
        }

        if (rmv_idx == -1){
            System.out.println("DVD not found in Store!");
        }
        else{
            for (int i = rmv_idx + 1; i < NumDVD; i++){
                itemsInStore[i - 1] = itemsInStore[i]; 
            }
            NumDVD -= 1;
            System.out.println("DVD removed");
        }
    }

    public void print(){
        System.out.println("***************************STORE**************************\nItems:\n");
        for (int i = 0; i < this.NumDVD; i++){
            System.out.println((i + 1) + ". " + this.itemsInStore[i].toString());
        }
        System.out.println("**********************************************************");
    }
}
