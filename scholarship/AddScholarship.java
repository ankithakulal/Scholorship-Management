
package scholarship;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class AddScholarship extends JFrame implements ActionListener{
    
    JTextField tfname, tfid, tfamount, tfcrit;
    JComboBox cbtypee;
    JButton add, back;
    
    
    AddScholarship() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add scholarship details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        
        JLabel labelid = new JLabel("ID:");
        labelid.setBounds(400, 150, 150, 30);
        labelid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelid);
        
        tfid = new JTextField();
        tfid.setBounds(600, 150, 150, 30);
        add(tfid);
        
        
        JLabel labeltypee = new JLabel("Type:");
        labeltypee.setBounds(50, 200, 150, 30);
        labeltypee.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltypee);
        
        String courses[] = {"Merit-Based Scholarships","Need-Based Scholarships","Category-Specific Scholarships","Location-Based Scholarships","Special Interest Scholarships"};
        
        cbtypee = new JComboBox(courses);
        cbtypee.setBounds(200,200, 150, 30);
        add(cbtypee);
        
        
        JLabel labelamount = new JLabel("Amount:");
        labelamount.setBounds(400, 200, 150, 30);
        labelamount.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelamount);
        
        tfamount = new JTextField();
        tfamount.setBounds(600, 200, 150, 30);
        add(tfamount);
        
        
        JLabel labelcrit = new JLabel("Eligibility:");
        labelcrit.setBounds(50, 250, 150, 30);
        labelcrit.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcrit);
        
        tfcrit = new JTextField();
        tfcrit.setBounds(200, 250, 150, 30);
        add(tfcrit);
        
        add = new JButton ("Add");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton ("Back");
        back.setBounds(450, 550, 150, 40);
        add.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String id = tfid.getText();
            String typee = (String) cbtypee.getSelectedItem();
            String amount = tfamount.getText();
            String eligibility = tfcrit.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "insert into addscholarship values('"+name+"','"+id+"','"+typee+"','"+amount+"','"+eligibility+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            }  catch (Exception e) {
                e.printStackTrace();
            }
                
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new AddScholarship();
    }
    
}
