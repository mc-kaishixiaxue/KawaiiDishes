package com.hakimen.kawaiidishes.datagen;

import com.hakimen.kawaiidishes.KawaiiDishes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = KawaiiDishes.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        generator.addProvider(new ItemModelSupplier(generator,fileHelper));
        generator.addProvider(new BlockStateSupplier(generator,fileHelper));
        generator.addProvider(new LangSupplier(generator,"en_us"));
        generator.addProvider(new CraftingRecipeSupplier(generator));
        generator.addProvider(new LootTableSupplier(generator));
    }
}
