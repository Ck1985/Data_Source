package multithreading;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class UnResponsiveUIwThreadSleep extends JFrame {
    private boolean stop = false;
    private JTextField tfCount;
    private int count = 1;

    public UnResponsiveUIwThreadSleep() {
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        cp.add(new JLabel("Counter"));
        tfCount = new JTextField(count + " ", 20);
        tfCount.setEditable(false);
        cp.add(tfCount);

        JButton btnStart = new JButton("Start Counting");
        cp.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread() {
                    public void run() {
                        stop = false;
                        for (int i = 1; i < 100000; i++) {
                            if (stop) break;
                            tfCount.setText(count + " ");
                            ++count;
                            try {
                                sleep(10);
                            } catch (InterruptedException ex){}
                        }
                    }
                };
                t.start();
            }
        });
        JButton btnStop = new JButton("Stop counting");
        cp.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop = true;
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("counter");
        this.setSize(320,120);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UnResponsiveUIwThreadSleep();
            }
        });
    }
}
