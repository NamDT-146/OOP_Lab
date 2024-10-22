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
}
