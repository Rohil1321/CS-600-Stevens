package Def_Pack;

public class Trie {
	
	private TrieNode root;
    /* Constructor */
    public Trie()
    {
        root = new TrieNode(' ');
    }
    /* Function to insert word */

    public void insert(String word)
    {
        if (search(word) == true)
            return;
        TrieNode current = root;
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else
            {
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    /* Function to search for word */
    public boolean search(String word)
    {
        TrieNode current = root;
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }
        if (current.isEnd == true)
            return true;
        return false;
    }

}
