import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.control;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Assessments Systems");
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // Grid containing the 8 bays
        int n = AssessmentFeed.getCIDs().size();
        List<String> studentsCID = AssessmentFeed.getCIDs();
        JPanel grid = new JPanel(new GridLayout(n, 3, 10, 10));

        JLabel[] labels = new JLabel[n];
        JPanel[] panels = new JPanel[n];


        for (int i = 0; i < n; i++) {
            String studentCID = studentsCID.get(i);
            JPanel panel = new JPanel();
            panels[i] = panel;

            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            String studentName = AssessmentFeed.getStudentName(studentCID);
            String studentType = AssessmentFeed.getStudentType(studentCID);
            labels[i] = new JLabel();

            labels[i].setText("<html>" + studentName +
                    "<br> Student CID: " + studentCID +
                    "<br> Student Type: " + studentType +
                    "<br> Overall Grade: " + String.format("%.2f", AssesmentsRes.getOverAll(studentCID)) +
                    "<br>Independent Programming Test: " + String.format("%.2f", AssesmentsRes.getIndependent(studentCID)) +
                    "<br> AI-Assisted Software Project " + String.format("%.2f", AssesmentsRes.Project(studentCID)) +
                    "<br> Software Design Viva: " + String.format("%.2f", AssesmentsRes.getSoftwareDesign(studentCID)) +
                    "<html>");
            panel.add(labels[i]);
            grid.add(panel);
            frame.add(grid);
            frame.setVisible(true);

        }

    }
}