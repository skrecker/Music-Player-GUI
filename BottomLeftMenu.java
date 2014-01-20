
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class BottomLeftMenu extends JPanel {
  JList leftMenu;
  String[] menuOptions = {"Music","Playlist","Likes"};

  BottomLeftMenu() {
   this.setLayout(new FlowLayout());
   leftMenu = new JList(menuOptions);
   leftMenu.setPreferredSize(new Dimension(100,410));
   this.add(leftMenu);
  }

}
