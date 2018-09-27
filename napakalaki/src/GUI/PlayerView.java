/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


//import Napakalaki.CultistPlayer;
import Napakalaki.BadConsequence;
import Napakalaki.CultistPlayer;
import Napakalaki.Napakalaki;
import Napakalaki.Player;
import Napakalaki.Treasure;
import Napakalaki.TreasureKind;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marcos
 */
public class PlayerView extends javax.swing.JPanel {
    
    Player playerModel;
    private static Napakalaki napakalakiModel;

    public PlayerView() {
        initComponents();
        this.jLabel9.setVisible(false);
        
    }
    
    public void setPlayer(Player p){
        //playerModel=new Player("");
        playerModel=p;
        this.badConsequenceView1.setVisible(false);
        this.name.setText(playerModel.getName());
        this.level.setText(Integer.toString(playerModel.getLevels()));
        this.dead.setText(Boolean.toString(playerModel.isDead()));
        this.puedeRobar.setText(Boolean.toString(playerModel.canISteal()));
        this.enemigo.setText(playerModel.getEnemy().getName());
        this.nivelCombate.setText(Integer.toString(playerModel.getNivelCombate()));
        this.NumSectarios.setText(Integer.toString(CultistPlayer.totalCultistPlayers));
        this.fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        // EXAMEN
        this.jLabel12.setText(playerModel.getClass().getSimpleName());
        // FIN EXAMEN
        repaint();
        revalidate();
    }
    
    public static void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
        
    }
    
    public void desactivarBoton(){
        this.jButton2.setEnabled(false);
        repaint();
        revalidate();
    }
    
    public void activarBoton(){
        this.jButton2.setEnabled(true);
        repaint();
        revalidate();
    }
    
    public void activarBoton2(){
        this.jButton5.setEnabled(true);
        repaint();
        revalidate();
    }
    
    public void setBadConsequence(BadConsequence b){
        this.badConsequenceView1.setBadConsequence(b);
        this.jLabel9.setVisible(false);
        repaint();
        revalidate();
    }
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList){
        aPanel.removeAll();
        for( Treasure t: aList){
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output= new ArrayList();
        for(Component c: aPanel.getComponents()){
            tv=(TreasureView) c;
            if(tv.isSelected()){
                output.add(tv.getTreasure());
            }
        }
        return output;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        dead = new javax.swing.JLabel();
        puedeRobar = new javax.swing.JLabel();
        enemigo = new javax.swing.JLabel();
        nivelCombate = new javax.swing.JLabel();
        NumSectarios = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        badConsequenceView1 = new GUI.BadConsequenceView();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setOpaque(false);

        name.setForeground(new java.awt.Color(0, 0, 255));
        name.setText("jLabel1");

        level.setForeground(new java.awt.Color(255, 0, 51));
        level.setText("jLabel2");
        level.setMaximumSize(new java.awt.Dimension(0, 0));
        level.setMinimumSize(new java.awt.Dimension(0, 0));

        dead.setForeground(new java.awt.Color(0, 0, 255));
        dead.setText("jLabel3");

        puedeRobar.setForeground(new java.awt.Color(0, 0, 255));
        puedeRobar.setText("jLabel4");

        enemigo.setForeground(new java.awt.Color(0, 0, 255));
        enemigo.setText("jLabel6");

        nivelCombate.setForeground(new java.awt.Color(255, 0, 51));
        nivelCombate.setText("jLabel7");

        NumSectarios.setForeground(new java.awt.Color(0, 0, 255));
        NumSectarios.setText("jLabel8");

        visibleTreasures.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        visibleTreasures.setOpaque(false);

        hiddenTreasures.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hiddenTreasures.setOpaque(false);

        jButton1.setText("Steal Treasure");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Make Visible");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Discard Treasures");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Jugador:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nivel:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Muerte:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Puede Robar:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enemigo:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nivel de Combate:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Numero de Sectarios:");

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setName(""); // NOI18N
        jLabel9.setRequestFocusEnabled(false);

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Tesoros Visibles:");

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Tesoros Ocultos:");

        jButton4.setText("Discard All Treasures");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Decrementar nivel al enemigo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Clase de Jugador");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(enemigo))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(nivelCombate))
                            .addComponent(jLabel7))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumSectarios)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel10))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dead)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(puedeRobar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                            .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dead)
                                    .addComponent(puedeRobar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemigo)
                            .addComponent(nivelCombate)
                            .addComponent(NumSectarios))))
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        level.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        this.setPlayer(napakalakiModel.getCurrentPlayer());
        this.jLabel9.setVisible(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        if(selVisible.isEmpty()){
            ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
            napakalakiModel.discardHiddenTreasure(selHidden);
            setPlayer(napakalakiModel.getCurrentPlayer());
        }
        else{
            napakalakiModel.discardVisibleTreasure(selVisible);
            setPlayer(napakalakiModel.getCurrentPlayer());
        }
        this.jLabel9.setVisible(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        playerModel.discardAllTreasures();
        this.setPlayer(playerModel);
        this.jLabel9.setVisible(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(playerModel.canISteal()){
            Treasure aux=playerModel.stealTreasure();
            if(aux==null){
                this.jLabel9.setText("No has podido robar nada");
            }
            else{
                this.jLabel9.setText("Has robado un tesoro");
                //playerModel.getHiddenTreasures().add(aux);
                //setPlayer(napakalakiModel.getCurrentPlayer());
                setPlayer(playerModel);
            }
        }
        else{
            this.jLabel9.setText("No puedes robar");
        }
        this.jLabel9.setVisible(true);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    //EXAMEN
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ArrayList<Treasure> selOcultos = getSelectedTreasures(hiddenTreasures);
        if(selOcultos.isEmpty()){
           JOptionPane.showMessageDialog(null, "No tienes tesoros ocultos, o no tienes tesoros ocultos seleccionados");
        }
        else{
                int aux=playerModel.quitarNivelesEnemigo(selOcultos);
                jButton5.setEnabled(false);
                JOptionPane.showMessageDialog(null, "As quitado a tu enemigo " +aux+ " puntos");
                //setPlayer(napakalakiModel.getCurrentPlayer().getEnemy());
                napakalakiModel.discardHiddenTreasure(selOcultos);
                setPlayer(napakalakiModel.getCurrentPlayer());
            }
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed
    //FIN EXAMEN

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NumSectarios;
    private GUI.BadConsequenceView badConsequenceView1;
    private javax.swing.JLabel dead;
    private javax.swing.JLabel enemigo;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nivelCombate;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JLabel puedeRobar;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
    
