import java.util.*;

public class Sort
{
    public static int selectionSort(ArrayList<String> list)
    {
        int checksCount = 0;
        int startIndex = 0;
        int smallestIndex = 0;

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = startIndex; j < list.size(); j++)
            {
                if (isBeforeNeedle(list.get(smallestIndex), list.get(j)))
                {
                    smallestIndex = j;
                }
                checksCount++;
            }

            Collections.swap(list, i, smallestIndex);
            startIndex++;
            smallestIndex = startIndex;
        }

        return checksCount;
    }

    public static int insertionSort(ArrayList<String> list)
    {
        int checksCount = 0;
        int elementsOn = 2;
        boolean inOrder = false;

        while (elementsOn != list.size())
        {
            while (!inOrder)
            {
                inOrder = true;
                for (int i = 0; i < elementsOn; i++)
                {
                    if (isBeforeNeedle(list.get(i), list.get(i + 1)))
                    {
                        Collections.swap(list, i, i + 1);
                        inOrder = false;
                    }
                    checksCount++;
                }
            }
            elementsOn++;
            inOrder = false;           
        }
        return checksCount;
    }

    public static int bubbleSort(ArrayList<String> list)
    {
        int checksCount = 0;
        int swapCount = 1; // cant be 0 or else loop wont start

        while (swapCount != 0)
        {
            swapCount = 0;
            for (int i = 0; i < list.size() - 1; i++)
            {
                if (isBeforeNeedle(list.get(i), list.get(i + 1)))
                {
                    Collections.swap(list, i, i + 1);
                    swapCount++;
                }
                checksCount++;
            }
        }
        return checksCount;
    }

    public static boolean isBeforeNeedle(String test, String needle) // 2 words
    {
        boolean before = false;
        boolean done = false;

        for (int i = 0; i < test.length(); i++)
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
        // ArrayList<String> fruits0 = new ArrayList<String>(Arrays.asList("mango", "banana", "strawberry", "cherry", "lime", "pear", "apple", "watermelon", "lemon", "blueberry", "orange"));
        // ArrayList<String> fruits1 = new ArrayList<String>(Arrays.asList("mango", "banana", "strawberry", "cherry", "lime", "pear", "apple", "watermelon", "lemon", "blueberry", "orange"));
        // ArrayList<String> fruits2 = new ArrayList<String>(Arrays.asList("mango", "banana", "strawberry", "cherry", "lime", "pear", "apple", "watermelon", "lemon", "blueberry", "orange"));

        // selectionSort(fruits0);
        // System.out.println(fruits0.toString());

        // insertionSort(fruits1);
        // System.out.println(fruits1.toString());

        // bubbleSort(fruits2);
        // System.out.println(fruits2.toString());

        // ArrayList<String> fruits20 = new ArrayList<String>(Arrays.asList("pear", "banana", "raspberry", "apple", "lime", "mango", "apricot", "watermelon", "lemon", "blueberry", "blueberry"));
        // ArrayList<String> fruits21 = new ArrayList<String>(Arrays.asList("pear", "banana", "raspberry", "apple", "lime", "mango", "apricot", "watermelon", "lemon", "blueberry", "blueberry"));
        // ArrayList<String> fruits22 = new ArrayList<String>(Arrays.asList("pear", "banana", "raspberry", "apple", "lime", "mango", "apricot", "watermelon", "lemon", "blueberry", "blueberry"));

        // selectionSort(fruits20);
        // System.out.println(fruits20.toString());

        // insertionSort(fruits21);
        // System.out.println(fruits21.toString());

        // bubbleSort(fruits22);
        // System.out.println(fruits22.toString());

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> testForNums = new ArrayList<String>();

        for (int i = 0; i < alphabet.length; i++)
        {
            for(int j = 0; j < alphabet.length; j++)
            {
                testForNums.add(alphabet[i] + alphabet[j]);
            }
        }

        Collections.shuffle(testForNums);

        System.out.println("selectionSort checks:    " + selectionSort(testForNums));
        System.out.println("selectionSort list size: " + testForNums.size());

        Collections.shuffle(testForNums);

        // System.out.println("insertionSort checks:    " + insertionSort(testForNums));
        // System.out.println("insertionSort list size: " + testForNums.size());

        // Collections.shuffle(testForNums);

        System.out.println("bubbleSort checks:    " + bubbleSort(testForNums));
        System.out.println("bubbleSort list size: " + testForNums.size());
    }
}