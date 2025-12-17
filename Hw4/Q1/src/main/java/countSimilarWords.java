      // Method to count similar words of given length

      import java.util.HashSet;
      import java.util.Set;
      public class countSimilarWords {
          public static int countSimilarWords(String str1, String str2, int length) {
              // Split words by whitespace and punctuation
              String[] words1 = str1.split("\\W+");
              String[] words2 = str2.split("\\W+");

              Set<String> set1 = new HashSet<>();

              for (int i = 0; i < words1.length; i++) {
                  String w = words1[i];
                  if (w.length() == length) {
                      set1.add(w.toLowerCase());
                  }
              }

              int count = 0;

              for (int j = 0; j < words2.length; j++) {
                  String w = words2[j];
                  if (w.length() == length && set1.contains(w.toLowerCase())) {
                      count++;
                  }
              }
              return count;
          }

      }
