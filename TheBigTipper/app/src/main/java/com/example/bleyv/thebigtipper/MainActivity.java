package com.example.bleyv.thebigtipper;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText numbrAmt;
    private EditText percentAmt;
    private Button done;
    private double tip_result;
    private CoordinatorLayout snackBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbrAmt = (EditText) findViewById(R.id.total_amount);
        percentAmt = (EditText) findViewById(R.id.tip_percentage);
        done = (Button) findViewById(R.id.done);
        snackBarLayout = (CoordinatorLayout) findViewById(R.id.snackbarContainer);
        done.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                    if(numbrAmt.getText().toString().length() <= 0)
                    {
                        final Snackbar snackbar = Snackbar.make(snackBarLayout, "Please enter the amount of your bill: ", Snackbar.LENGTH_INDEFINITE);

                        TextView tv = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                        tv.setTextColor(Color.WHITE);

                        ViewGroup group = (ViewGroup) snackbar.getView();
                        group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                        snackbar.setActionTextColor(Color.WHITE);
                        snackbar.setAction("Reset", new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                snackbar.dismiss();
                                percentAmt.setText("");
                                numbrAmt.setText("");
                            }
                        });


                        snackbar.show();
                    }
                    else if(percentAmt.getText().toString().length()<=0)
                    {
                        final Snackbar snackbar = Snackbar.make(snackBarLayout, "Please enter tip percentage you would like to leave: ", Snackbar.LENGTH_INDEFINITE);

                        TextView tv = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                        tv.setTextColor(Color.WHITE);

                        ViewGroup group = (ViewGroup) snackbar.getView();
                        group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                        snackbar.setActionTextColor(Color.WHITE);
                        snackbar.setAction("Reset", new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                snackbar.dismiss();
                                percentAmt.setText("");
                                numbrAmt.setText("");
                            }
                        });


                        snackbar.show();
                    }
                    else{
                        double amt = Double.parseDouble(numbrAmt.getText().toString());
                        double tip_percent = Double.parseDouble(percentAmt.getText().toString());
                        tip_result = (amt+tip_percent)/10;
                        Log.d(TAG, "onClick() called with: " + "v = [" + tip_result + "]");

                        final Snackbar snackbar = Snackbar.make(snackBarLayout, "Tip is: $"+tip_result+". Thanks, fam. You got another one? ", Snackbar.LENGTH_INDEFINITE);

                        TextView tv = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                        tv.setTextColor(Color.WHITE);

                        ViewGroup group = (ViewGroup) snackbar.getView();
                        group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                        snackbar.setActionTextColor(Color.WHITE);
                        snackbar.setAction("Reset", new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                snackbar.dismiss();
                                percentAmt.setText("");
                                numbrAmt.setText("");
                            }
                        });


                        snackbar.show();
                    }

            }
        });

    }
}
