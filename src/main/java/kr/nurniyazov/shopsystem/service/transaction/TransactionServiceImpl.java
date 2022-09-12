package kr.nurniyazov.shopsystem.service.transaction;

import kr.nurniyazov.shopsystem.enums.OperationType;
import kr.nurniyazov.shopsystem.model.Transaction;
import kr.nurniyazov.shopsystem.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Page<Transaction> getInputs(int page, int size) {
        return transactionRepository.findAllByType(OperationType.INPUT, PageRequest.of(page - 1, size));
    }

    @Override
    public Page<Transaction> getOutputs(int page, int size) {
        return transactionRepository.findAllByType(OperationType.OUTPUT, PageRequest.of(page - 1, size));
    }
}
