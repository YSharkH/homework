package homewor.com.second;

import java.util.Stack;

public class Computer {



    public static String solve(String expression) throws myException {//计算表达式
        double sum, flag;
        int top = -1;// 存数堆栈的指针
        double[] stackNum = new double[100];// 数组模拟堆栈，栈精度不够
        Stack<Character> stack = new Stack<Character>();//存运算符的堆栈

        for (int i = 0; i < expression.length(); i++) {
            char p = expression.charAt(i);
            flag = sum = 0;
            if (p >= '0' && p <= '9') {//存入数字
                while (true) {
                    p = expression.charAt(i);
                    if (p == '.') flag = 0.1;
                    else {
                        if (flag == 0) {
                            sum = sum * 10 + (p - '0');
                        } else {//小数位处理
                            sum += ((p - '0') * flag);
                            flag *= 0.1;
                        }
                    }
                    if (i + 1 < expression.length() && ((expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') || expression.charAt(i + 1) == '.'))
                        i++;
                    else {
                        stackNum[++top] = sum;
                        break;
                    }
                }
            } else {
                if (p == '(') stack.push(p);
                else if (p == '*' || p == '/') {
                    while (stack.size() > 0 && (stack.peek() == '*' || stack.peek() == '/')) {
                        double temp = operation(top,stackNum,stack);
                        stackNum[++top] = temp;
                    }
                    stack.push(p);
                } else if (p == '+' || p == '-') {
                    while (stack.size() > 0 && stack.peek() != '(') {
                        double temp = operation(top,stackNum,stack);
                        stackNum[++top] = temp;
                    }
                    stack.push(p);
                } else if (p == ')') {// 运算符为)时堆栈内容都取出来
                    while (stack.size() > 0 && stack.peek() != '(') {
                        double temp = operation(top,stackNum,stack);
                        stackNum[++top] = temp;
                    }
                    stack.pop();
                } else {
                    throw new myException("输入数据错误");
                }
            }
        }
        while (stack.size() > 0) {

            double temp = operation(top,stackNum,stack);
            stackNum[++top] = temp;
        }

        return "" + stackNum[top];
    }

    public static double compute(double a, double b, char p) throws myException {
        double sum = 0;double x=Math.max(a,b);
        double y=Math.min(a,b);
        if (p == '+') {

            sum = b + a;
            if(y>Double.MAX_VALUE-x||y<Double.MIN_VALUE-x){
                throw new myException("数据溢出");
            }
        } else if (p == '-') {
            sum = b - a;
            if(x>Double.MAX_VALUE+y||x<Double.MIN_VALUE+y){
                throw new myException("数据溢出");
            }
        } else if (p == '*') {

            sum=a*b;
            if(y>Double.MAX_VALUE/x||x<Double.MIN_VALUE/y){
                throw new myException("数据溢出");
            }

        } else if (p == '/') {
            sum = b / a;
        }
        return sum;
    }
    public  static double operation(int top,double []stackNum,Stack stack) throws myException {
        double temp;
        try {
            temp = compute(stackNum[top--], stackNum[top--], (Character) stack.pop());
            stackNum[++top] = temp;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new myException("数据异常");
        }
        return temp;
    }


}
