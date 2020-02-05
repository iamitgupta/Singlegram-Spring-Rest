package com.sg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.beans.Media;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

}
