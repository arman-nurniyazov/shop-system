package kr.nurniyazov.shopsystem.repository;

import kr.nurniyazov.shopsystem.enums.OperationType;
import kr.nurniyazov.shopsystem.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Page<Transaction> findAllByType(OperationType type, Pageable pageable);

}
