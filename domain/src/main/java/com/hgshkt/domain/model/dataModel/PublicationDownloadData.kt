package com.hgshkt.domain.model.dataModel

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
