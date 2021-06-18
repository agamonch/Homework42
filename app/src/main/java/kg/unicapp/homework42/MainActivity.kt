package kg.unicapp.homework42

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val NotificationID = 101
    private val CHANNEL_ID = "channel_id_example_01"



    private lateinit var myAdaptor: MyAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationsChannel()

        setup()

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{

            sendNotifications()
        }


    }




    private fun createNotificationsChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notifications title"
            val descriptionText = "Notifications description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance). apply {
                description = descriptionText
            }
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }

    private fun sendNotifications() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_flight_takeoff_24)
            .setContentTitle("Уведомление")
            .setContentText("ПОРА ВЗЛЕТАТЬ")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(NotificationID, builder.build())
        }



    }
    private fun setup() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        myAdaptor = MyAdaptor()
        recyclerView.adapter = myAdaptor
        myAdaptor.setItems(Data.getLongListOfItems())



    }
}