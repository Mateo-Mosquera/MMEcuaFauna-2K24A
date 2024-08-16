package MMUserInterface.MMGUI;

import javax.swing.JFrame;

import MMUserInterface.MMCustomerController.MMPanelBar;
import java.awt.BorderLayout;
import java.awt.Container;

import MMUserInterface.MMForms.MMMainPanel;


public class MMWindowsMain extends JFrame {

    public MMWindowsMain(String titleApp) {
        customizeComponent(titleApp);
    }

    private void customizeComponent(String titleApp) {
        setUndecorated(true);
        setSize(600, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(new MMPanelBar(this), BorderLayout.NORTH);

        container.add(new MMMainPanel(), BorderLayout.CENTER);

        setVisible(true);
    }
}
