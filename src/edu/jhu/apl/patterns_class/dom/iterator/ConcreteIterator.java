package edu.jhu.apl.patterns_class.dom.iterator;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{

    public int currentPosition = 0;
    //private List<Node> domList = new ArrayList<>();
    public Node dom;

    public ConcreteIterator (Node dom) {
        this.dom = dom;
    }

    @Override
    public Node getNext() {
        //currentPosition++;
        return dom.getNext();
    }

    @Override
    public boolean hasNext() {
        return dom.hasNext();
    }

    public boolean hasPrevious(){
        return dom.hasPrevious();
    }

    public Node getPrevious(){
        return dom.getPrevious();
    }

//    @Override
//    public void reset() {
//        currentPosition = 0;
//    }

//    public void addDOM(Node dom){
//        dom.add(dom);
//    }

}
