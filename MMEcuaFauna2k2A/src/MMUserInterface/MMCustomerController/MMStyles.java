package MMUserInterface.MMCustomerController;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class MMStyles {
    public static final Color MMBACKGROUND_COLOR = new Color(245, 245, 245);
    public static final Color MMCOLOR_FONT = new Color(0, 0, 0);
    public static final Color MMCOLOR_FONT_LIGHT = new Color(120, 120, 120);
    public static final Color MMCOLOR_CURSOR = new Color(0, 0, 0);
    public static final Color MMCOLOR_BORDER = new Color(0, 0, 0);

    public static final Font MMFONT = new Font("Arial", Font.PLAIN, 18);
    public static final Font MMFONT_BOLD = new Font("Arial", Font.BOLD, 18);
    public static final Font MMFONT_CUSTOM = new Font("Arial", Font.BOLD, 12);

    public static final Cursor MMCURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor MMCURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_ICON_ANT = MMStyles.class.getResource("/MMUserInterface/MMResources/Icons/iconAnt.png");

    public static final CompoundBorder mmCreateBorderRect() {
        return BorderFactory.createCompoundBorder(new LineBorder(MMCOLOR_BORDER), new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "👾 ECUFAUNA", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "☣️ ECUFAUNA", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, "❓ ECUFAUNA",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
