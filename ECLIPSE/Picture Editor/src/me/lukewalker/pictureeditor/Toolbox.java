package me.lukewalker.pictureeditor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Toolbox extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField y;
	private JTextField x;
	private JTextField width;
	private JTextField height;

	public Toolbox() {
		super("Toolbox");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 91, 91, 0};
		gridBagLayout.rowHeights = new int[]{79, 79, 79, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		x = new JTextField();
		GridBagConstraints gbc_x = new GridBagConstraints();
		gbc_x.fill = GridBagConstraints.BOTH;
		gbc_x.insets = new Insets(0, 0, 5, 5);
		gbc_x.gridx = 0;
		gbc_x.gridy = 0;
		getContentPane().add(x, gbc_x);
		x.setColumns(10);
		
		JLabel label1 = new JLabel("X x Y");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.fill = GridBagConstraints.BOTH;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 0;
		getContentPane().add(label1, gbc_label1);
		
		y = new JTextField();
		GridBagConstraints gbc_y = new GridBagConstraints();
		gbc_y.fill = GridBagConstraints.BOTH;
		gbc_y.insets = new Insets(0, 0, 5, 0);
		gbc_y.gridx = 2;
		gbc_y.gridy = 0;
		getContentPane().add(y, gbc_y);
		y.setColumns(10);
		
		width = new JTextField();
		GridBagConstraints gbc_width = new GridBagConstraints();
		gbc_width.fill = GridBagConstraints.BOTH;
		gbc_width.insets = new Insets(0, 0, 5, 5);
		gbc_width.gridx = 0;
		gbc_width.gridy = 1;
		getContentPane().add(width, gbc_width);
		width.setColumns(10);
		
		JLabel lblWidthXHeight = new JLabel("Width x Height");
		lblWidthXHeight.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWidthXHeight = new GridBagConstraints();
		gbc_lblWidthXHeight.fill = GridBagConstraints.BOTH;
		gbc_lblWidthXHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidthXHeight.gridx = 1;
		gbc_lblWidthXHeight.gridy = 1;
		getContentPane().add(lblWidthXHeight, gbc_lblWidthXHeight);
		
		height = new JTextField();
		GridBagConstraints gbc_height = new GridBagConstraints();
		gbc_height.fill = GridBagConstraints.BOTH;
		gbc_height.insets = new Insets(0, 0, 5, 0);
		gbc_height.gridx = 2;
		gbc_height.gridy = 1;
		getContentPane().add(height, gbc_height);
		height.setColumns(10);
		JButton button = new JButton();
		button.setText("Submit");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		getContentPane().add(button, gbc_button);
		
		JRadioButton button1 = new JRadioButton("Print Pixel Color");
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.insets = new Insets(0, 0, 0, 5);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 3;
		getContentPane().add(button1, gbc_button1);
		
		JRadioButton button2 = new JRadioButton("Draw Darker Line");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.insets = new Insets(0, 0, 0, 5);
		gbc_button2.gridx = 1;
		gbc_button2.gridy = 3;
		getContentPane().add(button2, gbc_button2);
		
		JRadioButton button3 = new JRadioButton("Draw Square");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.gridx = 2;
		gbc_button3.gridy = 3;
		getContentPane().add(button3, gbc_button3);
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		
		setSize(357,289);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if (button1.isSelected()) {
					PictureEditor.printPixelColors(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
				} else if (button2.isSelected()) {
					PictureEditor.drawDarkerLine(Integer.parseInt(y.getText()));
				} else if (button3.isSelected()) {
					PictureEditor.drawSquare(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
				}
			}
		});
	}
}
