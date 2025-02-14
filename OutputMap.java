/**
 * Stores all possible refinement results in a map.
 * Each key is a combination of an item and a setting, and the value is the corresponding output.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputMap
{        
    private static Map<String, Output> outputMap;

    static {
        outputMap = new HashMap<>();
        
        //KeyCards
        //Janitor Keycard
        // Example: Defining some keycard refinement outcomes.
        Output Janitor1 = new Output(Item.KEYCARD_JANITOR, RefineSetting.ROUGH, List.of(OutputItem.DESTROYED));
        outputMap.put(Janitor1.getFormula(),Janitor1);
        //When the Janitor Keycard is refined on the setting Rough, it is destroyed in the output.
        
        Output Janitor2 = new Output(Item.KEYCARD_JANITOR, RefineSetting.COARSE, List.of(OutputItem.DESTROYED));
        outputMap.put(Janitor2.getFormula(),Janitor2);
        
        Output Janitor3 = new Output(Item.KEYCARD_JANITOR, RefineSetting.ONE_TO_ONE, 
        List.of(new OutputItem(Item.KEYCARD_ZONE_MANAGER, 1.0)));
        outputMap.put(Janitor3.getFormula(),Janitor3);
        
        Output Janitor4 = new Output(Item.KEYCARD_JANITOR, RefineSetting.FINE, List.of(new OutputItem(Item.KEYCARD_SCIENTIST, 1.0)));
        outputMap.put(Janitor4.getFormula(),Janitor4);
        
        Output Janitor5 = new Output(Item.KEYCARD_JANITOR, RefineSetting.VERY_FINE, List.of(new OutputItem(Item.KEYCARD_SCIENTIST, 0.5),
        new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 0.5)));
        outputMap.put(Janitor5.getFormula(),Janitor5);
        
        //Scientist Keycard
        Output Scientist1 = new Output(Item.KEYCARD_SCIENTIST, RefineSetting.ROUGH, List.of(new OutputItem(OutputItem.DESTROYED, 0.5),
        new OutputItem(Item.KEYCARD_JANITOR, 0.5)));
        outputMap.put(Scientist1.getFormula(), Scientist1);
        
        Output Scientist2 = new Output(Item.KEYCARD_SCIENTIST, RefineSetting.COARSE, 
        List.of(new OutputItem(Item.KEYCARD_JANITOR, 1.0)));
        outputMap.put(Scientist2.getFormula(), Scientist2);
        
        Output Scientist3 = new Output(Item.KEYCARD_SCIENTIST, RefineSetting.ONE_TO_ONE, 
        List.of(new OutputItem(Item.KEYCARD_ZONE_MANAGER, 1.0)));
        outputMap.put(Scientist3.getFormula(), Scientist3);
        
        Output Scientist4 = new Output(Item.KEYCARD_SCIENTIST, RefineSetting.FINE,
        List.of(new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 1.0)));
        outputMap.put(Scientist4.getFormula(), Scientist4);
        
        Output Scientist5 = new Output(Item.KEYCARD_SCIENTIST, RefineSetting.VERY_FINE, 
        List.of(new OutputItem(Item.KEYCARD_SCIENTIST, 0.33), new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 0.33),
        new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 0.33)));
        outputMap.put(Scientist5.getFormula(), Scientist5);
        
        //Research Supervisor Keycard
        Output ResearchSupervisor1 = new Output(Item.KEYCARD_RESEARCH_SUPERVISOR, RefineSetting.ROUGH, 
        List.of(new OutputItem(Item.KEYCARD_JANITOR, 0.5), new OutputItem(Item.KEYCARD_SCIENTIST, 0.5)));
        outputMap.put(ResearchSupervisor1.getFormula(),ResearchSupervisor1);
        
        Output ResearchSupervisor2 = new Output(Item.KEYCARD_RESEARCH_SUPERVISOR, RefineSetting.COARSE, 
        List.of(new OutputItem(Item.KEYCARD_SCIENTIST, 1.0)));
        outputMap.put(ResearchSupervisor2.getFormula(),ResearchSupervisor2);
        
        Output ResearchSupervisor3 = new Output(Item.KEYCARD_RESEARCH_SUPERVISOR, RefineSetting.ONE_TO_ONE, 
        List.of(new OutputItem(Item.KEYCARD_GUARD, 1.0)));
        outputMap.put(ResearchSupervisor3.getFormula(),ResearchSupervisor3);
        
        Output ResearchSupervisor4 = new Output(Item.KEYCARD_RESEARCH_SUPERVISOR, RefineSetting.FINE, 
        List.of(new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 1.0)));
        outputMap.put(ResearchSupervisor4.getFormula(),ResearchSupervisor4);
        
        Output ResearchSupervisor5 = new Output(Item.KEYCARD_RESEARCH_SUPERVISOR, RefineSetting.VERY_FINE, 
        List.of(new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 0.5), new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 0.5)));
        outputMap.put(ResearchSupervisor5.getFormula(),ResearchSupervisor5);
        
        // Guard Keycard
        Output Guard1 = new Output(Item.KEYCARD_GUARD, RefineSetting.ROUGH, 
        List.of(new OutputItem(Item.KEYCARD_JANITOR, 0.5),new OutputItem(Item.KEYCARD_SCIENTIST, 0.5)));
        outputMap.put(Guard1.getFormula(), Guard1);
        
        Output Guard2 = new Output(Item.KEYCARD_GUARD, RefineSetting.COARSE, 
        List.of(new OutputItem(Item.KEYCARD_SCIENTIST, 1.0)));
        outputMap.put(Guard2.getFormula(), Guard2);
        
        Output Guard3 = new Output(Item.KEYCARD_GUARD, RefineSetting.ONE_TO_ONE, 
        List.of(new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 1.0)));
        outputMap.put(Guard3.getFormula(), Guard3);
        
        Output Guard4 = new Output(Item.KEYCARD_GUARD, RefineSetting.FINE, List.of(new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 1.0)));
        outputMap.put(Guard4.getFormula(), Guard4);
        
        Output Guard5 = new Output(Item.KEYCARD_GUARD, RefineSetting.VERY_FINE, List.of(new OutputItem(Item.KEYCARD_GUARD, 0.33),
        new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 0.33), new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 0.33)));
        outputMap.put(Guard5.getFormula(), Guard5);
        
        // Operative Keycard
        Output Operative1 = new Output(Item.KEYCARD_MTF_OPERATIVE, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_GUARD, 0.5),
            new OutputItem(OutputItem.DESTROYED, 0.5)
        ));
        outputMap.put(Operative1.getFormula(), Operative1);
        
        Output Operative2 = new Output(Item.KEYCARD_MTF_OPERATIVE, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_GUARD, 1.0)
        ));
        outputMap.put(Operative2.getFormula(), Operative2);
        
        Output Operative3 = new Output(Item.KEYCARD_MTF_OPERATIVE, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 1.0)
        ));
        outputMap.put(Operative3.getFormula(), Operative3);
        
        Output Operative4 = new Output(Item.KEYCARD_MTF_OPERATIVE, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 1.0)
        ));
        outputMap.put(Operative4.getFormula(), Operative4);
        
        Output Operative5 = new Output(Item.KEYCARD_MTF_OPERATIVE, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 0.33),
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 0.33),
            new OutputItem(Item.KEYCARD_O5, 0.33)
        ));
        outputMap.put(Operative5.getFormula(), Operative5);
        
        // Captain Keycard
        Output Captain1 = new Output(Item.KEYCARD_MTF_CAPTAIN, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 1.0)
        ));
        outputMap.put(Captain1.getFormula(), Captain1);
        
        Output Captain2 = new Output(Item.KEYCARD_MTF_CAPTAIN, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 1.0)
        ));
        outputMap.put(Captain2.getFormula(), Captain2);
        
        Output Captain3 = new Output(Item.KEYCARD_MTF_CAPTAIN, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_CHAOS_INSURGENCY, 1.0)
        ));
        outputMap.put(Captain3.getFormula(), Captain3);
        
        Output Captain4 = new Output(Item.KEYCARD_MTF_CAPTAIN, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_O5, 1.0)
        ));
        outputMap.put(Captain4.getFormula(), Captain4);
        
        Output Captain5 = new Output(Item.KEYCARD_MTF_CAPTAIN, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.25),
            new OutputItem(Item.KEYCARD_O5, 0.75)
        ));
        outputMap.put(Captain5.getFormula(), Captain5);
        
        // Zone Manager Keycard
        Output ZoneManager1 = new Output(Item.KEYCARD_ZONE_MANAGER, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_JANITOR, 0.5),
            new OutputItem(Item.KEYCARD_SCIENTIST, 0.5)
        ));
        outputMap.put(ZoneManager1.getFormula(), ZoneManager1);
        
        Output ZoneManager2 = new Output(Item.KEYCARD_ZONE_MANAGER, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_SCIENTIST, 1.0)
        ));
        outputMap.put(ZoneManager2.getFormula(), ZoneManager2);
        
        Output ZoneManager3 = new Output(Item.KEYCARD_ZONE_MANAGER, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_GUARD, 1.0)
        ));
        outputMap.put(ZoneManager3.getFormula(), ZoneManager3);
        
        Output ZoneManager4 = new Output(Item.KEYCARD_ZONE_MANAGER, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 1.0)
        ));
        outputMap.put(ZoneManager4.getFormula(), ZoneManager4);
        
        Output ZoneManager5 = new Output(Item.KEYCARD_ZONE_MANAGER, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.KEYCARD_ZONE_MANAGER, 0.4),
            new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 0.4),
            new OutputItem(Item.KEYCARD_CHAOS_INSURGENCY, 0.2)
        ));
        outputMap.put(ZoneManager5.getFormula(), ZoneManager5);
        
        // Facility Manager Keycard
        Output FacilityManager1 = new Output(Item.KEYCARD_FACILITY_MANAGER, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_ZONE_MANAGER, 1.0)
        ));
        outputMap.put(FacilityManager1.getFormula(), FacilityManager1);
        
        Output FacilityManager2 = new Output(Item.KEYCARD_FACILITY_MANAGER, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 1.0)
        ));
        outputMap.put(FacilityManager2.getFormula(), FacilityManager2);
        
        Output FacilityManager3 = new Output(Item.KEYCARD_FACILITY_MANAGER, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_CHAOS_INSURGENCY, 1.0)
        ));
        outputMap.put(FacilityManager3.getFormula(), FacilityManager3);
        
        Output FacilityManager4 = new Output(Item.KEYCARD_FACILITY_MANAGER, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_O5, 1.0)
        ));
        outputMap.put(FacilityManager4.getFormula(), FacilityManager4);
        
        Output FacilityManager5 = new Output(Item.KEYCARD_FACILITY_MANAGER, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.25),
            new OutputItem(Item.KEYCARD_O5, 0.75)
        ));
        outputMap.put(FacilityManager5.getFormula(), FacilityManager5);
        
        // CI Access Device
        Output CI1 = new Output(Item.KEYCARD_CHAOS_INSURGENCY, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_GUARD, 1.0)
        ));
        outputMap.put(CI1.getFormula(), CI1);
        
        Output CI2 = new Output(Item.KEYCARD_CHAOS_INSURGENCY, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 1.0)
        ));
        outputMap.put(CI2.getFormula(), CI2);
        
        Output CI3 = new Output(Item.KEYCARD_CHAOS_INSURGENCY, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 1.0)
        ));
        outputMap.put(CI3.getFormula(), CI3);
        
        Output CI4 = new Output(Item.KEYCARD_CHAOS_INSURGENCY, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_O5, 1.0)
        ));
        outputMap.put(CI4.getFormula(), CI4);
        
        Output CI5 = new Output(Item.KEYCARD_CHAOS_INSURGENCY, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.25),
            new OutputItem(Item.KEYCARD_O5, 0.75)
        ));
        outputMap.put(CI5.getFormula(), CI5);
        
        // O5 Keycard
        Output O51 = new Output(Item.KEYCARD_O5, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_GUARD, 1.0)
        ));
        outputMap.put(O51.getFormula(), O51);
        
        Output O52 = new Output(Item.KEYCARD_O5, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 0.5),
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 0.5)
        ));
        outputMap.put(O52.getFormula(), O52);
        
        Output O53 = new Output(Item.KEYCARD_O5, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_O5, 1.0)
        ));
        outputMap.put(O53.getFormula(), O53);
        
        Output O54 = new Output(Item.KEYCARD_O5, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),
            new OutputItem(Item.KEYCARD_O5, 0.5)
        ));
        outputMap.put(O54.getFormula(), O54);
        
        Output O55 = new Output(Item.KEYCARD_O5, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.75),
            new OutputItem(Item.KEYCARD_O5, 0.25)
        ));
        outputMap.put(O55.getFormula(), O55);
        
        //Standard Weaponry
        //COM-15
        Output COM15_1 = new Output(Item.GUN_COM15, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 15)
        ));
        outputMap.put(COM15_1.getFormula(), COM15_1);
        
        Output COM15_2 = new Output(Item.GUN_COM15, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 0.5),
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 15)
        ));
        outputMap.put(COM15_2.getFormula(), COM15_2);
        
        Output COM15_3 = new Output(Item.GUN_COM15, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)
        ));
        outputMap.put(COM15_3.getFormula(), COM15_3);
        
        Output COM15_4 = new Output(Item.GUN_COM15, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_COM18, 1.0) 
        ));
        outputMap.put(COM15_4.getFormula(), COM15_4);
        
        Output COM15_5 = new Output(Item.GUN_COM15, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_FSP9, 0.555), 
            new OutputItem(Item.GUN_REVOLVER, 0.295), 
            new OutputItem(Item.GUN_COM45, 0.15)
        ));
        outputMap.put(COM15_5.getFormula(), COM15_5);
        
        // COM-18
        Output COM18_1 = new Output(Item.GUN_COM18, RefineSetting.ROUGH, List.of(
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 15),  // 50% chance for 9x19mm (15 rounds)
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 30)   // 50% chance for 9x19mm (30 rounds)
        ));
        outputMap.put(COM18_1.getFormula(), COM18_1);
        
        Output COM18_2 = new Output(Item.GUN_COM18, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_COM15, 1.0)  // 100% chance for COM-15
        ));
        outputMap.put(COM18_2.getFormula(), COM18_2);
        
        Output COM18_3 = new Output(Item.GUN_COM18, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)  // 100% chance for Randomized Attachments
        ));
        outputMap.put(COM18_3.getFormula(), COM18_3);
        
        Output COM18_4 = new Output(Item.GUN_COM18, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_FSP9, 1.0)  // 100% chance for FSP-9
        ));
        outputMap.put(COM18_4.getFormula(), COM18_4);
        
        Output COM18_5 = new Output(Item.GUN_COM18, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 0.55),  // 55% chance for Crossvec
            new OutputItem(Item.GUN_REVOLVER, 0.45)  // 45% chance for .44 Revolver
        ));
        outputMap.put(COM18_5.getFormula(), COM18_5);
        // Crossvec
        Output Crossvec_1 = new Output(Item.GUN_CROSSVEC, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),          // 50% chance for Destroyed
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 60)        // 50% chance for 9x19mm (60 rounds)
        ));
        outputMap.put(Crossvec_1.getFormula(), Crossvec_1);
        
        Output Crossvec_2 = new Output(Item.GUN_CROSSVEC, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_FSP9, 1.0)                 // 100% chance for FSP-9
        ));
        outputMap.put(Crossvec_2.getFormula(), Crossvec_2);
        
        Output Crossvec_3 = new Output(Item.GUN_CROSSVEC, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)  // 100% chance for Randomized Attachments
        ));
        outputMap.put(Crossvec_3.getFormula(), Crossvec_3);
        
        Output Crossvec_4 = new Output(Item.GUN_CROSSVEC, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_E11_SR, 0.6),          // 60% chance for MTF-E11-SR
            new OutputItem(Item.GUN_AK, 0.4)                   // 40% chance for AK
        ));
        outputMap.put(Crossvec_4.getFormula(), Crossvec_4);
        
        Output Crossvec_5 = new Output(Item.GUN_CROSSVEC, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_E11_SR, 0.7),          // 70% chance for MTF-E11-SR
            new OutputItem(Item.GUN_SHOTGUN, 0.3)             // 30% chance for Shotgun
        ));
        outputMap.put(Crossvec_5.getFormula(), Crossvec_5);
        
        // FR-MG-0
        Output FRMG_1 = new Output(Item.GUN_FRMG0, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_E11_SR, 0.5),            // 50% chance for MTF-E11-SR
            new OutputItem(AmmoItem.AMMO_556x45, 0.5, 150)      // 50% chance for 5.56x45mm (150 rounds)
        ));
        outputMap.put(FRMG_1.getFormula(), FRMG_1);
        
        Output FRMG_2 = new Output(Item.GUN_FRMG0, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_E11_SR, 1.0)            // 100% chance for MTF-E11-SR
        ));
        outputMap.put(FRMG_2.getFormula(), FRMG_2);
        
        Output FRMG_3 = new Output(Item.GUN_FRMG0, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)   // 100% chance for Randomized Attachments
        ));
        outputMap.put(FRMG_3.getFormula(), FRMG_3);
        
        Output FRMG_4 = new Output(Item.GUN_FRMG0, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_LOGICER, 1.0)               // 100% chance for Logicer
        ));
        outputMap.put(FRMG_4.getFormula(), FRMG_4);
        
        Output FRMG_5 = new Output(Item.GUN_FRMG0, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(Item.GUN_COM18, 0.95),          // Part of the group
                new OutputItem(Item.GUN_CROSSVEC, 0.95)       // Part of the group
            ), 0.95),                                          // 95% chance for the group
            new OutputItem(Item.MICRO_HID, 0.05)               // 5% chance for Micro H.I.D.
        ));
        outputMap.put(FRMG_5.getFormula(), FRMG_5);
        
        // FSP-9
        Output FSP9_1 = new Output(Item.GUN_FSP9, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),             // 50% chance for Destroyed
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 45)           // 50% chance for 9x19mm (45 rounds)
        ));
        outputMap.put(FSP9_1.getFormula(), FSP9_1);
        
        Output FSP9_2 = new Output(Item.GUN_FSP9, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_COM18, 1.0)                   // 100% chance for COM-18
        ));
        outputMap.put(FSP9_2.getFormula(), FSP9_2);
        
        Output FSP9_3 = new Output(Item.GUN_FSP9, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)     // 100% chance for Randomized Attachments
        ));
        outputMap.put(FSP9_3.getFormula(), FSP9_3);
        
        Output FSP9_4 = new Output(Item.GUN_FSP9, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 1.0)                // 100% chance for Crossvec
        ));
        outputMap.put(FSP9_4.getFormula(), FSP9_4);
        
        Output FSP9_5 = new Output(Item.GUN_FSP9, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 0.7),               // 70% chance for Crossvec
            new OutputItem(Item.GUN_E11_SR, 0.3)             // 30% chance for MTF-E11-SR
        ));
        outputMap.put(FSP9_5.getFormula(), FSP9_5);
        // MTF-E11-SR
        Output E11_SR_1 = new Output(Item.GUN_E11_SR, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_COM15, 0.5),                 // 50% chance for COM-15
            new OutputItem(AmmoItem.AMMO_556x45, 0.5, 80)       // 50% chance for 5.56x45mm (80 rounds)
        ));
        outputMap.put(E11_SR_1.getFormula(), E11_SR_1);
        
        Output E11_SR_2 = new Output(Item.GUN_E11_SR, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 1.0)              // 100% chance for Crossvec
        ));
        outputMap.put(E11_SR_2.getFormula(), E11_SR_2);
        
        Output E11_SR_3 = new Output(Item.GUN_E11_SR, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)   // 100% chance for Randomized Attachments
        ));
        outputMap.put(E11_SR_3.getFormula(), E11_SR_3);
        
        Output E11_SR_4 = new Output(Item.GUN_E11_SR, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_AK, 1.0)                    // 100% chance for AK
        ));
        outputMap.put(E11_SR_4.getFormula(), E11_SR_4);
        
        Output E11_SR_5 = new Output(Item.GUN_E11_SR, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_AK, 0.3),                   // 30% chance for AK
            new OutputItem(Item.GUN_CROSSVEC, 0.3),             // 30% chance for Crossvec
            new OutputItem(Item.GUN_FRMG0, 0.25),               // 25% chance for FR-MG-0
            new OutputItem(Item.GUN_SHOTGUN, 0.1),              // 10% chance for Shotgun
            new OutputItem(Item.MICRO_HID, 0.05)                // 5% chance for Micro H.I.D.
        ));
        outputMap.put(E11_SR_5.getFormula(), E11_SR_5);
        
        // AK
        Output AK_1 = new Output(Item.GUN_AK, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_COM15, 0.5),                 // 50% chance for COM-15
            new OutputItem(AmmoItem.AMMO_762x39, 0.5, 90)       // 50% chance for 7.62x39mm (90 rounds)
        ));
        outputMap.put(AK_1.getFormula(), AK_1);
        
        Output AK_2 = new Output(Item.GUN_AK, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_A7, 0.5),                   // 50% chance for A7
            new OutputItem(Item.GUN_CROSSVEC, 0.5)             // 50% chance for Crossvec
        ));
        outputMap.put(AK_2.getFormula(), AK_2);
        
        Output AK_3 = new Output(Item.GUN_AK, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)   // 100% chance for Randomized Attachments
        ));
        outputMap.put(AK_3.getFormula(), AK_3);
        
        Output AK_4 = new Output(Item.GUN_AK, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_E11_SR, 1.0)                // 100% chance for MTF-E11-SR
        ));
        outputMap.put(AK_4.getFormula(), AK_4);
        
        Output AK_5 = new Output(Item.GUN_AK, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 0.3),             // 30% chance for Crossvec
            new OutputItem(Item.GUN_E11_SR, 0.3),               // 30% chance for MTF-E11-SR
            new OutputItem(Item.GUN_LOGICER, 0.25),             // 25% chance for Logicer
            new OutputItem(Item.GUN_SHOTGUN, 0.1),              // 10% chance for Shotgun
            new OutputItem(Item.MICRO_HID, 0.05)                // 5% chance for Micro H.I.D.
        ));
        outputMap.put(AK_5.getFormula(), AK_5);
        
        // Logicer
        Output Logicer_1 = new Output(Item.GUN_LOGICER, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_AK, 0.5),                     // 50% chance for AK
            new OutputItem(AmmoItem.AMMO_762x39, 0.5, 120)       // 50% chance for 7.62x39mm (120 rounds)
        ));
        outputMap.put(Logicer_1.getFormula(), Logicer_1);
        
        Output Logicer_2 = new Output(Item.GUN_LOGICER, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_FRMG0, 1.0)                  // 100% chance for FR-MG-0
        ));
        outputMap.put(Logicer_2.getFormula(), Logicer_2);
        
        Output Logicer_3 = new Output(Item.GUN_LOGICER, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)    // 100% chance for Randomized Attachments
        ));
        outputMap.put(Logicer_3.getFormula(), Logicer_3);
        
        Output Logicer_4 = new Output(Item.GUN_LOGICER, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_SHOTGUN, 1.0)                // 100% chance for Shotgun
        ));
        outputMap.put(Logicer_4.getFormula(), Logicer_4);
        
        Output Logicer_5 = new Output(Item.GUN_LOGICER, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(Item.GUN_AK, 1.0),                // Part of the group
                new OutputItem(OutputItem.GRENADE_HE_X2, 1.0) // Part of the group, HE Grenade x2
            ), 0.6),                                             // 60% chance for (AK, HE Grenade x2)
            new OutputGroup(List.of(
                new OutputItem(Item.GUN_SHOTGUN, 1.0),           // Part of the group
                new OutputItem(Item.GUN_REVOLVER, 1.0)          // Part of the group
            ), 0.3),                                             // 30% chance for (Shotgun, .44 Revolver)
            new OutputItem(Item.MICRO_HID, 0.1)                 // 10% chance for Micro H.I.D.
        ));
        outputMap.put(Logicer_5.getFormula(), Logicer_5);
        // .44 Revolver
        Output Revolver_1 = new Output(Item.GUN_REVOLVER, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),            // 50% chance for Destroyed
            new OutputItem(AmmoItem.AMMO_44CAL, 0.5, 12)         // 50% chance for .44 Mag (12 rounds)
        ));
        outputMap.put(Revolver_1.getFormula(), Revolver_1);
        
        Output Revolver_2 = new Output(Item.GUN_REVOLVER, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_COM18, 0.8),                 // 80% chance for COM-18
            new OutputItem(Item.GRENADE_HE, 0.2) // 20% chance for High-Explosive Grenade
        ));
        outputMap.put(Revolver_2.getFormula(), Revolver_2);
        
        Output Revolver_3 = new Output(Item.GUN_REVOLVER, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)    // 100% chance for Randomized Attachments
        ));
        outputMap.put(Revolver_3.getFormula(), Revolver_3);
        
        Output Revolver_4 = new Output(Item.GUN_REVOLVER, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 1.0)               // 100% chance for Crossvec
        ));
        outputMap.put(Revolver_4.getFormula(), Revolver_4);
        
        Output Revolver_5 = new Output(Item.GUN_REVOLVER, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(Item.KEYCARD_ZONE_MANAGER, 1.0),  // Zone Manager Keycard
                new OutputItem(Item.GUN_COM15, 1.0),             // COM-15
                new OutputItem(Item.MEDKIT, 1.0), // First Aid Kit
                new OutputItem(Item.PAINKILLERS, 1.0)    // Painkillers
            ), 0.5),                                             // 50% chance for grouped items
            new OutputItem(OutputItem.GRENADE_HE_X2, 0.5) // 50% chance for High-Explosive Grenade (x2)
        ));
        outputMap.put(Revolver_5.getFormula(), Revolver_5);

        // Shotgun
        Output Shotgun_1 = new Output(Item.GUN_SHOTGUN, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_AK, 0.5),                     // 50% chance for AK
            new OutputItem(AmmoItem.AMMO_12GAUGE, 0.5, 25)       // 50% chance for 12/70 Buckshot (25 rounds)
        ));
        outputMap.put(Shotgun_1.getFormula(), Shotgun_1);
        
        Output Shotgun_2 = new Output(Item.GUN_SHOTGUN, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_AK, 1.0)                     // 100% chance for AK
        ));
        outputMap.put(Shotgun_2.getFormula(), Shotgun_2);
        
        Output Shotgun_3 = new Output(Item.GUN_SHOTGUN, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RANDOMATTACHMENTS, 1.0)    // 100% chance for Randomized Attachments
        ));
        outputMap.put(Shotgun_3.getFormula(), Shotgun_3);
        
        Output Shotgun_4 = new Output(Item.GUN_SHOTGUN, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_LOGICER, 1.0)                // 100% chance for Logicer
        ));
        outputMap.put(Shotgun_4.getFormula(), Shotgun_4);
        
        Output Shotgun_5 = new Output(Item.GUN_SHOTGUN, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_AK, 0.4),                    // 40% chance for AK
            new OutputItem(Item.GUN_CROSSVEC, 0.3),              // 30% chance for Crossvec
            new OutputItem(Item.GUN_LOGICER, 0.25),              // 25% chance for Logicer
            new OutputItem(Item.MICRO_HID, 0.05)                // 5% chance for Micro H.I.D.
        ));
        outputMap.put(Shotgun_5.getFormula(), Shotgun_5);
        
        // High-Explosive Grenade
        Output HEGrenade_1 = new Output(Item.GRENADE_HE, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)             // 100% chance for Destroyed
        ));
        outputMap.put(HEGrenade_1.getFormula(), HEGrenade_1);
        
        Output HEGrenade_2 = new Output(Item.GRENADE_HE, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 1.0)              // 100% chance for Flashbang Grenade
        ));
        outputMap.put(HEGrenade_2.getFormula(), HEGrenade_2);
        
        Output HEGrenade_3 = new Output(Item.GRENADE_HE, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 1.0)              // 100% chance for Flashbang Grenade
        ));
        outputMap.put(HEGrenade_3.getFormula(), HEGrenade_3);
        
        Output HEGrenade_4 = new Output(Item.GRENADE_HE, RefineSetting.FINE, List.of(
            new OutputItem(Item.GRENADE_HE, 1.0)     // 100% chance for High-Explosive Grenade
        ));
        outputMap.put(HEGrenade_4.getFormula(), HEGrenade_4);
        
        Output HEGrenade_5 = new Output(Item.GRENADE_HE, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),           // 50% chance for Destroyed
            new OutputItem(Item.GRENADE_HE, 0.25),   // 25% chance for High-Explosive Grenade
            new OutputItem(Item.SCP_018, 0.25)                   // 25% chance for SCP-018
        ));
        outputMap.put(HEGrenade_5.getFormula(), HEGrenade_5);

        // Flashbang Grenade
        Output Flashbang_1 = new Output(Item.GRENADE_FLASH, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)             // 100% chance for Destroyed
        ));
        outputMap.put(Flashbang_1.getFormula(), Flashbang_1);
        
        Output Flashbang_2 = new Output(Item.GRENADE_FLASH, RefineSetting.COARSE, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                 // 100% chance for Flashlight
        ));
        outputMap.put(Flashbang_2.getFormula(), Flashbang_2);
        
        Output Flashbang_3 = new Output(Item.GRENADE_FLASH, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.GRENADE_HE, 1.0)     // 100% chance for High-Explosive Grenade
        ));
        outputMap.put(Flashbang_3.getFormula(), Flashbang_3);
        
        Output Flashbang_4 = new Output(Item.GRENADE_FLASH, RefineSetting.FINE, List.of(
            new OutputItem(Item.GRENADE_HE, 1.0)     // 100% chance for High-Explosive Grenade
        ));
        outputMap.put(Flashbang_4.getFormula(), Flashbang_4);
        
        Output Flashbang_5 = new Output(Item.GRENADE_FLASH, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.75),          // 75% chance for Destroyed
            new OutputItem(Item.SCP_207, 0.25)                   // 25% chance for SCP-207
        ));
        outputMap.put(Flashbang_5.getFormula(), Flashbang_5);

        //Special Weaponry
        // 3-X Particle Disruptor
        Output ParticleDisruptor_1 = new Output(Item.PARTICLE_DISRUPTOR, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                 // 100% chance for Flashlight
        ));
        outputMap.put(ParticleDisruptor_1.getFormula(), ParticleDisruptor_1);
        
        Output ParticleDisruptor_2 = new Output(Item.PARTICLE_DISRUPTOR, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_E11_SR, 1.0)                // 100% chance for MTF-E11-SR
        ));
        outputMap.put(ParticleDisruptor_2.getFormula(), ParticleDisruptor_2);
        
        Output ParticleDisruptor_3 = new Output(Item.PARTICLE_DISRUPTOR, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.JAILBIRD, 1.0)                 // 100% chance for Jailbird
        ));
        outputMap.put(ParticleDisruptor_3.getFormula(), ParticleDisruptor_3);
        
        Output ParticleDisruptor_4 = new Output(Item.PARTICLE_DISRUPTOR, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.REFUELED_PARTICLE_DISRUPTOR, 1.0) // 100% chance for Refueled Particle Disruptor
        ));
        outputMap.put(ParticleDisruptor_4.getFormula(), ParticleDisruptor_4);
        
        Output ParticleDisruptor_5 = new Output(Item.PARTICLE_DISRUPTOR, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.MICRO_HID, 1.0)                // 100% chance for Micro H.I.D.
        ));
        outputMap.put(ParticleDisruptor_5.getFormula(), ParticleDisruptor_5);

        // A7
        Output A7_1 = new Output(Item.GUN_A7, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_COM15, 0.5),                  // 50% chance for COM-15
            new OutputItem(AmmoItem.AMMO_762x39, 0.5, 90)        // 50% chance for 7.62x39mm (90 rounds)
        ));
        outputMap.put(A7_1.getFormula(), A7_1);
        
        Output A7_2 = new Output(Item.GUN_A7, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GUN_COM18, 1.0)                  // 100% chance for COM-18
        ));
        outputMap.put(A7_2.getFormula(), A7_2);
        
        Output A7_3 = new Output(Item.GUN_A7, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.GUN_A7, 1.0)                     // 100% chance for A7
        ));
        outputMap.put(A7_3.getFormula(), A7_3);
        
        Output A7_4 = new Output(Item.GUN_A7, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_AK, 1.0)                     // 100% chance for AK
        ));
        outputMap.put(A7_4.getFormula(), A7_4);
        
        Output A7_5 = new Output(Item.GUN_A7, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(Item.GRENADE_FLASH, 1.0),         // Flashbang Grenade
                new OutputItem(Item.GUN_REVOLVER, 1.0)          // .44 Revolver
            ), 1.0)                                              // 100% chance for the group
        ));
        outputMap.put(A7_5.getFormula(), A7_5);

        // COM-45
        Output COM45_1 = new Output(Item.GUN_COM45, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),           // 50% chance for Destroyed
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 15)         // 50% chance for 9x19mm (15 rounds)
        ));
        outputMap.put(COM45_1.getFormula(), COM45_1);
        
        Output COM45_2 = new Output(Item.GUN_COM45, RefineSetting.COARSE, List.of(
            new OutputItem(AmmoItem.AMMO_9x19, 0.5, 15),        // 50% chance for 9x19mm (15 rounds)
            new OutputItem(Item.GUN_COM15, 0.5)                 // 50% chance for COM-15
        ));
        outputMap.put(COM45_2.getFormula(), COM45_2);
        
        Output COM45_3 = new Output(Item.GUN_COM45, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.GUN_COM45, 1.0)                 // 100% chance for COM-45
        ));
        outputMap.put(COM45_3.getFormula(), COM45_3);
        
        Output COM45_4 = new Output(Item.GUN_COM45, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_CROSSVEC, 1.0)              // 100% chance for Crossvec
        ));
        outputMap.put(COM45_4.getFormula(), COM45_4);
        
        Output COM45_5 = new Output(Item.GUN_COM45, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GUN_REVOLVER, 1.0)             // 100% chance for .44 Revolver
        ));
        outputMap.put(COM45_5.getFormula(), COM45_5);

        // Jailbird
        Output Jailbird_1 = new Output(Item.JAILBIRD, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                // 100% chance for Flashlight
        ));
        outputMap.put(Jailbird_1.getFormula(), Jailbird_1);
        
        Output Jailbird_2 = new Output(Item.JAILBIRD, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.DAMAGED_JAILBIRD, 1.0) // 100% chance for Jailbird (Heavily damaged)
        ));
        outputMap.put(Jailbird_2.getFormula(), Jailbird_2);
        
        Output Jailbird_3 = new Output(Item.JAILBIRD, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.PARTICLE_DISRUPTOR, 1.0)        // 100% chance for 3-X Particle Disruptor
        ));
        outputMap.put(Jailbird_3.getFormula(), Jailbird_3);
        
        Output Jailbird_4 = new Output(Item.JAILBIRD, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.REFUELED_JAILBIRD, 1.0) // 100% chance for Jailbird (Refueled)
        ));
        outputMap.put(Jailbird_4.getFormula(), Jailbird_4);
        
        Output Jailbird_5 = new Output(Item.JAILBIRD, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.MICRO_HID, 1.0)                // 100% chance for Micro H.I.D.
        ));
        outputMap.put(Jailbird_5.getFormula(), Jailbird_5);

        // Micro H.I.D.
        Output MicroHID_1 = new Output(Item.MICRO_HID, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GUN_E11_SR, 1.0)                // 100% chance for MTF-E11-SR
        ));
        outputMap.put(MicroHID_1.getFormula(), MicroHID_1);
        
        Output MicroHID_2 = new Output(Item.MICRO_HID, RefineSetting.COARSE, List.of(
            new OutputItem(Item.PARTICLE_DISRUPTOR, 0.5),       // 50% chance for 3-X Particle Disruptor
            new OutputItem(Item.JAILBIRD, 0.5)                 // 50% chance for Jailbird
        ));
        outputMap.put(MicroHID_2.getFormula(), MicroHID_2);
        
        Output MicroHID_3 = new Output(Item.MICRO_HID, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.REFUELED_MICRO_HID, 1.0) // 100% chance for Micro H.I.D. (Refueled)
        ));
        outputMap.put(MicroHID_3.getFormula(), MicroHID_3);
        
        Output MicroHID_4 = new Output(Item.MICRO_HID, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.REFUELED_MICRO_HID, 1.0) // 100% chance for Micro H.I.D. (Refueled)
        ));
        outputMap.put(MicroHID_4.getFormula(), MicroHID_4);
        
        Output MicroHID_5 = new Output(Item.MICRO_HID, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.REFUELED_MICRO_HID, 1.0) // 100% chance for Micro H.I.D. (Refueled)
        ));
        outputMap.put(MicroHID_5.getFormula(), MicroHID_5);
        
        //Ammo
        //Ammo uses an economy system that determines how many rounds is given to a player when converting ammo in SCP-914. 
        //This system stops players from turning a weak fully loaded weapon, such as a COM-15, into a stronger fully loaded weapon,
        //such as a Logicer. Any "extra" ammo will be left unchanged.
        //These paths also apply to any ammo inside a Firearm that is going through SCP-914.
        //The following inputs represent 15 rounds being placed in the input booth.
        
        // 9x19mm
        Output NineMM_1 = new Output(AmmoItem.AMMO_9x19, RefineSetting.ROUGH, List.of(
            new OutputItem(AmmoItem.AMMO_556x45, 1.0, 10)        // 100% chance for 5.56x45mm (10 rounds)
        ));
        outputMap.put(NineMM_1.getFormula(), NineMM_1);
        
        Output NineMM_2 = new Output(AmmoItem.AMMO_9x19, RefineSetting.COARSE, List.of(
            new OutputItem(AmmoItem.AMMO_556x45, 1.0, 10)        // 100% chance for 5.56x45mm (10 rounds)
        ));
        outputMap.put(NineMM_2.getFormula(), NineMM_2);
        
        Output NineMM_3 = new Output(AmmoItem.AMMO_9x19, RefineSetting.ONE_TO_ONE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 4),     // .44 Mag (4 rounds)
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 1)       // 9x19mm (1 round)
            ), 1.0)                                              // 100% chance for the group
        ));
        outputMap.put(NineMM_3.getFormula(), NineMM_3);
        
        Output NineMM_4 = new Output(AmmoItem.AMMO_9x19, RefineSetting.FINE, List.of(
            new OutputItem(AmmoItem.AMMO_556x45, 1.0, 10)        // 100% chance for 5.56x45mm (10 rounds)
        ));
        outputMap.put(NineMM_4.getFormula(), NineMM_4);
            
        Output NineMM_5 = new Output(AmmoItem.AMMO_9x19, RefineSetting.VERY_FINE, List.of(
            new OutputItem(AmmoItem.AMMO_556x45, 1.0, 10)        // 100% chance for 5.56x45mm (10 rounds)
        ));
        outputMap.put(NineMM_5.getFormula(), NineMM_5);
            
        // 5.56x45mm
        Output FiveFiveSix_1 = new Output(AmmoItem.AMMO_556x45, RefineSetting.ROUGH, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 21),       // 9x19mm (21 rounds)
                new OutputItem(AmmoItem.AMMO_556x45, 1.0, 1)       // 5.56x45mm (1 round)
            ), 1.0)                                                // 100% chance for the group
        ));
        outputMap.put(FiveFiveSix_1.getFormula(), FiveFiveSix_1);
        
        Output FiveFiveSix_2 = new Output(AmmoItem.AMMO_556x45, RefineSetting.COARSE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 21),       // 9x19mm (21 rounds)
                new OutputItem(AmmoItem.AMMO_556x45, 1.0, 1)       // 5.56x45mm (1 round)
            ), 1.0)                                                // 100% chance for the group
        ));
        outputMap.put(FiveFiveSix_2.getFormula(), FiveFiveSix_2);
        
        Output FiveFiveSix_3 = new Output(AmmoItem.AMMO_556x45, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(AmmoItem.AMMO_762x39, 1.0, 15)         // 100% chance for 7.62x39mm (15 rounds)
        ));
        outputMap.put(FiveFiveSix_3.getFormula(), FiveFiveSix_3);
        
        Output FiveFiveSix_4 = new Output(AmmoItem.AMMO_556x45, RefineSetting.FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 21),       // 9x19mm (21 rounds)
                new OutputItem(AmmoItem.AMMO_556x45, 1.0, 1)       // 5.56x45mm (1 round)
            ), 1.0)                                                // 100% chance for the group
        ));
        outputMap.put(FiveFiveSix_4.getFormula(), FiveFiveSix_4);
        
        Output FiveFiveSix_5 = new Output(AmmoItem.AMMO_556x45, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 21),       // 9x19mm (21 rounds)
                new OutputItem(AmmoItem.AMMO_556x45, 1.0, 1)       // 5.56x45mm (1 round)
            ), 1.0)                                                // 100% chance for the group
        ));
        outputMap.put(FiveFiveSix_5.getFormula(), FiveFiveSix_5);
    
        // 7.62x39mm
        Output SevenSixTwo_1 = new Output(AmmoItem.AMMO_762x39, RefineSetting.ROUGH, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 6),      // .44 Mag (6 rounds)
                new OutputItem(AmmoItem.AMMO_762x39, 1.0, 1)      // 7.62x39mm (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(SevenSixTwo_1.getFormula(), SevenSixTwo_1);
        
        Output SevenSixTwo_2 = new Output(AmmoItem.AMMO_762x39, RefineSetting.COARSE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 6),      // .44 Mag (6 rounds)
                new OutputItem(AmmoItem.AMMO_762x39, 1.0, 1)      // 7.62x39mm (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(SevenSixTwo_2.getFormula(), SevenSixTwo_2);
        
        Output SevenSixTwo_3 = new Output(AmmoItem.AMMO_762x39, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(AmmoItem.AMMO_556x45, 1.0, 15)         // 100% chance for 5.56x45mm (15 rounds)
        ));
        outputMap.put(SevenSixTwo_3.getFormula(), SevenSixTwo_3);
        
        Output SevenSixTwo_4 = new Output(AmmoItem.AMMO_762x39, RefineSetting.FINE, List.of(
            new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 9)         // 100% chance for 12/70 Buckshot (9 rounds)
        ));
        outputMap.put(SevenSixTwo_4.getFormula(), SevenSixTwo_4);
        
        Output SevenSixTwo_5 = new Output(AmmoItem.AMMO_762x39, RefineSetting.VERY_FINE, List.of(
            new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 9)         // 100% chance for 12/70 Buckshot (9 rounds)
        ));
        outputMap.put(SevenSixTwo_5.getFormula(), SevenSixTwo_5);
        
        // 12/70 Buckshot
        Output TwelveGauge_1 = new Output(AmmoItem.AMMO_12GAUGE, RefineSetting.ROUGH, List.of(
            new OutputItem(AmmoItem.AMMO_762x39, 1.0, 25)        // 100% chance for 7.62x39mm (25 rounds)
        ));
        outputMap.put(TwelveGauge_1.getFormula(), TwelveGauge_1);
        
        Output TwelveGauge_2 = new Output(AmmoItem.AMMO_12GAUGE, RefineSetting.COARSE, List.of(
            new OutputItem(AmmoItem.AMMO_762x39, 1.0, 25)        // 100% chance for 7.62x39mm (25 rounds)
        ));
        outputMap.put(TwelveGauge_2.getFormula(), TwelveGauge_2);
        
        Output TwelveGauge_3 = new Output(AmmoItem.AMMO_12GAUGE, RefineSetting.ONE_TO_ONE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 35),     // 9x19mm (35 rounds)
                new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 1)    // 12/70 Buckshot (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(TwelveGauge_3.getFormula(), TwelveGauge_3);
        
        Output TwelveGauge_4 = new Output(AmmoItem.AMMO_12GAUGE, RefineSetting.FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 10),    // .44 Mag (10 rounds)
                new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 1)    // 12/70 Buckshot (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(TwelveGauge_4.getFormula(), TwelveGauge_4);
        
        Output TwelveGauge_5 = new Output(AmmoItem.AMMO_12GAUGE, RefineSetting.VERY_FINE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 10),    // .44 Mag (10 rounds)
                new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 1)    // 12/70 Buckshot (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(TwelveGauge_5.getFormula(), TwelveGauge_5);
    
        // .44 Mag
        Output FortyFourMag_1 = new Output(AmmoItem.AMMO_44CAL, RefineSetting.ROUGH, List.of(
            new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 21)       // 100% chance for 12/70 Buckshot (21 rounds)
        ));
        outputMap.put(FortyFourMag_1.getFormula(), FortyFourMag_1);
        
        Output FortyFourMag_2 = new Output(AmmoItem.AMMO_44CAL, RefineSetting.COARSE, List.of(
            new OutputItem(AmmoItem.AMMO_12GAUGE, 1.0, 21)       // 100% chance for 12/70 Buckshot (21 rounds)
        ));
        outputMap.put(FortyFourMag_2.getFormula(), FortyFourMag_2);
        
        Output FortyFourMag_3 = new Output(AmmoItem.AMMO_44CAL, RefineSetting.ONE_TO_ONE, List.of(
            new OutputGroup(List.of(
                new OutputItem(AmmoItem.AMMO_9x19, 1.0, 49),     // 9x19mm (49 rounds)
                new OutputItem(AmmoItem.AMMO_44CAL, 1.0, 1)      // .44 Mag (1 round)
            ), 1.0)                                               // 100% chance for the group
        ));
        outputMap.put(FortyFourMag_3.getFormula(), FortyFourMag_3);
        
        Output FortyFourMag_4 = new Output(AmmoItem.AMMO_44CAL, RefineSetting.FINE, List.of(
            new OutputItem(AmmoItem.AMMO_762x39, 1.0, 35)        // 100% chance for 7.62x39mm (35 rounds)
        ));
        outputMap.put(FortyFourMag_4.getFormula(), FortyFourMag_4);
        
        Output FortyFourMag_5 = new Output(AmmoItem.AMMO_44CAL, RefineSetting.VERY_FINE, List.of(
            new OutputItem(AmmoItem.AMMO_762x39, 1.0, 35)        // 100% chance for 7.62x39mm (35 rounds)
        ));
        outputMap.put(FortyFourMag_5.getFormula(), FortyFourMag_5);
        
        // Treatment Items
        // Adrenaline
        Output Adrenaline_1 = new Output(Item.ADRENALINE, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),            // 50% chance for Destroyed
            new OutputItem(Item.PAINKILLERS, 0.5)                 // 50% chance for Painkillers
        ));
        outputMap.put(Adrenaline_1.getFormula(), Adrenaline_1);
        
        Output Adrenaline_2 = new Output(Item.ADRENALINE, RefineSetting.COARSE, List.of(
            new OutputItem(Item.MEDKIT, 0.5),              // 50% chance for First Aid Kit
            new OutputItem(Item.PAINKILLERS, 0.5)                 // 50% chance for Painkillers
        ));
        outputMap.put(Adrenaline_2.getFormula(), Adrenaline_2);
        
        Output Adrenaline_3 = new Output(Item.ADRENALINE, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)                 // 100% chance for Painkillers
        ));
        outputMap.put(Adrenaline_3.getFormula(), Adrenaline_3);
        
        Output Adrenaline_4 = new Output(Item.ADRENALINE, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_500, 1.0)                     // 100% chance for SCP-500
        ));
        outputMap.put(Adrenaline_4.getFormula(), Adrenaline_4);
        
        Output Adrenaline_5 = new Output(Item.ADRENALINE, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.PAINKILLERS, 0.66),               // 66% chance for Painkillers
            new OutputItem(Item.SCP_500, 0.33)                    // 33% chance for SCP-500
        ));
        outputMap.put(Adrenaline_5.getFormula(), Adrenaline_5);
    
        // First Aid Kit
        Output FirstAidKit_1 = new Output(Item.MEDKIT, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)             // 100% chance for Destroyed
        ));
        outputMap.put(FirstAidKit_1.getFormula(), FirstAidKit_1);
        
        Output FirstAidKit_2 = new Output(Item.MEDKIT, RefineSetting.COARSE, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)                 // 100% chance for Painkillers
        ));
        outputMap.put(FirstAidKit_2.getFormula(), FirstAidKit_2);
        
        Output FirstAidKit_3 = new Output(Item.MEDKIT, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.MEDKIT, 1.0)                      // 100% chance for First Aid Kit
        ));
        outputMap.put(FirstAidKit_3.getFormula(), FirstAidKit_3);
        
        Output FirstAidKit_4 = new Output(Item.MEDKIT, RefineSetting.FINE, List.of(
            new OutputItem(Item.ADRENALINE, 1.0)                  // 100% chance for Adrenaline
        ));
        outputMap.put(FirstAidKit_4.getFormula(), FirstAidKit_4);
        
        Output FirstAidKit_5 = new Output(Item.MEDKIT, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.33),           // 33% chance for Destroyed
            new OutputItem(Item.MEDKIT, 0.33),                    // 33% chance for First Aid Kit
            new OutputItem(Item.SCP_500, 0.33)                    // 33% chance for SCP-500
        ));
        outputMap.put(FirstAidKit_5.getFormula(), FirstAidKit_5);
    
        // Painkillers
        Output Painkillers_1 = new Output(Item.PAINKILLERS, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)             // 100% chance for Destroyed
        ));
        outputMap.put(Painkillers_1.getFormula(), Painkillers_1);
        
        Output Painkillers_2 = new Output(Item.PAINKILLERS, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),            // 50% chance for Destroyed
            new OutputItem(Item.PAINKILLERS, 0.5)                 // 50% chance for Painkillers
        ));
        outputMap.put(Painkillers_2.getFormula(), Painkillers_2);
        
        Output Painkillers_3 = new Output(Item.PAINKILLERS, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)                 // 100% chance for Painkillers
        ));
        outputMap.put(Painkillers_3.getFormula(), Painkillers_3);
        
        Output Painkillers_4 = new Output(Item.PAINKILLERS, RefineSetting.FINE, List.of(
            new OutputItem(Item.MEDKIT, 1.0)                      // 100% chance for First Aid Kit
        ));
        outputMap.put(Painkillers_4.getFormula(), Painkillers_4);
        
        Output Painkillers_5 = new Output(Item.PAINKILLERS, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.ADRENALINE, 0.5),                 // 50% chance for Adrenaline
            new OutputItem(Item.MEDKIT, 0.5)                      // 50% chance for First Aid Kit
        ));
        outputMap.put(Painkillers_5.getFormula(), Painkillers_5);
        
        //SCP Items
        // SCP-330's Candies can not be upgraded via SCP-914 and will stay on the input side if dropped.
            
        Output SCP330_1 = new Output(Item.SCP_330, RefineSetting.ROUGH, List.of( 
            OutputItem.CANNOT_BE_REFINED));
        outputMap.put(SCP330_1.getFormula(),SCP330_1);
        
        Output SCP330_2 = new Output(Item.SCP_330, RefineSetting.COARSE, List.of(
            OutputItem.CANNOT_BE_REFINED  
        ));
        outputMap.put(SCP330_2.getFormula(),SCP330_2);
        
        Output SCP330_3 = new Output(Item.SCP_330, RefineSetting.ONE_TO_ONE, List.of(
            OutputItem.CANNOT_BE_REFINED
        ));
        outputMap.put(SCP330_3.getFormula(),SCP330_3);
        
        Output SCP330_4 = new Output(Item.SCP_330, RefineSetting.FINE, List.of(
            OutputItem.CANNOT_BE_REFINED
        ));
        outputMap.put(SCP330_4.getFormula(),SCP330_4);
        
        Output SCP330_5 = new Output(Item.SCP_330, RefineSetting.VERY_FINE, List.of(             
            OutputItem.CANNOT_BE_REFINED
        ));
        outputMap.put(SCP330_5.getFormula(),SCP330_5);
        
        // SCP-018
        Output SCP018_1 = new Output(Item.SCP_018, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.GRENADE_FLASH, 1.0)             // 100% chance for Flashbang Grenade
        ));
        outputMap.put(SCP018_1.getFormula(), SCP018_1);
        
        Output SCP018_2 = new Output(Item.SCP_018, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 1.0)             // 100% chance for Flashbang Grenade
        ));
        outputMap.put(SCP018_2.getFormula(), SCP018_2);
        
        Output SCP018_3 = new Output(Item.SCP_018, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_018, 1.0)                   // 100% chance for SCP-018
        ));
        outputMap.put(SCP018_3.getFormula(), SCP018_3);
        
        Output SCP018_4 = new Output(Item.SCP_018, RefineSetting.FINE, List.of(
            new OutputItem(Item.GRENADE_HE, 1.0)    // 100% chance for High-Explosive Grenade
        ));
        outputMap.put(SCP018_4.getFormula(), SCP018_4);
        
        Output SCP018_5 = new Output(Item.SCP_018, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(SCP018_5.getFormula(), SCP018_5);
    
        // SCP-207
        Output SCP207_1 = new Output(Item.SCP_207, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)               // 100% chance for Painkillers
        ));
        outputMap.put(SCP207_1.getFormula(), SCP207_1);
        
        Output SCP207_2 = new Output(Item.SCP_207, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ADRENALINE, 1.0)                // 100% chance for Adrenaline
        ));
        outputMap.put(SCP207_2.getFormula(), SCP207_2);
        
        Output SCP207_3 = new Output(Item.SCP_207, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.ANTI_SCP_207, 1.0)                   // 100% chance for SCP-207?
        ));
        outputMap.put(SCP207_3.getFormula(), SCP207_3);
        
        Output SCP207_4 = new Output(Item.SCP_207, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_1853, 1.0)                  // 100% chance for SCP-1853
        ));
        outputMap.put(SCP207_4.getFormula(), SCP207_4);
        
        Output SCP207_5 = new Output(Item.SCP_207, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP207_5.getFormula(), SCP207_5);
    
        // Anti-SCP-207
        Output AntiSCP207_1 = new Output(Item.ANTI_SCP_207, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)               // 100% chance for Painkillers
        ));
        outputMap.put(AntiSCP207_1.getFormula(), AntiSCP207_1);
        
        Output AntiSCP207_2 = new Output(Item.ANTI_SCP_207, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ADRENALINE, 1.0)                // 100% chance for Adrenaline
        ));
        outputMap.put(AntiSCP207_2.getFormula(), AntiSCP207_2);
        
        Output AntiSCP207_3 = new Output(Item.ANTI_SCP_207, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_207, 1.0)                   // 100% chance for SCP-207
        ));
        outputMap.put(AntiSCP207_3.getFormula(), AntiSCP207_3);
        
        Output AntiSCP207_4 = new Output(Item.ANTI_SCP_207, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_1853, 1.0)                  // 100% chance for SCP-1853
        ));
        outputMap.put(AntiSCP207_4.getFormula(), AntiSCP207_4);
        
        Output AntiSCP207_5 = new Output(Item.ANTI_SCP_207, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(AntiSCP207_5.getFormula(), AntiSCP207_5);
    
        // SCP-244-A
        Output SCP244A_1 = new Output(Item.SCP_244A, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP244A_1.getFormula(), SCP244A_1);
        
        Output SCP244A_2 = new Output(Item.SCP_244A, RefineSetting.COARSE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(SCP244A_2.getFormula(), SCP244A_2);
        
        Output SCP244A_3 = new Output(Item.SCP_244A, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_244B, 1.0)                  // 100% chance for SCP-244-B
        ));
        outputMap.put(SCP244A_3.getFormula(), SCP244A_3);
        
        Output SCP244A_4 = new Output(Item.SCP_244A, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_244A, 1.0)                  // 100% chance for SCP-244-A
        ));
        outputMap.put(SCP244A_4.getFormula(), SCP244A_4);
        
        Output SCP244A_5 = new Output(Item.SCP_244A, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.SCP_244A, 1.0)                  // 100% chance for SCP-244-A
        ));
        outputMap.put(SCP244A_5.getFormula(), SCP244A_5);
    
        // SCP-244-B
        Output SCP244B_1 = new Output(Item.SCP_244B, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP244B_1.getFormula(), SCP244B_1);
        
        Output SCP244B_2 = new Output(Item.SCP_244B, RefineSetting.COARSE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(SCP244B_2.getFormula(), SCP244B_2);
        
        Output SCP244B_3 = new Output(Item.SCP_244B, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_244A, 1.0)                  // 100% chance for SCP-244-A
        ));
        outputMap.put(SCP244B_3.getFormula(), SCP244B_3);
        
        Output SCP244B_4 = new Output(Item.SCP_244B, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_244B, 1.0)                  // 100% chance for SCP-244-B
        ));
        outputMap.put(SCP244B_4.getFormula(), SCP244B_4);
        
        Output SCP244B_5 = new Output(Item.SCP_244B, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.SCP_244B, 1.0)                  // 100% chance for SCP-244-B
        ));
        outputMap.put(SCP244B_5.getFormula(), SCP244B_5);
        
        // SCP-268
        Output SCP268_1 = new Output(Item.SCP_268, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP268_1.getFormula(), SCP268_1);
        
        Output SCP268_2 = new Output(Item.SCP_268, RefineSetting.COARSE, List.of(
            new OutputItem(Item.SCP_268, 1.0)                   // 100% chance for SCP-268
        ));
        outputMap.put(SCP268_2.getFormula(), SCP268_2);
        
        Output SCP268_3 = new Output(Item.SCP_268, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_268, 1.0)                   // 100% chance for SCP-268
        ));
        outputMap.put(SCP268_3.getFormula(), SCP268_3);
        
        Output SCP268_4 = new Output(Item.SCP_268, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_268, 1.0)                   // 100% chance for SCP-268
        ));
        outputMap.put(SCP268_4.getFormula(), SCP268_4);
        
        Output SCP268_5 = new Output(Item.SCP_268, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.SCP_268, 1.0)                   // 100% chance for SCP-268
        ));
        outputMap.put(SCP268_5.getFormula(), SCP268_5);
    
        // SCP-500
        Output SCP500_1 = new Output(Item.SCP_500, RefineSetting.ROUGH, List.of(
            new OutputGroup(List.of(
                new OutputItem(Item.MEDKIT, 1.0),               // First Aid Kit
                new OutputItem(Item.PAINKILLERS, 1.0)          // Painkillers
            ), 1.0)                                            // 50% chance each
        ));
        outputMap.put(SCP500_1.getFormula(), SCP500_1);
        
        Output SCP500_2 = new Output(Item.SCP_500, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ADRENALINE, 1.0)               // 100% chance for Adrenaline
        ));
        outputMap.put(SCP500_2.getFormula(), SCP500_2);
        
        Output SCP500_3 = new Output(Item.SCP_500, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_500, 1.0)                  // 100% chance for SCP-500
        ));
        outputMap.put(SCP500_3.getFormula(), SCP500_3);
        
        Output SCP500_4 = new Output(Item.SCP_500, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),         // 50% chance for Destroyed
            new OutputItem(Item.SCP_500, 0.5)                  // 50% chance for SCP-500
        ));
        outputMap.put(SCP500_4.getFormula(), SCP500_4);
        
        Output SCP500_5 = new Output(Item.SCP_500, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)          // 100% chance for Destroyed
        ));
        outputMap.put(SCP500_5.getFormula(), SCP500_5);
        
        // SCP-1576
        Output SCP1576_1 = new Output(Item.SCP_1576, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.RADIO, 1.0)                     // 100% chance for Radio
        ));
        outputMap.put(SCP1576_1.getFormula(), SCP1576_1);
        
        Output SCP1576_2 = new Output(Item.SCP_1576, RefineSetting.COARSE, List.of(
            new OutputItem(Item.SCP_2176, 1.0)                  // 100% chance for SCP-2176
        ));
        outputMap.put(SCP1576_2.getFormula(), SCP1576_2);
        
        Output SCP1576_3 = new Output(Item.SCP_1576, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_1576, 1.0)                  // 100% chance for SCP-1576
        ));
        outputMap.put(SCP1576_3.getFormula(), SCP1576_3);
        
        Output SCP1576_4 = new Output(Item.SCP_1576, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP1576_4.getFormula(), SCP1576_4);
        
        Output SCP1576_5 = new Output(Item.SCP_1576, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(SCP1576_5.getFormula(), SCP1576_5);
    
        // SCP-1853
        Output SCP1853_1 = new Output(Item.SCP_1853, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.PAINKILLERS, 1.0)               // 100% chance for Painkillers
        ));
        outputMap.put(SCP1853_1.getFormula(), SCP1853_1);
        
        Output SCP1853_2 = new Output(Item.SCP_1853, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ADRENALINE, 1.0)                // 100% chance for Adrenaline
        ));
        outputMap.put(SCP1853_2.getFormula(), SCP1853_2);
        
        Output SCP1853_3 = new Output(Item.SCP_1853, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.SCP_1853, 1.0)                  // 100% chance for SCP-1853
        ));
        outputMap.put(SCP1853_3.getFormula(), SCP1853_3);
        
        Output SCP1853_4 = new Output(Item.SCP_1853, RefineSetting.FINE, List.of(
            new OutputItem(Item.SCP_207, 1.0)                   // 100% chance for SCP-207
        ));
        outputMap.put(SCP1853_4.getFormula(), SCP1853_4);
        
        Output SCP1853_5 = new Output(Item.SCP_1853, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),          // 50% chance for Destroyed
            new OutputItem(Item.SCP_500, 0.5)                   // 50% chance for SCP-500
        ));
        outputMap.put(SCP1853_5.getFormula(), SCP1853_5);
    
        // SCP-2176
        Output SCP2176_1 = new Output(Item.SCP_2176, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.SCP_2176_ACTIVATION, 1.0)    // 100% chance for Activates
        ));
        outputMap.put(SCP2176_1.getFormula(), SCP2176_1);
        
        Output SCP2176_2 = new Output(Item.SCP_2176, RefineSetting.COARSE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 1.0)             // 100% chance for Flashbang Grenade
        ));
        outputMap.put(SCP2176_2.getFormula(), SCP2176_2);
        
        Output SCP2176_3 = new Output(Item.SCP_2176, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.COINS, 1.0)   // 100% chance for Coin (x12)
        ));
        outputMap.put(SCP2176_3.getFormula(), SCP2176_3);
        
        Output SCP2176_4 = new Output(Item.SCP_2176, RefineSetting.FINE, List.of(
            new OutputItem(Item.GUN_COM18, 1.0)                 // 100% chance for COM-18
        ));
        outputMap.put(SCP2176_4.getFormula(), SCP2176_4);
        
        Output SCP2176_5 = new Output(Item.SCP_2176, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.FLASHLIGHT, 0.8),              // 80% chance for Flashlight
            new OutputItem(Item.GUN_E11_SR, 0.2)               // 20% chance for MTF-E11-SR
        ));
        outputMap.put(SCP2176_5.getFormula(), SCP2176_5);
    
        // Miscellaneous
        // Light Armor
        Output LightArmor_1 = new Output(Item.ARMOR_LIGHT, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),          // 50% chance for Destroyed
            new OutputItem(Item.RADIO, 0.5)                     // 50% chance for Radio
        ));
        outputMap.put(LightArmor_1.getFormula(), LightArmor_1);
        
        Output LightArmor_2 = new Output(Item.ARMOR_LIGHT, RefineSetting.COARSE, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                // 100% chance for Flashlight
        ));
        outputMap.put(LightArmor_2.getFormula(), LightArmor_2);
        
        Output LightArmor_3 = new Output(Item.ARMOR_LIGHT, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.ARMOR_LIGHT, 1.0)               // 100% chance for Light Armor
        ));
        outputMap.put(LightArmor_3.getFormula(), LightArmor_3);
        
        Output LightArmor_4 = new Output(Item.ARMOR_LIGHT, RefineSetting.FINE, List.of(
            new OutputItem(Item.ARMOR_COMBAT, 1.0)              // 100% chance for Combat Armor
        ));
        outputMap.put(LightArmor_4.getFormula(), LightArmor_4);
        
        Output LightArmor_5 = new Output(Item.ARMOR_LIGHT, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.ARMOR_COMBAT, 0.5),             // 50% chance for Combat Armor
            new OutputItem(Item.ARMOR_HEAVY, 0.5)               // 50% chance for Heavy Armor
        ));
        outputMap.put(LightArmor_5.getFormula(), LightArmor_5);
    
        // Combat Armor
        Output CombatArmor_1 = new Output(Item.ARMOR_COMBAT, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.ARMOR_LIGHT, 0.5),              // 50% chance for Light Armor
            new OutputItem(Item.FLASHLIGHT, 0.5)                // 50% chance for Flashlight
        ));
        outputMap.put(CombatArmor_1.getFormula(), CombatArmor_1);
        
        Output CombatArmor_2 = new Output(Item.ARMOR_COMBAT, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ARMOR_LIGHT, 1.0)               // 100% chance for Light Armor
        ));
        outputMap.put(CombatArmor_2.getFormula(), CombatArmor_2);
        
        Output CombatArmor_3 = new Output(Item.ARMOR_COMBAT, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.ARMOR_COMBAT, 1.0)              // 100% chance for Combat Armor
        ));
        outputMap.put(CombatArmor_3.getFormula(), CombatArmor_3);
        
        Output CombatArmor_4 = new Output(Item.ARMOR_COMBAT, RefineSetting.FINE, List.of(
            new OutputItem(Item.ARMOR_HEAVY, 1.0)               // 100% chance for Heavy Armor
        ));
        outputMap.put(CombatArmor_4.getFormula(), CombatArmor_4);
        
        Output CombatArmor_5 = new Output(Item.ARMOR_COMBAT, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.ARMOR_HEAVY, 1.0)               // 100% chance for Heavy Armor
        ));
        outputMap.put(CombatArmor_5.getFormula(), CombatArmor_5);
    
        // Heavy Armor
        Output HeavyArmor_1 = new Output(Item.ARMOR_HEAVY, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.ARMOR_LIGHT, 0.5),              // 50% chance for Light Armor
            new OutputItem(Item.ARMOR_COMBAT, 0.5)              // 50% chance for Combat Armor
        ));
        outputMap.put(HeavyArmor_1.getFormula(), HeavyArmor_1);
        
        Output HeavyArmor_2 = new Output(Item.ARMOR_HEAVY, RefineSetting.COARSE, List.of(
            new OutputItem(Item.ARMOR_COMBAT, 1.0)              // 100% chance for Combat Armor
        ));
        outputMap.put(HeavyArmor_2.getFormula(), HeavyArmor_2);
        
        Output HeavyArmor_3 = new Output(Item.ARMOR_HEAVY, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.ARMOR_HEAVY, 1.0)               // 100% chance for Heavy Armor
        ));
        outputMap.put(HeavyArmor_3.getFormula(), HeavyArmor_3);
        
        Output HeavyArmor_4 = new Output(Item.ARMOR_HEAVY, RefineSetting.FINE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(HeavyArmor_4.getFormula(), HeavyArmor_4);
        
        Output HeavyArmor_5 = new Output(Item.ARMOR_HEAVY, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(HeavyArmor_5.getFormula(), HeavyArmor_5);
        
        // Coin
        Output Coin_1 = new Output(Item.COIN, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(Coin_1.getFormula(), Coin_1);
        
        Output Coin_2 = new Output(Item.COIN, RefineSetting.COARSE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(Coin_2.getFormula(), Coin_2);
        
        Output Coin_3 = new Output(Item.COIN, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(Coin_3.getFormula(), Coin_3);
        
        Output Coin_4 = new Output(Item.COIN, RefineSetting.FINE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(Coin_4.getFormula(), Coin_4);
        
        Output Coin_5 = new Output(Item.COIN, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.COIN, 1.0)                      // 100% chance for Coin
        ));
        outputMap.put(Coin_5.getFormula(), Coin_5);
        
        // Flashlight
        Output Flashlight_1 = new Output(Item.FLASHLIGHT, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(Flashlight_1.getFormula(), Flashlight_1);
        
        Output Flashlight_2 = new Output(Item.FLASHLIGHT, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),          // 50% chance for Destroyed
            new OutputItem(Item.FLASHLIGHT, 0.5)                // 50% chance for Flashlight
        ));
        outputMap.put(Flashlight_2.getFormula(), Flashlight_2);
        
        Output Flashlight_3 = new Output(Item.FLASHLIGHT, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                // 100% chance for Flashlight
        ));
        outputMap.put(Flashlight_3.getFormula(), Flashlight_3);
        
        Output Flashlight_4 = new Output(Item.FLASHLIGHT, RefineSetting.FINE, List.of(
            new OutputItem(Item.RADIO, 1.0)                     // 100% chance for Radio
        ));
        outputMap.put(Flashlight_4.getFormula(), Flashlight_4);
        
        Output Flashlight_5 = new Output(Item.FLASHLIGHT, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 0.9),            // 90% chance for Flashbang Grenade
            new OutputItem(Item.SCP_2176, 0.1)                  // 10% chance for SCP-2176
        ));
        outputMap.put(Flashlight_5.getFormula(), Flashlight_5);
    
        // Radio
        Output Radio_1 = new Output(Item.RADIO, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(Radio_1.getFormula(), Radio_1);
        
        Output Radio_2 = new Output(Item.RADIO, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(Radio_2.getFormula(), Radio_2);
        
        Output Radio_3 = new Output(Item.RADIO, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(OutputItem.RECHARGED_RADIO, 1.0) // 100% chance for Radio (Recharged)
        ));
        outputMap.put(Radio_3.getFormula(), Radio_3);
        
        Output Radio_4 = new Output(Item.RADIO, RefineSetting.FINE, List.of(
            new OutputItem(OutputItem.RECHARGED_RADIO, 1.0) // 100% chance for Radio (Recharged)
        ));
        outputMap.put(Radio_4.getFormula(), Radio_4);
        
        Output Radio_5 = new Output(Item.RADIO, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.FLASHLIGHT, 0.75),              // 75% chance for Flashlight
            new OutputItem(Item.SCP_1576, 0.25)                 // 25% chance for SCP-1576
        ));
        outputMap.put(Radio_5.getFormula(), Radio_5);
        
        // Remote Admin Only Items
        // Containment Engineer Keycard
        Output ContainmentEngineer_1 = new Output(Item.KEYCARD_CONTAINMENT_ENGINEER, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_SCIENTIST, 0.5),         // 50% chance for Scientist Keycard
            new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 0.5) // 50% chance for Research Supervisor Keycard
        ));
        outputMap.put(ContainmentEngineer_1.getFormula(), ContainmentEngineer_1);
        
        Output ContainmentEngineer_2 = new Output(Item.KEYCARD_CONTAINMENT_ENGINEER, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 1.0) // 100% chance for Research Supervisor Keycard
        ));
        outputMap.put(ContainmentEngineer_2.getFormula(), ContainmentEngineer_2);
        
        Output ContainmentEngineer_3 = new Output(Item.KEYCARD_CONTAINMENT_ENGINEER, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_FACILITY_MANAGER, 1.0)  // 100% chance for Facility Manager Keycard
        ));
        outputMap.put(ContainmentEngineer_3.getFormula(), ContainmentEngineer_3);
        
        Output ContainmentEngineer_4 = new Output(Item.KEYCARD_CONTAINMENT_ENGINEER, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 0.5),          // 50% chance for Captain Keycard
            new OutputItem(Item.KEYCARD_O5, 0.5)                // 50% chance for O5 Keycard
        ));
        outputMap.put(ContainmentEngineer_4.getFormula(), ContainmentEngineer_4);
        
        Output ContainmentEngineer_5 = new Output(Item.KEYCARD_CONTAINMENT_ENGINEER, RefineSetting.VERY_FINE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.33),         // 33% chance for Destroyed
            new OutputItem(Item.KEYCARD_O5, 0.66)               // 66% chance for O5 Keycard
        ));
        outputMap.put(ContainmentEngineer_5.getFormula(), ContainmentEngineer_5);
    
        // Private Keycard
        Output PrivateKeycard_1 = new Output(Item.KEYCARD_MTF_PRIVATE, RefineSetting.ROUGH, List.of(
            new OutputItem(Item.KEYCARD_SCIENTIST, 0.5),          // 50% chance for Scientist Keycard
            new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 0.5) // 50% chance for Research Supervisor Keycard
        ));
        outputMap.put(PrivateKeycard_1.getFormula(), PrivateKeycard_1);
        
        Output PrivateKeycard_2 = new Output(Item.KEYCARD_MTF_PRIVATE, RefineSetting.COARSE, List.of(
            new OutputItem(Item.KEYCARD_RESEARCH_SUPERVISOR, 1.0) // 100% chance for Research Supervisor Keycard
        ));
        outputMap.put(PrivateKeycard_2.getFormula(), PrivateKeycard_2);
        
        Output PrivateKeycard_3 = new Output(Item.KEYCARD_MTF_PRIVATE, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.KEYCARD_CONTAINMENT_ENGINEER, 1.0) // 100% chance for Containment Engineer Keycard
        ));
        outputMap.put(PrivateKeycard_3.getFormula(), PrivateKeycard_3);
        
        Output PrivateKeycard_4 = new Output(Item.KEYCARD_MTF_PRIVATE, RefineSetting.FINE, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 1.0)          // 100% chance for Operative Keycard
        ));
        outputMap.put(PrivateKeycard_4.getFormula(), PrivateKeycard_4);
        
        Output PrivateKeycard_5 = new Output(Item.KEYCARD_MTF_PRIVATE, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.KEYCARD_MTF_OPERATIVE, 0.5),         // 50% chance for Operative Keycard
            new OutputItem(Item.KEYCARD_MTF_CAPTAIN, 0.5)           // 50% chance for Captain Keycard
        ));
        outputMap.put(PrivateKeycard_5.getFormula(), PrivateKeycard_5);
    
        // Lantern
        Output Lantern_1 = new Output(Item.LANTERN, RefineSetting.ROUGH, List.of(
            new OutputItem(OutputItem.DESTROYED, 1.0)           // 100% chance for Destroyed
        ));
        outputMap.put(Lantern_1.getFormula(), Lantern_1);
        
        Output Lantern_2 = new Output(Item.LANTERN, RefineSetting.COARSE, List.of(
            new OutputItem(OutputItem.DESTROYED, 0.5),          // 50% chance for Destroyed
            new OutputItem(Item.LANTERN, 0.5)                   // 50% chance for Lantern
        ));
        outputMap.put(Lantern_2.getFormula(), Lantern_2);
        
        Output Lantern_3 = new Output(Item.LANTERN, RefineSetting.ONE_TO_ONE, List.of(
            new OutputItem(Item.FLASHLIGHT, 1.0)                // 100% chance for Flashlight
        ));
        outputMap.put(Lantern_3.getFormula(), Lantern_3);
        
        Output Lantern_4 = new Output(Item.LANTERN, RefineSetting.FINE, List.of(
            new OutputItem(Item.RADIO, 1.0)                     // 100% chance for Radio
        ));
        outputMap.put(Lantern_4.getFormula(), Lantern_4);
        
        Output Lantern_5 = new Output(Item.LANTERN, RefineSetting.VERY_FINE, List.of(
            new OutputItem(Item.GRENADE_FLASH, 0.9),            // 90% chance for Flashbang Grenade
            new OutputItem(Item.SCP_2176, 0.1)                  // 10% chance for SCP-2176
        ));
        outputMap.put(Lantern_5.getFormula(), Lantern_5);
        
        //thats 275 combinations of 55 items and 5 settings. Wow!

    }

    /**
     * Retrieves the output items for a given refinement formula.
     * @param formula The formula representing an input item and setting.
     * @return The corresponding output items.
     */
    public static Output getOutputItems(String formula) {
        return outputMap.get(formula);
    }
}   
