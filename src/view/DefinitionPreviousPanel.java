/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.event.*;
import dictionarymodel.DictionaryEntry;
import java.util.function.Consumer;

/**
 *
 * @author eco
 */
public class DefinitionPreviousPanel extends javax.swing.JPanel {
	private DictionaryEntry data;

	/**
	 * Creates new form DefinitionNextPanel
	 */
	public DefinitionPreviousPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                wordLabel = new javax.swing.JLabel();
                prevLabel = new javax.swing.JLabel();

                wordLabel.setFont(new java.awt.Font("sansserif", 2, 20)); // NOI18N
                wordLabel.setText("Lorel");

                prevLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
                prevLabel.setForeground(new java.awt.Color(65, 114, 159));
                prevLabel.setText("< previous");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prevLabel)
                                        .addComponent(wordLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(wordLabel)
                                .addGap(8, 8, 8)
                                .addComponent(prevLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

	public void addGotoDefinitionListener(Consumer<DictionaryEntry> listener) {
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (data != null) {
					listener.accept(data);
				}
			}
		});
	}

	public void setData(DictionaryEntry data) {
		if (data == null) {
			wordLabel.setText("");
			prevLabel.setText("");
		} else {
			wordLabel.setText(data.word);
			prevLabel.setText("< previous");
		}
		this.data = data;
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel prevLabel;
        private javax.swing.JLabel wordLabel;
        // End of variables declaration//GEN-END:variables
}
