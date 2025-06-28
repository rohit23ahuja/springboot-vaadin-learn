package dev.rohitahuja.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {
    public MainView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();

        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
            taskField.setValue("");
        });
        addButton.addClickShortcut(Key.ENTER);
        add(new H1("Vaadin Todo"), todosList, new HorizontalLayout(taskField, addButton));
    }

}
