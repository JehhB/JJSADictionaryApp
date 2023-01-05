/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.function.Consumer;

/**
 *
 * @author eco
 */
public class SearchBox extends javax.swing.JPanel {

	private String text;

	/**
	 * Creates new form SearchBox
	 */
	public SearchBox() {
		initComponents();

		text = "";
		searchText.setText("Search");
		searchText.addFocusListener(new java.awt.event.FocusListener() {
			@Override
			public void focusGained(FocusEvent fe) {
				if (text.isEmpty() && searchText.getText().equals("Search")) {
					searchText.setText("");
					searchText.setForeground(Color.BLACK);
					searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/xmark.png")));
				}
			}

			@Override
			public void focusLost(FocusEvent fe) {
				text = searchText.getText();
				if (text.isEmpty()) {
					clearSearch();
				}
			}
		});
	}

	public void clearSearch() {
		text = "";
		searchText.setText("Search");
		searchText.setForeground(new Color(49, 49, 49));
		searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search.png")));
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                searchText = new javax.swing.JTextField();
                searchButton = new javax.swing.JButton();

                setBackground(new java.awt.Color(255, 255, 255));
                setMaximumSize(new java.awt.Dimension(200, 24));
                setMinimumSize(new java.awt.Dimension(200, 24));

                searchText.setForeground(new java.awt.Color(49, 49, 49));
                searchText.setText("Search");
                searchText.setToolTipText("Search");
                searchText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                searchText.setMargin(new java.awt.Insets(16, 16, 16, 16));
                searchText.setOpaque(true);

                searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search.png"))); // NOI18N
                searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                searchButton.setBorderPainted(false);
                searchButton.setContentAreaFilled(false);
                searchButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)
                                .addGap(16, 16, 16))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(searchButton)
                                .addGap(6, 6, 6))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
		if (text.isEmpty()) {
			searchText.requestFocusInWindow();
		} else {
			clearSearch();
		}
        }//GEN-LAST:event_searchButtonActionPerformed

	public String getText() {
		return text;
	}

	public void addSearchListener(Consumer<String> listener) {
		searchText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				listener.accept(text);
			}
			
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton searchButton;
        private javax.swing.JTextField searchText;
        // End of variables declaration//GEN-END:variables
}
