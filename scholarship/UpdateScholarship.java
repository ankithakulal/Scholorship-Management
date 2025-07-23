
package scholarship;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateScholarship extends JFrame implements ActionListener{
    
    JTextField tftypee,tfname, tfid, tfamount, tfcrit;
    JLabel lblid;
    JButton add, back;
    String id;
    
    
    UpdateScholarship(String id) {
        this.id = id;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update scholarship details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        
        JLabel labelid = new JLabel("ID:");
        labelid.setBounds(400, 150, 150, 30);
        labelid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelid);
        
        lblid= new JLabel();
        lblid.setBounds(600, 150, 150, 30);
        lblid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblid);
        
        
        
        
        JLabel labeltypee = new JLabel("Type:");
        labeltypee.setBounds(50, 200, 150, 30);
        labeltypee.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltypee);
        
        
        tftypee = new JTextField();
        
        tftypee.setBounds(200,200, 150, 30);
        add(tftypee);
        
        
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
        
        try {
            Conn c = new Conn();
            String query = "select * from addscholarship where id='"+id+"'";
           ResultSet rs = c.s.executeQuery(query);
           while (rs.next()) {
              lblname.setText(rs.getString("name"));
              lblid.setText(rs.getString("id"));
              tftypee.setText(rs.getString("typee"));
              tfamount.setText(rs.getString("amount"));
              tfcrit.setText(rs.getString("eligibility"));
              
              
           
           }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton ("Update Details");
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
            
            
            String typee = tftypee.getText();
            String amount = tfamount.getText();
            String eligibility = tfcrit.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "update addscholarship set typee='"+typee+"',amount='"+amount+"',eligibility='"+eligibility+"' where id= '"+id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateScholarship("");
    }
    
}
