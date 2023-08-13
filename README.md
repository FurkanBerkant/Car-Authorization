# Car-Authorization
projeyi çalıştırmak için gerekli olan kütüphaneler
```
pip install -r requirements.txt
```
# Proje Hakkında
temel olarak araç kayıtlarını ve kullanıcı araç yetkilendirmelerini tutabileceğimiz bir mikroservis projesi.
API'larımızı test etmek için Postman kullanabilirsiniz.
# Kullanılan Teknolojiler
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Swagger
- JWT
- Lombok
- Mapstruct

# API
- Araç Ekleme
```
POST http://localhost:8080/api/v1/vehicles
{
    "label":"BMW M3",
    "brand": "BMW",
    "model": "M3",
    "company_id":1,
    "chassis_number": "123456789",
    "model_year": 2015,
    "plate_number": "34ABC123",
}
```
- Araç Listeleme
```
GET http://localhost:8080/api/v1/vehicles
```
- Araç Güncelleme
```
PUT http://localhost:8080/api/v1/vehicles/1
{
    "label":"BMW M3",
    "brand": "BMW",
    "model": "M3",
    "company_id":1,
    "chassis_number": "123456789",
    "model_year": 2015,
    "plate_number": "34ABC123",
}
```
- Araç Silme
```
DELETE http://localhost:8080/api/v1/vehicles/1
```
- Kullanıcı Ekleme
```
POST http://localhost:8080/api/v1/users
{ 
    "userId":1547, 
    "name":"Hüseyin", 
    "surname":"Ateş", 
    "companyId":5879, 
    "companyName":"Mülakat A.Ş.", 
    "role":"Admin"
} 
```
- Kullanıcı Listeleme
```
GET http://localhost:8080/api/v1/users
```
- Kullanıcı Güncelleme
```
PUT http://localhost:8080/api/v1/users/1
{ 
    "name":"Hüseyin", 
    "surname":"Ateş", 
    "companyId":5879, 
    "companyName":"Mülakat A.Ş.", 
    "role":"Admin"
} 
```
- Kullanıcı Silme
```
DELETE http://localhost:8080/api/v1/users/1
```

