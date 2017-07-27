package com.gdgupc.enzoftware.savingtime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ProgressBar incomePB , expensePB;
    TextView incomeTV , expenseTV;
    EditText aboutET , amountET;
    Switch modeSwitch;
    int incomeProgress = 60;
    int expenseProgress = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        incomePB = (ProgressBar) findViewById(R.id.progressBarIncome);
        expensePB = (ProgressBar) findViewById(R.id.progressBarExpense);
        incomeTV = (TextView) findViewById(R.id.incomeTextView);
        expenseTV = (TextView) findViewById(R.id.expenseTextView);
        aboutET = (EditText) findViewById(R.id.aboutEditText);
        amountET = (EditText) findViewById(R.id.amountEditText);
        modeSwitch = (Switch) findViewById(R.id.switchMode);

        incomePB.setProgress(incomeProgress);
        expensePB.setProgress(expenseProgress);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aboutET.getText().toString().equals("") || amountET.getText().toString().equals("")){
                    Snackbar.make(view, "You can't enter empty info", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    if(modeSwitch.isChecked()){
                        int amount = Integer.parseInt(amountET.getText().toString());
                        expenseProgress += amount;
                    }else{
                        int amount = Integer.parseInt(amountET.getText().toString());
                        incomeProgress += amount;
                    }
                }

                incomePB.setProgress(incomeProgress);
                expensePB.setProgress(expenseProgress);

                incomeTV.setText("Income     => "+String.valueOf(incomeProgress));
                expenseTV.setText("Expense     => "+String.valueOf(expenseProgress));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
