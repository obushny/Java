import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame {

    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JTextField field;
    private static int pause;

        /*
        Прочие элементы
        */


    public static void main(String[] args) {
        new main().setVisible(true);
    }

    public main() {
        progressBar1 = new JProgressBar();
        progressBar2 = new JProgressBar();

        JPanel panel = new JPanel();
        JButton button = new JButton("Start");
       // panel.setLayout(new BorderLayout());
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                runRunner1();
                runRunner2();
            }
        });

        panel.add(button);
        panel.add(progressBar1);
        panel.add(progressBar2);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void runRunner1() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i=0; i<100; i++) {
                    pause=100;//600+(int)Math.random()*400;
                    try {
                        Thread.sleep(pause);
                        progressBar1.setValue(progressBar1.getValue() + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
    }
    private void runRunner2() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i=0; i<100; i++) {
                    pause=600+(int)Math.random()*400;
                    try {
                        Thread.sleep(pause);
                        progressBar2.setValue(progressBar2.getValue() + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
    }

}