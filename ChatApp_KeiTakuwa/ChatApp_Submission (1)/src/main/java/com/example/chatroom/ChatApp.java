package com.example.chatroom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatApp extends Application {

    private TextArea chatArea;
    private TextField usernameField;
    private TextField hostField;
    private TextField portField;
    private TextField messageField;
    private Label statusLabel;
    private Label audioStatusLabel;
    private Button connectButton;
    private Button disconnectButton;
    private Button sendButton;
    private Button playButton;

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private volatile boolean connected = false;

    private Clip clip;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        root.setTop(createTopArea());
        root.setCenter(createChatArea());

        VBox bottomWrapper = new VBox(10, createAudioArea(), createBottomArea());
        root.setBottom(bottomWrapper);

        Scene scene = new Scene(root, 650, 450);

        stage.setTitle("Chat Room");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            disconnectFromServer();
            if (clip != null) {
                clip.stop();
                clip.close();
            }
        });
        stage.show();

        chatArea.appendText("System: Welcome to the chat room.\n");
    }

    private VBox createTopArea() {
        Label titleLabel = new Label("Simple Chat Room");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        Label hostLabel = new Label("Host:");
        hostField = new TextField("localhost");
        hostField.setPrefWidth(100);

        Label portLabel = new Label("Port:");
        portField = new TextField("5000");
        portField.setPrefWidth(60);

        connectButton = new Button("Connect");
        disconnectButton = new Button("Disconnect");
        disconnectButton.setDisable(true);

        connectButton.setOnAction(e -> connectToServer());
        disconnectButton.setOnAction(e -> disconnectFromServer());

        statusLabel = new Label("Status: Disconnected");

        HBox connectionRow = new HBox(10, usernameLabel, usernameField, hostLabel, hostField,
                portLabel, portField, connectButton, disconnectButton);

        VBox topArea = new VBox(10, titleLabel, connectionRow, statusLabel);
        topArea.setPadding(new Insets(0, 0, 10, 0));

        return topArea;
    }

    private TextArea createChatArea() {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        chatArea.setPromptText("Chat messages will appear here...");
        return chatArea;
    }

    private HBox createAudioArea() {
        playButton = new Button("Play");
        Button stopButton = new Button("Stop");
        audioStatusLabel = new Label("Audio: Ready");

        playButton.setOnAction(e -> playAudio());
        stopButton.setOnAction(e -> stopAudio());

        return new HBox(10, playButton, stopButton, audioStatusLabel);
    }

    private HBox createBottomArea() {
        messageField = new TextField();
        messageField.setPromptText("Type your message here");
        messageField.setPrefWidth(350);

        sendButton = new Button("Send");
        sendButton.setDisable(true);
        Button clearButton = new Button("Clear Chat");

        sendButton.setOnAction(e -> sendMessage());
        messageField.setOnAction(e -> sendMessage());
        clearButton.setOnAction(e -> chatArea.clear());

        HBox bottomArea = new HBox(10, messageField, sendButton, clearButton);
        bottomArea.setPadding(new Insets(10, 0, 0, 0));

        return bottomArea;
    }

    private void connectToServer() {
        String host = hostField.getText().trim();
        String portText = portField.getText().trim();
        String username = usernameField.getText().trim();

        if (host.isEmpty()) {
            statusLabel.setText("Status: Empty hostname");
            return;
        }
        if (username.isEmpty()) {
            statusLabel.setText("Status: Empty username");
            return;
        }

        int port;
        try {
            port = Integer.parseInt(portText);
        } catch (NumberFormatException e) {
            statusLabel.setText("Status: Invalid port number");
            return;
        }

        Thread connectionThread = new Thread(() -> {
            try {
                socket = new Socket(host, port);
                output = new PrintWriter(socket.getOutputStream(), true);
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output.println("USERNAME|" + username);
                connected = true;

                Platform.runLater(() -> {
                    statusLabel.setText("Status: Connected to " + host + ":" + port);
                    usernameField.setDisable(true);
                    hostField.setDisable(true);
                    portField.setDisable(true);
                    connectButton.setDisable(true);
                    disconnectButton.setDisable(false);
                    sendButton.setDisable(false);
                });

                receiveMessages();
            } catch (IOException e) {
                Platform.runLater(() -> statusLabel.setText("Status: Unable to connect"));
            }
        });
        connectionThread.setDaemon(true);
        connectionThread.start();
    }

    private void receiveMessages() {
        try {
            String incomingMessage;
            while ((incomingMessage = input.readLine()) != null) {
                String message = incomingMessage;
                Platform.runLater(() -> chatArea.appendText(message + "\n"));
            }
        } catch (IOException e) {
            // connection closed
        }

        if (connected) {
            connected = false;
            Platform.runLater(() -> {
                statusLabel.setText("Status: Server disconnected");
                resetConnectionControls();
            });
        }
    }

    private void disconnectFromServer() {
        if (!connected) {
            return;
        }
        connected = false;

        if (output != null) {
            output.println("QUIT");
        }
        closeConnection();

        Platform.runLater(() -> {
            statusLabel.setText("Status: Disconnected");
            resetConnectionControls();
        });
    }

    private void closeConnection() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            // already closed
        }
        if (output != null) {
            output.close();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            // already closed
        }
    }

    private void resetConnectionControls() {
        usernameField.setDisable(false);
        hostField.setDisable(false);
        portField.setDisable(false);
        connectButton.setDisable(false);
        disconnectButton.setDisable(true);
        sendButton.setDisable(true);
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (message.isEmpty()) {
            return;
        }
        if (!connected || output == null) {
            statusLabel.setText("Status: Not connected");
            return;
        }
        output.println("MESSAGE|" + message);
        messageField.clear();
    }

    private void playAudio() {
        if (clip != null && clip.isRunning()) {
            return;
        }
        playButton.setDisable(true);

        Thread audioThread = new Thread(() -> {
            try {
                File audioFile = new File("music.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                if (clip != null) {
                    clip.close();
                }
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                Platform.runLater(() -> {
                    audioStatusLabel.setText("Audio: Playing");
                    playButton.setDisable(false);
                });
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                Platform.runLater(() -> {
                    audioStatusLabel.setText("Audio: Unable to open file");
                    playButton.setDisable(false);
                });
            }
        });
        audioThread.setDaemon(true);
        audioThread.start();
    }

    private void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            audioStatusLabel.setText("Audio: Stopped");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
