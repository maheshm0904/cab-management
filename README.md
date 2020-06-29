# Cab-management

# Rest calls to verify oprations

* Authentication </br>
 HttpMethod:Post </br>
 Uri:/authenticate </br>
 RequestBody:
 ```
{
    "username":"maheshm",
    "password":"password"
}
```

* Get All Bookings </br>
HttpMethod:Get </br>
Uri:/getAllBookings/1 </br>
Authorization: Bearer </br>
Description: To get all bookings related to customer id 1 </br>

* Get Near By Cabs </br>
HttpMethod:Get </br>
Uri:/getNearByCabs </br>
Authorization: Bearer </br>
Description: To get near by cabs </br>

* Request Booking </br>
HttpMethod:Get </br>
Uri:/requestBooking </br>
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



