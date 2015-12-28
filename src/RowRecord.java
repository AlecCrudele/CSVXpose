import java.io.Serializable;

public class RowRecord implements Serializable {
	private String row;
	private String column;
	private String value;
	private String repRecNum;
	private String worksheet;
	private String header;
	private boolean chained = false;
	private boolean isNumeric = true;
	private String chainAction;
	private int rowRangeUpper;
	private int rowRangeLower;
	private int mapIndex;
	private int[] totalIndexes;
	private static final long serialVersionUID = 6618469361098325812L;

	public RowRecord(String worksheet, String row, String column) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
	}

	public RowRecord(String worksheet, String row, String column, String header) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
		this.header = header;
	}

	public RowRecord(String worksheet, String row, String column, String header, boolean chained, String chainAction) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
		this.header = header;
		this.chained = chained;
		this.chainAction = chainAction;
		this.rowRangeLower = 1;
		this.rowRangeUpper = 99;
	}
	
	public RowRecord(String worksheet, String row, String column, String header, boolean chained, String chainAction, int[] totalIndexes) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
		this.header = header;
		this.chained = chained;
		this.chainAction = chainAction;
		this.rowRangeLower = 1;
		this.rowRangeUpper = 99;
		this.totalIndexes = totalIndexes;
	}
	
	//Subrow by default when no chain action specified
	public RowRecord(String worksheet, String row, String column, String header, boolean chained) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
		this.header = header;
		this.chained = chained;
		this.chainAction = "subrow";
		this.rowRangeLower = 1;
		this.rowRangeUpper = 99;
	}
	
	public RowRecord(boolean isNumeric, String worksheet, String row, String column, String header, boolean chained) {
		this.row = row;
		this.column = column;
		this.worksheet = worksheet;
		this.header = header;
		this.chained = chained;
		this.chainAction = "subrow";
		this.rowRangeLower = 1;
		this.rowRangeUpper = 99;
		if(isNumeric == false)
		{
			this.isNumeric = false;
		}
	}

	public RowRecord(String repRecNum, String worksheet, String row, String column, String value) {
		this.value = value;
		this.repRecNum = repRecNum;
		this.worksheet = worksheet;
		this.row = row;
		this.column = column;
	}

	public void replaceRowDefinition(String newRow) {
		this.row = newRow;
	}

	public void replaceColDefinition(String column) {
		this.column = column;
	}

	public void replaceWorksheetDefinition(String worksheet) {
		this.worksheet = worksheet;
	}

	public boolean isChained() {
		return chained;
	}

	public String getChainOperation() {
		return chainAction;
	}

	public int getRangeLower() {
		return rowRangeLower;
	}

	public int getRangeUpper() {
		return rowRangeUpper;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getCol() {
		return column;
	}

	public String getRepRecNum() {
		return repRecNum;
	}

	public String getValue() {
		return value;
	}

	public String getWorksheet() {
		return worksheet;
	}

	public String getHeader() {
		return header;
	}
	
	public int getMapIndex()
	{
		return mapIndex;
	}
	
	public void setMapIndex(int index)
	{
		this.mapIndex = index;
	}
	
	public boolean isNumeric()
	{
		return this.isNumeric;
	}
	
	public int[] getTotalIndices()
	{
		return totalIndexes;
	}

	public int hashCode() {
		if (header == null) {
			return (this.worksheet + this.row + this.column).hashCode();
		} else {
			return (this.header + this.worksheet + this.row + this.column).hashCode();
		}
	}

	public boolean equals(RowRecord rr) {
		if (!(rr instanceof RowRecord)) {
			return false;
		}
		if (this.header == null || rr.getHeader() == null) {
			if (this.worksheet.equals(rr.worksheet) && this.row.equals(rr.row) && this.column.equals(rr.column)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (this.header.equals(rr.getHeader()) && this.worksheet.equals(rr.worksheet) && this.row.equals(rr.row) && this.column.equals(rr.column)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
