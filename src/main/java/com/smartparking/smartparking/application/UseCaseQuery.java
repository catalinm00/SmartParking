package com.smartparking.smartparking.application;

public interface UseCaseQuery<R extends Response, Q extends Query> {
    R execute(Q query);
}
