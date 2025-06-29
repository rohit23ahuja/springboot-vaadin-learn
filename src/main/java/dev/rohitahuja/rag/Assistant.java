package dev.rohitahuja.rag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class Assistant {

    private static Logger _log = LoggerFactory.getLogger(Assistant.class);


    private static final String DEFAULT_SYSTEM =
            """
                    You are a helpful and friendly AI assistant who can answer questions about Indian Premier Leage (IPL).
                    """;

    private final ChatClient chatClient;

    public Assistant(ChatClient.Builder builder, VectorStore vectorStore) {

        this.chatClient = builder
                .defaultAdvisors(RetrievalAugmentationAdvisor.builder()
                        .documentRetriever(
                                VectorStoreDocumentRetriever.builder()
                                        .similarityThreshold(0.50)
                                        .vectorStore(vectorStore)
                                        .build())
                        .build())
                .build()

        ;
    }

    public Flux<String> chat(String userMessage) {

        return chatClient
                .prompt()
                .system(DEFAULT_SYSTEM)
                .user(userMessage)
                .stream()
                .content();
    }
}
