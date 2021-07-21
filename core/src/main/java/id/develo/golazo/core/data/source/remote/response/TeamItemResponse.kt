package id.develo.golazo.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamItemResponse(

    // Team Detail
    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strLeague")
    val strLeague: String,

    @field:SerializedName("strTeam")
    val strTeam: String,

    @field:SerializedName("strTeamShort")
    val strTeamShort: String,

    @field:SerializedName("strDescriptionEN")
    val strDescription: String,

    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String,

    @field:SerializedName("strTeamJersey")
    val strTeamJersey: String,

    @field:SerializedName("strKeywords")
    val strKeywords: String,

    // Social Media
    @field:SerializedName("strInstagram")
    val strInstagram: String,

    @field:SerializedName("strTwitter")
    val strTwitter: String,

    @field:SerializedName("strWebsite")
    val strWebsite: String,

    @field:SerializedName("strYoutube")
    val strYoutube: String,

    @field:SerializedName("strFacebook")
    val strFacebook: String,

    )
