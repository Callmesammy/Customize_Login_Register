
package Login_Registers;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;


public class Log_Reg extends javax.swing.JPanel {

   public static Color BckColor = new Color(230,207,150);
   private Login log;
   private Register reg;
   private MigLayout layout;
   private boolean isLoggin;
   private Animator animate;
   
    public Log_Reg() {
        initComponents();
        init();
        setAnimate();
    }
    private void setAnimate(){
        animate = new Animator(1500, new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
             
            }
            
        });
        animate.addTarget(new PropertySetter(this, "animate", 0,30,0));
    }
    
    private void init(){
        setBackground(BckColor);
        layout = new MigLayout("fill", "fill", "fill");
        setLayout(layout);
        log = new Login();
        reg = new Register();
        add(reg, "pos (50%)-290px 0.5al n n");
        add(log, "pos (50%)-10px 0.5al n n");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
