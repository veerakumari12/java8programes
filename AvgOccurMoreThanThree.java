import java.util.Arrays;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AvgOccurMoreThanThree {

   public static void main(String args[]) {

     /*  calculate the avg of those numbers
       which occurs more than three in below Array*/
       int[] a ={1, 3, 4, 2, 2, 1, 5, 5, 4, 3, 8 , 7, 1, 1, 2, 2, 1, 2};

      Map<Integer, Long> ap=Arrays.stream(a).boxed().collect(Collectors.groupingBy(x->x,Collectors.counting()));
       OptionalDouble avg1=  ap.entrySet().stream().filter(x->x.getValue()>3).mapToInt(Map.Entry::getKey).average();

       OptionalDouble avg=    Arrays.stream(a).boxed()
               .collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet()
               .stream().filter(x->x.getValue()>=3).mapToInt(Map.Entry::getKey).average();
if(avg.isPresent()){
    System.out.println("Average of numbers occurring more than 3 times: " + avg.getAsDouble());
}

       if(avg1.isPresent()){
           System.out.println("Average of numbers occurring more than 3 times: " + avg1.getAsDouble());
       }



    }

    }


