package vcmsa.ci.musicplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    data class Song(  //(Native Mobile Bites.2023)
        val title: String,
        val artist: String,
        val rating:Int,
        val comments:String

    )

    companion object{
        val playlist = ArrayList<Song>()

    }

    private lateinit var edtTitle:EditText
     private lateinit var edtArtist:EditText
     private lateinit var edtRatings:EditText
     private lateinit var edtComments:EditText






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtTitle = findViewById(R.id.edtTitle)
        edtArtist = findViewById(R.id.edtArtist)
        edtRatings = findViewById(R.id.edtRating)
        edtComments = findViewById(R.id.edtComments)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            addSong()
        }

        btnNext.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }

        btnExit.setOnClickListener {
            finishAffinity()

        }



















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun addSong(){
        val title = edtTitle.text.toString()
        val artist = edtArtist.text.toString()
        val rating = edtRatings.text.toString().toIntOrNull()
        val comments = edtComments.text.toString()

        if (title.isNotEmpty()&& artist.isNotEmpty()&& rating != null && rating in 1..5 && comments.isNotEmpty()){
            if (playlist.size<4){
                playlist.add(Song(title,artist,rating,comments))
                Toast.makeText(this,"Playlist full(Max 4 songs only)", Toast.LENGTH_SHORT).show()
                edtTitle.text.clear()
                edtArtist.text.clear()
                edtRatings.text.clear()
                edtComments.text.clear()
            }
        }else{
            Toast.makeText(this,"Please ensure all fields are filled correctly",Toast.LENGTH_SHORT).show()
        }
    }


}