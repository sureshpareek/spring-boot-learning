package com.example.demo.dto.entities



enum class AccessRightsObject(val value: String) {
    AllrightsOnEverything("all-rights-everything"),
    BillingManagers("billing-managers"),
    ProjectManagers("project-managers"),
    ProjectDevs("project-devs"),
    ProjectOutsider("project-outsider"),
    HrAllrights("hr-allrights"),
    HrHrManagement("hr-hrManagement"),
    ReportingManager("reporting-manager"),
    TimesheetSimpleMinded("timesheet-simple-minded"),
    Client("project-client");

    companion object {
        private val map = values().associateBy(AccessRightsObject::value)
        fun fromValue(value: String) = map[value]
    }
}


data class FrontPageItem(
    val name: String,
    val slag: String
)

data class BackendAPI(
    val singleAPI: List<String>,
    val regexAPI: List<String>
)

data class AccessRight(
    val name: AccessRightsObject,
    val frontPage: List<FrontPageItem>,
    val backendAPI: BackendAPI
)