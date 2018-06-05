package org.login.com.calculator5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener */ {

    @BindView(R.id.edt_value)
    EditText mEdtValue;

    Values values = new Values();

/*    Button mBtnOne;
    Button mBtnTwo;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // mEdtValue = findViewById(R.id.edt_value);
     /*   mBtnOne = findViewById(R.id.btn_one);
        mBtnTwo = findViewById(R.id.btn_two);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
*/
    /*    mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdtValue.setText(mBtnOne.getText().toString());
            }
        });*/
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                mEdtValue.setText(mBtnOne.getText().toString());
                break;
            case R.id.btn_two:
                mEdtValue.setText(mBtnTwo.getText().toString());
                break;

        }

    }*/

    public void setValue(View view) {

        if(values.isResult)
        {
            values.setResult(false);
            mEdtValue.setText(""+String.valueOf(view.getTag()));
        }else
        {

            mEdtValue.setText(mEdtValue.getText().toString() + String.valueOf(view.getTag()));

        }

    }

    public void setPreviousValue(View view)
    {
        int currentValue = Integer.parseInt(mEdtValue.getText().toString());
        int previousValue = currentValue/10;

        if (previousValue>0)
        {
            mEdtValue.setText(String.valueOf(previousValue));
        }
        else
        {
            mEdtValue.setText("");
        }

    }

    public void setAction(View view) {
        switch (String.valueOf(view.getTag())) {

            case "Add":
                values.setActionName("Add");
                values.setFirstValue(Integer.parseInt(mEdtValue.getText().toString()));
                mEdtValue.setText(mEdtValue.getText().toString() + " + ");

                break;

            case "Sub":
                values.setActionName("Sub");

                values.setFirstValue(Integer.parseInt(mEdtValue.getText().toString()));
                mEdtValue.setText(mEdtValue.getText().toString() + " - ");

                break;

            case "Mul":
                values.setActionName("Mul");
                values.setFirstValue(Integer.parseInt(mEdtValue.getText().toString()));
                mEdtValue.setText(mEdtValue.getText().toString() + " * ");
                break;

            case "Div":
                values.setActionName("Div");
                values.setFirstValue(Integer.parseInt(mEdtValue.getText().toString()));
                mEdtValue.setText(mEdtValue.getText().toString() + " / ");

                break;

            case "Equal":
               try {
                   ICalculation iCalculation = new Calculation();


                   values.setSecondValue(iCalculation.splite(values,mEdtValue.getText().toString()));

                   mEdtValue.setText(String.valueOf(iCalculation.calculation(values)));
                   values.setResult(true);
               }catch (Exception ex)
               {
                   Toast.makeText(getApplicationContext(),"Select action first",Toast.LENGTH_LONG).show();
               }
                break;

        }
    }

 /*   @OnClick(R.id.btn_one)
    public void setVal()
    {
        Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_LONG).show();
    }*/
}
