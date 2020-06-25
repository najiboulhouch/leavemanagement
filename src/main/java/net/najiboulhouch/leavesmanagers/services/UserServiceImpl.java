package net.najiboulhouch.leavesmanagers.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.User;
import net.najiboulhouch.leavesmanagers.repositories.UserRepository;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see UserService
 */

@Named
@Qualifier("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Inject private UserRepository userRepository;
	@Inject	private PasswordEncoder passwordEncoder;
	@Inject	private GroupeService groupeService;
	@Inject private EmployeeService employeeService ;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserByName(String name) {
		return userRepository.findOne(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUser(User user, String currentPassword) throws ValidationException {
		if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.USER.PASSWROD.INCORRECT"));
		}
		userRepository.save(user);
		Employee employee = employeeService.findById(user.getEmployee().getId());
		if(employee != null)
			{	
				employee.setFirstName(user.getFirstName());
				employee.setLastName(user.getLastName());
				employeeService.save(employee);
			}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changePassword(User user, String currentPassword) throws ValidationException {
		User userDB = userRepository.findOne(user.getUserName());
		if (!passwordEncoder.matches(currentPassword, userDB.getPassword())) {
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.USER.PASSWROD.INCORRECT"));
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAccount(User user, String currentPassword) throws ValidationException {
		if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.USER.PASSWROD.INCORRECT"));
		}
		user.setEnabled(false);
		userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsersPendingRegistration() {
		return userRepository.findByEnabledFalse();
	}

	@Override
	public void approveRegistration(User user) throws ValidationException {
		Groupe groupe = groupeService.findById("NON SUPERVISOR");
		if (groupe != null) {
			user.setGroupe(groupe);
			user.setEnabled(true);
			userRepository.save(user);
		} else
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.GROUP.NON_SUPERVISOR.NOT_EXIST"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerUser(User user) throws ValidationException {
		if(userRepository.findByUserName(user.getUserName()) != null)
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.USER.USERNAME.EXIST"));
		else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setDateRegistred(new Date());
			user.setEnabled(false);
			Employee employee = new Employee(user.getTitle() , user.getFirstName() , user.getLastName() , user.getEmail() , user.getDateRegistred() );
			employeeService.save(employee);
			user.setEmployee(employee);
			userRepository.save(user);
		}
	}

}
