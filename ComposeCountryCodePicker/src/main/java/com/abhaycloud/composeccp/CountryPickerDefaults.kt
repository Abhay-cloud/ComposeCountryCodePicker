package com.abhaycloud.composeccp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.abhaycloud.composeccp.utils.CountryModel

@Composable
internal fun DefaultCountryPickerField(country: CountryModel, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClick()
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = country.icon),
                contentDescription = "Flag of ${country.name}",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = country.dialCode)
        }
    }
}

@Composable
internal fun DefaultCountryItem(country: CountryModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = country.icon),
            contentDescription = "Flag of ${country.name}",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "${country.name} (${country.dialCode})")
    }
}

@Composable
internal fun DefaultSearchField(searchQuery: String, onValueChange: (String) -> Unit) {
    TextField(
        value = searchQuery,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        label = { Text("Search Country") },
        modifier = Modifier.fillMaxWidth()
    )
}
