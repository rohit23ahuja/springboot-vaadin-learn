package dev.rohitahuja.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.server.streams.UploadHandler;
import dev.rohitahuja.upload.CustomMultipartFile;
import dev.rohitahuja.upload.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@PageTitle("Ingestion")
@Route(value = "ingestion", layout = MainLayout.class)
public class IngestionView extends Div {

    private final FileUploadService fileUploadService;

    public IngestionView(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;

        addClassName("ingestion-view");
        setWidthFull();

        H3 title = new H3("File Upload");
        add(title);

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFiles(10);
        upload.setMaxFileSize(10 * 1024 * 1024); // 10MB
        upload.setAcceptedFileTypes(".txt", ".pdf", ".md", ".doc", ".docx");

        Button uploadButton = new Button("Upload");
        uploadButton.addClickListener(event -> {
            if (buffer.getInputStream() != null) {
                try {
                    fileUploadService.addFileToContext(new CustomMultipartFile(buffer.getFileName(), null, buffer.getInputStream().readAllBytes()));
                    Notification.show("File uploaded successfully: " + buffer.getFileName());
                } catch (Exception e) {
                    Notification.show("File upload failed: " + e.getMessage());
                }
            } else {
                Notification.show("No file selected.");
            }
        });

        HorizontalLayout layout = new HorizontalLayout(upload, uploadButton);
        add(layout);
    }

}
