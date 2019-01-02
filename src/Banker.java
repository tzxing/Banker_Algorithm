import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banker extends JFrame implements ActionListener {
    JPanel jPanel;
    JLabel jLabel1;
    JLabel jLabel2;
    JTextField jTextField_no;
    JTextField jTextField_num;
    JButton jButton;
    JTextArea jTextArea;

    public Banker() throws HeadlessException {
        super("银行家算法");
        this.setResizable(true);
        this.setBounds(300, 200, 600, 200);
        this.setLayout(new BorderLayout());
        jPanel = new JPanel();
        jLabel1 = new JLabel("进程：P");
        jTextField_no = new JTextField(2);
        jLabel2 = new JLabel("欲分配资源数：");
        jTextField_num = new JTextField(3);
        jButton = new JButton("尝试分配");
        jButton.addActionListener(this);
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jPanel.add(jLabel1);
        jPanel.add(jTextField_no);
        jPanel.add(jLabel2);
        jPanel.add(jTextField_num);
        jPanel.add(jButton);
        this.add(jPanel);
        this.add(jTextArea, BorderLayout.SOUTH);
        this.setVisible(true);
        jTextArea.setText(Data.test());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int request_no = Integer.parseInt(jTextField_no.getText())-1;
        int request_num = Integer.parseInt(jTextField_num.getText());
        if (request_num > Data.need[request_no]) {
            JOptionPane.showMessageDialog(Banker.this, "请求数超过需求资源数，请重试!");
            return;
        }
        if (request_num > Data.available) {
            JOptionPane.showMessageDialog(Banker.this, "请求数超过可用资源数，请重试!");
            return;
        }
        jTextArea.setText(Data.test(request_no, request_num));


    }
}
