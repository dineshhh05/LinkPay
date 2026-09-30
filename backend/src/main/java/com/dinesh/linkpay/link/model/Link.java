package com.dinesh.linkpay.link.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.dinesh.linkpay.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID linkToken;

    // Link (M) <---> (1) User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_owner", nullable = false)
    private User linkOwner;

    @Column(precision = 19, scale = 2, nullable = false)    
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private LinkStatus status;

    @Column(nullable=false)
    private Instant expiresAt;

    @Column(nullable=false, updatable=false)
    private Instant createdAt;

    @Column(nullable=false)
    private Instant updatedAt;


}
