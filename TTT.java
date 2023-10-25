/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author glenn
 */
public class TTT extends javax.swing.JFrame {
    private JButton block;
    private Random random = new Random();
    private boolean p1_turn = true;
    private boolean check_resetter;
    private int xCounter = 0;
    private int oCounter = 0;
    private boolean win = false;
    private int time_setter = 10;
    private int overall_match_counter = 0;
    private int tie_counter = 0;
    private int side = 0;
    //
    
    int counter = 0; // counter for image cycle
    int counter2 = 0; // counter for image cycle
    
    Timer player1Timer = new Timer(1000, new ActionListener() {
        int timeLeft = time_setter;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(check_resetter){
                timeLeft = time_setter;
                check_resetter = false;
            }
            timeLeft--;
            player1TimerLabel.setText("<html>Player 1 Timer<center>" + timeLeft + "</center></html>");
            side = 0;
            if (timeLeft <= 0) {
                p1_turn = false;
                player1TimerLabel.setText("<html>Player 1 Timer<center>Out of Time!</center></html>");
                ((Timer) e.getSource()).stop();
                jLabel5.setText("Player 2 Turn");
                player2Timer.start();
            }
        }
    });
    
     Timer player2Timer = new Timer(1000, new ActionListener() {
         int timeLeft = time_setter;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!check_resetter){
                timeLeft = time_setter;
                check_resetter = true;
            }
            timeLeft--;
            player2TimerLabel.setText("<html>Player 2 Timer<center>" + timeLeft + "</center></html>");
            side = 1;
            if (timeLeft <= 0) {
                p1_turn = true;
                player2TimerLabel.setText("<html>Player 2 Timer<center>Out of Time!</center></html>");
                ((Timer) e.getSource()).stop();
                jLabel5.setText("Player 1 Turn");
                player1Timer.start();
            }
        }
    });
    
    public TTT() {
        initComponents();
        player1TimerLabel.setText("<html>Player 1 Timer<center>" + time_setter + "</center></html>");
        player2TimerLabel.setText("<html>Player 2 Timer<center>" + time_setter + "</center></html>");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("potato.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        jLabel6.setIcon(imageIcon);
    
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("water.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        jLabel7.setIcon(imageIcon2);
    //
    }
    
    public void setxWin(JButton jb1, JButton jb2, JButton jb3){
        jb1.setBackground(Color.YELLOW);
        jb2.setBackground(Color.YELLOW);
        jb3.setBackground(Color.YELLOW);
        
        enableButtons(false);   
        
        jb1.setEnabled(true);
        jb2.setEnabled(true);
        jb3.setEnabled(true);
        
        xCounter++;
        jLabel5.setText("Player 1 Wins!");
        win = true;
        stopTimers();
    }
    
    public void setoWin(JButton jb1, JButton jb2, JButton jb3){
        jb1.setBackground(Color.YELLOW);
        jb2.setBackground(Color.YELLOW);
        jb3.setBackground(Color.YELLOW);
        enableButtons(false);
        
        jb1.setEnabled(true);
        jb2.setEnabled(true);
        jb3.setEnabled(true);
        oCounter++;
        jLabel5.setText("Player 2 Wins!");
        win = true;
        stopTimers();
    }
    public void confirmWin(){
        if(
                (jButton1.getText().equals("x")) &&
                (jButton4.getText().equals("x")) &&
                (jButton7.getText().equals("x"))){
            setxWin(jButton1, jButton4, jButton7);
        }
        if(
                (jButton2.getText().equals("x")) &&
                (jButton5.getText().equals("x")) &&
                (jButton8.getText().equals("x"))){
            setxWin(jButton2, jButton5, jButton8);
        }
        if(
                (jButton3.getText().equals("x")) &&
                (jButton6.getText().equals("x")) &&
                (jButton9.getText().equals("x"))){
            setxWin(jButton3, jButton6, jButton9);
        }
        if(
                (jButton1.getText().equals("x")) &&
                (jButton2.getText().equals("x")) &&
                (jButton3.getText().equals("x"))){
            setxWin(jButton1, jButton2, jButton3);
        }
        if(
                (jButton4.getText().equals("x")) &&
                (jButton5.getText().equals("x")) &&
                (jButton6.getText().equals("x"))){
            setxWin(jButton4, jButton5, jButton6);
        }
        if(
                (jButton7.getText().equals("x")) &&
                (jButton8.getText().equals("x")) &&
                (jButton9.getText().equals("x"))){
            setxWin(jButton7, jButton8, jButton9);
        }
        if(
                (jButton1.getText().equals("x")) &&
                (jButton5.getText().equals("x")) &&
                (jButton9.getText().equals("x"))){
            setxWin(jButton1, jButton5, jButton9);
        }
        if(
                (jButton3.getText().equals("x")) &&
                (jButton5.getText().equals("x")) &&
                (jButton7.getText().equals("x"))){
            setxWin(jButton3, jButton5, jButton7);
        }
        
        if(
                (jButton1.getText() .equals("o")) &&
                (jButton4.getText() .equals("o")) &&
                (jButton7.getText() .equals("o"))){
            setoWin(jButton1, jButton4, jButton7);
        }
        if(
                (jButton2.getText() .equals("o")) &&
                (jButton5.getText() .equals("o")) &&
                (jButton8.getText() .equals("o"))){
            setoWin(jButton2, jButton5, jButton8);
        }
        if(
                (jButton3.getText() .equals("o")) &&
                (jButton6.getText() .equals("o")) &&
                (jButton9.getText() .equals("o"))){
            setoWin(jButton3, jButton6, jButton9);
        }
        if(
                (jButton1.getText() .equals("o")) &&
                (jButton2.getText() .equals("o")) &&
                (jButton3.getText() .equals("o"))){
            setoWin(jButton1, jButton2, jButton3);
        }
        if(
                (jButton4.getText() .equals("o")) &&
                (jButton5.getText() .equals("o")) &&
                (jButton6.getText() .equals("o"))){
            setoWin(jButton4, jButton5, jButton6);
        }
        if(
                (jButton7.getText().equals("o")) &&
                (jButton8.getText().equals("o")) &&
                (jButton9.getText().equals("o"))){
            setoWin(jButton7, jButton8, jButton9);
        }
        if(
                (jButton1.getText().equals("o")) &&
                (jButton5.getText().equals("o")) &&
                (jButton9.getText().equals("o"))){
            setoWin(jButton1, jButton5, jButton9);
        }
        if(
                (jButton3.getText().equals("o")) &&
                (jButton5.getText().equals("o")) &&
                (jButton7.getText().equals("o"))){
            setoWin(jButton3, jButton5, jButton7);
        }
        
        if(isAllFilled() && !win){
            jButton1.setText("");
            jButton1.setBackground(null);
            jButton2.setText("");
            jButton2.setBackground(null);
            jButton3.setText("");
            jButton3.setBackground(null);
            jButton4.setText("");
            jButton4.setBackground(null);
            jButton5.setText("");
            jButton5.setBackground(null);
            jButton6.setText("");
            jButton6.setBackground(null);
            jButton7.setText("");
            jButton7.setBackground(null);
            jButton8.setText("");
            jButton8.setBackground(null);
            jButton9.setText("");
            jButton9.setBackground(null);
            jLabel5.setText("TIE GAME");
            stopTimers();
            enableButtons(false);
            tie_counter++;
	}
        player1TimerLabel.setText("<html>Player 1 Timer<center>" + time_setter + "</center></html>");
        player2TimerLabel.setText("<html>Player 2 Timer<center>" + time_setter + "</center></html>");
    }

    public boolean isAllFilled(){
        for (JButton b : getButtonArrays())
            if(b.getText().equals("")) return false;
        
       return true;
    }           
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        player1TimerLabel = new javax.swing.JLabel();
        player2TimerLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");
        setResizable(false);

        jButton10.setText("START");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Player 1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Player 2");

        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAction(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TICTACTOE");
        jLabel5.setToolTipText("");

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        player1TimerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        player2TimerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(player1TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player2TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(player2TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(player1TimerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jMenu1.setText("Check Stats");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit Timer");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:

        counter2++;

        if(counter2 > 4)
            counter2 = 0;

        switch(counter2){
            case 0:{
                ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("water.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel7.setIcon(imageIcon2);
            }
            break;
            case 1:{
                ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("rat.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel7.setIcon(imageIcon2);
            }
            break;
            case 2:{
                ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("luffy.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel7.setIcon(imageIcon2);
            }
            break;
            case 3:{
                ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("nami.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel7.setIcon(imageIcon2);
            }
            break;
            case 4:{
                ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("lamb.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel7.setIcon(imageIcon2);
            }
            break;

        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        counter++;
        if(counter > 4)
            counter = 0;

        switch(counter){
            case 0:{
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("potato.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel6.setIcon(imageIcon);
            }
            break;
            case 1:{
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("glenn.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel6.setIcon(imageIcon);
            }
            break;
            case 2:{
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("raymond.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel6.setIcon(imageIcon);
            }

            break;
            case 3:{
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("melo.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel6.setIcon(imageIcon);
            }
            break;
            case 4:{
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("john.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                jLabel6.setIcon(imageIcon);
            }
            break;

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void clickAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickAction
        block = (JButton) evt.getSource();
        if(p1_turn){
            if(block.getText().equals("")){
                block.setText("x");
                block.setBackground(Color.CYAN);
                p1_turn = false;
                jLabel5.setText("Player 2 Turn");
                player2Timer.start();
                player1Timer.stop();
                confirmWin();
            }
        }
        else{
            if(block.getText().equals("")){
                block.setText("o");
                block.setBackground(Color.GREEN);
                p1_turn = true;
                jLabel5.setText("Player 1 Turn");
                player1Timer.start();
                player2Timer.stop();
                confirmWin();
            }
        }

    }//GEN-LAST:event_clickAction
     private void stopTimers() {
        player1Timer.stop();
        player2Timer.stop();
    }
     
    public void setTime(int x){
        time_setter = x;
    }
    
    public JButton[] getButtonArrays(){
        return new JButton[]{jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9, jButton10};
    }
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        overall_match_counter++;
        if(random.nextInt(2)==0) {
            p1_turn=true;
            check_resetter=true;
            Font f = jLabel3.getFont();
            jLabel3.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
            f = jLabel4.getFont();
            jLabel4.setFont(f.deriveFont(f.getStyle() | ~Font.BOLD));
            jLabel5.setText("Player 1 Turn");
            player1Timer.start();
            player2Timer.stop();
        }
        else {
            p1_turn=false;
            check_resetter=false;
            Font f = jLabel3.getFont();
            jLabel3.setFont(f.deriveFont(f.getStyle() | ~Font.BOLD));
            f = jLabel4.getFont();
            jLabel4.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
            jLabel5.setText("Player 2 Turn");
            player2Timer.start();
            player1Timer.stop();
        }

        enableButtons(true);
        jButton10.setText("RESET");

        if(jButton10.getText().equals("RESET")){
            jButton1.setText("");
            jButton1.setBackground(null);
            jButton2.setText("");
            jButton2.setBackground(null);
            jButton3.setText("");
            jButton3.setBackground(null);
            jButton4.setText("");
            jButton4.setBackground(null);
            jButton5.setText("");
            jButton5.setBackground(null);
            jButton6.setText("");
            jButton6.setBackground(null);
            jButton7.setText("");
            jButton7.setBackground(null);
            jButton8.setText("");
            jButton8.setBackground(null);
            jButton9.setText("");
            jButton9.setBackground(null);
            player1TimerLabel.setText("<html>Player 1 Timer<center>" + time_setter + "</center></html>");
            player2TimerLabel.setText("<html>Player 2 Timer<center>" + time_setter + "</center></html>");
            win = false;
        }
    }//GEN-LAST:event_jButton10ActionPerformed
    
    private void controlTime(boolean g){
        if(g){
            if(side == 0)player1Timer.stop();
            else player2Timer.stop();
            enableButtons(false);
        }else{
            if(side == 0)player1Timer.start();
            else player2Timer.start();
            enableButtons(true);
        }
    }
    
    private void enableButtons(boolean s){
        JButton[] buttons = getButtonArrays();
        for(int i = 0; i < buttons.length-1; i++)
            buttons[i].setEnabled(s);
    }
    
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if(!jLabel5.getText().equals("TICTACTOE"))
            controlTime(true);
        
        JOptionPane.showMessageDialog(null, "Overall Matches: " + overall_match_counter + 
                                                        "\nOverall Ties: " + tie_counter + 
                                                        "\n\n===Player 1===\nWins: " + xCounter +
                                                        "\nLosses: " + oCounter +
                                                        "\n\n===Player 2===\nWins: " + oCounter +
                                                        "\nLosses: " + xCounter);
        if(!jLabel5.getText().equals("TICTACTOE"))
            controlTime(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        int g = 0;
        if(!jLabel5.getText().equals("TICTACTOE")){
            controlTime(true);
            g = JOptionPane.showConfirmDialog(null, "Changing the timer resets the game!");
        }
        if(g == 0){
            String j = JOptionPane.showInputDialog(null, "Enter time: ");
            try{
                if(!j.equals(""))
                    time_setter = Integer.valueOf(j);
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Invalid input, only integers");
            }
            player1TimerLabel.setText("<html>Player 1 Timer<center>" + time_setter + "</center></html>");
            player2TimerLabel.setText("<html>Player 2 Timer<center>" + time_setter + "</center></html>");
        }
    }//GEN-LAST:event_jMenu2MouseClicked
    
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
            java.util.logging.Logger.getLogger(TTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TTT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel player1TimerLabel;
    private javax.swing.JLabel player2TimerLabel;
    // End of variables declaration//GEN-END:variables
}
