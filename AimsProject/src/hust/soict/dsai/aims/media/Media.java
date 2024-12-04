package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media extends java.lang.Object{
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByTitleCost();
    
    public Media(int id, String title){
        super();
        this.id = id;
        this.title = title;
        this.category = "UnKnown";
        this.cost = 0f;
    }
    
    public Media(int id, String title, String category, float cost){
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    

    public int getId(){
        return this.id;
    }
    
    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }

    public float getCost(){
        return this.cost;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public boolean isMatchID(int id){
        return this.id == id;
    }

    public boolean equals(Media md){
        return md.getTitle() == this.getTitle();
    }
}
