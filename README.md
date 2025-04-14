# Job Portal System 

## Project Overview  
This project is a **Job Portal System** built using **React (Frontend)**, **Spring Boot (Backend)**, and **MySQL (Database)** is a part of my ESD Course. It allows students to log in, view job offers they are eligible for based on their domain, specialization, and academic performance, and apply for jobs by uploading their CV.   

## Features  
### Student Features  
- **Login/Registration**: Students can register and log in securely.  
- **View Eligible Offers**: The system checks the student's domain, specialization, and computed grade to display relevant job offers.  
- **Upload CV**: Students can upload their CV when applying for a job.  
- **Automatic Data Fetching**: Personal details, grades, and other academic records are automatically fetched and stored.
- 
### System Features  
- **Eligibility Check**: Automatically filters job offers based on student's academic records.  
- **Secure File Upload**: CVs are securely stored and linked to applications.  
- **Grade Calculation**: Computes the student's overall grade based on past courses.  

---

## Technologies Used  
### Frontend  
- **React.js** (with hooks, functional components)  
- **Axios** (for API calls)  
- **React Router** (for navigation)  
- **Tailwind CSS** (for styling)  

### Backend  
- **Spring Boot** (REST API)  
- **Spring Security** (Authentication & Authorization)  
- **Spring Data JPA** (Database operations)  
- **File Handling** (CV upload & storage)  

### Database  
- **MySQL** (Relational database for storing student, company, and job data)
  
---

## Setup & Installation  
### Prerequisites  
- Node.js (for React)  
- Java JDK 11+ (for Spring Boot)  
- MySQL Server  
- Maven (for Spring Boot dependencies)  

### Backend Setup (Spring Boot)  
1. **Clone the repository**  
   ```bash
   git clone <your-repo-link>
   cd backend

2. **Configure MySQL**
   Update application.properties in src/main/resources:
   ```code
   spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   
3. **Run the Spring Boot application**
   ```bash
   mvn spring-boot:run

### Frontend Setup (React)
1. Navigate to the frontend folder:
   ```bash
   cd frontend
   
2. Install dependencies:
   ```bash
   npm install
   
3. Run the React App:
   ```bash
   npm start
