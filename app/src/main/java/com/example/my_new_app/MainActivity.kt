package com.example.my_new_app

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_new_app.ui.theme.MyNewAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ScreenOne()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenOne() {
    Box(modifier = Modifier.background(Color.hsl(259f, 0.8f, 0.75f))) {
        Column {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.hsl(255f, 0.8f, 0.79f)
                ),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .size(287.dp)
                    .padding(start = 25.dp, top = 40.dp, bottom = 180.dp, end = 25.dp)
            ) {
                Row {
                    Text(
                        modifier = Modifier.padding(start = 6.dp, top = 5.dp),
                        text = "Time",
                        color = Color.White,
                        fontWeight = FontWeight.W300,
                        fontSize = 18.sp,
                    )
                    Text(
                        modifier = Modifier.padding(start = 25.dp, top = 5.dp),
                        text = "Make an appointment with a",
                        color = Color.White,
                        fontWeight = FontWeight.W300,
                        fontSize = 18.sp,
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 75.dp, top = 15.dp),
                        tint = Color.White

                    )
                }
                Row {
                    Text(
                        modifier = Modifier.padding(start = 6.dp, top = 0.dp),
                        text = "16:30",
                        color = Color.White,
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                    )
                    Text(
                        modifier = Modifier.padding(start = 17.dp, top = 0.dp),
                        text = "therapist aat 22, Hazratganj",
                        color = Color.White,
                        fontWeight = FontWeight.W300,
                        fontSize = 18.sp,
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.doctor1),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 150.dp)
                .width(400.dp)
                .size(270.dp)
        )
        Row {
            var text by remember { mutableStateOf("") }

            TextField(value = text,
                onValueChange = { text = it },
                label = { Text("Search") },
                modifier = Modifier
                    .padding(top = 471.dp, start = 27.dp, end = 10.dp)
                    .background(Color.White)
                    .size(width = 310.dp, height = 57.dp),
                //  .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                })
            Icon(
                imageVector = Icons.Rounded.Favorite, contentDescription = null,
                modifier = Modifier
                    .padding(top = 470.dp)
                    .size(55.dp)
                    .background(Color.White, RectangleShape),
                tint = (Color.hsl(259f, 0.8f, 0.75f))
            )
        }
        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Button(
            onClick = { isSheetOpen = true },
            modifier = Modifier
                .padding(top = 450.dp)
                .align(alignment = Alignment.Center),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(text = "Open sheet")
        }
        if (isSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { isSheetOpen = false },
                modifier = Modifier.height(300.dp),
                containerColor = Color.White
            ) {
                Column {
                    Row {
                        Spacer(modifier = Modifier.fillMaxWidth(0.15f))
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxWidth()
                                .background(color = Color.Black, shape = CircleShape)
                        )
                        Spacer(modifier = Modifier.fillMaxWidth(0.27f))
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxWidth()
                                .background(color = Color.Black, shape = CircleShape)
                        )
                        Spacer(modifier = Modifier.fillMaxWidth(0.45f))

                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(30.dp)
                                .fillMaxWidth()
                                .background(color = Color.Black, shape = CircleShape)
                        )
                    }
                    Row {
                        Text(
                            text = "Doctor's",
                            fontWeight = FontWeight.W400,
                            fontSize = 25.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 25.dp, start = 45.dp)
                        )
                        Text(
                            text = "Location",
                            fontWeight = FontWeight.W400,
                            fontSize = 25.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 25.dp, start = 45.dp)
                        )
                        Text(
                            text = "Contact",
                            fontWeight = FontWeight.W400,
                            fontSize = 25.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 25.dp, start = 45.dp)
                        )
                    }
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.hsl(0f, 0.0f, 0.98f)
                        ),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .size(130.dp)
                            .padding(top = 70.dp)
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .size(75.dp)
                                    .padding(start = 35.dp, top = 11.dp, bottom = 15.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .size(99.dp)
                                    .padding(start = 55.dp, top = 11.dp, bottom = 15.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .size(119.dp)
                                    .padding(start = 55.dp, top = 12.dp, bottom = 15.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .size(159.dp)
                                    .padding(start = 5.dp, top = 13.dp, bottom = 15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
