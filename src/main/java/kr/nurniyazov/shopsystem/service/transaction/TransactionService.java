package kr.nurniyazov.shopsystem.service.transaction;

import kr.nurniyazov.shopsystem.model.Transaction;
import org.springframework.data.domain.Page;

public interface TransactionService {

    Page<Transaction> getInputs(int page, int size);

    Page<Transaction> getOutputs(int page, int size);
}
