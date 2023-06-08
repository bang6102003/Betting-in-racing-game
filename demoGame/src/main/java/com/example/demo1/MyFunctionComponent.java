package com.example.demo1;

import com.almasb.fxgl.entity.component.Component;

public class MyFunctionComponent extends Component {
    private final Runnable function;

    public MyFunctionComponent(Runnable function) {
        this.function = function;
    }

    @Override
    public void onAdded() {
        function.run();
    }
}
