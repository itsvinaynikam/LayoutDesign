package com.example.layoutdesign.Fragment

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.layoutdesign.Adpter.User_itemAdapter
import com.example.layoutdesign.GetRequest.Appclient
import com.example.layoutdesign.GetRequest.getmainResponce
import com.example.layoutdesign.Interface.onclicklisner
import com.example.layoutdesign.RoomDataBase.RoomAppDatabase
import com.example.layoutdesign.RoomDataBase.RoomUserr
import com.example.layoutdesign.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!




    lateinit var db: RoomAppDatabase
    //private lateinit var viewModel: com.example.layoutdesign.ViewModel.MovieViewModel
    var uuseelist = mutableListOf<RoomUserr>()
     lateinit var madapter: User_itemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

     //Api thi adapter set thay

       /* viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(requireActivity(), Observer { movieList ->

            madapter= User_itemAdapter(requireContext(), movieList as MutableList<GetUser>)
            binding.recyclvieww.layoutManager= LinearLayoutManager(requireContext())
            binding.recyclvieww.adapter=madapter


            // movieAdapter.setMovieList(movieList)
        })*/

        madapter= User_itemAdapter(requireContext(),uuseelist )
        binding.recyclvieww.layoutManager= LinearLayoutManager(requireContext())
        binding.recyclvieww.adapter=madapter

        db = Room.databaseBuilder(requireContext().applicationContext, RoomAppDatabase::class.java, "databasename").allowMainThreadQueries().build()

        madapter.setonclick(object :onclicklisner{

            override fun deleteData(user: RoomUserr) {
                db.RoomuserDao().delete(user)
                upDateData()
                Toast.makeText(requireContext(), "Deleted Data", Toast.LENGTH_SHORT).show()

            }

            override fun upDateDataa(updateuser: RoomUserr)
            {
              /*  val ProfileFragment = ProfileFragment()
                val bundle = Bundle()
                bundle.putParcelable("updateuser", updateuser)
                ProfileFragment.arguments = bundle*/

               /* parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment)
                    .addToBackStack(null)
                    .commit()

*/







            }

        })

        getRequest()
        upDateData()

        return binding.root
    }

    private fun upDateData() {
        if (db!=null)
        { uuseelist= db.RoomuserDao().getAll() as MutableList<RoomUserr>
            madapter.SetItem(uuseelist)
        }

    }

    private fun getRequest() {
        var req = Appclient.initt().alllist()
        req.enqueue(object : Callback<getmainResponce> {
            override fun onResponse(
                call: Call<getmainResponce>,
                response: Response<getmainResponce>
            ) {

                if (response.isSuccessful) {
                    var res = response.body()

                    res.let {
                        it?.getUserlist?.forEach {
                            var roomData=RoomUserr(id = it.id, firstname = it.first_name, lastName = it.last_name, email = it.email, image = it.avatar)

                            try {
                                db.RoomuserDao().insertAll(roomData)
                            }
                            catch (e:Exception)
                            {
                            }


                        }
                        // madapter.SetItem(it!!.getUserlist)
                    }

                }

            }

            override fun onFailure(call: Call<getmainResponce>, t: Throwable) {

               // Toast.makeText(requireContext(), "Internet ishhue ", Toast.LENGTH_SHORT).show()

            }

        })

    }


}