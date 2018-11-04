package edu.uncw.seahawktours;

public class Building {

    private int nameId;
    private int infoId;
    private int imageId;
    private int captionId;
    private int link;


    public Building() { }

    public int getLink() { return link; }

    public void setLink(int link) { this.link = link; }

    public int getCaptionId() { return captionId; }

    public void setCaptionId(int captionId) { this.captionId = captionId; }

    public int getNameId() {
        return nameId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }


}
