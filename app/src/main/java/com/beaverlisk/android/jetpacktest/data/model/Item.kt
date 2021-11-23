package com.beaverlisk.android.jetpacktest.data.model

import com.squareup.moshi.Json

data class Item(
    @Json(name = "name") var name: String = "",
    @Json(name = "description") var description: String = "",
    @Json(name = "type") var type: String = "",
    @Json(name = "level") var level: Int = 0,
    @Json(name = "rarity") var rarity: String = "",
    @Json(name = "vendor_value") var vendorValue: Int = 0,
    @Json(name = "game_types") var gameTypes: List<String> = listOf(),
    @Json(name = "flags") var flags: List<String> = listOf(),
    @Json(name = "restrictions") var restrictions: List<String> = listOf(),
    @Json(name = "id") var id: Int = 0,
    @Json(name = "chat_link") var chatLink: String = "",
    @Json(name = "icon") var icon: String = "",
    @Json(name = "details") var details: ItemDetails = ItemDetails()
) {
    companion object {

        fun createMockObject(): Item = Item(
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
            icon = "https://render.guildwars2.com/file/68FF9617BA1BE1AD58E83E4209AEF0FB58950702/434425.png"
        )
    }

}

data class ItemDetails(@Json(name = "type") var type: String = "")
