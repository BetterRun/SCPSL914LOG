/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
        
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        //yuh, yuh, keep it goin'
        while (true) {
                // Retrieve the item based on the user's input
                Item selectedItem = null;
                String userInput = new String("");
            
                // Prompt user to input an item by name or ID
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
                
                // Display the selected item
                System.out.println("You selected the item: " + selectedItem.getName() + " (ID: " + selectedItem.getId() + ")");
                
                // Retrieve the item based on the user's input
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
                String prompt = new String("");
                System.out.println("Continue? (Y/N)");
                prompt = scanner.nextLine();
                System.out.println();
                
                if (!prompt.equalsIgnoreCase("Y")) {
                    break;        
                }    
        }
    }
}