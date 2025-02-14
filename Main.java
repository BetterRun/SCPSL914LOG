/**
 * Main class for the upgrade pathfinder application.
 * Handles user input to determine possible upgrades and item refinement paths.
 */
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
                Item selectedItem = null;
                String userInput = new String("");

                // Get a valid item from the user.
                while (selectedItem == null) {
                    System.out.println("Enter the item name or ID:");
                    userInput = scanner.nextLine();    
                    
                    Item[] items = Item.getAllItems();
                    for (Item item : items) {
                        if (item.getName().equalsIgnoreCase(userInput) || String.valueOf(item.getId()).equals(userInput)) {
                            selectedItem = item;
                            break;
                        }
                    }
                    if(selectedItem == null)
                    {
                        System.out.println("Invalid item. Please try again.");
                    }
                }

                System.out.println("You selected the item: " + selectedItem.getName() + " (ID: " + selectedItem.getId() + ")");

                // Get a valid refinement setting.
                RefineSetting selectedSetting = null;
                
                while (selectedSetting == null) {
                    System.out.println("Enter the setting:");
                    userInput = scanner.nextLine();    
                    
                    RefineSetting[] settings = RefineSetting.getSettings();
                    for (RefineSetting setting: settings) {
                        if (setting.getName().equalsIgnoreCase(userInput)) {
                            selectedSetting = setting;
                            break;
                        }
                    }
                    if(selectedSetting == null)
                    {
                        System.out.println("Invalid setting. Please try again.");
                    }
                }
                
                System.out.println("You selected the setting: " + selectedSetting + "\n");
                
                if (!(OutputMap.getOutputItems(Output.getFormula(selectedItem, selectedSetting)) == null)) {
                    System.out.println(OutputMap.getOutputItems(Output.getFormula(selectedItem, selectedSetting)));
                } else {
                    System.out.println("Input: " + selectedItem.getName() + " (setting: " + selectedSetting + ")\nOutput: Unknown\n");
                }

                // Display refinement results
                String prompt = new String("");
                System.out.println("Continue? (Y/N)");
                prompt = scanner.nextLine();
                System.out.println();

                // Prompt for continuation
                if (!prompt.equalsIgnoreCase("Y")) {
                    break;        
                }    
        }
    }
}