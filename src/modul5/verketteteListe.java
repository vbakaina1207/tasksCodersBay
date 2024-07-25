package modul5;

public class verketteteListe {

    public static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList<E> {
        private Node<E> head;
        private int size;

        private LinkedList() {
            head = null;
            size = 0;
        }

        public boolean add(E e) {
            Node<E> addNode = new Node<>(e);
            if (head == null) {
                head = addNode;
            } else {
                Node<E> cur = head;
                while (cur.next != null){
                    cur = cur.next;
                }
                cur.next = addNode;
            }
            size++;
            return true;
        }

        public void add(int index, E element ) {
            if(index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index " + index + " liegt außerhalb des zulässigen Bereichs.");
            }
            Node<E> addNode = new Node<>(element);
            if(index == 0) {
                addNode.next = head;
                head = addNode;
            } else {
                Node<E> cur = head;
                for (int i = 0; i< index -1; i++){
                    cur = cur.next;
                }
                addNode.next = cur.next;
                cur.next = addNode;
            }
            size++;
        }

        public int size () {
            return  size;
        }

        public E get(int index) {
            if(index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index " + index + " liegt außerhalb des zulässigen Bereichs.");
            }
            Node<E> cur = head;
            for (int i = 0; i< index; i++){
                cur = cur.next;
            }
            return cur.data;
        }

        public E remove(int index) {
            if(index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index " + index + " liegt außerhalb des zulässigen Bereichs.");
            }
            Node<E> removeNode;
            if(index == 0) {
                removeNode = head;
                head = removeNode.next;
            } else {
                Node<E> cur = head;
                for (int i = 0; i< index -1; i++){
                    cur = cur.next;
                }
                removeNode = cur.next;
                cur.next = cur.next.next;
            }
            size--;
            return  removeNode.data;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> cur = head;
            sb.append("[");
            while (cur!=null) {
                sb.append(cur.data);
                if (cur.next!=null)
                    sb.append(" - > ");
                cur = cur.next;
            }
            sb.append("]");
            return  sb.toString();
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
            String str = list.toString();
        System.out.println(str);
        int remove = list.remove(2);
        System.out.println("removeElement "+ remove);
        System.out.println("list add " + list.add(6));
        System.out.println(list);
        System.out.println("getElement " + list.get(1));
        System.out.println("size list " + list.size());

        LinkedList<String> listStr = new LinkedList<>();
        listStr.add("String");
        listStr.add("Integer");
        listStr.add("Array");
        System.out.println("list String " + listStr.toString());
        System.out.println("listStr get 1 " + listStr.get(1));
        System.out.println("listStr size " +listStr.size());
    }
}
