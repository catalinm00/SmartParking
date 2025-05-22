package com.smartparking.smartparking.application;

public interface UseCaseCommand<R extends Response, C extends Command> {
    R execute(C cmd);
}
