package com.abhaycloud.countrypickerfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abhaycloud.composeccp.CountryPickerField
import com.abhaycloud.composeccp.CountryPickerFieldDefaults
import com.abhaycloud.composeccp.utils.CountryModel
import com.abhaycloud.countrypickerfield.ui.theme.CountryPickerFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryPickerFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var selectedCountry by remember {
                        mutableStateOf(
                            CountryModel(
                                code = "US",
                                name = "United States",
                                icon = R.drawable.us,
                                dialCode = "+1"
                            )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        Text("Selected Country: ${selectedCountry.name}")
                        Spacer(modifier = Modifier.height(16.dp))
                        CountryPickerField(
                            selectedCountry = selectedCountry,
                            fieldShape = RoundedCornerShape(16.dp),
                            fieldColors = CardDefaults.cardColors(contentColor = Color.Cyan),

                            onCountrySelected = { selectedCountry = it }
                        ) {
                            Row(modifier = Modifier.padding(10.dp)) {
                                Text(text = it.name)
                                Image(
                                    painter = painterResource(id = it.icon),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

