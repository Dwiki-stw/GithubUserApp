package com.example.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()

    }

    private fun showSelectedUser(user: User){
        val toDetailUser = Intent(this, DetailUserActivity::class.java)
        toDetailUser.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(toDetailUser)
    }

    private val listUser: ArrayList<User>
    get() {
        val nameUser        =    resources.getStringArray(R.array.name)
        val companyUser     =    resources.getStringArray(R.array.company)
        val locationUser    =    resources.getStringArray(R.array.location)
        val photoUser       =    resources.obtainTypedArray(R.array.avatar)
        val userName        =    resources.getStringArray(R.array.username)
        val repositoryUser  =    resources.getStringArray(R.array.repository)
        val followingUser   =    resources.getStringArray(R.array.following)
        val followersUser   =    resources.getStringArray(R.array.followers)

        val listUser = ArrayList<User>()

        for (i in nameUser.indices){
            val user = User(nameUser[i], companyUser[i], locationUser[i], photoUser.getResourceId(i, -1),
                userName[i], repositoryUser[i], followingUser[i], followersUser[i])
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList(){
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: UserAdapter.OnItemClickCallback{
            override fun onItemclicked(data: User) {
                showSelectedUser(data)
            }
        })
    }


}