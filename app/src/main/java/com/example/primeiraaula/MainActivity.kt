package com.example.primeiraaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome:String = "Os números gerados para a Mega Sena são:"
        textViewNome.text = nome

        // mostrar os numeros escolhidos
        gerarNumerosDezenas()

        // quando clicar, gera um novo conjunto de numeros
        gerarNumeros.setOnClickListener{
            gerarNumerosDezenas()
        }

        // gerar a propaganda
        MobileAds.initialize(this){}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    // funcao para gerar os numeros
    private fun gerarNumerosDezenas() {

        // lista dos numeros escolhidos
        var numeroSorteados:MutableList<Int> = mutableListOf<Int>()

        // sortear seis numeros
        while (numeroSorteados.size < 6){

            // criar o numero randomico
            var dezena:Int = (1..60).random()

            // se ele estiver ja na lista, nao adiciona
            if (numeroSorteados.contains(dezena)){
                // nao faca nada
            }
            else{
                // senao, adiciona mais um numero
                numeroSorteados.add(dezena)
            }
        }
        // organizar os numeros da lista em ordem ascendente
        numeroSorteados.sort()

        // colocar cada numero na sua bola
        primeiroNumero.text = numeroSorteados[0].toString()
        segundoNumero.text = numeroSorteados[1].toString()
        terceiroNumero.text = numeroSorteados[2].toString()
        quartoNumero.text = numeroSorteados[3].toString()
        quintoNumero.text = numeroSorteados[4].toString()
        sextoNumero.text = numeroSorteados[5].toString()
    }
}