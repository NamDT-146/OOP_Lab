package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
        DigitalVideoDisc [] List_of_dvds = {dvd1, dvd2, dvd3};
        anOrder.addDigitalVideoDisc(List_of_dvds);

        anOrder.print();
        // System.out.println("Total Cost is: ");
        // System.out.println(anOrder.totalCost());
        anOrder.searchByID(4);
    }
}
