package com.inov.ss7analayser.beans;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapDumper;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.JScanner;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;




/**
 * 
 * @author Abderrahim OUBIDAR
 */

public class AnalayserForm extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public AnalayserForm(){
		
		initComponents();
		selectButton.setVisible(false);
		captureButton.setVisible(false);
		analayseFromInterface.setVisible(false);
		interfaceNumber.setVisible(false);
		analayseLoadedFile.setEnabled(false);

		colorizeIt();
	}
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		analayseFromInterface = new JButton();
		captureButton = new JButton();
		interfaceNumber = new JTextField();
		listButton = new JButton();
		loadButton = new JButton();
		selectButton = new JButton();
		analayseLoadedFile = new JButton();
		packetListPanel = new JTabbedPane();
		outputList = new JScrollPane();
		packetsList = new JList<>();
		jScrollPane2 = new JScrollPane();
		outputText = new JTextArea();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("SS7 ANALYZER");
		setBackground(new Color(117, 125, 250));

		analayseFromInterface.setForeground(new Color(40, 21, 233));
		analayseFromInterface.setText("Analyse");
		analayseFromInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				analyseInterfaceActionPerformed(evt);
			}
		});
		

		captureButton.setForeground(new Color(40, 21, 233));
		captureButton.setText("Capture");
		captureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				captureActionPerformed(evt);
			}
		});
		

		interfaceNumber.setForeground(new Color(40, 21, 233));
		interfaceNumber.setText("0");

		listButton.setForeground(new Color(40, 21, 233));
		listButton.setText("List");
		listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				listActionPerformed(evt);
			}
		});
		

		loadButton.setForeground(new Color(253, 0, 0));
		loadButton.setText("Load ");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loadActionPerformed(evt);
			}
		});

		selectButton.setForeground(new Color(40, 21, 233));
		selectButton.setText("Select");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				selectActionPerformed(evt);
			}
		});

		analayseLoadedFile.setForeground(new Color(253, 0, 0));
		analayseLoadedFile.setText("Analyse");
		analayseLoadedFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				analyseActionPerformed(evt);
			}
		});


		packetsList.setFont(new Font("Consolas", 0, 12)); // NOI18N
		outputList.setViewportView(packetsList);

		packetListPanel.addTab("PACKET LIST", outputList);

		outputText.setEditable(false);
		outputText.setColumns(20);
		outputText.setFont(new Font("Consolas", 0, 12)); // NOI18N
		outputText.setRows(5);
		jScrollPane2.setViewportView(outputText);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(jScrollPane2)
												.addGroup(
														GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		listButton,
																		GroupLayout.PREFERRED_SIZE,
																		83,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		selectButton,
																		GroupLayout.PREFERRED_SIZE,
																		82,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		interfaceNumber,
																		GroupLayout.PREFERRED_SIZE,
																		32,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		captureButton,
																		GroupLayout.PREFERRED_SIZE,
																		82,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		analayseFromInterface,
																		GroupLayout.PREFERRED_SIZE,
																		92,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		46,
																		Short.MAX_VALUE)
																.addComponent(
																		loadButton,
																		GroupLayout.PREFERRED_SIZE,
																		86,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		analayseLoadedFile,
																		GroupLayout.PREFERRED_SIZE,
																		71,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(
														packetListPanel,
														GroupLayout.Alignment.LEADING))
								.addContainerGap()));

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {
				analayseLoadedFile, analayseFromInterface, captureButton,
				loadButton, listButton, selectButton });

		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(packetListPanel,
										GroupLayout.PREFERRED_SIZE, 134,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2,
										GroupLayout.DEFAULT_SIZE, 346,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
																.addComponent(
																		loadButton)
																.addComponent(
																		analayseLoadedFile))
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
																.addComponent(
																		listButton,
																		GroupLayout.PREFERRED_SIZE,
																		23,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		selectButton)
																.addComponent(
																		interfaceNumber,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		captureButton)
																.addComponent(
																		analayseFromInterface)))
								.addContainerGap()));

		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {
				analayseLoadedFile, analayseFromInterface, captureButton,
				loadButton, listButton, selectButton, interfaceNumber });

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents
	public void analyseInterfaceActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_analyse_intActionPerformed

		// Initialize the list with items
		DefaultListModel model = new DefaultListModel();
		StringBuilder errbuf = new StringBuilder(); // For any error msgs
		final String file = "tmp-capture-file.cap";

		outputText.setText("Opening file for reading: " + file + "\n \n");

		Pcap pcap = Pcap.openOffline(file, errbuf);

		if (pcap == null) {
			outputText.setText("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}
		// -//////////////////////////////////////////
		JScanner.getThreadLocal().setFrameNumber(1);
		// -//////////////////////////////////////////
		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {

				model.addElement(packet.getFrameNumber()
						- 1
						+ ": Received at:"
						+ new Date(packet.getCaptureHeader()
								.timestampInMillis()) + " capture lenght: "
						+ packet.getCaptureHeader().caplen() + " lenght: "
						+ packet.getCaptureHeader().wirelen() + " \n \n");

				packetsList.setModel(model);

				outputText.append("Packet number: "
						+ (packet.getFrameNumber() - 1) + "\n\n"
						+ packet.toHexdump(packet.size(), true, true, true)
						+ packet.toString() + "\n \n");

				// ****************************************************************

			}

		};
		try {

			pcap.loop(Pcap.LOOP_INFINITE, jpacketHandler, "\b");

		} finally {

			pcap.close();

		}

	}// GEN-LAST:event_jButton_analyse_intActionPerformed

	public void captureActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_captureActionPerformed

		JScanner.getThreadLocal().setFrameNumber(0);

		List<PcapIf> alldevs = new ArrayList<>(); // Will be filled with NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs
		DefaultListModel model = new DefaultListModel();

		/***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}

		System.out.println("Network devices found:");

		for (PcapIf device : alldevs) {
			String description = (device.getDescription() != null) ? device
					.getDescription() : "No description available";
		}

		int k = Integer.parseInt(interfaceNumber.getText());

		PcapIf device = alldevs.get(k); // We know we have atleast 1 device
		outputText.append((device.getDescription() != null) ? device
				.getDescription() : device.getName() + "\n");

		/***************************************************************************
		 * Second we open up the selected device
		 **************************************************************************/

		int snaplen = 64 * 1024; // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000; // 10 seconds in millis
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
				errbuf);

		if (pcap == null) {
			System.err.printf("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}

		/***************************************************************************
		 * Third we create a packet handler which will receive packets from the
		 * libpcap loop.
		 **************************************************************************/

		PcapPacketHandler<String> jpacketHandler = (PcapPacket packet,
				String user) -> {

			model.addElement(packet.getFrameNumber() + " Received at: "
					+ new Date(packet.getCaptureHeader().timestampInMillis())
					+ " capture lenght: " + packet.getCaptureHeader().caplen()
					+ " lenght: " + packet.getCaptureHeader().wirelen());
			packetsList.setModel(model);

		};

		pcap.loop(5, jpacketHandler, "");

		/***************************************************************************
		 * save on output file
		 **************************************************************************/

		String ofile = "tmp-capture-file.cap";
		PcapDumper dumper = pcap.dumpOpen(ofile); // output file

		pcap.loop(5, dumper); // Special native dumper call to loop

		File file = new File(ofile);
		outputText.setText("file name: [" + ofile + "] has: " + file.length()
				+ " bytes in it! saved into application's folder. \n");
		// System.out.printf("%s file has %d bytes in it!\n", ofile,
		// file.length());

		dumper.close(); // Won't be able to delete without explicit close

		pcap.close();
		analayseFromInterface.setVisible(true);

	}// GEN-LAST:event_jButton_captureActionPerformed

	public void listActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_listActionPerformed

		List<PcapIf> alldevs = new ArrayList<>(); // Will be filled with NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs

		/***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}

		outputText.setText("Network devices found: \n");

		int i = 0;
		for (PcapIf device : alldevs) {
			String description = (device.getDescription() != null) ? device
					.getDescription() : "No description available";
			outputText.append((i++) + ": " + device.getName() + " ["
					+ description + "]\n");
		}
		selectButton.setVisible(true);
		interfaceNumber.setVisible(true);
	}// GEN-LAST:event_jButton_listActionPerformed

	public void selectActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_selectActionPerformed

		List<PcapIf> alldevs = new ArrayList<>(); // Will be filled with NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs

		/***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}

		outputText.setText("Network devices found: \n");

		int i = 0;
		for (PcapIf device : alldevs) {
			String description = (device.getDescription() != null) ? device
					.getDescription() : "No description available";
			outputText.append((i++) + ": " + device.getName() + " ["
					+ description + "]\n");
		}
		int k = Integer.parseInt(interfaceNumber.getText());

		outputText.append("\n Interface choosed is: ");
		PcapIf device = alldevs.get(k); // We know we have atleast 1 device
		outputText.append((device.getDescription() != null) ? device
				.getDescription() : device.getName() + "\n");

		/***************************************************************************
		 * Second we open up the selected device
		 **************************************************************************/
		int snaplen = 64 * 1024; // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000; // 10 seconds in millis
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
				errbuf);

		if (pcap == null) {
			outputText.append("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}
		captureButton.setVisible(true);
	}// GEN-LAST:event_jButton_selectActionPerformed

	public void loadActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_laodActionPerformed
		try {

			selectButton.setVisible(false);
			captureButton.setVisible(false);
			analayseFromInterface.setVisible(false);
			interfaceNumber.setVisible(false);

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(null);
			File f = fileChooser.getSelectedFile();
			String filename = f.getAbsolutePath();

			outputText.setText(filename);
			analayseLoadedFile.setEnabled(true);
		} catch (Exception e) {
			outputText.setText("You need to laod a file");
		}
	}// GEN-LAST:event_jButton_laodActionPerformed

	public void analyseActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton_analyseActionPerformed

		// Initialize the list with items
		DefaultListModel<String> model = new DefaultListModel<String>();
		final StringBuilder errbuf = new StringBuilder(); // For any error msgs

		final String file = outputText.getText();
		outputText.setText("Opening file for reading: " + file + "\n \n");
		Pcap pcap = Pcap.openOffline(file, errbuf);

		if (pcap == null) {
			outputText.setText("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}

		JScanner.getThreadLocal().setFrameNumber(1);
		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {

				model.addElement(packet.getFrameNumber()
						- 1
						+ ": Received at:"
						+ new Date(packet.getCaptureHeader()
								.timestampInMillis()) + " capture lenght: "
						+ packet.getCaptureHeader().caplen() + " lenght: "
						+ packet.getCaptureHeader().wirelen() + " \n \n");

				packetsList.setModel(model);

				outputText.append("Packet number: "
						+ (packet.getFrameNumber() - 1) + "\n\n"
						+ packet.toHexdump(packet.size(), true, true, true)
						+ packet.toString() + "\n \n");

			}
		};

		try {

			pcap.loop(Pcap.LOOP_INFINITE, jpacketHandler, "\b");

		} finally {
			pcap.close();
			analayseLoadedFile.setEnabled(false);
		}
	}// GEN-LAST:event_jButton_analyseActionPerformed

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					AnalayserPrototype.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					AnalayserPrototype.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					AnalayserPrototype.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					AnalayserPrototype.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AnalayserForm().setVisible(true);
			}
		});
	}

void colorizeIt() {
	Color c = new Color(0, 100, 100);
	this.getContentPane().setBackground(c);
}

// Variables declaration - do not modify//GEN-BEGIN:variables
private JButton analayseLoadedFile;
public JButton analayseFromInterface;
private JButton captureButton;
private JButton loadButton;
private JButton listButton;
private JButton selectButton;
private JList<String> packetsList;
private JScrollPane jScrollPane2;
private JScrollPane outputList;
private JTabbedPane packetListPanel;
private JTextArea outputText;
private JTextField interfaceNumber;
// End of variables declaration//GEN-END:variables
}
