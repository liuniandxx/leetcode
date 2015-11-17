import sun.text.normalizer.Trie;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liunian on 15-11-6.
 */
public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() <= 0 || search(word)) {
            return;
        }
        TrieNode nextNode = root;
        int index = 0;
        for(index = 0; index < word.length(); index++) {
            TrieNode tmp = nextNode.getMeachChild(word.charAt(index));
            if(tmp == null) {
                break;
            } else {
                nextNode = tmp;
            }
        }

        if(index == word.length()) {
            nextNode.setIsLeaf(true);
        } else {
            while (index < word.length()) {
                TrieNode child = new TrieNode(word.charAt(index));
                index++;
                if(nextNode.getChilds() == null) {
                    List<TrieNode> childs = new ArrayList<TrieNode>();
                    childs.add(child);
                    nextNode.setChilds(childs);
                } else {
                    nextNode.getChilds().add(child);
                }
                nextNode = child;
            }
            nextNode.setIsLeaf(true);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() <= 0) {
            return true;
        }
        int index = 0;
        TrieNode nextNode = root;
        for(index = 0; index < word.length(); index++) {
            nextNode = nextNode.getMeachChild(word.charAt(index));
            if(nextNode == null) {
                break;
            }
        }

        if(nextNode!= null && nextNode.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() <= 0) {
            return true;
        }
        int index = 0;
        TrieNode nextNode = root;
        for(index = 0; index < prefix.length(); index++) {
            nextNode = nextNode.getMeachChild(prefix.charAt(index));
            if(nextNode == null) {
                break;
            }
        }

        if(nextNode!= null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        trie.insert("abcd");
        System.out.println(trie.startsWith("ab"));
    }

    public TrieNode getRoot() { return root; }
}
