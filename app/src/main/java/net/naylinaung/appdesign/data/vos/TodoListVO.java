package net.naylinaung.appdesign.data.vos;

import java.util.List;

/**
 * Created by NayLinAung on 9/21/2016.
 */
public class TodoListVO {

    private int toDoListId;
    private String title;
    private List<TodoItemVO> todoItems;

    public int getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(int toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TodoItemVO> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItemVO> todoItems) {
        this.todoItems = todoItems;
    }
}
