package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.iterator.DepthFirstIterator;
import edu.jhu.apl.patterns_class.dom.replacement.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ListIterator;

public class XMLSerializer
{
	java.io.File		file			= null;
	java.io.BufferedWriter	writer			= null;

	public XMLSerializer(String filename) throws java.io.FileNotFoundException
	{
		file		= new java.io.File(filename);
		writer		= new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file)));
	}

	public void close() throws java.io.IOException
	{
		writer.close();
	}

	private void prettyIndentation(BufferedWriter writer, int indentationLevel) throws java.io.IOException
	{
		for (int i = 0; i < indentationLevel; i++)
			writer.write("\t");
	}

	//
	// Strategize Node data printing.
	// Strategize whitespace insertion.
	// Strategize output stream
	//

	public void serialize(String serializeType, Node node, BufferedWriter writer) throws IOException {
		dataPrintSetStrategyWithIterator(serializeType, node, writer, 0);
	}

	// Strategizing whitespace adding to the xml document
	private void whitespaceStrategy(String whitespaceType, BufferedWriter writer, int indentationLevel) throws IOException {
		if (whitespaceType.equals("newline")){
			writer.write("\n");
		}
		else if (whitespaceType.equals("indent")){
			prettyIndentation(writer, indentationLevel);
		}
	}

	// Strategizing how to print the xml document, with or without indentation and whitespace
//	private void dataPrintSetStrategy(String serializeType, Node node, BufferedWriter writer, int indentationLevel) throws IOException {
//		if (node instanceof edu.jhu.apl.patterns_class.dom.Document){
//			writer.write("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
//			if (serializeType.equals("pretty"))
//				whitespaceStrategy("newline", writer, indentationLevel);
//			dataPrintSetStrategy(serializeType, ((edu.jhu.apl.patterns_class.dom.replacement.Document )node).getDocumentElement(), writer, indentationLevel);
//		}
//		else if (node instanceof Element){
//			if (serializeType.equals("pretty"))
//				whitespaceStrategy("indent", writer, indentationLevel);
//			writer.write("<" + ((edu.jhu.apl.patterns_class.dom.replacement.Element )node).getTagName());
//
//			int	attrCount	= 0;
//
//			for (java.util.ListIterator i =
//				 ((edu.jhu.apl.patterns_class.dom.NodeList )node.getAttributes()).listIterator(0);
//				 i.hasNext();)
//			{
//				edu.jhu.apl.patterns_class.dom.replacement.Node	attr =
//						(edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();
//
//				dataPrintSetStrategy(serializeType, attr, writer, indentationLevel);
//				attrCount++;
//			}
//
//			if (attrCount > 0)
//				writer.write(" ");
//
//			if (!((edu.jhu.apl.patterns_class.dom.NodeList )node.getChildNodes()).listIterator(0).hasNext())
//			{
//				writer.write("/>");
//				if (serializeType.equals("pretty"))
//					whitespaceStrategy("newline", writer, indentationLevel);
//			}
//			else
//			{
//				writer.write(">");
//				if (serializeType.equals("pretty"))
//					whitespaceStrategy("newline", writer, indentationLevel);
//				indentationLevel++;
//
//				for (java.util.ListIterator i =
//					 ((edu.jhu.apl.patterns_class.dom.NodeList )node.getChildNodes()).listIterator(0);
//					 i.hasNext();)
//				{
//					edu.jhu.apl.patterns_class.dom.replacement.Node	child =
//							(edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();
//
//					if (child instanceof edu.jhu.apl.patterns_class.dom.replacement.Element ||
//							child instanceof edu.jhu.apl.patterns_class.dom.replacement.Text)
//						//serializePretty(child);
//						dataPrintSetStrategy(serializeType, child, writer, indentationLevel);
//				}
//
//				indentationLevel--;
//				if (serializeType.equals("pretty"))
//					whitespaceStrategy("indent", writer, indentationLevel);
//				writer.write("</" + ((edu.jhu.apl.patterns_class.dom.replacement.Element )node).getTagName() + ">");
//				if (serializeType.equals("pretty"))
//					whitespaceStrategy("newline", writer, indentationLevel);
//			}
//		}
//		else if (node instanceof Attr){
//			writer.write(" " + ((edu.jhu.apl.patterns_class.dom.replacement.Attr )node).getName() + "=\"" +
//					((edu.jhu.apl.patterns_class.dom.replacement.Attr )node).getValue() + "\"");
//		}
//		else if (node instanceof Text){
//			if (serializeType.equals("pretty"))
//				whitespaceStrategy("indent", writer, indentationLevel);
//			writer.write(((edu.jhu.apl.patterns_class.dom.replacement.Text )node).getData());
//			if (serializeType.equals("pretty"))
//				whitespaceStrategy("newline", writer, indentationLevel);
//		}
//	}

	private void dataPrintSetStrategyWithIterator(String serializeType, Node node, BufferedWriter writer, int indentationLevel) throws IOException {
		DepthFirstIterator iterator = new DepthFirstIterator(node);

		while(iterator.currentNode != null){
			if (iterator.currentNode instanceof edu.jhu.apl.patterns_class.dom.Document){
				writer.write("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
				if (serializeType.equals("pretty"))
					whitespaceStrategy("newline", writer, indentationLevel);
				//dataPrintSetStrategy(serializeType, ((Document )iterator.currentNode).getDocumentElement(), writer, indentationLevel);
			}
			else if (iterator.currentNode instanceof Element){
				if (serializeType.equals("pretty"))
					whitespaceStrategy("indent", writer, indentationLevel);
				writer.write("<" + ((Element )iterator.currentNode).getTagName());

				int	attrCount	= 0;

				for (ListIterator i =
					 ((edu.jhu.apl.patterns_class.dom.NodeList )iterator.currentNode.getAttributes()).listIterator(0);
					 i.hasNext();)
				{
					Node	attr =
							(Node )i.next();

					//dataPrintSetStrategy(serializeType, attr, writer, indentationLevel);
					attrCount++;
				}

				if (attrCount > 0)
					writer.write(" ");

				if (!((edu.jhu.apl.patterns_class.dom.NodeList )iterator.currentNode.getChildNodes()).listIterator(0).hasNext())
				{
					writer.write("/>");
					if (serializeType.equals("pretty"))
						whitespaceStrategy("newline", writer, indentationLevel);
				}
				else
				{
					writer.write(">");
					if (serializeType.equals("pretty"))
						whitespaceStrategy("newline", writer, indentationLevel);
					indentationLevel++;

					for (ListIterator i =
						 ((edu.jhu.apl.patterns_class.dom.NodeList )iterator.currentNode.getChildNodes()).listIterator(0);
						 i.hasNext();)
					{
						Node	child =
								(Node )i.next();

//						if (child instanceof Element ||
//								child instanceof Text)
//							//serializePretty(child);
//							dataPrintSetStrategy(serializeType, child, writer, indentationLevel);
					}

					indentationLevel--;
					if (serializeType.equals("pretty"))
						whitespaceStrategy("indent", writer, indentationLevel);
					writer.write("</" + ((Element )iterator.currentNode).getTagName() + ">");
					if (serializeType.equals("pretty"))
						whitespaceStrategy("newline", writer, indentationLevel);
				}
			}
			else if (iterator.currentNode instanceof Attr){
				writer.write(" " + ((Attr )iterator.currentNode).getName() + "=\"" +
						((Attr )iterator.currentNode).getValue() + "\"");
			}
			else if (iterator.currentNode instanceof Text){
				if (serializeType.equals("pretty"))
					whitespaceStrategy("indent", writer, indentationLevel);
				writer.write(((Text )iterator.currentNode).getData());
				if (serializeType.equals("pretty"))
					whitespaceStrategy("newline", writer, indentationLevel);
			}
			iterator.currentNode = iterator.getNext();
		}
	}

	public static void main(String args[]) throws FileNotFoundException {
		if (args.length < 2)
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
		Document	document	=
		  new edu.jhu.apl.patterns_class.dom.Document();
		Node	root		= document.createDOM("element", "document", null);
		document.appendChild(root);

		Node	child		= document.createDOM("element", "element", null);
		Node		attr		= document.createDOM("attr", "attribute", null);
		attr.setValue("attribute value");
		child.setAttributeNode(attr);
		root.appendChild(child);

		child	= document.createDOM("element", "element", null);
		root.appendChild(child);

		child	= document.createDOM("element", "element", null);
		child.setAttribute("attribute", "attribute value");
		child.setAttribute("attribute2", "attribute2 value");
		edu.jhu.apl.patterns_class.dom.replacement.Node		text		= document.createDOM("text", "Element Value", null);
		child.appendChild(text);
		root.appendChild(child);

		child	= document.createDOM("element", "element", null);
		root.appendChild(child);

		Document	documentDuplicate	=
				new edu.jhu.apl.patterns_class.dom.Document();
		Node	rootDuplicate		= documentDuplicate.createDOM("element", "document", null);
		documentDuplicate.appendChild(rootDuplicate);

		Node	childDuplicate		= documentDuplicate.createDOM("element", "element", null);
		Node		attrDuplicate		= documentDuplicate.createDOM("attr", "attribute", null);
		attrDuplicate.setValue("attribute value");
		childDuplicate.setAttributeNode(attrDuplicate);
		rootDuplicate.appendChild(childDuplicate);

		childDuplicate	= documentDuplicate.createDOM("element", "element", null);
		rootDuplicate.appendChild(childDuplicate);

		childDuplicate	= documentDuplicate.createDOM("element", "element", null);
		childDuplicate.setAttribute("attribute", "attribute value");
		childDuplicate.setAttribute("attribute2", "attribute2 value");
		edu.jhu.apl.patterns_class.dom.replacement.Node		textDuplicate		= documentDuplicate.createDOM("text", "Element Value", null);
		childDuplicate.appendChild(textDuplicate);
		rootDuplicate.appendChild(childDuplicate);

		childDuplicate	= documentDuplicate.createDOM("element", "element", null);
		rootDuplicate.appendChild(childDuplicate);

		//
		// Serialize
		//
		try
		{
			XMLSerializer	xmlSerializer	= new XMLSerializer(args[0]);
			xmlSerializer.serialize("pretty", document, xmlSerializer.writer);
			xmlSerializer.close();
			xmlSerializer	= new XMLSerializer(args[1]);
			xmlSerializer.serialize("minimal", documentDuplicate, xmlSerializer.writer);
			xmlSerializer.close();
		}
		catch (IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
	}
}
