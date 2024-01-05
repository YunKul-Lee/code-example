package com.jake.behavior.persistence.state;

public interface State<T> {

    void performAction(T context);
}
