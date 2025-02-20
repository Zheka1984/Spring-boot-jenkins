package org.example.Repositories;

import org.example.DAO.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RepoInterface<T> {

    public T getById(long id);

}
