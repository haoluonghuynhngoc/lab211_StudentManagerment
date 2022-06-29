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
public class StranScriptList extends ArrayList<StranScript> {

    public int find(String stID, String subID) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStID().equals(stID) == true && this.get(i).getSubID().equals(subID) == true) {
                index = this.indexOf(new StranScript(stID));
            }
        }
        return index;
    }


    public void showInfor() {
        System.out.println("+----------------------+----------------------+--------------+--------------+--------------+");
        System.out.println("+      STUDENT ID      +       SUBJECT ID     +    LAB MARK  +   TEXT MARK  +  FINAL MARK  +");
        System.out.println("+----------------------+----------------------+--------------+--------------+--------------+");
        for (int i = 0; i < this.size(); i++) {
            this.get(i).show();
        }
        System.out.println("+----------------------+----------------------+--------------+--------------+--------------+");
    }




 
}
