package com.bridgelabz.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,coffee,burger;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Getting instance of CheckBoxes and Button from the activty_main.xml file

        pizza=(CheckBox)findViewById(R.id.pizza);
        coffee=(CheckBox)findViewById(R.id.coffee);
        burger=(CheckBox)findViewById(R.id.burger);
        order= (Button) findViewById(R.id.order);
        //Applying the Listener on the Button click

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("selected items:");

                // Condition for the checked box
                 if(pizza.isChecked()){
                     result.append("\n Pizza 100Rs ");
                     totalamount+=100;
                 }
                if (coffee.isChecked()){
                    result.append("\n Coffee 50 RS");
                    totalamount+= 50;
                }
                if (burger.isChecked()){
                    result.append("\n Burger 70Rs");
                    totalamount+= 70;
                }
                result.append("\n total"+totalamount+"Rs");
                // makimg a pop message through toast for placed order and the total amount
                Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
