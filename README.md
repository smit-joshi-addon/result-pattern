# Result Pattern Library

## Overview
The `result-pattern` library provides a generic `Result<T>` class to encapsulate success and failure scenarios in a structured way. This class is useful for standardizing API responses, handling errors, and improving code readability.

## Features
- **Encapsulates success & failure responses**
- **Supports various error types** (Unauthorized, Not Found, Already Exists, Validation Error, etc.)
- **Provides utility methods** for success and failure
- **Supports mapping data** from one type to another

## Installation
To use this library in your Maven project, add the following dependency:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/smit-joshi-addon/result-pattern</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.smit.result</groupId>
    <artifactId>result-pattern</artifactId>
    <version>1.0</version>
</dependency>
```

## Usage

### Creating a Success Result
```java
Result<String> result = Result.success("Operation Successful");
System.out.println(result.getData()); // Output: Operation Successful
```

### Creating a Failure Result
```java
Result<String> result = Result.failure("Something went wrong");
System.out.println(result.getMessage()); // Output: Something went wrong
```

### Using Predefined Error Types
```java
Result<String> notFoundResult = Result.entityNotFoundException("User not found");
System.out.println(notFoundResult.getMessage()); // Output: User not found
```

### Mapping Data
```java
Result<Integer> successResult = Result.success(100);
Result<String> mappedResult = successResult.map(Object::toString);
System.out.println(mappedResult.getData()); // Output: "100"
```

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing
Feel free to contribute by opening issues or submitting pull requests.

## Author
[smit-joshi](https://github.com/smit-joshi814)

