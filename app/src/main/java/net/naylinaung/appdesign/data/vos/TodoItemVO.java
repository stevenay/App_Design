package net.naylinaung.appdesign.data.vos;

/**
 * Created by NayLinAung on 9/21/2016.
 */
public class TodoItemVO {

    private int itemId;
    private String description;
    private boolean checked;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
