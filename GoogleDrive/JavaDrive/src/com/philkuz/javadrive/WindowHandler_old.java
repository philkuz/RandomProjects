//package com.philkuz.javadrive;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.nio.file.*;
//import java.time.*;
//import javax.swing.*;
//import java.io.*;
//
//public class WindowHandler_old {
//	private JFrame frame;
//	private JTextArea taLog;
//	private JTextField tfDirectory;
//	private JFileChooser fcFileBrowser;
//	private GridBagConstraints gridBagC;
//	public String getTimeStr(boolean fileSafe)
//	{
//		LocalDateTime now = LocalDateTime.now();
//		if(!fileSafe)
//		{
//			String time = String.format("%1$td %<tb, %<tY %<tH:%<tM:%<tS \t", now);
//			return time;
//		}
//		else
//		{
//			String time = String.format("%1$tY%<tm%<td_%<tH%<tM%<tS", now);
//			return time;
//		}
//	}
//	public void addLog(String line)
//	{
//		String outputLine = getTimeStr(false) + line;
//		taLog.append(outputLine);
//	}
//	private void setupTextArea(){
//		taLog = new JTextArea();
//		addLog("Starting Log \n");
//		taLog.setColumns(20);
//        
//        taLog.setRows(5);
//        taLog.setWrapStyleWord(true);
//        taLog.setEditable(false);
//        JScrollPane jsPane = new JScrollPane(taLog);
//        gridBagC.gridx = 0;
//        gridBagC.gridy = 1;
//		gridBagC.gridwidth = 3;
//		gridBagC.gridheight = 2;
//		frame.getContentPane().add(jsPane, gridBagC);
//	}
//	private void fileBrowserAction(ActionEvent e){
//		fcFileBrowser = new JFileChooser(); 
//	    fcFileBrowser.setCurrentDirectory(new java.io.File("."));
//	    fcFileBrowser.setDialogTitle("Choose the directory you weant to use");
//	    fcFileBrowser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//	    //
//	    // disable the "All files" option.
//	    //
//	    fcFileBrowser.setAcceptAllFileFilterUsed(false);
//	    //    
//	    if (fcFileBrowser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) { 
//	    	JavaDrive.googleDrivePath = fcFileBrowser.getSelectedFile().getAbsolutePath();
//	    	tfDirectory.setText(JavaDrive.googleDrivePath);
//	    	
//	    }	   
//	}
//	WindowHandler_old()
//	{
//		
//		frame = new JFrame("Java Drive Util");
//		frame.setSize(JavaDrive.windowLength,JavaDrive.windowHeight);
//		frame.getContentPane().setLayout(new GridBagLayout());
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		frame.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent evt){
//				windowClose();
//			}
//		});
//		tfDirectory = new JTextField(JavaDrive.googleDrivePath);
//		JButton jbBrowse = new JButton("Browse");
//		int buttonWidth = 40;
//		int buttonHeight = 22;
//		tfDirectory.setSize(JavaDrive.windowLength-buttonWidth, buttonHeight);
//		
//		
//		
//		
//		jbBrowse.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e){
//				fileBrowserAction(e);
//			}
//		});
//		gridBagC = new GridBagConstraints();
//		gridBagC.fill = GridBagConstraints.HORIZONTAL;
//		gridBagC.ipadx = 200;
//		
//		gridBagC.gridx = 0;
//		gridBagC.gridy = 0;
//		gridBagC.gridwidth = 2;
//		
//		frame.getContentPane().add(tfDirectory, gridBagC);
//		gridBagC.gridx = 2;
//		gridBagC.gridwidth = 1;
//		frame.getContentPane().add(jbBrowse, gridBagC);
//		setupTextArea();
//		
//		
//		frame.setVisible(true);
//	}
//	// close handler that saves the current log to a new file
//	public void windowClose()
//	{		
//		String logDirectory = JavaDrive.logDirectory;
//		
//		File logDir = new File(logDirectory);
//		if(!logDir.exists())
//		{
//			boolean success = false;
//			try {
//				logDir.mkdirs();
//				success= true;
//			}catch(SecurityException e){
//				
//			}
//			if(success)
//			{
//				
//			}
//		}
//		String logFileName = String.format(logDirectory+"javadrive_%s.log",getTimeStr(true));
//		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//	              new FileOutputStream(logFileName), "utf-8"))) {
//			writer.write(taLog.getText());
//			
//		}catch(IOException e)
//		{
//			
//		}
//		System.exit(0);
//	}
//}
