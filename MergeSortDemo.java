import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortDemo  {


static ArrayList<Integer> mergesort (ArrayList<Integer> a, int left, int right) {

ArrayList<Integer> result = new ArrayList<Integer>();

if (left == right) {
   result.add(a.get(right));
   return result;
}

int mid = left + (right - left) / 2;

ArrayList<Integer> resultleft = mergesort(a, left, mid);
ArrayList<Integer> resultright = mergesort(a, mid+1, right);
result = combine(resultleft, resultright);

return result;

}


static ArrayList<Integer> combine(ArrayList<Integer> a, ArrayList<Integer> b) {

ArrayList<Integer> solution = new ArrayList<Integer>();

int i = 0;
int j = 0;

while (i < a.size() && j < b.size()) {

if(a.get(i) < b.get(j)) {

solution.add(a.get(i));
i++;

}

else
{
solution.add(b.get(j));
j++;
}

}

while (i < a.size())
{
solution.add(a.get(i));
i++;
}

while (j < b.size())
{
solution.add(b.get(j));
j++;
}

return solution;
}


public static void main(String[] args) {


ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,-3, 4, 2, 6, 3, 8, 0));
ArrayList<Integer> result = new ArrayList<Integer>();               
                
                System.out.println("The elements in a are: " + a);
                result = mergesort(a,0,7);
                
                System.out.println("Now the elements are: " + result); 

}
}

