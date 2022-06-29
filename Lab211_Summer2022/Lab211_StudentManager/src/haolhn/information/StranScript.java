/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

/**
 *
 * @author ngoc hao
 */
public class StranScript {

    private String stID;
    private String subID;
    private double labMark;
    private double testMark;
    private double finalMark;

    public StranScript() {
    }

    public StranScript(String stID) {
        this.stID = stID;
    }

    public StranScript(String stID, String subID, double labMark, double testMark, double finalMark) {
        this.stID = stID;
        this.subID = subID;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }

    @Override
    public boolean equals(Object obj) {
        return this.stID.equals(((StranScript) obj).getStID());
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public double getLabMark() {
        return labMark;
    }

    public void setLabMark(double labMark) {
        this.labMark = labMark;
    }

    public double getTestMark() {
        return testMark;
    }

    public void setTestMark(double testMark) {
        this.testMark = testMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double averageMark() {
        return this.labMark * 0.3 + this.testMark * 0.3 + this.finalMark * 0.4;
    }

    public String checkMark() {
        String check = "";
        if (this.averageMark() > 4) {
            check = "Pass";
        } else {
            check = "Not Pass";
        }
        return check;
    }

    public void show() {
        System.out.printf("|%22s|%22s|%14s|%14s|%14s|\n", stID, subID, labMark, testMark, finalMark);
    }

    public void showStReport(int number, String subjectName) {

        System.out.printf("|%10s|%24s|%22.1f|%14s|\n", number, subjectName, averageMark(), checkMark());
    }

    public void showSubReport(String StudentName) {
        System.out.printf("|%18s|%24s|%22s|%14s|\n", stID, StudentName, averageMark(), checkMark());
    }

}
