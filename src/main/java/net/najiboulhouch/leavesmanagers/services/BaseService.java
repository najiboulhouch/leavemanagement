package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.BaseEntity;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

/**
 * Interface for CRUD methods 
 * @author n.oulhouch
 * @version 1.0
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 
	 * @return List
	 */
	public List<T> findAll();
	
	/**
	 * 
	 * @param entity
	 * @return Entity
	 */
	public T findOne(T entity);
	
	/**
	 * 
	 * @param id
	 * @return Entity
	 */
	public T findById(Long id);
	
	/**
	 * 
	 * @param entity
	 * @throws ValidationException
	 */
	public void save(T entity) throws ValidationException;
	
	/**
	 * 
	 * @param entities
	 * @throws ValidationException
	 */
	public void save(List<T> entities) throws ValidationException;
	
	/**
	 * 
	 * @param entity
	 * @throws ValidationException 
	 */
	public void delete(T entity) throws ValidationException;
	
	/**
	 * 
	 * @param entities
	 */
	public void delete(List<T> entities) throws ValidationException;
	
}
