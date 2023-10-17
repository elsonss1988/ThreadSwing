package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog{
    String title = "Minha Tela com Thread";
    private JPanel jPanel = new JPanel(new GridBagLayout());
    private JLabel descricaoHora = new JLabel("Time Thread 1");
    private JLabel descricaoHora2 = new JLabel("Time Thread 2");
    private JTextField mostraTempo = new JTextField();
    private JTextField mostraTempo2 = new JTextField();

    private  JButton startButton = new JButton("Start");
    private  JButton stopButton = new JButton("Stop");
    private Thread thread1Time;
    private Thread thread2Time;
    private Runnable thread = new Runnable() {
        @Override
        public void run() {
            while(true){
                mostraTempo.setText(new SimpleDateFormat("dd/MM//yyyy hh:mm:ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    private Runnable thread2 = new Runnable(){
        public void run(){
            while(true){
                mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };
    TelaTimeThread(){
        setTitle(title);
        setSize( new Dimension(300,300));

        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5,10,5,5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200,25));
        descricaoHora.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(descricaoHora, gridBagConstraints);

        mostraTempo.setPreferredSize(new Dimension(200,25));
        gridBagConstraints.gridy++;
        mostraTempo.setHorizontalAlignment(SwingConstants.CENTER);
        mostraTempo.setEditable(false);
        jPanel.add(mostraTempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200,25));
        descricaoHora2.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.gridy++;
        jPanel.add(descricaoHora2, gridBagConstraints);

        mostraTempo2.setPreferredSize(new Dimension(200,25));
        gridBagConstraints.gridy++;
        mostraTempo2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        mostraTempo2.setEditable(false);
        jPanel.add(mostraTempo2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        startButton.setPreferredSize(new Dimension(92,25));
        gridBagConstraints.gridy++;
        jPanel.add(startButton,gridBagConstraints);

        stopButton.setPreferredSize(new Dimension(92,25));
        gridBagConstraints.gridx++;
        jPanel.add(stopButton,gridBagConstraints);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                thread1Time = new Thread(thread);
                thread2Time = new Thread(thread2);
                thread1Time.start();
                thread2Time.start();
                stopButton.setEnabled(true);
                startButton.setEnabled(false);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thread1Time.stop();
                thread2Time.stop();
                stopButton.setEnabled(false);
                startButton.setEnabled(true);
            }
        });

        stopButton.setEnabled(false);

        add(jPanel,BorderLayout.CENTER);
        setVisible(true);
    }
}
























