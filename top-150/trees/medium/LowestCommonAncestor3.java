// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/

class LowestCommonAncestor3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet<>();
        while (p != null) {
            seen.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (seen.contains(q)) {
                return q;
            }
            q = q.parent;
        }

        return null;
    }
}
