package vcmsa.ci.musicplaylist

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var btnDisplay: Button //(W3Schools.1999-2025) used for arrays
    private lateinit var btnAverage:Button
    private lateinit var btnReturn:Button
    private lateinit var txtTotal:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        btnDisplay = findViewById(R.id.btnDisplay)
        btnAverage = findViewById(R.id.btnAverage)
        btnReturn = findViewById(R.id.btnReturn)
        txtTotal = findViewById(R.id.txtTotal)

        btnDisplay.setOnClickListener {
            val details = StringBuilder() //(Romman Sabbir.2023)
            for (song in MainActivity.playlist){
                details.append("Title:${song.title}\n")
                details.append("Artist:${song.artist}\n")
                details.append("Ratings:${song.rating}\n")
                details.append("Comment:${song.comments}\n\n")
            }
            txtTotal.text = details.toString()


        }

        btnAverage.setOnClickListener {   //(IEE moduale manual/lecture.2025)
            var totalRating = 0
            for (song in MainActivity.playlist){
                totalRating += song.rating
            }
            val avg = if (MainActivity.playlist.isNotEmpty())
                totalRating.toDouble()/
                MainActivity.playlist.size else 0.0
            txtTotal.text = "Aveage Rating: %2f".format(avg)

        }

        btnReturn.setOnClickListener {
            finish()
        }




















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}