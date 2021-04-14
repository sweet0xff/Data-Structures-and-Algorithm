package com.github.sweet.monad;

public interface TrySupplier<T>{
    T get() throws Throwable;
}
