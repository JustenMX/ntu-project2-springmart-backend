## NTU Software Engineering Project 2

# Springmart: A Full-Stack E-Commerce Powerhouse (Server / Backend)

<img src="https://res.cloudinary.com/doniqecd2/image/upload/v1698082900/SPRINGMART/logo.svg" alt="Springmart Logo" width="120" height="120">

Springmart is an exceptional full-stack e-commerce platform, seamlessly combining the robustness of Spring Boot for backend operations with the dynamic React framework for frontend development. This powerful synergy provides a solid foundation for a wide array of functionalities.

## Key Dependencies

- **Spring Boot Starter**: Provides core Spring Boot functionality.
- **Spring Boot Test Starter**: Enables comprehensive testing of Spring Boot applications.
- **Spring Boot Web Starter**: A starter for building robust web applications using Spring MVC.
- **Spring Boot DevTools**: Enhances development experience with fast application restarts.
- **Lombok**: Simplifies Java code, eliminating boilerplate.
- **SpringDoc OpenAPI UI**: Automatically generates comprehensive API documentation.
- **Spring Boot Data JPA**: Simplifies the implementation of JPA-based data access layers.
- **PostgreSQL**: A powerful, open-source relational database system.
- **Spring Boot Starter Validation**: A starter for using Hibernate Validator for bean validation.
- **Stripe Java**: A Java library for seamless integration with the Stripe API.
- **Dotenv Java**: Enables the use of environment variables for configuration.
- **OpenCSV**: A Java library for reading and writing CSV files.
- **Spring Boot Starter Security**: Provides essential security features for a Spring Boot application.
- **OAuth2 Resource Server**: Enables OAuth2 resource server functionality.

## Integration

Springmart seamlessly integrates with PostgreSQL, providing a robust foundation for data storage. Additionally, it leverages Spring Security for user authentication, utilizing JWT tokens to ensure secure access.

## Security in Springmart

Security is a paramount concern for Springmart, particularly given its role as an e-commerce platform. Here's why:

- **User Data Protection**: E-commerce platforms handle sensitive user information, including personal details and payment credentials. Ensuring the security of this data is non-negotiable.

- **Prevention of Unauthorized Access**: Unauthorized access to certain parts of the application can lead to a range of issues, from privacy breaches to financial losses.

- **Mitigation of Attacks**: Security measures help defend against common attacks like SQL injection, cross-site scripting (XSS), and cross-site request forgery (CSRF).

### User Authentication in Springmart

Springmart implements a standard user authentication process:

1. **Registration**: New users sign up by providing their necessary details, including email and a secure password.

2. **Password Hashing**: The user's password is hashed before being stored in the database. This ensures that even if the database is compromised, passwords remain secure.

3. **Login**: Users enter their email and password to log in. The application verifies the credentials against the stored hashes.

4. **Token-Based Authorization**: Upon successful login, the server generates a JSON Web Token (JWT) and sends it to the client. This token is used for subsequent requests to authenticate the user.

5. **Token Expiration**: Tokens have a limited lifespan. Once expired, users need to re-authenticate by providing their credentials again.

6. **Secure Routes**: Certain routes in the application are designated for authenticated users only. Access to sensitive functionalities is restricted without a valid JWT token.

7. **Logout**: Users can log out, which invalidates their current token. This prevents any further access using the same token.

### Access Control

Springmart employs a role-based access control (RBAC) system:

- **User Role**: Standard users have access to view and manage their own account details, orders, adding products to wishlist and shopping cart.

- **Admin Role**: Administrators have additional privileges, such as managing products, categories, and user accounts.

## Seamless Integration of Product Data

In Springmart, we've implemented a seamless integration for managing product data, leveraging the power of OpenCSV and PostgreSQL. This approach ensures a dynamic and efficient process for handling product information.

            +------------------------+
            |                        |
            |  Cloud Storage         |
            |                        |
            +------------------------+
                      |
                      | CSV File
                      |
            +------------------------+
            |                        |
            |  Backend Server        |
            |                        |
            +------------------------+
                      |
                      | OpenCSV
                      |
            +------------------------+
            |                        |
            |  Process CSV Data      |
            |                        |
            +------------------------+
                      |
                      | PostgreSQL Database
                      |
            +------------------------+

### Cloud-Backed Data Management

Our platform utilizes a CSV file stored in cloud storage to serve as the definitive source of truth for product listings. This enables easy updates and modifications to the product data without the need for direct database interactions.

### Smart Retrieval Mechanism

Upon startup, Springmart intelligently fetches this CSV file from the cloud storage service. This means that any changes or additions to the product data are instantaneously reflected in the application, ensuring that the platform is always up-to-date.

### Image Management for Visual Appeal

To enhance the visual experience, we've devised a robust solution for managing product images. The CSV file not only contains product data but also references to the associated images. This allows for a seamless association of product images with their respective listings in the PostgreSQL database.

### Benefits at a Glance

- **Effortless Updates**: The CSV file serves as a dynamic repository, facilitating easy updates to product data and images without the need for intricate database operations.

- **Enhanced User Experience**: By efficiently linking product images with their corresponding listings, Springmart significantly enriches the visual appeal of your e-commerce platform.

- **Automated Synchronization**: The backend server's startup routine guarantees that any alterations to the CSV file are instantly reflected in the application, ensuring synchronization between your data source and the live platform.

## Elevating the E-Commerce Experience

Originally conceived as a robust backend project, we eagerly accepted the challenge of transforming it into a full-stack e-commerce platform in just two weeks. This feat, achieved amidst our professional commitments, attests to our unwavering determination and passion for crafting an intuitive and efficient platform. As we persist in our journey of learning and growth, anticipate further innovations that will revolutionize the e-commerce landscape. Stay tuned for the next wave of advancements or follow our github pages for new projects!
