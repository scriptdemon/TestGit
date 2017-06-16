package first_follow;

import java.util.ArrayList;

/**
 *
 * @author abk_D12A_42
 */
public class getFirst {
    static String temp;
    public static String[] findFirst(ArrayList<String> Q,ArrayList<String> A,String[] first)
    {
        System.out.println(Q.size());
        for(int i=0;i<Q.size();i++)
        {
            temp = "";
            getTerminal(A.get(i),Q,A);
            first[i] = temp;
        }
        System.out.println("List of FIRST:");
        for(int i=0;i<Q.size();i++)
        {
            System.out.println(Q.get(i)+ " = " +first[i]);
        }
        return first;
    }
    
    public static void getTerminal(String A,ArrayList<String> q,ArrayList<String> a)
    {
        if(A.indexOf("|") == -1)
        {    
            if(!(A.charAt(0)>= 'A' && A.charAt(0) <= 'Z'))
            {
                if(temp.indexOf(A.charAt(0)) == -1)
                     temp = temp.concat(Character.toString(A.charAt(0)));
            }
            else
            {
                int req = q.indexOf(Character.toString(A.charAt(0)));
                getTerminal(a.get(req),q,a);
            }
        }
        else
        {
            getTerminal(A.substring(0, A.indexOf("|")),q,a);
            getTerminal(A.substring(A.indexOf("|")+1, A.length()),q,a);
        }
    }
}