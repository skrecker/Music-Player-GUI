//this panel will hold the menu on the bottom left panel

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

class BottomPanel extends JPanel {
  private DefaultListModel listmodel;
  private static BottomPanel bottompanel;
  JScrollPane libraryPane;
  JList leftMenu;
  JList playlist;
  JTable library;
  int cellX;
  int cellY;
  final JPopupMenu popup;
  String[] menuOptions = {"Music","Playlist"};
  private String[] tableHeaders = {"Track Title", "Artist", "Album", "Likes"};
  private String[][] sampleTracks = {{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Run Away","Akua Naru","The Journey Aflame","14"},
  {"Far Fowls","Nujabes","Spiritual State", "21"},{"Optimist","P.O.S","Never Better","15"},
  {"O Heaven","Blu & Exile","Give Me My Flowers", "12"},{"How Many of Us?","Damu the Fudgemunk","Damumelo","9"},
  {"Homare","Shing 02","Untitled", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Right Here","DJ Mitsu","New Awakening", "5"},{"Time Leak","Analogtronics","Union","9"},
  {"Glass","Eyedea & Abilities","E&A", "15"},{"Strange Planet","Homeboy Sandman","The Good Sun","19"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Run Away","Akua Naru","The Journey Aflame","14"},
  {"Far Fowls","Nujabes","Spiritual State", "21"},{"Optimist","P.O.S","Never Better","15"},
  {"O Heaven","Blu & Exile","Give Me My Flowers", "12"},{"How Many of Us?","Damu the Fudgemunk","Damumelo","9"},
  {"Homare","Shing 02","Untitled", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Right Here","DJ Mitsu","New Awakening", "5"},{"Time Leak","Analogtronics","Union","9"},
  {"Glass","Eyedea & Abilities","E&A", "15"},{"Strange Planet","Homeboy Sandman","The Good Sun","19"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Run Away","Akua Naru","The Journey Aflame","14"},
  {"Far Fowls","Nujabes","Spiritual State", "21"},{"Optimist","P.O.S","Never Better","15"},
  {"O Heaven","Blu & Exile","Give Me My Flowers", "12"},{"How Many of Us?","Damu the Fudgemunk","Damumelo","9"},
  {"Homare","Shing 02","Untitled", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Right Here","DJ Mitsu","New Awakening", "5"},{"Time Leak","Analogtronics","Union","9"},
  {"Glass","Eyedea & Abilities","E&A", "15"},{"Strange Planet","Homeboy Sandman","The Good Sun","19"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Run Away","Akua Naru","The Journey Aflame","14"},
  {"Far Fowls","Nujabes","Spiritual State", "21"},{"Optimist","P.O.S","Never Better","15"},
  {"O Heaven","Blu & Exile","Give Me My Flowers", "12"},{"How Many of Us?","Damu the Fudgemunk","Damumelo","9"},
  {"Homare","Shing 02","Untitled", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Right Here","DJ Mitsu","New Awakening", "5"},{"Time Leak","Analogtronics","Union","9"},
  {"Glass","Eyedea & Abilities","E&A", "15"},{"Strange Planet","Homeboy Sandman","The Good Sun","19"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Run Away","Akua Naru","The Journey Aflame","14"},
  {"Far Fowls","Nujabes","Spiritual State", "21"},{"Optimist","P.O.S","Never Better","15"},
  {"O Heaven","Blu & Exile","Give Me My Flowers", "12"},{"How Many of Us?","Damu the Fudgemunk","Damumelo","9"},
  {"Homare","Shing 02","Untitled", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Right Here","DJ Mitsu","New Awakening", "5"},{"Time Leak","Analogtronics","Union","9"},
  {"Glass","Eyedea & Abilities","E&A", "15"},{"Strange Planet","Homeboy Sandman","The Good Sun","19"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"}};

  //arraylist to hold track objects
  JSplitPane libraryAndPlaylist; //holds library and playlist jscrollpanes

  private BottomPanel() {
    //create leftmenu
    leftMenu = new JList(menuOptions);
    leftMenu.setPreferredSize(new Dimension(65,435));
    leftMenu.setBorder(BorderFactory.createEtchedBorder());
    leftMenu.setBackground(new Color(235,235,235));
    leftMenu.setForeground(Color.BLACK);

    JPanel menuLabel = new JPanel();
    menuLabel.add(new JLabel("Menu"));
    JPanel menuPane = new JPanel();
    menuPane.setLayout(new VerticalLayout());
    menuPane.add(menuLabel);
    menuPane.add(leftMenu);
    menuPane.setBorder(BorderFactory.createEtchedBorder());

    //create playlist jlist
    listmodel = new DefaultListModel();
    playlist = new JList(listmodel);
    playlist.setCellRenderer( new MyJListCellRenderer() );

    JPanel playBar = new JPanel();
    playBar.setLayout(new VerticalLayout());
    JLabel ilab = new JLabel("Current Playlist                       ");
    playBar.add(ilab);
    JPanel j = new JPanel();
    GridBagLayout gbag = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    j.setLayout(gbag);
    gbc.gridx =0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbag.setConstraints(ilab, gbc);
    j.add(ilab);
    JButton save = new JButton("Save");
    save.setPreferredSize(new Dimension(54,30));
    j.add(new JLabel("   "));
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbag.setConstraints(save, gbc);
    gbc.anchor = GridBagConstraints.EAST;
    j.add(save);
    Font font = new Font(save.getFont().getName(),save.getFont().getStyle(),10);
    save.setFont(font);
    save.setToolTipText("Save this playlist");
    playBar.add(j);

    //buttons for the playlist section
    JPanel playDelBar = new JPanel();
    JButton playDel = new JButton(""); //button for removing playlist track
    JButton playAdd = new JButton(""); //button for adding playlist track
    JButton playTrash = new JButton(""); //button for trashing whole playlist
    JButton playlistButton = new JButton("Playlists"); //button for trashing whole playlist
    playlistButton.setFont(font);
    ImageIcon removeTagIcon = new ImageIcon("img/remove_tag_icon.png");
    ImageIcon addTagIcon = new ImageIcon("img/plus.png");
    ImageIcon delTagIcon = new ImageIcon("img/minus.png");
    playTrash.setIcon(removeTagIcon);
    playAdd.setIcon(addTagIcon);
    playDel.setIcon(delTagIcon);
    playDel.setPreferredSize(new Dimension(40,27));
    playAdd.setPreferredSize(new Dimension(40,27));
    playTrash.setPreferredSize(new Dimension(40,27));
    playDelBar.add(playlistButton);
    playDelBar.add(new JLabel("   "));
    playDelBar.add(playAdd);
    playDelBar.add(playDel);
    playDelBar.add(playTrash);
    playAdd.setToolTipText("Add track to current playlist."); 
    playDel.setToolTipText("Remove selected track in current playlist."); 
    playTrash.setToolTipText("Clear current playlist."); 
    playDelBar.setPreferredSize(new Dimension(240,29));

    playlistButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
	    PlaylistFrame pFrame;
            pFrame = PlaylistFrame.create();
	    pFrame.playlistframe = null;
            pFrame = PlaylistFrame.create();

            pFrame.setVisible(true);
	}
    });

    //listeners for buttons on playlist side
    playDel.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //deleted hilighted song
          DefaultListModel lm  = (DefaultListModel) playlist.getModel();
	  lm.removeElement(playlist.getSelectedValue());     
	  //int i = playlist.getSelectedIndex();
	  //playlist.removeSelectionInterval(i,i);
	}
    });

    playAdd.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //add highlighted song
	 String trak = getSelectedTrack();
	 addToList(trak);
	}
    });

    playTrash.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //delete everything 	
	//playlist.setListData(new String[0]);
	playlist.removeAll();
          DefaultListModel lm  = (DefaultListModel) playlist.getModel();
	  lm.removeAllElements();     
	}
    });

    save.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
	    PlaylistFrame pFrame;
            pFrame = PlaylistFrame.create();
	    pFrame.passPlaylist();
            pFrame.setVisible(true);
	}
    });

    playlist.setDropMode(DropMode.INSERT);
    playlist.setBackground(new Color(235,235,235));
    playlist.setForeground(Color.BLACK);


    //create library jtable
    library = new JTable(sampleTracks,tableHeaders){
  	public Component prepareRenderer
  	  (TableCellRenderer renderer,int Index_row, int Index_col) {
  	    Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
  	    //even index, selected or not selected
  	    if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
  		comp.setBackground(new Color(235,235,235));
  	    } else {
  		comp.setBackground( new Color (204, 204, 204));
  	    }  if (isCellSelected(Index_row, Index_col)) {
  	        comp.setBackground(new Color(7,66,60));
  	    }
  	    return comp;
  	  }
       public boolean isCellEditable(int rowIndex, int colIndex) {
           return true;   //Disallow the editing of any cell
       }
   };
	library.setRowSelectionInterval(0,0);
    library.setColumnSelectionAllowed(false);
    //library.setShowHorizontalLines(true);
    library.setDragEnabled(true);
    //library.setTransferHandler(new TransferHandler("text"));
    TransferHandler t = library.getTransferHandler(); 
    library.setForeground(Color.BLACK);

    //create jpopupmenu
    popup = new JPopupMenu();
    JMenuItem edit = new JMenuItem("Rename");
    JMenuItem play = new JMenuItem("Play");
    JMenuItem add = new JMenuItem("Add to Playlist");
    JMenuItem delete = new JMenuItem("Delete");

    //actionlistener for edit
    edit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Rename")){
        //TagPopupFrame f = new TagPopupFrame();
        library.editCellAt(cellX,cellY);
        //f.setVisible(true);
      }
       }
    });
    
    //actionlistener for play
    play.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Play")){
       CenterConsole c = CenterConsole.getInstance();
       c.setPlaySong();
	   ButtonControlPanel cP = ButtonControlPanel.getInstance();
	   cP.play.setIcon(cP.pauseIcon);
	   cP.isPaused = false;
		cP.play.setToolTipText("Pause song");
      }
       }
    });

    //actionlistener for adding to playlist   
    add.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add to Playlist")){
	 String trak = getSelectedTrack();
	 addToList(trak);
	}
      }
    });

    delete.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Delete")){
	  removeFromTable();
	}
      }
    });

    //add jmenuitems to rightclick popup
    popup.add(play);
    popup.add(add);
    popup.add(edit);
    popup.add(delete);
    
    //JTable right-click popup menu section
    library.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
        if(SwingUtilities.isRightMouseButton(e) == true) { 
       // if (e.isPopupTrigger()){
            JTable source = (JTable)e.getSource();
            int row = source.rowAtPoint( e.getPoint() );
            int column = source.columnAtPoint( e.getPoint() );

            if (! source.isRowSelected(row)){
                source.changeSelection(row, column, false, false);
            }
 	    getMousePos(row,column);
            popup.show(e.getComponent(), e.getX(), e.getY());
           
         } 
       }
     });

    JScrollPane lib = new JScrollPane(library);
    //lib.setPreferredSize(new Dimension(600,400));
    JScrollPane pList = new JScrollPane(playlist);
    pList.setPreferredSize(new Dimension(250,400));//160 400 default
    playBar.add(pList);
    playBar.setBorder(BorderFactory.createEtchedBorder());
    playBar.add(playDelBar);
    JScrollPane scroll = new JScrollPane(library);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


    //leftMenu.setPreferredSize(new Dimension(100,410));
    JSplitPane b = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,playBar);
    JPanel top = new JPanel();
    top.add(b);
    libraryAndPlaylist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPane, top);
    this.add(b); 
    libraryAndPlaylist.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                @Override
                    public void paint(Graphics g) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
            };
            }
        });
       // libraryAndPlaylist.setBorder(null);
       
    b.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                @Override
                    public void paint(Graphics g) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
            };
            }
        });
  }

  //gets the position of the mouse
  public void getMousePos(int x, int y) {
    cellX = x;
    cellY = y;
  }

  //gets the selected track in the library jtable
  public String getSelectedTrack() {
    //get the row index 
    int selectedRowIndex = library.getSelectedRow(); 
    String[] songInfo = getSongToPlay();
    String selectedObject = (String) library.getModel().getValueAt(selectedRowIndex, 0);
    //selectedObject = selectedObject+" - "+(String) library.getModel().getValueAt(selectedRowIndex, 1);
    selectedObject = songInfo[0]+" - "+songInfo[1]+" - "+songInfo[2];
    return selectedObject;
  }

  //create the instance of this bottom panel
  public static BottomPanel create() {
    if (bottompanel == null) {
	    bottompanel = new BottomPanel();
    }
    return bottompanel;
  }

  public static BottomPanel getInstance() {
    return bottompanel;
  }

  private void addToList(String song) {
    listmodel.addElement(song);
  }

  private void removeFromTable() {
    int selectedRowIndex = library.getSelectedRow(); 
    DefaultTableModel t = (DefaultTableModel) library.getModel();
    t.removeRow(selectedRowIndex);
  }
  public Object[] getPlaylistArray(){
		return playlist.getSelectedValues();

  } 
 
  //returns an array of the song info selected
  public String[] getSongToPlay() {
    String[] info = new String[3];
    int selectedRowIndex = library.getSelectedRow(); 
    String song = (String) library.getModel().getValueAt(selectedRowIndex, 0);
    String artist = (String) library.getModel().getValueAt(selectedRowIndex, 1);
    String album = (String) library.getModel().getValueAt(selectedRowIndex, 2);
    info[0] = song;
    info[1] = artist;
    info[2] = album;
    
    return info;
  }
	
	public String[] getNextSongToPlay(){
    	int selectedRowIndex = library.getSelectedRow();
		try{
			library.setRowSelectionInterval(selectedRowIndex+1,selectedRowIndex+1); 
   		 }catch(IllegalArgumentException e){
			
		}
		return getSongToPlay();
	}

	public String[] getPreviousSongToPlay(){
    	int selectedRowIndex = library.getSelectedRow();
		if(selectedRowIndex == 0 ){
			//do Nothing
		}else{
			library.setRowSelectionInterval(selectedRowIndex -1, selectedRowIndex - 1); 
    	}
		return getSongToPlay();
	}
	

  public String[] getSongFromPlaylist(String song) {
    String[] songInfo = song.split(" - ");
    return songInfo; //array is of size 3 
  }
}
