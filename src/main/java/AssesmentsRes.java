import java.awt.*;
import java.util.ArrayList;

public class AssesmentsRes {

    //Independent Programming Test (AI not permitted)
    // final percentage equals the program mark, but is capped at 40% if the explanation was unsuccessful.
    static public Float getIndependent(String CID) {
        if (AssessmentFeed.getResult(CID, AssessmentFeed.PROGRAMMING_TEST,
                AssessmentFeed.EXPLAINED_SUCCESSFULLY) == 1.0) {
            return (float) AssessmentFeed.getResult(CID, AssessmentFeed.PROGRAMMING_TEST,
                    AssessmentFeed.PROGRAM_MARK);
        } else {
            return 40.00F;
        }
    }

    //AI-Assisted Software Project (AI permitted) Final percentage = 0.4 × functionality + 0.6 × verification.
    static public Float Project(String CID) {
        float functionality = (float) AssessmentFeed.getResult(CID, AssessmentFeed.AI_PROJECT,
                AssessmentFeed.FUNCTIONALITY_MARK);
        float verification = (float) AssessmentFeed.getResult(CID, AssessmentFeed.AI_PROJECT,
                AssessmentFeed.VERIFICATION_MARK);
        Float finalRes = (float) ((0.40 * functionality) + (0.60 * verification));
        return finalRes;
    }

    static public Float getSoftwareDesign(String CID) {
        if (AssessmentFeed.getStudentType(CID).equals("MSc")) {
            float design = (float) AssessmentFeed.getResult(CID, AssessmentFeed.DESIGN_VIVA,
                    AssessmentFeed.DESIGN_MARK);
            float explenation = (float) AssessmentFeed.getResult(CID, AssessmentFeed.DESIGN_VIVA,
                    AssessmentFeed.EXPLANATION_MARK);
            Float finalRes = (explenation + design) / 2;
            return finalRes;
        } else {
            return 0.00F;
        }
    }

    static public Float getOverAll(String CID) {
        Float Overall = 0.00F;
        if (AssessmentFeed.getStudentType(CID).equals("MSc")) {
            Overall = (float) ((0.30 * getIndependent(CID)) + 0.70 * Project(CID));
        } else if (AssessmentFeed.getStudentType(CID).equals("UG")) {
            Overall = (float) ((0.25 * getIndependent(CID))
                    + (0.45 * Project(CID)) + (0.30 * getSoftwareDesign(CID)));
        }
        return Overall;
    }

    static public void wRep(ArrayList<String> Students) {
        String report = "";
        for (int i = 0; i < Students.size(); i++) {
            if (AssessmentFeed.getStudentType(Students.get(i)).equals("MSc")) {
                System.out.println(AssessmentFeed.getStudentName(Students.get(i)));
                System.out.println("CID" + Students.get(i));
                System.out.println("type" + AssessmentFeed.getStudentType(Students.get(i)));
                System.out.println("Independent Programming Test: " + String.format("%.2f", AssesmentsRes.getIndependent(Students.get(i)))
                        + "containing both Functionality Mark " + AssessmentFeed.getResult(Students.get(i), AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.FUNCTIONALITY_MARK) + " &  Verification Mark " + AssessmentFeed.getResult(Students.get(i), AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.VERIFICATION_MARK));
                System.out.println("Independent Programming Test: " + String.format("%.2f", AssesmentsRes.getIndependent(Students.get(i)))
                        + "containing both Functionality Mark " + AssessmentFeed.getResult(Students.get(i), AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.FUNCTIONALITY_MARK) + " &  Verification Mark " + AssessmentFeed.getResult(Students.get(i), AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.VERIFICATION_MARK));
            }
        }
    }
}




