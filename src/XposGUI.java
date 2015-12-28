import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.io.FilenameUtils;

public class XposGUI extends JFrame {

	private File inFile;
	private SpecSheet single;

	public XposGUI() {
		initUI();
	}

	private void initUI() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		JButton quitButton = new JButton("Quit");
		quitButton.setToolTipText("Exit the program");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		JButton updateMapButton = new JButton("Update SpecSheet Map");
		updateMapButton.setToolTipText("Update the SpecSheet Save Files");
		updateMapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SpecSheetMapper map = new SpecSheetMapper();
				map.updateMappings();
			}
		});

		JButton CSVGenButton = new JButton("Generate SQL Tables");
		CSVGenButton.setToolTipText("Transpose cost report and generate SQL tables from data");
		CSVGenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (inFile == null) {
					System.out.println("Please select an input file.");
				} else {
					CSVGenerator gen = new CSVGenerator();
					gen.go(inFile.getPath());
				}
			}
		});
		
		JButton GenSingleCSV = new JButton("Generate Single SQL Table");
		GenSingleCSV.setToolTipText("Transpose cost report and generate SQL tables from single spec sheet");
		GenSingleCSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser inFileChooser = new JFileChooser(System.getProperty("user.dir"));
				inFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res = inFileChooser.showOpenDialog(XposGUI.this);

				if (res == JFileChooser.APPROVE_OPTION) {

					File file = inFileChooser.getSelectedFile();
					String ext = FilenameUtils.getExtension(file.getPath());
					if(inFile == null)
					{
						System.out.println("Please select an input CSV.");
						return;
					}
					String extInFile = FilenameUtils.getExtension(inFile.getPath());
					if (ext.toLowerCase().equals("spec") && inFile != null && extInFile.toLowerCase().equals("csv")) {
						SpecSheetIO packager = new SpecSheetIO();
						single = packager.load(file.getName());
						CSVGenerator gen = new CSVGenerator(single);
						gen.generateIndividual(inFile.getPath());
					} else {
						System.out.println("Incompatible File Type or no input CSV selected.");
					}

				}
			}
		});

		JButton chooseInputFile = new JButton("Choose Input File (CSV)");
		chooseInputFile.setToolTipText("Select a Cost Report to transpose");
		chooseInputFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser inFileChooser = new JFileChooser(System.getProperty("user.dir"));
				inFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res = inFileChooser.showOpenDialog(XposGUI.this);

				if (res == JFileChooser.APPROVE_OPTION) {

					File file = inFileChooser.getSelectedFile();
					String ext = FilenameUtils.getExtension(file.getPath());
					if (ext.toLowerCase().equals("csv")) {
						inFile = file;
					} else {
						System.out.println("Incompatible File Type.");
					}

				} else {

				}
			}
		});

		JButton createSpecSheet = new JButton("Create Spec Sheets");
		createSpecSheet.setToolTipText("Create new spec sheets that will be collected when SQL files are generated.");
		createSpecSheet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				IndividualSheetGUI iu = new IndividualSheetGUI();
				iu.setVisible(true);
			}
		});

		JPanel subPanel = new JPanel();

		subPanel.add(quitButton);
		subPanel.add(updateMapButton);
		subPanel.add(CSVGenButton);
		subPanel.add(GenSingleCSV);
		subPanel.add(chooseInputFile);
		subPanel.add(createSpecSheet);

		subPanel.setBackground(Color.white);

		panel1.add(subPanel, BorderLayout.SOUTH);
		try {
			BufferedImage logo = ImageIO.read(new File(System.getProperty("user.dir") + "/images/logo.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			this.add(picLabel, BorderLayout.NORTH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.add(panel1);

		setTitle("HdsXpoS CSV to SQL Generator (This program is for HDS employee use only)");
		setSize(1020, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				XposGUI ex = new XposGUI();
				ex.setVisible(true);
			}
		});
	}
}
