package dev.rohitahuja.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.firitin.components.messagelist.MarkdownMessage;

import java.util.UUID;

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
        newChatButton.addClickListener(e -> {
            messageList.removeAll();
            focusMessageInput();
        });

        messageInput.setWidthFull();
        messageInput.addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM,
                LumoUtility.Margin.Horizontal.AUTO, LumoUtility.MaxWidth.SCREEN_MEDIUM);
        messageInput.addSubmitListener(e -> {
            var questionText = e.getValue();
            var question = new MarkdownMessage(questionText, "You");
            question.addClassName("you");
            var answer = new MarkdownMessage("Assistant");
            answer.getElement().executeJs("this.scrollIntoView()");

            messageList.add(question);
            messageList.add(answer);
//            aiAssistant.chat(chatId, questionText)
//                    .onNext(answer::appendMarkdownAsync)
//                    .onError(err -> System.err.println("ooops" + e))
//                    .start();
                });



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
