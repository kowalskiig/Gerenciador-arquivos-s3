package com.projeto.s3.repository;

import com.projeto.s3.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    @Query(value = """
    SELECT f.id, f.file_name, f.file_url, f.upload_at 
    FROM tb_file AS f 
    ORDER BY upload_at DESC
    """, nativeQuery = true)
    List<File> findAllFile();

}
