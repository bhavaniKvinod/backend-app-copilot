-- ========================================
-- DATABASE SCHEMA DOCUMENTATION
-- PostgreSQL Database: postgres
-- Schema: public
-- Generated: February 11, 2026
-- ========================================

-- ========================================
-- TABLE 1: user_table
-- Description: Core user table storing user account information
-- Rows: 2
-- ========================================
CREATE TABLE IF NOT EXISTS user_table (
    user_id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR,
    last_name VARCHAR,
    email VARCHAR,
    password VARCHAR,
    address VARCHAR,
    role VARCHAR,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- ========================================
-- TABLE 2: employer
-- Description: Employer profile information linked to users
-- Rows: 1
-- ========================================
CREATE TABLE IF NOT EXISTS employer (
    user_id BIGINT PRIMARY KEY NOT NULL,
    company_name VARCHAR,
    industry VARCHAR,
    location VARCHAR
);

-- ========================================
-- TABLE 3: job_seeker
-- Description: Job seeker profile information linked to users
-- Rows: 1
-- ========================================
CREATE TABLE IF NOT EXISTS job_seeker (
    user_id BIGINT PRIMARY KEY NOT NULL,
    skills VARCHAR,
    exp_years INTEGER NOT NULL,
    resume_url VARCHAR
);

-- ========================================
-- TABLE 4: job
-- Description: Job postings created by employers
-- Rows: 1
-- ========================================
CREATE TABLE IF NOT EXISTS job (
    job_id BIGINT PRIMARY KEY NOT NULL,
    employer_user_id BIGINT,
    title VARCHAR,
    description VARCHAR,
    job_type VARCHAR,
    requirements VARCHAR,
    salary_range VARCHAR,
    status VARCHAR,
    posted_date DATE
);

-- ========================================
-- TABLE 5: application
-- Description: Job applications submitted by job seekers
-- Rows: 0
-- ========================================
CREATE TABLE IF NOT EXISTS application (
    app_id BIGINT PRIMARY KEY NOT NULL,
    seeker_id BIGINT,
    job_id BIGINT,
    status VARCHAR,
    applied_date DATE
);

-- ========================================
-- TABLE 6: interview
-- Description: Interview records for job applications
-- Rows: 0
-- ========================================
CREATE TABLE IF NOT EXISTS interview (
    interview_id BIGINT PRIMARY KEY NOT NULL,
    app_id BIGINT,
    sched_date DATE,
    mode VARCHAR,
    result VARCHAR,
    feedback VARCHAR
);

-- ========================================
-- TABLE 7: token
-- Description: JWT token management for authentication
-- Rows: 57
-- ========================================
CREATE TABLE IF NOT EXISTS token (
    id BIGINT PRIMARY KEY NOT NULL,
    userid BIGINT,
    jwttoken VARCHAR,
    is_revoked BOOLEAN NOT NULL,
    is_expired BOOLEAN NOT NULL
);

-- ========================================
-- SCHEMA SUMMARY
-- ========================================
-- Total Tables: 7
-- Total Columns: 42
-- 
-- Table Breakdown:
-- ┌─────────────────┬─────────┬──────────────────────────────────┐
-- │ Table Name      │ Columns │ Rows                             │
-- ├─────────────────┼─────────┼──────────────────────────────────┤
-- │ application     │    5    │ 0                                │
-- │ employer        │    4    │ 1                                │
-- │ interview       │    6    │ 0                                │
-- │ job             │    9    │ 1                                │
-- │ job_seeker      │    4    │ 1                                │
-- │ token           │    5    │ 57                               │
-- │ user_table      │    9    │ 2                                │
-- └─────────────────┴─────────┴──────────────────────────────────┘
--
-- Data Type Distribution:
-- - BIGINT: Primary keys and foreign key references
-- - VARCHAR: Text fields for names, descriptions, URLs, etc.
-- - DATE: Application and posting dates
-- - TIMESTAMP: Created and updated timestamps
-- - INTEGER: Experience years
-- - BOOLEAN: Token status flags
--
-- Key Relationships (Based on Column Names):
-- - user_table (user_id) → employer (user_id)
-- - user_table (user_id) → job_seeker (user_id)
-- - employer (user_id) → job (employer_user_id)
-- - job (job_id) → application (job_id)
-- - job_seeker (user_id) → application (seeker_id)
-- - application (app_id) → interview (app_id)
-- - user_table (user_id) → token (userid)
--
-- ========================================
