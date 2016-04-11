package Solutions;

import java.util.*;

/**
 * Created by JingWen on 4/10/16.
 */

public class LeetCode126_FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        Map<String, List<List<String>>> thisLevel = new HashMap<>();
        Map<String, List<List<String>>> lastLevel = new HashMap<>();

        thisLevel.put(beginWord, new LinkedList<>());
        lastLevel.put(endWord, new LinkedList<>());

        thisLevel.get(beginWord).add(Arrays.asList(beginWord));
        lastLevel.get(endWord).add(Arrays.asList(endWord));

        wordList.remove(beginWord);
        wordList.remove(endWord);
        List<List<String>> resultList = new LinkedList<>();
        while (thisLevel.size() != 0) {
            Map<String, List<List<String>>> nextLevel = new HashMap<>();
            Map<String, List<List<String>>> temp;

            if (lastLevel.size() < thisLevel.size()) {
                temp = thisLevel;
                thisLevel = lastLevel;
                lastLevel = temp;
            }
            boolean found = false;
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
                            List<List<String>> tempList;
                            if (list1.get(0).get(0).equals(endWord)) {
                                tempList = list1;
                                list1 = list2;
                                list2 = tempList;
                            }
                            for (List<String> l1 : list1) {
                                for (List<String> l2 : list2) {
                                    List<String> result = new LinkedList<String>(l1);
                                    for (int l = l2.size() - 1; l >= 0; l--) {
                                        result.add(l2.get(l));
                                    }
                                    resultList.add(result);
                                }
                            }
                            found = true;
                        } else if (!found && wordList.contains(queryWord)) {
                            if (!nextLevel.containsKey(queryWord)) {
                                nextLevel.put(queryWord, new LinkedList<>());
                            }
                            for (List<String> list : thisLevel.get(key)) {
                                List<String> newList = new LinkedList<>(list);
                                newList.add(queryWord);
                                nextLevel.get(queryWord).add(newList);
                            }
                        }
                    }
                    charArray[i] = original;
                }
            }
            if (found) break;
            wordList.removeAll(nextLevel.keySet());
            thisLevel = nextLevel;
        }
        return resultList;
    }
}