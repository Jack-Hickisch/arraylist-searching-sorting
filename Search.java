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

    public static int binarySearch(ArrayList<String> haystack, String needle)
    {
        int index = -1;
        boolean cantDivide = false;
        int division = haystack.size();
        int start = 0;
        while (!cantDivide)
        {
            if (division >= 1)
            {
                index = (haystack.get((division / 2) + start).equals(needle)) ? (division / 2) + start : index; // is the middle one it?
                // System.out.println("div: " + division);
                // System.out.println("strt: " + start);
                // System.out.println(haystack.get(division / 2));
                if (isBeforeNeedle(haystack.get(division / 2), needle))
                {
                    division /= 2;
                    start += 0; // dont need to shift frame
                }

                else if (!isBeforeNeedle(haystack.get(division / 2), needle))
                {
                    division /= 2;
                    start += division; // need to shift frame
                }
            }
            else if (division == 0) // could be off by up to 2 away from start since even numbers mess it up
            {
                if (haystack.get(start).equals(needle))
                return start;
                if (haystack.get(start + 1).equals(needle))
                return start + 1;
                if (haystack.get(start - 1).equals(needle))
                return start - 1;
                if (haystack.get(start + 2).equals(needle))
                return start + 2;
                if (haystack.get(start - 2).equals(needle))
                return start - 2;
                cantDivide = true;
            }
            else
            {
                cantDivide = true;
            }
        }

        return index;
    }

    public static boolean isBeforeNeedle(String test, String needle) // 2 words
    {
        boolean before = false;
        boolean done = false;

        for (int i = 0; i < test.length() - 1; i++)
        {
            if (!done && positionOfLetter(test.substring(i, i + 1), needle.substring(i, i + 1)) == 1)
            {
                done = true;
                before = true;
            }
            if (!done && positionOfLetter(test.substring(i, i + 1), needle.substring(i, i + 1)) == -1)
            {
                done = true;
                before = false;
            }
        }

        return before;
    }

    public static int positionOfLetter(String testLetter, String needleLetter) // -1 = before, 0 = same, 1 = after
    {
        String[] alphabet = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        // nothing comes before something so "" is inclded
        int foundtest = -1;
        int foundneedle = -1;

        for (int i = 0; i < alphabet.length; i++)
        {
            foundtest = (alphabet[i].equals(testLetter)) ? i : foundtest;
            foundneedle = (alphabet[i].equals(needleLetter)) ? i : foundneedle;
        }

        if (foundtest < foundneedle)
        return -1;
        if (foundtest > foundneedle)
        return 1;

        return 0;
    }

    public static void main(String[] args)
    {
        ArrayList<String> fruits = new ArrayList<String>( 
            Arrays.asList("apple", "banana", "banana", "cherry", "lemon", "lime", "mango", "orange", "pear", "strawberry", "watermelon"));

        System.out.println(search(fruits, "cherry"));
        System.out.println(search(fruits, "watermelon"));
        System.out.println(search(fruits, "blueberry"));
        
        System.out.println("");

        System.out.println(binarySearch(fruits, "apple"));
        System.out.println(binarySearch(fruits, "banana"));
        System.out.println(binarySearch(fruits, "cherry"));
        System.out.println(binarySearch(fruits, "lemon"));
        System.out.println(binarySearch(fruits, "lime"));
        System.out.println(binarySearch(fruits, "mango"));
        System.out.println(binarySearch(fruits, "orange"));
        System.out.println(binarySearch(fruits, "pear"));
        System.out.println(binarySearch(fruits, "strawberry"));
        System.out.println(binarySearch(fruits, "watermelon"));
        System.out.println(binarySearch(fruits, "blueberry"));
    }
}