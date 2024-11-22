package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc dics){
        if (qtyOrdered >= MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        this.itemsOrdered[qtyOrdered] = dics;
        qtyOrdered += 1;
        System.out.println("DVD Added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        for (int i = 0; i < dvdList.length; i++)
        {
            this.itemsOrdered[qtyOrdered] = dvdList[i];
            qtyOrdered += 1;
        }
        
        System.out.println(dvdList.length + " DVD Added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED){
            System.out.println("Order List Full");
            return;
        }
        this.itemsOrdered[qtyOrdered] = dvd1;
        this.itemsOrdered[qtyOrdered + 1] = dvd2;
        qtyOrdered += 2;
        System.out.println("2 DVD Added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int rm_index = -1;
        for (int i = 0; i < this.qtyOrdered; i += 1){
            if (itemsOrdered[i].getTitle() == disc.getTitle()){
                rm_index = i;
            }
        }

        if (rm_index == -1){
            System.out.println("Deleting-DVD not found");
        }
        else{
            for (int i = rm_index + 1; i < this.qtyOrdered; i++){
                itemsOrdered[i - 1] = itemsOrdered[i];
            }
            this.qtyOrdered -= 1;
            System.out.println("DVD Deleted");

        }

    }

    public float totalCost(){
        float Sum = 0.0f;
        for (int i = 0; i < this.qtyOrdered; i++){
            Sum += this.itemsOrdered[i].getCost();
        }
        
        return Sum;
    }

    public void print(){
        System.out.println("***************************CART***************************\nOrdered Items:\n");
        for (int i = 0; i < this.qtyOrdered; i++){
            System.out.println((i + 1) + ". " + this.itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**********************************************************");
    }

    public void searchByID(int id){
        for (int i = 0; i < this.qtyOrdered; i++){
            if (this.itemsOrdered[i].isMatchID(id)){
                System.out.println("ID " + id + ": " + this.itemsOrdered[i].toString());
                return;
            }
        }

        System.out.println("There is no DVD match the ID " + id);

        return;
    }
}
