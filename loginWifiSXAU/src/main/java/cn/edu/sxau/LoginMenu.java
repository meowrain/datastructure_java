package cn.edu.sxau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginMenu{
    JMenuBar bar;
    JMenu menu;
    public LoginMenu(){
        bar = new JMenuBar();
        menu = new JMenu();
        menu.setText("菜单");
        JMenuItem item = new JMenuItem("关于");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(item,"山西农业大学校园网登录客户端\nMade by Meowrain", "关于", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.add(item);
        bar.add(menu);

    }

    public JMenuBar CreateMenuBar() {
        return bar;
    }

}
