package com.hakimen.kawaiidishes.datagen;

import com.hakimen.kawaiidishes.datagen.recipebuilder.CoffeeMachineRecipeBuilder;
import com.hakimen.kawaiidishes.datagen.recipebuilder.CoffeePressRecipeBuilder;
import com.hakimen.kawaiidishes.recipes.CoffeeMachineRecipe;
import com.hakimen.kawaiidishes.registry.EffectRegister;
import com.hakimen.kawaiidishes.registry.ItemRegister;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionProgress;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class CraftingRecipeSupplier extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipeSupplier(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        roasting(pFinishedRecipeConsumer, ItemRegister.coffeeFruit.get(), ItemRegister.driedCoffeeBeans.get(), ItemRegister.roastedCoffeeBeans.get());
        roasting(pFinishedRecipeConsumer, Items.COCOA_BEANS, ItemRegister.driedCocoaBeans.get(), ItemRegister.roastedCocoaBeans.get());

        ShapedRecipeBuilder.shaped(ItemRegister.mug.get())
                .pattern("x x")
                .pattern("xxx")
                .define('x', Items.BRICK)
                .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegister.coffeeMachine.get())
                .pattern("xxx")
                .pattern(".px")
                .pattern("iri")
                .define('x', Tags.Items.STONE)
                .define('r', Items.REDSTONE)
                .define('p', ItemRegister.coffeePress.get())
                .define('.', Items.IRON_NUGGET)
                .define('i', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(ItemRegister.coffeePress.get()), has(ItemRegister.coffeePress.get()))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegister.coffeePress.get())
                .pattern("xxx")
                .pattern("g g")
                .pattern("xxx")
                .define('g',Tags.Items.GLASS_PANES)
                .define('x',Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegister.mortarAndPestle.get())
                .pattern("x x")
                .pattern("xxx")
                .define('x',Tags.Items.STONE)
                .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegister.darkChocolateBar.get())
                .requires(ItemRegister.cocoaPowder.get())
                .requires(ItemRegister.cocoaPowder.get())
                .requires(Items.SUGAR)
                .requires(ItemRegister.cocoaPowder.get())
                .unlockedBy(getHasName(ItemRegister.cocoaPowder.get()), has(ItemRegister.cocoaPowder.get()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegister.milkChocolateBar.get())
                .requires(ItemRegister.cocoaPowder.get())
                .requires(ItemRegister.cocoaPowder.get())
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(ItemRegister.cocoaPowder.get()), has(ItemRegister.cocoaPowder.get()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegister.whiteChocolateBar.get())
                .requires(ItemRegister.cocoaPowder.get())
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(ItemRegister.cocoaPowder.get()), has(ItemRegister.cocoaPowder.get()))
                .save(pFinishedRecipeConsumer);

        cosmetics(pFinishedRecipeConsumer);
        decor(pFinishedRecipeConsumer);
        coffees(pFinishedRecipeConsumer);


    }

    public void decor(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        stool(pFinishedRecipeConsumer, ItemRegister.blackStool.get(), Items.BLACK_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.blueStool.get(), Items.BLUE_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.brownStool.get(), Items.BROWN_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.cyanStool.get(), Items.CYAN_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.grayStool.get(), Items.GRAY_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.greenStool.get(), Items.GREEN_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.lightBlueStool.get(), Items.LIGHT_BLUE_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.lightGrayStool.get(), Items.LIGHT_GRAY_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.limeStool.get(), Items.LIME_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.magentaStool.get(), Items.MAGENTA_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.orangeStool.get(), Items.ORANGE_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.pinkStool.get(), Items.PINK_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.purpleStool.get(), Items.PURPLE_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.redStool.get(), Items.RED_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.whiteStool.get(), Items.WHITE_WOOL);
        stool(pFinishedRecipeConsumer, ItemRegister.yellowStool.get(), Items.YELLOW_WOOL);
    }

    public void cosmetics(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.blackMaidDress.get(), Items.BLACK_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.whiteMaidDress.get(), Items.WHITE_WOOL, Items.BLACK_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.grayMaidDress.get(), Items.GRAY_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.light_grayMaidDress.get(), Items.LIGHT_GRAY_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.light_blueMaidDress.get(), Items.LIGHT_BLUE_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.redMaidDress.get(), Items.RED_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.pinkMaidDress.get(), Items.PINK_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.magentaMaidDress.get(), Items.MAGENTA_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.purpleMaidDress.get(), Items.PURPLE_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.greenMaidDress.get(), Items.GREEN_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.limeMaidDress.get(), Items.LIME_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.blueMaidDress.get(), Items.BLUE_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.cyanMaidDress.get(), Items.CYAN_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.yellowMaidDress.get(), Items.YELLOW_WOOL, Items.WHITE_WOOL);

        maidOutfit(pFinishedRecipeConsumer, ItemRegister.orangeMaidDress.get(), Items.ORANGE_WOOL, Items.WHITE_WOOL);
        maidOutfit(pFinishedRecipeConsumer, ItemRegister.brownMaidDress.get(), Items.BROWN_WOOL, Items.WHITE_WOOL);


        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.blackMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.whiteMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.grayMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.light_grayMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.light_blueMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.redMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.pinkMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.magentaMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.purpleMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.greenMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.limeMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.blueMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.cyanMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.yellowMaidDress.get());

        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.orangeMaidDress.get());
        maidOutfitVariations(pFinishedRecipeConsumer, ItemRegister.brownMaidDress.get());

        shoes(pFinishedRecipeConsumer, ItemRegister.blackThighHighsShoes.get(), Items.LEATHER, Items.BLACK_WOOL);
        shoes(pFinishedRecipeConsumer, ItemRegister.whiteThighHighsShoes.get(), Items.LEATHER, Items.GRAY_WOOL);

        thighHighs(pFinishedRecipeConsumer, ItemRegister.blackThighHighs.get(), Items.BLACK_WOOL);
        thighHighs(pFinishedRecipeConsumer, ItemRegister.whiteThighHighs.get(), Items.WHITE_WOOL);

        catEars(pFinishedRecipeConsumer, ItemRegister.blackCatEars.get(), Items.BLACK_WOOL);
        catEars(pFinishedRecipeConsumer, ItemRegister.whiteCatEars.get(), Items.WHITE_WOOL);
        catEars(pFinishedRecipeConsumer, ItemRegister.caramelCatEars.get(), Items.YELLOW_WOOL);

        catTails(pFinishedRecipeConsumer, ItemRegister.blackCatTail.get(), Items.BLACK_WOOL);
        catTails(pFinishedRecipeConsumer, ItemRegister.whiteCatTail.get(), Items.WHITE_WOOL);
        catTails(pFinishedRecipeConsumer, ItemRegister.caramelCatTail.get(), Items.YELLOW_WOOL);

        foxTails(pFinishedRecipeConsumer, ItemRegister.blackFoxTail.get(), Items.BLACK_WOOL, Items.WHITE_WOOL);
        foxTails(pFinishedRecipeConsumer, ItemRegister.redFoxTail.get(), Items.ORANGE_WOOL, Items.WHITE_WOOL);
        foxTails(pFinishedRecipeConsumer, ItemRegister.whiteFoxTail.get(), Items.WHITE_WOOL, Items.WHITE_WOOL);


    }

    public void coffees(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.coffeePowder.get(),
                Items.SUGAR,
                ItemRegister.latteCoffee.get().getDefaultInstance(),
                100,
                false,
                true,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.DIG_SPEED, 30 * 20));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                Items.SUGAR,
                ItemRegister.cocoaPowder.get(),
                ItemRegister.mochaCoffee.get().getDefaultInstance(),
                100,
                false,
                true,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.REGENERATION, 30 * 20, 1));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.coffeePowder.get(),
                Items.SUGAR,
                ItemRegister.macchiatoCoffee.get().getDefaultInstance(),
                100,
                true,
                true,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.ABSORPTION, 30 * 20, 1));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.expressoCoffee.get().getDefaultInstance(),
                100,
                true,
                false,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 15 * 20));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.coffeePowder.get(),
                ItemRegister.doppioCoffee.get().getDefaultInstance(),
                100,
                true,
                false,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30 * 20, 1));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                Items.SUGAR,
                ItemRegister.americanCoffee.get().getDefaultInstance(),
                100,
                true,
                false,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30 * 20));

        machineRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.cocoaPowder.get(),
                Items.SUGAR,
                ItemRegister.cappuccinoCoffee.get().getDefaultInstance(),
                100,
                true,
                true,
                ItemRegister.mug.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.DIG_SPEED, 60 * 20, 1));


        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                Items.WATER_BUCKET,
                ItemRegister.americanCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.americanCoffee.get(),
                ItemRegister.expressoCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.DIG_SPEED, 15 * 20)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.coffeePowder.get(),
                ItemRegister.coffeePowder.get(),
                Items.WATER_BUCKET,
                ItemRegister.doppioCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 1)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.doppioCoffee.get(),
                Items.MILK_BUCKET,
                Items.SUGAR,
                ItemRegister.macchiatoCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.ABSORPTION, 15 * 20, 1)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.expressoCoffee.get(),
                Items.MILK_BUCKET,
                ItemRegister.cocoaPowder.get(),
                ItemRegister.mochaCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.REGENERATION, 15 * 20, 1)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.expressoCoffee.get(),
                Items.MILK_BUCKET,
                Items.SUGAR,
                ItemRegister.latteCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.DIG_SPEED, 15 * 20)
        );

        pressRecipe(pFinishedRecipeConsumer,
                ItemRegister.americanCoffee.get(),
                Items.MILK_BUCKET,
                ItemRegister.cocoaPowder.get(),
                ItemRegister.cappuccinoCoffee.get().getDefaultInstance(),
                new MobEffectInstance(EffectRegister.kawaiiEffect.get(), 15 * 20),
                new MobEffectInstance(MobEffects.DIG_SPEED, 30 * 20, 1)
        );
    }

    public void machineRecipe(Consumer<FinishedRecipe> consumer, Item item, Item item1, Item item2, ItemStack result, int ticks, boolean needWater, boolean needMilk, ItemStack onOutput, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeeMachineRecipeBuilder builder = new CoffeeMachineRecipeBuilder(
                item,
                item1,
                item2,
                result,
                ticks,
                needWater,
                needMilk,
                onOutput,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));
        builder.save(consumer);
    }

    public void machineRecipe(Consumer<FinishedRecipe> consumer, Item item, Item item1, ItemStack result, int ticks, boolean needWater, boolean needMilk, ItemStack onOutput, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeeMachineRecipeBuilder builder = new CoffeeMachineRecipeBuilder(
                item,
                item1,
                result,
                ticks,
                needWater,
                needMilk,
                onOutput,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));
        builder.save(consumer);
    }

    public void machineRecipe(Consumer<FinishedRecipe> consumer, Item item, ItemStack result, int ticks, boolean needWater, boolean needMilk, ItemStack onOutput, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeeMachineRecipeBuilder builder = new CoffeeMachineRecipeBuilder(
                item,
                result,
                ticks,
                needWater,
                needMilk,
                onOutput,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));

        builder.save(consumer);
    }


    public void pressRecipe(Consumer<FinishedRecipe> consumer, Item item, Item item1, Item item2, ItemStack result, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeePressRecipeBuilder builder = new CoffeePressRecipeBuilder(
                item,
                item1,
                item2,
                result,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));
        builder.save(consumer);
    }

    public void pressRecipe(Consumer<FinishedRecipe> consumer, Item item, Item item1, ItemStack result, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeePressRecipeBuilder builder = new CoffeePressRecipeBuilder(
                item,
                item1,
                result,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));
        builder.save(consumer);
    }

    public void pressRecipe(Consumer<FinishedRecipe> consumer, Item item, ItemStack result, MobEffectInstance mainEffect, MobEffectInstance secondaryEffect) {
        CoffeePressRecipeBuilder builder = new CoffeePressRecipeBuilder(
                item,
                result,
                mainEffect,
                secondaryEffect
        );
        builder.unlockedBy(getHasName(item), has(item));

        builder.save(consumer);
    }


    public void roasting(Consumer<FinishedRecipe> consumer, Item stage1, Item stage2, Item stage3) {
        simpleCookingRecipe(consumer, "smelting", SimpleCookingSerializer.SMELTING_RECIPE, 200, stage1, stage2, 0.12f);
        simpleCookingRecipe(consumer, "smoking", SimpleCookingSerializer.SMOKING_RECIPE, 100, stage1, stage2, 0.12f);

        simpleCookingRecipe(consumer, "smelting", SimpleCookingSerializer.SMELTING_RECIPE, 200, stage2, stage3, 0.12f);
        simpleCookingRecipe(consumer, "smoking", SimpleCookingSerializer.SMOKING_RECIPE, 100, stage2, stage3, 0.12f);

    }

    public void catTails(Consumer<FinishedRecipe> consumer, Item result, Item item) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("  #")
                .pattern("s##")
                .pattern("ss ")
                .define('#', Ingredient.of(item.getDefaultInstance()))
                .define('s', Ingredient.of(Tags.Items.STRING))
                .unlockedBy(getHasName(item), has(item))
                .save(consumer);
    }

    public void foxTails(Consumer<FinishedRecipe> consumer, Item result, Item item, Item item2) {
        ShapedRecipeBuilder.shaped(result)
                .pattern(" #x")
                .pattern("s##")
                .pattern("ss ")
                .define('#', Ingredient.of(item.getDefaultInstance()))
                .define('x', Ingredient.of(item2.getDefaultInstance()))
                .define('s', Ingredient.of(Tags.Items.STRING))
                .unlockedBy(getHasName(item), has(item))
                .save(consumer);
    }

    public void thighHighs(Consumer<FinishedRecipe> consumer, Item result, Item item) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .define('#', Ingredient.of(item.getDefaultInstance()))
                .unlockedBy(getHasName(item), has(item))
                .save(consumer);
    }


    public void shoes(Consumer<FinishedRecipe> consumer, Item result, Item item, Item item2) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("# #")
                .pattern("s s")
                .define('#', Ingredient.of(item.getDefaultInstance()))
                .define('s', Ingredient.of(item2.getDefaultInstance()))
                .unlockedBy(getHasName(item), has(item))
                .unlockedBy(getHasName(item2), has(item2))
                .save(consumer);
    }

    public void catEars(Consumer<FinishedRecipe> consumer, Item result, Item item) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("#s#")
                .pattern("s s")
                .define('#', Ingredient.of(item.getDefaultInstance()))
                .define('s', Ingredient.of(Tags.Items.STRING))
                .unlockedBy(getHasName(item), has(item))
                .save(consumer);
    }

    public void maidOutfit(Consumer<FinishedRecipe> consumer, Item result, Item mainColor, Item secondaryColor) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("# #")
                .pattern("s#s")
                .pattern("@@@")
                .define('#', Ingredient.of(mainColor.getDefaultInstance()))
                .define('@', Ingredient.of(secondaryColor.getDefaultInstance()))
                .define('s', Ingredient.of(Tags.Items.STRING))
                .unlockedBy(getHasName(mainColor), has(mainColor))
                .unlockedBy(getHasName(secondaryColor), has(secondaryColor))
                .save(consumer);
    }

    public void maidOutfitVariations(Consumer<FinishedRecipe> consumer, Item result) {
        for (var i : ItemRegister.ITEMS.getEntries().stream().toList()) {
            var path = i.get().getRegistryName().getPath();
            if (path.equals(result.getRegistryName().getPath() + "_cat_tail_black")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.blackCatTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
            if (path.equals(result.getRegistryName().getPath() + "_cat_tail_white")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.whiteCatTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
            if (path.equals(result.getRegistryName().getPath() + "_cat_tail_caramel")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.caramelCatTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
            if (path.equals(result.getRegistryName().getPath() + "_fox_tail_black")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.blackFoxTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
            if (path.equals(result.getRegistryName().getPath() + "_fox_tail_red")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.redFoxTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
            if (path.equals(result.getRegistryName().getPath() + "_fox_tail_white")) {
                ShapelessRecipeBuilder.shapeless(i.get())
                        .requires(Ingredient.of(result.getDefaultInstance()))
                        .requires(Ingredient.of(ItemRegister.whiteFoxTail.get().getDefaultInstance()))
                        .unlockedBy(getHasName(result), has(result))
                        .save(consumer);
            }
        }
    }

    public void stool(Consumer<FinishedRecipe> consumer, Item result, Item mainColor) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("#s#")
                .pattern("| |")
                .define('s', Ingredient.of(mainColor.getDefaultInstance()))
                .define('#', Ingredient.of(Items.STRIPPED_OAK_LOG, Items.STRIPPED_ACACIA_LOG, Items.STRIPPED_BIRCH_LOG, Items.STRIPPED_SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.STRIPPED_DARK_OAK_LOG))
                .define('|', Ingredient.of(Items.STICK))
                .unlockedBy(getHasName(mainColor), has(mainColor))
                .save(consumer);
    }
}
