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

public class TridentVenchants {
    public static void RegisterTrident() {
        //Trident
        /* Structure of the TridentEnchant provider : ilc
        * impaling : HasImpaling
        * loyalty : HasLoyalty (2=HasRiptide)
        * channeling : HasChanneling
        */
        FabricModelPredicateProviderRegistry.register(Items.TRIDENT, 
                new Identifier("venchants","tridentenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                    String impaling = "0"; String loyalty = "0"; String channeling = "0";
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                    if (enchants.isEmpty()) return 42;
                    if (enchants.containsKey(Enchantments.IMPALING)) impaling = "1";
                    if (enchants.containsKey(Enchantments.LOYALTY)) loyalty = "1";
                    if (enchants.containsKey(Enchantments.RIPTIDE)) loyalty = "2";
                    if (enchants.containsKey(Enchantments.CHANNELING)) channeling = "1";
                    return Integer.parseInt("1"+impaling+loyalty+channeling);
                }
                ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
            int impalingl = 0; // Impaling level, used by the colorprovider
            int loyaltyl = 0; // Loyalty or Riptide level
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.IMPALING)) impalingl = enchants.get(Enchantments.IMPALING);
            if (enchants.containsKey(Enchantments.LOYALTY)) loyaltyl = enchants.get(Enchantments.LOYALTY);
            if (enchants.containsKey(Enchantments.RIPTIDE)) loyaltyl = enchants.get(Enchantments.RIPTIDE);
            int Ibaj1 = impalingl; int Ibaj2 = loyaltyl;
            return GetColor.getTridentColor(tintIndex,Ibaj1,Ibaj2);
        } else return -1;}, Items.TRIDENT);
    }
    
}