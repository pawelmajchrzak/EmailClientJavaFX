package com.test.controller;

import com.test.EmailManager;
import com.test.model.EmailMessage;
import com.test.model.EmailTreeItem;
import com.test.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private WebView emailWebView;

    @FXML
    private TableView<EmailMessage> emailsTableView;

    @FXML
    private TableColumn<EmailMessage, String> senderCol;

    @FXML
    private TableColumn<EmailMessage, Integer> sizeCol;

    @FXML
    private TableColumn<EmailMessage, String> subjectCol;

    @FXML
    private TableColumn<EmailMessage, String> RecipientCol;

    @FXML
    private TableColumn<EmailMessage, Date> dateCol;

    @FXML
    private TreeView<String> emailsTreeView;

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }

    @FXML
    void addAccoundAction() {
        viewFactory.showLoginWindow();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpEmailTreeView();
        setUpEmailsTableView();
        setUpFolderSelection();
    }

    private void setUpFolderSelection() {
        emailsTreeView.setOnMouseClicked(e->{
            EmailTreeItem<String> item = (EmailTreeItem<String>) emailsTreeView.getSelectionModel().getSelectedItem();
            if(item != null) {
                emailsTableView.setItems(item.getEmailMessages());
            }
        });
    }

    private void setUpEmailsTableView() {
        senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessage,String >("sender"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessage,String >("subject"));
        RecipientCol.setCellValueFactory(new PropertyValueFactory<EmailMessage,String >("recipient"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessage,Integer>("size"));
        dateCol.setCellValueFactory(new PropertyValueFactory<EmailMessage,Date>("date"));
    }


    private void setUpEmailTreeView() {
        emailsTreeView.setRoot(emailManager.getFoldersRoot());
        emailsTreeView.setShowRoot(false);
    }
}
