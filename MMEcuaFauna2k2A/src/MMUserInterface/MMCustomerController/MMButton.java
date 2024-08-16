package MMUserInterface.MMCustomerController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MMButton extends JButton implements MouseListener {

    private boolean isRound;

    public MMButton(String text, boolean isRound) {
        this.isRound = isRound;
        customizeComponent(text);
        //setBackground(Color.BLUE);  Cambia el color de todos los botones
    }

    private void customizeComponent(String text) {
        setText(text);
        setFont(MMStyles.MMFONT_CUSTOM);
        setForeground(MMStyles.MMCOLOR_FONT);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(MMStyles.MMCURSOR_HAND);
        addMouseListener(this);

        if (isRound) {
            setPreferredSize(new Dimension(50, 50));
        } else {
            setPreferredSize(new Dimension(200, 40));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
    if (getModel().isPressed()) {
        g.setColor(getBackground().darker());
    } else if (getModel().isRollover()) {
        g.setColor(getBackground().brighter());
    } else {
        g.setColor(getBackground());
    }
    g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Bordes redondeados
    super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(MMStyles.MMCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(MMStyles.MMCURSOR_DEFAULT);
    }
}
