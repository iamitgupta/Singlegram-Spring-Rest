package com.sg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.beans.Location;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
