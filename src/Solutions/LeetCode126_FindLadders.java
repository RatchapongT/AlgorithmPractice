package Solutions;

import java.util.*;

/**
 * Created by JingWen on 4/10/16.
 */

public class LeetCode126_FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        Map<String, List<List<String>>> thisLevel = new HashMap<>();
        Map<String, List<List<String>>> lastLevel = new HashMap<>();

        thisLevel.put(beginWord, new ArrayList<>());
        lastLevel.put(endWord, new ArrayList<>());

        thisLevel.get(beginWord).add(new ArrayList<>());
        lastLevel.get(endWord).add(new ArrayList<>());

        thisLevel.get(beginWord).get(0).add(beginWord);
        lastLevel.get(endWord).get(0).add(endWord);

        wordList.remove(beginWord);
        wordList.remove(endWord);
        List<List<String>> resultList = new ArrayList<>();
        while (thisLevel.size() != 0 && lastLevel.size() != 0) {
            Map<String, List<List<String>>> nextLevel = new HashMap<>();
            Set<String> visited = new HashSet<String>();
            Map<String, List<List<String>>> temp;

            if (lastLevel.size() < thisLevel.size()) {
                temp = thisLevel;
                thisLevel = lastLevel;
                lastLevel = temp;
            }
            boolean getResults = false;
            for (String key : thisLevel.keySet()) {
                char[] charArray = key.toCharArray();
                for (int i = 0; i < key.length(); i++) {
                    char original = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        String queryWord = new String(charArray);
                        if (lastLevel.containsKey(queryWord)) {
                            List<List<String>> list1 = thisLevel.get(key);
                            List<List<String>> list2 = lastLevel.get(queryWord);
                            for (int j = 0; j < list1.size(); j++) {
                                for (int k = 0; k < list2.size(); k++) {
                                    List<String> result = new ArrayList<String>(list1.get(j));
                                    for (int l = list2.get(k).size() - 1; l >= 0; l--) {
                                        result.add(list2.get(k).get(l));
                                    }
                                    if (result.get(0) != beginWord) {
                                        Collections.reverse(result);
                                    }
                                    resultList.add(result);

                                }
                            }
                            getResults = true;
                        } else if (wordList.contains(queryWord) && !getResults) {
                            if (!visited.contains(queryWord)) visited.add(queryWord);
                            if (!nextLevel.containsKey(queryWord)) nextLevel.put(queryWord, new ArrayList<>());
                            for (List<String> list : thisLevel.get(key)) {
                                nextLevel.get(queryWord).add(new ArrayList<>(list));
                                nextLevel.get(queryWord).get(nextLevel.get(queryWord).size() - 1).add(queryWord);
                            }
                        }
                    }
                    charArray[i] = original;
                }
            }
            if (getResults) break;
            wordList.removeAll(visited);
            thisLevel = nextLevel;
        }
        return resultList;
    }
}