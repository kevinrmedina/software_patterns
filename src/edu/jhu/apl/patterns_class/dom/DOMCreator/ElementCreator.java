package edu.jhu.apl.patterns_class.dom.DOMCreator;

import edu.jhu.apl.patterns_class.dom.Document;
import edu.jhu.apl.patterns_class.dom.Element;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class ElementCreator{
    public Node createDOM(String tagName, Document document){
        return new Element(tagName, document);
    }
}
