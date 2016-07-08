/*
 * Copyright 2016 Pavel Stepanov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package igel.app;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class MainActivity extends AppCompatActivity {

    EditText cash;
    EditText bank;
    EditText cashless;
    ImageView imgView1;
    ImageView imgView2;
    ImageView imgView3;
    TextView moneyAmountView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        cash = (EditText) findViewById(R.id.cash);
        bank = (EditText) findViewById(R.id.bank);
        cashless = (EditText) findViewById(R.id.cashless);
        moneyAmountView = (TextView) findViewById(R.id.textView2);
//        moneyAmountView.setText(cash.getText());

        TextWatcher inputData = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double x, y, z;
                String str1 = cash.getText().toString();
                String str2 = bank.getText().toString();
                String str3 = cashless.getText().toString();
                if(!str1.equals("")) x = Double.parseDouble(str1);
                else x = 0;
                if(!str2.equals("")) y = Double.parseDouble(str2);
                else y = 0;
                if(!str3.equals("")) z = Double.parseDouble(str3);
                else z = 0;
                z += x + y;
                String S = Double.toString(z);
                moneyAmountView.setText(S);
            }
        };

        ((EditText) findViewById(R.id.cash)).addTextChangedListener(inputData);
        ((EditText) findViewById(R.id.bank)).addTextChangedListener(inputData);
        ((EditText) findViewById(R.id.cashless)).addTextChangedListener(inputData);


      /* cashless.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event )
            {
                if(event.getAction() > 0)
                {
                    double x, y;
                    String str1 = cashless.getText().toString();
                    String str2 = moneyAmountView.getText().toString();
                    x = Double.parseDouble(str1);
                    y = Double.parseDouble(str2);
                    x += y;
                    String S = Double.toString(x);
                    moneyAmountView.setText(S);
                }
                return false;
            }
        });*/


        findViewById(R.id.imgView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ничего не происходит", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.imgView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("XXX", "Bla bla bla. I'm a message from a code. Bla bla bla.");
            }
        });


    }

}

