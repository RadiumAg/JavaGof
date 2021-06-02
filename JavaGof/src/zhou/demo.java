package zhou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

import static java.lang.reflect.Array.*;

public class demo extends JFrame {
    private JTextField text;               //文本框
    private String input;                       //结果

    public demo() {
        init();
        this.setTitle("计算器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 200, 500, 300);
        this.setLocation(800, 400);//窗体位置
        this.setVisible(true);
    }

    private boolean isNumber(int asc) {
        if (asc < 48 || asc > 57) {
            return false;
        } else {
            return true;
        }
    }

    private boolean inputRule(char inputWord, char[] input) {
        var currentWordAsc = Integer.valueOf(inputWord);
        if (input.length == 1) {
            if (!isNumber(currentWordAsc)) {
                text.setText("第一个不能输入字符");
                this.input = "";
                return true;
            }
        } else if (input.length > 1) {
            var preWordAsc = Integer.valueOf(input[input.length - 2]);
            if (!isNumber(preWordAsc) && !isNumber(currentWordAsc)) {
                text.setText("不能连续输入字符");
                this.input = "";
                return true;
            }
        }
        return false;
    }

    public void init() {
        input = "";//监听事件中算法输出至文本框
        JPanel panel = new JPanel();
        text = new JTextField(30);
        text.setEditable(false);                       //文本框禁止编辑
        //将textField加入本JFrame中，布局为边界布局，位置为north
        this.add(text, BorderLayout.NORTH);
        String[] name = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
        //网格布局，四行四列，行间距和列间距为1
        panel.setLayout(new GridLayout(4, 4, 1, 1));
        for (int i = 0; i < name.length; i++) {
            JButton button = new JButton(name[i]);
            //设置按钮的时间监听
            button.addActionListener(new MyActionListener());
            //将按钮加入到panel中
            panel.add(button);
        }
        //将panel加入到本JFrame中，布局为边界布局，位置为centre
        this.add(panel, BorderLayout.CENTER);
    }

    class MyActionListener implements ActionListener {           //内部类实现按钮响应
        @Override
        public void actionPerformed(ActionEvent e) {
            int cnt = 0;
            String actionCommand = e.getActionCommand();            //获取按钮上的字符串
            if (actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*") || actionCommand.equals("/")) {
                input += " " + actionCommand + " ";
            } else if (actionCommand.equals("C")) {                    //清除输入
                input = "";
            } else if (actionCommand.equals("=")) {                    //按下等号
                try {
                    if (input.equals("")) {
                        return;
                    }
                    input += "=" + calculate(input);
                } catch (MyException e1) {
                    if (e1.getMessage().equals("被除数不能为0"))
                        input = e1.getMessage();
                    else
                        input = e1.getMessage();
                }
                text.setText(input);
                input = "";
                cnt = 1;
            } else
                input += actionCommand;                         //按下数字
            var stringArray = Arrays.stream(input.split(" ")).filter(x -> x != " ").toArray();
            var noWhiteSpaceStringBuffer = "";
            for (var singleWord : stringArray) {
                noWhiteSpaceStringBuffer += singleWord;
            }
            if (inputRule(actionCommand.toCharArray()[0], noWhiteSpaceStringBuffer.toCharArray()) && !actionCommand.equals("=")) {
                return;
            }
            //因为如果不按“=”按钮cnt一直为0，所以可以保证显示输入的数字和操作键
            if (cnt == 0)
                text.setText(input);
        }
    }

    private String calculate(String input) throws MyException {              //计算函数,throws可能跑出异常
        //将字符串分割成字符串数组，根据空格分割
        String[] comput = input.split(" ");
        Stack<Double> stack = new Stack<>();//创建一个空栈
        //（从第0位开始），偶数位为操作数
        Double m;
        m = Double.parseDouble(comput[0]);
        stack.push(m);                                      //第一个操作数入栈
        for (int i = 1; i < comput.length; i++) {
            if (i % 2 == 1) {
                //将偶数为操作数进栈，遇见+(-)运算符，则将下一个数以正(负）的形式压人栈中
                if (comput[i].equals("+"))
                    stack.push(Double.parseDouble(comput[i + 1]));
                if (comput[i].equals("-"))
                    stack.push(-Double.parseDouble(comput[i + 1]));
                //遇见*或/运算符，则将栈顶元素出栈与数组后一元素进行计算，并将其结果重新压入栈中
                if (comput[i].equals("*")) {                 //将前一个数出栈做乘法再入栈
                    Double d = stack.peek();                //取栈顶元素
                    stack.pop();                            //移除堆栈顶部的对象，并作为此函数的值返回该对象。
                    stack.push(d * Double.parseDouble(comput[i + 1]));
                }
                if (comput[i].equals("/")) {                 //将前一个数出栈做乘法再入栈
                    double help = Double.parseDouble(comput[i + 1]);
                    if (help == 0)
                        throw new MyException("被除数不能为0");           //不会继续执行该函数
                    double d = stack.peek();//查看堆栈顶部的对象，但不从堆栈中移除它。
                    stack.pop();
                    stack.push(d / help);
                }
            }
        }
        double sum = 0;
        while (!stack.isEmpty()) {           //求和
            sum += stack.peek();
            stack.pop();
        }
        String result = String.valueOf(sum);
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame jf = new demo();
    }
}
