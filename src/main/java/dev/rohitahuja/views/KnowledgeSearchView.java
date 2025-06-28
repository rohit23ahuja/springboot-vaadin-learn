package dev.rohitahuja.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Knowledge Search")
@Route(value = "search", layout = MainLayout.class)
public class KnowledgeSearchView extends VerticalLayout {

    private MessageInput messageInput = new MessageInput();

    public KnowledgeSearchView() {
        var newChatButton = new Button("New Chat");
        var messageList = new VerticalLayout();
        focusMessageInput();

        setPadding(false);
        setSpacing(false);
        messageList.setSpacing(true);
        messageList.addClassNames(LumoUtility.Padding.Horizontal.SMALL, LumoUtility.Margin.Horizontal.AUTO,
                LumoUtility.MaxWidth.SCREEN_MEDIUM);

        newChatButton.addClassName("new-chat-button");
// Add click listener

        messageInput.setWidthFull();
        messageInput.addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM,
                LumoUtility.Margin.Horizontal.AUTO, LumoUtility.MaxWidth.SCREEN_MEDIUM);
        // add submit listener

        add(newChatButton);
        var scroller = new Scroller(messageList);
        scroller.setWidthFull();
        scroller.addClassName(LumoUtility.AlignContent.END);
        addAndExpand(scroller);
        add(messageInput);

    }

    private void focusMessageInput() {
        messageInput.getElement().executeJs("requestAnimationFrame(() => this.querySelector('vaadin-text-area').focus() )");
    }
}
