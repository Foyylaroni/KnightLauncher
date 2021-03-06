package xyz.lucasallegri.launcher.settings;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import mdlaf.utils.MaterialBorders;
import xyz.lucasallegri.launcher.Fonts;
import xyz.lucasallegri.launcher.Language;
import xyz.lucasallegri.launcher.LauncherGUI;
import xyz.lucasallegri.logging.KnightLog;
import xyz.lucasallegri.util.ColorUtil;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class SettingsGUI {

	public static JFrame settingsGUIFrame;
	public static JComboBox<String> choicePlatform;
	public static JComboBox<String> choiceLanguage;
	public static JComboBox<String> choiceStyle;
	public static JComboBox<String> choiceMemory;
	public static JCheckBox checkboxRebuilds;
	public static JCheckBox checkboxKeepOpen;
	public static JButton forceRebuildButton;
	public static JCheckBox checkboxShortcut;
	public static JCheckBox checkboxStringDeduplication;
	public static JCheckBox checkboxG1GC;
	public static JCheckBox checkboxExplicitGC;
	public static JCheckBox checkboxUndecorated;
	public static JEditorPane argumentsPane;
	
	int pY, pX;

	public static void compose() {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					SettingsGUI window = new SettingsGUI();
					window.settingsGUIFrame.setVisible(true);
				} catch (Exception e) {
					KnightLog.logException(e);
				}
			}
		});
	}

	public SettingsGUI() {
		LauncherGUI.launcherGUIFrame.setVisible(false);
		initialize();
	}

	private void initialize() {
		settingsGUIFrame = new JFrame();
		settingsGUIFrame.setTitle(Language.getValue("t.settings"));
		settingsGUIFrame.setBounds(100, 100, 850, 475);
		settingsGUIFrame.setResizable(false);
		settingsGUIFrame.setUndecorated(true);
		settingsGUIFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settingsGUIFrame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.setBounds(-2, 20, 852, 455);
		tabbedPane.setFont(Fonts.fontMedBig);
		tabbedPane.addTab("Appearance", createAppearancePanel());
		tabbedPane.addTab("Behavior", createBehaviorPanel());
		tabbedPane.addTab("Game", createGamePanel());
		tabbedPane.addTab("Files", new JPanel());
		tabbedPane.addTab("Mods", createModsPanel());
		tabbedPane.addTab("Connection", createConnectionPanel());
		settingsGUIFrame.getContentPane().add(tabbedPane);
		
//		checkboxRebuilds = new JCheckBox(Language.getValue("m.rebuilds"));
//		checkboxRebuilds.setBounds(11, 203, 270, 23);
//		checkboxRebuilds.setFont(Fonts.fontReg);
//		checkboxRebuilds.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxRebuilds);
//		checkboxRebuilds.setSelected(Settings.doRebuilds);
//		checkboxRebuilds.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.rebuildsChangeEvent(_action);
//			}
//		});
//		
//		checkboxKeepOpen = new JCheckBox(Language.getValue("m.keep_open"));
//		checkboxKeepOpen.setBounds(11, 225, 270, 21);
//		checkboxKeepOpen.setFont(Fonts.fontReg);
//		checkboxKeepOpen.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxKeepOpen);
//		checkboxKeepOpen.setSelected(Settings.keepOpen);
//		checkboxKeepOpen.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.keepOpenChangeEvent(_action);
//			}
//		});
//		
//		forceRebuildButton = new JButton(Language.getValue("b.force_rebuild"));
//		forceRebuildButton.setBounds(166, 247, 120, 23);
//		forceRebuildButton.setFont(Fonts.fontMed);
//		forceRebuildButton.setFocusPainted(false);
//		forceRebuildButton.setFocusable(false);
//		forceRebuildButton.setToolTipText(Language.getValue("b.force_rebuild"));
//		settingsGUIFrame.getContentPane().add(forceRebuildButton);
//		forceRebuildButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.forceRebuildEvent();
//			}
//		});
//		
//		checkboxShortcut = new JCheckBox(Language.getValue("m.create_shortcut"));
//		checkboxShortcut.setBounds(11, 247, 139, 23);
//		checkboxShortcut.setFont(Fonts.fontReg);
//		checkboxShortcut.setFocusPainted(false);
//		checkboxShortcut.setToolTipText(Language.getValue("m.create_shortcut"));
//		settingsGUIFrame.getContentPane().add(checkboxShortcut);
//		checkboxShortcut.setSelected(Settings.createShortcut);
//		checkboxShortcut.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.createShortcutChangeEvent(_action);
//			}
//		});
//		
//		JSeparator sepExtraTxt = new JSeparator();
//		sepExtraTxt.setBounds(10, 308, 272, 2);
//		settingsGUIFrame.getContentPane().add(sepExtraTxt);
//		
//		JLabel labelExtraTxt = new JLabel(Language.getValue("m.extratxt_settings"));
//		labelExtraTxt.setFont(Fonts.fontMed);
//		labelExtraTxt.setBounds(10, 288, 271, 14);
//		settingsGUIFrame.getContentPane().add(labelExtraTxt);
//		
//		JLabel labelMemory = new JLabel(Language.getValue("m.allocated_memory"));
//		labelMemory.setFont(Fonts.fontReg);
//		labelMemory.setBounds(15, 327, 124, 14);
//		settingsGUIFrame.getContentPane().add(labelMemory);
//		
//		choiceMemory = new JComboBox<String>();
//		choiceMemory.setFont(Fonts.fontReg);
//		choiceMemory.setFocusable(false);
//		choiceMemory.setBounds(145, 323, 135, 20);
//		settingsGUIFrame.getContentPane().add(choiceMemory);
//		choiceMemory.addItem(Language.getValue("o.memory_default"));
//		choiceMemory.addItem(Language.getValue("o.memory_low"));
//		choiceMemory.addItem(Language.getValue("o.memory_med"));
//		choiceMemory.addItem(Language.getValue("o.memory_high"));
//		choiceMemory.addItem(Language.getValue("o.memory_flex"));
//		choiceMemory.setSelectedIndex(parseSelectedMemoryAsIndex());
//		choiceMemory.setToolTipText((String)choiceMemory.getSelectedItem());
//		choiceMemory.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent event) {
//				SettingsEventHandler.memoryChangeEvent(event);
//			}
//		});
//		
//		checkboxStringDeduplication = new JCheckBox(Language.getValue("m.use_string_deduplication"));
//		checkboxStringDeduplication.setFont(Fonts.fontReg);
//		checkboxStringDeduplication.setBounds(11, 357, 249, 23);
//		checkboxStringDeduplication.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxStringDeduplication);
//		checkboxStringDeduplication.setSelected(Settings.gameUseStringDeduplication);
//		checkboxStringDeduplication.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.useStringDeduplicationChangeEvent(_action);
//			}
//		});
//		
//		checkboxG1GC = new JCheckBox(Language.getValue("m.use_g1gc"));
//		checkboxG1GC.setFont(Fonts.fontReg);
//		checkboxG1GC.setBounds(11, 379, 249, 23);
//		checkboxG1GC.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxG1GC);
//		checkboxG1GC.setSelected(Settings.gameUseG1GC);
//		checkboxG1GC.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.useG1GCChangeEvent(_action);
//			}
//		});
//		
//		checkboxExplicitGC = new JCheckBox(Language.getValue("m.disable_explicit_gc"));
//		checkboxExplicitGC.setFont(Fonts.fontReg);
//		checkboxExplicitGC.setBounds(11, 401, 249, 23);
//		checkboxExplicitGC.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxExplicitGC);
//		checkboxExplicitGC.setSelected(Settings.gameDisableExplicitGC);
//		checkboxExplicitGC.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.disableExplicitGCChangeEvent(_action);
//			}
//		});
//		
//		checkboxUndecorated = new JCheckBox(Language.getValue("m.undecorated_window"));
//		checkboxUndecorated.setFont(Fonts.fontReg);
//		checkboxUndecorated.setBounds(11, 423, 249, 23);
//		checkboxUndecorated.setFocusPainted(false);
//		settingsGUIFrame.getContentPane().add(checkboxUndecorated);
//		checkboxUndecorated.setSelected(Settings.gameUndecoratedWindow);
//		checkboxUndecorated.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent _action) {
//				SettingsEventHandler.undecoratedWindowChangeEvent(_action);
//			}
//		});
//		
//		JLabel labelArgumentsPane = new JLabel(Language.getValue("m.additional_args"));
//		labelArgumentsPane.setFont(Fonts.fontMed);
//		labelArgumentsPane.setBounds(13, 462, 271, 14);
//		settingsGUIFrame.getContentPane().add(labelArgumentsPane);
//		
//		argumentsPane = new JEditorPane();
//		argumentsPane.setFont(Fonts.fontReg);
//		argumentsPane.setBounds(11, 421, 255, 85);
//		settingsGUIFrame.getContentPane().add(argumentsPane);
//		argumentsPane.setText(Settings.gameAdditionalArgs);
//		
//		JScrollPane scrollBar = new JScrollPane(argumentsPane);
//		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollBar.setBounds(11, 483, 272, 85);
//		settingsGUIFrame.getContentPane().add(scrollBar);
		
		JPanel titleBar = new JPanel();
		titleBar.setBounds(0, 0, settingsGUIFrame.getWidth(), 20);
		titleBar.setBackground(ColorUtil.getTitleBarColor());
		settingsGUIFrame.getContentPane().add(titleBar);
		
		
		/*
		 * Based on Paul Samsotha's reply @ StackOverflow
		 * link: https://stackoverflow.com/questions/24476496/drag-and-resize-undecorated-jframe
		 */
		titleBar.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		    	
		        pX = me.getX();
		        pY = me.getY();
		    }
		});
		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				
		        pX = me.getX();
		        pY = me.getY();
		    }
		
		    @Override 
		    public void mouseDragged(MouseEvent me) {
		
		    	settingsGUIFrame.setLocation(settingsGUIFrame.getLocation().x + me.getX() - pX,
		    	settingsGUIFrame.getLocation().y + me.getY() - pY);
		    }
		});
		titleBar.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent me) {
		
				settingsGUIFrame.setLocation(settingsGUIFrame.getLocation().x + me.getX() - pX,
				settingsGUIFrame.getLocation().y + me.getY() - pY);
		    }
		
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// Auto-generated method stub
			}
		});
		titleBar.setLayout(null);
		
		JLabel windowTitle = new JLabel(Language.getValue("t.settings"));
		windowTitle.setFont(Fonts.fontMed);
		windowTitle.setBounds(10, 0, settingsGUIFrame.getWidth() - 100, 20);
		titleBar.add(windowTitle);
		
		Icon closeIcon = IconFontSwing.buildIcon(FontAwesome.WINDOW_CLOSE_O, 14, ColorUtil.getForegroundColor());
		JButton closeButton = new JButton(closeIcon);
		closeButton.setBounds(settingsGUIFrame.getWidth() - 22, 0, 20, 20);
		closeButton.setFocusPainted(false);
		closeButton.setFocusable(false);
		closeButton.setBorder(MaterialBorders.roundedLineColorBorder(ColorUtil.getTitleBarColor(), 0));
		closeButton.setFont(Fonts.fontMed);
		titleBar.add(closeButton);
		closeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       settingsGUIFrame.dispose();
		    }
		});
		
		Icon minimizeIcon = IconFontSwing.buildIcon(FontAwesome.WINDOW_MINIMIZE, 14, ColorUtil.getForegroundColor());
		JButton minimizeButton = new JButton(minimizeIcon);
		minimizeButton.setBounds(settingsGUIFrame.getWidth() - 42, 0, 20, 20);
		minimizeButton.setFocusPainted(false);
		minimizeButton.setFocusable(false);
		minimizeButton.setBorder(MaterialBorders.roundedLineColorBorder(ColorUtil.getTitleBarColor(), 0));
		minimizeButton.setFont(Fonts.fontMed);
		titleBar.add(minimizeButton);
		
		settingsGUIFrame.setLocationRelativeTo(null);
		
		settingsGUIFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosed(WindowEvent windowEvent) {
		    	LauncherGUI.launcherGUIFrame.setVisible(true);
		        SettingsEventHandler.saveAdditionalArgs();
		    }
		});
		
	}
	
	protected JPanel createAppearancePanel() {
		JPanel appearancePanel = new JPanel();
		appearancePanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Appearance");
		headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerLabel.setBounds(25, 11, 450, 50);
		headerLabel.setFont(Fonts.fontMedGiant);
		appearancePanel.add(headerLabel);
		
		JLabel labelStyle = new JLabel(Language.getValue("m.launcher_style"));
		labelStyle.setBounds(25, 90, 125, 18);
		labelStyle.setFont(Fonts.fontRegBig);
		appearancePanel.add(labelStyle);
		
		choiceStyle = new JComboBox<String>();
		choiceStyle.setBounds(25, 115, 150, 20);
		choiceStyle.setFocusable(false);
		choiceStyle.setFont(Fonts.fontReg);
		choiceStyle.addItem(Language.getValue("o.dark"));
		choiceStyle.addItem(Language.getValue("o.light"));
		appearancePanel.add(choiceStyle);
		choiceStyle.setSelectedIndex(Settings.launcherStyle.equals("dark") ? 0 : 1);
		choiceStyle.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				SettingsEventHandler.styleChangeEvent(event);
			}
		});
		
		JLabel labelLanguage = new JLabel(Language.getValue("m.language"));
		labelLanguage.setBounds(225, 90, 125, 18);
		labelLanguage.setFont(Fonts.fontRegBig);
		appearancePanel.add(labelLanguage);
		
		choiceLanguage = new JComboBox<String>();
		choiceLanguage.setBounds(225, 115, 150, 20);
		choiceLanguage.setFocusable(false);
		choiceLanguage.setFont(Fonts.fontReg);
		for(String lang : Language.AVAILABLE_LANGUAGES) {
			choiceLanguage.addItem(lang);
		}
		appearancePanel.add(choiceLanguage);
		choiceLanguage.setSelectedItem(Language.getLangName(Settings.lang));
		choiceLanguage.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				SettingsEventHandler.languageChangeEvent(event);
			}
		});
		
		return appearancePanel;
	}
	
	protected JPanel createBehaviorPanel() {
		JPanel behaviorPanel = new JPanel();
		behaviorPanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Behavior");
		headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerLabel.setBounds(25, 11, 450, 50);
		headerLabel.setFont(Fonts.fontMedGiant);
		behaviorPanel.add(headerLabel);
		
		JLabel labelCleaning = new JLabel(Language.getValue("m.rebuilds"));
		labelCleaning.setBounds(25, 90, 225, 18);
		labelCleaning.setFont(Fonts.fontRegBig);
		behaviorPanel.add(labelCleaning);
		
		JLabel labelCleaningExplained = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		labelCleaningExplained.setBounds(25, 110, 600, 16);
		labelCleaningExplained.setFont(Fonts.fontReg);
		behaviorPanel.add(labelCleaningExplained);
		
		JToggleButton switchCleaning = new JToggleButton("");
		switchCleaning.setBounds(680, 95, 30, 23);
		behaviorPanel.add(switchCleaning);
		
		JSeparator sep = new JSeparator();
		sep.setBounds(25, 140, 690, 16);
		behaviorPanel.add(sep);
		
		JLabel labelKeepOpen = new JLabel(Language.getValue("m.keep_open"));
		labelKeepOpen.setBounds(25, 155, 225, 18);
		labelKeepOpen.setFont(Fonts.fontRegBig);
		behaviorPanel.add(labelKeepOpen);
		
		JLabel labelKeepOpenExplained = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		labelKeepOpenExplained.setBounds(25, 175, 600, 16);
		labelKeepOpenExplained.setFont(Fonts.fontReg);
		behaviorPanel.add(labelKeepOpenExplained);
		
		JToggleButton switchKeepOpen = new JToggleButton("");
		switchKeepOpen.setBounds(680, 160, 30, 23);
		behaviorPanel.add(switchKeepOpen);
		
		JSeparator sep2 = new JSeparator();
		sep2.setBounds(25, 205, 690, 16);
		behaviorPanel.add(sep2);
		
		JLabel labelShortcut = new JLabel(Language.getValue("m.create_shortcut"));
		labelShortcut.setBounds(25, 220, 225, 18);
		labelShortcut.setFont(Fonts.fontRegBig);
		behaviorPanel.add(labelShortcut);
		
		JLabel labelShortcutExplained = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		labelShortcutExplained.setBounds(25, 240, 600, 16);
		labelShortcutExplained.setFont(Fonts.fontReg);
		behaviorPanel.add(labelShortcutExplained);
		
		JToggleButton switchShortcut = new JToggleButton("");
		switchShortcut.setBounds(680, 225, 30, 23);
		behaviorPanel.add(switchShortcut);
		
		return behaviorPanel;
	}
	
	protected JPanel createGamePanel() {
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Game");
		headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerLabel.setBounds(25, 11, 450, 50);
		headerLabel.setFont(Fonts.fontMedGiant);
		gamePanel.add(headerLabel);
		
		JLabel labelStyle = new JLabel(Language.getValue("m.platform"));
		labelStyle.setBounds(25, 90, 125, 18);
		labelStyle.setFont(Fonts.fontRegBig);
		gamePanel.add(labelStyle);
		
		choicePlatform = new JComboBox<String>();
		choicePlatform.setBounds(25, 115, 150, 20);
		choicePlatform.setFont(Fonts.fontReg);
		choicePlatform.setFocusable(false);
		gamePanel.add(choicePlatform);
		choicePlatform.addItem(Language.getValue("o.steam"));
		choicePlatform.addItem(Language.getValue("o.standalone"));
		choicePlatform.setSelectedItem(Settings.gamePlatform);
		choicePlatform.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				SettingsEventHandler.platformChangeEvent(event);
			}
		});
		
		return gamePanel;
	}
	
	protected JPanel createModsPanel() {
		JPanel modsPanel = new JPanel();
		modsPanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Mods");
		headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerLabel.setBounds(25, 11, 450, 50);
		headerLabel.setFont(Fonts.fontMedGiant);
		modsPanel.add(headerLabel);
		
		JLabel soonLabel = new JLabel("Coming soon...");
		soonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		soonLabel.setBounds(25, 60, 450, 50);
		soonLabel.setFont(Fonts.fontRegBig);
		modsPanel.add(soonLabel);
		
		return modsPanel;
	}
	
	protected JPanel createConnectionPanel() {
		JPanel connectionPanel = new JPanel();
		connectionPanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Connection");
		headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerLabel.setBounds(25, 11, 450, 50);
		headerLabel.setFont(Fonts.fontMedGiant);
		connectionPanel.add(headerLabel);
		
		JLabel soonLabel = new JLabel("Coming soon...");
		soonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		soonLabel.setBounds(25, 60, 450, 50);
		soonLabel.setFont(Fonts.fontRegBig);
		connectionPanel.add(soonLabel);
		
		return connectionPanel;
	}
 	
	public static int parseSelectedMemoryAsInt() {
		switch(choiceMemory.getSelectedIndex()) {
		case 0: return 512;
		case 1: return 1024;
		case 2: return 2048;
		case 3: return 4096;
		case 4: return 8192;
		}
		return 512;
	}
	
	public static int parseSelectedMemoryAsIndex() {
		switch(Settings.gameMemory) {
		case 512: return 0;
		case 1024: return 1;
		case 2048: return 2;
		case 4096: return 3;
		case 8192: return 4;
		}
		return 0;
	}
}
