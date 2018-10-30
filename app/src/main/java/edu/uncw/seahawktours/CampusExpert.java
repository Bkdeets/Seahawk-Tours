package edu.uncw.seahawktours;

import java.util.HashMap;
import android.util.Log;


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
                newConstruction.setName("Dobo Hall");
                newConstruction.setInfo("Opened for use in 1996, the New Science Building contained classrooms," +
                        "laboratories and faculty offices for the Chemistry and Biology Departments. Known as Dobo Hall" +
                        "its 1999 dedication to the Dobo brothers, it is currently used by the Department of Biology and" +
                        "Marine Biology and the Department of Chemistry.");
                newConstruction.setImageId(R.drawable.dobo);
                newConstruction.setCaption("Entrance to Dobo Hall");

                return newConstruction;

            case "DePaolo Hall" :
                newConstruction.setName("DePaolo Hall");
                newConstruction.setInfo("The DePaolo Hall was built in 1970 and was the original cafeteria on campus." +
                        "After Wagoner Hall opened in 1989, the building was renamed Westside Hall because of its geographic" +
                        "location on campus. It houses student services including Abrons Student Health Center, CARE" +
                        "and Crossroads, University Testing Services, Disability Services, the University Learning" +
                        "Center, and University College. On April 29, 2011, the UNCW Board of Trustees announced the" +
                        "renaming of Westside Hall to DePaolo Hall in honor of Rosemary DePaolo, who retired June 30" +
                        "after eight years as Chancellor. The naming recognizes Dr. DePaolos leadership at UNCW and" +
                        "her commitment to put students first while accomplishing the ambitious strategic goals of her" +
                        "administration.");
                newConstruction.setImageId(R.drawable.depaolo);
                newConstruction.setCaption("Entrance to DePaolo Hall");
                return newConstruction;

            case "Computer Information Systems Building" :
                newConstruction.setName("Computer Information Systems Building");
                newConstruction.setInfo("The Computer Information Systems (CIS) building was constructed to house" +
                        "the Information Systems and Operations Management Department from the Cameron School of Business" +
                        "and the Department of Computer Science from the College of Arts and Sciences. The CIS Building, a" +
                        "new 51,731 square-foot state-of-the-art facility on the UNCW campus, opened January 10, 2007 for" +
                        "the new school semester. Work on the facility began on July 29, 2004 with the groundbreaking, and" +
                        "competed in December of 2006. The building cost approximately $12.8 million and was funded by the" +
                        "North Carolina State Bond campaign of 2000.");
                newConstruction.setImageId(R.drawable.cis);
                newConstruction.setCaption("Entrance to the Computer Information Systems Building");
                return newConstruction;

            default:
                return newConstruction;
        }
    }
}
