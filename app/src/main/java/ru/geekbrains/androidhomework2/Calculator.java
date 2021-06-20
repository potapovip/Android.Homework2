package ru.geekbrains.androidhomework2;

public class Calculator {

    int firstArg;
    int secondArg;

    StringBuilder inputStr = new StringBuilder();

    private State state;

    private enum State{
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator() {
        this.state = State.firstArgInput; //this под вопросом.
    }

    public void onNumPressed (int buttonId){

    }

    public void onActionPressed (int actionId){

    }
    public String getText(){
        return inputStr.toString();
    }

}
