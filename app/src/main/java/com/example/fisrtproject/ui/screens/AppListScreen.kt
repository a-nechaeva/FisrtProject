package com.example.fisrtproject.ui.screens

import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fisrtproject.R
import androidx.compose.runtime.*
import com.example.fisrtproject.data.AppData
import com.example.fisrtproject.ui.components.AppListItem
import com.example.fisrtproject.ui.viewmodels.AppListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    viewModel: AppListViewModel
) {
    val apps by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("RuStore")},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.rustore),
                        contentDescription = "RuStore Logo",
                        modifier = Modifier.size(40.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        tint = Color.Unspecified
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0077FF),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {
        paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .clip(RoundedCornerShape(12.dp)),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(
                count = apps.size,
                key = { index -> apps[index].id }
            ) {
                index ->
                AppListItem(
                    app = apps[index],
                    onClick = { onAppClick(apps[index].id)}
                )
            }
        }
    }
}