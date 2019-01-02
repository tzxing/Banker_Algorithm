import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Initial extends JFrame implements ActionListener {

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JButton jButton;

    public Initial() throws HeadlessException {
        super("银行家算法");
        this.setBounds(300, 200, 300, 150);
        this.setResizable(false);
        this.setLayout(new GridLayout(5, 1));
        jLabel1 = new JLabel("请输入进程数：");
        jLabel2 = new JLabel("请输入资源总数");
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton = new JButton("下一步");
        jButton.addActionListener(this);
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jLabel2);
        this.add(jTextField2);
        this.add(jButton);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new Initial();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Data.count_process = Integer.parseInt(jTextField1.getText());
            Data.count_resource = Integer.parseInt(jTextField2.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Initial.this, "请正确输入数据！");
            return;
        }
        new Input();
        this.setVisible(false);
    }
}
