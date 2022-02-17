package edu.jhu.apl.patterns_class.dom.iterator;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public interface Iterator {
    Node getNext();
    boolean hasNext();
    //void reset();
}
