# cab-management

Rest calls to verify oprations

HttpMethod:Post
Uri:/authenticate
RequestBody:
{
    "username":"maheshm",
    "password":"password"
}

HttpMethod:Get
Uri:/getAllBookings/1
Authorization: Bearer 
Discription: To get all bookings related to customer id 1

HttpMethod:Get
Uri:/getNearByCabs
Authorization: Bearer 
Discription: To get near by cabs

HttpMethod:Get
Uri:/requestBooking
Authorization: Bearer 
RequestBody:
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
Discription: To get request cab from pickup point to drop point



