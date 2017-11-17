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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Toolbox extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField y;
	private JTextField x;
	private JTextField width;
	private JTextField height;
	private JTextField newFile;
	private JTextField red;
	private JTextField green;
	private JTextField blue;

	public Toolbox() {
		super("Toolbox");
		
		ButtonGroup buttons = new ButtonGroup();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 91, 91, 0};
		gridBagLayout.rowHeights = new int[]{79, 79, 0, 79, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		red = new JTextField();
		GridBagConstraints gbc_red = new GridBagConstraints();
		gbc_red.insets = new Insets(0, 0, 5, 5);
		gbc_red.fill = GridBagConstraints.HORIZONTAL;
		gbc_red.gridx = 0;
		gbc_red.gridy = 2;
		getContentPane().add(red, gbc_red);
		red.setColumns(10);
		
		green = new JTextField();
		GridBagConstraints gbc_green = new GridBagConstraints();
		gbc_green.insets = new Insets(0, 0, 5, 5);
		gbc_green.fill = GridBagConstraints.HORIZONTAL;
		gbc_green.gridx = 1;
		gbc_green.gridy = 2;
		getContentPane().add(green, gbc_green);
		green.setColumns(10);
		
		blue = new JTextField();
		GridBagConstraints gbc_blue = new GridBagConstraints();
		gbc_blue.insets = new Insets(0, 0, 5, 0);
		gbc_blue.fill = GridBagConstraints.HORIZONTAL;
		gbc_blue.gridx = 2;
		gbc_blue.gridy = 2;
		getContentPane().add(blue, gbc_blue);
		blue.setColumns(10);
		JButton button = new JButton();
		button.setText("Submit");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		getContentPane().add(button, gbc_button);
		
		JRadioButton button1 = new JRadioButton("Print Pixel Color");
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 4;
		getContentPane().add(button1, gbc_button1);
		buttons.add(button1);
		
		JRadioButton button2 = new JRadioButton("Draw Darker Line");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 1;
		gbc_button2.gridy = 4;
		getContentPane().add(button2, gbc_button2);
		buttons.add(button2);
		
		JRadioButton button3 = new JRadioButton("Draw Square");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.insets = new Insets(0, 0, 5, 0);
		gbc_button3.gridx = 2;
		gbc_button3.gridy = 4;
		getContentPane().add(button3, gbc_button3);
		buttons.add(button3);
		
		JRadioButton button4 = new JRadioButton("Draw Triangle   ");
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 5;
		getContentPane().add(button4, gbc_button4);
		buttons.add(button4);
		
		JRadioButton button5 = new JRadioButton("Reflect X             ");
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 1;
		gbc_button5.gridy = 5;
		getContentPane().add(button5, gbc_button5);
		buttons.add(button5);
		
		JRadioButton button6 = new JRadioButton("Inverse Colors");
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.insets = new Insets(0, 0, 5, 0);
		gbc_button6.gridx = 2;
		gbc_button6.gridy = 5;
		getContentPane().add(button6, gbc_button6);
		buttons.add(button6);
		
		JRadioButton button7 = new JRadioButton("Grayscale         ");
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.insets = new Insets(0, 0, 5, 5);
		gbc_button7.gridx = 0;
		gbc_button7.gridy = 6;
		getContentPane().add(button7, gbc_button7);
		buttons.add(button7);
		
		newFile = new JTextField();
		GridBagConstraints gbc_newFile = new GridBagConstraints();
		gbc_newFile.insets = new Insets(0, 0, 5, 5);
		gbc_newFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_newFile.gridx = 0;
		gbc_newFile.gridy = 8;
		getContentPane().add(newFile, gbc_newFile);
		newFile.setColumns(10);
		
		JButton update = new JButton("Update Image");
		GridBagConstraints gbc_update = new GridBagConstraints();
		gbc_update.insets = new Insets(0, 0, 5, 5);
		gbc_update.gridx = 1;
		gbc_update.gridy = 8;
		getContentPane().add(update, gbc_update);
		
		getRootPane().setDefaultButton(button);
		button.requestFocus();
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				int x_value = Integer.parseInt(x.getText());
				int y_value = Integer.parseInt(y.getText());
				int width_value = Integer.parseInt(width.getText());
				int height_value = Integer.parseInt(height.getText());
				
				if (button1.isSelected()) {
					PictureEditor.printPixelColors(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
				} else if (button2.isSelected()) {
					PictureEditor.drawDarkerLine(Integer.parseInt(y.getText()), Integer.parseInt(width.getText()));
				} else if (button3.isSelected()) {
					PictureEditor.drawSquare(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
				} else if (button4.isSelected()) {
					PictureEditor.drawTriangle(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
				} else if (button5.isSelected()) {
					PictureEditor.reflectX();
				} else if (button6.isSelected()) {
					PictureEditor.inverseColors();
				} else if (button7.isSelected()) {
					PictureEditor.grayscale();
				}
			}
		});
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = PictureEditor.pic.getFrame();
				PictureEditor.pic = new Picture(newFile.getText());
				PictureEditor.pic.show();
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.dispose();
			}
		});
		
		JButton reset = new JButton("Reset");
		GridBagConstraints gbc_reset = new GridBagConstraints();
		gbc_reset.insets = new Insets(0, 0, 5, 0);
		gbc_reset.gridx = 2;
		gbc_reset.gridy = 8;
		getContentPane().add(reset, gbc_reset);
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					JFrame frame = PictureEditor.pic.getFrame();
					PictureEditor.pic = new Picture(PictureEditor.pic.getFile());
					PictureEditor.pic.show();
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.dispose();
				}
			}
		});
		
		setSize(324,428);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
