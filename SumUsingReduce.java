import java.util.Arrays;

public class SumUsingReduce {
    public static void main(String[] args) {
        int [] numm={2,3,6,7};
//REDUCE      estused
       int reduce1= Arrays.stream(numm).reduce(0,(a,b)->a+b);
       System.out.println(reduce1);
        int sum=0;
        for(int x:numm){
            sum+=x;


        }
        System.out.println(sum);
    }
}
