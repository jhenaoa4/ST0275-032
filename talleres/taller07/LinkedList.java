
/**
 * Write a description of class List here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedList {
    private Node first;
    private int size;
    public LinkedList()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        if(size == 0){
            Node nue = new Node(data);
            first = nue;
        }else{
            Node temp = getNode(index-1);
            Node nuevo = new Node(data);
            nuevo.next = temp.next;
            temp.next = nuevo;
            size++; 
        }
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(size != 0){        
            if(index == 0){
                Node temp = first.next;
                first = temp;
            } else if(index == size-1){
                Node temp = getNode(index-1);
                temp.next= null;
            } else {
                Node temp = getNode(index-1);
                temp.next = getNode(index+1);
                size--;
            }
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node actual = first;
        while(actual.next != null){
            if(data == actual.data) return true;
            actual = actual.next;
        }
        return false;
    }

}

