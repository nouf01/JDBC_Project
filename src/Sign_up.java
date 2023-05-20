/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nouf3
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Sign_up extends javax.swing.JFrame {

    /**
     * Creates new form Sign_up
     */
    public Sign_up() {
        initComponents();
        Show_Custs_In_JTable();
        Show_Cars_In_JTable();
    }

    public Connection getConnection()
   {
       Connection con;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/Car_shop", "root","Nn2021s");
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
// to get & show customer:
   public ArrayList<Customer> getCustList()
   {
       ArrayList<Customer> custList = new ArrayList<Customer>();
       Connection connection = getConnection();
       
       
       String query = "SELECT * FROM  `customer`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Customer cust;
           while(rs.next())
           {
               cust = new Customer(rs.getString("National_id"),rs.getString("Fname"),rs.getString("Mname"),rs.getString("Lname"),rs.getString("Phone"),rs.getString("Street"),rs.getString("City"),rs.getString("Zip_code"),rs.getString("Dob"));
               custList.add(cust);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return custList;
   }
   
   public ArrayList<Car> getCarList()
   {
       ArrayList<Car> custList = new ArrayList<Car>();
       Connection connection = getConnection();
       
       
       String query = "SELECT * FROM  `Car`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Car car;
           while(rs.next())
           {
               car = new Car(rs.getString("Register_num"),rs.getString("Manufacturer"),rs.getString("Model"),rs.getString("Plate"),rs.getInt("Year"),rs.getInt("Price"),rs.getInt("Branch_id"));
               custList.add(car);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return custList;
   }
   
   public void getSearchedList(String Query, String message)
   {
       ArrayList<Car> carList = new ArrayList<Car>();
       Connection connection = getConnection();
       
       
       String query = Query;
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Car car;
           while(rs.next())
           {
               car = new Car(rs.getString("Register_num"),rs.getString("Manufacturer"),rs.getString("Model"),rs.getString("Plate"),rs.getInt("Year"),rs.getInt("Price"),rs.getInt("Branch_id"));
               carList.add(car);
           }
            DefaultTableModel model = (DefaultTableModel)jTable_Car.getModel();
            model.setRowCount(0);
           Object[] row = new Object[7];
           for(int i = 0; i < carList.size(); i++)
           {
               row[0] = carList.get(i).getRegister_num();
               row[1] = carList.get(i).getManufacturer();
               row[2] = carList.get(i).getModel();
               row[3] = carList.get(i).getPlate();
               row[4] = carList.get(i).getYear();
               row[5] = carList.get(i).getPrice();
               row[6] = carList.get(i).getBranch_id();
               model.addRow(row);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

public void Show_Cars_In_JTable()
   {
       ArrayList<Car> list = getCarList();
       DefaultTableModel model = (DefaultTableModel)jTable_Car.getModel();
       Object[] row = new Object[7];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getRegister_num();
           row[1] = list.get(i).getManufacturer();
           row[2] = list.get(i).getModel();
           row[3] = list.get(i).getPlate();
           row[4] = list.get(i).getYear();
           row[5] = list.get(i).getPrice();
           row[6] = list.get(i).getBranch_id();
           model.addRow(row);
       }
    } 

public void Show_Custs_In_JTable()
   {
       ArrayList<Customer> list = getCustList();
       DefaultTableModel model = (DefaultTableModel)jTable1_Display_Custs.getModel();
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           if(list.get(i).getNational_id().equals(jTextField3_nationID.getText())){
               row[0] = list.get(i).getNational_id();
               row[1] = list.get(i).getFname();
               row[2] = list.get(i).getMname();
               row[3] = list.get(i).getLname();
               row[4] = list.get(i).getPhone();
               row[5] = list.get(i).getStreet();
               row[6] = list.get(i).getCity();
               row[7] = list.get(i).getZip_code();
               row[8] = list.get(i).getDob();
               model.addRow(row);
           }
       }
    }

public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable1_Display_Custs.getModel();
               model.setRowCount(0);
               Show_Custs_In_JTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1_Fname = new javax.swing.JTextField();
        jTextField2_Lname = new javax.swing.JTextField();
        jTextField3_nationID = new javax.swing.JTextField();
        jTextField4_Mname = new javax.swing.JTextField();
        jTextField6_Phone = new javax.swing.JTextField();
        jTextField7_Street = new javax.swing.JTextField();
        jTextField8_DOB = new javax.swing.JTextField();
        jTextField9_city = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_Display_Custs = new javax.swing.JTable();
        jButton1_insert = new javax.swing.JButton();
        jButton2_update = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_Year = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Car = new javax.swing.JTable();
        jButton_searchCar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField5_ZIP1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("National ID:");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 85, -1, 33));

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("First Name:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 127, -1, 33));

        jLabel3.setBackground(new java.awt.Color(153, 204, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Zip Code:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 552, -1, 45));

        jLabel4.setBackground(new java.awt.Color(153, 204, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Middle Name:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 179, -1, 45));

        jLabel5.setBackground(new java.awt.Color(153, 204, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Last Name:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 233, -1, 45));

        jLabel6.setBackground(new java.awt.Color(153, 204, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Phone:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 287, -1, 30));

        jLabel7.setBackground(new java.awt.Color(153, 204, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Date of Birth:");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 352, -1, 45));

        jLabel8.setBackground(new java.awt.Color(153, 204, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("City:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 424, -1, 45));

        jLabel9.setBackground(new java.awt.Color(153, 204, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Street:");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 478, -1, 45));

        jTextField1_Fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1_Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_FnameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1_Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 133, 147, -1));

        jTextField2_Lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2_Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_LnameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2_Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 245, 147, -1));

        jTextField3_nationID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3_nationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_nationIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3_nationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 91, 147, -1));

        jTextField4_Mname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4_Mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_MnameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4_Mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 191, 147, -1));

        jTextField6_Phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6_Phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6_PhoneActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 302, 147, -1));

        jTextField7_Street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7_Street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7_StreetActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7_Street, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 500, 147, -1));

        jTextField8_DOB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8_DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8_DOBActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8_DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 364, 147, -1));

        jTextField9_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9_cityActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField9_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 436, 147, -1));

        jTable1_Display_Custs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "National ID", "First Name", "Middle Name", "Last Name:", "Phone", "Date of Birth", "City", "Street", "Zip Code"
            }
        ));
        jTable1_Display_Custs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_Display_CustsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_Display_Custs);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 739, 945, 71));

        jButton1_insert.setBackground(new java.awt.Color(51, 204, 0));
        jButton1_insert.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1_insert.setText("Insert");
        jButton1_insert.setActionCommand("Insert");
        jButton1_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_insertActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 606, -1, -1));

        jButton2_update.setBackground(new java.awt.Color(51, 204, 0));
        jButton2_update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2_update.setText("Update");
        jButton2_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_updateActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 606, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Enter Your Info:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 59, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 0));
        jLabel11.setText("Welcome");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 16, -1, -1));

        jLabel12.setBackground(new java.awt.Color(153, 204, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Enter Year:");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 137, -1, 33));

        jTextField_Year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_YearActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 143, 147, -1));

        jTable_Car.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Register_num", "Manufacturer", "Model", "Plate", "Year", "Price", "Branch_id"
            }
        ));
        jScrollPane2.setViewportView(jTable_Car);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 176, 836, 290));

        jButton_searchCar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_searchCar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton_searchCar.setText("Search");
        jButton_searchCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchCarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_searchCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 132, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 0));
        jLabel14.setText("Cars");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(881, 85, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 204, 0));
        jLabel15.setText("Your Personal Information");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 704, -1, -1));

        jTextField5_ZIP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5_ZIP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_ZIP1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5_ZIP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 574, 147, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1338, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 1340));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 204, 0));
        jLabel19.setText("Add New Payment");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 859, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_FnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_FnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_FnameActionPerformed

    private void jTextField2_LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_LnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_LnameActionPerformed

    private void jTextField3_nationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_nationIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_nationIDActionPerformed

    private void jTextField4_MnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_MnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_MnameActionPerformed

    private void jTextField6_PhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6_PhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6_PhoneActionPerformed

    private void jTextField7_StreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7_StreetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7_StreetActionPerformed

    private void jTextField8_DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8_DOBActionPerformed

    private void jTextField9_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9_cityActionPerformed

    private void jButton1_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_insertActionPerformed
        String query = "INSERT INTO `customer` VALUES ('"+jTextField3_nationID.getText()+"','"+jTextField1_Fname.getText()+"','"+jTextField4_Mname.getText()+"','"+jTextField2_Lname.getText()+"','"+jTextField6_Phone.getText()+"','"+jTextField7_Street.getText()+"','"+jTextField9_city.getText()+"','"+jTextField5_ZIP1.getText()+"','"+jTextField8_DOB.getText()+"')";
        
        executeSQlQuery(query, "Inserted");
    }//GEN-LAST:event_jButton1_insertActionPerformed

    private void jButton2_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_updateActionPerformed
       String query = "UPDATE `customer` SET `Fname`='"+jTextField1_Fname.getText()+"',`Mname`='"+jTextField4_Mname.getText()+"',`Lname`='"+jTextField2_Lname.getText()+"',`Phone`='"+jTextField6_Phone.getText()+"',`Street`='"+jTextField7_Street.getText()+"',`City`='"+jTextField9_city.getText()+"',`Zip_Code`='"+jTextField5_ZIP1.getText()+"',`Dob`='"+jTextField8_DOB.getText()+"' WHERE `National_id` = '"+jTextField3_nationID.getText()+"'";
       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_jButton2_updateActionPerformed

    private void jTable1_Display_CustsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_Display_CustsMouseClicked
        // Get The Index Of The Slected Row 
        int i = jTable1_Display_Custs.getSelectedRow();

        TableModel model = jTable1_Display_Custs.getModel();
        
         // Display Slected Row In JTexteFields
        jTextField3_nationID.setText(model.getValueAt(i,0).toString());
        jTextField1_Fname.setText(model.getValueAt(i,1).toString());
        jTextField4_Mname.setText(model.getValueAt(i,2).toString());
        jTextField2_Lname.setText(model.getValueAt(i,3).toString());
        jTextField6_Phone.setText(model.getValueAt(i,4).toString());
        jTextField7_Street.setText(model.getValueAt(i,5).toString());
        jTextField9_city.setText(model.getValueAt(i,6).toString());
        jTextField5_ZIP1.setText(model.getValueAt(i,7).toString());
        jTextField8_DOB.setText(model.getValueAt(i,8).toString());
    }//GEN-LAST:event_jTable1_Display_CustsMouseClicked

    private void jTextField_YearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_YearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_YearActionPerformed

    private void jButton_searchCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchCarActionPerformed
        String query = "SELECT * FROM `car` WHERE `Year` = "+jTextField_Year.getText();
        
        getSearchedList(query, "Searched");
    }//GEN-LAST:event_jButton_searchCarActionPerformed

    private void jTextField5_ZIP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_ZIP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_ZIP1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_insert;
    private javax.swing.JButton jButton2_update;
    private javax.swing.JButton jButton_searchCar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1_Display_Custs;
    private javax.swing.JTable jTable_Car;
    private javax.swing.JTextField jTextField1_Fname;
    private javax.swing.JTextField jTextField2_Lname;
    private javax.swing.JTextField jTextField3_nationID;
    private javax.swing.JTextField jTextField4_Mname;
    private javax.swing.JTextField jTextField5_ZIP1;
    private javax.swing.JTextField jTextField6_Phone;
    private javax.swing.JTextField jTextField7_Street;
    private javax.swing.JTextField jTextField8_DOB;
    private javax.swing.JTextField jTextField9_city;
    private javax.swing.JTextField jTextField_Year;
    // End of variables declaration//GEN-END:variables
}
