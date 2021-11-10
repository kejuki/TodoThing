
public class Item {
	private boolean itemState;
	private String item;

	public Item(String item, boolean itemState) {
		this.setItem(item);
		this.setItemState(itemState);
	}

	public boolean isItemState() {
		return itemState;
	}

	public void setItemState(boolean itemState) {
		this.itemState = itemState;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
