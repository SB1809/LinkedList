/*
Sophia Babayev, 9/25/25, a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/



public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  //private ArrayList<String> strArr = new ArrayList<>();
  ListNode head;


  //constructors go here
  public LinkedList(){
    head = null;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    if (head == null){
      head = new ListNode(line, null);
      return head;
    }


    if (head.getValue().compareTo(line) > 0){
      head = new ListNode(line, head);
      
      return head;
    }


    ListNode place = head;
    boolean placed = false;

    while (placed == false) {
      if (place.getNext() != null && place.getNext().getValue().compareTo(line) < 0){
       place = place.getNext();
      }
      else{
        placed = true;
      }
      
    } 
      if (place.getNext() == null) {
        ListNode newNode = new ListNode(line, null);
        place.setNext(newNode);
        return newNode;
      } else {
        ListNode newNode = new ListNode(line, place.getNext());
        place.setNext(newNode);
        return newNode;
      }
      
      

  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
   if (head.getValue().equals(line)){
        ListNode deletedNode = head;
       
        head = head.getNext();
        return deletedNode;
      }


    ListNode place = head;
    while (place != null){
      
      if (place.getNext().getValue().equals(line)){
        ListNode deletedNode = place.getNext();
        deletedNode.getValue().equals(null);
        place.setNext(deletedNode.getNext());
        return deletedNode;

      } 
      //System.out.println(str);
      place = place.getNext();
    }
    return null;
  }



  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String str = "";
    ListNode place = head;
    while (place != null){
      str = str + place.getValue() + " ";
      //System.out.println(str);
      place = place.getNext();
    }
    return str;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
  }

  //precondition: the list has been initialized
  //postconditions: reverses the entire linked list such that the tail is now the head and the head is the tail.
  public void reverse(){

    ListNode prev = null;
    ListNode curr = head;
    ListNode next = head.getNext();
    while(curr != null){
      curr.setNext(prev);
      prev = curr;
      curr = next;
      if (next != null){
        next = next.getNext();
      } else {
        next = null;
      }
      
    }
    if (curr == null){
      head = prev;
    }
    

  }


    //precondition: the list has been initialized
    //postconditions: take each "chunk" of n nodes and reverse them. 
    //if there aren't enough nodes at the end to fit into a chunk they are left without being reversed. 
    public void nReverse(int n) {
      
      if (head.getValue() == null || n <= 1) {
        return;
      }

      ListNode tailOfSorted = null;
      ListNode tail;
      ListNode prev = null;
      ListNode curr = head;
      ListNode next = head.getNext();

    while(curr != null){
      tail = curr;
      for (int i = 0; i < n && curr != null; i++) {
        
        curr.setNext(prev);
        prev = curr;
        curr = next;
        if (next != null){
          next = next.getNext();
        } else {
          next = null;
        }
        
      }
    if(tailOfSorted!= null){

      tailOfSorted.setNext(prev);
    }
    else{
        head = prev;
    }
      tail.setNext(curr);
    tailOfSorted = tail;

    }
  
      

    }

}
