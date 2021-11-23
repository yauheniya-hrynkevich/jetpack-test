package com.beaverlisk.android.jetpacktest

import androidx.annotation.ColorRes

enum class Rarity constructor(
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

        fun getFromStringValue(value: String): Rarity = values().find {
            it.apiName.equals(value, true)
        } ?: UNKNOWN
    }

}