package com.beaverlisk.android.jetpacktest.ui.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beaverlisk.android.jetpacktest.R
import com.beaverlisk.android.jetpacktest.Rarity
import com.beaverlisk.android.jetpacktest.data.model.Item
import com.beaverlisk.android.jetpacktest.ui.common.NavigationToolbar
import com.beaverlisk.android.jetpacktest.ui.common.loadPicture
import com.beaverlisk.android.jetpacktest.ui.navigation.NavigationScreen

@Composable
fun BankContentScreen(navController: NavController, viewModel: BankViewModel) {
    Column {
        NavigationToolbar(
            title = LocalContext.current.getString(NavigationScreen.SCREEN_BANK.title)
        ) {}
        BankItemsList(viewModel.bankContentStateList)  // Put the items to overlap here
    }
}

@Composable
fun BankItemsList(bankItems: List<Item>) {
    LazyColumn {
        itemsIndexed(bankItems) { index, item ->
            BankListItem(item)
        }
    }
}

@Preview
@Composable
fun BankListItem(item: Item = Item.createMockObject()) {
    Row(modifier = Modifier.padding(8.dp)) {
        Column {
            BankItemImage(
                url = item.icon,
                contentDescription = item.name
            )
        }
        Column {
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify
            )
            Text(
                text = item.rarity,
                style = MaterialTheme.typography.body2,
                color = colorResource(Rarity.getFromStringValue(item.rarity).colorRes)
            )
        }
    }
}

@Composable
private fun BankItemImage(url: String, contentDescription: String) {
    loadPicture(url = url, placeholderRes = R.drawable.ic_gw2_logo).value?.asImageBitmap()?.let {
        Image(
            bitmap = it,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(84.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }

}