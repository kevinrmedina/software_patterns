//Concrete Creator for Attr DOM

package edu.jhu.apl.patterns_class.dom.DOMCreator;

import edu.jhu.apl.patterns_class.dom.Attr;
import edu.jhu.apl.patterns_class.dom.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class AttrCreator{
    public Node createDOM(String tagName, Document document){
        return new Attr(tagName, document);
    }
    public Node createDOM(String tagName, String value, Document document){
        return new Attr(tagName, value, document);
    }
}
