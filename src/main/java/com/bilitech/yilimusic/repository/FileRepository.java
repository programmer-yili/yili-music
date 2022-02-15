package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
