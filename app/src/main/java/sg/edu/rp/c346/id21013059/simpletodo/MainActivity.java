package sg.edu.rp.c346.id21013059.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd;
    Button btnClear;
    ListView lvToDo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTask = findViewById(R.id.editNewToDo);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.listViewToDo);


        ArrayList<String> alTodo;
        ArrayAdapter<String> aaTodo;

        alTodo = new ArrayList<>();
        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);

        lvToDo.setAdapter(aaTodo);

        btnAdd.setOnClickListener((view -> {
            String newToDo = etTask.getText().toString();
            alTodo.add(newToDo);
            aaTodo.notifyDataSetChanged();

        }));

        btnClear.setOnClickListener((view -> {
            alTodo.clear();
            aaTodo.notifyDataSetChanged();

        }));
    }
}