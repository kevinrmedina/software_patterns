////////////////////////////////////////////////////////////////////////////
// Concrete Decorator for Validating if Attributes can be added
////////////////////////////////////////////////////////////////////////////

package edu.jhu.apl.patterns_class.dom.decorators;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class CanAddAttributeDecorator extends DOMSourceDecorator{


    public CanAddAttributeDecorator(DOMSource source, Node dom, String text) {
        super(source, dom, text);
    }
    public CanAddAttributeDecorator(Node dom, String text) {
        super(dom, text);
    }

//    @Override
//    public boolean canAdd(boolean validity, Node element, String newAttribute){
//        if(validity){
//            ValidChildren schemaElement = findSchemaElement(element.getTagName());
//            return schemaElement == null ? true : schemaElement.childIsValid(newAttribute, true);
//        }
//        else {
//            System.out.println("Attempted invalid schema operation.");
//            System.exit(0);
//            return false;
//        }
//    }
    @Override
    public boolean canAdd(){
        ValidChildren schemaElement = findSchemaElement(dom.getTagName());
       if (schemaElement == null ? true : schemaElement.childIsValid(text, true)){
           return super.canAdd();
        }
       else{
           System.out.println("Attempted invalid schema operation.");
           System.exit(0);
           return false;
       }
    }

//    public boolean verify(Node element, String newAttribute){
//        ValidChildren schemaElement = findSchemaElement(element.getTagName());
//        return schemaElement == null ? true : schemaElement.childIsValid(newAttribute, true);
//    }
}
