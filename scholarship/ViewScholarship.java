
package scholarship;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewScholarship extends JFrame implements ActionListener{
    
    JTable table;
    Choice cid;
    JButton search, print, update, back;
    
    ViewScholarship() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Seach by ID");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cid = new Choice();
        cid.setBounds(180, 20, 150, 20);
        add(cid);
        
         try {
            Conn c =  new Conn();
            ResultSet rs = c.s.executeQuery("select * from addscholarship");
            
            
            while(rs.next()) {
                cid.add(rs.getString("id"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c =  new Conn();
            ResultSet rs = c.s.executeQuery("select * from addscholarship");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
         
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == search) {
            String query = "select * from addscholarship where ID = '"+cid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource()==print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateScholarship(cid.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
}
    
    public static void main (String[] args) {
        new ViewScholarship();
    }
    
}
