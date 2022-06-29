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
public class Student {

    private String stID;
    private String fName;
    private String lName;
    private boolean gender;
    private String bDate;
    private String email;
    private String phone;

    public Student() {
    }

    public Student(String stID) {
        this.stID = stID;
    }

    public Student(String stID, String fName, String lName, boolean gender, String bDate, String email, String phone) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        return this.stID.equalsIgnoreCase(((Student) obj).getStID());
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String checkGender() {
        String result = "";
        if (gender == true) {
            result = "MALE";
        } else {
            result = "FEMALE";
        }
        return result;
    }

    public void ShowInfor() {
        System.out.printf(" |%15s|%20s|%20s|%15s|%17s|%30s|%16s|\n", stID, fName, lName, checkGender(), bDate, email, phone);
    }

    @Override
    public String toString() {
        return stID + "," + fName + "," + lName + "," + checkGender() + "," + bDate + "," + email + "," + phone;
    }

}
