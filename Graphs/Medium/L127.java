package Graphs.Medium;

// 127. Word Ladder

import java.util.*;

public class L127 {

    class Pair{
        String word;
        int sequence;
        Pair(String word, int sequence){
            this.word = word;
            this.sequence = sequence;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int step = p.sequence;
            if (word.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] newWord = word.toCharArray();
                    newWord[i] = ch;
                    String replacedString = new String(newWord);
                    if (set.contains(replacedString)) {
                        set.remove(replacedString);
                        q.add(new Pair(replacedString, step + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        L127 obj = new L127();
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }
}

// Time Complexity: O(N * M * 26)
// Where N = size of wordList Array and M = word length of words present in the wordList..
// Note that, hashing operations in an unordered set takes O(1) time, but if you want to use set here, then the time complexity would increase by a factor of log(N) as hashing operations in a set take O(log(N)) time.
// Space Complexity:  O( N ) { for creating an unordered set and copying all values from wordList into it }
// Where N = size of wordList Array.