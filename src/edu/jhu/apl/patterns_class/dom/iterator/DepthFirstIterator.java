package edu.jhu.apl.patterns_class.dom.iterator;

import edu.jhu.apl.patterns_class.XMLSerializer;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstIterator extends ConcreteIterator{

//    private int currentChild = 0;
//    private int amountOfChildren = 0;
    private Node currentNode = null;
    private Node nextNode = null;

    public DepthFirstIterator(Node domTree) {
        super(domTree);
        this.currentNode = domTree;
//        this.amountOfChildren = amountOfChildren;
    }

    @Override
    public Node getNext(){
        if (this.currentNode.hasNext()){
            this.nextNode = this.currentNode.getNext();
            this.currentNode = this.nextNode;
            return this.nextNode;
        }
       else
           return getPrevious();

    }

    @Override
    public Node getSibling(){

    }

    @Override
    public Node getPrevious(){
        this.nextNode = this.currentNode.getPrevious();
        this.currentNode = this.nextNode;
        return nextNode;
    }

    public static void main(String args[]){
        Document document = new edu.jhu.apl.patterns_class.dom.Document();
        Node	root		= null;
        Node	child		= null;
        Node		attr		= null;
        root	= document.createDOM("element", "document", null);
        document.appendChild(root);
        child	= document.createDOM("element", "element", null);
        attr	= document.createDOM("attr", "attribute", child);
        attr.setValue("attribute value");
        child.setAttributeNode(attr);
        child	= document.createDOM("element", "element", null);
        root.appendChild(child);
        child.setAttribute("attribute", "attribute value");
        child.setAttribute("attribute2", "attribute2 value");
        Node text = document.createDOM("text", "Element Value", null);
        child.appendChild(text);
        root.appendChild(child);
        child	= document.createDOM("element", "element", null);
        root.appendChild(child);

        DepthFirstIterator iterator = new DepthFirstIterator(document);
//        Node currentNode = document;
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
//        currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();
        iterator.currentNode = iterator.getNext();


        System.out.println("Got it");
    }
}

