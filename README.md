Enviro365 Waste Sorting API

Overview

The Enviro365 Waste Sorting API is a Spring Boot-based RESTful backend service for a mobile application that promotes sustainable waste management practices. It provides waste category lookup, disposal guidelines, and recycling tips.

Tech Stack
- Backend: Spring Boot, Spring Data JPA, H2 Database
- API Format: JSON
- Validation: Spring Boot Validation Annotations

Endpoints
HTTP Method      - Endpoint                      -    Description 
/*****************************************/
GET              -   /api/waste/categories        -   Get all waste categories 
POST             -   /api/waste/categories        -   Add a new waste category 
PUT              -   /api/waste/categories/{id}   -   Update an existing category 
DELETE           -   /api/waste/categories/{id}   -   Delete a category 
