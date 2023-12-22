package fr.dev.majdi.composemenu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.dev.majdi.composemenu.domain.model.RecipeModel
import fr.dev.majdi.composemenu.presentation.utils.DEFAULT_RECIPE_IMAGE
import fr.dev.majdi.composemenu.presentation.utils.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */

@ExperimentalCoroutinesApi
@Composable
fun RecipeCard(
    recipe: RecipeModel,
    onClick: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(
                16.dp
            )
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick),
        elevation = 10.dp,
    ) {

        Column {
            val image =
                loadPicture(url = recipe.featuredImage, defaultImage = DEFAULT_RECIPE_IMAGE).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Recipe Featured Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h3
                    )

                }
                for (ingredient in recipe.ingredients) {
                    Text(
                        text = ingredient,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                val source = recipe.sourceUrl
                ExtendedButton(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    uriHandler.openUri(source)
                }
            }
        }
    }

}


