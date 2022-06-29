/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

import java.util.ArrayList;

/**
 *
 * @author ngoc hao
 */
public class StudentList extends ArrayList<Student> {

    public int findID(String id) {
        int index = -1;
        index = this.indexOf(new Student(id));
        return index;
    }

    public void showStudent(String id) {
        if (this.size() == 0) {
            System.out.println("\tList is Empty !");
        } else {

            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
            System.out.println(" +   ID STUDENT  +      FIRST NAME    +      LAST NAME     +     GENDER    +    BIRTH DAY    +             EMAIL            +  PHONE NUMBER  +");
            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
            this.get(findID(id)).ShowInfor();
            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
        }
    }

    public void showAllStudent() {
        if (this.size() == 0) {
            System.out.println("\tList is Empty !");
        } else {
            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
            System.out.println(" +   ID STUDENT  +      FIRST NAME    +      LAST NAME     +     GENDER    +    BIRTH DAY    +             EMAIL            +  PHONE NUMBER  +");
            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
            for (int i = 0; i < this.size(); i++) {
                this.get(i).ShowInfor();
            }
            System.out.println(" +---------------+--------------------+--------------------+---------------+-----------------+------------------------------+----------------+");
        }
    }

}
