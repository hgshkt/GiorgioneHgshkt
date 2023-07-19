package com.hgshkt.domain.data_model

// data needed to load publication
data class PublicationDownloadData(
    /** uri of publication image */
    // Uri.toString()
    val uriString: String,
    /** publication description */
    val description: String,
    /** publication load time */
    val time: Long
)
