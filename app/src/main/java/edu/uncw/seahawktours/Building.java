package edu.uncw.seahawktours;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import java.util.List;

@Entity
public class Building {



    @Id
    public long id;

    private String name;
    private int nameId;
    private int infoId;
    private int imageId;
    private int captionId;
    private int link;

    public Building(String name, int nameId, int infoId, int imageId, int captionId, int link) {
        this.name = name;
        this.nameId = nameId;
        this.infoId = infoId;
        this.imageId = imageId;
        this.captionId = captionId;
        this.link = link;

    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }


}
