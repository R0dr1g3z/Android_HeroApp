package com.example.heroapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heroapp.data.HeroesRepository.heroes
import com.example.heroapp.model.Hero
import com.example.heroapp.ui.theme.HeroAppTheme
import com.example.heroapp.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroAppTheme {
                HeroApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroApp() {
    Scaffold(topBar = { HeroTopBar() }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(heroes) {
                HeroItem(hero = it)
            }
        }
    }

}

@Composable
fun HeroItem(hero: Hero) {
    Card(elevation = 2.dp) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    stringResource(hero.name),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    stringResource(hero.description),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(hero.image),
                contentDescription = null,
                modifier = Modifier
                    .clip(Shapes.small)
                    .size(72.dp)
            )
        }

    }
}

@Composable
fun HeroTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(stringResource(R.string.app_name), style = MaterialTheme.typography.h1)
    }
}

@Preview(showBackground = true)
@Composable
fun HeroLightPreview() {
    HeroAppTheme {
        HeroApp()
    }
}

@Preview
@Composable
fun HeroDarkPreview(){
    HeroAppTheme(darkTheme = true) {
        HeroApp()
    }
}