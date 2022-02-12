////////////////////////////////////////////////////////////////////////////
// Concrete Decorator for Validating if Elements can be added
////////////////////////////////////////////////////////////////////////////

package edu.jhu.apl.patterns_class.dom.decorators;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class CanAddElementDecorator extends DOMSourceDecorator{

    public CanAddElementDecorator(DOMSource source, Node dom, String text) {
        super(source, dom, text);
    }
    public CanAddElementDecorator(Node dom, String text) {
        super(dom, text);
    }


    public boolean canAdd(){
        ValidChildren schemaElement = findSchemaElement(dom == null ? null : dom.getTagName());
        if((schemaElement == null ? true : schemaElement.childIsValid(text, false))){
            return super.canAdd();
        }
        else{
            System.out.println("Attempted invalid schema operation.");
            System.exit(0);
            return false;
        }
    }

}
