package com.andromeda.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = listOf<UserModel>(
            UserModel(R.drawable.user_male, "Andromeda", "My Friend"),
            UserModel(R.drawable.user_male, "Budi", "My Friend"),
            UserModel(R.drawable.user_male, "Joko", "My Friend"),
            UserModel(R.drawable.user_female, "Siti", "My Friend"),
            UserModel(R.drawable.user_female, "Ani", "My Friend"),
            UserModel(R.drawable.user_male, "Tono", "My Friend"),
            UserModel(R.drawable.user_male, "Steven", "My Friend"),
            UserModel(R.drawable.user_male, "Dodit", "My Friend"),
            UserModel(R.drawable.user_female, "Sinta", "My Friend"),
            UserModel(R.drawable.user_female, "Santi", "My Friend"),
        )

        val userAdapter = UserAdapter(users, object: UserAdapter.OnAdapterListener{
            override fun onClick(user: UserModel) {
                Toast.makeText(this@MainActivity, user.name, Toast.LENGTH_SHORT).show()
            }
        })

        findViewById<RecyclerView>(R.id.recycler_view).adapter = userAdapter

    }
}