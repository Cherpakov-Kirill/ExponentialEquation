import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetValueFrame extends JFrame {
    GetValueFrame() {
        super("Set parameter a");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 80);

        JPanel panel = new JPanel(new FlowLayout());
        JTextField textField = new JTextField(10);
        JLabel label1 = new JLabel("a = ");

        JButton button = new JButton("Set a");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = 0;
                try {
                    a = Double.parseDouble(textField.getText());
                    Main.startCalculations(a);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(panel, "Некорректный ввод!");
                }

            }
        });

        panel.add(label1);
        panel.add(textField);
        panel.add(button);
        add(panel);
        setVisible(true);
    }
}
