package com.polinakulyk.cashregister.util;

import com.polinakulyk.cashregister.db.entity.Product;
import com.polinakulyk.cashregister.db.entity.Receipt;
import com.polinakulyk.cashregister.db.entity.ReceiptItem;
import com.polinakulyk.cashregister.exception.CashRegisterException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class CashRegisterUtil {

    private CashRegisterUtil() {
        throw new CashRegisterException("Cannot instantiate");
    }

    public static String nonEmpty(String s) {
        return s != null && !s.isEmpty() ? s : null;
    }

    public static String quote(String message, Object value) {
        return "" + message + ": \"" + (value != null ? value.toString() : "null") + "\"";
    }

    public static String quote(String message, Object value1, Object value2) {
        return "" + message + ": \"" + (value1 != null ? value1.toString() : "null") + "\", \""
                + (value2 != null ? value2.toString() : "null") + "\"";
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(Clock.systemUTC());
    }

    public static Date from(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
    }

    public static LocalDateTime from(Date date) {
        return date.toInstant().atZone(ZoneId.of("Z")).toLocalDateTime();
    }

    public static Product strip(Product product) {
        return product.setItems(null);
    }

    public static Receipt strip(Receipt receipt) {
        for (ReceiptItem receiptItem : receipt.getItems()) {
            strip(receiptItem);
        }
        return receipt;
    }

    public static ReceiptItem strip(ReceiptItem receiptItem) {
        receiptItem.setReceipt(null);
        strip(receiptItem.getProduct());
        return receiptItem;
    }

}