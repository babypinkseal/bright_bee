package com.example.brightbee.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.brightbee.R
import com.example.brightbee.data.Material
import com.example.brightbee.data.getSampleMaterialList

class MaterialListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialListContent()
        }
    }
}

@Composable
fun MaterialListContent() {
    Scaffold(
        topBar = { AppTopBar() }
    ) {
        MaterialListScreen()
    }
}

@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.material_list_title)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
            }
        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}

@Composable
fun MaterialListScreen() {
    val materialList = getSampleMaterialList()

    LazyColumn {
        items(materialList) { material ->
            MaterialListItem(material)
        }
    }
}

@Composable
fun MaterialListItem(material: Material) {
    ListItem(
        text = { Text(text = material.title) },
        secondaryText = { Text(text = material.author) },
        icon = { Icon(Icons.Filled.Info, contentDescription = stringResource(R.string.material_icon)) },
        modifier = Modifier.clickable { /* Handle material item click */ }
    )
}

@Preview
@Composable
fun MaterialListScreenPreview() {
    MaterialListScreen()
}
