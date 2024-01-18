
package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeid;
    JButton search,print,update,back;
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lsearch=new JLabel("Search by employee ID");
        lsearch.setBounds(20,20,150,20);
        add(lsearch);
        cemployeeid=new Choice();
        cemployeeid.setBounds(180,20,150,20);
        add(cemployeeid);
       // table =new JTable();
        try{
            con c=new con();
            ResultSet rs=c.st.executeQuery("Select * from employee");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                cemployeeid.add(rs.getString("empID"));
            }
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table =new JTable();
        try{
            con c=new con();
            ResultSet rs=c.st.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
          
            
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        search=new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        print=new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        update=new JButton("update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        back=new JButton("back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
                
                
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="Select * from employee where empID='"+cemployeeid.getSelectedItem()+"'";
            try{
                con c=new con();
                ResultSet rs=c.st.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==print){
            try{
                table.print();
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==update){
           setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
            
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    
    
    
    
    
    public static void main(String[] args){
        new ViewEmployee();
    }
    
}
