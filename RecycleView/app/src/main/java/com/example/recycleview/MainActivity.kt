package com.example.recycleview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Cryptos>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var price: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT < 166) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        imageId = arrayOf(
            R.drawable.binancecoin,R.drawable.bitcoin,R.drawable.bitcoincash,R.drawable.cardano,R.drawable.dogecoin,
            R.drawable.ethereum,R.drawable.litecoin,R.drawable.polkadot,R.drawable.ripple,R.drawable.tether
        )

        heading = arrayOf(
            "Binancecoin","Bitcoin","Bitcoincash","Cardano","Dogecoin","Ethereum","Litecoin","Polkadot","Ripple","Tether"
        )

        price = arrayOf(
            "R$ 2,214.24","R$ 242,741.84","R$ 3,602.86","R$ 11.06","R$ 1.71","R$ 16,773.71","R$ 952.77","R$ 131.08","R$ 10.23","R$ 5.26"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Cryptos>()
        getUserdata()

    }

    private fun getUserdata() {

        for(i in imageId.indices) {
            val cryptos = Cryptos(imageId[i], heading[i], price[i])
            newArrayList.add(cryptos)
        }

        var adapter = Adapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "Você clicou no item ${position + 1}",Toast.LENGTH_SHORT).show()
            }

        })
    }
}