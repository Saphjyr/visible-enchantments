package net.fabricmc.venchants;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;


public class venchantsMod implements ModInitializer
{
    
    @Environment(EnvType.CLIENT)
    @Override
    public void onInitialize() 
    {
        ArmorVenchants.RegisterLeatherHelmet();
        ArmorVenchants.RegisterLeatherBoot();
        ArmorVenchants.RegisterLeatherArmor();
        ArmorVenchants.RegisterHelmet();
        ArmorVenchants.RegisterBoot();
        ArmorVenchants.RegisterArmor();
        
        HandheldVenchants.RegisterSwords();
        HandheldVenchants.RegisterTools();
       
        ProjectilethrowerVenchants.RegistrerBow();
        ProjectilethrowerVenchants.RegisterCrossbow();

        FishingRodVenchants.RegisterFishingRod();
        
        TridentVenchants.RegisterTrident();  
    }
    
}
    
