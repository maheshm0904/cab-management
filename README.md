# Cab-management

## Technologies 
1.Spring boot </br>
2.Rest  </br>
3.Hibernate/JPA spatial </br>
4.Postgress PostGIS extention </br>
5.JWT Authentication </br>

## Dependancies
1.Postgress </br>
2.PostGIS extention </br>
3.Java 1.8 </br>

## Rest calls to verify oprations

* Authentication </br>
 HttpMethod:Post </br>
 Uri:/cab-management/authenticate </br>
 RequestBody:
 ```
{
    "username":"maheshm",
    "password":"password"
}
```

* Get All Bookings </br>
HttpMethod:Get </br>
Uri:/cab-management/bookings/{customerId} </br>
Authorization: Bearer </br>
Description: To get all bookings related to customer id 1 </br>

* Get Near By Cabs </br>
HttpMethod:Get </br>
Uri:/cab-management/cabs </br>
Authorization: Bearer </br>
Description: To get near by cabs </br>

* Request Booking </br>
HttpMethod:Get </br>
Uri:/cab-management/bookings </br>
Authorization: Bearer </br>
RequestBody: </br>
```
{
    "pickupFrom": {
            "type": "Point",
            "coordinates": [
               10.809003,54.097834
            ]
        },
        "dropTo": {
            "type": "Point",
            "coordinates": [
               10.809003,54.097834
            ]
        }
}
```
Description: To get request cab from pickup point to drop point



