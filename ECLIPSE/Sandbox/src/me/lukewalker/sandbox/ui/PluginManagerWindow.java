package me.lukewalker.sandbox.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import me.lukewalker.sandbox.plugins.Plugin;
import me.lukewalker.sandbox.plugins.PluginLoader;

public class PluginManagerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public PluginManagerWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Plugin Manager");
		// SET SIZE
		//setSize()
		setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblEnabled = new JLabel("Enabled");
		lblEnabled.setBounds(84, 17, 46, 14);
		getContentPane().add(lblEnabled);
		
		JList disabledList = new JList();
		disabledList.setBounds(231, 33, 203, 194);
		getContentPane().add(disabledList);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Plugin plugin : PluginLoader.getInstance().enabled) {
			listModel.addElement(plugin.getName());
		}
		JList enabledList = new JList(listModel);
		enabledList.setBounds(10, 33, 203, 194);
		getContentPane().add(enabledList);
		
		JLabel lblDisabled = new JLabel("Disabled");
		lblDisabled.setBounds(310, 17, 46, 14);
		getContentPane().add(lblDisabled);
		
		JButton btnDisable = new JButton("disable --->");
		btnDisable.setBounds(68, 238, 89, 23);
		getContentPane().add(btnDisable);
		btnDisable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnEnable = new JButton("<--- enable");
		btnEnable.setBounds(286, 238, 89, 23);
		getContentPane().add(btnEnable);
		btnEnable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
