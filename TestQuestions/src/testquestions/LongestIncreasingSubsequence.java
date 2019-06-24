/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testquestions;

/**
 *
 * @author pwinzell
 */
public class LongestIncreasingSubsequence {


    public static void longestIncreasingSubSqequence(){

     int intArray[] = {0,2,12,3,2};
    // int intArray[] = {1,2,3,5,7,6,5};
     //int intArray[] = {0,8,10,9,4,11,12};

     //int intArray[] =  {0, 8, 4, 2, 12, 3, 6, 15};


     //int intArray[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

     // int intArray[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13};

     //int intArray[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

    
     System.out.println(lis_1(intArray));
     System.out.println(lis_2(intArray,intArray.length));
    }



    // {0,8,120,9,10,130,11,12};
   public static int _lis(int i,int n, int a[]) {

        //arr holds the last element of the lis, so we need a traversal pointer
        int traverse = i;
        System.out.println( i + " " + n );

        //Find the next array element greater than the current lis
        while(a[traverse] <= a[i] && traverse != n)
        {
            traverse++;
        }

        if (traverse == n) //traversal reached end of the array
        {
            if (a[traverse] > a[i]){
                return 2;
            }
            else{
                return 1;
            }
        }

        return 1 + _lis(traverse,n,a); //look at the rest of the list
    }


   // O()
    public static int lis_1(int a[]){

        int max = 0;
        int temp = 0;

        for(int i = 0; i < a.length; ++i){
            temp = _lis(i, a.length-1,a);
            System.out.println(temp);
            max = (temp > max) ? temp: max;
        }

        return max;
    }

 //  O(n^2)
 public static int lis_2( int arr[], int n )
{
    int lis[] = new int[n];

    lis[0] = 1;

    /* Compute optimized LIS values in bottom up manner */
    for (int i = 1; i < n; i++ )
    {
        lis[i] = 1;
        for (int j = 0; j < i; j++ )
            if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                lis[i] = lis[j] + 1;
    }

    int max = 1;
    for (int i = 0 ; i < lis.length; i++){
        System.out.println(i + " " + lis[i]);
        max = Math.max(max,lis[i]);
    }

    return max;
}
 
 


}
