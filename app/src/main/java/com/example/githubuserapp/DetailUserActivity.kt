package com.example.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailUserActivity : AppCompatActivity(){

    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvName      : TextView  = findViewById(R.id.dtl_name)
        val tvUsername  : TextView  = findViewById(R.id.dtl_username)
        val tvCompany   : TextView  = findViewById(R.id.dtl_company)
        val tvLocation  : TextView  = findViewById(R.id.dtl_location)
        val tvFollowing : TextView  = findViewById(R.id.dtl_num_following)
        val tvFollowers : TextView  = findViewById(R.id.dtl_num_followers)
        val tvRepository: TextView  = findViewById(R.id.dtl_num_repository)
        val imgUser     : ImageView = findViewById(R.id.dtl_photo)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        tvName.text       = user.name
        tvUsername.text   = user.username
        tvCompany.text    = user.company
        tvLocation.text   = user.location
        tvFollowing.text  = user.following
        tvFollowers.text  = user.followers
        tvRepository.text = user.repository
        imgUser.setImageResource(user.photo)

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener{
            val messageShare = "Username GitHub: ${user.username}"
            val intentShare = Intent(Intent.ACTION_SEND)
            intentShare.type = "text/plain"
            intentShare.putExtra(Intent.EXTRA_TEXT, messageShare)
            startActivity(intentShare)
        }

    }
}