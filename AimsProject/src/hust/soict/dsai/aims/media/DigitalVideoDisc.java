package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(nbDigitalVideoDiscs + 1, title, category, director, length, cost);
        nbDigitalVideoDiscs += 1;
    }

    public DigitalVideoDisc(String title, String category, float cost){
        super(nbDigitalVideoDiscs + 1, title, category, "Unknown", -1, cost);
        nbDigitalVideoDiscs += 1;
    }

    public DigitalVideoDisc(String title){
        super(nbDigitalVideoDiscs + 1, title, "Unknown", "Unknown", -1, -1f);
        nbDigitalVideoDiscs += 1;
    }

    public String toString(){
        String retString = "DVD " + this.getTitle() + " " + this.getCategory() + " " + this.getLength() + ": " + this.getCost() + "$";
        return retString;
    }

    public boolean isMatch(String title){
        return this.getTitle() == title;
    }

    public boolean isMatchID(int ID){
        return this.getId() == ID;
    }

}
