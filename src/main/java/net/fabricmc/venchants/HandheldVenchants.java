package net.fabricmc.venchants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class HandheldVenchants {
    public static void RegisterSwords() {
        
    
        //Swords
        //List of all swords
        List<Item> SwordItems = Arrays.asList(
        Items.NETHERITE_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, Items.IRON_SWORD, Items.STONE_SWORD, Items.WOODEN_SWORD);

       /* Structure of the SwordEnchant provider : tflk
        * 
        * t : Sharpness type 0=None 1=Sharpness 2=Smite 3=BaneOfArthropods, tl = level (layer 1)
        * f = hasFireaspect, fl = level (Layer2)
        * l = hasLooting, ll = level (layer3)
        * k = hasKnockback, kl = level (Layer4)
        */
        
        for (Item entry : SwordItems){
            FabricModelPredicateProviderRegistry.register(entry, 
            new Identifier("venchants","swordenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String t = "0"; String f = "0" ; String l = "0" ; String k = "0" ;
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BANE_OF_ARTHROPODS)) t= "3";
                if (enchants.containsKey(Enchantments.SMITE)) t= "2";
                if (enchants.containsKey(Enchantments.SHARPNESS)) t= "1";
                if (enchants.containsKey(Enchantments.FIRE_ASPECT)) f= "1";
                if (enchants.containsKey(Enchantments.LOOTING)) l= "1";
                if (enchants.containsKey(Enchantments.KNOCKBACK)) k= "1";
                return Integer.parseInt("1"+t+f+l+k);
                
                }
            
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
                int tl = 0; int fl = 0; int ll = 0; int kl = 0;
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BANE_OF_ARTHROPODS)) tl = enchants.get(Enchantments.BANE_OF_ARTHROPODS);
                if (enchants.containsKey(Enchantments.SMITE)) tl = enchants.get(Enchantments.SMITE);
                if (enchants.containsKey(Enchantments.SHARPNESS)) tl = enchants.get(Enchantments.SHARPNESS);
                if (enchants.containsKey(Enchantments.FIRE_ASPECT)) fl = enchants.get(Enchantments.FIRE_ASPECT);
                if (enchants.containsKey(Enchantments.LOOTING)) ll = enchants.get(Enchantments.LOOTING);
                if (enchants.containsKey(Enchantments.KNOCKBACK)) kl = enchants.get(Enchantments.KNOCKBACK);
                int ibaj1 = tl; int ibaj2 = fl; int ibaj3 = ll; int ibaj4 = kl;
                return GetColor.getSwordColor(tintIndex,ibaj1,ibaj2,ibaj3,ibaj4);
            } else return -1;}, entry);
            

        }
    }
    
    public static void RegisterTools() {
        //List of all Tools
        List<Item> ToolItems = Arrays.asList(
        Items.NETHERITE_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLDEN_PICKAXE, Items.IRON_PICKAXE, Items.STONE_PICKAXE, Items.WOODEN_PICKAXE,
        Items.NETHERITE_SHOVEL, Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL, Items.IRON_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL,
        Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE,
        Items.NETHERITE_HOE, Items.DIAMOND_HOE, Items.GOLDEN_HOE, Items.IRON_HOE, Items.STONE_HOE, Items.WOODEN_HOE,
        Items.SHEARS);

       /* Structure of the ToolEnchant provider : tflk
        * 
        * tt : Sharpness type 0=None 1=Sharpness 2=Smite 3=BaneOfArthropods, tl = level (layer 1) (Naturaly only on axes)
        * efficiency = hasEfficiency, fl = level (Layer2)
        * fortune = 0=None 1=Fortune 2=SilkTouch
        */
        
        for (Item entry : ToolItems){
            FabricModelPredicateProviderRegistry.register(entry, 
            new Identifier("venchants","toolenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String tt = "0"; String efficiency = "0" ; String fortune = "0" ;
                
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BANE_OF_ARTHROPODS)) tt= "3";
                if (enchants.containsKey(Enchantments.SMITE)) tt= "2";
                if (enchants.containsKey(Enchantments.SHARPNESS)) tt= "1";
                if (enchants.containsKey(Enchantments.EFFICIENCY)) efficiency= "1";
                if (enchants.containsKey(Enchantments.FORTUNE)) fortune= "1";
                if (enchants.containsKey(Enchantments.SILK_TOUCH)) fortune= "2";
                return Integer.parseInt("1"+tt+efficiency+fortune);
                
                }
            
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
                int ttl = 0; int efficiencyl = 0; int fortunel = 0;
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BANE_OF_ARTHROPODS)) ttl = enchants.get(Enchantments.BANE_OF_ARTHROPODS);
                if (enchants.containsKey(Enchantments.SMITE)) ttl = enchants.get(Enchantments.SMITE);
                if (enchants.containsKey(Enchantments.SHARPNESS)) ttl = enchants.get(Enchantments.SHARPNESS);
                if (enchants.containsKey(Enchantments.EFFICIENCY)) efficiencyl = enchants.get(Enchantments.EFFICIENCY);
                if (enchants.containsKey(Enchantments.FORTUNE)) fortunel = enchants.get(Enchantments.FORTUNE);
                if (enchants.containsKey(Enchantments.SILK_TOUCH)) fortunel = 3;
                int ibaj1 = ttl; int ibaj2 = efficiencyl; int ibaj3 = fortunel;
                return GetColor.getToolColor(tintIndex,ibaj1,ibaj2,ibaj3);
            } else return -1;}, entry);
        }

    }
}