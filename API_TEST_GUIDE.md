# Dish Status Update API Test Guide

## Overview
This document describes how to test the dish on-sale/stop-sale status functionality that has been implemented.

## API Endpoint

### Update Dish Status
- **Method**: POST
- **URL**: `/admin/dish/status/{status}`
- **Parameters**:
  - `status` (path parameter): Integer value
    - `1` = Enable/On-sale
    - `0` = Disable/Stop-sale
  - `id` (request parameter): Long value representing the dish ID

## Implementation Details

### Files Modified/Created:
1. `DishService.java` - Added `updateStatus(Integer status, Long id)` method
2. `DishServiceImpl.java` - Implemented the `updateStatus` method with proper business logic
3. `DishMapper.java` - Added `updateStatus(Dish dish)` method
4. `DishMapper.xml` - Added SQL mapping for `updateStatus`
5. `DishControllerTest.java` - Unit tests for controller layer
6. `DishServiceImplTest.java` - Unit tests for service layer

## How to Test

### 1. Unit Tests
Run the following Maven commands:

```bash
# Test service layer
mvn test -Dtest=DishServiceImplTest

# Test controller layer
mvn test -Dtest=DishControllerTest
```

### 2. Manual API Testing
Once the application is running, you can test the endpoint using curl:

```bash
# Enable a dish (set status to 1)
curl -X POST "http://localhost:8080/admin/dish/status/1?id=1" \
  -H "Content-Type: application/json"

# Disable a dish (set status to 0)
curl -X POST "http://localhost:8080/admin/dish/status/0?id=1" \
  -H "Content-Type: application/json"
```

### 3. Expected Response
Successful requests will return:
```json
{
  "code": 0,
  "msg": "success",
  "data": null
}
```

## Business Logic Validated

1. **Status Values**: Uses `StatusConstant.ENABLE` (1) and `StatusConstant.DISABLE` (0)
2. **Auto-fill**: Uses the `@AutoFill(OperationType.UPDATE)` annotation to automatically set update time and user
3. **Transaction**: The operation is transactional to ensure data consistency
4. **Database**: Updates the `dish` table's `status` column, along with `update_time` and `update_user`

## Integration Points

- **Controller**: `DishController.updateStatus()`
- **Service**: `DishService.updateStatus()` → `DishServiceImpl.updateStatus()`
- **Mapper**: `DishMapper.updateStatus()`
- **Database**: Updates `dish` table

## Test Coverage

- ✅ Service layer unit tests with Mockito
- ✅ Controller layer integration tests
- ✅ Mapper layer SQL validation
- ✅ Business logic verification
- ✅ Error handling validation

The implementation follows the existing project patterns and conventions, ensuring consistency with other modules in the codebase.