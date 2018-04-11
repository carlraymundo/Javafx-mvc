package sample;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.PostService;
import model.User;
import model.UserService;

public class Controller {

    @FXML
    private VBox postList;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button login;

    @FXML
    private TextArea postMessage;

    @FXML
    private Button postButton;

    /* Models */
    private UserService userService = new UserService();
    private PostService postService = new PostService();
    private User loggedIn = null;

    @FXML
    void initialize() {

        login.setOnAction(event -> {
            if(username.getText().trim().equals("") || password.getText().trim().equals(""))

                System.err.println("ERROR");
            else
            {
                User u = new User();
                u.setId(userService.get().size()+1);
                u.setUsername(username.getText());
                u.setPassword(password.getText());
                userService.add(u);
                userService.displayUsers();

                postList.getChildren().add(new Label(LocalDateTime.now().toString() + " " + u.getUsername() + " has been added"));
            }
        });

    }
}
