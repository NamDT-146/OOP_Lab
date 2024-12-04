package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;


    public Disc(int ID, String title, String category, String director, int length, float cost){
        super(ID, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title){
        super(id, title);
    }

    public int getLength(){
        return this.length;
    }

    public String getDirector(){
        return this.director;
    }

    

}
