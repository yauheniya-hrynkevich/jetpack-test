package com.beaverlisk.android.jetpacktest.data.model

import com.squareup.moshi.Json

data class Item(
    @Json(name = "name") val name: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "type") val type: String = "",
    @Json(name = "level") val level: Int = 0,
    @Json(name = "rarity") val rarity: String = "",
    @Json(name = "vendor_value") val vendorValue: Int = 0,
    @Json(name = "game_types") val gameTypes: List<String> = listOf(),
    @Json(name = "flags") val flags: List<String> = listOf(),
    @Json(name = "restrictions") val restrictions: List<String> = listOf(),
    @Json(name = "id") val id: Int = 0,
    @Json(name = "chat_link") val chatLink: String = "",
    @Json(name = "icon") val iconUrl: String = "",
    @Json(name = "details") val details: ItemDetails = ItemDetails()
) {
    companion object {

        fun createMockObject(): Item =
            Item(
                name = "Philosopher's Stone",
                description = "Used by the Mystic Forge to change one material into another.",
                type = "Trophy",
                level = 0,
                rarity = "Basic",
                vendorValue = 6,
                gameTypes = listOf("Activity", "Wvw", "Dungeon", "Pve"),
                flags = listOf("AccountBound", "NoSell", "AccountBindOnUse"),
                restrictions = listOf(),
                id = 20796,
                chatLink = "[&AgE8UQAA]",
                iconUrl = "https://render.guildwars2.com/file/68FF9617BA1BE1AD58E83E4209AEF0FB58950702/434425.png"
            )
    }

}

data class ItemDetails(@Json(name = "type") val type: String = "")
