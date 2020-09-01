MINECRAFTPATH = "VEnchants\\generate assets\\assets\\minecraft\\models\\item"
VENCHANTSPATH = "VEnchants\\generate assets\\assets\\venchants\\models\\item"

def generate_assets():
    return [generate_armor_assets(), generate_bow_assets(), generate_sword_assets(), generate_tool_assets(), generate_rod_assets(), generate_trident_assets(), generate_crossbow_assets()]


A = ["netherite_helmet", "netherite_chestplate", "netherite_leggings", "netherite_boots",
    "diamond_helmet", "diamond_chestplate", "diamond_leggings", "diamond_boots",
    "golden_helmet", "golden_chestplate", "golden_leggings", "golden_boots",
    "iron_helmet", "iron_chestplate", "iron_leggings", "iron_boots",
    "chainmail_helmet", "chainmail_chestplate", "chainmail_leggings", "chainmail_boots",
    "turtle_helmet"]

def generate_armor_assets() :
    #Leather Stuff : specific layer1
    #Leather Helmet
    for item in ["leather_helmet"] :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\",\r\n    \"layer1\": \"minecraft:item/" + item + "_overlay" + "\"  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for respiration in range(0,2):
                for aqua in range(0,2):
                    p = protection; r = respiration; a = aqua
                    text +="{ \"predicate\": {\"venchants:leatherhelmetenchant\": 1"+str(p)+str(r)+str(a)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(r)+str(a)+"\" },\r    "
                    g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(r)+str(a)+".json","w")
                    text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"minecraft:item/" + item + "_overlay" + "\",\r\t  \"layer2\": \"venchants:item/protection" + str(p) +"\",\r\t  \"layer3\": \"venchants:item/respiration"+str(r)+"\",\r\t  \"layer4\": \"venchants:item/aqua"+str(a)+"\"\r    }\r}    "
                    g.write(text2)
                    g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close
    #Leather Boots
    for item in ["leather_boots"] :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\",\r\n    \"layer1\": \"minecraft:item/" + item + "_overlay" + "\"  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for frost in range(0,3):
                for feather in range(0,4):
                    p = protection; fr = frost; fe = feather
                    text +="{ \"predicate\": {\"venchants:leatherbootenchant\": 1"+str(p)+str(fr)+str(fe)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(fr)+str(fe)+"\" },\r    "
                    g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(fr)+str(fe)+".json","w")
                    text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"minecraft:item/" + item + "_overlay" + "\",\r\t  \"layer2\": \"venchants:item/protection" + str(p) +"\",\r\t  \"layer3\": \"venchants:item/frost"+str(fr)+"\",\r\t  \"layer4\": \"venchants:item/feather"+str(fe)+"\"\r    }\r}    "
                    g.write(text2)
                    g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close
    # Leather Armor
    for item in ["leather_chestplate", "leather_leggings"] :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\",\r\n    \"layer1\": \"minecraft:item/" + item + "_overlay" + "\"  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for thorns in range(0,2):
                p = protection; t = thorns
                text +="{ \"predicate\": {\"venchants:leatherarmorenchant\": 1"+str(p)+str(t)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(t)+"\" },\r    "
                g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(t)+".json","w")
                text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"minecraft:item/" + item + "_overlay" + "\",\r\t  \"layer2\": \"venchants:item/protection" + str(p) +"\",\r\t  \"layer3\": \"venchants:item/thorns"+str(t)+"\"\r    }\r}    "
                g.write(text2)
                g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close
    #Helmet
    Itemlist = ["netherite_helmet","diamond_helmet","golden_helmet", "iron_helmet","chainmail_helmet","turtle_helmet"]
    for item in Itemlist :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for thorns in range(0,2):
                for respiration in range(0,2):
                    for aqua in range(0,2) :
                        p = protection; t = thorns; r = respiration; a = aqua
                        text +="{ \"predicate\": {\"venchants:helmetenchant\": 1"+str(p)+str(t)+str(r)+str(a)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(t)+str(r)+str(a)+"\" },\r    "
                        g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(t)+str(r)+str(a)+".json","w")
                        text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/protection"+str(p)+"\",\r\t  \"layer2\": \"venchants:item/thorns" + str(t) +"\",\r\t  \"layer3\": \"venchants:item/respiration"+str(r)+"\",\r\t  \"layer4\": \"venchants:item/aqua"+str(a)+"\"\r    }\r}    "
                        g.write(text2)
                        g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close
    #Boots
    Itemlist = ["netherite_boots", "diamond_boots", "golden_boots", "iron_boots", "chainmail_boots"]
    for item in Itemlist :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for thorns in range(0,2):
                for frost in range(0,3):
                    for feather in range(0,4) :
                        p = protection; t = thorns; fr = frost; fe = feather
                        text +="{ \"predicate\": {\"venchants:bootenchant\": 1"+str(p)+str(t)+str(fr)+str(fe)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(t)+str(fr)+str(fe)+"\" },\r    "
                        g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(t)+str(fr)+str(fe)+".json","w")
                        text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/protection"+str(p)+"\",\r\t  \"layer2\": \"venchants:item/thorns" + str(t) +"\",\r\t  \"layer3\": \"venchants:item/frost"+str(fr)+"\",\r\t  \"layer4\": \"venchants:item/feather"+str(fe)+"\"\r    }\r}    "
                        g.write(text2)
                        g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close
    #Other Armor
    Itemlist = ["netherite_chestplate", "netherite_leggings",
    "diamond_chestplate", "diamond_leggings",
    "golden_chestplate", "golden_leggings",
    "iron_chestplate", "iron_leggings",
    "chainmail_chestplate", "chainmail_leggings"]
    for item in Itemlist :
        f = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for protection in range(0,5) :
            for thorns in range(0,2):
                p = protection; t = thorns
                text +="{ \"predicate\": {\"venchants:armorenchant\": 1"+str(p)+str(t)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(p)+str(t)+"\" },\r    "
                g = open(VENCHANTSPATH + "//" + item + "_1"+str(p)+str(t)+".json","w")
                text2 = "{    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/protection"+str(p)+"\",\r\t  \"layer2\": \"venchants:item/thorns" + str(t) +"\"\r    }\r}    "
                g.write(text2)
                g.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f.write(text)
        f.close

    return True

S = ["netherite_sword", "diamond_sword", "golden_sword", "iron_sword", "stone_sword", "wooden_sword"]
def generate_sword_assets(Itemlist = S) :
    #Items from A
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/handheld\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for type in range(0,4) :
            for fire in range(0,2):
                for looting in range(0,2) :
                    for knock in range(0,2) :
                        text +="{ \"predicate\": {\"venchants:swordenchant\": 1"+str(type)+str(fire)+str(looting)+str(knock)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(type)+str(fire)+str(looting)+str(knock)+"\" },\r    "
                        g1 = open(VENCHANTSPATH + "//" + item +"_1"+str(type)+str(fire)+str(looting)+str(knock)+".json","w")
                        text2 = "{    \"parent\": \"item/handheld\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/type" + str(type) +"\",\r\t  \"layer2\": \"venchants:item/fire"+str(fire)+"\",\r\t  \"layer3\": \"venchants:item/looting"+str(looting)+"\",\r\t  \"layer4\": \"venchants:item/knock"+str(knock)+"\"\r    }\r}    "
                        g1.write(text2)
                        g1.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    return True

def generate_bow_assets(Itemlist = ["bow"]) :
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        #  gives :
        #text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        text = "{\r\n    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n        \"layer0\": \"item/bow\"\r\n    },\r\n    \"display\": {\r\n        \"thirdperson_righthand\": {\r\n            \"rotation\": [ -80, 260, -40 ],\r\n            \"translation\": [ -1, -2, 2.5 ],\r\n            \"scale\": [ 0.9, 0.9, 0.9 ]\r\n        },\r\n        \"thirdperson_lefthand\": {\r\n            \"rotation\": [ -80, -280, 40 ],\r\n            \"translation\": [ -1, -2, 2.5 ],\r\n            \"scale\": [ 0.9, 0.9, 0.9 ]\r\n        },\r\n        \"firstperson_righthand\": {\r\n            \"rotation\": [ 0, -90, 25 ],\r\n            \"translation\": [ 1.13, 3.2, 1.13],\r\n            \"scale\": [ 0.68, 0.68, 0.68 ]\r\n        },\r\n        \"firstperson_lefthand\": {\r\n            \"rotation\": [ 0, 90, -25 ],\r\n            \"translation\": [ 1.13, 3.2, 1.13],\r\n            \"scale\": [ 0.68, 0.68, 0.68 ]\r\n        }\r\n    },\r\n    \"overrides\": [\r\n        "
        for power in range(0,2) :
            for flame in range(0,2):
                for infinity in range(0,3) :
                    for punch in range(0,2) :
                        text += "{\"predicate\": {\"venchants:bowenchant\": 1"+str(power)+str(flame)+str(infinity)+str(punch)+"}, \"model\": \"venchants:item/" + item + "_1"+str(power)+str(flame)+str(infinity)+str(punch)+"\"},\r\n        {\"predicate\": {\"venchants:bowenchant\": 1"+str(power)+str(flame)+str(infinity)+str(punch)+", \"pulling\": 1}, \"model\": \"venchants:item/bow_pulling_0"+"_1"+str(power)+str(flame)+str(infinity)+str(punch)+"\"},\r\n        {\"predicate\": {\"venchants:bowenchant\": 1"+str(power)+str(flame)+str(infinity)+str(punch)+", \"pulling\": 1, \"pull\": 0.65}, \"model\": \"venchants:item/bow_pulling_1"+"_1"+str(power)+str(flame)+str(infinity)+str(punch)+"\"},\r\n        {\"predicate\": {\"venchants:bowenchant\": 1"+str(power)+str(flame)+str(infinity)+str(punch)+", \"pulling\": 1,\"pull\": 0.9},\"model\": \"venchants:item/bow_pulling_2"+"_1"+str(power)+str(flame)+str(infinity)+str(punch)+"\"},\r\n\t\t"
                        for pull in ["bow","bow_pulling_0", "bow_pulling_1", "bow_pulling_2"] :
                            g1 = open(VENCHANTSPATH + "//" + pull +"_1"+str(power)+str(flame)+str(infinity)+str(punch)+".json","w")
                            text2 = "{    \"parent\": \"item/bow\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + pull + "\",\r\n      \"layer1\": \"venchants:item/type" + str(power) +"\",\r\t  \"layer2\": \"venchants:item/flame"+str(flame)+"\",\r\t  \"layer3\": \"venchants:item/infinity"+str(infinity)+"\",\r\t  \"layer4\": \"venchants:item/knock"+str(punch)+"\"\r    }\r}    "
                            g1.write(text2)
                            g1.close
        text = text[:-5]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    return True

T = ["netherite_pickaxe", "diamond_pickaxe", "golden_pickaxe", "iron_pickaxe", "stone_pickaxe", "wooden_pickaxe",
    "netherite_shovel", "diamond_shovel", "golden_shovel", "iron_shovel", "stone_shovel", "wooden_shovel",
    "netherite_axe", "diamond_axe", "golden_axee", "iron_axe", "stone_axe", "wooden_axe",
    "netherite_hoe", "diamond_hoe", "golden_hoe", "iron_hoe", "stone_hoe", "wooden_hoe",
    "shears"]
def generate_tool_assets(Itemlist = T) :
    #Items from A

    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/  gives :
        text = "{  \"parent\": \"minecraft:item/handheld\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for type in range(0,4) :
            for efficiency in range(0,2):
                for fortune in range(0,3) :
                    text +="{ \"predicate\": {\"venchants:toolenchant\": 1"+str(type)+str(efficiency)+str(fortune)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(type)+str(efficiency)+str(fortune)+"\" },\r    "
                    g1 = open(VENCHANTSPATH + "//" + item +"_1"+str(type)+str(efficiency)+str(fortune)+".json","w")
                    text2 = "{    \"parent\": \"item/handheld\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/type" + str(type) +"\",\r\t  \"layer2\": \"venchants:item/efficiency"+str(efficiency)+"\",\r\t  \"layer3\": \"venchants:item/fortune"+str(fortune)+"\"\r    }\r}    "
                    g1.write(text2)
                    g1.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    return True

def generate_rod_assets(Itemlist = ["fishing_rod"]) :
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/  gives :
        text = "{  \"parent\": \"minecraft:item/handheld_rod\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for lure in range(0,2) :
            for lots in range(0,2):
                for mending in range(0,2) :
                    text += "{\"predicate\": {\"venchants:rodenchant\": 1"+str(lure)+str(lots)+str(mending)+"}, \"model\": \"venchants:item/" + item + "_1"+str(lure)+str(lots)+str(mending)+"\"},\r\n        {\"predicate\": {\"venchants:rodenchant\": 1"+str(lure)+str(lots)+str(mending)+", \"cast\": 1}, \"model\": \"venchants:item/fishing_rod_cast"+"_1"+str(lure)+str(lots)+str(mending)+"\"},\r\n        "
                    for cast in ["fishing_rod","fishing_rod_cast"] :
                        g1 = open(VENCHANTSPATH + "//" + cast +"_1"+str(lure)+str(lots)+str(mending)+".json","w")
                        text2 = "{    \"parent\": \"minecraft:item/fishing_rod\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + cast + "\",\r\n      \"layer1\": \"venchants:item/lure" + str(lure) +"\",\r\t  \"layer2\": \"venchants:item/lots"+str(lots)+"\",\r\t  \"layer3\": \"venchants:item/mending"+str(mending)+"\"\r    }\r}    "
                        g1.write(text2)
                        g1.close
        text = text[:-11]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    return True

def generate_trident_assets(Itemlist = ["trident"]) :
    #Items from A
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{  \"parent\": \"minecraft:item/generated\",\r\n  \"textures\": {\r\n    \"layer0\": \"minecraft:item/" + item + "\"\r\n  },\r\n  \"overrides\": [\r\n    "
        for impaling in range(0,2) :
            for loyalty in range(0,3):
                for channeling in range(0,2) :
                    text +="{ \"predicate\": {\"venchants:tridentenchant\": 1"+str(impaling)+str(loyalty)+str(channeling)+" }, \"model\" : \"venchants:item/" + item + "_1"+str(impaling)+str(loyalty)+str(channeling)+"\" },\r    "
                    g1 = open(VENCHANTSPATH + "//" + item +"_1"+str(impaling)+str(loyalty)+str(channeling)+".json","w")
                    text2 = "{    \"parent\": \"minecraft:item/generated\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + item + "\",\r\n      \"layer1\": \"venchants:item/impaling" + str(impaling) +"\",\r\t  \"layer2\": \"venchants:item/loyalty"+str(loyalty)+"\",\r\t  \"layer3\": \"venchants:item/channeling"+str(channeling)+"\"\r    }\r}    "
                    g1.write(text2)
                    g1.close
        text = text[:-6]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    """Itemlist = ["trident_in_hand"]
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{\r\n    \"parent\": \"builtin/entity\",\r\n    \"gui_light\": \"front\",\r\n    \"textures\": {\r\n        \"layer0\": \"minecraft:item/trident\"\r\n    },\r\n    \"display\": {\r\n        \"thirdperson_righthand\": {\r\n            \"rotation\": [ 0, 60, 0 ],\r\n            \"translation\": [ 11, 17, -2 ],\r\n            \"scale\": [ 1, 1, 1 ]\r\n        },\r\n        \"thirdperson_lefthand\": {\r\n            \"rotation\": [ 0, 60, 0 ],\r\n            \"translation\": [ 3, 17, 12 ],\r\n            \"scale\": [ 1, 1, 1 ]\r\n        },\r\n        \"firstperson_righthand\": {\r\n            \"rotation\": [ 0, -90, 25 ],\r\n            \"translation\": [ -3, 17, 1],\r\n            \"scale\": [ 1, 1, 1 ]\r\n        },\r\n        \"firstperson_lefthand\": {\r\n            \"rotation\": [ 0, 90, -25 ],\r\n            \"translation\": [ 13, 17, 1],\r\n            \"scale\": [ 1, 1, 1 ]\r\n        },\r\n        \"gui\": {\r\n            \"rotation\": [ 15, -25, -5 ],\r\n            \"translation\": [ 2, 3, 0 ],\r\n            \"scale\": [ 0.65, 0.65, 0.65 ]\r\n        },\r\n        \"fixed\": {\r\n            \"rotation\": [ 0, 180, 0 ],\r\n            \"translation\": [ -2, 4, -5],\r\n            \"scale\":[ 0.5, 0.5, 0.5]\r\n        },\r\n        \"ground\": {\r\n            \"rotation\": [ 0, 0, 0 ],\r\n            \"translation\": [ 4, 4, 2],\r\n            \"scale\":[ 0.25, 0.25, 0.25]\r\n        }\r\n    },\r\n    \"overrides\": [\r\n        "
        for impaling in range(0,2) :
            for loyalty in range(0,3):
                for channeling in range(0,2) :
                    text += "{\"predicate\": {\"venchants:tridentenchant\": 1"+str(impaling)+str(loyalty)+str(channeling)+"}, \"model\": \"venchants:item/" + "trident" + "_1"+str(impaling)+str(loyalty)+str(channeling)+"\"},\r        {\"predicate\": {\"venchants:tridentenchant\": 1"+str(impaling)+str(loyalty)+str(channeling)+", \"throwing\": 1}, \"model\": \"venchants:item/trident_throwing"+"_1"+str(impaling)+str(loyalty)+str(channeling)+"\"},\r        "
                    g1 = open(VENCHANTSPATH + "//" + "trident_throwing" +"_1"+str(impaling)+str(loyalty)+str(channeling)+".json","w")
                    text2 = "{    \"parent\": \"minecraft:item/trident\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + "trident" + "\",\r\n      \"layer1\": \"venchants:item/impaling" + str(impaling) +"\",\r\t  \"layer2\": \"venchants:item/loyalty"+str(loyalty)+"\",\r\t  \"layer3\": \"venchants:item/channeling"+str(channeling)+"\"\r    }\r}    "
                    g1.write(text2)
                    g1.close
        text = text[:-10]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close"""
    return True

def generate_crossbow_assets(Itemlist = ["crossbow"]) :
    for item in Itemlist :
        f1 = open(MINECRAFTPATH + "//" + item + ".json","w")
        # https://www.pythonescaper.com/ gives :
        text = "{\r\n    \"parent\": \"item/generated\",\r\n    \"textures\": {\r\n        \"layer0\": \"item/crossbow_standby\"\r\n    },\r\n    \"display\": {\r\n        \"thirdperson_righthand\": {\r\n            \"rotation\": [ -90, 0, -60 ],\r\n            \"translation\": [ 2, 0.1, -3 ],\r\n            \"scale\": [ 0.9, 0.9, 0.9 ]\r\n        },\r\n        \"thirdperson_lefthand\": {\r\n            \"rotation\": [ -90, 0, 30 ],\r\n            \"translation\": [ 2, 0.1, -3 ],\r\n            \"scale\": [ 0.9, 0.9, 0.9 ]\r\n        },\r\n        \"firstperson_righthand\": {\r\n            \"rotation\": [ -90, 0, -55 ],\r\n            \"translation\": [ 1.13, 3.2, 1.13],\r\n            \"scale\": [ 0.68, 0.68, 0.68 ]\r\n        },\r\n        \"firstperson_lefthand\": {\r\n            \"rotation\": [ -90, 0, 35 ],\r\n            \"translation\": [ 1.13, 3.2, 1.13],\r\n            \"scale\": [ 0.68, 0.68, 0.68 ]\r\n        }\r\n    },\r\n    \"overrides\": [\r\n\t\t"
        for quick in range(0,2) :
            for piercing in range(0,3):
                text += "{\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+" }, \"model\" : \"venchants:item/crossbow_standby_1"+str(quick) + str(piercing)+"\" },\r\n        {\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+", \"pulling\": 1}, \"model\": \"venchants:item/crossbow_pulling_0_1"+str(quick) + str(piercing)+"\"},\r\n        {\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+", \"pulling\": 1, \"pull\": 0.58}, \"model\": \"venchants:item/crossbow_pulling_1_1"+str(quick) + str(piercing)+"\"},\r\n        {\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+", \"pulling\": 1, \"pull\": 1.0}, \"model\": \"venchants:item/crossbow_pulling_2_1"+str(quick) + str(piercing)+"\"},\r\n        {\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+", \"charged\": 1}, \"model\": \"venchants:item/crossbow_arrow_1"+str(quick) + str(piercing)+"\"},\r\n        {\"predicate\": {\"venchants:crossbowenchant\": 1"+str(quick) + str(piercing)+", \"charged\": 1, \"firework\": 1}, \"model\": \"venchants:item/crossbow_firework_1"+str(quick) + str(piercing)+"\"},\r\n\t\t"
                for pull in ["crossbow_standby","crossbow_pulling_0","crossbow_pulling_1","crossbow_pulling_2", "crossbow_arrow", "crossbow_firework"] :
                    g1 = open(VENCHANTSPATH + "//" + pull +"_1"+str(quick) + str(piercing)+".json","w")
                    text2 = "{    \"parent\": \"item/crossbow\",\r\n    \"textures\": {\r\n      \"layer0\": \"minecraft:item/" + pull + "\",\r\n      \"layer1\": \"venchants:item/quick" + str(quick) +"\",\r\t  \"layer2\": \"venchants:item/piercing"+str(piercing)+"\"\r    }\r}    "
                    g1.write(text2)
                    g1.close
        text = text[:-5]
        text += "\r\n  ]\r\n}"
        f1.write(text)
        f1.close
    return True


