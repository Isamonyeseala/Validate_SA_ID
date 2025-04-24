# Validate_SA_ID

# SA ID Validator

A Java project that validates **South African ID numbers** using **TDD (Test-Driven Development)**, **JUnit 5**, and **Gradle**.

## 🧪 What This Project Does

This app validates 13-digit South African ID numbers based on the official format:  
**YYMMDDSSSSCAZ**

- ✅ Validates correct **length** (13 digits)
- ✅ Checks for **numeric-only** values
- ✅ Verifies **birthdate** using `LocalDate`
- ✅ Checks **gender digits** (0000–9999)
- ✅ Ensures **citizenship digit** is either `0` (SA citizen) or `1` (permanent resident)
- ✅ Confirms the **checksum digit (Z)** using the **Luhn algorithm**

---

## 📦 Technologies Used

- Java 17+
- JUnit 5
- Gradle
- TDD (Test-Driven Development)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/validate_sa_id.git
cd validate_sa_id
