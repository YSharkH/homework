package homewor.com.second;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static int n;
    public static void dfs(int k,int start,LinkedList<Integer>member) {
        if(k==n) {
            print(member);
            return;
        }
        for(int i=start;i<n;i++) {
            if(k+i<=n) {
                member.add(i);
                dfs(k+i,i,member);
                member.remove(member.size()-1);
            }
            else {
                return;
            }
        }
    }

    private static void print(LinkedList<Integer>member) {
        System.out.print(member.get(0));
        for(int i=1;i<member.size();i++) {
            System.out.print("+"+member.get(i));
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        LinkedList<Integer>temp=new LinkedList<Integer>();
        dfs(0,1,temp);
    }
}
