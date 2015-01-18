package com.tut.client.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;

public class OrderView extends JPanel {

	// Constructor
	public OrderView(NewOrderController controller) {
		this.controller = controller;

		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());
		this.setPreferredSize(new Dimension(GUIconstants.NOTELIST_WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Colors.NOTE_BORDER.getColor()));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		updateView();
	}

	private void createComponents() {
		Box noteLayout = Box.createVerticalBox();

		// Box
		Box headerBox = createHeader();
		Box contentBox = createContent();

		noteLayout.add(headerBox);
		noteLayout.add(Box.createVerticalStrut(10));
		noteLayout.add(Box.createVerticalStrut(10));
		noteLayout.add(contentBox);
		this.add(noteLayout);
	}

	// HeaderBox
	private Box createHeader() {
		FlowLayout header = new FlowLayout(FlowLayout.LEFT);
		JPanel hPanel = new JPanel(header);
		hPanel.setOpaque(false);

		JLabel title = new JLabel("Shopping Cart");
		title.setFont(new Font("Calibri", Font.BOLD, 35));

		// Icon Holder
		Box iconHolder = Box.createHorizontalBox();


		// Cursor
		Cursor hand = new Cursor(Cursor.HAND_CURSOR);
		lbNew.setCursor(hand);
		lbEdit.setCursor(hand);
		lbDelete.setCursor(hand);

		// Add Listeners
		NoteListener listener = new NoteListener();
		lbNew.addMouseListener(listener);
		lbEdit.addMouseListener(listener);
		lbDelete.addMouseListener(listener);

		iconHolder.add(lbNew);
		iconHolder.add(lbEdit);
		iconHolder.add(lbDelete);

		hPanel.add(title);

		Box headerBox = Box.createHorizontalBox(); // Box Layout
		headerBox.add(hPanel);
		headerBox.add(iconHolder);
		return headerBox;
	}

	

	// content
	private Box createContent() {
		JPanel fPanel = new JPanel(new BorderLayout());
		fPanel.setOpaque(false);
		fPanel.setPreferredSize(new Dimension(GUIconstants.NOTE_WIDTH.getValue() - 50, 50));

		Font adjustedFont = new Font("Calibri", Font.PLAIN, 20);
		JTextArea contentArea = new JTextArea(10, 5);
		contentArea.setLineWrap(true);
		contentArea.setFont(adjustedFont);
		fPanel.add(contentArea, BorderLayout.CENTER);

		Box footerBox = Box.createHorizontalBox(); // Box Layout
		footerBox.add(fPanel);
		return footerBox;
	}

	public void updateView() {
		this.removeAll();

		this.revalidate();
		this.repaint();
	}

	class NoteListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);

			if (e.getSource() == lbNew) {
				String strTask = (String) JOptionPane.showInputDialog(null, "To-Do", "New Task",
						JOptionPane.OK_CANCEL_OPTION);
				if (strTask != null && !strTask.equals("")) {
				}

			} else if (e.getSource() == lbEdit) {
			} else if (e.getSource() == lbDelete) {
				int option = (int) JOptionPane.showConfirmDialog(null, "Are you sure you to remove this note?",
						"Delete Note", JOptionPane.YES_NO_OPTION);
			}
		}
	}

	private static final long serialVersionUID = 1L;
	private NewOrderController controller;

	// Action icons
	private JLabel lbNew;
	private JLabel lbEdit;
	private JLabel lbDelete;
}
