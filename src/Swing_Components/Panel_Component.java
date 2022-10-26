
package Swing_Components;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

// this is se for more Panel comonents
public class Panel_Component extends JComponent{

    /**
     * @return the setAlpha
     */
    public float getSetAlpha() {
        return setAlpha;
    }

    /**
     * @param setAlpha the setAlpha to set
     */
    public void setSetAlpha(float setAlpha) {
        this.setAlpha = setAlpha;
    }

    private float setAlpha = 1f;
    
    public Panel_Component() {
    }

    // for the 2d backgrounds and designs 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, setAlpha));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        g2.dispose();
    }
    
    
    
}
