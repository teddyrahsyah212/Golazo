package id.develo.golazo.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamModel(
    // Team Detail
    val idTeam: String,
    var strLeague: String,
    var strTeam: String,
    var strTeamShort: String?,
    var strDescription: String,
    var strTeamBadge: String,
    var strTeamJersey: String,
    var strKeywords: String,

    // Social Media
    var strInstagram: String,
    var strTwitter: String,
    var strWebsite: String,
    var strYoutube: String,
    var strFacebook: String,
    var isFavorite: Boolean = false
) : Parcelable