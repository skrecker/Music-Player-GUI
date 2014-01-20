import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;

class Main {
  public static void main(String args[]) {
try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
UIManager.put("nimbusBase", new Color(7,66,60));
UIManager.put("control", Color.DARK_GRAY);
UIManager.put("textForeground", Color.WHITE);
UIManager.put("info", new Color(7,66,60));

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Music();
	}
     });
  }
}
