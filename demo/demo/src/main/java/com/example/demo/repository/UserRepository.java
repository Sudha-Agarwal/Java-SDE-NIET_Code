package com.example.demo.repository;

import com.example.demo.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    //Find by Name
    List<Users> findByName(String name);
    List<Users> findByEmail(String email);
    List<Users> findByNameAndEmail(String name, String email);
    List<Users> findByNameOrEmail(String name, String email);
    void deleteByEmail(String email);

    //JPQL
    @Query("SELECT u from Users u WHERE u.name = :name")
    List<Users> getByNameJPQL(@Param("name") String name);

    @Query("SELECT u FROM Users u WHERE u.name= :name AND u.email= :email")
    List<Users> findByNameAndEmailJPQL(@Param("name") String name,
                                       @Param("email") String email);

    //Native Query
    //Real database SQL
    @Query(value="SELECT * FROM db_users WHERE name= :name", nativeQuery = true)
    List<Users> findByNameNative(@Param("name") String name);



}
