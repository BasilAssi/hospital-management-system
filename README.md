# hospital-management-system
The Hospital Management System is a comprehensive software solution designed to streamline and simplify the operations of a medical facility. This system is built around four core entities: Patients, Doctors, Appointments, and Medical Records.

Patients are individuals seeking medical attention or care. Each patient has a unique ID, name, address, phone number, and email address. Their medical history, consisting of past diagnoses, surgeries, allergies, etc., is also tracked in the system.

Doctors are medical professionals who provide care to the patients. Each doctor has a unique ID, name, their area of specialization, and working hours. They also have a list of patients under their care.

Appointments represent scheduled meetings between a doctor and a patient. Each appointment has a unique ID, a date, and a time. The appointment is linked to the specific patient and doctor involved.

Medical Records are comprehensive documents of a patient's health history and past treatments. Each record has a unique ID and includes details of the patient's diagnosis and the treatment provided or recommended. These records are created by doctors and are linked to both the patient and the doctor involved.

The relationships between these entities are crucial to the functioning of the system. A patient can have multiple appointments with different doctors, and a doctor can have appointments with multiple patients. Each appointment is associated with a unique medical record. If a patient is deleted from the system, logically, their appointments and medical records should be deleted as well. However, a doctor can exist independently of the appointments or medical records they are associated with.


![hospital-management system](https://github.com/BasilAssi/hospital-management-system/assets/104434508/c5650260-8de8-446d-a857-adf69435ad18)


![Appointment](https://github.com/BasilAssi/hospital-management-system/assets/104434508/9837b2ad-be7a-4321-a508-8252c32d5c3d)
![Doctor](https://github.com/BasilAssi/hospital-management-system/assets/104434508/1c684182-f7bd-4a0f-8b26-e18fa54869ca)
![medicalRecord](https://github.com/BasilAssi/hospital-management-system/assets/104434508/57782bf2-9edb-4061-bdc0-80af1e8af9a3)
![Patient](https://github.com/BasilAssi/hospital-management-system/assets/104434508/29ee260d-ef87-4dba-ab0b-8b5c43618711)
