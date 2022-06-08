package br.com.zup.minha__musica_favorita.informacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityInformacaoBinding
import br.com.zup.minha__musica_favorita.informacao.fragments.adapter.InformacoesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class InformacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformacaoBinding
    private val listaMusica = listOf("Informações","Fotos" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        exibirViewPagerTabLayout()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(getString(R.string.detalhe_banda))
    }

    private fun exibirViewPagerTabLayout(){
        val informacoesPagerAdapter = InformacoesPagerAdapter(supportFragmentManager, lifecycle, listaMusica)
        binding.viewInformacoes.adapter = informacoesPagerAdapter

        TabLayoutMediator(binding.TabInformacoes, binding.viewInformacoes){tab, posicao ->
            tab.text = listaMusica[posicao]
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}