package us.artit.sbprisoncore.listeners;

import com.sxtanna.recipe.Recipes;
import us.artit.sbprisoncore.utils.CustomItems;

public final class CraftingListener {

    public CraftingListener() {
        Recipes.shaped(CustomItems.KNOWLEDGE_SCROLL)
                .put('M', CustomItems.MINE_DUST)
                .put('S', CustomItems.SKY_DUST)
                .define('M', 'M', ' ',
                        'S', 'S', ' ',
                        ' ', ' ', ' ').register();
    }

}