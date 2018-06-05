package org.login.com.calculator5;

import android.widget.Switch;

public class Calculation implements ICalculation {


    @Override
    public int calculation(Values values) {
        switch (values.getActionName()) {
            case "Add":
                return values.getFirstValue() + values.getSecondValue();
            case "Sub":
                return values.getFirstValue() - values.getSecondValue();
            case "Mul":
                return values.getFirstValue() * values.getSecondValue();
            case "Div":
                return values.getFirstValue() / values.getSecondValue();
        }
        return 0;
    }

    @Override
    public int splite(Values values,String value) {

        switch (values.getActionName()) {
            case "Add":
                String[] strings = value.split(" \\+ ");

                return Integer.parseInt(strings[1]);
            case "Sub":
                String[] stringss = value.split(" - ");

                return Integer.parseInt(stringss[1]);
            case "Mul":
                String[] stringsss = value.split(" \\* ");

                return Integer.parseInt(stringsss[1]);
            case "Div":
                String[] stringssss = value.split(" / ");

                return Integer.parseInt(stringssss[1]);
        }
        return 0;
    }
}
