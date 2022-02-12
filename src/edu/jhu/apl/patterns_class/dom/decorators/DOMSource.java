package edu.jhu.apl.patterns_class.dom.decorators;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public interface DOMSource {
    // canAddText and canAddAttribute alternative canAdd() method
//    boolean canAdd(boolean cont, Node element);
    // canAddElement alternative canAdd() method
//    boolean canAdd(boolean cont, Node element, String newElement);
    boolean canAdd();
}