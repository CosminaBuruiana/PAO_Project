## Medical Clinic

### Part I
The role of this project is to manage a medical clinic's data, specifically the data related to doctors, appointments, and medicines.

For instance, the program allow clinic administrators to add new doctors to the system, modify their experience levels, and delete doctors who are no longer working at the clinic. They also use the program to create appointments for patients and assign them to specific doctors. Additionally, the program help the clinic manage its inventory of medicines by sorting them by price and indicating their types.

Summarily, this program streamline the management of important medical data, making it easier to keep track of appointments, doctors, and medicines.

### **Class Hierarchy**
 #### Abstract Class 
 - Person (Concrete classes: Patient and Doctor)

  #### Concrete classes:

 - Patient
 -  Doctor
 -  Cardiologist
 -  Ophthalmologist
 -  ORLDoctor
 -  ToolCardiologist 
 - ToolORL 
 - ToolOphthalmologist
 -  MedicalClinic
 - Appointment
 -  Cure
 -  Medicine

#### Enum classes:

 - MedicineType

**Functionalities**

  
1. Add a doctor  
2. List of doctors  
3. Modify the doctor experience  
4. Delete doctor  
5. Sort the doctors by salary  
6. Sort the medicines by price  
7. Create an appointment
8. Remove an appointment for a doctor
9. Add an appointment for a doctor
10. Appointments list by a date
11. Appointments list by a doctor

### Part II
In the second phase of this project, I incorporated a connection to an Oracle Database using JDBC to guarantee the persistence of data. I successfully implemented Create, Read, Update, and Delete (CRUD) operations for all the entities present in the system. To achieve this, I introduced a Repository layer, which replaced the previous approach of using static maps in the Services. This architectural change improves data management and retrieval.

Additionally, I integrated a logging system to capture and record error messages. This allows for better monitoring and debugging of the system. Furthermore, I enhanced the system by implementing a feature to write the list of doctors to a CSV file. This enables the preservation and easy access to doctor-related information in a structured format.

Overall, these updates have significantly improved the system's functionality, data persistence, error handling, and data export capabilities.
