package dev.matyaqubov.footballplayersinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.matyaqubov.footballplayersinfo.R
import dev.matyaqubov.footballplayersinfo.model.Player

class MainRecyclerViewAdapter(private  val players:ArrayList<Player>)
    : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player=players[position]
        holder.apply {
            playerName.text=player.name
            tvDesc.text=player.decription
            Picasso.get().load(player.image).placeholder(R.mipmap.ic_launcher_round).into(playerImage)


        }
        if (player.expand){
            holder.llExpndbel.visibility=View.VISIBLE
            holder.imgUpDown.setImageResource(R.drawable.ic_up)
        } else{
            holder.llExpndbel.visibility=View.GONE
            holder.imgUpDown.setImageResource(R.drawable.ic_down)
        }
    }

    override fun getItemCount()=players.size


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val playerImage=view.findViewById<ImageView>(R.id.img_player)
        val playerName=view.findViewById<TextView>(R.id.tv_name)
        val imgUpDown=view.findViewById<ImageView>(R.id.img_down_up)
        val tvDesc=view.findViewById<TextView>(R.id.tv_description)
        val readMoreButton=view.findViewById<Button>(R.id.btn_read_more)
        val llExpndbel=view.findViewById<LinearLayout>(R.id.ll_expandable)

        init {
            imgUpDown.setOnClickListener {
                val player=players[adapterPosition]
                player.expand=!player.expand
                notifyItemChanged(adapterPosition)
            }
        }


    }
}