package edu.jhu.apl.patterns_class.dom.DOMCreator;

import edu.jhu.apl.patterns_class.dom.Node;

public class NodeCreator{
    public Node createDOM(String name, short type){
        return new Node(name, type);
    }
}
