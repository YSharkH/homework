package homewor.com.second;

public class myList<T> {
    protected int key;
    protected myList<T> head;//头
    protected myList<T> tail;//尾
    protected myList<T> next;
    protected myList<T> pre;
    private T data;
    protected int len;

    //构造
    public myList(int key, T data) {
        this.data = data;
        this.key = key;
        head=this;
        tail = head;
        len++;
    }

    //添加
    public void add(myList<T> node) {
        tail.next = node;
        node.pre = tail;
        tail = node;
        len++;
    }

    //删除
    public void del(int key) throws myException {
        //头结点
        if (head.key == key) {
            head = head.next;
            head.pre = null;
            len--;
        } else if (tail.key == key) {
            tail = tail.pre;
            tail.next = null;
            len--;
        } else {
            myList<T> current = get(key);
            if (current == null) {
                throw new myException("节点不存在");
            }
            current.pre.next = current.next;
            current.next.pre = current.pre;
            current = null;
            len--;
        }
    }

    //根据key获取节点
    public myList<T> get(int key) {
        if (head.key == key) {
            return head;
        } else if (tail.key == key) {
            return tail;
        } else {
            myList<T> temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    break;
                }
                temp = temp.next;
            }
            return temp;
        }
    }

    //递归显示链表内容
    public void show() {
        System.out.print(head.key+" ");
        if (head.next != null) {
            head.next.show();
        }
    }

    //反转链表
    public myList<T> turn(myList<T> head) {
        if(head==null || head.next==null)
            return head;
        myList<T> p = head;
        myList<T> q;
        myList<T> temp = null;
        while(p!=null) {
            q = p.next;
            p.next = temp;
            p.pre = q;
            temp = p;
            p = q;
        }
        return temp;

    }

}