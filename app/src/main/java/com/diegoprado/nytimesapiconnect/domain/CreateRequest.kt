package com.diegoprado.nytimesapiconnect.domain

import com.diegoprado.nytimesapiconnect.data.RequestAPI
import com.diegoprado.nytimesapiconnect.data.request.RequestProvider

class CreateRequest {

    var myRequest: RequestProvider

    init {
        myRequest = RequestAPI().request()
    }
}