package com.septiana.septiana_uas_bestpractice

import androidx.recyclerview.widget.RecyclerView
import com.septiana.septiana_uas_bestpractice.databinding.CardItemBinding

class CardViewHolder (
    private val cardItemBinding: CardItemBinding,
    private val clickListener: ProdukClickListener
    ) : RecyclerView.ViewHolder(cardItemBinding.root)
{
        fun bindProduk(produk: Produk){
            cardItemBinding.cover.setImageResource(produk.cover)
            cardItemBinding.title.text = produk.title

            cardItemBinding.cardView.setOnClickListener {
                clickListener.onClick(produk)
            }
        }
}