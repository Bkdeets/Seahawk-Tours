package edu.uncw.seahawktours;

//Simple class to define SearchListItem (img and text)
//Used for the search box and filtering results
public class SearchListItem {
    private int imageResource;
    private String text1;
    public SearchListItem(int imageResource, String text1) {
        this.imageResource = imageResource;
        this.text1 = text1;
    }
    public int getImageResource() {
        return imageResource;
    }
    public String getText1() {
        return text1;
    }
}

