package id.develo.golazo.core.data.source

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : id.develo.golazo.core.data.source.Resource<T>(data)
    class Loading<T>(data: T? = null) : id.develo.golazo.core.data.source.Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : id.develo.golazo.core.data.source.Resource<T>(data, message)
}
