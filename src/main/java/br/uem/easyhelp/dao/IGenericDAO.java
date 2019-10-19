package br.uem.easyhelp.dao;

import java.util.List;

/**
 * @author Douglas
 */
public interface IGenericDAO<T> {

    T insert(T t);

    boolean update(T t);

    boolean delete(T t);

    T findById(Long id);

    List<T> listAll();
}
