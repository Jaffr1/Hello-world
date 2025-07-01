package collection;


class Node
{
 Node perviousNode;
 
 int element;
 
 Node nextNode;

 public Node(Node perviousNode, int element, Node nextNode) 
 {
  this.perviousNode = perviousNode;
  this.element = element;
  this.nextNode = nextNode;
 }
}

public class MyLinkedList 
{
 
 Node head = null;
 Node tail = null;
 static int index = 0;
 
 
 
 public void add(int element)
 {
  if(head == null)
  {
   
   Node newNode = new Node(null , element, null);
   head = newNode;
   tail = newNode;
  }
  else
  {
   Node newNode = new Node(tail , element, null);
   tail.nextNode = newNode;
   tail = newNode;
  }
  
  index++;
 }

 void display()
 {
  Node start = head;
  while(start != null)
  {
   System.out.println(start.element);
   start = start.nextNode;
  }
 } 
}