package com.example.app.service.repositories;
import com.example.app.model.Lend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LendRepository extends JpaRepository<Lend,Long>{

    List<Lend> findLendsByBook_Title(String title);

    List<Lend> findLendsByUser_UserName(String userName);
}
