/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.program;

import haolhn.information.ListStudent;
import haolhn.utils.Menu;

/**
 *
 * @author ngoc hao
 */
public class StudentManager {

    public static void main(String[] args) {
        ListStudent script = new ListStudent();
        boolean checkMenu = false;
        Menu menu = new Menu();
        menu.add("\n==============================MENU===========================");
        menu.add("1.ADD new student.");
        menu.add("2.Update or Delete the student.");
        menu.add("3.ADD new subject.");
        menu.add("4.Update or Delete subject.");
        menu.add("5.Entering student's grade.");
        menu.add("6.Student Grade report.");
        menu.add("7.Subject Grade report.");
        menu.add("8.QUIT.");
        menu.add("\n========================================================\n");
        do {
            menu.showMenu();
            int choice = menu.getChoice("Input your choice 1 <---> 8:");
            switch (choice) {
                case 1:
                    script.addStudent();
                    break;
                case 2:
                    Menu menuCase2 = new Menu();
                    menuCase2.add("\n------------------STUDENT--------------------");
                    menuCase2.add("1.Update Student.");
                    menuCase2.add("2.Delete Student. ");
                    menuCase2.add("3.Quit. ");
                    menuCase2.add("\n");
                    boolean checkCase2 = false;
                    do {
                        script.showStudent();
                        boolean checkStudent = false;
                        String id = script.checkStudent();
                        if (id.isEmpty()) {
                            System.out.println("ID Student is not exist !!!");
                        } else {
                            do {
                                menuCase2.showMenu();
                                int choiceStudent = menu.getChoice("Input your choice 1 <---> 3:");
                                switch (choiceStudent) {
                                    case 1:
                                        script.updateStudent(id);
                                        break;
                                    case 2:
                                        script.deleteStudent(id);
                                        break;
                                    case 3:
                                        checkStudent = menu.confirmYesNo("Do you want to Quit (Y/N):");
                                        break;
                                }
                            } while (checkStudent == false);
                        }//end if check student
                        checkCase2 = menu.confirmYesNo("Do you want to Continude to change infor Student (Y/N):");
                    } while (checkCase2 == true);
                    break;
                case 3:
                    script.addSubject();
                    break;
                case 4:
                    Menu menuCase4 = new Menu();
                    menuCase4.add("\n------------------SUBJECT--------------------");
                    menuCase4.add("1.Update Subject.");
                    menuCase4.add("2.Delete Subject.");
                    menuCase4.add("3.Quit. ");
                    menuCase4.add("\n");
                    boolean checkCase4 = false;
                    do {
                        script.showSubject();
                        boolean checkSubject = false;
                        String id = script.checkSubject();
                        if (id.isEmpty()) {
                            System.out.println("ID Subject is not exist !!!");
                        } else {
                            do {
                                menuCase4.showMenu();
                                int choiceStudent = menu.getChoice("Input your choice 1 <---> 3:");
                                switch (choiceStudent) {
                                    case 1:
                                        script.updateSubject(id);
                                        break;
                                    case 2:
                                        script.deleteSubject(id);
                                        break;
                                    case 3:
                                        checkSubject = menu.confirmYesNo("Do you want to Quit (Y/N):");
                                        break;
                                }
                            } while (checkSubject == false);
                        }//end if check student
                        checkCase4 = menu.confirmYesNo("Do you want to Continude to change infor Subject (Y/N):");
                    } while (checkCase4 == true);
                    break;
                case 5:
                    script.enterScore();
                    break;
                case 6:
                    boolean checkStu = script.reportStudent();
                    if (checkStu == true) {
                        System.out.println("Student does not exist");
                    }
                    break;
                case 7:
                    boolean checkSub = script.reportSubject();
                    if (checkSub == true) {
                        System.out.println("Subject does not exist");
                    }
                    break;
                case 8:
                    checkMenu = menu.confirmYesNo("Do you want to Quit (Y/N) :");
                    break;
            }
        } while (checkMenu != true);
    }
}
