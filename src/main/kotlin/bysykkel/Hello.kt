package bysykkel


import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson

fun main(args: Array<String>) {


    val (request, response, result) = "https://gbfs.urbansharing.com/oslobysykkel.no/gbfs.json"
        .httpGet()
        .responseString()

    when (result) {
        is Result.Failure -> {
            val ex = result.getException()
            println(ex)
        }
        is Result.Success -> {
            val data = result.get()
            println(data)
        }
    }

    val (jsonReq, jsonResp, jsonResult) = "https://gbfs.urbansharing.com/oslobysykkel.no/gbfs.json"
        .httpGet()
        .responseJson()

    when (jsonResult) {
        is Result.Success -> {
            println(jsonResult.value.content)
            handleResult(jsonResult.value)
        }
        is Result.Failure -> {
            val ex = jsonResult.getException()
            println(ex)
        }
    }


    // val mapper = ObjectMapper().registerKotlinModule()
    //   .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    data class HttpBinUserAgentModel(var userAgent: String = "")

}

fun handleResult(result: FuelJson) {

}

//fun responseJson(handler: (Request, Response, Result<FuelJson, FuelError>) -> Unit)

//val jsonObject = json.obj() //JSONObject
//val jsonArray = json.array() //JSONArray

