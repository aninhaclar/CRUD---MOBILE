package com.anapires.clientesapp.Service

import com.anapires.clientesapp.Model.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClienteService {
    
    @POST("clientes")
    fun cadastrarCliente(@Body cliente: Cliente): Call<Cliente>

}