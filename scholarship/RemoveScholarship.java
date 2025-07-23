
package scholarship;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveScholarship extends JFrame implements ActionListener {
    Choice cid;
    JButton delete, back;
    RemoveScholarship() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelid = new JLabel("ID");
        labelid.setBounds(50, 50, 100, 30);
        add(labelid);
        
        cid = new Choice();
        cid.setBounds(200, 50, 100, 30);
        add(cid);
        
        try {
            Conn c = new Conn();
            String query = "select * from addscholarship";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cid.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelamount = new JLabel("Amount");
        labelamount.setBounds(50, 150, 100, 30);
        add(labelamount);
        
        JLabel lblamount = new JLabel();
        lblamount.setBounds(200, 150, 100, 30);
        add(lblamount);
        
        JLabel labeleligibility = new JLabel("Eligibility");
        labeleligibility.setBounds(50, 200, 100, 30);
        add(labeleligibility);
        
        JLabel lbleligibility = new JLabel();
        lbleligibility.setBounds(200, 200, 100, 30);
        add(lbleligibility);
        
        try {
            Conn c = new Conn();
            String query = "select * from addscholarship where id = '"+cid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblamount.setText(rs.getString("amount"));
                lbleligibility.setText(rs.getString("eligibility"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         cid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from addscholarship where id = '"+cid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblamount.setText(rs.getString("amount"));
                        lbleligibility.setText(rs.getString("eligibility"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
         
         delete = new JButton("Delete");
         delete.setBounds(80, 300, 100, 30);
         delete.setBackground(Color.BLACK);
         delete.setForeground(Color.WHITE);
         delete.addActionListener(this);
         add(delete);
         
         back = new JButton("Back");
         back.setBounds(220, 300, 100, 30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from addscholarship where id = '"+cid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Scholarship detils deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
        
    }
    
    public static void main(String[] args) {
        new RemoveScholarship();
    }
}
