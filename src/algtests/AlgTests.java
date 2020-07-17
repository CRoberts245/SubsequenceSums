//Cameron Roberts
//Prof. Salloum
//Prog1
//Algorithms
 package algtests;
import java.util.Random; 




public class AlgTests {

 
   public static void main(String[] args) {
        Random rand = new Random(); 
        int [] b;
        long [] times = new long[4];
        int totalSize = 10000000;
        b = new int[totalSize];
        for(int i = 0; i < totalSize; i++){
            int randInt = rand.nextInt(100+100)-100;
            b[i]=randInt;
        }


            
        //TIMING BLOCK

        //timing alg 1
        System.out.println("BOUNDARY INDICES");
        System.out.println("-------------------");
//        long Start= System.nanoTime();
//        int sum1 = maxSubSum1(b);
//        long End= System.nanoTime();
//        long CPUTime=End-Start;
//        times[0] = CPUTime;
        //timing alg 2
//        long Start= System.nanoTime();
//        int sum2 = maxSubSum2(b);
//        long End= System.nanoTime();
//        long CPUTime=End-Start;
//        times[1] = CPUTime;
        //timing alg 4
        long Start= System.nanoTime();
        int sum4 = maxSubSum4(b);
        long End= System.nanoTime();
        long CPUTime=End-Start;
        times[3] = CPUTime;
        //timing alg 3
        Start= System.nanoTime();
        int sum3 = maxSubSum3(b, 0, b.length-1);
        End= System.nanoTime();
        CPUTime=End-Start;
        times[2] = CPUTime;
        
       
        

       System.out.println("NANOTIME");
       System.out.println("-------------------");
       for(int i = 0; i < 4; i++){
            System.out.println(times[i]);
        }



        System.out.println("MAX SUBSEQUENCE SUM");
        System.out.println("-------------------");
       // System.out.println(sum1);
//        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
   }



    //algorithm 1 n^3
    static int maxSubSum1(int[] a){
        int maxSum = 0;
        int boundary1 = 0;
        int boundary2 = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i; j <= a.length-1; j++){

            int currentSum = 0;
             for(int k = i; k <= j; k++){
                currentSum +=a[k];

                if(currentSum > maxSum){
                    boundary1 = i;
                    boundary2 = j;
                    maxSum = currentSum;
                }

            }

         }

        }

        System.out.print(boundary1);
        System.out.print(" ");
        System.out.println(boundary2);
        return maxSum;
    }



    //algorithm 2 n^2
    static int maxSubSum2(int[] a ){
        int boundary1 = 0;
        int boundary2 = 0;
        int maxSum = 0;

        int counter = 0;
        int maxCounter = 0;
        for( int i = 0; i < a.length; i++ ){
           int thisSum = 0;
           
           
           for( int j = i; j < a.length; j++ ){
               thisSum += a[j];
               counter = counter+1;
               if (maxCounter < counter && thisSum > maxSum){
                 maxCounter = counter;
               }
               if( thisSum > maxSum )
                   maxSum = thisSum;
                   
                 
               if(maxCounter == counter){
                   boundary2 = j;
                   boundary1 = j-(j-i);
               }    
                   
           }
        }
        
        System.out.print(boundary1);
        System.out.print(" ");
        System.out.println(boundary2);
        return maxSum;
    } 





    //algorithm 3
    static int maxSubSum3(int[] a, int left, int right){
        
        if(left == right){ //base
            if(a[left]>0){
             return a[left];
            }
            else{
             return 0;
            }
        }
        //calc  max left right sum
        int center = (left + right)/2;

        int maxLeftSum = maxSubSum3(a,left,center);
        
        int maxRightSum = maxSubSum3(a,center+1,right);



        //calc left borderSum
        int maxLeftBorderSum = Integer.MIN_VALUE;
        int leftBorderSum = 0;

        for(int i = center; i >= left; i--){
            
            leftBorderSum += a[i];
            
            if(leftBorderSum>maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;

            }
            
        }

        //calc right max border sum
        int maxRightBorderSum = Integer.MIN_VALUE;
        int rightBorderSum = 0;
        for(int i = center+1; i <= right; i++){

            rightBorderSum += a[i];
           
          
            if(rightBorderSum>maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }

        }
        
        if(maxRightBorderSum+maxLeftBorderSum > maxLeftSum && maxRightBorderSum+maxLeftBorderSum > maxRightSum){
            
            
            return maxRightBorderSum+maxLeftBorderSum;
            
        }
        else if(maxLeftSum > maxRightBorderSum+maxLeftBorderSum && maxLeftSum > maxRightSum){
           
            return maxLeftSum;
        }
        else if(maxRightSum > maxRightBorderSum+maxLeftBorderSum && maxRightSum > maxLeftSum){

            return maxRightSum;
        }
     
     return 0;
    }




    //algorithm 4
    static int maxSubSum4(int[] a){

        int maxSum = 0;
        int currentSum = 0;
        int counter = 0;
        int boundary1 = 0;
        int maxCounter = 0;
        for(int i = 0; i< a.length; i++){

            currentSum += a[i];
            counter = counter+1;
            if (maxCounter < counter && currentSum> maxSum){
                maxCounter = counter;
            }
            if(currentSum>maxSum){
                maxSum = currentSum;

                boundary1 = i;
                
            }
            else if(currentSum < 0){
                currentSum = 0;
                counter = 0;
            }
        }
       
        int boundary2 = boundary1 - maxCounter;
        
        System.out.print(boundary2+1);
        System.out.print(" ");
        System.out.println(boundary1);
        return maxSum;
    }

}


