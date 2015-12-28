import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.io.FilenameUtils;

public class IndividualSheetGUI extends JFrame {

	private SpecSheet currentSheet;
	private SpecSheetIO packager;

	public IndividualSheetGUI() {
		initUI();
		packager = new SpecSheetIO();
	}

	private void initUI() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());

		JLabel sheetSectionTitle = new JLabel();
		sheetSectionTitle.setText("Sheet Section: ");
		JTextField sheetSection = new JTextField();
		sheetSection.setColumns(12);

		JLabel sheetNameTitle = new JLabel();
		sheetNameTitle.setText("Sheet Name: ");
		JTextField sheetName = new JTextField();
		sheetName.setColumns(12);

		JLabel ColumnNameTitle = new JLabel();
		ColumnNameTitle.setText("Column Title: ");
		JTextField columnName = new JTextField();
		columnName.setColumns(12);

		JLabel worksheetTitle = new JLabel();
		worksheetTitle.setText("Worksheet: ");
		JTextField worksheet = new JTextField();
		worksheet.setColumns(12);

		JLabel rowTitle = new JLabel();
		rowTitle.setText("Row: ");
		JTextField row = new JTextField();
		row.setColumns(12);

		JLabel columnTitle = new JLabel();
		columnTitle.setText("Column: ");
		JTextField column = new JTextField();
		column.setColumns(12);
		
		JLabel isChainedLabel = new JLabel();
		isChainedLabel.setText("Does this column have sub-rows?");
		JCheckBox isChained = new JCheckBox();

		JComboBox<String> rowRecordBox = new JComboBox<String>();
		JButton initRowRecord = new JButton("Load Row Record");
		initRowRecord.setToolTipText("Load a row Record from Active Spec Sheet");
		initRowRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				RowRecord record = currentSheet.getRecord((String) rowRecordBox.getSelectedItem());
				columnName.setText(record.getHeader());
				worksheet.setText(record.getWorksheet());
				row.setText(record.getRow());
				column.setText(record.getCol());
				isChained.setSelected(record.isChained());
			}
		});

		JButton deleteRowRecord = new JButton("Delete Row Record");
		deleteRowRecord.setToolTipText("Delete a row Record from Active Spec Sheet");
		deleteRowRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (currentSheet != null) {
					currentSheet.removeRecord((String) rowRecordBox.getSelectedItem());
					columnName.setText("");
					worksheet.setText("");
					row.setText("");
					column.setText("");
					isChained.setSelected(false);
					rowRecordBox.removeItem((String) rowRecordBox.getSelectedItem());
					packager.save(currentSheet, currentSheet.getSheetSection() + "." + currentSheet.getSheetName());
				}
			}
		});

		JButton saveRowRecord = new JButton("Save Row Record");
		saveRowRecord.setToolTipText("Save a row Record from Active Spec Sheet");
		saveRowRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SpecSheet sheet = new SpecSheet(sheetSection.getText(), sheetName.getText());
				RowRecord record = null;
				if(isChained.isSelected())
				{
					record = new RowRecord(worksheet.getText(), row.getText(), column.getText(), columnName.getText(), true, "subrow");
				}
				else
				{
					record = new RowRecord(worksheet.getText(), row.getText(), column.getText(), columnName.getText());
				}
				if (currentSheet == null) {
					sheet.addRecord(record);
					currentSheet = sheet;
					packager.save(currentSheet, currentSheet.getSheetSection() + "." + currentSheet.getSheetName());
					rowRecordBox.removeAllItems();
					rowRecordBox.addItem(record.getHeader());
				} else if (currentSheet != null && currentSheet.getSheetName().toLowerCase().equals(sheetName.getText().toLowerCase())) {
					boolean nameFound = false;
					for (RowRecord rec : currentSheet.getRecords()) {
						if (columnName.getText().toLowerCase().equals(rec.getHeader().toLowerCase())) {
							nameFound = true;
							rec.replaceRowDefinition(row.getText());
							rec.replaceColDefinition(column.getText());
							rec.replaceWorksheetDefinition(worksheet.getText());
							currentSheet.replaceRecord(rec);
							System.out.println("Record saved with name match.");
							packager.save(currentSheet, currentSheet.getSheetSection() + "." + currentSheet.getSheetName());
						}
					}
					if (!nameFound) {
						currentSheet.addRecord(record);
						rowRecordBox.addItem(record.getHeader());
						packager.save(currentSheet, currentSheet.getSheetSection() + "." + currentSheet.getSheetName());
					} else {
						System.out.println("Column name exists already. Column was modified.");
					}
				}
			}
		});

		JPanel rowRecordSelector = new JPanel();
		rowRecordSelector.add(new JLabel("Select an existing column to modify:"));
		rowRecordSelector.add(rowRecordBox);
		rowRecordSelector.add(initRowRecord);
		rowRecordSelector.add(saveRowRecord);
		rowRecordSelector.add(deleteRowRecord);

		JButton createButton = new JButton("Create New Sheet");
		createButton.setToolTipText("Generates the new spec sheet and saves it in the \"sheets\" folder.");
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SpecSheetIO packager = new SpecSheetIO();
				SpecSheet sheet = new SpecSheet(sheetSection.getText(), sheetName.getText());
				RowRecord record = null;
				if(isChained.isSelected())
				{
					record = new RowRecord(worksheet.getText(), row.getText(), column.getText(), columnName.getText(), true, "subrow");
				}
				else
				{
					record = new RowRecord(worksheet.getText(), row.getText(), column.getText(), columnName.getText());
				}
				sheet.addRecord(record);
				currentSheet = sheet;
				packager.save(currentSheet, currentSheet.getSheetSection() + "." + currentSheet.getSheetName());
				rowRecordBox.removeAllItems();
				rowRecordBox.addItem(record.getHeader());
			}
		});
		JButton quitButton = new JButton("Quit");
		quitButton.setToolTipText("Exit the program");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		
		JButton resetButton = new JButton("Reset Fields");
		resetButton.setToolTipText("Reset all fields and start fresh.");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				sheetSection.setText("");
				sheetName.setText("");
				columnName.setText("");
				worksheet.setText("");
				row.setText("");
				column.setText("");
				isChained.setSelected(false);
				rowRecordBox.removeAllItems();
				currentSheet = null;
			}
		});

		JButton chooseInputSS = new JButton("Modify Existing Sheet");
		chooseInputSS.setToolTipText("Select a Spec Sheet to Load/Modify");
		chooseInputSS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser inFileChooser = new JFileChooser(System.getProperty("user.dir"));
				inFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res = inFileChooser.showOpenDialog(IndividualSheetGUI.this);

				if (res == JFileChooser.APPROVE_OPTION) {

					File file = inFileChooser.getSelectedFile();
					String ext = FilenameUtils.getExtension(file.getPath());
					if (ext.toLowerCase().equals("spec")) {
						currentSheet = packager.load(file.getName());
						sheetSection.setText(currentSheet.getSheetSection());
						sheetName.setText(currentSheet.getSheetName());
						columnName.setText("");
						worksheet.setText("");
						row.setText("");
						column.setText("");
						rowRecordBox.removeAllItems();
						for (RowRecord record : currentSheet.getRecords()) {
							rowRecordBox.addItem(record.getHeader());
						}
					} else {
						System.out.println("Incompatible File Type.");
					}
				}
			}
		});

		JPanel criteriaPanel = new JPanel(new GridLayout(7, 1));
		criteriaPanel.add(sheetSectionTitle);
		criteriaPanel.add(sheetSection);
		criteriaPanel.add(sheetNameTitle);
		criteriaPanel.add(sheetName);
		criteriaPanel.add(ColumnNameTitle);
		criteriaPanel.add(columnName);
		criteriaPanel.add(worksheetTitle);
		criteriaPanel.add(worksheet);
		criteriaPanel.add(rowTitle);
		criteriaPanel.add(row);
		criteriaPanel.add(columnTitle);
		criteriaPanel.add(column);
		criteriaPanel.add(isChainedLabel);
		criteriaPanel.add(isChained);

		JPanel subPanel = new JPanel();

		subPanel.add(createButton);
		subPanel.add(chooseInputSS);
		subPanel.add(resetButton);
		subPanel.add(quitButton);

		panel1.add(criteriaPanel);
		panel1.add(rowRecordSelector);
		panel1.add(subPanel);

		this.add(panel1);

		setTitle("HdsXpoS CSV to SQL Individual Sheet Generator (This program is for HDS employee use only)");
		setSize(850, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
