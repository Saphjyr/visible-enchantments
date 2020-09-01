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

public class FishingRodVenchants {
    public static void RegisterFishingRod() {
        //Fishing rod
        /* Structure of the RodEnchant provider : pfip
        * lure : HasLure
        * lots : HasLuckoftheSea
        * mending : HasMending
        */
        FabricModelPredicateProviderRegistry.register(Items.FISHING_ROD, 
                new Identifier("venchants","rodenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                    String lure = "0"; String lots = "0"; String mending = "0";
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                    if (enchants.isEmpty()) return 42;
                    if (enchants.containsKey(Enchantments.LURE)) lure = "1";
                    if (enchants.containsKey(Enchantments.LUCK_OF_THE_SEA)) lots = "1";
                    if (enchants.containsKey(Enchantments.MENDING)) mending = "1";
                    return Integer.parseInt("1"+lure+lots+mending);
                }
                ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
            
            int lurel = 0; // Lure level, used by the colorprovider
            int lotsl = 0; // LotS level
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.LURE)) lurel = enchants.get(Enchantments.LURE);
            if (enchants.containsKey(Enchantments.LUCK_OF_THE_SEA)) lotsl = enchants.get(Enchantments.LUCK_OF_THE_SEA);
            int Ibaj1 = lurel; int Ibaj2 = lotsl;
            return GetColor.getRodColor(tintIndex,Ibaj1,Ibaj2);
        } else return -1;}, Items.FISHING_ROD);
    }
}