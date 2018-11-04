package edu.uncw.seahawktours;

import java.util.HashMap;

public class CampusExpert {

    public HashMap<String,Building> buildings;


    public CampusExpert() {
        buildings = new HashMap<>();
        buildings.put("Alderman Hall",build("Alderman Hall"));
        buildings.put("Dobo Hall",build("Dobo Hall"));
        buildings.put("DePaolo Hall",build("DePaolo Hall"));
        buildings.put("Computer Information Systems Building",build("Computer Information Systems Building"));
        buildings.put("James Hall",build("James Hall"));
    }

    public Building build(String buildingName) {

        Building newConstruction = new Building();

        switch (buildingName) {

            case "Dobo Hall" :
                newConstruction.setNameId(R.string.dobo_name);
                newConstruction.setInfoId(R.string.dobo_info);
                newConstruction.setImageId(R.drawable.dobo);
                newConstruction.setCaptionId(R.string.dobo_caption);
                newConstruction.setLink(R.string.dobo_link);

                return newConstruction;

            case "DePaolo Hall" :
                newConstruction.setNameId(R.string.depaolo_name);
                newConstruction.setInfoId(R.string.depaolo_info);
                newConstruction.setImageId(R.drawable.depaolo);
                newConstruction.setCaptionId(R.string.depaolo_caption);
                newConstruction.setLink(R.string.depaolo_link);

                return newConstruction;

            case "Computer Information Systems Building" :
                newConstruction.setNameId(R.string.cis_name);
                newConstruction.setInfoId(R.string.cis_info);
                newConstruction.setImageId(R.drawable.cis);
                newConstruction.setCaptionId(R.string.cis_caption);
                newConstruction.setLink(R.string.cis_link);

                return newConstruction;

            case "Alderman Hall" :
                newConstruction.setNameId(R.string.alderman_name);
                newConstruction.setInfoId(R.string.alderman_info);
                newConstruction.setImageId(R.drawable.alderman);
                newConstruction.setCaptionId(R.string.alderman_caption);
                newConstruction.setLink(R.string.alderman_link);

                return newConstruction;

            case "James Hall" :
                newConstruction.setNameId(R.string.james_name);
                newConstruction.setInfoId(R.string.james_info);
                newConstruction.setImageId(R.drawable.james);
                newConstruction.setCaptionId(R.string.james_caption);
                newConstruction.setLink(R.string.james_link);

                return newConstruction;


            default:
                return newConstruction;
        }
    }
}
