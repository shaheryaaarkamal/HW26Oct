package com.example.hw_26_oct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button save;
    ArrayList<String> addArray=new ArrayList<>();
    EditText editText;
    ListView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.inputText);
        display=(ListView)findViewById(R.id.listView);
        save =(Button)findViewById(R.id.btnadd);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getinput = editText.getText().toString();

                if (addArray.contains(getinput)) {
                    Toast.makeText(getBaseContext(), "Item Already added", Toast.LENGTH_SHORT).show();
                } else if (getinput == null || getinput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input Field is empty.", Toast.LENGTH_SHORT).show();
                }

                else
                    {
                        addArray.add(getinput);

                        ArrayAdapter<String> adapetr= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,addArray);
                        display.setAdapter(adapetr);
                        ((EditText)findViewById(R.id.inputText)).setText("  ");

                }
            }
        });
    }
}