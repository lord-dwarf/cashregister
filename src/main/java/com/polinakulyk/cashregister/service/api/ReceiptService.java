package com.polinakulyk.cashregister.service.api;

import com.polinakulyk.cashregister.controller.dto.UpdateReceiptItemDto;
import com.polinakulyk.cashregister.db.entity.Product;
import com.polinakulyk.cashregister.db.entity.Receipt;
import com.polinakulyk.cashregister.db.entity.ReceiptItem;
import java.util.List;
import java.util.Optional;

public interface ReceiptService {
    List<Receipt> findAll();
    Receipt createReceipt();
    Receipt complete(String receiptId);
    Receipt cancel(String receiptId);
    Receipt add(String receiptId, ReceiptItem receiptItem);
    Receipt cancel(String receiptId, String receiptItemId);
    Receipt update(
            String receiptId, String receiptItemId, UpdateReceiptItemDto updateReceiptItemDto);
}
