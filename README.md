# LinkPay
> ⚠️ **Status: In Development**

A full-stack payment link generator that enables users to create shareable payment links — no checkout page required. Built to simulate real-world fintech infrastructure with a focus on reliability, security, and developer experience.

---

## Features & Scope

- **Payment Link Generation** — Create unique, shareable payment links with custom amounts and descriptions
- **Secure Payments** — Stripe-powered payment processing with webhook verification
- **User Dashboard** — Manage links, track payments, and view transaction history
- **Idempotency** — Prevents duplicate payments through unique request ID handling
- **Email Notifications** — Automated receipts and payment confirmations
- **Audit & Logging** — Append-only audit trail for all payment and link events
- **Deployment Ready** — Dockerized for local or cloud deployment, with logging and health checks
- **Tested & Documented** — Unit and integration tests included; Swagger UI for API documentation

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Build Tool | Maven |
| Database | PostgreSQL |
| Cache | Redis |
| Payments | Stripe API |
| Email | Resend / SendGrid |
| Frontend | Next.js |
| Frontend Hosting | Vercel |
| API Testing | Postman |

---

## Project Structure

```
LinkPay/
│
├── backend/                          # Spring Boot API
│    └── src/main/java/com/dinesh/linkpay/
│         ├── user/                   # User module
│         │    ├── controller/
│         │    ├── service/
│         │    ├── repository/
│         │    ├── dto/
│         │    └── model/
│         ├── link/                   # Payment link module
│         ├── payment/                # Payment processing module
│         ├── common/                 # Shared entities, DTOs, and utilities
│         │    └── exception/         # Custom exceptions
│         └── config/                 # App configuration
│
├── frontend/                         # Next.js frontend
│    ├── app/                         # App router pages
│    ├── components/                  # Reusable UI components
│    └── lib/                         # API clients and utilities
│
├── docker/                           # Docker configuration
└── README.md
```

---

## How It Works

```
1. User creates a payment link  →  POST /links
2. Link is shared with a payer  →  https://linkpay.io/pay/{linkId}
3. Payer visits the link        →  Next.js renders the payment page
4. Payer submits payment        →  Stripe processes the charge
5. Webhook confirms payment     →  POST /webhooks/stripe
6. Ledger entry recorded        →  Audit trail updated
7. Receipt emailed to payer     →  Email notification sent
```

---

## Roadmap

- [x] **Project scaffolding & architecture design**
- [ ] **User module**
  - [ ] User registration & authentication
  - [ ] JWT-based session management
  - [ ] User profile management
- [ ] **Link module**
  - [ ] Payment link generation
  - [ ] Link expiry & status management
  - [ ] Custom amount & description
  - [ ] One-time vs reusable links
- [ ] **Payment module**
  - [ ] Stripe payment processing
  - [ ] Webhook verification & handling
  - [ ] Idempotency key implementation
  - [ ] Payment status tracking
  - [ ] Refund support
- [ ] **Audit & Logging module**
  - [ ] Audit trail for all payment and link events
  - [ ] Immutable audit log (append-only)
  - [ ] Structured logging with correlation IDs
- [ ] **Infrastructure**
  - [ ] Redis caching layer
  - [ ] Docker deployment configuration
  - [ ] Logging & health checks
- [ ] **Frontend**
  - [ ] Dashboard — manage links & view payments
  - [ ] Public payment page — payer-facing checkout
  - [ ] Authentication flows (login, register)
  - [ ] Email receipt templates
- [ ] **Testing & Docs**
  - [ ] Unit tests
  - [ ] Integration tests
  - [ ] Swagger UI documentation
  - [ ] Load testing using JMeter

---

## Author

**Saidinesh Ponraj.**  
Computer Science (Co-op) · York University  
Aspiring Software Engineer — Banking & FinTech Systems  
📧 [dineshsai841@gmail.com](mailto:dineshsai841@gmail.com)
