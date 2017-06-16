/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftrecursion;

import java.util.ArrayList;

/**
 *
 * @author Abhishek
 */
public class LRDetector {
    ArrayList<String> S,Prod;
    String Prime;
    String beta;
    public LRDetector(ArrayList<String> S,ArrayList<String> Prod)
    {
        this.S = S;
        this.Prod = Prod;
    }
    
    public void initCompute()
    {
        for(int i=0;i<S.size();i++)
        {
            Prime="#|";
            beta ="";
            computeLR(S.get(i),Prod.get(i));
            displayResult(S.get(i));
        }
    }
    
    public boolean detectLR(String S,String Prod)
    {
        return S.charAt(0) == Prod.charAt(0);
    }
    
    public void computeLR(String S,String Prod)
    {
        if(Prod.contains("|"))
        {
            computeLR(S,Prod.substring(0,Prod.indexOf("|")));
            computeLR(S,Prod.substring(Prod.indexOf("|")+1));
        }
        else if(detectLR(S,Prod))
        {
            String temp=S+"'";
            Prime = Prime.concat(Prod.substring(Prod.indexOf(S)+1)+temp+"|");
        }
        else
        {
            String temp=S+"'";
            beta = beta.concat(Prod+temp+"|");
        }
    }
    
    public void displayResult(String S)
    {
        System.out.println("For non-terminal "+S+":");
        if(Prime.equals("#|"))
            System.out.println("No left Recursion");
        else
        {
            System.out.print(S+"'->");
            System.out.println(Prime);

            System.out.print(S+"->");
            System.out.print(beta);
        }
        System.out.println("\n");
    }
}
