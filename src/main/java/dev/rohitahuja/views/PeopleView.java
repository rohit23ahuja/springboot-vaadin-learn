//package dev.rohitahuja.views;
//
//import com.example.application.services.PersonService;
//import com.vaadin.flow.component.dependency.Uses;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.messages.MessageInput;
//import com.vaadin.flow.component.orderedlayout.Scroller;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Menu;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import org.springframework.ai.chat.client.ChatClient;
//import org.vaadin.firitin.components.messagelist.MarkdownMessage;
//import org.vaadin.lineawesome.LineAwesomeIconUrl;
//
//@PageTitle("People")
//@Menu(order = 0, icon = LineAwesomeIconUrl.ROBOT_SOLID)
//@Route("")
//@Uses(Icon.class)
//public class PeopleView extends VerticalLayout {
//
//    public PeopleView(
//        PersonService personService,
//        ChatClient.Builder builder) {
//        var chatClient = builder
//            .defaultTools(personService)
//            .build();
//
//        var messageList = new VerticalLayout();
//        var scroller = new Scroller(messageList);
//        var messageInput = new MessageInput();
//        messageInput.setWidthFull();
//        scroller.setWidthFull();
//        messageList.setWidthFull();
//
//        messageInput.addSubmitListener(event -> {
//            var userMessage = event.getValue();
//            messageList.add(new MarkdownMessage(userMessage, "You"));
//            var assistantMessage = new MarkdownMessage("", "Assistant");
//            messageList.add(assistantMessage);
//            chatClient.prompt()
//                .user(event.getValue())
//                .stream()
//                .content()
//                .subscribe(assistantMessage::appendMarkdownAsync);
//        });
//
//        addAndExpand(scroller);
//        add(messageInput);
//    }
//
//
//
//}
