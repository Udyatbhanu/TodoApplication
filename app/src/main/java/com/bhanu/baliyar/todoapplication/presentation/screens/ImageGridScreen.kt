import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class GridItem(val title: String, val imageUrl: String)

val sampleItems = listOf(
    GridItem("Mountains", "https://images.unsplash.com/photo-1587502537745-88e14a56a514"),
    GridItem("Beach", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
    GridItem("Forest", "https://images.unsplash.com/photo-1501785888041-af3ef285b470"),
    GridItem("Desert", "https://images.unsplash.com/photo-1606813908427-3c3d6014d8e0")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageGridScreen(items: List<GridItem> = sampleItems) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Image Grid") })
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                GridItemCard(item)
            }
        }
    }
}

@Composable
fun GridItemCard(item: GridItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}