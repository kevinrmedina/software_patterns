package edu.jhu.apl.patterns_class.dom.decorators;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class DOMSourceDecorator implements DOMSource{


    java.util.Vector<ValidChildren>	schema	= new java.util.Vector<>();
    private DOMSource wrappee;
    //public boolean validity;
    public Node dom;
    public String text;

    public ValidChildren findSchemaElement(String element)
    {
        for (int i = 0; i < schema.size(); i++)
            if ((schema.elementAt(i).getThisElement() == null && element == null) ||
                    (schema.elementAt(i).getThisElement()!=null && schema.elementAt(i).getThisElement().compareTo(element)==0))
                return schema.elementAt(i);

        return null;
    }
    @Override
    public boolean canAdd() {
        if(this.wrappee != null)
            return this.wrappee.canAdd();
        else
            return true;
    }

//    @Override
//    public boolean canAdd(boolean validity, Node element, String newElement) {
//        this.validity = validity;
//        return this.wrappee.canAdd(this.validity, t, newElement);
//    }

    DOMSourceDecorator(DOMSource source, Node dom, String text){
        this.wrappee = source;
        this.dom = dom;
        this.text = text;
    }
    DOMSourceDecorator(Node dom, String text){
        this.dom = dom;
        this.text = text;
    }

    DOMSourceDecorator(Node dom){
        this.dom = dom;
    }
}

class ValidChildren
{
    private String				thisElement		= null;	// A value of null represents Document.
    private java.util.Vector<String>	validChildren		= new java.util.Vector<String>();
    private java.util.Vector<Boolean>	childIsAttribute	= new java.util.Vector<Boolean>();
    private boolean				_canHaveText		= false;

    public ValidChildren(String thisElement)		{ this.thisElement = thisElement; }

    public String	getThisElement()			{ return thisElement; }
    public boolean	canHaveText()				{ return _canHaveText; }
    public void	setCanHaveText(boolean _canHaveText)	{ this._canHaveText = _canHaveText; }

    public void	addValidChild(String child, boolean isAttribute)
    {
        if (childIsValid(child, isAttribute))
            return;

        validChildren.add(child);
        childIsAttribute.add(new Boolean(isAttribute));
    }

    public boolean	childIsValid(String child, boolean isAttribute)
    {
        for (int i = 0; i < validChildren.size(); i++)
            if (childIsAttribute.elementAt(i).booleanValue() == isAttribute &&
                    validChildren.elementAt(i).compareTo(child) == 0)
                return true;

        return false;
    }
}