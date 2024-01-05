package com.jake.behavior.state;

public interface State<T> {

    void performAction(T context);
}
