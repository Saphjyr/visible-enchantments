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


//Leather stuff is separated because the game already use layer1 if it is tinted
//That is why thorns is not displayed on leather helmets and leather boots

// Helmets
/* Structure of the HelmetEnchant provider : 1ptra
* p : Protection type : 0=None 1=Protection 2=Projectileprotection 3=FireProtection 4=Blastprotection
* t : HasTorns
* r : HasRespiration
* a : HasAquaAffinity
*/

// Boot, provider : bootenchant
/* Structure of the BootEnchant provider : 1ptff
* p : Protection type : 0=None 1=Protection 2=Projectileprotection 3=FireProtection 4=Blastprotection
* t : HasTorns
* frost : 0=none 1=frostwalker 2=DepthStrider
* feather : 0=None 1=FeatherFalling 2=SoulSpeed 3 = Both
*/

//Armor, provider : armorenchant
/* Structure of the ArmorEnchant provider : 1pt
* p : Protection type : 0=None 1=Protection 2=Projectileprotection 3=FireProtection 4=Blastprotection
* t : 0=Thorns 1=HasTorns
*/

public class ArmorVenchants {
    public static void RegisterLeatherHelmet() {
        Item entry = Items.LEATHER_HELMET;
        FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","leatherhelmetenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
            String p = "0"; String r = "0"; String a = "0";
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.isEmpty()) return 42;
            if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
            if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
            if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
            if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
            if (enchants.containsKey(Enchantments.RESPIRATION))  r = "1";
            if (enchants.containsKey(Enchantments.AQUA_AFFINITY))  a = "1";
            return Integer.parseInt(("1"+p+r+a));
            }
        ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0) return GetColor.getDyedColor(stack);
            else if (tintIndex > 1) {  
            int protectionl = 0; // Protection type, used by the colorprovider
            int respirationl = 0; //Respiration level
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
            if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
            if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
            if (enchants.containsKey(Enchantments.RESPIRATION)) respirationl = enchants.get(Enchantments.RESPIRATION);
            int Imbadatjava1 = protectionl; int Imbadatjava2 = respirationl;
            return GetColor.getLeatherHelmetColor(tintIndex,Imbadatjava1,Imbadatjava2);
        } else return -1;}, entry);
    }

    public static void RegisterLeatherBoot() {
        Item entry = Items.LEATHER_BOOTS;
        FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","leatherbootenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
            String p = "0"; String frost = "0"; String feather = "0";
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.isEmpty()) return 42;
            if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
            if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
            if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
            if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
            if (enchants.containsKey(Enchantments.FROST_WALKER))  frost = "1";
            if (enchants.containsKey(Enchantments.DEPTH_STRIDER))  frost = "2";
            if (enchants.containsKey(Enchantments.FEATHER_FALLING))  feather = "1";
            if (enchants.containsKey(Enchantments.SOUL_SPEED)) {if (feather == "1") feather = "3"; else feather = "2";};
            return Integer.parseInt(("1"+p+frost+feather));
            }
        ));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0) return GetColor.getDyedColor(stack);
            else if (tintIndex > 1) {  
            int protectionl = 0; // Protection type, used by the colorprovider
            int frostl = 0;
            int featherl = 0;
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
            if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
            if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
            if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
            if (enchants.containsKey(Enchantments.PROTECTION)) protectionl = enchants.get(Enchantments.PROTECTION);
            if (enchants.containsKey(Enchantments.FROST_WALKER)) frostl = enchants.get(Enchantments.FROST_WALKER);
            if (enchants.containsKey(Enchantments.DEPTH_STRIDER)) frostl = enchants.get(Enchantments.DEPTH_STRIDER);
            if (enchants.containsKey(Enchantments.FEATHER_FALLING)) featherl = enchants.get(Enchantments.FEATHER_FALLING);
            if (enchants.containsKey(Enchantments.SOUL_SPEED)) featherl = enchants.get(Enchantments.SOUL_SPEED);
            int Imbadatjava1 = protectionl; int Imbadatjava2 = frostl; int Imbadatjava3 = featherl;
            return GetColor.getLeatherBootColor(tintIndex,Imbadatjava1,Imbadatjava2, Imbadatjava3);
        } else return -1;}, entry);
        
    }

    public static void RegisterLeatherArmor() {
        List<Item> LeatherArmorItems = Arrays.asList(Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS);
        for (Item entry : LeatherArmorItems){ 
            FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","leatherarmorenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String p = "0"; String t = "0";
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
                if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
                if (enchants.containsKey(Enchantments.THORNS))  t = "1";
                return Integer.parseInt(("1"+p+t));
                }
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                if (tintIndex == 0) return GetColor.getDyedColor(stack);
                else if (tintIndex > 1) {  
                int protectionl = 0; // Protection type, used by the colorprovider
                int thornsl = 0; // Thorns level
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROTECTION)) protectionl = enchants.get(Enchantments.PROTECTION);
                if (enchants.containsKey(Enchantments.THORNS)) thornsl = enchants.get(Enchantments.THORNS);
                int Imbadatjava1 = protectionl; int Imbadatjava2 = thornsl;
                return GetColor.getLeatherArmorColor(tintIndex,Imbadatjava1,Imbadatjava2);
            } else return -1;}, entry);  
        }
        
    }

    public static void RegisterHelmet() {
        List<Item> HelmetItems = Arrays.asList(Items.NETHERITE_HELMET, Items.DIAMOND_HELMET, Items.GOLDEN_HELMET, Items.IRON_HELMET, Items.CHAINMAIL_HELMET, Items.TURTLE_HELMET);
        for (Item entry : HelmetItems){ 
            FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","helmetenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String p = "0"; String t = "0"; String r = "0"; String a = "0";
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
                if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
                if (enchants.containsKey(Enchantments.THORNS))  t = "1";
                if (enchants.containsKey(Enchantments.RESPIRATION))  r = "1";
                if (enchants.containsKey(Enchantments.AQUA_AFFINITY))  a = "1";
                return Integer.parseInt(("1"+p+t+r+a));
                }
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
                int protectionl = 0; // Protection type, used by the colorprovider
                int thornsl = 0; // Thorns level
                int respirationl = 0; //Respiration level
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROTECTION)) protectionl = enchants.get(Enchantments.PROTECTION);
                if (enchants.containsKey(Enchantments.THORNS)) thornsl = enchants.get(Enchantments.THORNS);
                if (enchants.containsKey(Enchantments.RESPIRATION)) respirationl = enchants.get(Enchantments.RESPIRATION);
                int Imbadatjava1 = protectionl; int Imbadatjava2 = thornsl; int Imbadatjava3 = respirationl;
                return GetColor.getHelmetColor(tintIndex,Imbadatjava1,Imbadatjava2, Imbadatjava3);
            } else return -1;}, entry);  
        }
    }
    public static void RegisterBoot() {
        List<Item> BootItems = Arrays.asList(Items.NETHERITE_BOOTS, Items.DIAMOND_BOOTS, Items.GOLDEN_BOOTS, Items.IRON_BOOTS, Items.CHAINMAIL_BOOTS);
        for (Item entry : BootItems){ 
            FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","bootenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String p = "0"; String t = "0"; String frost = "0"; String feather = "0";
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
                if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
                if (enchants.containsKey(Enchantments.THORNS))  t = "1";
                if (enchants.containsKey(Enchantments.FROST_WALKER))  frost = "1";
                if (enchants.containsKey(Enchantments.DEPTH_STRIDER))  frost = "2";
                if (enchants.containsKey(Enchantments.FEATHER_FALLING))  feather = "1";
                if (enchants.containsKey(Enchantments.SOUL_SPEED)) {if (feather == "1") feather = "3"; else feather = "2";};
                return Integer.parseInt(("1"+p+t+frost+feather));
                }
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
                int protectionl = 0; // Protection type, used by the colorprovider
                int thornsl = 0; // Thorns level
                int frostl = 0;
                int featherl = 0;
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROTECTION)) protectionl = enchants.get(Enchantments.PROTECTION);
                if (enchants.containsKey(Enchantments.THORNS)) thornsl = enchants.get(Enchantments.THORNS);
                if (enchants.containsKey(Enchantments.FROST_WALKER)) frostl = 1+enchants.get(Enchantments.FROST_WALKER);
                if (enchants.containsKey(Enchantments.DEPTH_STRIDER)) frostl = enchants.get(Enchantments.DEPTH_STRIDER);
                if (enchants.containsKey(Enchantments.SOUL_SPEED)) featherl = 1+enchants.get(Enchantments.SOUL_SPEED);
                if (enchants.containsKey(Enchantments.FEATHER_FALLING)) featherl = enchants.get(Enchantments.FEATHER_FALLING);
                int Imbadatjava1 = protectionl; int Imbadatjava2 = thornsl; int Imbadatjava3 = frostl; int Imbadatjava4 = featherl;
                return GetColor.getBootColor(tintIndex,Imbadatjava1,Imbadatjava2, Imbadatjava3, Imbadatjava4);
            } else return -1;}, entry);  
        }
        
    }

    public static void RegisterArmor() {
        List<Item> ArmorItems = Arrays.asList(
        Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS,//Nehterite
        Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS,//Diamond
        Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS,//Golden
        Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS,//Iron
        Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_LEGGINGS//Chainmail
        );
        for (Item entry : ArmorItems){ 
            FabricModelPredicateProviderRegistry.register(entry, new Identifier("venchants","armorenchant"), (ModelPredicateProvider)((stack, world, entity) -> {
                String p = "0"; String t = "0";
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.isEmpty()) return 42;
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) p = "4";
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) p = "3";
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) p = "2";
                if (enchants.containsKey(Enchantments.PROTECTION)) p = "1";
                if (enchants.containsKey(Enchantments.THORNS))  t = "1";
                return Integer.parseInt(("1"+p+t));
                }
            ));
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {if (tintIndex > 0) {  
                int protectionl = 0; // Protection type, used by the colorprovider
                int thornsl = 0; // Thorns level
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(stack);
                if (enchants.containsKey(Enchantments.BLAST_PROTECTION)) protectionl = enchants.get(Enchantments.BLAST_PROTECTION);
                if (enchants.containsKey(Enchantments.FIRE_PROTECTION)) protectionl = enchants.get(Enchantments.FIRE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROJECTILE_PROTECTION)) protectionl = enchants.get(Enchantments.PROJECTILE_PROTECTION);
                if (enchants.containsKey(Enchantments.PROTECTION)) protectionl = enchants.get(Enchantments.PROTECTION);
                if (enchants.containsKey(Enchantments.THORNS)) thornsl = enchants.get(Enchantments.THORNS);
                int Imbadatjava1 = protectionl; int Imbadatjava2 = thornsl;
                return GetColor.getArmorColor(tintIndex,Imbadatjava1,Imbadatjava2);
            } else return -1;}, entry);  
        }
    }
}