package com.aneury1.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
///import com.aneury1.todolist.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val todoViewModel: TodoViewModel by viewModels()


    @Inject
    lateinit var ThisString: String
    var idOfClicked : Int = 1

    @Inject
    lateinit var dataSession :DataSession


    @Inject
    @Named("retrofit")
    lateinit var retrofit : Retrofit2

///    lateinit var  activityMainBinding: ActivityMainBinding


    private fun setMainBind(): Unit{
  ///      activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
     //   setContentView(activityMainBinding.root)
    }

    suspend fun getTodos(): List<TodoModel>{
        return withContext(Dispatchers.IO){
            val retrofit = retrofit.getRetrofit2()
            val todo = retrofit.create(TodoEndpoint::class.java)

            val response : Response<List<TodoModel>> = todo.getAllTodo()
            if(response.isSuccessful)
                response.body()?: emptyList()
            else
                emptyList()
        }
    }

    suspend fun getAnyJoke(): Joke{
        return withContext(Dispatchers.IO){
            val retrofit = retrofit.getRetrofit2()
            val response: Response<Joke> = retrofit.create(TodoEndpoint::class.java).getOneJoke()
            val value:Joke = response.body()!!
            value
        }
    }


//java.lang.IllegalArgumentException: Unable to create call adapter for retrofit2.Response<java.util.List<com.aneury1.todolist.TodoModel>>
//        for method TodoEndpoint.getAllTodo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.newTextField).text = retrofit.getUrl()



         todoViewModel.todoList.observe(this, {
             if(!it.isNullOrEmpty())
                Toast.makeText(this,"Count of ${it.size}", Toast.LENGTH_LONG).show()
         });

        findViewById<Button>(R.id.add).setOnClickListener{

           ///todo check with CoroutineScope()
           CoroutineScope(Dispatchers.IO).launch {
               val todos = getAnyJoke()///getTodos()
               if(todos!=null){
                 Log.d("JOKE", "is not null ${todos.joke}")
               /// Toast.makeText(this, "Is not null??", Toast.LENGTH_SHORT).show()
               }
               else
                   Log.d("JOKE", "is null as always")


               /// todoViewModel.todoList.postValue(todos)
           }

            /*GlobalScope.launch(Dispatchers.Main){
               val todos = getTodos()
                todoViewModel.todoList.postValue(todos)
            }*/
        }

   /*
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
*/
    }
}

