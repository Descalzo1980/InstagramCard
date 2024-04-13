package dev.stas.instagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import dev.stas.instagramcard.ui.InstagramProfileCard
import dev.stas.instagramcard.ui.theme.InstagramCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<MainViewModel>()
        setContent {
            Test(viewModel = viewModel)
        }
    }
}


@Composable
fun Test(viewModel: MainViewModel) {
    InstagramCardTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
/*            LazyColumn {
                items(models.value){ model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowedButtonCallback = {
                            viewModel.changeFollowingStatus(it)
                        }
                    )
                }
            }*/
/*            LazyRow() {
                items(models.value){ model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowedButtonCallback = {
                            viewModel.changeFollowingStatus(it)
                        }
                    )
                }
            }*/
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                this.items(models.value) { model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowedButtonCallback = {
                            viewModel.changeFollowingStatus(it)
                        }
                    )
                }
            }
        }
    }
}


