package edu.jhu.apl.patterns_class.dom.replacement;

import edu.jhu.apl.patterns_class.dom.Document;

import java.io.IOException;

public abstract class ElementProxy implements Element{
    private edu.jhu.apl.patterns_class.dom.Element elementService;
    private edu.jhu.apl.patterns_class.dom.NamedNodeMap attributes	= null;

    public ElementProxy(String tagName, Document document){
        this.elementService = new edu.jhu.apl.patterns_class.dom.Element(tagName, document);
    }

    public void serialize(java.io.Writer writer, edu.jhu.apl.patterns_class.XMLSerializer.WhitespaceStrategy whitespace) throws IOException {
        whitespace.prettyIndentation(writer);
        writer.write("<" + getTagName());

        int	attrCount	= 0;


    }



















    //
    // Unimplemented Element members.
    //
    public edu.jhu.apl.patterns_class.dom.replacement.Attr getAttributeNodeNS(String namespaceURI, String localName)
    { return null; }
    public String getAttributeNS(String namespaceURI, String localName) { return null; }
    public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagNameNS(String tagName) { return null; }
    public boolean hasAttributeNS(String namespaceURI, String localName) { return false; }
    public void removeAttributeNS(String namespaceURI, String localName) {}
    public edu.jhu.apl.patterns_class.dom.replacement.Attr
    setAttributeNodeNS(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr) { return null; }
    public void setAttributeNS(String namespaceURI, String localName, String value) {}
    public edu.jhu.apl.patterns_class.dom.replacement.Attr
    setAttributeNS(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr) { return null; }
    public edu.jhu.apl.patterns_class.dom.replacement.NodeList
    getElementsByTagNameNS(String namespaceURI, String localName) { return null; }
    public void setIdAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr idAttr, boolean isId) {}
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {}
    public void setIdAttribute(String name, boolean isId) {}
    public org.w3c.dom.TypeInfo getSchemaTypeInfo() { return null; }



    //
    // Reimplemented Node members.
    //
    public edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap getAttributes()	{ return attributes; }
    public boolean hasAttributes()			{ return attributes.getLength() > 0; }

}
