package MMUserInterface.MMCustomerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow;

public class MMPanelBar extends JPanel {

    public MMPanelBar(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("  EcuaFauna 2K24A");
        titleLabel.setFont(MMStyles.MMFONT_BOLD);
        titleLabel.setForeground(MMStyles.MMCOLOR_FONT);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        MMButton closeButton = new MMButton("X", true);
        MMButton minimizeButton = new MMButton("_", true);
        MMButton maximizeButton = new MMButton("O", true);

        closeButton.setBackground(Color.RED);
        minimizeButton.setBackground(Color.YELLOW);
        maximizeButton.setBackground(Color.GREEN);

        buttonPanel.add(minimizeButton);
        buttonPanel.add(maximizeButton);
        buttonPanel.add(closeButton);

        add(titleLabel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);

        // Funcionalidad de los botones
        closeButton.addActionListener(e -> frame.dispose());
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
        maximizeButton.addActionListener(e -> frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH));

        // Hacer la barra de título arrastrable
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = frame.getLocation().x + e.getX() - initialClick.x;
                int y = frame.getLocation().y + e.getY() - initialClick.y;
                frame.setLocation(x, y);
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
}
