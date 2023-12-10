package de.syntax_institut.ferienwohnungfinder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntax_institut.ferienwohnungfinder.databinding.ListItemAppartmentBinding

class AppartmentAdapter(private val items: List<AppartmentData>) :
    RecyclerView.Adapter<AppartmentAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ListItemAppartmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListItemAppartmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = items[position]
        val binding = holder.binding
        binding.txtTitle.text = data.title
        binding.txtAddress.text = data.address
        binding.txtSleepRooms.text = data.sleepRooms.toString()
        binding.txtSize.text = "${data.size} m²"
        binding.txtPersons.text = data.persons.toString()
        binding.txtPetsAllowed.text = if (data.petsAllowed) { "Ja" } else { "Nein" }
        binding.txtPricePerNight.text = "${data.pricePerNight} €"
        binding.imgAppartmentView.setImageResource(data.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}