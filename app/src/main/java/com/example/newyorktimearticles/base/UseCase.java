package com.example.newyorktimearticles.base;

public interface UseCase<S, T> {
    T execute(S value);
}
