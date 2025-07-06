package com.abhaycloud.countrypickerfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhaycloud.composeccp.CountryPickerField
import com.abhaycloud.composeccp.utils.CountryData
import com.abhaycloud.composeccp.utils.CountryUtils.getLocaleCountry
import com.abhaycloud.countrypickerfield.ui.theme.CountryPickerFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryPickerFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryPickerDemo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CountryPickerDemo(modifier: Modifier) {
    var selectedCountry by remember { mutableStateOf(CountryData.getLocaleCountry()) }

    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        CountryPickerField(
            selectedCountry = selectedCountry,
            onCountrySelected = {
                selectedCountry = it
            })
    }

}
