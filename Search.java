import java.util.*; 

public class Search
{
    public static int search(ArrayList<String> haystack, String needle)
    {
        int index = -1;
        for (int i = 0; i < haystack.size(); i++)
        {
            index = (haystack.get(i).equals(needle)) ? i : index;
        }
        return index;
    }
    public static void main(String[] args)
    {
        //String[] fruits = {"apple", "banana", "banana", "cherry", "lemon", "lime", "mango", "orange", "pear", "strawberry", "watermelon"};
        ArrayList<String> fruits = new ArrayList<String>( 
            Arrays.asList("apple", "banana", "banana", "cherry", "lemon", "lime", "mango", "orange", "pear", "strawberry", "watermelon"));

        System.out.println(search(fruits, "cherry"));
        System.out.println(search(fruits, "watermelon"));
        System.out.println(search(fruits, "blueberry"));
    }
}