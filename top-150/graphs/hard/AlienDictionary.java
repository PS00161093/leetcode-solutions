// https://leetcode.com/problems/alien-dictionary/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.startsWith(word2) && word1.length() > word2.length()) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            sb.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sb.length() != inDegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
