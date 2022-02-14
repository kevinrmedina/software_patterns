////////////////////////////////////////////////////////////////////////////////
// Creator class for different the DOM objects (Elements, Texts, Attributes)
////////////////////////////////////////////////////////////////////////////////

package edu.jhu.apl.patterns_class.dom;

public class Document extends Node implements edu.jhu.apl.patterns_class.dom.replacement.Document
{
	public Document()
	{
		super(null, org.w3c.dom.Node.DOCUMENT_NODE);
		document	= this;
	}


// Replaces the individual create functions, this acts as the Creator functions
	public edu.jhu.apl.patterns_class.dom.replacement.Node createDOM(String domType, String str, edu.jhu.apl.patterns_class.dom.replacement.Node parent){
		if(domType.equals("element")){
			return new Element(str, this);
		}
		else if (domType.equals("text")){
			return new Text(str, this);
		}
		else if (domType.equals("attr")){
			return new Attr(str, this, parent);
		}
		else
			return null;

	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node createDOM(String domType, String str, Document doc, edu.jhu.apl.patterns_class.dom.replacement.Node parent){
		if(domType.equals("element")){
			return new Element(str, doc);
		}
		else if (domType.equals("text")){
			return new Text(str, doc);
		}
		else if (domType.equals("attr")){
			return new Attr(str, doc, parent);
		}
		else
			return null;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node createDOM(String domType, String str, String value, Document doc, edu.jhu.apl.patterns_class.dom.replacement.Node parent){
		if (domType.equals("attr"))
			return new Attr(str, value, doc, parent);
		else
			return null;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node getDocumentElement()
	{
		for (java.util.ListIterator i = ((NodeList )getChildNodes()).listIterator(0); i.hasNext();)
		{
			edu.jhu.apl.patterns_class.dom.replacement.Node	element =
			  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

			if (element instanceof edu.jhu.apl.patterns_class.dom.replacement.Element)
				return (edu.jhu.apl.patterns_class.dom.replacement.Node )element;
		}

		return null;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node getNext(){
		return getDocumentElement();
	}

	public boolean hasNext(){
		if (getDocumentElement() != null){
			return true;
		}
		else{
			return false;
		}
	}

	public Node getPrevious(){
		return null;
	}

	public boolean hasPrevious(){
		return false;
	}

	//
	// Unimplemented Document members.
	//
	public org.w3c.dom.DOMImplementation getImplementation() { return null; }
	public org.w3c.dom.DocumentType getDoctype() { return null; }
	public org.w3c.dom.DocumentFragment createDocumentFragment() { return null; }
	public org.w3c.dom.Comment createComment(String data) { return null; }
	public org.w3c.dom.CDATASection createCDATASection(String data) throws org.w3c.dom.DOMException { return null; }
	public org.w3c.dom.ProcessingInstruction createProcessingInstruction(String target, String data)
	  throws org.w3c.dom.DOMException
	  { return null; }
	public org.w3c.dom.EntityReference createEntityReference(String name) throws org.w3c.dom.DOMException { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  importNode(edu.jhu.apl.patterns_class.dom.replacement.Node importedNode, boolean deep) throws org.w3c.dom.DOMException
	  { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Element createElementNS(String namespaceURI, String qualifiedName)
	  throws org.w3c.dom.DOMException
	  { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Attr createAttributeNS(String namespaceURI, String qualifiedName)
	  throws org.w3c.dom.DOMException
	  { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagNameNS(String namespaceURI, String localName)
	  { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Element getElementById(String elementId) { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Node cloneNode(boolean deep) { return null; }


	public void setValue(String attribute_value) {}
	public void setAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Node attr) {}
	public void setAttribute(String attribute, String attribute_value) {}

	@Override
	public void setParent(Element element) {

	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  renameNode(edu.jhu.apl.patterns_class.dom.replacement.Node n, String namespaceURI, String qualifiedName) { return null; }
	public void normalizeDocument() {}
	public org.w3c.dom.DOMConfiguration getDomConfig() { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  adoptNode(edu.jhu.apl.patterns_class.dom.replacement.Node source) { return null; }
	public void setDocumentURI(String documentURI) {}
	public String getDocumentURI() { return null; }
	public void setStrictErrorChecking(boolean strictErrorChecking) {}
	public boolean getStrictErrorChecking() { return false; }
	public void setXmlVersion(String xmlVersion) {}
	public String getXmlVersion() { return null; }
	public void setXmlStandalone(boolean xmlStandalone) {}
	public boolean getXmlStandalone() { return false; }
	public String getXmlEncoding() { return null; }
	public String getInputEncoding() { return null; }
}
