package com.srmstudios.fidelity.ui.model

data class Season(
    val id: Int? = null,
    var url: String? = null,
    var imageUrl: String? = null,
    var title: String? = null,
    var airing: Boolean? = null,
    var synopsis: String? = null,
    var type: String? = null,
    var episodes: Int? = null,
    var score: Double? = null,
    var startDate: String? = null,
    var endDate: String? = null,
    var members: Int? = null,
    var rated: String? = null
)