package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getName(){
        EditText editText = (EditText)findViewById(R.id.examinee_name);
        String name = editText.getText().toString();
        return name;
    }

    private String getNumber(){
        EditText editText = (EditText)findViewById(R.id.examinee_num);
        String name = editText.getText().toString();
        return name;
    }

    public void showScore(View view){
        message = "Dear "+getName()+"("+getNumber()+"), your score is: "+processResult() + "/8";
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
        toast.show();
    }

    public int getAnswerOne() {
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_1);
        int checkedRadioButtonId = question1.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.Q1a);

       int temp  = 0;
        if (radioButton == correctRadioButton) {
            temp  = 1;
        }
        return temp ;
    }


    public int getAnswerTwo() {
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_2);
        int checkedRadioButtonId = question1.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.Q2b);

        int score = 0;
        if (radioButton == correctRadioButton) {
            score = 1;
            }
            return score;
    }

    public int getAnswerThree() {
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_3);
        int checkedRadioButtonId = question1.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.Q3c);

        int score = 0;
        if (radioButton == correctRadioButton) {
            score = 1;
        }
        return score;
    }

    public int getAnswerFour() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.Q4a);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.Q4b);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.Q4c);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.Q4d);

        int temp = 0;
        if (!(checkBox1.isChecked())&&checkBox2.isChecked()&&!(checkBox3.isChecked())&&(checkBox4.isChecked())==true){
            temp = 1;
        }
        return temp;
    }

    public int getAnswerFive() {
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_5);
        int checkedRadioButtonId = question1.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.Q5a);

        int temp = 0;
        if (radioButton == correctRadioButton) {
            temp = 1;
        }
        return temp;
    }

    public int getAnswerSix() {
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_6);
        int checkedRadioButtonId = question1.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.Q6b);

        int temp = 0;
        if (radioButton == correctRadioButton) {
            temp = 1;
        }
        return temp;
    }

    public int getAnswerSeven() {
        EditText editText = (EditText)findViewById(R.id.Q7);
        String  text = editText.getText().toString().trim();
        String answerSeven = "United Arab Emirates";
        int temp = 0;
        if (text.equalsIgnoreCase(answerSeven)){
            temp = 1;
        }
        return temp;
    }

    public int getAnswerEight(){
        EditText editText = (EditText)findViewById(R.id.Q8);
        String  text = editText.getText().toString().trim();
        String answerEigth = "Organization of Petroleum Exporting Countries";
        int temp = 0;
        if (text.equalsIgnoreCase(answerEigth)){
            temp = 1;
        }
        return temp;
    }

    public void sendResult(View view){
        String[] address = {"sanusikabir89@gmail.com"};
        String subject = "Quiz result";
        composeEmail(subject,message,address);
    }

    public int processResult(){
        int result =getAnswerOne() + getAnswerTwo() + getAnswerThree() + getAnswerFour() + getAnswerFive()
                + getAnswerSix() + getAnswerSeven() + getAnswerEight();
    return result;
    }

    public void composeEmail(String subject, String text, String[] addresses){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
