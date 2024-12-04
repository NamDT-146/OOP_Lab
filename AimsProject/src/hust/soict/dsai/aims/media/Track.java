package hust.soict.dsai.aims.media;

public class Track {
    private String title;
    private int length;

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }

    public String getTitle(){
        return this.title;
    }
}
