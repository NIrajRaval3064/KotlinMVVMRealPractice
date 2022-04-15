package thematrixapps.com.realpracticeproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import thematrixapps.com.realpracticeproject.databinding.LayoutRvItemBinding
import thematrixapps.com.realpracticeproject.model.Data
import thematrixapps.com.realpracticeproject.model.EmployeeList


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var employees = mutableListOf<Data>()

    fun setMovieList(movies: List<Data>) {
        this.employees = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = thematrixapps.com.realpracticeproject.databinding.LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val employe = employees[position]
        holder.binding.movieTitle.text = employe.firstName
        Glide.with(holder.itemView.context).load(employe.avatar).placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.moviePoster)

    }

    override fun getItemCount(): Int {
        return employees.size
    }
}

class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {}