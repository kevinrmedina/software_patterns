package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.decorators.CanAddAttributeDecorator;
import edu.jhu.apl.patterns_class.dom.decorators.CanAddElementDecorator;
import edu.jhu.apl.patterns_class.dom.decorators.CanAddTextDecorator;
import edu.jhu.apl.patterns_class.dom.decorators.DOMSourceDecorator;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.io.IOException;

public class XMLValidator
{
	private java.util.Vector<ValidChildren>	schema	= new java.util.Vector<ValidChildren>();

	//
	// Supercedes any existing description for this element.
	//
	public ValidChildren addSchemaElement(String element)
	{
		ValidChildren	schemaElement	= findSchemaElement(element);

		if (schemaElement != null)
			schema.remove(schemaElement);

		schema.add(schemaElement = new ValidChildren(element));
		return schemaElement;
	}

	public ValidChildren findSchemaElement(String element)
	{
		for (int i = 0; i < schema.size(); i++)
			if ((schema.elementAt(i).getThisElement() == null && element == null) ||
			 (schema.elementAt(i).getThisElement()!=null && schema.elementAt(i).getThisElement().compareTo(element)==0))
				return schema.elementAt(i);

		return null;
	}

	public boolean canRootElement(String newElement)
	{
		DOMSourceDecorator checker = new CanAddElementDecorator(null, newElement);
		return checker.canAdd();
	}

	//
	// Optional for schema implementation:
	//
	// public static boolean canValue(edu.jhu.apl.patterns_class.dom.replacement.Attribute attribute, String value)
	// {
	// }

	public static void main(String args[])
	{
		if (args.length < 1)
		{
			System.out.println("No output filenames provided.");
			System.exit(0);
		}

		//
		// Create tree of this document:
		// <? xml version="1.0" encoding="UTF-8"?>
		// <document>
		//   <element attribute="attribute value"/>
		//   <element/>
		//   <element attribute="attribute value" attribute2="attribute2 value">
		//     Element Value
		//   </element>
		//   <element>
		//   </element>
		// </document>
		//
		// Schema for this document:
		// document contains:  element
		// element contains:  element
		// element contains attributes:  attribute, attribute2
		//
		XMLValidator	xmlValidator	= new XMLValidator();
		ValidChildren	schemaElement	= xmlValidator.addSchemaElement(null);
		schemaElement.addValidChild("document", false);
		schemaElement	= xmlValidator.addSchemaElement("document");
		schemaElement.addValidChild("element", false);
		schemaElement	= xmlValidator.addSchemaElement("element");
		schemaElement.addValidChild("element", false);
		schemaElement.addValidChild("attribute", true);
		schemaElement.addValidChild("attribute2", true);
		schemaElement.setCanHaveText(true);
		DOMSourceDecorator checker = null;

		Document	document	=
		  new edu.jhu.apl.patterns_class.dom.Document();
		Node	root		= null;
		Node	child		= null;
		Node		attr		= null;

		if (xmlValidator.canRootElement("document"))
		{
			root	= document.createDOM("element", "document", null);
			document.appendChild(root);
		}
		else {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		child	= document.createDOM("element", "element", null);
		checker = new CanAddElementDecorator(new CanAddAttributeDecorator(child, "attribute"), root, "element");

		if(checker.canAdd())
		{
			attr	= document.createDOM("attr", "attribute", child);
			attr.setValue("attribute value");
			child.setAttributeNode(attr);
		}

		checker = new CanAddElementDecorator(root, "element");

		if (checker.canAdd()){
			child	= document.createDOM("element", "element", null);
			root.appendChild(child);
		}

		child	= document.createDOM("element", "element", null);
		checker = new CanAddElementDecorator(new CanAddAttributeDecorator(new CanAddTextDecorator(child), child, "attribute"), root, "element");

		if(checker.canAdd()){
			child.setAttribute("attribute", "attribute value");
			child.setAttribute("attribute2", "attribute2 value");
			Node text = document.createDOM("text", "Element Value", null);
			child.appendChild(text);
			root.appendChild(child);
		}

		checker = new CanAddElementDecorator(root, "element");

		if(checker.canAdd()){
			child	= document.createDOM("element", "element", null);
			root.appendChild(child);
		}

		//
		// Serialize
		//
		try
		{
			XMLSerializer	xmlSerializer	= new XMLSerializer(args[0]);
			xmlSerializer.serialize("pretty", document, xmlSerializer.writer);
			xmlSerializer.close();
		}
		catch (IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
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
