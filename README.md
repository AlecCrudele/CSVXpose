# CSVXpose
CSV transposer designed for Big-Data CSV files from Central Medicare Services
Java-driven application designed to work with CSV and Excel files containing larger than 1,048,576 rows (Excel physical limit) 

XPosGUI - Run to view in-progress GUI
HDSXPos - CSV transposer called by XPosGUI

Rest of files are various classes required to handle individual fields and data groupings.

Run SpecSheetMapper.java to create spec sheets for generating transposed CSV files. (These are accepted by the GUI before running HDSXPos.java)

Make sure that the 'sql' and 'sheets' folders exist before running the program. 