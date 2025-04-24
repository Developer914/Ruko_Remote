package com.example.roku.resources


data class Descriptions(
    val heading: String,
    val details: String,
    val btnTxt: String
)

val descriptions = listOf (
    Descriptions(
        heading = "Welcome!",
        details = "Your phone will replace your remote and give you many new features.",
        btnTxt = "Let’s Start"
    ),
    Descriptions(
        heading = "Easily Control your Smart TV with phone",
        details = "Your phone will replace your remote and give you many new features.",
        btnTxt = "Next"
    ),
    Descriptions(
        heading = "Network Access",
        details = "Tap  “Allow” to access your Network to find your Smart TV and connect.",
        btnTxt = "Next"
    ),
    Descriptions(
        heading = "Connect same Wi-Fi",
        details = "Make sure your Devices are connected with same Wi-Fi",
        btnTxt = "Next"
    ),
    Descriptions(
        heading = "All setup completed!",
        details = "Press “Continue” to begin using your TV remote control.",
        btnTxt = "Continue"
    )
)