package edu.jhu.apl.patterns_class.dom.DOMCreator;

import edu.jhu.apl.patterns_class.dom.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class DocumentCreator{
    public Node createDOM(){
        return new Document();
    }
}
