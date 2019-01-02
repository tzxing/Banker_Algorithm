import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JFrame implements ActionListener {

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel[] jLabels_name;
    private JTextField[] jTextFields_allocation;
    private JTextField[] jTextFields_max;
    private JButton jButton;

    public Input() throws HeadlessException {
        super("银行家算法");
        Data.allocation = new int[Data.count_process];
        Data.max = new int[Data.count_process];
        Data.need=new int[Data.count_process];
        this.setResizable(true);
        this.setBounds(300, 200, 600, 400);
        this.setLayout(new GridLayout(Data.count_process + 2, 3));
        jLabel1 = new JLabel("进程");
        jLabel2 = new JLabel("已占有资源数");
        jLabel3 = new JLabel("最大资源需求数");
        jLabels_name = new JLabel[Data.count_process];
        jTextFields_allocation = new JTextField[Data.count_process];
        jTextFields_max = new JTextField[Data.count_process];
        jButton = new JButton("下一步");
        jButton.addActionListener(this);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        for (int i = 0; i < Data.count_process; i++) {
            jLabels_name[i] = new JLabel();
            jLabels_name[i].setText("P" + (i+1));
            jTextFields_allocation[i] = new JTextField();
            jTextFields_max[i] = new JTextField();

        }
        for (int i = 0; i < Data.count_process; i++) {
            this.add(jLabels_name[i]);
            this.add(jTextFields_allocation[i]);
            this.add(jTextFields_max[i]);
        }
        this.add(jButton);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Data.available = Data.count_resource;

        try {
            for (int i = 0; i < Data.count_process; i++) {
                Data.allocation[i] = Integer.parseInt(jTextFields_allocation[i].getText());
                Data.max[i] = Integer.parseInt(jTextFields_max[i].getText());
                Data.need[i]=Data.max[i]-Data.allocation[i];
                if (Data.allocation[i] > Data.max[i]) {
                    JOptionPane.showMessageDialog(Input.this, "占有资源数不能大于最大资源需求数，请重试！");
                    return;
                }
                Data.available -= Data.allocation[i];
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Input.this, "请正确输入数据！");
            return;
        }
        if (Data.available < 0) {
            JOptionPane.showMessageDialog(Input.this, "占有资源数大于总资源数，请重试！");
            return;
        }
        new Banker();
        this.setVisible(false);


    }
}
