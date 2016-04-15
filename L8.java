/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l8;

/**
 *
 * @author hrehman.bscs13seecs
 */

public class L8 {

    /**
     * @param args the command line arguments
     */
    private static int[] coins = new int[4];

    /**
     *
     */
    public L8()
    {
        coins = new int[]{1,5,10,25};
    }
     static int greedy_c_change(int amount)
    {
        int newAmount=amount;
        int sum=0;
        int i=coins.length-1;
        while(newAmount!=0)
        {
            if(coins[i]>newAmount)
            {
                i--;
                continue;
            }
            
            System.out.println(coins[i]);
            newAmount=newAmount-coins[i];
            sum++;
        }
        return sum;
    }
      static int dynamic_c_change(int amount)
    {
        int[] C = new int[amount+1];
        int[] denom = new int[amount+1];

        C[0]=0;
        for (int j = 1 ;j<=amount ;j++)
        {
            C[j] = -1;
            for (int i=1; i<coins.length; i++)
            {
                int j1= j-coins[i];
                if(j >= coins[i] && (1 +C[j1] < C[j]))
                 {
                     C[j] = 1 +C[j1];
                     denom[j] = coins[i];
                 }
            }
        }
    return C[amount];
    }
    public static void main(String[] args)
    {
        L8 object = new L8();
        int greedy_count=object.greedy_c_change(29);
        System.out.println("Greedy Solution says  "+greedy_count+"  coins are required.");
        int dynamic_count;
        dynamic_count = L8.dynamic_c_change(29);
        System.out.println("Dynamic Solution says  "+dynamic_count+" coins are required.");
    }
    
}
