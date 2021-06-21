package ru.geekbrains.androidhomework2;

import android.os.Parcelable;

public class Calculator {

    int firstArg;
    int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private State state;
    private int actionSelected;

    private enum State{
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator() {
        this.state = State.firstArgInput;
    }

    public void onNumPressed (int buttonId){
        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length()<9){
            switch (buttonId){
                case R.id.K0:
                    if(inputStr.length() != 0){
                        inputStr.append("0");
                    }
                    break;
                case R.id.K1:
                    inputStr.append("1");
                    break;
                case    R.id.K2:
                    inputStr.append("2");
                    break;
                case R.id.K3:
                    inputStr.append("3");
                    break;
                case R.id.K4:
                    inputStr.append("4");
                    break;
                case R.id.K5:
                    inputStr.append("5");
                    break;
                case R.id.K6:
                    inputStr.append("6");
                    break;
                case R.id.K7:
                    inputStr.append("7");
                    break;
                case R.id.K8:
                    inputStr.append("8");
                    break;
                case R.id.K9:
                    inputStr.append("9");
                    break;
            }
        }

    }

    public void onActionPressed (int actionId){
        if (actionId == R.id.K_kalc && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.K_add:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.K_sub:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.K_mult:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.K_div:
                    inputStr.append(firstArg / secondArg);
                    break;
            }
        }
        else if(inputStr.length()>0 && state ==State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.K_add:
                    actionSelected = R.id.K_add;
                    break;
                case R.id.K_sub:
                    actionSelected = R.id.K_sub;
                    break;
                case R.id.K_mult:
                    actionSelected = R.id.K_mult;
                    break;
                case R.id.K_div:
                    actionSelected = R.id.K_div;
                    break;
            }
        }
    }
    public String getText(){
        return inputStr.toString();
    }

}
