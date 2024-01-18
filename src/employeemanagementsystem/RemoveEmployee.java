
package employeemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    JButton delete,back;
    Choice cempid;
    
    
    
   RemoveEmployee(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       JLabel lbempid=new JLabel("Employee Id");
       lbempid.setBounds(50,50,150,30);
       add(lbempid);
       cempid=new Choice();
       cempid.setBounds(200,50,100,30);
       add(cempid);
       try{
           con c=new con();
           String query="Select * from employee";
           ResultSet rs=c.st.executeQuery(query);
           while(rs.next()){
               cempid.add(rs.getString("empId"));
           
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       JLabel lbname=new JLabel("Name");
   lbname.setBounds(50,100,100,30);
   add(lbname);
   JLabel lblname=new JLabel();
   lblname.setBounds(200,100,100,30);
   add(lblname);
    JLabel lbphone=new JLabel("phone");
   lbphone.setBounds(50,150,100,30);
   add(lbphone);
   JLabel lblphone=new JLabel();
   lblphone.setBounds(200,150,100,30);
   add(lblphone);
   JLabel lbemail=new JLabel("email");
   lbemail.setBounds(50,200,100,30);
   add(lbemail);
   JLabel lblemail=new JLabel();
   lblemail.setBounds(200,200,100,30);
   add(lblemail);
    try{
           con c=new con();
           String query="Select * from employee where empId='"+cempid.getSelectedItem()+"'";
           ResultSet rs=c.st.executeQuery(query);
           while(rs.next()){
              // cempid.add(rs.getString("empId"));
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phone"));
               lblemail.setText(rs.getString("email"));
               
           
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    cempid.addItemListener((ItemEvent ae) -> {
          try{
           con c=new con();
           String query="Select * from employee where empId='"+cempid.getSelectedItem()+"'";
           ResultSet rs=c.st.executeQuery(query);
           while(rs.next()){
              // cempid.add(rs.getString("empId"));
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phone"));
               lblemail.setText(rs.getString("email"));
               
           
           }
       }catch(Exception e){
           e.printStackTrace();
       }
        
       });
    delete=new JButton("Delete");
    delete.setBounds(80,300,100,30);
    delete.setBackground(Color.BLACK);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(this);
    add(delete);
     back=new JButton("Back");
    back.setBounds(220,300,100,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/remove.jpg"));
       Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
      
        image.setBounds(350,10,600,400);
        add(image);
    
   
   
   
       setSize(1000,400);
       setLocation(300,150);
       setVisible(true);
       
   }
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==delete){
           try{
               con c=new con();
               String query="delete from employee where empId='"+cempid.getSelectedItem()+"'";
               c.st.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee information deleted successfully");
               setVisible(false);
               new Home();
               
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
           
       }
       else{
           setVisible(false);
           new Home();
       }
       
   }
   
   
    public static void main(String[] args){
        
        
        
        new RemoveEmployee();
        
    }
    
}
