package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Media md1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(md1);
        Media md2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(md2);
        Media md3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
        cart.addMedia(md3);

        cart.getItemsOrdered();
        cart.displayItems();
    }
}
