package dev.matyaqubov.footballplayersinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.footballplayersinfo.R
import dev.matyaqubov.footballplayersinfo.adapter.MainRecyclerViewAdapter
import dev.matyaqubov.footballplayersinfo.model.Player

class MainActivity : AppCompatActivity() {
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var players:ArrayList<Player>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        players= ArrayList()

        addItems()
        initViews()
    }

    private fun addItems() {
        for (i in 0..4){
            players.add(Player("Eldor Shomurodov",
                "Bunyodkor\n" +
                        "In 2015, he signed a contract with Bunyodkor.[citation needed] He played 19 matches and scored 7 goals in the league (as of 1 October 2015).[citation needed]\n" +
                        "\n" +
                        "Rostov\n" +
                        "On 15 July 2017, Bunyodkor announced that Shomurodov was moving to Russian Premier League club Rostov.[3]\n" +
                        "\n" +
                        "Genoa\n" +
                        "On 1 October 2020, he moved to Serie A club Genoa.[4] By doing so, he became the second Uzbek footballer to play in Italy, after Ilyos Zeytulayev.[citation needed]\n" +
                        "\n" +
                        "Roma\n" +
                        "On 2 August 2021, Roma announced the acquisition of Shomurodov on a five-year contract for €17.5 million plus bonuses.[5] He debuted 17 days later in José Mourinho's first game as manager, away to Trabzonspor in the first leg of the UEFA Europa Conference League playoffs. He started the game and scored the decisive goal of a 2–1 win.[6]",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Eldor_Shomurodov.jpg/330px-Eldor_Shomurodov.jpg",
                false,
                "https://en.wikipedia.org/wiki/Eldor_Shomurodov"))
        }
    }

    private fun initViews() {
        val mainRv=findViewById<RecyclerView>(R.id.rv_main)
        mainRecyclerViewAdapter= MainRecyclerViewAdapter(players)
        mainRv.apply {
            adapter=mainRecyclerViewAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }
}