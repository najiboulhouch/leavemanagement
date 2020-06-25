package net.najiboulhouch.leavesmanagers.services;


import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.BaseEntity;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.repositories.BaseRepository;


/**
 * 
 * Implementation of CRUD method,it used with repository interface of Spring Data JPA
 * @author n.oulhouch
 * @version 1.0
 * @param <T>
 * @see BaseService
 */

@Transactional(rollbackFor=ValidationException.class)
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {


	@Inject private BaseRepository<T> reporitory ;
	
	
	@Override
	public List<T> findAll() {
		return reporitory.findAll();
	}

	@Override
	public T findOne(T entity) {
		return reporitory.findOne(entity.getId());
	}

	@Override
	public void save(T entity) throws ValidationException {
		reporitory.save(entity);
	}

	@Override
	public void delete(T entity) throws ValidationException  {
		reporitory.delete(entity.getId());
	}

	@Override
	public void save(List<T> entities) throws ValidationException  {
		for (T entity : entities) {
			this.save(entity);
		}
	}

	@Override
	public void delete(List<T> entities) throws ValidationException  {
		for (T entity : entities) {
			this.delete(entity);
		}	
	}
	
	@Override
	public T findById(Long id) {
		return reporitory.findOne(id);
	}

	
}
