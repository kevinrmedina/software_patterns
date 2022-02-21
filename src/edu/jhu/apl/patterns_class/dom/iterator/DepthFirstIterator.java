// Concrete Iterator for Depth First Iteration

package edu.jhu.apl.patterns_class.dom.iterator;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class DepthFirstIterator implements Iterator{
    
    public Node currentNode = null;
    private Node nextNode = null;

    public DepthFirstIterator(Node domTree) {
        this.currentNode = domTree;
    }

    public Node getNext(){
        if (this.currentNode.hasNext()){
            this.nextNode = this.currentNode.getNext();
            this.currentNode = this.nextNode;
            return this.nextNode;
        }
       else if (this.currentNode.hasPrevious()){
            this.currentNode = this.getPrevious();
            this.currentNode = this.getNext();
           return this.currentNode;
        }
       else{
           return null;
        }

    }

    public boolean hasNext() {
        return this.currentNode.hasNext();
    }

    public boolean hasPrevious(){
        return this.currentNode.hasPrevious();
    }

    public Node getPrevious(){
        this.nextNode = this.currentNode.getPrevious();
        this.currentNode = this.nextNode;
        return nextNode;
    }

}

