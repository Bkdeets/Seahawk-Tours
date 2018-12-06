package edu.uncw.seahawktours;

//Simple class to define SearchListItem (img and text)
//Used for the search box and filtering results
public class SearchListItem {
    private int imageResource;
    private String text1;
    private long id;
    public SearchListItem(int imageResource, String text1, long id) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.id = id;
    }
    public int getImageResource() {
        return imageResource;
    }
    public long getId() {
        return id;
    }
    public String getText1() {
        return text1;
    }
}

