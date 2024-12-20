package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    private FilteredList<Media> filteredList;
    private ObservableList<Media> mediaList;



    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        Media md1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        this.cart.addMedia(md1);
        Media md2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        this.cart.addMedia(md2);
        Media md3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
        this.cart.addMedia(md3);
        tblMedia.setItems(this.cart.getItemsOrdered());

        this.mediaList = this.cart.getItemsOrdered();
        
        filteredList = new FilteredList<>(mediaList, p -> true);


        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    private void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredList.setPredicate(media -> true); // Show all items
            return;
        }
    
        // Get the selected filter criteria
        boolean filterById = radioBtnFilterId.isSelected();
    
        // Update the predicate based on the filter
        filteredList.setPredicate(media -> {
            if (filterById) {
                return this.cart.checkID(Integer.parseInt(filter)); // Filter by ID
            } else {
                return this.cart.checkTitle(filter); // Filter by Title
            }
        });
    }
    
}