package edu.jhu.apl.patterns_class.dom.iterator;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{

    private int currentPosition = 0;
    private List<Node> domList = new ArrayList<>();
    private Node dom;

    public ConcreteIterator (Node dom) {
        this.dom = dom;
    }

    @Override
    public Node getNext() {
        currentPosition++;
        return domList.get(currentPosition - 1);
    }

    @Override
    public boolean hasNext() {
        return domList.get(currentPosition).hasNext();
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }

    public void addDOM(Node dom){
        domList.add(dom);
    }

}
