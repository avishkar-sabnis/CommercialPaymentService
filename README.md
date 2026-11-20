# CommercialPaymentService

Commercial Card Processing Platform
An educational, enterprise-style commercial card processing platform built incrementally using Java 21, Spring Boot 3, Maven, Oracle Database, Kafka, Redis, and other supporting technologies.

The project models commercial card capabilities such as company onboarding, employee and card management, spend controls, payment authorization, capture, clearing, settlement, and reconciliation. External payment-network, acquirer, issuer, and banking integrations are simulated.
Scope note: This is a learning project, not a replica of Mastercard's or any other payment network's proprietary architecture. Do not use real cardholder data, PANs, CVVs, or production credentials.

1. Architecture overview
The platform is designed as independently deployable services with clear business ownership.
Component	Responsibility
API Gateway	External entry point, routing and cross-cutting request controls
Organization Service	Companies, departments, employees and merchant profiles
Onboarding Orchestrator	Coordinates company onboarding across services
Card Management Service	Card issuance, activation, blocking, replacement and lifecycle
Account & Funding Service	Corporate credit accounts, prepaid balances, reservations and utilization
Spend Policy Service	Company, department, employee and card spending rules
Payment Service	Payment lifecycle, idempotency and payment orchestration
Authorization & Risk Service	Risk evaluation, authorization attempts and issuer interaction
Financial Ledger Service	Immutable double-entry financial journal
Clearing & Settlement Service	Clearing batches, fees and settlement obligations
Reconciliation & Finance Service	Reconciliation, statements, expenses and finance operations
Notification & Reporting Service	Notifications, webhooks and reporting projections


Infrastructure such as Kafka, Redis, Oracle, observability tools and the API Gateway is not automatically treated as a business microservice.
2. Technology stack
Area	Technology
Language	Java 21
Framework	Spring Boot 3
Build	Maven
Persistence	Spring Data JPA
Database	Oracle Database
Messaging	Apache Kafka
Cache	Redis
Resilience	Resilience4j
API documentation	OpenAPI / Swagger UI
Testing	JUnit 5, Mockito, Testcontainers
Containers	Docker
Orchestration	Kubernetes
Metrics and dashboards	Prometheus and Grafana
Tracing	OpenTelemetry


Versions and dependencies may be updated as the project evolves.
3. Repository structure
The repository uses a Maven multi-module layout. Each business service is intended to be independently buildable and deployable.
commercial-card-platform/
├── pom.xml
├── organization-service/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/example/commercialcards/organization/
│       │   │       ├── company/
│       │   │       └── common/
│       │   └── resources/
│       │       ├── application.yml
│       │       └── db/migration/
│       └── test/
└── README.md
Additional service modules will be added as implementation progresses.
4. Current implementation
Organization Service
The initial implementation includes:
- Create a company.
- Retrieve a company by ID.
- Activate a company.
- Company status management.
- Request validation.
- Centralized API exception handling.
- JPA persistence configuration.
- Oracle datasource configuration.
- Actuator health endpoint.
- OpenAPI / Swagger UI configuration.
Company statuses:
- PENDING
- ACTIVE
- SUSPENDED
- CLOSED
New companies are created in PENDING status. Activation is an explicit business operation.
Current API endpoints
Method	Endpoint	Description
POST	/api/v1/companies	Create a company
GET	/api/v1/companies/{companyId}	Retrieve a company
POST	/api/v1/companies/{companyId}/activate	Activate a company
GET	/actuator/health	Application health


5. Prerequisites
Install the following before running the service:
- JDK 21
- Maven 3.9 or later
- Oracle Database (the default local configuration uses Oracle Free with FREEPDB1)
Verify Java and Maven:
java -version
mvn -version
6. Database setup
Create a development Oracle schema, for example:
- Username: COMMERCIAL_CARDS
- Password: choose a local development password
Execute the SQL migration:
organization-service/src/main/resources/db/migration/V1__create_companies.sql
The application is configured with:
spring:
  jpa:
    hibernate:
      ddl-auto: validate
This means Hibernate validates the schema rather than silently creating or changing database tables. Database changes should be maintained as explicit, version-controlled migrations.

Configure the connection using environment variables:
Variable	Default
DB_URL	jdbc:oracle:thin:@//localhost:1521/FREEPDB1
DB_USERNAME	COMMERCIAL_CARDS
DB_PASSWORD	change-me
SERVER_PORT	8081


Example for PowerShell:
$env:DB_URL="jdbc:oracle:thin:@//localhost:1521/FREEPDB1"
$env:DB_USERNAME="COMMERCIAL_CARDS"
$env:DB_PASSWORD="your-local-password"
Do not commit real credentials to source control.
7. Build and run
Run from the repository root:
mvn clean verify
Start Organization Service:
mvn -pl organization-service spring-boot:run
The service listens on port 8081 by default.

Useful URLs:
- Health: http://localhost:8081/actuator/health
- Swagger UI: http://localhost:8081/swagger-ui.html
- OpenAPI document: http://localhost:8081/v3/api-docs
8. API examples
Create a company
Request:
POST /api/v1/companies
Content-Type: application/json
{
  "name": "ABC Technologies",
  "legalName": "ABC Technologies Private Limited",
  "registrationNumber": "ABC-REG-001"
}
A successful request returns HTTP 201 Created and a company representation containing its generated ID, status and creation timestamp.
Retrieve a company
GET /api/v1/companies/{companyId}
Replace {companyId} with the ID returned by the create operation.
Activate a company
POST /api/v1/companies/{companyId}/activate
A closed company cannot be activated.
9. Engineering principles
The implementation will follow these principles:
1. Bounded contexts: Each service owns a clearly defined business capability.
2. Data ownership: Services do not directly read or modify another service's database tables.
3. API and event contracts: Synchronous APIs are used when an immediate answer is required; events are used for asynchronous propagation.
4. Idempotency: Repeated requests must not create duplicate business or financial effects.
5. Resilience: Timeouts, bounded retries, circuit breakers and bulkheads are applied where appropriate.
6. Reliable event publishing: Transactional Outbox will be used when database changes must reliably produce Kafka events.
7. Financial integrity: Financial postings will use an auditable, balanced double-entry ledger.
8. Observability: Services will expose health, metrics, structured logs and distributed traces.
9. Security: Authentication, authorization, tenant isolation, encryption and secret management are required before production-like use.
10. Testing: Unit, integration, contract and failure-recovery tests will be added as the services evolve.
Patterns will be applied where they solve a real problem; they will not be added indiscriminately to every service.
10. Planned implementation roadmap
1. Complete Organization Service: companies, departments, employees and hierarchy.
2. Implement Account & Funding Service.
3. Implement Spend Policy Service.
4. Implement Card Management Service.
5. Implement Onboarding Orchestrator using a Saga-style workflow.
6. Implement Payment Service and its payment orchestrator.
7. Implement Authorization & Risk Service and simulated issuer integration.
8. Implement Financial Ledger Service.
9. Implement Clearing & Settlement Service.
10. Implement Reconciliation & Finance Service.
11. Implement Notification & Reporting Service.
12. Add Kafka integration, Transactional Outbox, schema management and DLQ handling.
13. Add security, resilience, observability and automated testing.
14. Containerize services and deploy locally with Docker, then progress to Kubernetes.
11. Important payment-system behavior
The platform must account for payment-specific failure scenarios:
- An authorization timeout does not necessarily mean the issuer declined the transaction.
- Do not blindly retry an authorization if its outcome is unknown.
- Use inquiry and recovery workflows to resolve uncertain outcomes.
- Reserve funding safely under concurrent requests.
- Prevent duplicate captures and refunds.
- Keep authorization, capture, clearing and settlement as distinct lifecycle stages.
- Do not treat a cache as the authoritative source of financial balances.
- Reconcile internal records against external clearing and settlement records.
12. Project status
Current stage: Foundation and Organization Service.

The initial codebase is a starter implementation, not a production-ready payment platform. Authentication, tenant isolation, audit history, Kafka event publication, automated tests and onboarding orchestration are planned implementation milestones.

Contributions to the learning project should preserve service boundaries, explicit database migrations, secure configuration and test coverage.
