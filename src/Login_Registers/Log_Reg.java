
package Login_Registers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;


public class Log_Reg extends javax.swing.JPanel {

    private static Color main = new Color (240,210,205);
    private Login log;
    private Register reg;
    private MigLayout layout;
    private Animator animat;
    private boolean isLoading;
   
    public void minate(int animate){
        layout.setComponentConstraints(reg, "pos (50%)-290px-" +animate+" 0.5al n n");
        layout.setComponentConstraints(log, "pos (50%)-10px+" +animate+" 0.5al n n");
        revalidate();
    }
    public Log_Reg() {
        initComponents();
        init();
        setAnimation();
    }
    
    public void init(){
        setBackground(main);
        layout = new MigLayout("fill", "fill", "fill");
        setLayout(layout);
        log = new Login();
        reg = new Register();
        add(reg, "pos (50%)-290px 0.5al n n ");
        add(log, "pos (50%)-10px 0.5al n n ");
       
    }
    
    public void setAnimation(){
        animat = new Animator(1500, new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                
            }
        
        });
        animat.addTarget(new PropertySetter(this, "animate", 0,30,0));
        animat.setResolution(0);
//        animate.setAcceleration(0.5f);
//        animate.setDeceleration(0.5f);
         reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    loading(false);
                }
            }
        });
         log.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    loading(true);
                }
            }
        });
    }

    private void loading(boolean slie){
        if (slie != isLoading) {
            if (!animat.isRunning()) {
                isLoading = slie;
                animat.start();
            }
        }
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
