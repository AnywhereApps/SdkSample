package com.anywhereapps.sdk.model

data class Establishment(
    val businesses: List<Business>,
    val region: Region,
    val total: Int
)