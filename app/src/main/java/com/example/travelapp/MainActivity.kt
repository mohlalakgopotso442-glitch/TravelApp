package com.example.packinglistapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PackingListApp()
        }
    }
}

data class PackingItem(
    val name: String,
    val category: String,
    val quantity: Int,
    val comments: String
)

@Composable
fun PackingListApp() {

    var currentScreen by remember { mutableStateOf(1) }

    val packingList = remember {
        mutableStateListOf<PackingItem>()
    }

    if (currentScreen == 1) {
        ScreenOne(
            packingList = packingList,
            goToScreenTwo = {
                currentScreen = 2
            }
        )
    } else {
        ScreenTwo(
            packingList = packingList,
            goBack = {
                currentScreen = 1
            }
        )
    }
}

@Composable
fun ScreenOne(
    packingList: MutableList<PackingItem>,
    goToScreenTwo: () -> Unit
) {

    var itemName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var comments by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Packing List App",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = comments,
            onValueChange = { comments = it },
            label = { Text("Comments") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (
                    itemName.isEmpty() ||
                    category.isEmpty() ||
                    quantity.isEmpty() ||
                    comments.isEmpty()
                ) {

                    println("ERROR: Empty fields")

                } else {

                    packingList.add(
                        PackingItem(
                            itemName,
                            category,
                            quantity.toInt(),
                            comments
                        )
                    )

                    println("Item Added")

                    itemName = ""
                    category = ""
                    quantity = ""
                    comments = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add To Packing List")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                goToScreenTwo()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go To Screen Two")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                System.exit(0)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Exit App")
        }
    }
}

@Composable
fun ScreenTwo(
    packingList: List<PackingItem>,
    goBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Packing List",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                println("Displaying Full Packing List")

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Display Packing List")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {

                println("Displaying Quantity Above 2")

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Quantity >= 2")
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(packingList) { item ->

                if (item.quantity >= 2) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),

                        elevation = CardDefaults.cardElevation(5.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {

                            Text("Item: ${item.name}")
                            Text("Category: ${item.category}")
                            Text("Quantity: ${item.quantity}")
                            Text("Comments: ${item.comments}")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                goBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back To Main Screen")
        }
    }
}