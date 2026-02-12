# Database Schema Documentation

**Database:** postgres  
**Schema:** public  
**Generated:** February 11, 2026  
**Total Tables:** 7  
**Total Columns:** 42

---

## Table Overview

| Table Name | Columns | Rows | Purpose |
|------------|---------|------|---------|
| `user_table` | 9 | 2 | Core user accounts (employers & job seekers) |
| `employer` | 4 | 1 | Employer profile information |
| `job_seeker` | 4 | 1 | Job seeker profile information |
| `job` | 9 | 1 | Job postings |
| `application` | 5 | 0 | Job applications |
| `interview` | 6 | 0 | Interview records |
| `token` | 5 | 57 | JWT token management |

---

## Detailed Table Definitions

### 1. user_table
**Purpose:** Core user account table storing authentication and profile information

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| user_id | BIGINT | ❌ NO | Primary Key |
| first_name | VARCHAR | ✅ YES | User's first name |
| last_name | VARCHAR | ✅ YES | User's last name |
| email | VARCHAR | ✅ YES | User's email address |
| password | VARCHAR | ✅ YES | Hashed password |
| address | VARCHAR | ✅ YES | User's address |
| role | VARCHAR | ✅ YES | User role (employer/seeker) |
| created_at | TIMESTAMP | ✅ YES | Account creation timestamp |
| updated_at | TIMESTAMP | ✅ YES | Last update timestamp |

**Current Rows:** 2

---

### 2. employer
**Purpose:** Employer-specific profile information

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| user_id | BIGINT | ❌ NO | Primary Key, FK to user_table |
| company_name | VARCHAR | ✅ YES | Name of the company |
| industry | VARCHAR | ✅ YES | Industry sector |
| location | VARCHAR | ✅ YES | Company location |

**Current Rows:** 1

---

### 3. job_seeker
**Purpose:** Job seeker-specific profile information

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| user_id | BIGINT | ❌ NO | Primary Key, FK to user_table |
| skills | VARCHAR | ✅ YES | Comma-separated skills list |
| exp_years | INTEGER | ❌ NO | Years of experience |
| resume_url | VARCHAR | ✅ YES | URL to resume/CV |

**Current Rows:** 1

---

### 4. job
**Purpose:** Job postings created by employers

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| job_id | BIGINT | ❌ NO | Primary Key |
| employer_user_id | BIGINT | ✅ YES | FK to employer/user_table |
| title | VARCHAR | ✅ YES | Job title |
| description | VARCHAR | ✅ YES | Job description |
| job_type | VARCHAR | ✅ YES | Full-time, Part-time, Contract, etc. |
| requirements | VARCHAR | ✅ YES | Job requirements |
| salary_range | VARCHAR | ✅ YES | Salary range (e.g., "50k-70k") |
| status | VARCHAR | ✅ YES | Posted, Active, Closed, etc. |
| posted_date | DATE | ✅ YES | Job posting date |

**Current Rows:** 1

---

### 5. application
**Purpose:** Job applications submitted by job seekers

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| app_id | BIGINT | ❌ NO | Primary Key |
| seeker_id | BIGINT | ✅ YES | FK to job_seeker |
| job_id | BIGINT | ✅ YES | FK to job |
| status | VARCHAR | ✅ YES | Pending, Accepted, Rejected, etc. |
| applied_date | DATE | ✅ YES | Application submission date |

**Current Rows:** 0

---

### 6. interview
**Purpose:** Interview records and scheduling for applications

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| interview_id | BIGINT | ❌ NO | Primary Key |
| app_id | BIGINT | ✅ YES | FK to application |
| sched_date | DATE | ✅ YES | Scheduled interview date |
| mode | VARCHAR | ✅ YES | In-person, Video, Phone, etc. |
| result | VARCHAR | ✅ YES | Pass, Fail, Pending, etc. |
| feedback | VARCHAR | ✅ YES | Interview feedback/notes |

**Current Rows:** 0

---

### 7. token
**Purpose:** JWT token management for user authentication and session control

| Column | Type | Nullable | Notes |
|--------|------|----------|-------|
| id | BIGINT | ❌ NO | Primary Key |
| userid | BIGINT | ✅ YES | FK to user_table |
| jwttoken | VARCHAR | ✅ YES | JWT token string |
| is_revoked | BOOLEAN | ❌ NO | Token revocation status |
| is_expired | BOOLEAN | ❌ NO | Token expiration status |

**Current Rows:** 57 (Active tokens in system)

---

## Relationship Diagram

```
┌──────────────────────────────────────────────────────────────┐
│                      user_table                              │
│  (user_id, email, password, role, created_at, updated_at)    │
└──────────────────┬───────────────────────────────────────────┘
                   │
        ┌──────────┤
        │          │
        ▼          ▼
   ┌─────────┐  ┌──────────┐
   │employer │  │job_seeker│
   │         │  │          │
   └────┬────┘  └────┬─────┘
        │            │
        ▼            ▼
    (creates)    (submits)
        │            │
        ▼            │
   ┌──────────┐      │
   │   job    │      │
   │(job_id)  │      │
   └────┬─────┘      │
        │            │
        └───┬────────┘
            ▼
    ┌────────────────┐
    │  application   │
    │  (app_id)      │
    └───────┬────────┘
            │
            ▼
    ┌────────────────┐
    │   interview    │
    └────────────────┘

┌──────────────────┐
│     token        │ (tracks JWT tokens)
│   (userid)───────┼─→ user_table (for auth)
└──────────────────┘
```

---

## Data Statistics

- **Largest Table:** `token` with 57 rows
- **Active Users:** 2 in `user_table`
- **Empty Tables:** `application`, `interview`
- **Total Data:** Minimal test/development data

---

## File Locations

- **SQL Schema:** `DATABASE_SCHEMA.sql`
- **Markdown Documentation:** `DATABASE_SCHEMA.md`
- **Application Config:** `src/main/resources/application.properties`

---

## Notes

- All primary keys are BIGINT type
- Most columns are nullable except for primary keys and `exp_years` in job_seeker
- No explicit foreign key constraints visible in schema query, but relationships are implied by naming conventions
- Password is stored as VARCHAR (should be hashed in application)
- Token table contains historical JWT tokens with revocation/expiration status
