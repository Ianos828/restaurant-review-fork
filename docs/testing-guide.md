# MealMeter Testing Guide

---

This document supplements the [developer guide](developer-guide.md) and provides information on the testing process.

## How to run tests

---

1. Right-click the `test` folder and select `Run Tests in...`
2. Run `./gradlew clean test` in the Gradle console

## Testing Completed

---

### Unit Tests

Unit tests were completed for most of the classes in `Storage`, `Model` and `Logic` via Junit tests. 100% method
coverage was achieved, and close to 100% line coverage was achieved. This ensures that the backend functionality is as
expected.

### UI Tests

Manual testing was done to ensure that the UI behaves as expected.