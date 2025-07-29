package com.anapires.clientesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anapires.clientesapp.Model.Cliente
import com.anapires.clientesapp.Service.Conexao
import com.anapires.clientesapp.ui.theme.ClientesAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val cliente = Cliente(
            id = null,
            nome = "Cadastro da Ana",
            email = "anapires17@gmail.com"
        )

        val conexao = Conexao().getClienteService()
        val requisicao = conexao.cadastrarCliente(cliente)

        requisicao.enqueue(object : Callback<Cliente> {
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                // sucesso
            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                // erro
            }
        })

        setContent {
            ClientesAppTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientesAppTheme {
        Greeting("Android")
    }
}
