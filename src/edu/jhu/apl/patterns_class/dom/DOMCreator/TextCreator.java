package edu.jhu.apl.patterns_class.dom.DOMCreator;

import edu.jhu.apl.patterns_class.dom.Document;
import edu.jhu.apl.patterns_class.dom.Text;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class TextCreator{
    public Node createDOM(String value, Document document){
        return new Text(value, document);
    }
}