package com.example.demo

import com.example.demo.dto.entities.AccessRight
import com.example.demo.dto.entities.AccessRightsObject
import com.example.demo.dto.entities.BackendAPI
import com.example.demo.dto.entities.FrontPageItem

object AccessRightsData {
    val accessRights = listOf(
        AccessRight(
            name = AccessRightsObject.AllrightsOnEverything,
            frontPage = listOf(
                FrontPageItem(name = "Add Source", slag = "add-source")
            ),
            backendAPI = BackendAPI(
                singleAPI = listOf(),
                regexAPI = listOf()
            )
        ),
        AccessRight(
            name = AccessRightsObject.ProjectManagers,
            frontPage = listOf(),
            backendAPI = BackendAPI(
                singleAPI = listOf(),
                regexAPI = listOf()
            )
        ),
        AccessRight(
            name = AccessRightsObject.HrHrManagement,
            frontPage = listOf(),
            backendAPI = BackendAPI(
                singleAPI = listOf(),
                regexAPI = listOf()
            )
        ),
        AccessRight(
            name = AccessRightsObject.ProjectDevs,
            frontPage = listOf(),
            backendAPI = BackendAPI(
                singleAPI = listOf(),
                regexAPI = listOf()
            )
        ),
        AccessRight(
            name = AccessRightsObject.Client,
            frontPage = listOf(),
            backendAPI = BackendAPI(
                singleAPI = listOf(),
                regexAPI = listOf()
            )
        )
    )
}