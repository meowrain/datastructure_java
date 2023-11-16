package cn.edu.sxau;

import com.alibaba.fastjson2.JSON;
import com.formdev.flatlaf.FlatIntelliJLaf;
import org.apache.commons.io.FileUtils;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberBox;

    private void saveInfo() {
        boolean is_remember = rememberBox.isSelected();
        if (is_remember) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Save the username and password to a file
            try {
                String info = username + "," + password;
                File file = new File("info.txt");
                FileUtils.writeStringToFile(file, info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void readInfo() {
        boolean is_remember = rememberBox.isSelected();
        if (is_remember) {
            File file = new File("info.txt");
            if (file.exists()) {
                try {
                    String info = FileUtils.readFileToString(file);
                    String[] parts = info.split(",");
                    usernameField.setText(parts[0]);
                    passwordField.setText(parts[1]);
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void sendRequest() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            // Encode the query parameters
            String encodedUsername = URLEncoder.encode(username, "UTF-8");
            String encodedPassword = URLEncoder.encode(password, "UTF-8");
            InetAddress localhost = InetAddress.getLocalHost();
            String local_ip = localhost.getHostAddress();

            // Form the GET request URL with query parameters
            String requestUrl = "http://172.29.6.2:801/eportal/portal/login";
            StringBuilder queryParams = new StringBuilder();

            queryParams.append("?callback=dr1003");
            queryParams.append("&login_method=1");
            queryParams.append("&user_account=").append(encodedUsername);
            queryParams.append("&user_password=").append(encodedPassword);
            queryParams.append("&wlan_user_ip=").append(local_ip);
            queryParams.append("&wlan_user_ipv6=");
            queryParams.append("&wlan_user_mac=000000000000");
            queryParams.append("&wlan_ac_ip=");
            queryParams.append("&wlan_ac_name=");
            queryParams.append("&jsVersion=4.1.3");
            queryParams.append("&terminal_type=1");
            queryParams.append("&lang=").append("zh-cn,zh");
            queryParams.append("&v=9637");

            requestUrl += queryParams.toString();

            // Create a URL object from the request URL string
            URL url = new URL(requestUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            // Check the response code to determine the success of the request
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response content
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Assuming the response string is stored in a variable called "response"
                int startIndex = response.indexOf("(") + 1;
                int endIndex = response.lastIndexOf(")");
                String jsonResponse = response.substring(startIndex, endIndex);

// Parse the JSON response and extract the "msg" field
                ResponseData jsonObject = JSON.parseObject(jsonResponse, ResponseData.class);

                String msg = jsonObject.msg;
                System.out.println(msg);
                if (msg.equals("Portal协议认证成功！") || msg.equals("IP: " + local_ip + " 已经在线！")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录成功！");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录失败，请重试！");
                }

            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "登录失败，请重试！");
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public LoginFrame() {
        setTitle("山西农业大学校园网登录程序");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //获取到屏幕尺寸
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);   //居中位置就是：屏幕尺寸/2 - 窗口尺寸/2
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
//        try {
//            UIManager.setLookAndFeel(new NimbusLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            throw new RuntimeException(e);
//        }
        LoginMenu loginMenu = new LoginMenu();
        JMenuBar bar = loginMenu.CreateMenuBar();
        setJMenuBar(bar);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        JLabel usernameLabel = new JLabel("学号:");
        usernameLabel.setFont(new Font("Songti SC", Font.BOLD, 15));
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("Songti SC", Font.BOLD, 15));
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("登录");
        rememberBox = new JCheckBox("记住信息");
        rememberBox.setSelected(true); //默认设置为true
        readInfo();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(new Label());
        panel.add(rememberBox);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInfo();
                sendRequest();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
