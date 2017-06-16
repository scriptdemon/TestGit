/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftrecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abhishek
 */
public class Leftrecursion {

    static ArrayList<String> S = new ArrayList();
    static ArrayList<String> Prod = new ArrayList();
    static int count;
    public static void main(String[] args) {
        getProductions(S,Prod);
        LRDetector test = new LRDetector(S,Prod);
        test.initCompute();
    }
    
    public static void getProductions(ArrayList<String> S,ArrayList<String> Prod)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of productions: ");
        count = s.nextInt();
        for(int i=0;i<count;i++)
        {
            if(i==0)
                System.out.print("Enter Start Symbol: ");
            else
                System.out.print("Enter Non-Terminal "+i+": ");
            S.add(s.next());
            System.out.println("Enter Production: ");
            Prod.add(s.next());    
        }
    }
    
}
