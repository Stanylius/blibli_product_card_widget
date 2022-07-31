package com.example.product_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.product_card.ui.theme.Product_cardTheme
import java.text.DecimalFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Product_cardTheme {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            item {
                Item(
                    title = "MOST BRAND NEW SHOE WITH WHITE STRIPS AND BLACK ROPE MODEL FOR TEENAGERS SUITS YOU TO PLAY AND HIKING ON THE HIGHEST MOUNTAIN",
                    price = 50000.0,
                    isBestSeller = true,
                    city = "Jakarta",
                    tags = arrayOf("pre-order", "unique"),
                    stock = 10,
                    discount = 10,
                    sumOfColor = 5,
                    isSmallCard = false,
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    buttonFunctionality = {  }
                )
                Item(
                    title = "MOST BRAND NEW SHOE WITH WHITE STRIPS AND BLACK ROPE MODEL FOR TEENAGERS SUITS YOU TO PLAY AND HIKING ON THE HIGHEST MOUNTAIN",
                    price = 50000.0,
                    isBestSeller = false,
                    city = "Jakarta",
                    tags = arrayOf("pre-order"),
                    stock = 0,
                    discount = 10,
                    sumOfColor = 0,
                    isSmallCard = false,
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    buttonFunctionality = {  }
                )
                Item(
                    title = "MOST BRAND NEW SHOE WITH WHITE STRIPS AND BLACK ROPE MODEL FOR TEENAGERS SUITS YOU TO PLAY AND HIKING ON THE HIGHEST MOUNTAIN",
                    price = 50000.0,
                    isBestSeller = true,
                    city = "Jakarta",
                    tags = arrayOf("pre-order", "unique"),
                    stock = 10,
                    discount = 10,
                    sumOfColor = 5,
                    isSmallCard = true,
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    buttonFunctionality = {  }
                )
            }

        }



    }
}

@Composable
fun Item(
    title: String = "",
    price: Double = 0.0,
    isBestSeller: Boolean = false,
    city: String = "",
    tags: Array<String?>,
    stock: Int = 0,
    discount: Int = 0,
    sumOfColor: Int = 0,
    isSmallCard: Boolean = false,
    image: Painter,
    buttonFunctionality: () -> Unit?
) {
    Box {
        val cardWidth: Int = if (isSmallCard) 200 else 300
        Card(
            Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFCFD2CF),
                    shape = RoundedCornerShape(10.dp)
                )
                .width(cardWidth.dp)
                .padding(all = 3.dp),
//        border = BorderStroke(1.dp, Color.LightGray),
            elevation = 1.dp,

            ) {
            Column(Modifier.padding(all = 5.dp)
            ) {
                Box {
                    // product image
                    Image(
                        painter = image, contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentScale = ContentScale.Fit
                    )
                    if (sumOfColor > 1)
                    Row(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .shadow(15.dp, CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            modifier = Modifier.width(25.dp),
                            contentDescription = null // decorative element
                        )
                        Text(
                            text = sumOfColor.toString(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        )
                    }
                }
                // product info
                Column(
                    Modifier.padding(vertical = 5.dp)
                ) {
                    // product tags
                    if (tags.isNotEmpty()) {
                        Row (
                            Modifier.padding(end = 5.dp)
                        ) {
                            for (anyTags in tags) {
                                if (anyTags != null) {
                                    Text(
                                        text = anyTags,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(Color(0xFFCFD2CF), CircleShape)
                                            .padding(horizontal = 7.dp)
                                    )
                                }
                            }
                        }
                    }
                    // product title OR name
                    Text(
                        text = title,
                        fontWeight = FontWeight.Normal,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    // product price
                    Text(
                        text = "Rp. " + DecimalFormat("#,###").format(price),
                        fontWeight = FontWeight.W600,
                        color = Color(0xFFEF5B0C)
                    )
                    // city
                    Text(
                        text = city,
                        fontWeight = FontWeight.Light
                    )
                    // discount
                    if (discount > 0) {
                        Row {
                            val priceAfterDiscount = price - ((price / 100) * discount)
                            Text(
                                modifier = Modifier.padding(end = 5.dp),
                                text = "Rp. " + DecimalFormat("#,###").format(priceAfterDiscount),
                                fontWeight = FontWeight.Light,
                                textDecoration = TextDecoration.LineThrough,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "$discount%",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFFEB1D36),
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xFFDDBEBE), CircleShape)
                                    .padding(horizontal = 5.dp)
                            )
                        }
                    }
                    var buttonColor = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0096FF))
                    var buttonText = "Add to bag"
                    var buttonTextColor = Color(0xFFFFFFFF)
                    if (stock < 1) {
                        buttonColor = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFCFD2CF))
                        buttonText = "Out of stock"
                        buttonTextColor = Color(0xFF7F8487)
                    }
                    // Button
                    Button(
                        onClick = { buttonFunctionality },
                        colors = buttonColor,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = buttonText,
                            color = buttonTextColor
                        )
                    }
                }
            }
        }
        if (isBestSeller)
        Column {
            Text(text = "Divider", color = Color.Transparent)
            Text(
                text = "Paling Top",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .background(
                        Color(0xFFEF5B0C),
                        shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
                    )
                    .padding(horizontal = 10.dp)
            )
        }
    }
}