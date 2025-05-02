package tree;

public class Node {
	private int count = 0; // number of times a word ends at this node
	private Node[] children = new Node['z' - 'a' + 1]; // 26 lowercase letters

	// returns the count of how many times the given word was added
	public int num(String s) {
		int index = s.charAt(0) - 'a';

		if (children[index] == null) return 0;

		if (s.length() == 1) {
			return children[index].count;
		} else {
			return children[index].num(s.substring(1));
		}
	}

	// adds the given word to the trie by creating nodes along the path
	public void add(String s) {
		if (!s.isEmpty()) {
			int index = s.charAt(0) - 'a';

			if (children[index] == null)
				children[index] = new Node();

			if (s.length() == 1) {
				children[index].count++;
			} else {
				children[index].add(s.substring(1));
			}
		}
	}
}
