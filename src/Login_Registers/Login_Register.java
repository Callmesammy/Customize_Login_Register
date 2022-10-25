
package Login_Registers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author user
 */
public class Login_Register extends javax.swing.JPanel {

    
    //here we attacch the login and register age Mglaout\
    
    private MigLayout layout;
    private Login log;
    private Register reg;
    private boolean isstart;
    private Animator animator;
   
//    JPanel panel = new JPanel();
    private final static Color cl = new Color(205,234,205);
    
    public void setAnimate(int animate){
        System.out.println(animate);
      layout.setComponentConstraints(log, "pos  (50%)-290px-"+animate+" 0.5al n n");
      layout.setComponentConstraints(reg, "pos  (50%)-10px+"+animate+" 0.5al n n");
     
        if (animate ==30) {
            if (isstart) {
                   setComponentZOrder(log, 0);
        }else{
            setComponentZOrder(reg, 0);
        } 
        
            }
         
        revalidate();
    }
    public Login_Register() {
        initComponents();
        init();
        initAnimate();
    }
    
    public void initAnimate(){
        animator = new Animator(1000, new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
              
            }
        
        });
        animator.addTarget(new PropertySetter(this, "animate", 0,30,0));
        animator.setResolution(0);
        
    }
    private void init(){
        setBackground(cl);
        layout = new MigLayout("fill", "fill", "fill");
        log = new Login();
        reg = new Register();
        setLayout(layout);
        add(log, "pos (50%)-290px 0.5al n n");
        add(reg, "pos (50%)-10px 0.5al n n");
        log.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    slidingadd(false);
                    
                }
            }
        });
        reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    slidingadd(true);
                    
                }
            }
        });
       }
     
    private void slidingadd (boolean show){
        if (show != isstart) {
            if (!animator.isRunning()) {
                isstart = show;
                animator.start();
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
