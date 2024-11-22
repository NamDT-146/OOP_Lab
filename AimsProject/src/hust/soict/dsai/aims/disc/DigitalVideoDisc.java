package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost){
        super();
        this.title = title;
        this.category = category;
        this.director = "Unknown";
        this.length = -1;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title){
        super();
        this.title = title;
        this.category = "Unknown";
        this.director = "Unknown";
        this.length = -1;
        this.cost = -1f;
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public String getTitle(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public String getDirector(){
        return director;
    }

    public int getLength(){
        return length; 
    }

    public float getCost(){
        return cost;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public static void main(String[] args) {
        
    }

    public String toString(){
        String retString = "DVD " + this.title + " " + this.category + " " + this.length + ": " + this.cost + "$";
        return retString;
    }

    public boolean isMatch(String title){
        return this.title == title;
    }

    public boolean isMatchID(int ID){
        return this.id == ID;
    }

    public int getID(){
        return this.id;
    }

}
