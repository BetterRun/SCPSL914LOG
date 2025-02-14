/**
 * A JavaFX-based GUI for refining items in the game.
 * Allows users to select an item, choose a setting, and see potential refinement outcomes.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class MainGUI extends Application {

    // Declare components as class-level fields
    private ListView<Item> itemListView;
    private ComboBox<String> settingDropdown;
    private Label outputLabel;
    private Label newInputLabel;
    private Button refineButton;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Layout
            VBox layout = new VBox(10);
            layout.setStyle("-fx-background-color: #1C1C1C; -fx-text-fill: #D6B295;");

            // Initialize Components (already declared above)

            // Item ListView
            Label itemLabel = new Label("Select Item:");
            itemLabel.setStyle("-fx-text-fill: #D6B295;");
            itemListView = new ListView<>(); // Initialize the ListView
            itemListView.getItems().addAll(Item.getAllItems());
            itemListView.setStyle("-fx-background-color: #1C1C1C; -fx-control-inner-background: #CCCCCC; -fx-text-fill: #D6B295;");
            itemListView.setCellFactory(param -> new ListCell<>() {
                private final ImageView imageView = new ImageView();

                @Override
                protected void updateItem(Item item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        imageView.setImage(item.getImage());
                        setGraphic(imageView);
                        setText(item.toString());
                    }
                }
            });

            // Setting Dropdown
            Label settingLabel = new Label("Select Setting:");
            settingLabel.setStyle("-fx-text-fill: #D6B295;");
            settingDropdown = new ComboBox<>(); // Initialize the ComboBox
            for (RefineSetting setting : RefineSetting.getSettings()) {
                settingDropdown.getItems().add(setting.getName());
            }

            // Buttons
            refineButton = new Button("Refine"); // Initialize the Button

            // Labels
            newInputLabel = new Label(""); // Initialize labels
            newInputLabel.setStyle("-fx-text-fill: #D6B295;");
            newInputLabel.setWrapText(true);

            outputLabel = new Label("Output will be displayed here.");
            outputLabel.setStyle("-fx-text-fill: #D6B295;");
            outputLabel.setWrapText(true);

            // Add "Refine Search?" label and CheckBox
            Label refineSearchLabel = new Label("Continuous Refinement Search?");
            refineSearchLabel.setStyle("-fx-text-fill: #D6B295;");
            refineSearchLabel.setWrapText(true);

            CheckBox refineSearchCheckBox = new CheckBox();

            // Dropdown that will show when CheckBox is ticked
            ComboBox<Item> refineDropdown = new ComboBox<>();
            //refineDropdown.setStyle("-fx-background-color: #CCCCCC; -fx-control-inner-background: #CCCCCC; -fx-text-fill: #D6B295;");
            refineDropdown.setVisible(false); // Initially hidden

            Label promptOutputLabel = new Label("Select target item to refine to. (Press 'Refine' to see results.)");
            promptOutputLabel.setStyle("-fx-text-fill: #D6B295;");
            promptOutputLabel.setVisible(false);
            promptOutputLabel.setWrapText(true);

            Label searchCountLabel = new Label("Here is a count of refinements to the target item.");
            searchCountLabel.setStyle("-fx-text-fill: #D6B295;");
            searchCountLabel.setVisible(false);
            searchCountLabel.setWrapText(true);


            // Populate the dropdown with items (same as itemListView)
            refineDropdown.getItems().addAll(Item.getAllItems());

            // Show/Hide dropdown based on CheckBox state
            refineSearchCheckBox.setOnAction(e -> {
                boolean isChecked = refineSearchCheckBox.isSelected();
                refineDropdown.setVisible(isChecked); // Show the dropdown if checked
                searchCountLabel.setVisible(isChecked);
                promptOutputLabel.setVisible(isChecked);
            });

            // Event Handling for item and setting selection
            itemListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                    updateOutputLabel(itemListView, settingDropdown, outputLabel)
            );
            settingDropdown.setOnAction(e -> updateOutputLabel(itemListView, settingDropdown, outputLabel));

            // Event Handling for the refine button
            refineButton.setOnAction(e -> {
                if (refineSearchCheckBox.isSelected() && refineDropdown.getSelectionModel().getSelectedItem() != null) {
                    // CheckBox is checked: repeat handleRefineEvent
                    int refinementCount = 0;
                    // List to store the order of items that became the current item during the search
                    List<Object> selectedItemOrder = new ArrayList<>();
                    Object firstItem = itemListView.getSelectionModel().getSelectedItem();
                    //Repeat until target reached.
                    while (!refineDropdown.getSelectionModel().getSelectedItem().equals(itemListView.getSelectionModel().getSelectedItem())) {
                        refinementCount++;
                        handleRefineEvent();
                        // Get the currently selected item in the itemListView
                        Object currentItem = itemListView.getSelectionModel().getSelectedItem();
                        // Add the current item to the tracking list
                        selectedItemOrder.add(currentItem);
                        //Check if the selected item was destroyed or removed
                        if (currentItem == null || !itemListView.getItems().contains(currentItem)) {
                            searchCountLabel.setText("Item destroyed or removed during search after " + refinementCount + " refinements.\nItems traversed: " + selectedItemOrder);
                            break;
                        }
                        //Stop after too many refinements
                        if (refinementCount > 1000) { // Arbitrary large number
                            searchCountLabel.setText("Could not reach target item.");
                            break;
                        }
                        searchCountLabel.setText("Refinements to Target: " + refinementCount + "\nItems traversed: " + selectedItemOrder);
                    }

                } else {
                    // CheckBox is not checked: handle the event once
                    handleRefineEvent();
                }
            });

            // Add UI elements to layout
            layout.getChildren().addAll(itemLabel, itemListView, settingLabel, settingDropdown, refineButton, newInputLabel, outputLabel, refineSearchLabel, refineSearchCheckBox, promptOutputLabel, refineDropdown, searchCountLabel);

            // Set up the scene
            Scene scene = new Scene(layout, 400, 800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("SCP-914 Refinement Simulator");
            primaryStage.setMaximized(true);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Event handler for the Refine button.
     */
    private void handleRefineEvent() {
        Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
        String selectedSetting = settingDropdown.getValue();

        if (selectedItem != null && selectedSetting != null) {
            RefineSetting setting = RefineSetting.getSetting(selectedSetting);
            Output output = OutputMap.getOutputItems(Output.getFormula(selectedItem, setting));

            // Randomly select an output item based on probabilities
            Item newInput = getRandomOutputItem(output);
            if (newInput != null) {
                // Handle specific output conditions
                handleOutputLogic(newInput, selectedItem);
            }
        } else {
            outputLabel.setText("Please select an item and setting.");
        }
    }

    /**
     * Handles logic for various outputs after refinement.
     */
    private void handleOutputLogic(Item newInput, Item selectedItem) {
        if (newInput.getId() == OutputItem.DESTROYED.getId() || newInput.getId() == OutputItem.SCP_2176_ACTIVATION.getId()) {
            newInputLabel.setText("You now have no item." + " (" + newInput.getName() + ")");
            itemListView.getSelectionModel().select(newInput);
        } else if (newInput.getId() == OutputItem.CANNOT_BE_REFINED.getId()) {
            newInputLabel.setText(newInput.getName());
            itemListView.getSelectionModel().select(selectedItem);
        } else if (newInput.getId() == OutputItem.RANDOMATTACHMENTS.getId()) {
            newInputLabel.setText("You now have a " + selectedItem + " with random attachments.");
            itemListView.getSelectionModel().select(selectedItem);
        } else if (newInput instanceof OutputItem && !(newInput instanceof OutputGroup)) {
            if ((newInput instanceof AmmoItem && ((AmmoItem) newInput).getRoundsInt() > 15)
                    || !(newInput instanceof AmmoItem)) {
                Item correspondingInput = findMatchingItemById(newInput.getId(), Item.getAllItems());
                newInputLabel.setText("You now have a " + newInput.getName() + ".");
                itemListView.getSelectionModel().select(correspondingInput);
            } else {
                newInputLabel.setText("You now have a " + newInput.getName() + ".");
            }
        } else if (newInput instanceof OutputGroup) {
            String groupOutput = handleOutputGroup((OutputGroup) newInput);
            newInputLabel.setText(groupOutput);
        } else {
            newInputLabel.setText("You now have a " + newInput.getName() + ".");
            itemListView.getSelectionModel().select(newInput);
        }
    }

    /**
     * Handles output for grouped items.
     */
    private String handleOutputGroup(OutputGroup outputGroup) {
        StringBuilder groupOutput = new StringBuilder("You now have a ");
        for (OutputItem outputItem : outputGroup.getGroupedItems()) {
            if (outputItem.getRounds() > 0) {
                groupOutput.append(outputItem.getName()).append(" (").append(outputItem.getRounds()).append(" rounds)");
            } else {
                groupOutput.append(outputItem.getName());
            }
            if (outputGroup.getGroupedItems().indexOf(outputItem) != outputGroup.getGroupedItems().size() - 1) {
                groupOutput.append(", ");
            }
        }
        return groupOutput.toString();
    }

    // Method to update the output label based on current selection
    private void updateOutputLabel(ListView<Item>  itemListView, ComboBox<String> settingDropdown, Label outputLabel) {
        Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
        String selectedSetting = settingDropdown.getValue();

        if (selectedItem != null && selectedSetting != null) {
            RefineSetting setting = RefineSetting.getSetting(selectedSetting);
            Output output = OutputMap.getOutputItems(Output.getFormula(selectedItem, setting));

            if (output != null) {
                outputLabel.setText(output.toString());
            } else {
                outputLabel.setText("Please select a new item and setting");
            }
        } else {
            outputLabel.setText("Please select an item and setting.");
        }
    }
    
    private Item getRandomOutputItem(Output output) {
        List<OutputItem> possibleOutputs = output.getPossibleOutputs();
    
        // Calculate cumulative probabilities
        double totalChance = 0;
        for (OutputItem outputItem : possibleOutputs) {
            totalChance += outputItem.getChance();
        }
    
        // Generate a random number in the range [0, totalChance)
        double random = Math.random() * totalChance;
    
        // Iterate through the outputs to find the selected one
        double cumulativeProbability = 0;
        for (OutputItem outputItem : possibleOutputs) {
            cumulativeProbability += outputItem.getChance();
            if (random <= cumulativeProbability) {
                return outputItem; // Return the selected item
            }
        }
    
        // Default case (shouldn't be reached if probabilities are correct)
        return null;
    }
    
    private Item findMatchingItemById(int id, Item[] items) {
    for (Item item : items) {
        // Check if the item's ID matches and it's not an instance of OutputItem
        if (item.getId() == id /*&& !(item instanceof OutputItem)*/) {
            return item; // Return the matching Item
        }
    }
    return null; // Return null if no match is found
}
    
    public static void main(String[] args) {
        launch(args);
    }
}