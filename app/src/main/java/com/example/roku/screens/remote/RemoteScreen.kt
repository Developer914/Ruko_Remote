package com.example.roku.screens.remote


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roku.R
import com.example.roku.ui.theme.BackgroundColor
import com.example.roku.ui.theme.SelectTabColor
import com.example.roku.ui.theme.UnSelectTabColor

@Composable
fun RemoteScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = BackgroundColor
            )
    ) {
        val selectedTab = remember { mutableIntStateOf(0) }
        PadSelectorBar(selectedTab)
        RemoteButtonsLayout()
        MainControlLayout(selectedTab.intValue)
        BackAndHomeButtonLayout()
        SocialMediaButtonLayout()
    }
}

@SuppressLint("AutoboxingStateValueProperty")
@Composable
fun PadSelectorBar(selectedTab: MutableIntState) {
    DialAndTouchTab(selectedTab.intValue) { selectedTabIndex ->
        selectedTab.intValue = selectedTabIndex
    }
}

@Composable
fun DialAndTouchTab(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabTitles = listOf("Dile Pad", "Touch Pad")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        tabTitles.forEachIndexed { index, title ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onTabSelected(index) }
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (selectedTab == index) SelectTabColor else UnSelectTabColor,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .padding(
                            bottom = 6.dp
                        )
                        .height(1.dp)
                        .fillMaxWidth(1f) // Optional: reduce underline width
                        .background(
                            if (selectedTab == index) SelectTabColor else Color.Transparent,
                        )
                )
            }
        }
    }
}

@Composable
fun RemoteButtonsLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 19.dp,
                start = 30.dp,
                end = 30.dp
            )
    ) {
        FirstRowOfButtonsLayout()
        Spacer(modifier = Modifier.height(10.dp))
        SecondRowOfButtonsLayout()
        Spacer(modifier = Modifier.height(10.dp))
        ThirdRowOfButtonsLayout()
        Spacer(modifier = Modifier.height(10.dp))
        FourthRowOfButtonsLayout()
    }
}

@Composable
fun FirstRowOfButtonsLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RemoteButton(R.drawable.ic_reload_button, "reload button")
        RemoteButton(R.drawable.ic_star_button, "star button")
        RemoteButton(R.drawable.ic_power_button, "power button")
    }
}

@Composable
fun SecondRowOfButtonsLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RemoteButton(R.drawable.ic_mute_button, "mute button")
        RemoteButton(R.drawable.ic_volume_low_button, "volume low button")
        RemoteButton(R.drawable.ic_volume_up_button, "volume up button")
    }
}

@Composable
fun ThirdRowOfButtonsLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RemoteButton(R.drawable.ic_backword_button, "background button")
        RemoteButton(R.drawable.ic_play_pause_button, "play pause button")
        RemoteButton(R.drawable.ic_fowrard_button, "forward button")
    }
}

@Composable
fun FourthRowOfButtonsLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RemoteButton(R.drawable.ic_hdmi_button, "hdmi button")

        RemoteButton(R.drawable.ic_keyboard_button, "keyboard button")
    }
}

@Composable
fun RemoteButton(remoteImage: Int, description: String) {
    Image(
        painter = painterResource(remoteImage),
        contentDescription = description
    )
}

@Composable
fun SocialMediaButton(socialMediaImage: Int, description: String) {
    Image(
        painter = painterResource(socialMediaImage),
        contentDescription = description
    )
}

@Composable
fun MainControlLayout(selectedTab: Int) {
    when(selectedTab){
        0 -> {
            DialPad()
        }

        1 -> {
            TouchPad()
        }
    }
}

@Composable
fun DialPad() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp
            ),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_main_button),
            contentDescription = "Dile Pad"
        )
    }
}

@Composable
fun TouchPad() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp
            ),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_touch_pad),
            contentDescription = "Touch Pad"
        )
    }
}

@Composable
fun BackAndHomeButtonLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp,
                start = 30.dp,
                end = 30.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RemoteButton(R.drawable.ic_back_space_button, "back space button")

        RemoteButton(R.drawable.ic_home_button, "home button")
    }
}

@Composable
fun SocialMediaButtonLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 18.dp,
                start = 30.dp,
                end = 30.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SocialMediaButton(R.drawable.ic_netflix, "Netflix")

        SocialMediaButton(R.drawable.ic_youtube, "YouTube")
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    RemoteScreen()
}