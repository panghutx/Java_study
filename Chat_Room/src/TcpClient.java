import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class TcpClient extends JFrame{

    Socket socket;
    public static JTextArea ta=new JTextArea();
    private JTextField tf=new JTextField();
    Container cc;

    public TcpClient(String title) throws IOException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc=this.getContentPane();

        final JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");

        tf.addFocusListener(new JTextFieldListener(tf,"请在此输入内容"));
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(TcpClient.this, "请输入内容！");
                }else {

                    //接收服务器的响应
                    while(true) {
                        try(InputStream inputStream = socket.getInputStream()) {
                            try(OutputStream outputStream = socket.getOutputStream()){
                                PrintWriter writer = new PrintWriter(outputStream);
                                System.out.println(tf.getText());
                                writer.println(tf.getText());
                                ta.append("客户端："+tf.getText()+"\n");
                                Scanner scanner = new Scanner(inputStream);
                                String resp = scanner.next();
                                ta.append("服务器：:"+resp+"\n");
                                ta.setSelectionEnd(ta.getText().length());
                                tf.setText("");
                            }


                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }


                }


            }
        });
    }

    //焦点监听器
    class JTextFieldListener implements FocusListener{

        private String hintText;          //提示文字
        private JTextField textField;

        public JTextFieldListener(JTextField textField,String hintText) {
            this.textField=textField;
            this.hintText=hintText;
            textField.setText(hintText);   //默认直接显示
            textField.setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {

            //获取焦点时，清空提示内容
            String temp=textField.getText();
            if(temp.equals(hintText)){
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {

            //失去焦点时，没有输入内容，显示提示内容
            String temp=textField.getText();
            if(temp.equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }

        }

    }

    private void connect() {
        ta.append("尝试连接\n");
        try {
            socket=new Socket("127.0.0.1",9090);
            ta.append("完成连接\n");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //EventQueue事件队列，封装了异步事件指派机制
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                TcpClient client= null;
                try {
                    client = new TcpClient("向服务器发送数据");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                client.setSize(400,400);
                client.setVisible(true);
                client.connect();


            }
        });

    }

}