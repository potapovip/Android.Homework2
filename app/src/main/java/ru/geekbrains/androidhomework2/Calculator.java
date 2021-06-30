package ru.geekbrains.androidhomework2;

import java.io.Serializable;

public class Calculator implements Serializable {
    Double firstArg;
    Double secondArg;
    private StringBuilder inputStr = new StringBuilder();
    private State state;
    private int actionSelected;

    public enum State {
        FIRST_ARG_INPUT,
        SECOND_ARG_INPUT,
        RESULT_SHOW
    }

    public void setFirstArg(Double firstArg) {
        this.firstArg = firstArg;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Calculator() {
        this.state = State.FIRST_ARG_INPUT;
    }

    public void onNumPressed(int buttonId) {
        if (state == State.RESULT_SHOW) {
            state = State.FIRST_ARG_INPUT;
            inputStr.setLength(0);
        }
        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.K0:
                    if (inputStr.length() == 0 || inputStr.length() > 1) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.K1:
                    inputStr.append("1");
                    break;
                case R.id.K2:
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
                case R.id.K_comma:
                    if (inputStr.indexOf(".") == -1) {
                        inputStr.append(".");
                    }
                    break;
                case R.id.K_del:
                    inputStr.deleteCharAt(inputStr.length() - 1);
                    break;
                case R.id.K_AC:
                    inputStr.delete(0, inputStr.length());
                    break;
            }
        }
    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.K_kalc && state == State.SECOND_ARG_INPUT) {
            secondArg = Double.parseDouble(inputStr.toString());
            state = State.RESULT_SHOW;
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
        } else if (actionId == R.id.K_perc && state == State.SECOND_ARG_INPUT) {
            secondArg = Double.parseDouble(inputStr.toString());
            state = State.RESULT_SHOW;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.K_add:
                    inputStr.append(firstArg + (secondArg / 100 * firstArg));
                    break;
                case R.id.K_sub:
                    inputStr.append(firstArg - (secondArg / 100 * firstArg));
                    break;
                case R.id.K_mult:
                    inputStr.append(firstArg * (secondArg / 100));
                    break;
                case R.id.K_div:
                    inputStr.append(firstArg / (secondArg / 100));
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.FIRST_ARG_INPUT) {
            firstArg = Double.parseDouble(inputStr.toString());
            state = State.SECOND_ARG_INPUT;
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

    public String getText() {
        return inputStr.toString();
    }
}
