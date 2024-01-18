package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JTextField tfname,tffname,tfsal,tfphone,tfemail,tfdesign,tfaadhar,tfadd;
     JDateChooser dc;
     JComboBox cedu;
     JLabel lbempid;
      JButton add;
      JButton back;
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading =new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        JLabel lname=new JLabel("Name");
        lname.setBounds(50,150,150,30);
        lname.setFont(new Font("Serif",Font.PLAIN,20));
        add(lname);
         tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
         JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("Serif",Font.PLAIN,20));
        add(fname);
          tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
         JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("Serif",Font.PLAIN,20));
        add(dob);
        dc=new JDateChooser();
       dc.setBounds(200,200,150,30);
       add(dc);
       JLabel lsalary=new JLabel("Salary");
        lsalary.setBounds(400,200,150,30);
        lsalary.setFont(new Font("Serif",Font.PLAIN,20));
        add(lsalary);
          tfsal=new JTextField();
        tfsal.setBounds(600,200,150,30);
        add(tfsal);
        JLabel laddress=new JLabel("Address_e");
        laddress.setBounds(50,250,150,30);
        laddress.setFont(new Font("Serif",Font.PLAIN,20));
        add(laddress);
           tfadd=new JTextField();
        tfadd.setBounds(200,250,150,30);
        add(tfadd);
        JLabel lphone=new JLabel("Phone");
        lphone.setBounds(400,250,150,30);
        lphone.setFont(new Font("Serif",Font.PLAIN,20));
        add(lphone);
          tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
         JLabel lemail=new JLabel("Email");
        lemail.setBounds(50,300,150,30);
        lemail.setFont(new Font("Serif",Font.PLAIN,20));
        add(lemail);
         tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        JLabel leducation=new JLabel("Education");
        leducation.setBounds(400,300,150,30);
        leducation.setFont(new Font("Serif",Font.PLAIN,20));
        add(leducation);
        String courses[]={"Btech","BBA","BA","BCA","BCOM","MBA","MTECH","MSC"};
           cedu=new JComboBox(courses);
          cedu.setBackground(Color.WHITE);
        cedu.setBounds(600,300,150,30);
        add(cedu);
        JLabel ldesign;
        ldesign = new JLabel("Designation_e");
        ldesign.setBounds(50,350,150,30);
        ldesign.setFont(new Font("Serif",Font.PLAIN,20));
        add(ldesign);
          tfdesign=new JTextField();
        tfdesign.setBounds(200,350,150,30);
        add(tfdesign);
        JLabel laadhar=new JLabel("Aadhar");
        laadhar.setBounds(400,350,150,30);
        laadhar.setFont(new Font("Serif",Font.PLAIN,20));
        add(laadhar);
           tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        JLabel lempid=new JLabel("Employee ID");
        lempid.setBounds(50,400,150,30);
        lempid.setFont(new Font("Serif",Font.PLAIN,20));
        add(lempid);
          lbempid=new JLabel(""+number);
        lbempid.setBounds(200,400,150,30);
        add(lbempid);
        add=new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        add.addActionListener(this);
         back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        //image.add(add);
        back.addActionListener(this);
       // add=new JButton("Add Employee");
        //add.setBounds(620,80,150,40);
      //  image.add(add);
        //add.addActionListener(this);
        
        
        
       
          
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();
            String salary=tfsal.getText();
            String address=tfadd.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)cedu.getSelectedItem();
            String designation=tfdesign.getText();
            String aadhar=tfaadhar.getText();
            String empId=lbempid.getText();
          //  String address=tfadd.getText();
            try{
                con ce=new con();
                String query="insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                ce.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new AddEmployee();
    }
    
}
