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

public class SubjectList extends ArrayList<Subject> {

    public int findID(String id) {
        int index = -1;
        index = this.indexOf(new Subject(id));
        return index;
    }
 

    public void showAllSubject() {
        if (this.size() == 0) {
            System.out.println("\tList is Empty !");
        } else {

            System.out.println(" +--------------------+--------------------+--------------------+");
            System.out.println(" +     ID SUBJECT     +    NAME SUBJECT    +      CREADIT       +");
            System.out.println(" +--------------------+--------------------+--------------------+");
            for (int i = 0; i < this.size(); i++) {
                this.get(i).ShowInfor();
            }
            System.out.println(" +--------------------+--------------------+--------------------+");
        }
    }

    public void showSubject(String id) {
        if (this.size() == 0) {
            System.out.println("\tList is Empty !");
        } else {

            System.out.println(" +--------------------+--------------------+--------------------+");
            System.out.println(" +     ID SUBJECT     +    NAME SUBJECT    +      CREADIT       +");
            System.out.println(" +--------------------+--------------------+--------------------+");
            this.get(findID(id)).ShowInfor();
            System.out.println(" +--------------------+--------------------+--------------------+");
        }
    }

   

}
