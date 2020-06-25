package net.najiboulhouch.leavesmanagers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import net.najiboulhouch.leavesmanagers.entities.BaseEntity;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see JpaRepository
 *
 * @param <T>
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
		
}
