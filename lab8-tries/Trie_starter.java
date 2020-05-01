public class Tries {
	

	public static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;
		public TrieNode() {
			isEndOfWord = false;
			for(int i=0; i<26; i++) {
				children[i] = null;
			}
		}
	}

	static TrieNode root;

	public static void insert(String key) {

		TrieNode searcher = root;
		int index;

		for (int i = 0; i < key.length(); i++) {

			index = key.charAt(i) - 'a';

			if (searcher.children[index] == null)
				searcher.children[index] = new TrieNode();

			searcher = searcher.children[index];

		}

		searcher.isEndOfWord = true;

	}

	public static boolean search(String key) {

		TrieNode searcher = root;
		int index;

		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';

			if (searcher.children[index] == null)
				return false;

			searcher = searcher.children[index];
		}

		if (searcher != null && searcher.isEndOfWord == true) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		String[] keys = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

		String[] output = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		int i;
		for (i = 0; i < keys.length; i++) {
			insert(keys[i]);
		}
		
		if(search("back") == true)
			System.out.println("far: " + output[1]);
			else
				System.out.println("far: " + output[0]);
		
		if (search("bank") == true)
			System.out.println("bank: " + output[1]);
		else
			System.out.println("bank: " + output[0]);
		
		if(search("simple") == true)
			System.out.println("simple: " + output[1]);
			else
				System.out.println("simple: " + output[0]);

		
	}
}