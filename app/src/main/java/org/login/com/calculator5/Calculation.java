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
}
