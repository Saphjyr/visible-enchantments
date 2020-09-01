package net.fabricmc.venchants;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class GetColor {
    // using https://www.colorspire.com/rgb-color-wheel/
    // private int BLACK = 0x000000;
    // private int ALMOSTBLACK = 0xC40EFC;
    private static int WHITE = 0xFFFFFF;
    private static int GOLD = 0xDB8300;// E4C45B
    private static int PURPLE = 0x1A0DD5;
    private static int BLUE = 0x00FFDE;// 0x00DB07
    private static int GREEN = 0x52A400;

    // tintIndex is the layer to wich the color provider is applied
    public static int getToolColor(int tintIndex, int ttl, int efficiencyl, int fortunel) {
        if (tintIndex == 1) {
            if (ttl == 5)
                return GOLD;
            if (ttl == 4)
                return PURPLE;
            if (ttl == 3)
                return BLUE;
            if (ttl == 2)
                return GREEN;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (efficiencyl == 5)
                return GOLD;
            if (efficiencyl == 4)
                return PURPLE;
            if (efficiencyl == 3)
                return BLUE;
            if (efficiencyl == 2)
                return GREEN;
            else
                return WHITE;
        } else if (tintIndex == 3) {
            if (fortunel == 3)
                return GOLD;
            if (fortunel == 2)
                return BLUE;
            else
                return WHITE;
        } else
            return WHITE;
    }

    public static int getSwordColor(int tintIndex, int tl, int fl, int ll, int kl) {
        if (tintIndex == 1) {
            if (tl == 5)
                return GOLD;
            if (tl == 4)
                return PURPLE;
            if (tl == 3)
                return BLUE;
            if (tl == 2)
                return GREEN;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (fl == 2)
                return GOLD;
            if (fl == 1)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3) {
            if (ll == 3)
                return GOLD;
            if (ll == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 4) {
            if (kl == 2)
                return GOLD;
            if (kl == 1)
                return BLUE;
            else
                return WHITE;
        } else
            return WHITE;

    }

    public static int getArmorColor(int tintIndex, int protectionl, int thornsl) {
        if (tintIndex == 1) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (thornsl == 3)
                return GOLD;
            if (thornsl == 2)
                return BLUE;
            else
                return WHITE;
        }

        else
            return WHITE;
    }

    public static int getHelmetColor(int tintIndex, int protectionl, int thornsl, int respirationl) {
        if (tintIndex == 1) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (thornsl == 3)
                return GOLD;
            if (thornsl == 2)
                return BLUE;
            else
                return WHITE;

        } else if (tintIndex == 3) {
            if (respirationl == 3)
                return GOLD;
            if (respirationl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 4)
            return GOLD;
        else
            return WHITE;
    }

    public static int getBootColor(int tintIndex, int protectionl, int thornsl, int frostl, int featherl) {
        if (tintIndex == 1) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (thornsl == 3)
                return GOLD;
            if (thornsl == 2)
                return BLUE;
            else
                return WHITE;

        } else if (tintIndex == 3) {
            if (frostl == 3)
                return GOLD;
            if (frostl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 4) {
            if (featherl == 4)
                return GOLD;
            if (featherl == 3)
                return PURPLE;
            if (featherl == 2)
                return BLUE;
            else
                return WHITE;
        } else
            return WHITE;
    }

    public static int getBowColor(int tintIndex, int powerl, int punchl) {
        if (tintIndex == 1) {
            if (powerl == 5)
                return GOLD;
            if (powerl == 4)
                return PURPLE;
            if (powerl == 3)
                return BLUE;
            if (powerl == 2)
                return GREEN;
            else
                return WHITE;
        } else if (tintIndex == 2)
            return GOLD;
        else if (tintIndex == 3)
            return GOLD;
        else if (tintIndex == 4) {
            if (punchl == 2)
                return GOLD;
            else
                return WHITE;
        } else
            return WHITE;
    }

    public static int getRodColor(int tintIndex, int lurel, int lotsl) {
        if (tintIndex == 1) {
            if (lurel == 3)
                return GOLD;
            if (lurel == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (lotsl == 3)
                return GOLD;
            if (lotsl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3)
            return GOLD;
        else
            return WHITE;
    }

    public static int getTridentColor(int tintIndex, int impalingl, int loyaltyl) {
        if (tintIndex == 1) {
            if (impalingl == 5)
                return GOLD;
            if (impalingl == 4)
                return PURPLE;
            if (impalingl == 3)
                return BLUE;
            if (impalingl == 2)
                return GREEN;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (loyaltyl == 3)
                return GOLD;
            if (loyaltyl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3)
            return GOLD;
        else
            return WHITE;
    }

    public static int getCrossbowColor(int tintIndex, int quickl, int piercingl) {
        if (tintIndex == 1) {
            if (quickl == 3)
                return GOLD;
            if (quickl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 2) {
            if (piercingl == 4)
                return GOLD;
            if (piercingl == 3)
                return PURPLE;
            if (piercingl == 2)
                return BLUE;
            else
                return WHITE;
        } else
            return WHITE;
    }

    public static int getLeatherHelmetColor(int tintIndex, int protectionl, int respirationl) {
        if (tintIndex == 2) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3) {
            if (respirationl == 3)
                return GOLD;
            if (respirationl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 4)
            return GOLD;
        else
            return WHITE;
    }

    public static int getLeatherBootColor(int tintIndex, int protectionl, int frostl, int featherl) {
        if (tintIndex == 2) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3) {
            if (frostl == 3)
                return GOLD;
            if (frostl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 4) {
            if (featherl == 4)
                return GOLD;
            if (featherl == 3)
                return PURPLE;
            if (featherl == 2)
                return BLUE;
            else
                return WHITE;
        } else
            return WHITE;
    }

    public static int getLeatherArmorColor(int tintIndex, int protectionl, int thornsl) {
        if (tintIndex == 2) {
            if (protectionl == 4)
                return GOLD;
            if (protectionl == 3)
                return PURPLE;
            if (protectionl == 2)
                return BLUE;
            else
                return WHITE;
        } else if (tintIndex == 3) {
            if (thornsl == 3)
                return GOLD;
            if (thornsl == 2)
                return BLUE;
            else
                return WHITE;
        }

        else
            return WHITE;

    }

    public static int getDyedColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getSubTag("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 10511680;
    }
    
}