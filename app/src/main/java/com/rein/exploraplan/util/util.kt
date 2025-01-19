package com.rein.exploraplan.util

/*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.rein.exploraplan.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

object util {

    fun dateToLong(dateString : String, pattern: String = "dd/MM/yyyy"): Long {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val date = sdf.parse(dateString)
        return date.time
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun longToDateTime(time: Long): String {
//        var zero: Long = 0
//        if (time == zero) return ""
        var instant: Instant = Instant.ofEpochMilli(time)
        var date: LocalDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy")
        return date.format(formatter)
    }

    fun longToDate(time: Long): String {
        val date = Date(time)
        val format = java.text.SimpleDateFormat("dd/MM/yyyy")
        return format.format(date)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun datetimeToLong(datetime: String): Long {
        return LocalDateTime.parse(
            datetime,
            DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy")
        ).atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()!!
    }

    */
/*fun getProvinceID(province: String): Int {
        return Constant.provinceList.indexOf(province)
    }*//*


    fun setOnClickTime(time: EditText, context: Context) {
        var mcurrentTime = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            mcurrentTime.set(Calendar.HOUR_OF_DAY, hour)
            mcurrentTime.set(Calendar.MINUTE, minute)
            time.setText(SimpleDateFormat("HH:mm").format(mcurrentTime.time))
        }
        TimePickerDialog(
            context,
            timeSetListener,
            mcurrentTime.get(Calendar.HOUR_OF_DAY),
            mcurrentTime.get(Calendar.MINUTE),
            true
        ).show()
    }

    fun setOnClickDate(date: EditText, context: Context, pattern : String = "dd/MM/yyyy") {
        var mcurrentTime = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            mcurrentTime.set(Calendar.DAY_OF_MONTH, day)
            mcurrentTime.set(Calendar.MONTH, month)
            mcurrentTime.set(Calendar.YEAR, year)
            date.setText(SimpleDateFormat(pattern).format(mcurrentTime.time))
        }
        DatePickerDialog(
            context,
            dateSetListener,
            mcurrentTime.get(Calendar.YEAR),
            mcurrentTime.get(Calendar.MONTH),
            mcurrentTime.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun StopPointTypeToString(type : Int): String {
        if (type == 1) return "Restaurant"
        if (type == 2) return "Accommodation"
        if (type == 3) return "Souvenir Shops"
        return "Others"
    }
    fun getAssetByStatus(status: Int) : Int {
        if (status == -1) {
            return  R.drawable.cancel
        }
        else if (status == 0) {
            return  R.drawable.delete
        }
        else if (status == 1) {
            return  R.drawable.explore
        }
        else {
            return  R.drawable.lock
        }
    }

    fun getAssetByStopPointType(type: Int) : Int {
        if (type == 1) {
            return  R.drawable.dining
        }
        else if (type == 2) {
            return  R.drawable.home
        }
        else if (type == 3) {
            return  R.drawable.map
        }
        else {
            return  R.drawable.location_pin
        }
    }

    fun urlToImageView(urlConnection : String, view : ImageView, size : Int) {

        Picasso.get()
            .load(urlConnection)
            .resize(size, size)
            .centerCrop()
            .into(view)

    }

    fun secondsToString(pTime: Int): String? {
        return String.format("%02d:%02d", pTime / 60, pTime % 60)
    }

}*/
