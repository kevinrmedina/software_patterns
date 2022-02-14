package edu.jhu.apl.patterns_class.dom;

public class Attr extends Node implements edu.jhu.apl.patterns_class.dom.replacement.Attr
{

	private edu.jhu.apl.patterns_class.dom.replacement.Node parent = null;

	Attr(String tagName, Document document, edu.jhu.apl.patterns_class.dom.replacement.Node parent)
	{
		super(tagName, org.w3c.dom.Node.ATTRIBUTE_NODE);
		this.document	= document;
		this.parent = parent;
	}

	Attr(String tagName, String value, Document document, edu.jhu.apl.patterns_class.dom.replacement.Node parent)
	{
		super(tagName, org.w3c.dom.Node.ATTRIBUTE_NODE);
		this.document	= document;
		this.parent = parent;
		setValue(value);
	}

	//
	// Implemented Attr members.
	//
	public String getName()
	{
		return getNodeName();
	}
	public String getValue()
	{
		return getNodeValue();
	}
	public void setValue(String value)
	{
		// TODO:  Check for readonly status.  NO_MODIFICATION_ALLOWED_ERR

		setNodeValue(value);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Element getOwnerElement()
	{
		return (Element )getParentNode();
	}

	//
	// Unimplemented Attr members.
	//
	public boolean getSpecified()	{ return true; }
	public boolean isId()		{ return false; }
	public org.w3c.dom.TypeInfo getSchemaTypeInfo() { return null; }

	public edu.jhu.apl.patterns_class.dom.replacement.Node getNext(){
		return null;
	}

	public boolean hasNext(){
		return false;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node getPrevious(){
		return this.parent;
	}

	public boolean hasPrevious(){
		return true;
	}
}
