package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String userName;
    private String passWord;

    @FXML private TextField user;
    @FXML private TextField pass;
    @FXML private Label userInfo;
    @FXML private Label passInfo;

    @FXML
    private void login(ActionEvent event) {
        setUserName(user.getText());
        setPassWord(pass.getText());

        if(CheckUser()){
            userInfo.setText("valid username");
        }
        else{
            userInfo.setText("not a valid username");
        }

        if(CheckPass()){
            passInfo.setText("valid password");
        }
        else{
            passInfo.setText("not a valid password");
        }

    }

    public boolean CheckUser() {

        String pat = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c" +
                "\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]" +
                "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c" +
                "\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        Pattern pattern = Pattern.compile(pat);

        Matcher m = pattern.matcher(getUserName());

        if(m.find()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean CheckPass() {

        String pat = "(?=^.{7,}$)((?=.*\\w)(?=(.*[A-Z]){2,})(?=(.*[a-z]){2,})(?=(.*[0-9]){2,})(?=.*[|!\"$%&\\/\\(\\)\\?\\^\\'\\\\\\+\\-\\*]))^.*";

        Pattern pattern = Pattern.compile(pat);

        Matcher m = pattern.matcher(getPassWord());

        if(m.find()){
            return true;
        }
        else {
            return false;
        }
    }


    @FXML
    private void printHelloWorld(ActionEvent event) {

        event.consume();
        System.out.println(user.getText()+", "+pass.getText());
    }
}
