package com.aneury1.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.aneury1.todolist.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var ThisString: String
    var idOfClicked : Int = 1

    @Inject
    lateinit var dataSession :DataSession

    lateinit var  activityMainBinding: ActivityMainBinding

    val todoViewModel: TodoViewModel by viewModels()

    private fun setMainBind(): Unit{
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMainBind()

        activityMainBinding.newTextField.text = "$ThisString $idOfClicked"


        activityMainBinding.add.setOnClickListener{
            idOfClicked+=1
            dataSession.setId("Session Value $idOfClicked")
            activityMainBinding.newTextField.text =   dataSession.getId()
            todoViewModel.liveData.postValue("HOLA")
        }

        todoViewModel.liveData.observe(this, {
           Toast.makeText(this, "change this $idOfClicked => $it", Toast.LENGTH_LONG).show()
        });



    }
}