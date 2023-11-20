
# Pico y Placa Predictor

A 'Pico y Placa' predictor that, given a vehicle license plate, date and time entered by the user, determines whether a vehicle can circulate on the road.

## Authors

- [@ferjozsot23](https://github.com/ferjozsot23/)


## What is "Pico y Placa"

"Pico y Placa" is a vehicle restriction measure implemented in cities. It is a transport demand management measure to ration the use of a scarce transport supply in the face of excessive demand.


## Rules
For this case we use the Quito, Ecuador restriction detailed below:

### Restriction based on day and last digit of licence plate

|**License plate last digit**|**Day**|
| ----------------- | ------------------------------------------------------------------ |
| 1 y 2 |  Monday |
| 3 y 4 | Tuesday |
| 5 y 6 | Wesnesday |
| 7 y 8 | Thursday |
| 9 y 0 | Friday |


### Restriction based on hour
|**Interval**| **Hour**|
| ----------------- | ------------------------------------------------------------------ |
| Interval 1 |  06:00 - 09:30 |
| Interval 2 | 16:00 - 20:00 |




## Installation
* Clone the repo https://github.com/ferjozsot23/PicoPlaca.git
* Open the project in your IDE according to your preference



## Usage

1. Run the Main class
1. Enter the license plate, date and hour separately.
- Enter the license in this format: PBU-1234.
- Enter the date in this format: mm/dd/yyyy.
- Enter the hour in this format (25 hours): HH:mm.

If the data entered is not in the correct format you will have to enter again

The app will show you a message indicating whether your vehicle is allowed or restricted to the road.
## Testing

The code includes unit tests situated in the "tests" directory.
Additionally, here are some test cases designed to validate the behavior.



|**License plate** | **Date**  | **Hour** | **Result** |
| ----------------- | ----------|----------------------|------------------------ |
| PBU-123 |  11-18-2002 | 19:00 | "Allowed to Road" |
| PBU-1231 | 11-20-2022 | 7:00 | "Restrict to Road" |
| !HOLA-123! | 10-10-1999 | 9:00 | Enter the data again |
| PBU-1233 | 01-01-2001 | "Sí" | Enter the data again |



## Built with

* **Programming language**: Java
* **Project Management Framework**: Maven
* **Unit Test**: JUnit



## Licence

 - Copyright (c) 2023 Fernando Soto. This project is MIT licensed.


## Hope you enjoy ❤️

