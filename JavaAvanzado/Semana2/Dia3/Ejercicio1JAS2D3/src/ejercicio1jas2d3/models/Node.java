
package ejercicio1jas2d3.models;

/**
 *
 * @author Zihao Wang
 */
public class Node {
    
    Object value;
    Node next;
    
    public Node(){
        this.value=null;
        this.next=null;
    }
    
    public Node(Object value){
        this.value=value;
        this.next=null;
    }
    
    public Node(Object value,Node next){
        this.value=value;
        this.next=next;
    }
    
    public Object obtenerValor(){
        return value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", next=" + next + '}';
    }
    
}
