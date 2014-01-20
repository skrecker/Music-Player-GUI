import avax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPanel extends JPanel implements MouseListener {
		JTextField searchTextField;
		JLabel trackSelection;
		JButton backButton;
		JButton forwardButton;
		JButton searchButton;
		String[] trackArray;
		int positionCount = 0;
		JList tempList;	
		JButton quickPlayButton;
		boolean emptyPlaylist= true;
		
		public SearchPanel(){
			super();
			this.setBackground(Color.DARK_GRAY);
			initComponents();
		}

		private void initComponents(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			backButton = new JButton("<");

			trackSelection = new JLabel();
			Dimension labelSize = new Dimension(200,50);
			trackSelection.setPreferredSize(labelSize);
			trackSelection.setText("Next Track");
			trackSelection.setHorizontalTextPosition(JLabel.CENTER);

			forwardButton = new JButton(">");
			
			quickPlayButton = new JButton("Quick Play");
			quickPlayButton.setVisible(false);

			searchTextField = new JTextField(10);
			searchTextField.setText("Search..");
			searchTextField.setActionCommand("search");
			searchTextField.setSelectedTextColor(Color.gray);
			searchTextField.setForeground(Color.gray);
			searchTextField.setToolTipText("Search for a track, artist or album");

			searchButton = new JButton("Search");
            searchButton.setToolTipText("Search");
			setCollapseSearchVisible(false);

			c.gridx = 0;
			c.gridy = 0;

			this.add(backButton,c);

			c.gridx = 3;
			c.gridy = 0;
			c.gridwidth = 3;
			c.fill = GridBagConstraints.HORIZONTAL;
			this.add(trackSelection);

			c.gridx = 4;
			c.gridy = 0;
			c.gridwidth = 1;
			this.add(forwardButton);
			
			c.gridx = 4;
			c.gridy = 0;
			c.gridwidth = 1;
			this.add(quickPlayButton);

			c.gridx = 5;
			c.gridy = 0;
			c.weightx = 1;
			c.anchor = GridBagConstraints.LINE_END;
			this.add(searchTextField,c);

			c.gridx = 6;
			c.gridy = 6;
			this.add(searchButton);

			searchTextField.addMouseListener(this);			

			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(!emptyPlaylist){
						positionCount--;
						if(positionCount >=0 ){	
							trackSelection.setText(trackArray[positionCount]);
						}
						else{
							positionCount = trackArray.length;
							trackSelection.setText(trackArray[positionCount]);

						}
					}
				}
					
			});

			forwardButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(!emptyPlaylist){
						positionCount++;

						if(positionCount < trackArray.length) {
						
							trackSelection.setText(trackArray[positionCount]);
						

						}else{
							positionCount = 0;
							trackSelection.setText(trackArray[positionCount]);
						}
					}
				}
			});	

			quickPlayButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					BottomPanel bP = BottomPanel.getInstance();
					CenterConsole cC = CenterConsole.getInstance();
					String[] sArray = bP.getSongFromPlaylist(trackSelection.getText());
					
					cC.artistLabel.setText(sArray[0]);
					cC.titleLabel.setText(sArray[1]);
					cC.albumLabel.setText(sArray[2]);
				
					ButtonControlPanel control = ButtonControlPanel.getInstance();
					control.play.setIcon(control.pauseIcon);						
					control.isPaused = false;
					control.play.setToolTipText("Pause song");
			//		temp.timeNowLabel.setText();
			//		temp.totTimeLabel.setText();
				}

			});			
	
		}

			

		public void populateQuickSearch(){
					
			tempList = BottomPanel.getInstance().playlist;
			int size = tempList.getModel().getSize();

			if(!tempList.isSelectionEmpty() && size!=0){
				emptyPlaylist = false;
				int point = tempList.getSelectedIndex();
				int anchor = tempList.getSelectedIndex();
				
				trackArray = new String[size];
				int arrayCount = 0;
				trackSelection.setText(tempList.getSelectedValue().toString());
			
					while(point <	size){
						tempList.setSelectedIndex(point);
						trackArray[arrayCount] = tempList.getSelectedValue().toString();
						arrayCount++;
						point++;
					}
					int i = 0;
				
					while(i< anchor){
						tempList.setSelectedIndex(i);
						trackArray[arrayCount] = tempList.getSelectedValue().toString();
						i++;
					}
				
					tempList.setSelectedIndex(anchor);	
			
			}else if(size==0){
				trackSelection.setText("Empty");
				emptyPlaylist = true;				
	
			}else if(tempList.isSelectionEmpty()){
				emptyPlaylist = false;
				tempList.setSelectedIndex(0);
				populateQuickSearch();

			}
		}

		public void setCollapseSearchVisible(boolean b){
				if(b){
					if(emptyPlaylist == false){
						backButton.setVisible(true);
						trackSelection.setVisible(true);
						forwardButton.setVisible(true);
						quickPlayButton.setVisible(true);
					}
					searchTextField.setVisible(false);
					searchButton.setVisible(false);
					
					populateQuickSearch();
					//quickSearchArray = BottomPanel.getInstance().getPlaylistArray();
					//trackSelection.setText(quickSearchArray[0].toString());  

				}else{
					backButton.setVisible(false);
					trackSelection.setVisible(false);
					forwardButton.setVisible(false);
					quickPlayButton.setVisible(false);
			
					searchTextField.setVisible(true);
					searchButton.setVisible(true);
				}
		}

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
          searchTextField.setText("Search");

    }

    public void mouseEntered(MouseEvent e) {
          searchTextField.setText("");

    }

    public void mouseExited(MouseEvent e) {
          searchTextField.setText("Search");

    }

    public void mouseClicked(MouseEvent e) {
          searchTextField.setText("");

    }
}
