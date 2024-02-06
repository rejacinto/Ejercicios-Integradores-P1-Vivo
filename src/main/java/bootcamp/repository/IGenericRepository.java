package bootcamp.repository;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository <T> {

    void save(T genericObject, Integer id);

    Optional<T> findById(Integer id);

    List<T> findAll();

}
