package edu.jhu.apl.patterns_class.dom.decorators;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class CanAddText extends DOMSourceDecorator{
    public CanAddText(Node dom) {
        super(dom);
    }

    public boolean canAdd(){
        ValidChildren schemaElement	= findSchemaElement(dom.getTagName());
        if(schemaElement == null ? true : schemaElement.canHaveText()){
            return super.canAdd();
        }
        else{
            System.out.println("Attempted invalid schema operation.");
            System.exit(0);
            return false;
        }
    }
}
