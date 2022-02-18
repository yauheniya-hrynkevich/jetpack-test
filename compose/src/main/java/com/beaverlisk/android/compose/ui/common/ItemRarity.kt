package com.beaverlisk.android.compose.ui.common

import androidx.annotation.ColorRes
import com.beaverlisk.android.compose.R

enum class ItemRarity constructor(
    private val apiName: String,
    @ColorRes val colorRes: Int
) {
    BASIC("Basic", R.color.rarity_basic),
    FINE("Fine", R.color.rarity_fine),
    MASTERWORK("Masterwork", R.color.rarity_masterwork),
    RARE("Rare", R.color.rarity_rare),
    EXOTIC("Exotic", R.color.rarity_exotic),
    LEGENDARY("Legendary", R.color.rarity_legendary),
    TRANSMUTED("Transmuted", R.color.rarity_transmuted),
    UNKNOWN("", R.color.rarity_basic);

    companion object {

        fun getFromStringValue(value: String): ItemRarity = values().find {
            it.apiName.equals(value, true)
        } ?: UNKNOWN
    }

}