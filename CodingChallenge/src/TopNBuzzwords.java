import java.util.*;

public class TopNBuzzwords {

    private static List<String> returnTopToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
      Map<String, Integer> map = new HashMap<>();
      Set<String> set = new HashSet<>();

      for(String toy : toys) {
          set.add(toy.toLowerCase());
      }

      for(String quote: quotes) {
          quote = quote.replaceAll("[^A-Za-z ]", "");
          Set<String> seen = new HashSet<>();
          for(String str : quote.split(" ")) {
              if(!set.contains(str.toLowerCase())) {
                  continue;
              }
              if(seen.contains(str.toLowerCase())) {
                  continue;
              }
              seen.add(str.toLowerCase());
              int count = map.getOrDefault(str.toLowerCase(), 0);
              count++;
              map.put(str.toLowerCase(), count);
          }
      }

      // put the counts in a priority queue ordered by count
        PriorityQueue<String> pq = new PriorityQueue<>(topToys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);
                if(count1 != count2) {
                    return count1 - count2;
                }
                return s1.compareTo(s2);
            }
        });

      for(String s : map.keySet()) {
          pq.offer(s);
          if(pq.size() > topToys) {
              pq.poll();
          }
      }

      List<String> result = new ArrayList<>();
      while(!pq.isEmpty()) {
          String s = pq.poll();
          int count = map.get(s);
          result.add(s);
          System.out.println(s + ": " + count);
      }
      Collections.reverse(result);
      return result;
    }

    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 2;
        String[] toys = new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = new String[] {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        List<String> ans = returnTopToys(numToys, topToys, toys, 6, quotes);
        System.out.println(ans);
    }
}
