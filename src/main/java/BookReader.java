
import java.io.File;
import java.util.*;

public class BookReader {


    public static void main(String[] args) throws Exception {

        File file = new File("/Users/asia/Desktop/szekspir.txt");

        Scanner scanner = new Scanner(file);

        Map<String, Integer> szekspirWords = new HashMap<>();

        while (scanner.hasNext()) {
            scanner.useDelimiter("\\W+");
            String word = scanner.next().toLowerCase();
            Integer count = szekspirWords.get(word);

            if (count == null) {
                szekspirWords.put(word, 1);
            } else {
                szekspirWords.put(word, count + 1);
            }
        }


        List<Map.Entry<String, Integer>> list1 = sortedList(szekspirWords);

        HashMap<String, Integer> sortedMapByValues = getSortedMap(list1);

        System.out.println("Sorted words of book:");
        for (Map.Entry mp : sortedMapByValues.entrySet()
                ) {
            System.out.println("word: " + mp.getKey() +
                    " : " + mp.getValue());

        }


    }

    private static HashMap<String, Integer> getSortedMap(List<Map.Entry<String, Integer>> list1) {
        HashMap<String, Integer> sortedMapByValues = new LinkedHashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            sortedMapByValues.put(list1.get(i).getKey(), list1.get(i).getValue());
        }
        return sortedMapByValues;
    }

    private static List<Map.Entry<String, Integer>> sortedList(Map<String, Integer> szekspirWords) {
        List<Map.Entry<String, Integer>> list = new LinkedList(szekspirWords.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o2, Map.Entry<String, Integer> o1) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }
}


