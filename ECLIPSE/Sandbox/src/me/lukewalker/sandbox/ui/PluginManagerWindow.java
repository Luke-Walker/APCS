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
import me.lukewalker.sandbox.plugins.PluginManager;
import javax.swing.SwingConstants;

public class PluginManagerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public PluginManagerWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Plugin Manager");
		// SET SIZE
		setSize(450, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblEnabled = new JLabel("Enabled");
		lblEnabled.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnabled.setBounds(84, 17, 46, 14);
		getContentPane().add(lblEnabled);
		
		JList<String> enabledList = new JList<>(getEnabledList());
		enabledList.setBounds(10, 33, 203, 194);
		getContentPane().add(enabledList);
		
		JList<String> disabledList = new JList<>(getDisabledList());
		disabledList.setBounds(231, 33, 203, 194);
		getContentPane().add(disabledList);
		
		JLabel lblDisabled = new JLabel("Disabled");
		lblDisabled.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisabled.setBounds(299, 17, 65, 14);
		getContentPane().add(lblDisabled);
		
		JButton btnDisable = new JButton("disable --->");
		btnDisable.setBounds(20, 238, 193, 23);
		getContentPane().add(btnDisable);
		btnDisable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String s : enabledList.getSelectedValuesList())
					PluginManager.getInstance().disablePlugin(PluginManager.getInstance().getPluginByName(s));
				
				enabledList.setModel(getEnabledList());
				disabledList.setModel(getDisabledList());
			}
		});
		
		JButton btnEnable = new JButton("<--- enable");
		btnEnable.setBounds(231, 238, 203, 23);
		getContentPane().add(btnEnable);
		btnEnable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String s : disabledList.getSelectedValuesList())
					PluginManager.getInstance().enablePlugin(PluginManager.getInstance().getPluginByName(s));
				
				enabledList.setModel(getEnabledList());
				disabledList.setModel(getDisabledList());
			}
		});
	}
	
	private DefaultListModel<String> getEnabledList() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Plugin plugin : PluginLoader.getInstance().enabled) model.addElement(plugin.getName());
		return model;
	}
	
	private DefaultListModel<String> getDisabledList() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Plugin plugin : PluginLoader.getInstance().disabled) model.addElement(plugin.getName());
		return model;
	}
}
