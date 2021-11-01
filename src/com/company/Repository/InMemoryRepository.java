package com.company.Repository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class InMemoryRepository<T> implements CrudRepo<T> {
    protected List<T> repoList;
    public InMemoryRepository(){
        this.repoList=new ArrayList<>();
    }
    @Override
    public abstract T findOne(@NotNull UUID id);

    @Override
    public Iterable<T> findAll() {
        return this.repoList;
    }

    @Override
    public T save(@NotNull T entity) {
        for(T x:this.repoList){ //loop through the repo to find an matching element
            if(x.equals(entity)){
                return x;
            }
        }
        this.repoList.add(entity);
        return null;
    }

    @Override
    public abstract T delete(@NotNull UUID id);

    @Override
    public abstract T update(@NotNull T entity);

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "repoList=" + repoList +
                '}';
    }


}
