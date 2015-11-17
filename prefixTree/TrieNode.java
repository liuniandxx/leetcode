import sun.text.normalizer.Trie;

import javax.print.DocFlavor;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liunian on 15-11-6.
 */
public class TrieNode {
    public TrieNode() {}

    public TrieNode(char val) {
        this.val = val;
    }

    private char val;
    private List<TrieNode> childs = null;
    private boolean isLeaf = false;

    public TrieNode getMeachChild(char ch) {
        if(childs == null || childs.size() <= 0) {
            return null;
        }

        for(TrieNode node : childs) {
            if(node.val == ch) {
                return node;
            }
        }
        return null;
    }


    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public List<TrieNode> getChilds() {
        return childs;
    }

    public void setChilds(List<TrieNode> childs) {
        this.childs = childs;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
