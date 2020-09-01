package net.fabricmc.venchants;

import java.util.Map;


import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ProjectilethrowerVenchants {
    public static void RegistrerBow() {
        //Bow
        /* Structure of the BowEnchant provider : pfip
        * power : HasPower
        * flame : HasFlame
        * infinity : 0=NoInfinity 1=Infinity 2=Mending
        * punch = HasPunch
        */
        FabricModelPredicateProviderRegistry.register(Items.BOW, 
                new Identifier("venchants","bowenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                    String power = "0"; String flame = "0"; String infinity = "0"; String punch = "0";
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                    if (enchants.isEmpty()) return 42;
                    if (enchants.containsKey(Enchantments.POWER)) power = "1";
                    if (enchants.containsKey(Enchantments.FLAME))   flame = "1";
                    if (enchants.containsKey(Enchantments.MENDING))  infinity = "2";
                    if (enchants.containsKey(Enchantments.INFINITY)) infinity = "1";
                    if (enchants.containsKey(Enchantments.PUNCH)) punch = "1";
                    return Integer.parseInt("1"+power+flame+infinity+punch);
                }
                ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
            int powerl = 0; // Powerlevel, used by the colorprovider
            int punchl = 0; // Punch level
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.POWER)) powerl = enchants.get(Enchantments.POWER);
            if (enchants.containsKey(Enchantments.PUNCH)) punchl = enchants.get(Enchantments.PUNCH);
            int Ibaj1 = powerl; int Ibaj2 = punchl;
            return GetColor.getBowColor(tintIndex,Ibaj1,Ibaj2);
        } else return -1;}, Items.BOW);
        
    }

    public static void RegisterCrossbow() {
        //Crossbow
        /* Structure of the CrossbowEnchant provider : qp
        * quick : HasQuickchage
        * piercing : HasPiercing (2=HasMultishot)
        */
        FabricModelPredicateProviderRegistry.register(Items.CROSSBOW, 
                new Identifier("venchants","crossbowenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                    String quick = "0"; String piercing = "0";
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                    if (enchants.isEmpty()) return 42;
                    if (enchants.containsKey(Enchantments.QUICK_CHARGE)) quick = "1";
                    if (enchants.containsKey(Enchantments.PIERCING)) piercing = "1";
                    if (enchants.containsKey(Enchantments.MULTISHOT)) piercing = "2";
                    return Integer.parseInt("1"+quick+piercing);
                }
                ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
            int quickl = 0; // Quickcharge level, used by the colorprovider
            int piercingl = 0; // Piercing or 4 if multishot
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.QUICK_CHARGE)) quickl = enchants.get(Enchantments.QUICK_CHARGE);
            if (enchants.containsKey(Enchantments.PIERCING)) piercingl = enchants.get(Enchantments.PIERCING);
            if (enchants.containsKey(Enchantments.MULTISHOT)) piercingl = 4;
            int Ibaj1 = quickl; int Ibaj2 = piercingl;
            return GetColor.getCrossbowColor(tintIndex,Ibaj1,Ibaj2);
        } else return -1;}, Items.CROSSBOW);
    }
    
}