public class Mesa{
    int tableId;
    int tableXcords;
    int tableYcords;
    boolean tableStatus;
    public void InventoryObject(int tableYcords, int tableXcords, int tableId, boolean tableStatus) {
        this.tableId = tableId;
        this.tableXcords = tableXcords;
        this.tableYcords = tableYcords;
        this.tableStatus = tableStatus;
    }

    public int getTableId() {
        return tableId;
    }
    public int getTableXcords() {
        return tableXcords;
    }
    public int getTableYcords() {
        return tableYcords;
    }
    public boolean getTableStatus() {
        return tableStatus;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public void setTableXcords(int tableXcords) {
        this.tableXcords = tableXcords;
    }
    public void setTableYcords(int tableYcords) {
        this.tableYcords = tableYcords;
    }
    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}
