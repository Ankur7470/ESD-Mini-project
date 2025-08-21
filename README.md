<h1 align="center"> Job Portal System </h1>
<p align="center"> Your Gateway to Streamlined Academic and Career Placements </p>

<p align="center">
  <img alt="Build" src="https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge">
  <img alt="Issues" src="https://img.shields.io/badge/Issues-0%20Open-blue?style=for-the-badge">
  <img alt="Contributions" src="https://img.shields.io/badge/Contributions-Welcome-orange?style=for-the-badge">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge">
</p>
<!--
  **Note:** These are static placeholder badges. Replace them with your project's actual badges.
  You can generate your own at https://shields.io
-->

## Table of Contents
- [⭐ Overview](#-overview)
- [✨ Key Features](#-key-features)
- [🛠️ Tech Stack & Architecture](#️-tech-stack--architecture)
- [🚀 Getting Started](#-getting-started)
- [🔧 Usage](#-usage)
- [🤝 Contributing](#-contributing)
- [📝 License](#-license)

## ⭐ Overview

The Job Portal System is a robust, full-stack application designed to streamline the academic and career placement process for students and educational institutions.

> Traditional academic placement processes are often fragmented and inefficient, leading to difficulties for students in discovering relevant opportunities and tracking their applications, while institutions struggle with manual data management and communication overhead.

This project offers a comprehensive, intuitive, and secure platform that centralizes job and placement opportunities. It empowers students with streamlined application processes, personalized eligibility checks, and real-time application status tracking. Concurrently, it provides institutions with powerful tools for managing placements, student data, and company interactions, significantly enhancing the efficiency and effectiveness of the entire recruitment lifecycle.

This project adopts a modern, decoupled client-server architecture. The backend is built with Spring Boot, serving a comprehensive suite of RESTful APIs, managing data persistence, business logic, and security through JWT-based authentication. The frontend is a dynamic Single-Page Application developed with React.js, consuming these APIs to deliver a rich, interactive user experience. Data is persistently stored in a relational database, managed via Hibernate/JPA.

## ✨ Key Features

*   **Secure User Authentication:** Leverages JWT (JSON Web Tokens) for robust and secure student and administrator login, ensuring authenticated access to system functionalities.
*   **Comprehensive Placement Listing & Filtering:** Students can browse, view details, and apply filters (e.g., by domain, specialization) to discover relevant job and placement opportunities.
*   **Streamlined Online Application:** Enables students to easily apply for placements directly through the portal, submitting necessary information.
*   **Real-time Application Status Tracking:** Provides students with the ability to monitor the progress and status of their submitted placement applications from application to final decision.
*   **Student Profile Management:** Allows students to view and manage their personal details, academic information, and eligibility criteria within the system.
*   **Categorization by Domain & Specialisation:** Efficiently organizes placements using defined domains and specializations, improving searchability and relevance for users.
*   **Integrated File Management:** Supports the upload and download of files, likely for resumes, academic documents, or offer letters, enhancing the application process.

## 🛠️ Tech Stack & Architecture

| Technology      | Purpose                            | Why it was Chosen                                                                      |
| :-------------- | :--------------------------------- | :------------------------------------------------------------------------------------- |
| **Backend**     |                                    |                                                                                        |
| Java            | Core Programming Language          | For its robustness, scalability, and widespread enterprise adoption.                    |
| Spring Boot     | Web Framework                      | Enables rapid application development, provides a powerful ecosystem, and strong community support. |
| Maven           | Build Automation Tool              | Standardized project structure, dependency management, and build lifecycle.            |
| Spring Security | Authentication & Authorization     | Provides comprehensive security features, including JWT support, out-of-the-box.       |
| Relational DB   | Data Storage (e.g., MySQL, PgSQL) | For structured data storage, transactional integrity, and complex querying capabilities. |
| **Frontend**    |                                    |                                                                                        |
| React.js        | UI Library                         | For building dynamic, component-based user interfaces and its strong ecosystem.         |
| Vite            | Build Tool                         | Offers extremely fast cold start times and hot module replacement for development.     |
| Tailwind CSS    | CSS Framework                      | Utility-first approach for rapid and consistent UI styling.                            |
| Ant Design      | UI Component Library               | Provides a rich set of high-quality, enterprise-level UI components out-of-the-box.   |
| Axios           | HTTP Client                        | A promise-based HTTP client for making API requests from the browser.                  |
| React Router DOM | Routing Library                    | For declarative routing in React applications, enabling seamless page navigation.      |

## 🚀 Getting Started

To get the Job Portal System up and running on your local machine, follow these steps.

### Prerequisites

Ensure you have the following software installed:

*   **Java Development Kit (JDK) 17+**: Required for the Spring Boot backend.
*   **Maven**: Necessary for building the Java backend.
*   **Node.js v18+**: Required for the React frontend.
*   **npm** (Node Package Manager) or **Yarn**: For managing frontend dependencies.
*   **A Relational Database**: Such as MySQL, PostgreSQL, or H2 (for development).

### Installation

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Ankur7470-ESD-Mini-project-19f4b21/Job-Portal-System.git
    cd Ankur7470-ESD-Mini-project-19f4b21
    ```

2.  **Backend Setup:**
    *   Navigate into the `backend` directory:
        ```bash
        cd backend
        ```
    *   **Database Configuration:**
        Edit `src/main/resources/application.properties` to configure your database connection details (e.g., `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`).
    *   **Database Schema & Data:**
        Execute the SQL scripts located in `src/main/resources/` on your chosen database:
        1.  `create_academicErp.sql` (creates tables)
        2.  `insert_academicErp.sql` (populates initial data)
        3.  `alter_academicErp.sql` (if any schema alterations are needed after initial creation)
    *   **Build and Run the Backend:**
        ```bash
        ./mvnw spring-boot:run
        ```
        (On Windows, use `mvnw.cmd spring-boot:run`)
        The backend API will typically run on `http://localhost:8080`.

3.  **Frontend Setup:**
    *   Open a new terminal and navigate into the `frontend` directory:
        ```bash
        cd ../frontend
        ```
    *   **Install Dependencies:**
        ```bash
        npm install
        # OR
        yarn install
        ```
    *   **Run the Frontend Development Server:**
        ```bash
        npm run dev
        # OR
        yarn dev
        ```
        The frontend application will typically run on `http://localhost:5173`.

## 🔧 Usage

Once both the backend and frontend servers are running, you can access the Job Portal System:

1.  Open your web browser and navigate to the frontend URL (e.g., `http://localhost:5173`).
2.  You will be presented with the login page. Use credentials from your `insert_academicErp.sql` script (if provided) or create new users through an administrative interface if available.
3.  Explore the dashboard to view eligible placements, apply for opportunities, and track your application status.
4.  For API interactions, you can use tools like Postman or Insomnia to hit the backend endpoints, typically exposed at `http://localhost:8080/api/v1/...`.

## 🤝 Contributing

We welcome contributions to the Job Portal System! If you're interested in improving the project, please follow these steps:

1.  **Fork** the repository on GitHub.
2.  **Clone** your forked repository to your local machine.
3.  **Create a new branch** for your feature or bug fix:
    ```bash
    git checkout -b feature/your-feature-name
    ```
4.  **Make your changes**, ensuring they adhere to the project's coding standards.
5.  **Commit your changes** with clear, descriptive commit messages.
6.  **Push your branch** to your forked repository.
7.  **Open a Pull Request** against the `main` branch of the original repository, describing your changes in detail.

## 📝 License

Distributed under the MIT License. See `LICENSE` for more information.
