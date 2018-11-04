package edu.uncw.seahawktours;

public class Building {

    private String name;
    private int nameId;
    private int infoId;
    private int imageId;
    private int captionId;
    private int link;

    public static final Building[] buildings = {

            new Building(
                    "Dobo Hall",
                    R.string.dobo_name,
                    R.string.dobo_info,
                    R.drawable.dobo,
                    R.string.dobo_caption,
                    R.string.dobo_link
            ),
            new Building(
                    "DePaolo Hall",
                    R.string.depaolo_name,
                    R.string.depaolo_info,
                    R.drawable.depaolo,
                    R.string.depaolo_caption,
                    R.string.depaolo_link
            ),
            new Building(
                    "Computer Information Systems Building",
                    R.string.cis_name,
                    R.string.cis_info,
                    R.drawable.cis,
                    R.string.cis_caption,
                    R.string.cis_link
            ),
            new Building(
                    "Alderman Hall",
                    R.string.alderman_name,
                    R.string.alderman_info,
                    R.drawable.alderman,
                    R.string.alderman_caption,
                    R.string.alderman_link
            ),
            new Building(
                    "James Hall",
                    R.string.james_name,
                    R.string.james_info,
                    R.drawable.james,
                    R.string.james_caption,
                    R.string.james_link
            )
    };


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

    @Override
    public String toString(){
        return this.name;
    }


}
