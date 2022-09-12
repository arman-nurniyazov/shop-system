package kr.nurniyazov.shopsystem.controller;

import kr.nurniyazov.shopsystem.model.Transaction;
import kr.nurniyazov.shopsystem.service.transaction.TransactionService;
import kr.nurniyazov.shopsystem.util.Util;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/inputs")
    public String getInputs(@RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer size,
                            Model model) {
        Page<Transaction> inputs = transactionService.getInputs(page, size);
        Util.generateModel(model, "inputs", inputs, page, size);
        return "inputs";
    }

    @GetMapping(value = "/outputs")
    public String getOutputs(@RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer size,
                            Model model) {
        Page<Transaction> outputs = transactionService.getOutputs(page, size);
        Util.generateModel(model, "outputs", outputs, page, size);
        return "outputs";
    }

}
