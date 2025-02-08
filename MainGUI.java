import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
            try {
                // Layout
                VBox layout = new VBox(10);
                layout.setStyle("-fx-background-color: #1C1C1C; -fx-text-fill: #D6B295;");
                
                // Components
                Label itemLabel = new Label("Select Item:");
                itemLabel.setStyle("-fx-text-fill: #D6B295;");
                ListView<Item> itemListView = new ListView<>(); // Scrollable list of items
                //itemListView.setPrefHeight(200); // Set preferred height for the scrollable area
                itemListView.getItems().addAll(Item.getAllItems());
                itemListView.setStyle("-fx-background-color: #1C1C1C; -fx-control-inner-background: #CCCCCC; -fx-text-fill: #D6B295;");
                
                // Custom cell factory to display images and text
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
                
                
                Label settingLabel = new Label("Select Setting:");
                settingLabel.setStyle("-fx-text-fill: #D6B295;");
                
                ComboBox<String> settingDropdown = new ComboBox<>();
                for (RefineSetting setting : RefineSetting.getSettings()) {
                    settingDropdown.getItems().add(setting.getName());
                }
        
                Button refineButton = new Button("Refine");
                
                Label newInputLabel = new Label("");
                newInputLabel.setStyle("-fx-text-fill: #D6B295;");
                
                Label outputLabel = new Label("Output will be displayed here.");
                outputLabel.setStyle("-fx-text-fill: #D6B295;");
                
                // Event Handling for item and setting selection
                itemListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
                    updateOutputLabel(itemListView, settingDropdown, outputLabel)
                );
                settingDropdown.setOnAction(e -> updateOutputLabel(itemListView, settingDropdown, outputLabel));
                
                // Event Handling for the refine button
                refineButton.setOnAction(e -> {
                    Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
                    String selectedSetting = settingDropdown.getValue();
                    
                    if (selectedItem != null && selectedSetting != null) {
                        RefineSetting setting = RefineSetting.getSetting(selectedSetting);
                        Output output = OutputMap.getOutputItems(Output.getFormula(selectedItem, setting));
                        
                        // Randomly select an output item based on probabilities
                        Item newInput = getRandomOutputItem(output);
                            if (newInput != null) {
                                //itemListView.scrollTo(newInput);
                                //Output item exceptions
                                if (newInput.getId() == OutputItem.DESTROYED.getId() || newInput.getId() == OutputItem.SCP_2176_ACTIVATION.getId()) {
                                    newInputLabel.setText("You now have no item." +  " (" + newInput.getName() + ")");
                                    itemListView.getSelectionModel().select(newInput);
                                } else if (newInput.getId() == OutputItem.CANNOT_BE_REFINED.getId()) {
                                    newInputLabel.setText(newInput.getName());
                                    itemListView.getSelectionModel().select(selectedItem);        
                                } else if (newInput.getId() == OutputItem.RANDOMATTACHMENTS.getId()) {
                                    newInputLabel.setText("You now have a " + selectedItem + " with random attachments.");
                                    itemListView.getSelectionModel().select(newInput);    
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
                                    String groupOutput = "You now have a ";
                                    for (OutputItem outputItem : ((OutputGroup) newInput).getGroupedItems()) {
                                        if (!(outputItem.getRounds() == 0)) {
                                            // Cast the outputItem to AmmoItem to access AmmoItem-specific properties.
                                            groupOutput += outputItem.getName() + " (" + outputItem.getRounds() + " rounds)";       
                                        } else {
                                            groupOutput += (outputItem.getName());
                                        }
                                        if (!(((OutputGroup) newInput).getGroupedItems().indexOf(outputItem) == 
                                        ((OutputGroup) newInput).getGroupedItems().size() - 2) && !(((OutputGroup) newInput).getGroupedItems().indexOf(outputItem) == 
                                        ((OutputGroup) newInput).getGroupedItems().size() - 1)) {
                                            groupOutput += ", ";
                                        } 
                                        if ((((OutputGroup) newInput).getGroupedItems().indexOf(outputItem) ==
                                        ((OutputGroup) newInput).getGroupedItems().size() - 2)) {
                                            groupOutput += " and a ";
                                        }
                                    }
                                    groupOutput += ".";
                                    newInputLabel.setText(groupOutput);
                                    
                                } else {
                                    newInputLabel.setText("You now have a " + newInput.getName() + ".");
                                    itemListView.getSelectionModel().select(newInput);
                                }
                        }
                    } else {
                        outputLabel.setText("Please select an item and setting.");
                    }
                });        
                
        
                // Add components to layout
                layout.getChildren().addAll(itemLabel, itemListView, settingLabel, settingDropdown, refineButton, newInputLabel, outputLabel);
        
                // Set up the scene
                Scene scene = new Scene(layout, 400, 400);
                primaryStage.setScene(scene);
                primaryStage.setTitle("SCP-914 Refinement Simulator");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
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