package bootcamp.repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericRepositoryImp <T> implements IGenericRepository <T> {

    private final Map<Integer, T> mapOfObjects = new HashMap<>();
    private Integer id = -1;

    @Override
    public Integer save(T genericObject) {
        id++;
        mapOfObjects.put(id, genericObject);
        return id;
    }

    @Override
    public Optional<T> findById(Integer id) {
        return Optional.of(mapOfObjects.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(mapOfObjects.values());
    }

    @Override
    public void update(T genericObject, Integer id) {
        if (mapOfObjects.containsKey(id)) mapOfObjects.put(id, genericObject);
        else System.out.println("El elemento que se quiere modificar no se encuentra en el repositorio.");
    }

    @Override
    public T deleteById(Integer id) {
        if (mapOfObjects.containsKey(id)) return mapOfObjects.remove(id);
        System.out.println("El elemento que se quiere eliminar no se encuentra en el repositorio.");
        return null;
    }
}
