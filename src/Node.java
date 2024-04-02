class Node<T extends Comparable<T>> {
  T element;
  Node<T> left;
  Node<T> right;

  Node(T element)
  {
    this.element = element;
    left = null;
    right = null;
  }
  public String toString() { 
    return element.toString(); 
  }
}

