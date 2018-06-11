package est.dreal.service;

import java.util.List;
import java.util.UUID;

/**
 * Created by florian.iggiotti on 05/06/2018.
 */
public interface IService<E> {
    List<E> findAll();
    E findOne(final Long id);
    E saveAndFlush(final E e);
    void delete(final E e);
}
