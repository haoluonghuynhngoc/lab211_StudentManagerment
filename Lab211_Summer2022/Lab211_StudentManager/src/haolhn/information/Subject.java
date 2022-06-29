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
public class Subject {

    private String subID;
    private String subName;
    private int credit;

    public Subject() {
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    public Subject(String subID, String subName, int credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    @Override
    public boolean equals(Object obj) {
        return this.subID.equalsIgnoreCase(((Subject) obj).getSubID());
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void ShowInfor() {
        System.out.printf(" |%20s|%20s|%20s|\n", subID, subName, credit);
    }

    @Override
    public String toString() {
        return subID + "," + subName + "," + credit;
    }

}
