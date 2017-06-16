/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_follow;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abk_D12A_42
 */
public class First_follow {
    static ArrayList<String> NT = new ArrayList();
    static ArrayList<String> prod = new ArrayList();
    static int nNT;
    static int nT;
    static String []first;
    static String []follow;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of non-terminals: ");
        nNT = s.nextInt();
        for (int i=0;i<nNT;i++)
        {
            if(i==0)
                System.out.print("start symobl: ");
            else
                System.out.print("Non terminal "+(i+1)+": ");
            NT.add(s.next());
            System.out.print("Enter Production: ");
            prod.add(s.next());
        }
        first = new String[nNT];
        follow = new String[nNT];
        first = getFirst.findFirst(NT,prod,first);
        getFollow.findFollow(NT,prod,first);
    }    
}
