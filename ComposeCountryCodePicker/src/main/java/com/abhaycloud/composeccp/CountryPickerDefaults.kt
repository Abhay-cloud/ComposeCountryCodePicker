package com.abhaycloud.composeccp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abhaycloud.composeccp.utils.CountryModel

@Composable
internal fun DefaultCountryPickerField(country: CountryModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = country.icon),
            contentDescription = "Flag of ${country.name}",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = country.dialCode)
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

object CountryPickerFieldDefaults {
    @Composable
    fun fieldColors(
        containerColor: Color = CardDefaults.cardColors().containerColor,
        contentColor: Color = CardDefaults.cardColors().contentColor
    ) = CardDefaults.cardColors(containerColor = containerColor, contentColor = contentColor)

    fun fieldShape(shape: Shape = RoundedCornerShape(8.dp)): Shape = shape

    fun fieldBorderStroke(): BorderStroke? = null
//    fun fieldPaddingValues(): PaddingValues = PaddingValues(16.dp)
}

