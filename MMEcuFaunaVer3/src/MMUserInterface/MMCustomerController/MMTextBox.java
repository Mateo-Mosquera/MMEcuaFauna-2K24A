package MMUserInterface.MMCustomerController;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Insets;

public class MMTextBox extends JTextField {

    public MMTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setFont(MMStyles.MMFONT);
        setForeground(MMStyles.MMCOLOR_FONT_LIGHT); // Color de las letras de cedula y nombre
        setCaretColor(MMStyles.MMCOLOR_RED);
        setMargin(new Insets(5, 5, 5, 5));
        setBorderRect();
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(MMStyles.MMCOLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder(new CompoundBorder(lineBorder, emptyBorder));
    }
}
