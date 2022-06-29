
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

import haolhn.utils.Utils;

/**
 *
 * @author ngoc hao
 */
public class ListStudent {

    StudentList stList = new StudentList();
    SubjectList subList = new SubjectList();
    StranScriptList scoreList = new StranScriptList();

    public void showStudent() {
        stList.showAllStudent();
    }

    public void showSubject() {
        subList.showAllSubject();
    }

//  add student 
    public void addStudent() {
        boolean check = true;
        String stID = "";
        do {
            stID = Utils.getString("Input Student ID : ").toUpperCase();
            int index = stList.findID(stID);
            if (index == -1) {
                String fName = Utils.getString("Input first Name : ");
                String lName = Utils.getString("Input last Name : ");
                boolean gender = Utils.getGender("Input Gender (Y:MALE / N:FEMALE) : ");
                String bDate = Utils.getDate("Input birth Date : ");
                String email = Utils.getMail("Input Email : ");
                String phone = Utils.getPhone("Input Phone number : ");
                stList.add(new Student(stID, fName, lName, gender, bDate, email, phone));
            } else {
                System.out.println("\tThe ID is Dulicate !");
            }
            check = Utils.confirmYesNo("Do you want to continue (Y/N) :");
        } while (check == true);
        this.showStudent();
    }

//check student
    public String checkStudent() {
        String id = "";
        String tmp = Utils.getString(" Input the ID Student to change Infomation : ").toUpperCase();
        int index = stList.findID(tmp);
        if (index > -1) {
            id = tmp;
        }
        return id;
    }

//    update student
    public void updateStudent(String id) {
        boolean check = false;
        int index = stList.findID(id);
        if (index > -1) {
            String newFName = Utils.updateString("Input new First Name :", stList.get(index).getfName());
            stList.get(index).setfName(newFName);
            String newLName = Utils.updateString("Input new Last Name :", stList.get(index).getlName());
            stList.get(index).setlName(newLName);
            boolean newGender = Utils.updateGender("Input new Gender (Y:MALE / N:FEMALE) :", stList.get(index).isGender());
            stList.get(index).setGender(newGender);
            String newBDate = Utils.updateDate("Input new birth Date :", stList.get(index).getbDate());
            stList.get(index).setbDate(newBDate);
            String newEmail = Utils.UpdateMail("Input new Email :", stList.get(index).getEmail());
            stList.get(index).setEmail(newEmail);
            String newPhone = Utils.updatePhone("Input Phone number :", stList.get(index).getPhone());
            stList.get(index).setPhone(newPhone);
            stList.showStudent(id);
        } else {
            System.out.println("\t Cant not find ID " + id + " In the list !");
        }
    }

//    delete student
    public void deleteStudent(String id) {
        int index = stList.findID(id);
        boolean checkDelete = false;
        boolean check = false;
        if (index > -1) {
            stList.showStudent(id);
            checkDelete = Utils.confirmYesNo("\t Do you want to Delete (Y/N)");
            if (checkDelete == true) {
                stList.remove(stList.get(index));
                System.out.println("\t Delete Successfully");
            } else {
                System.out.println("\t Cancle delete Successfully");
            }
        } else {
            System.out.println("\t Cant not find ID " + id + " In the list !");
        }
    }

// add subject
    public void addSubject() {
        boolean check = false;
        String idSub = "";
        do {
            idSub = Utils.getString("Input Subject ID :").toUpperCase();
            int index = subList.findID(idSub);
            if (index == -1) {
                String subName = Utils.getString(" Input name Subject :");
                int credit = Utils.getInt("Input Subject creadit :", 0, 10);
                subList.add(new Subject(idSub, subName, credit));
            } else {
                System.out.println("\tThe ID is Dulicate !");
            }
            check = Utils.confirmYesNo("Do you want to continue (Y/N)");
        } while (check == true);
        this.showSubject();

    }

    //check Subject
    public String checkSubject() {
        String id = "";
        String tmp = Utils.getString(" Input the ID Subject to change Infomation : ").toUpperCase();
        int index = subList.findID(tmp);
        if (index > -1) {
            id = tmp;
        }
        return id;
    }

//  update Subject
    public void updateSubject(String id) {
        int inndex = subList.findID(id);
        boolean check = false;
        if (inndex > -1) {
            String newNameSub = Utils.updateString("Input new name Subject :", subList.get(inndex).getSubName());
            subList.get(inndex).setSubName(newNameSub);
            int newCreadit = Utils.updateInt("Input new Creadit :", 1, 10, subList.get(inndex).getCredit());
            subList.get(inndex).setCredit(newCreadit);
            subList.showSubject(id);
        } else {
            System.out.println("\t Cant not find ID " + id + " In the list !");
        }
    }

// delete Subject
    public void deleteSubject(String id) {
        int indexDelete = subList.findID(id);
        boolean checkDelete = false;
        boolean check = false;
        if (indexDelete > -1) {
            subList.showSubject(id);
            checkDelete = Utils.confirmYesNo("\tDo you want to Delete (Y/N) :");
            if (checkDelete == true) {
                subList.remove(subList.get(indexDelete));
                System.out.println("\t Delete Successfully");
            } else {
                System.out.println("\t Cancle delete Successfully");
            }
        } else {
            System.out.println("\t Cant not find ID " + id + " In the list !");
        }

    }

// add grand 
    public void addGrand(String stID, String subID) {
        int index = scoreList.find(stID, subID);
        if (index == -1) {
            double newlab = Utils.getDouble("Input your LAB MARK :", 0, 10);
            double newTest = Utils.getDouble("Input your TEXT MARK :", 0, 10);
            double newFinal = Utils.getDouble("Input your Final MARK :", 0, 10);
            scoreList.add(new StranScript(stID, subID, newlab, newTest, newFinal));
        } else {
            boolean confirm = Utils.confirmYesNo(" You want to overwrite it (Y/N) :");
            if (confirm == true) {
                double updatelab = Utils.updateDouble("Update your LAB MARK :", 0, 10, scoreList.get(index).getLabMark());
                scoreList.get(index).setLabMark(updatelab);
                double updateTest = Utils.updateDouble("Update your TEXT MARK :", 0, 10, scoreList.get(index).getTestMark());
                scoreList.get(index).setTestMark(updateTest);
                double updateFinal = Utils.updateDouble("Update your Final MARK :", 0, 10, scoreList.get(index).getFinalMark());
                scoreList.get(index).setFinalMark(updateFinal);
            }
        }
    }

// Enter the student's subject score
    public void enterScore() {
        String stID, subID;
        boolean check = false;
        do {
            this.showStudent();
            this.showSubject();
            stID = Utils.getString("Input the Student ID :").toUpperCase();
            int indexst = stList.findID(stID);
            if (indexst > -1) {
                subID = Utils.getString("Input the Subject ID").toUpperCase();
                int indexSub = subList.findID(subID);
                if (indexSub > -1) {
                    this.addGrand(stID, subID);
                    scoreList.showInfor();
                } else {
                    System.out.println("ID Subject does not exist !\n");
                }
            } else {
                System.out.println("ID Student does not exist !\n");
            }
            check = Utils.confirmYesNo("Do you want to continue (Y/N)");
        } while (check == true);
    }


//report Student by id 
    public boolean reportStudent() {
        String stID;
        int numberOder = 1;
        boolean check = false;
        scoreList.showInfor();
        stID = Utils.getString("Input the Student ID :");
        int indexst = stList.findID(stID);
        if (indexst > -1) {
            System.out.println("\tStudent ID : " + stID);
            System.out.println("\tStudent Name : " + stList.get(indexst).getlName() + " " + stList.get(indexst).getfName());
            System.out.println("+----------+------------------------+----------------------+--------------+");
            System.out.println("+ ++ NO ++ + ++++ SUBJECT NAME ++++ + +++ AVERAGE MARK +++ + ++ STATUS ++ +");
            System.out.println("+----------+------------------------+----------------------+--------------+");
            for (int i = 0; i < scoreList.size(); i++) {
                for (int j = 0; j < subList.size(); j++) {
                    if (subList.get(j).getSubID().equalsIgnoreCase(scoreList.get(i).getSubID())) {
                        if (scoreList.get(i).getStID().equalsIgnoreCase(stID) == true) {
                            scoreList.get(i).showStReport(numberOder, subList.get(j).getSubName());
                            numberOder++;
                        }
                    }
                }
            }
            System.out.println("+----------+------------------------+----------------------+--------------+");
        } else {
            check = true;
        }
        return check;
    }

//report Subject by id
    public boolean reportSubject() {
        String subID;
        boolean check = false;
        scoreList.showInfor();
        subID = Utils.getString(" Subject ID :");
        int indexSub = subList.findID(subID);
        if (indexSub > -1) {
            System.out.println("\tInput the Subject ID : " + subID);
            System.out.println("\tSubject Name : " + subList.get(indexSub).getSubName());
            System.out.println("+------------------+------------------------+----------------------+--------------+");
            System.out.println("+ ++ STUDENT ID ++ + ++++ STUDENT NAME ++++ + +++ AVERAGE MARK +++ + ++ STATUS ++ +");
            System.out.println("+------------------+------------------------+----------------------+--------------+");
            for (int i = 0; i < scoreList.size(); i++) {
                for (int j = 0; j < stList.size(); j++) {
                    if (stList.get(j).getStID().equalsIgnoreCase(scoreList.get(i).getStID())) {
                        if (scoreList.get(i).getSubID().equalsIgnoreCase(subID) == true) {
                            scoreList.get(i).showSubReport(stList.get(j).getfName() + " " + stList.get(j).getlName());
                        }
                    }
                }
            }
            System.out.println("+------------------+------------------------+----------------------+--------------+");
        } else {
            check = true;
        }
        return check;
    }
    

}
