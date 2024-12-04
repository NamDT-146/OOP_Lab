package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;
    private static int nbDigitalVideoDiscs = 0;

    // public Disc(int ID, String title, String category, String director, int length, float cost){

    public CompactDisc(String title){
        super(nbDigitalVideoDiscs + 1, title);
        nbDigitalVideoDiscs += 1;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist){
        super(nbDigitalVideoDiscs + 1, title, category, director, length, cost);
        this.tracks = new ArrayList<Track>();
        this.artist = artist;
        nbDigitalVideoDiscs += 1;
    }

    public String getArtist() { 
        return artist;
    }

    public void addAuthor(Track track){
        if (tracks.indexOf(track) == -1){
            System.out.println("Author existed");
        }
        else {
            tracks.add(track);
        }
    }

    public void removeAuthor(Track track){
        int idx = tracks.indexOf(track);
        if (idx == -1){
            System.out.println(track + " not found");
        }
        else{
            tracks.remove(idx);
        }
    }

    public int getLength(){
        int total_length = 0;
        if (!tracks.isEmpty()){
            for (Track track: tracks){
                total_length += track.getLength();
            }
        }
        
        return total_length;
    }

    public void play(){
        System.out.println("Artist: " + this.artist);
        for (Track track: tracks){
            track.play();
        }
    }

    public String toString(){
        String retString = "CD " + this.getTitle() + " " + this.getCategory() + " " + this.getLength() + " Artist " + getArtist() + ": " + this.getCost() + "$";
        return retString;
    }

    
}
