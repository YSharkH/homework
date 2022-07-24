package homewor.com.second;

public class test {
    public static void main(String[] args) {
        //计算器
        Computer computer=new Computer();
        String s = "";
        try {
         s= computer.solve("4*(0-2)*2*2000000000000000");
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s);


        //双向链表
        myList<Integer> l=new myList<>(1,1);
        for (int i = 2; i < 10; i++) {
            l.add(new myList<>(i, i));
        }
        l.show();
        System.out.println("头结点");
        System.out.println(l.head.key);
        System.out.println("尾巴结点");
        System.out.println(l.tail.key);
        System.out.println();
        try {
            l.del(1);
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
        try {
            l.del(10);
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(l.head.pre);
        l.show();
        System.out.println();
        System.out.println(l.get(7));
        l.turn(l.next.head).show();
        System.out.println();
        System.out.println(l.len);


    }

    }

