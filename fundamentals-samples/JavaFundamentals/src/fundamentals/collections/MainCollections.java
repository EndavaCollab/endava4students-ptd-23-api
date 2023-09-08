package fundamentals.collections;

import java.util.*;

public class MainCollections {

    public static void main(String[] args) {
        listDefinition();
        setDefinition();
        mapDefinition();
    }

    //    List
    public static void listDefinition() {

//        List<String> namesList = new LinkedList<>();
        List<String> namesList = new ArrayList<>();

        // adaugam un element in lista
        namesList.add("John");
        namesList.add("Michel");
        namesList.add("Ana");
        namesList.add("Maria");
        namesList.add("Robert");

        for(int i = 0; i < namesList.size(); i++) {
            String element  = namesList.get(i);

            System.out.println(element);
        }

        System.out.println("----------");

        for(String element: namesList) {
            System.out.println(element);
        }

        System.out.println("----------");

        namesList.set(0, "Daniel");
    }

    //    Set
    public static void setDefinition() {
        Set<String> namesSet = new HashSet<>();

        namesSet.add("Andrei");
        namesSet.add("Ana");
        namesSet.add("Ana");
        namesSet.add("Ana");

        for(String name : namesSet) {
            System.out.println(name + " to hashCode => " + name.hashCode());
        }

        namesSet.remove("Ana");

        namesSet.clear();

        Set<String> namesTreeSet = new TreeSet<>();
        namesTreeSet.add("Ana");
        namesTreeSet.remove("Ana");
    }

    //    Map
    public static void mapDefinition() {
        Map<String, String> dictionaryMap = new HashMap<>();

        dictionaryMap.put("car", "car vehicle");
        dictionaryMap.put("car", "car with 4 or 2 doors");
        dictionaryMap.put("truck", "use for transport");
        dictionaryMap.put("bike", "use for sport");

        Iterator<Map.Entry<String, String>> iteratorMap = dictionaryMap.entrySet().iterator();

        while(iteratorMap.hasNext()) {
            Map.Entry<String, String> entry = iteratorMap.next();

            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


    }
}
