package com.polinakulyk.cashregister.db.entity;

import com.polinakulyk.cashregister.db.dto.ReceiptStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

import static com.polinakulyk.cashregister.util.CashRegisterUtil.MONEY_SCALE;
import static com.polinakulyk.cashregister.util.CashRegisterUtil.PRECISION;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull(message = "Created time cannot be null")
    private LocalDateTime createdTime;

    private LocalDateTime checkoutTime;

    @NotNull(message = "Receipt status cannot be null")
    private ReceiptStatus status;

    @Column(precision = PRECISION, scale = MONEY_SCALE)
    @NotNull(message = "Sum total cannot be null")
    @DecimalMin(value = "0.00", message = "Sum total must be positive")
    @DecimalMax(value = "99999.99", message = "Sum total must be less than 100k")
    private BigDecimal sumTotal;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    @NotNull(message = "Receipt items cannot be null")
    private Set<ReceiptItem> receiptItems = new HashSet<>();

    @ManyToOne
    @NotNull(message = "User cannot be null")
    private User user;

    public String getId() {
        return id;
    }

    public Receipt setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Receipt setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public Receipt setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
        return this;
    }

    public ReceiptStatus getStatus() {
        return status;
    }

    public Receipt setStatus(ReceiptStatus status) {
        this.status = status;
        return this;
    }

    public BigDecimal getSumTotal() {
        return sumTotal;
    }

    public Receipt setSumTotal(BigDecimal total) {
        this.sumTotal = total;
        return this;
    }

    public Set<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public Receipt setReceiptItems(Set<ReceiptItem> items) {
        this.receiptItems = items;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Receipt setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        return id.equals(receipt.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(
                ", ", Receipt.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdTime=" + createdTime)
                .add("checkoutTime=" + checkoutTime)
                .add("status='" + status + "'")
                .add("sumTotal=" + sumTotal)
                .add("receiptItems=" + receiptItems)
                .add("user.id=" + (user != null ? user.getId() : null))
                .toString();
    }
}
