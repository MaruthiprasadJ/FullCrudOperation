package com.task3.repository;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.task3.DO.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Transactional
	@Modifying
	@Query("update Employee e set e.active= :status where e.id= :id")
	void updateStatusById(@Param("id") long id,@Param("status") String status);
	
	@Query("select e from Employee e where (e.name=?1) OR (e.designation=?1) OR (e.salary=?1) OR (e.active=?1)")
	Page<Employee> findByFilter(String filter,Pageable pageable);
	
//	@Query("select e AND ")
//	Page<Employee> fetchMappedDetailerByFilter(String filter,Pageable pageable);

}
