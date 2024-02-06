package bootcamp.repository;

import java.util.*;

public class GenericRepositoryImp <T> implements IGenericRepository <T> {

    private final Map<Integer, T> mapOfObjects = new HashMap<>();

    @Override
    public void save(T genericObject, Integer id) {
        mapOfObjects.put(id, genericObject);
    }

    @Override
    public Optional<T> findById(Integer id) {
        return Optional.of(mapOfObjects.get(id));
    }

    @Override
    public List<T> findAll() {
        return (List<T>) mapOfObjects.values();
    }
}
