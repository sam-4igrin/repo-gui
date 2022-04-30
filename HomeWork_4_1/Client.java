package HomeWork_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Client extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("192.168.0.1");
    private final JTextField tfPort = new JTextField("80");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("semen");
    private final JPasswordField tfPassword = new JPasswordField("qwerty");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final  JList<String> userList = new JList<>();

    private boolean shownIoErrors = false;

    private Client() {
         Thread.setDefaultUncaughtExceptionHandler(this);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setSize(WIDTH, HEIGHT);
         setTitle("Chat Client");
         log.setEditable(false);
         JScrollPane spLog = new JScrollPane(log);
         JScrollPane spUsers = new JScrollPane(userList);
         String[] users = {"user1", "user2",
                 "user3", "user4", "user5",
                 "user6", "user7", "user8",
                 "user9", "user10_with_a_exceptionally_very_long_nickname"};
         userList.setListData(users);
         spUsers.setPreferredSize(new Dimension(100, 0));
         cbAlwaysOnTop.addActionListener(this);
         btnSend.addActionListener(this);
         tfMessage.addActionListener(this);


         panelTop.add(tfIPAddress);
         panelTop.add(tfPort);
         panelTop.add(cbAlwaysOnTop);
         panelTop.add(tfLogin);
         panelTop.add(tfPassword);
         panelTop.add(btnLogin);
         panelBottom.add(btnDisconnect, BorderLayout.WEST);
         panelBottom.add(tfMessage,BorderLayout.CENTER);
         panelBottom.add(btnSend, BorderLayout.EAST);


         add(panelBottom, BorderLayout.SOUTH);
         add(panelTop, BorderLayout.NORTH);
         add (spLog, BorderLayout.CENTER);
         add(spUsers,BorderLayout.EAST);

         setVisible(true);
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if ( src == btnSend || src == tfMessage) {
          sendMessage();
        } else {
            throw new RuntimeException("Action for component unimplemented: " + src);
        }
    }
    private void sendMessage () {
        String msg = tfMessage.getText();
        String username = tfLogin.getText();
        if ("".equals(msg)) return;
        tfMessage.setText(null);
        tfMessage.requestFocusInWindow();
        putLog(String.format("%s: %s", username, msg));
        wrtMsgToLogFile(msg, username);
    }

    private void wrtMsgToLogFile(String msg, String username) {
        try (FileWriter out = new FileWriter("log.txt", true)) {
            out.write(username + ": " + msg + "\n");
            out.flush();
        } catch (IOException e) {
            if (!shownIoErrors) {
                shownIoErrors = true;
                showException(Thread.currentThread(), e);
            }
        }
    }
    private void putLog(String msg) {
        if ("".equals(msg)) return;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });

    }

    private void showException(Thread t, Throwable e) {
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        if (ste.length == 0)
            msg = "Empty Stacktrace";
        else {
            msg = String.format("Exception in \"%s\" %s: %s\n\tat %s",
                    t.getName(),e,getClass().getCanonicalName());
                    JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, msg, "Exception", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
       e.printStackTrace();
       showException(t, e);

    }

}

