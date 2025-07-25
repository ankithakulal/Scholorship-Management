
package scholarship;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add, view, update, remove;
    
    Home() {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Scholarship Management");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("tahoma",Font.BOLD,25 ));
        image.add(heading);
        
        
        
        add = new JButton ("Add Scholarship");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton ("View Scholarship");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton ("update Scholarship");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton ("remove Scholarship");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
          setVisible(false);
          new AddScholarship();
        } else if (ae.getSource() == view){
            setVisible(false);
            new ViewScholarship();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewScholarship();
        } else {
            setVisible(false);
            new RemoveScholarship();
        }       
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
    
}
