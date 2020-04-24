package bysykkel

data class BysykkelRespons(var nb: NoooB) {

}

data class NoooB(var feeds: List<Feed>) {

}

data class Feed(var url: String, var name: String) {

}
