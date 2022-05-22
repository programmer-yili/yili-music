package com.bilitech.yilimusic.core.repository;

import com.bilitech.yilimusic.core.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
