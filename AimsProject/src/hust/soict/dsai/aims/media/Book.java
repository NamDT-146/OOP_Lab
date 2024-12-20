package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbDigitalVideoDiscs = 0;

    public Book(String title, String category, String director, float cost){
        super(nbDigitalVideoDiscs + 1, title, category, cost);
        nbDigitalVideoDiscs += 1;
    }

    public Book(String title){
        super(nbDigitalVideoDiscs + 1, title);
        nbDigitalVideoDiscs += 1;
    }
    
    public void addAuthor(String authorName){
        if (authors.indexOf(authorName) == -1){
            System.out.println("Author existed");
        }
        else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName){
        int idx = authors.indexOf(authorName);
        if (idx == -1){
            System.out.println(authorName + " not found");
        }
        else{
            authors.remove(idx);
        }
    }

    public String toString(){
        String retString = "Book " + this.getTitle() + " " + this.getCategory() + " Author: ";
        if (authors.size() > 0){

            retString +=  authors.get(0) + ", ";
            for (int i = 1; i < authors.size(); i++){
                retString += authors.get(i) + ", ";
            }

        }
        
        retString += ": " + this.getCost() + "$";
        return retString;
    }
}
