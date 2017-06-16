package first_follow;

import java.util.ArrayList;

/**
 *
 * @author abk_D12A_42
*/
public class getFollow{
    static String temp;
    static ArrayList<String> nonTerm;
    static ArrayList<String> prod;
    static String[] FIRST;
    static String[] FOLLOW;
    //static ArrayList<String> FIRST = new ArrayList();
    public static void findFollow(ArrayList<String> NT,ArrayList<String> Prod,String[] first)
    {
        nonTerm = NT;
        prod = Prod;
        FIRST = new String[NT.size()];
        FOLLOW = new String[NT.size()];
        for(int k=0;k<first.length;k++)
        {
            FIRST[k] = first[k];
        }
        for(int i=0;i<NT.size();i++)
        {
                temp = "";
                if(i==0)
                temp = temp.concat("$");
                for(int j=0;j<Prod.size();j++)
                {
                    if(prod.get(j).indexOf(nonTerm.get(i)) != -1)
                    {
                        if(prod.get(j).indexOf("|") != -1)
                        {
                            getFollowTerminal(nonTerm.get(i),prod.get(j).substring(0,prod.get(j).indexOf("|")));
                            getFollowTerminal(nonTerm.get(i),prod.get(j).substring(prod.get(j).indexOf("|")+1,prod.get(j).length()));
                        }
                        else
                        {
                            getFollowTerminal(nonTerm.get(i),prod.get(j));
                        }
                    }
                }
            FOLLOW[i] = temp;
            temp="";
        }
        System.out.println("List of follows: ");
        for(int i=0;i<FOLLOW.length;i++)
            System.out.println(nonTerm.get(i)+ " = " +FOLLOW[i]);
    }
    
    public static void getFollowTerminal(String NT,String prodn)
    {
        if(prodn.indexOf("|") == -1)
        {
            if(prodn.indexOf(NT)!= prodn.length()-1 && prodn.indexOf(NT) != -1)
            {
                if(prodn.charAt(prodn.indexOf(NT)+1) >= 'a' && prodn.charAt(prodn.indexOf(NT)+1) <= 'z')
                {
                    temp = temp.concat(Character.toString(prodn.charAt(prodn.indexOf(NT)+1)));
                }
                else
                {
                    int index = prodn.indexOf(NT) + 1;
                    String followNT = Character.toString(prodn.charAt(index));
                    temp = temp.concat(FIRST[nonTerm.indexOf(followNT)]);
                }
            }
            else if(prodn.indexOf(NT) != -1)
            {
                int index = prod.indexOf(prodn);
                temp = temp.concat(FOLLOW[index]);
            }
        }
        else
        {
            getFollowTerminal(NT,prodn.substring(0,prodn.indexOf("|")));
            getFollowTerminal(NT,prodn.substring(prodn.indexOf("|")+1,prodn.length()));
        }
    }
}
