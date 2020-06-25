package net.najiboulhouch.leavesmanagers.repositories;

import org.springframework.data.repository.CrudRepository;

import net.najiboulhouch.leavesmanagers.entities.Authority;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 */

public interface AuthorityRepository extends CrudRepository<Authority, String> {

}
