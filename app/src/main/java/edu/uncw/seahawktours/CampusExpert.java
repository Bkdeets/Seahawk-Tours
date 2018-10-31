package edu.uncw.seahawktours;

import java.util.HashMap;


public class CampusExpert {

    public HashMap<String,Building> buildings;


    public CampusExpert() {
        buildings = new HashMap<>();
        buildings.put("Dobo Hall",build("Dobo Hall"));
        buildings.put("DePaolo Hall",build("DePaolo Hall"));
        buildings.put("Computer Information Systems Building",build("Computer Information Systems Building"));
    }

    public Building build(String buildingName) {

        Building newConstruction = new Building();

        switch (buildingName) {

            case "Dobo Hall" :
                newConstruction.setNameId(R.string.dobo_name);
                newConstruction.setInfoId(R.string.dobo_info);
                newConstruction.setImageId(R.drawable.dobo);
                newConstruction.setCaptionId(R.string.dobo_caption);

                return newConstruction;

            case "DePaolo Hall" :
                newConstruction.setNameId(R.string.depaolo_name);
                newConstruction.setInfoId(R.string.depaolo_info);
                newConstruction.setImageId(R.drawable.depaolo);
                newConstruction.setCaptionId(R.string.depaolo_caption);
                return newConstruction;

            case "Computer Information Systems Building" :
                newConstruction.setNameId(R.string.cis_name);
                newConstruction.setInfoId(R.string.cis_info);
                newConstruction.setImageId(R.drawable.cis);
                newConstruction.setCaptionId(R.string.cis_caption);
                return newConstruction;

            default:
                return newConstruction;
        }
    }
}
