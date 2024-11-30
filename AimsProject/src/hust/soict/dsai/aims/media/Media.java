package hust.soict.dsai.aims.media;

public abstract class Media extends java.lang.Object{
    private int id;
    private String title;
    private String category;
    private float cost;
    
    
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
}
