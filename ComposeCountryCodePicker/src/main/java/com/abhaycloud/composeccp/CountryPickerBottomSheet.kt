package com.abhaycloud.composeccp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhaycloud.composeccp.utils.CountryData
import com.abhaycloud.composeccp.utils.CountryModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CountryPickerBottomSheet(
    countries: List<CountryModel> = CountryData.countries,
    isVisible: Boolean,
    onDismiss: () -> Unit,
    onCountrySelected: (CountryModel) -> Unit,
    countryItem: @Composable (CountryModel) -> Unit,
    searchField: @Composable (searchQuery: String, onValueChange: (String) -> Unit) -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(isVisible) {
        if (isVisible) bottomSheetState.show() else bottomSheetState.hide()
    }

    ModalBottomSheet(
        sheetState = bottomSheetState,
        onDismissRequest = onDismiss,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                var searchQuery by remember { mutableStateOf("") }
                val filteredCountries = remember(searchQuery) {
                    countries.filter {
                        it.name.contains(searchQuery, ignoreCase = true) ||
                                it.dialCode.contains(searchQuery)
                    }
                }

                searchField(searchQuery) {
                    searchQuery = it
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn {
                    items(filteredCountries) { country ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onCountrySelected(country)
                                }
                                .padding(vertical = 8.dp),
                        ) {
                            countryItem(country)
                        }
                    }
                }
            }
        }
    )

}