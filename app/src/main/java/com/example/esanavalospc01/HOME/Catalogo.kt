package com.example.esanavalospc01.HOME

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import coil.compose.rememberAsyncImagePainter

data class Catalogo(val name: String, val price: Double, val category: String, val image: String)

//mock data
val catalogoLaptops = listOf(
    Catalogo("Dell XPS 13", 1299.99, "Laptop", "https://i.dell.com/sites/csimages/App-Merchandizing_Images/all/xps-13-9315-laptop.png"),
    Catalogo("MacBook Air M2", 1199.00, "Laptop", "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-m2"),
    Catalogo("HP Spectre x360", 1399.99, "Laptop", "https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c08221611.png"),
    Catalogo("Lenovo ThinkPad X1 Carbon", 1499.00, "Laptop", "https://www.lenovo.com/medias/lenovo-laptop-thinkpad-x1-carbon-gen10-14-subseries-hero.png"),
    Catalogo("Asus ZenBook 14", 999.99, "Laptop", "https://dlcdnwebimgs.asus.com/gain/FE7C40E1-E08B-4A80-BF3F-9E4B9B08ABF6"),
    Catalogo("Acer Swift 3", 749.99, "Laptop", "https://static.acer.com/up/Resource/Acer/Laptops/Swift_3/Images/20220614/Swift_3_01.png"),
    Catalogo("Microsoft Surface Laptop 5", 1299.99, "Laptop", "https://c.s-microsoft.com/en-us/CMSImages/Surface-Laptop-5-Overview_hero_1.png")
)

@Composable
fun Catalago(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Catálogo de Laptops", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(catalogoLaptops) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(item.image),
                            contentDescription = item.name,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = "$${item.price}", style = MaterialTheme.typography.bodyLarge)
                            Text(text = item.category, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}