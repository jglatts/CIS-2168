package mapreduce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Reducer {

   public HashMap<String, Integer> reduce(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
      // YOUR CODE HERE
      HashMap<String, Integer> newHash = new HashMap<>();
      for (String key : map1.keySet()) {
          if (map2.containsKey(key)) newHash.put(key, map1.get(key) + map2.get(key));
          else newHash.put(key, map1.get(key));
      }
      for (String key : map2.keySet()) {
          if (!newHash.containsKey(key)) newHash.put(key, map2.get(key));
      }      
      return newHash; // <- change this line to return the hash map
   }

   public static void main(String[] args) {
      Mapper mapper1 = new Mapper("big1.txt");
      //Mapper mapper1 = new Mapper("tale1.txt");
      HashMap<String, Integer> map1 = mapper1.getWordcount();
      System.out.println(map1);

      Mapper mapper2 = new Mapper("big2.txt");
      //Mapper mapper2 = new Mapper("tale2.txt");
      HashMap<String, Integer> map2 = mapper2.getWordcount();
      System.out.println(map2);

      HashMap<String, Integer> map = new Reducer().reduce(map1, map2);
       //System.out.println(map);
       // System.out.println(new Mapper("tinyTale.txt").getWordcount());
       ArrayList<String> list = new ArrayList<>(map.keySet());
       Collections.sort(list);
       list.forEach((key) -> {
           System.out.println(key + " - " + map.get(key));
       });
   }
}
