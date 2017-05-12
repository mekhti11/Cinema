
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

/**
 *
 * @author mekhti
 */
public class SalonCalisan extends javax.swing.JFrame {

    int gosterimId,id;
    Connection connection;
    Statement statement;
    ResultSet result;

    /**
     * Creates new form SalonCalisan
     */
    public SalonCalisan(int gosterimId) {
        this.gosterimId = gosterimId;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buton27 = new javax.swing.JButton();
        buton28 = new javax.swing.JButton();
        buton29 = new javax.swing.JButton();
        buton30 = new javax.swing.JButton();
        buton31 = new javax.swing.JButton();
        buton32 = new javax.swing.JButton();
        buton33 = new javax.swing.JButton();
        buton34 = new javax.swing.JButton();
        buton35 = new javax.swing.JButton();
        buton36 = new javax.swing.JButton();
        buton37 = new javax.swing.JButton();
        buton38 = new javax.swing.JButton();
        buton39 = new javax.swing.JButton();
        buton40 = new javax.swing.JButton();
        buton41 = new javax.swing.JButton();
        buton42 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buton1 = new javax.swing.JButton();
        buton2 = new javax.swing.JButton();
        buton43 = new javax.swing.JButton();
        buton44 = new javax.swing.JButton();
        buton45 = new javax.swing.JButton();
        buton3 = new javax.swing.JButton();
        buton4 = new javax.swing.JButton();
        buton5 = new javax.swing.JButton();
        buton6 = new javax.swing.JButton();
        buton7 = new javax.swing.JButton();
        buton8 = new javax.swing.JButton();
        buton9 = new javax.swing.JButton();
        buton10 = new javax.swing.JButton();
        buton11 = new javax.swing.JButton();
        buton12 = new javax.swing.JButton();
        buton13 = new javax.swing.JButton();
        buton14 = new javax.swing.JButton();
        buton15 = new javax.swing.JButton();
        buton16 = new javax.swing.JButton();
        buton17 = new javax.swing.JButton();
        buton18 = new javax.swing.JButton();
        buton19 = new javax.swing.JButton();
        buton20 = new javax.swing.JButton();
        buton21 = new javax.swing.JButton();
        buton22 = new javax.swing.JButton();
        buton23 = new javax.swing.JButton();
        buton24 = new javax.swing.JButton();
        buton25 = new javax.swing.JButton();
        buton26 = new javax.swing.JButton();
        blackButon = new javax.swing.JButton();
        redButon = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        JButton[] buttons = new JButton[46];
        buttons[1] = buton1;
        buttons[2] = buton2;        
        buttons[3] = buton3;
        buttons[4] = buton4;
        buttons[5] = buton5;
        buttons[6] = buton6;
        buttons[7] = buton7;
        buttons[8] = buton8;
        buttons[9] = buton9;
        buttons[10] = buton10;
        buttons[11] = buton11;
        buttons[12] = buton12;
        buttons[13] = buton13;
        buttons[14] = buton14;
        buttons[15] = buton15;
        buttons[16] = buton16;
        buttons[17] = buton17;
        buttons[18] = buton18;
        buttons[19] = buton19;
        buttons[20] = buton20;
        buttons[21] = buton21;
        buttons[22] = buton22;
        buttons[23] = buton23;
        buttons[24] = buton24;
        buttons[25] = buton25;
        buttons[26] = buton26;
        buttons[27] = buton27;
        buttons[28] = buton28;
        buttons[29] = buton29;
        buttons[30] = buton30;
        buttons[31] = buton31;
        buttons[32] = buton32;
        buttons[33] = buton33;
        buttons[34] = buton34;
        buttons[35] = buton35;
        buttons[36] = buton36;
        buttons[37] = buton37;
        buttons[38] = buton38;
        buttons[39] = buton39;
        buttons[40] = buton40;
        buttons[41] = buton41;
        buttons[42] = buton42;
        buttons[43] = buton43;
        buttons[44] = buton44;
        buttons[45] = buton45;

        redButon.setBackground(Color.red);
        blackButon.setBackground(Color.BLACK);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setText("                                    PERDE");

         try{
            String sql = "SELECT * FROM `Koltuk` WHERE `GosterimId` = " + gosterimId;
            //System.out.println(sql);
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            int i=1;
            while(result.next()){
                int value = (int) result.getInt("value");
                if(value ==  0){
                    buttons[i].setBackground(Color.RED);
                    buttons[i].setEnabled(false);
                }else{
                    buttons[i].setBackground(Color.BLACK);
                }
                i++;
            }
        }catch(Exception e){System.out.println(e);}

        buton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton27ActionPerformed(evt);
            }
        });

        buton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton28ActionPerformed(evt);
            }
        });

        buton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton29ActionPerformed(evt);
            }
        });

        buton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton30ActionPerformed(evt);
            }
        });

        buton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton31ActionPerformed(evt);
            }
        });

        buton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton32ActionPerformed(evt);
            }
        });

        buton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton33ActionPerformed(evt);
            }
        });

        buton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton34ActionPerformed(evt);
            }
        });

        buton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton35ActionPerformed(evt);
            }
        });

        buton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton36ActionPerformed(evt);
            }
        });

        buton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton37ActionPerformed(evt);
            }
        });

        buton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton38ActionPerformed(evt);
            }
        });

        buton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton39ActionPerformed(evt);
            }
        });

        buton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton40ActionPerformed(evt);
            }
        });

        buton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton41ActionPerformed(evt);
            }
        });

        buton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton42ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setText("                                    PERDE");

        buton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton1ActionPerformed(evt);
            }
        });

        buton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton2ActionPerformed(evt);
            }
        });

        buton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton43ActionPerformed(evt);
            }
        });

        buton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton44ActionPerformed(evt);
            }
        });

        buton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton45ActionPerformed(evt);
            }
        });

        buton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton3ActionPerformed(evt);
            }
        });

        buton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton4ActionPerformed(evt);
            }
        });

        buton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton5ActionPerformed(evt);
            }
        });

        buton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton6ActionPerformed(evt);
            }
        });

        buton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton7ActionPerformed(evt);
            }
        });

        buton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton8ActionPerformed(evt);
            }
        });

        buton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton9ActionPerformed(evt);
            }
        });

        buton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton10ActionPerformed(evt);
            }
        });

        buton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton11ActionPerformed(evt);
            }
        });

        buton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton12ActionPerformed(evt);
            }
        });

        buton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton13ActionPerformed(evt);
            }
        });

        buton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton14ActionPerformed(evt);
            }
        });

        buton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton15ActionPerformed(evt);
            }
        });

        buton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton16ActionPerformed(evt);
            }
        });

        buton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton17ActionPerformed(evt);
            }
        });

        buton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton18ActionPerformed(evt);
            }
        });

        buton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton19ActionPerformed(evt);
            }
        });

        buton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton20ActionPerformed(evt);
            }
        });

        buton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton21ActionPerformed(evt);
            }
        });

        buton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton22ActionPerformed(evt);
            }
        });

        buton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton23ActionPerformed(evt);
            }
        });

        buton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton24ActionPerformed(evt);
            }
        });

        buton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton25ActionPerformed(evt);
            }
        });

        buton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton26ActionPerformed(evt);
            }
        });

        blackButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackButonActionPerformed(evt);
            }
        });

        redButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButonActionPerformed(evt);
            }
        });

        jLabel3.setText("TAKEN");

        jLabel4.setText("EMPTY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(buton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(buton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(buton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(buton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buton19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buton27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buton28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buton37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buton35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buton44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buton45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(blackButon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(redButon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(buton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buton28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buton37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blackButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void koltukSahibi(int id){
        try {
            int userId = 0;
            String sql = "SELECT * FROM `Koltuk` WHERE `koltukId` = "+id;
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next())
                userId = (Integer) result.getInt("userID");
            KoltukSahibiGoruntule ksg = new KoltukSahibiGoruntule(userId);
            ksg.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SalonCalisan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton27ActionPerformed
        id = (gosterimId-1)*45 + 27;
        koltukSahibi(id);
    }//GEN-LAST:event_buton27ActionPerformed

    private void buton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton28ActionPerformed
       id = (gosterimId-1)*45 + 28;
       koltukSahibi(id);
    }//GEN-LAST:event_buton28ActionPerformed

    private void buton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton29ActionPerformed
        id = (gosterimId-1)*45 + 29;
        koltukSahibi(id);
    }//GEN-LAST:event_buton29ActionPerformed

    private void buton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton30ActionPerformed
        id = (gosterimId-1)*45 + 30;
       koltukSahibi(id);
    }//GEN-LAST:event_buton30ActionPerformed

    private void buton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton31ActionPerformed
        id = (gosterimId-1)*45 + 31;
       koltukSahibi(id);
    }//GEN-LAST:event_buton31ActionPerformed

    private void buton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton32ActionPerformed
        id = (gosterimId-1)*45 + 32;
       koltukSahibi(id);
    }//GEN-LAST:event_buton32ActionPerformed

    private void buton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton33ActionPerformed
        id = (gosterimId-1)*45 + 33;
       koltukSahibi(id);
    }//GEN-LAST:event_buton33ActionPerformed

    private void buton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton34ActionPerformed
       id = (gosterimId-1)*45 + 34;
       koltukSahibi(id);
    }//GEN-LAST:event_buton34ActionPerformed

    private void buton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton35ActionPerformed
        id = (gosterimId-1)*45 +35 ;
       koltukSahibi(id);
    }//GEN-LAST:event_buton35ActionPerformed

    private void buton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton36ActionPerformed
       id = (gosterimId-1)*45 + 36;
       koltukSahibi(id);
    }//GEN-LAST:event_buton36ActionPerformed

    private void buton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton37ActionPerformed
        id = (gosterimId-1)*45 + 37;
       koltukSahibi(id);
    }//GEN-LAST:event_buton37ActionPerformed

    private void buton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton38ActionPerformed
       id = (gosterimId-1)*45 + 38;        koltukSahibi(id);
    }//GEN-LAST:event_buton38ActionPerformed

    private void buton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton39ActionPerformed
       id = (gosterimId-1)*45 + 39;
       koltukSahibi(id);
    }//GEN-LAST:event_buton39ActionPerformed

    private void buton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton40ActionPerformed
      id = (gosterimId-1)*45 + 40;
       koltukSahibi(id);
    }//GEN-LAST:event_buton40ActionPerformed

    private void buton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton41ActionPerformed
       id = (gosterimId-1)*45 + 41;
       koltukSahibi(id);
    }//GEN-LAST:event_buton41ActionPerformed

    private void buton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton42ActionPerformed
       id = (gosterimId-1)*45 + 42;
       koltukSahibi(id);
    }//GEN-LAST:event_buton42ActionPerformed

    private void buton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton2ActionPerformed
        id = (gosterimId-1)*45 + 2;
       koltukSahibi(id);
    }//GEN-LAST:event_buton2ActionPerformed

    private void buton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton43ActionPerformed
        id = (gosterimId-1)*45 + 43;
       koltukSahibi(id);
    }//GEN-LAST:event_buton43ActionPerformed

    private void buton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton44ActionPerformed
        id = (gosterimId-1)*45 + 44;
       koltukSahibi(id);
    }//GEN-LAST:event_buton44ActionPerformed

    private void buton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton45ActionPerformed
        id = (gosterimId-1)*45 + 45;
       koltukSahibi(id);
    }//GEN-LAST:event_buton45ActionPerformed

    private void buton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton3ActionPerformed
       id = (gosterimId-1)*45 + 3;        koltukSahibi(id);
    }//GEN-LAST:event_buton3ActionPerformed

    private void buton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton4ActionPerformed
        id = (gosterimId-1)*45 + 4;
       koltukSahibi(id);
    }//GEN-LAST:event_buton4ActionPerformed

    private void buton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton5ActionPerformed
        id = (gosterimId-1)*45 + 5;
       koltukSahibi(id);
    }//GEN-LAST:event_buton5ActionPerformed

    private void buton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton6ActionPerformed
        id = (gosterimId-1)*45 + 6;
       koltukSahibi(id);
    }//GEN-LAST:event_buton6ActionPerformed

    private void buton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton7ActionPerformed
       id = (gosterimId-1)*45 + 7;
       koltukSahibi(id);
    }//GEN-LAST:event_buton7ActionPerformed

    private void buton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton8ActionPerformed
      id = (gosterimId-1)*45 + 8;
       koltukSahibi(id);
    }//GEN-LAST:event_buton8ActionPerformed

    private void buton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton9ActionPerformed
       id = (gosterimId-1)*45 + 9;        koltukSahibi(id);
    }//GEN-LAST:event_buton9ActionPerformed

    private void buton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton10ActionPerformed
       id = (gosterimId-1)*45 + 10;        koltukSahibi(id);
    }//GEN-LAST:event_buton10ActionPerformed

    private void buton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton11ActionPerformed
       id = (gosterimId-1)*45 + 11;        koltukSahibi(id);
    }//GEN-LAST:event_buton11ActionPerformed

    private void buton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton12ActionPerformed
       id = (gosterimId-1)*45 + 12;        koltukSahibi(id);
    }//GEN-LAST:event_buton12ActionPerformed

    private void buton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton13ActionPerformed
       id = (gosterimId-1)*45 + 13;        koltukSahibi(id);
    }//GEN-LAST:event_buton13ActionPerformed

    private void buton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton14ActionPerformed
       id = (gosterimId-1)*45 + 14;        koltukSahibi(id);
    }//GEN-LAST:event_buton14ActionPerformed

    private void buton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton15ActionPerformed
       id = (gosterimId-1)*45 + 15;        koltukSahibi(id);
    }//GEN-LAST:event_buton15ActionPerformed

    private void buton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton16ActionPerformed
       id = (gosterimId-1)*45 + 16;        koltukSahibi(id);
    }//GEN-LAST:event_buton16ActionPerformed

    private void buton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton17ActionPerformed
       id = (gosterimId-1)*45 + 17;        koltukSahibi(id);
    }//GEN-LAST:event_buton17ActionPerformed

    private void buton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton18ActionPerformed
       id = (gosterimId-1)*45 + 18;        koltukSahibi(id);
    }//GEN-LAST:event_buton18ActionPerformed

    private void buton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton19ActionPerformed
       id = (gosterimId-1)*45 + 19;        koltukSahibi(id);
    }//GEN-LAST:event_buton19ActionPerformed

    private void buton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton20ActionPerformed
       id = (gosterimId-1)*45 + 20;        koltukSahibi(id);
    }//GEN-LAST:event_buton20ActionPerformed

    private void buton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton21ActionPerformed
       id = (gosterimId-1)*45 + 21;        koltukSahibi(id);
    }//GEN-LAST:event_buton21ActionPerformed

    private void buton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton22ActionPerformed
       id = (gosterimId-1)*45 + 22;        koltukSahibi(id);
    }//GEN-LAST:event_buton22ActionPerformed

    private void buton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton23ActionPerformed
       id = (gosterimId-1)*45 + 23;        koltukSahibi(id);
    }//GEN-LAST:event_buton23ActionPerformed

    private void buton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton24ActionPerformed
       id = (gosterimId-1)*45 + 24;        koltukSahibi(id);
    }//GEN-LAST:event_buton24ActionPerformed

    private void buton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton25ActionPerformed
       id = (gosterimId-1)*45 + 25;        koltukSahibi(id);
    }//GEN-LAST:event_buton25ActionPerformed

    private void buton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton26ActionPerformed
       id = (gosterimId-1)*45 + 26;        koltukSahibi(id);
    }//GEN-LAST:event_buton26ActionPerformed

    private void blackButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackButonActionPerformed
       
    }//GEN-LAST:event_blackButonActionPerformed

    private void redButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButonActionPerformed
       
    }//GEN-LAST:event_redButonActionPerformed

    private void buton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton1ActionPerformed
       id = (gosterimId-1)*45 + 1;        koltukSahibi(id);
    }//GEN-LAST:event_buton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blackButon;
    private javax.swing.JButton buton1;
    private javax.swing.JButton buton10;
    private javax.swing.JButton buton11;
    private javax.swing.JButton buton12;
    private javax.swing.JButton buton13;
    private javax.swing.JButton buton14;
    private javax.swing.JButton buton15;
    private javax.swing.JButton buton16;
    private javax.swing.JButton buton17;
    private javax.swing.JButton buton18;
    private javax.swing.JButton buton19;
    private javax.swing.JButton buton2;
    private javax.swing.JButton buton20;
    private javax.swing.JButton buton21;
    private javax.swing.JButton buton22;
    private javax.swing.JButton buton23;
    private javax.swing.JButton buton24;
    private javax.swing.JButton buton25;
    private javax.swing.JButton buton26;
    private javax.swing.JButton buton27;
    private javax.swing.JButton buton28;
    private javax.swing.JButton buton29;
    private javax.swing.JButton buton3;
    private javax.swing.JButton buton30;
    private javax.swing.JButton buton31;
    private javax.swing.JButton buton32;
    private javax.swing.JButton buton33;
    private javax.swing.JButton buton34;
    private javax.swing.JButton buton35;
    private javax.swing.JButton buton36;
    private javax.swing.JButton buton37;
    private javax.swing.JButton buton38;
    private javax.swing.JButton buton39;
    private javax.swing.JButton buton4;
    private javax.swing.JButton buton40;
    private javax.swing.JButton buton41;
    private javax.swing.JButton buton42;
    private javax.swing.JButton buton43;
    private javax.swing.JButton buton44;
    private javax.swing.JButton buton45;
    private javax.swing.JButton buton5;
    private javax.swing.JButton buton6;
    private javax.swing.JButton buton7;
    private javax.swing.JButton buton8;
    private javax.swing.JButton buton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton redButon;
    // End of variables declaration//GEN-END:variables
}
